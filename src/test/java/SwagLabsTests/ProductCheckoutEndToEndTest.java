package SwagLabsTests;

import SwagLabsPages.CheckoutInformationPage;
import SwagLabsPages.CompletePage;
import SwagLabsPages.LoginPage;
import org.testng.annotations.Test;

import java.util.List;

public class ProductCheckoutEndToEndTest  extends BaseTest
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

    //Checkout all items on page
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

}
