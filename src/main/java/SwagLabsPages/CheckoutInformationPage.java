package SwagLabsPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.ReporterUtil;
import util.ScreenShotUtil;

import java.util.ArrayList;
import java.util.List;

import static driverManager.DriverManager.getDriver;

//Locators and methods for Checkout information page
public class CheckoutInformationPage extends BasePage
{
    By firstnameLocator = By.xpath("//*[contains(@placeholder,'First Name')]");
    By lastNameLocator = By.xpath("//*[contains(@placeholder,'Last Name')]");
    By postalCodeLocator = By.xpath("//*[contains(@placeholder,'Postal')]");
    By continueLocator = By.xpath("//*[contains(@value,'Continue')]");
    By finishLocator = By.xpath("//button[contains(.,'Finish')]");
    By productsFromTable = By.xpath("//a//div[@class='inventory_item_name']");


    public CompletePage enterInfo()
    {
        sendKeys(firstnameLocator,"anu ");
        sendKeys(lastNameLocator,"deep");
        sendKeys(postalCodeLocator,"nmnm02");
        click(continueLocator);
        click(finishLocator);

        String sauce = ScreenShotUtil.takeScreenshot();
        ReporterUtil.getTest().info( MediaEntityBuilder.createScreenCaptureFromBase64String(sauce).build());

        return new CompletePage();
    }

    public CompletePage missingInfo()
    {
        sendKeys(firstnameLocator,"anu ");
        sendKeys(lastNameLocator,"deep");
        sendKeys(postalCodeLocator,"");
        click(continueLocator);

        String sauce = ScreenShotUtil.takeScreenshot();
        ReporterUtil.getTest().info( MediaEntityBuilder.createScreenCaptureFromBase64String(sauce).build());

        return new CompletePage();
    }

    /* public List<String> getProductsFromTable()
    {
        List <WebElement> products = getDriver().findElements(productsFromTable);
        List <String> productsFromTable = new ArrayList<>();
        for(WebElement product : products)
        {
            productsFromTable.add(product.getText());
        }
        return productsFromTable;
    }*/

}
