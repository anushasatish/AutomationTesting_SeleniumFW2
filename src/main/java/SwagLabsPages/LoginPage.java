package SwagLabsPages;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.PropertiesUtil;
import util.ReporterUtil;
import util.ScreenShotUtil;

import static driverManager.DriverManager.getDriver;

//Locators and methods for Login Page
public class LoginPage extends BasePage
{
    String LoginPageURL = PropertiesUtil.getUrL();
    By usernameElementLocator = By.xpath("//input[@id='user-name']");
    By passwordElementLocator = By.xpath("//input[@id='password']");
    By loginButtonLocator = By.xpath("//input[@value='Login']");
    By errorMsgLocator = By.xpath("//div [@class='error-message-container error']/h3[contains(text(),'Error: Postal Code is required')]");

    public void navigateToLoginPage()
    {
    getDriver().get(LoginPageURL);
    }

    public WebElement getUserName()
    {
    return getElement(usernameElementLocator);
    }

     public WebElement getPassword()
     {
     return getElement(passwordElementLocator);
     }

     public WebElement getError()
     {
         return getElement(errorMsgLocator);
     }

     //Login method
     public ProductPage login1()
    {
        click(loginButtonLocator);

        String sauce = ScreenShotUtil.takeScreenshot();
        ReporterUtil.getTest().info( MediaEntityBuilder.createScreenCaptureFromBase64String(sauce).build());

        return new ProductPage();
    }


    public ProductPage login()
    {
        getDriver().get(PropertiesUtil.getValueFromPropertyFile("url"));

        String sauce = ScreenShotUtil.takeScreenshot();
        ReporterUtil.getTest().info( MediaEntityBuilder.createScreenCaptureFromBase64String(sauce).build());

        ReporterUtil.getTest().info("Logged into the SauceDemo :: " + PropertiesUtil.getValueFromPropertyFile("url"));

        getDriver().findElement(usernameElementLocator).sendKeys(PropertiesUtil.getValueFromPropertyFile("sauceUsername"));
        ReporterUtil.getTest().info("Username :: " + PropertiesUtil.getValueFromPropertyFile("sauceUsername"));

        getDriver().findElement(passwordElementLocator).sendKeys(PropertiesUtil.getValueFromPropertyFile("saucePassword"));
        ReporterUtil.getTest().info("Password :: " + PropertiesUtil.getValueFromPropertyFile("saucePassword"));

        click(loginButtonLocator);
        ReporterUtil.getTest().info("Clicked on Login button");

        return new ProductPage(); //returns next page - products page
    }



}
