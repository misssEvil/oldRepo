package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

//import static runner.PropertyUtils.PREFIX_PROP;
import static runner.PropertyUtils.getProperties;
//import static runner.PropertyUtils.PREFIX_PROP;
import static runner.PropertyUtils.getProperties;

public final class JenkinsUtils {

    /*private static final String PROP_PORT = PREFIX_PROP + "port";
    private static final String PROP_ADMIN_USERNAME = PREFIX_PROP + "admin.username";
    private static final String PROP_ADMIN_PAS = PREFIX_PROP + "admin.password";*/



    static void get(WebDriver driver) {
        driver.get(String.format("http://localhost:%s", getProperties().getProperty("default.port")));
    }

    static void login(WebDriver driver) {
        get(driver);
        LoginPage loginElements = new LoginPage(driver);

        PageFactory.initElements(driver, loginElements);
        loginElements.getUsernameField().sendKeys(getProperties().getProperty("default.admin.username"));
        loginElements.getPasswordField().sendKeys(getProperties().getProperty("default.admin.password"));
        loginElements.getSubmitBtn().click();
    }

    static void logout(WebDriver driver) {
        get(driver);
        driver.findElement(By.xpath("//a[@href='/logout']")).click();
    }

}