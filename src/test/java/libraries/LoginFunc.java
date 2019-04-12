package libraries;

import objects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginFunc extends LoginPage {
    public LoginFunc(WebDriver driver) {
        super(driver);
    }

    public void fillUserID(String userID){
        txtUserID.sendKeys(userID);
    }

    public void fillPassword(String pass){
        txtPass.sendKeys(pass);
    }

    public void clickLoginButton(){
        btnLogin.click();
    }

    public void verifyLogin(String expectUserID){
//        Assert.assertEquals(lblUserID.getText(), expectUserID);
        Assert.assertTrue(lblUserID.getText().contains(expectUserID));
    }
}
