package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        super();
//        PageFactory.initElement(driver, this);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = LoginPageForm.USERNAME)
    public WebElement userName;

    @FindBy(id = LoginPageForm.PASSWORD)
    public WebElement password;

    @FindBy(id=LoginPageForm.LOGIN)
   public WebElement login;
}
