package configuration;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import data.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
    public void init(@Optional("firefox") String browserName) {
        driver = CommonFunctions.getBrowser(browserName);
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

    @Test
    public void captureScreenshot() {
        logger = extent.createTest("captureScreenshot");
        System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://www.automationtesting.in");
        String title = driver.getTitle();
        Assert.assertEquals("Home - Automation Test", title);
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, "Failed test case is " + result.getName());
            logger.log(Status.FAIL, "Test case is failed because: " + result.getThrowable());
            String screenShotPath = GetScreenShot.capture(driver, result.getName());
            MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(screenShotPath).build();
            logger.fail("Click on base64-image to open screenshot ==>> ", mediaModel);
////            Chrome and Firefox are not allowed to load local resource (screenshot). So using FromBase64 instead of FromPath
//            logger.fail("Snapshot below: " + logger.addScreenCaptureFromPath(screenShotPath));
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
