package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import util.PropertiesUtil;

//To initiate Driver, get driver and quit browser
public class DriverManager
{
    static ThreadLocal <WebDriver> tl = new ThreadLocal<>();
    private static WebDriver driver;

    public static void InitiateDriver()
    {
        String browser = PropertiesUtil.getBrowser();

        if (browser.equals("chrome"))
        {
            driver = new ChromeDriver();
        }else
        {
            driver = new SafariDriver();
        }
        tl.set(driver);

       // driver.manage().window().maximize();
    }

    public static WebDriver getDriver()
    {
       return tl.get();
        // return driver;
    }

    public static void quitBrowser()
    {
        tl.get().quit();
        // driver.quit();
    }
}
