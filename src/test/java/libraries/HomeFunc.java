package libraries;

import objects.HomePage;
import objects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomeFunc extends HomePage {
    public HomeFunc(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton(){
        btnLogout.click();
    }

    public void verifyLoginSuccessful(String expectUserID){
        Assert.assertTrue(lblUserID.getText().contains(expectUserID));
    }
}
