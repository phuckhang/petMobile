package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 90), this);
    }

    @FindBy(xpath = "//input[@name='uid']")
    public WebElement txtUserID;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement txtPass;

    @FindBy(name = "btnLogin")
    public WebElement btnLogin;

    @FindBy(xpath = "//*[@class='layout']//tr[@class='heading3']")
    public WebElement lblUserID;
}
