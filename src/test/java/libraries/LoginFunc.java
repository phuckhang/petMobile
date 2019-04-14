package libraries;

import objects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginFunc extends LoginPage {
    public LoginFunc(WebDriver driver) {
        super(driver);
    }

    public void fillEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void fillPassword(String pass) {
        txtPass.sendKeys(pass);
    }

    public void clickLoginButton() {
        btnLogin.click();
    }

    public void verifyErrorMessage(String expectMessage) {
        Assert.assertEquals(lblErrorMsg.getText(), expectMessage);
    }
}
