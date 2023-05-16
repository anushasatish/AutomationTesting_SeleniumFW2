package SwagLabsPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import util.ReporterUtil;
import util.ScreenShotUtil;

public class CompletePage extends BasePage
{
    By headerLocator = By.xpath("//h2[contains(@class,'complete-header')]");
    By backhomelOCATOR = By.xpath("//button[contains(.,'Back Home')]");

    public String getHeaderMessage()
    {

        String sauce = ScreenShotUtil.takeScreenshot();
        ReporterUtil.getTest().info( MediaEntityBuilder.createScreenCaptureFromBase64String(sauce).build());

        return getText(headerLocator);

    }

    public LoginPage goToHomePage()
    {
        click(backhomelOCATOR);
        return new LoginPage();
    }

}
