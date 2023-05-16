package listeners;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.*;
import util.ReporterUtil;
import util.ScreenShotUtil;

import static util.ReporterUtil.createReport;

//To add Listener class to listen to test events
public class FWListener implements ISuiteListener , ITestListener
{
    //OnStart - called when any test starts
    @Override
    public void onStart(ISuite suite)
    {
        createReport(suite.getName());
    }

    //OnFinish - called after all tests executed
    @Override
    public void onFinish(ISuite suite)
    {
       ReporterUtil.flushReport();
    }

    //called when testcase get started
    @Override
    public void onTestStart(ITestResult result)
    {
        ReporterUtil.createTest(result.getMethod().getMethodName());

    }

    //called on the success of any test
    @Override
    public void onTestSuccess(ITestResult result)
    {
    ReporterUtil.getTest().pass("PASSED");

    }

    //called on the failure of any test
   @Override
    public void onTestFailure(ITestResult result)
    {
    ReporterUtil.getTest().fail("FAILED");

        //To get screenshot whenever a test fails
        String sauce = ScreenShotUtil.takeScreenshot();
        ReporterUtil.getTest().info( MediaEntityBuilder.createScreenCaptureFromBase64String(sauce).build());

    }

    //called on when any tests are skipped
    @Override
    public void onTestSkipped(ITestResult result)
    {
        ReporterUtil.getTest().skip("SKIPPED");
    }

}
