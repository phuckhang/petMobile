package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 90), this);
    }

    @FindBy(xpath = "//*[@class='layout']//tr[@class='heading3']")
    public WebElement lblUserID;

    @FindBy(xpath = "//*[@href='Logout.php']")
    public WebElement btnLogout;
}
