package SwagLabsTests;

import SwagLabsPages.CompletePage;
import SwagLabsPages.ConfirmationPage;
import SwagLabsPages.LoginPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.annotations.Test;
import util.ReporterUtil;
import util.ScreenShotUtil;

import java.util.List;

public class ProductCheckoutEndToEndTest extends BaseTest
{
    LoginPage loginpg = new LoginPage();

    //Checkout single item on page
    @Test
    public void SingleProductTest()
    {
        loginpg.navigateToLoginPage();
        // loginpg.getUserName().sendKeys("standard_user");
        // loginpg.getPassword().sendKeys("secret_sauce");

        CompletePage completepage = loginpg.login()
                .singleItemCheckout()
                .enterInfo();

        System.out.println(completepage.getHeaderMessage());
        completepage.goToHomePage();
    }

    //Checkout all items on products page
    @Test
    public void AllProductsTest()
    {
        loginpg.navigateToLoginPage();

        CompletePage completepage = loginpg.login()
                .allItemsCheckout()
                .enterInfo();

        System.out.println(completepage.getHeaderMessage());
        completepage.goToHomePage();
    }

    //To get a list of the products selected
    @Test
    public void ProductList()
    {
        loginpg.navigateToLoginPage();

        ConfirmationPage confirmationPage = loginpg.login()
                .allItemsCheckout()
                .enterInfo2();
        confirmationPage.getProductsFromTable();

        String sauce = ScreenShotUtil.takeScreenshot();
        ReporterUtil.getTest().info( MediaEntityBuilder.createScreenCaptureFromBase64String(sauce).build());

        List<String> actualprodfromtable = confirmationPage.getProductsFromTable();
        System.out.print("The products selected are :: " +actualprodfromtable);
    }

}
