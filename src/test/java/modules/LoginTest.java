package modules;

import configuration.TestBase;
import libraries.HomeFunc;
import libraries.LoginFunc;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test(dataProvider = "guru")
    public void login_test(String userID, String pass){
        LoginFunc lf = new LoginFunc(driver);
        HomeFunc hf = new HomeFunc(driver);
        lf.fillUserID(userID);
        lf.fillPassword(pass);
        lf.clickLoginButton();
        hf.verifyLoginSuccessful(userID);
        hf.clickLoginButton();
    }
}
