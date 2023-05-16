package SwagLabsPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.ReporterUtil;
import util.ScreenShotUtil;

import java.util.List;

import static driverManager.DriverManager.getDriver;

public class ProductPage extends BasePage
{
    By backpackAddToCart = By.xpath("//*[contains(.,'Sauce Labs Backpack') and @class='inventory_item_name']/ancestor::div[@class='inventory_item_description']//button");
    By allAddToCartButtons = By.xpath("//button[contains(.,'Add to cart')]");
    By addToCartButton = By.xpath("//*[contains(@class,'shopping_cart_link')]");
    By checkoutbutton = By.xpath("//button[contains(.,'Checkout')]");


    public CheckoutInformationPage singleItemCheckout()
    {
        click(backpackAddToCart);
        click(addToCartButton);
        click(checkoutbutton);
        return new CheckoutInformationPage();
    }

    public CheckoutInformationPage allItemsCheckout()
    {
        List<WebElement> allElements = getDriver().findElements(allAddToCartButtons);
        int i = 1;
        for (WebElement ele : allElements)
        {
            ReporterUtil.getTest().info("Clicked on add to cart button : " + i);
            ele.click();
            mySleep(200);
            i++;
        }
        click(addToCartButton);
        click(checkoutbutton);

        String sauce = ScreenShotUtil.takeScreenshot();
        ReporterUtil.getTest().info( MediaEntityBuilder.createScreenCaptureFromBase64String(sauce).build());

        return new CheckoutInformationPage();
    }
}
