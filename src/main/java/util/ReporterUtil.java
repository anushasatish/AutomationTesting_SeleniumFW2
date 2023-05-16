package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;

//To get the ExtentReports to location ReportsNew with timestamp
public class ReporterUtil
{
    private static ExtentReports extentReports = new ExtentReports();
    private static ThreadLocal<ExtentTest> tl = new ThreadLocal<>();

    private static ExtentTest test;

    public static void createReport(String name)
    {
        LocalDateTime localdatetime = LocalDateTime.now();
        String time = localdatetime.getHour() + "_" +
                localdatetime.getMinute() + "_" +
                localdatetime.getSecond();

        ExtentSparkReporter spark = new ExtentSparkReporter("ReportsNew/spark_" + time + ".html");
        extentReports.attachReporter(spark);

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle(name);
        extentReports.attachReporter(spark);

    }

    //To write test information to a destination - ReportsNew
    public static void flushReport()
    {
        extentReports.flush();

    }

    //To create a test using ExtentReports
    public static void createTest(String testcase)
    {
        test = extentReports.createTest(testcase);
        tl.set(test);
    }

    public static ExtentTest getTest()
    {
    return tl.get();
    }
}
