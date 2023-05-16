package SwagLabsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropertiesUtil;
import util.ReporterUtil;

import java.time.Duration;

import static driverManager.DriverManager.getDriver;

public class BasePage
{
    public void click(By by)
    {
        ReporterUtil.getTest().info("Clicked on :" + by.toString());
        getDriver().findElement(by).click();
    }

    public String getText(By by)
    {
        return getDriver().findElement(by).getText().trim();
    }

    public WebDriverWait explicitWait()
    {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(PropertiesUtil.getExplicitTimeOutInSec()));
    }

    public WebElement getElement(By by)
    {
        return getDriver().findElement(by);
    }

    public void mySleep(int millis)
    {
        try
        {
            Thread.sleep(millis);
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
    public WebElement waitUntilEleIsVisible(By by)
    {
        return explicitWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void sendKeys(By by, String text)
    {
        ReporterUtil.getTest().info("Sending text: " + text);
        waitUntilEleIsVisible(by).sendKeys(text);
    }

    public String getTitle()
    {
        return getDriver().getTitle();
    }

}
