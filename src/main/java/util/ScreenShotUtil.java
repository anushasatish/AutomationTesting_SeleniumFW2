package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static driverManager.DriverManager.getDriver;

//To get the screenshot of the test result
public class ScreenShotUtil
{
    public static String takeScreenshot()
    {
        return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
