package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(id = "loginEmail")
    public WebElement txtEmail;

    @FindBy(xpath = "//input[@value='login']/..//input[@id='password']")
    public WebElement txtPass;

    @FindBy(xpath = "//button[@id='submit' and text()='Login']")
    public WebElement btnLogin;

    @FindBy(css = ".alert-danger > strong")
    public WebElement lblErrorMsg;
}
