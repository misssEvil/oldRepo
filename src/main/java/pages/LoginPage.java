package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private WebDriver driver;

    public LoginPage(WebDriver existingDriver){
        super(existingDriver);
    }

    @FindBy(name = "j_username")
    WebElement usernameField;

    @FindBy (name = "j_password")
    WebElement passwordField;

    @FindBy (name = "Submit")
    WebElement submitBtn;

    @FindBy (xpath = "//div/h1")
    WebElement welcomeMsg;

    @FindBy (xpath = "//div[@class='logo']")
    WebElement logoImg;

    public WebElement getUsernameField() {
        return usernameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getWelcomeMsg() {
        return welcomeMsg;
    }

    public WebElement getLogoImg() {
        return logoImg;
    }
}
