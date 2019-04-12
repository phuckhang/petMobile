package supports;

import configuration.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

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
        } else if (browser.equalsIgnoreCase("safari")) {
            return new SafariDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
            return new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        } else System.err.println("The browser " + browser + " is no defined!!");
        return null;
    }

}
