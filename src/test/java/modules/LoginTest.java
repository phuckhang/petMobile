package modules;

import configuration.TestBase;
import libraries.HomeFunc;
import libraries.LoginFunc;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test(dataProvider = "loginSuccess")
    public void test_login_success(String email, String pass) {
        logger = extent.createTest("test_login_passed");
        LoginFunc lf = new LoginFunc(driver);
        HomeFunc hf = new HomeFunc(driver);
        lf.fillEmail(email);
        logPassed("Fill email: " + email);
        lf.fillPassword(pass);
        logPassed("Fill password: " + pass);
        lf.clickLoginButton();
        logPassed("Click on Login button");
        hf.verifyLoginSuccessful();
        logPassed("Login successfully");
        hf.clickLogoutButton();
    }

    @Test(dataProvider = "loginFailed")
    public void test_login_failed(String email, String pass, String message) {
        logger = extent.createTest("test_login_failed");
        LoginFunc lf = new LoginFunc(driver);
        lf.fillEmail(email);
        logPassed("Fill email: " + email);
        lf.fillPassword(pass);
        logPassed("Fill password: " + pass);
        lf.clickLoginButton();
        logPassed("Click on Login button");
        lf.verifyErrorMessage(message);
        logPassed("Error message is correct");
    }

}
