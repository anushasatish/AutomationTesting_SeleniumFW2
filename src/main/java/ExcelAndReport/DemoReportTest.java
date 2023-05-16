package ExcelAndReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;

public class DemoReportTest
{
    public static void main(String[] args) {

        LocalDateTime localdatetime = LocalDateTime.now();
        int hour = localdatetime.getHour();
        int nano = localdatetime.getNano();

        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("ReportsSwag/Spark_" + hour + "_" + nano + ".html");

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("SwagLabs reports");

        extent.attachReporter(spark);

        ExtentTest test1 = extent.createTest("Test1");
        test1.info("step1_done");
        test1.info("step2_done");
        test1.pass("test 1 pass");

        test1.assignAuthor(("Anusha"));
        test1.assignCategory("Regression");
        test1.assignDevice("mac");

        ExtentTest test2 = extent.createTest("Test2");
        test1.info("step1_done");
        test1.info("step2_done");
        test1.pass("test 2 pass");

        test1.assignAuthor(("ABC"));
        test1.assignCategory("Smoke");
        test1.assignDevice("Windows");

        extent.flush();


    }
}
