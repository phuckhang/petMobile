package libraries;

import objects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomeFunc extends HomePage {
    public HomeFunc(WebDriver driver) {
        super(driver);
    }

    public void clickLogoutButton() {
        btnLogout.click();
    }

    public void verifyLoginSuccessful() {
        Assert.assertTrue(btnLogout.isDisplayed());
    }

}
