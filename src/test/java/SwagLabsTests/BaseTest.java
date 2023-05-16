package SwagLabsTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static driverManager.DriverManager.InitiateDriver;
import static driverManager.DriverManager.quitBrowser;

//Before and After methods
public class BaseTest
{
    @BeforeMethod
    public void setup()
    {
        InitiateDriver();
    }

   @AfterMethod
    public void teardown()
    {
        quitBrowser();
    }
}
