package SwagLabsPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.ReporterUtil;
import util.ScreenShotUtil;

import java.util.ArrayList;
import java.util.List;

import static driverManager.DriverManager.getDriver;

public class ConfirmationPage extends BasePage
{
    By productsFromTable = By.xpath("//a//div[@class='inventory_item_name']");

    public List<String> getProductsFromTable()
    {
        List <WebElement> products = getDriver().findElements(productsFromTable);
        List <String> productsFromTable = new ArrayList<>();
        for(WebElement product : products)
        {
            productsFromTable.add(product.getText());
        }

        String sauce = ScreenShotUtil.takeScreenshot();
        ReporterUtil.getTest().info( MediaEntityBuilder.createScreenCaptureFromBase64String(sauce).build());

        return productsFromTable;
    }
}
