package configuration;

import com.beust.jcommander.Parameter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.CommonFunctions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestBase {
    public static WebDriver driver;
    public static String BASE_URL="http://demo.guru99.com";

    @Parameters({"browserName"})
    @BeforeTest
    public static void init(@Optional("chrome") String browserName) {
        driver = CommonFunctions.getBrowser(browserName);
//        driver.manage().window().maximize();
//        driver.get(BASE_URL + "/V4/");
    }

    @Parameters({"urlPath"})
    @BeforeMethod
    public static void setUp(String urlPath) {
        CommonFunctions.visit(urlPath);
    }

    @DataProvider(name = "guru")
    public Object[][] testData() {
        return new Object[][]{
                new Object[]{"mngr189462", "jemebEb"}
        };
    }

    @AfterMethod
    public void takeScreenShotIfFailure(ITestResult testResult) throws IOException {
        String screenShotFile;
        String tc_name = testResult.getMethod().getConstructorOrMethod().getName();
        String dateFormat = new SimpleDateFormat("ddMMyyyy_hhmmss").format(Calendar.getInstance().getTime());
        //Create the file name with date time format then grant to "screenShotFile"
        screenShotFile = System.getProperty("user.dir") + "/src/test/java/reports/images/" + "ScreenShot_" + tc_name + "_" + dateFormat + ".png";

        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(screenShotFile));

        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
