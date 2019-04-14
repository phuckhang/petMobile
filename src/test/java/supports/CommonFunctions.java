package supports;

import configuration.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonFunctions extends TestBase {

    public static void visit(String path) {
        driver.manage().window().maximize();
        driver.get(BASE_URL + path);
    }

    public static WebDriver getBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
            return new FirefoxDriver();
        } else System.err.println("The browser '" + browser + "' is not defined!!");
        return null;
    }

}
