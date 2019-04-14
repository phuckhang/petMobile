package configuration;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import data.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.CommonFunctions;
import supports.GetScreenShot;

import java.io.IOException;

public class TestBase extends TestData {
    public static WebDriver driver;
    public static String BASE_URL = "https://anotepad.com";
    private ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    @Parameters({"browserName"})
    @BeforeTest
    public void init(String browserName) {
        String name = System.getProperty("browser.name");
        if (name == null) {
            driver = CommonFunctions.getBrowser(browserName);
        } else {
            driver = CommonFunctions.getBrowser(name);
        }

    }

    @Parameters({"urlPath"})
    @BeforeMethod
    public static void setUp(String urlPath) {
        CommonFunctions.visit(urlPath);
    }

    @BeforeTest
    public void startReport() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "ReportTest");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("User name", "Khang");
        htmlReporter.config().setDocumentTitle("ExtentReport");
        htmlReporter.config().setReportName("Auto Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, MarkupHelper.createLabel("Failed test case is " + result.getName(), ExtentColor.RED));
            logger.log(Status.FAIL, "Test case is failed because: " + result.getThrowable());
            String screenShotPath = GetScreenShot.capture(driver, result.getName());
            logger.fail("Screenshot is below: " + logger.addScreenCaptureFromPath(screenShotPath));
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.FAIL, "Skipped test case is " + result.getName());
        }
        extent.flush();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public void logPassed(String description) {
        logger.log(Status.PASS, MarkupHelper.createLabel(description, ExtentColor.GREEN));
    }

}
