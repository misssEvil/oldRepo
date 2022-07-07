package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait20;
    private WebDriverWait wait5;

    @BeforeMethod
    protected void beforeMethod() {
        driver = BaseUtils.createDriver();
        JenkinsUtils.login(driver);
    }

    @AfterMethod
    protected void afterMethod() {
        JenkinsUtils.logout(driver);
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait20() {
        if (wait20 == null) {
            wait20 = new WebDriverWait(getDriver(), 20);
        }
        return wait20;
    }

    protected WebDriverWait getWait5() {
        if (wait5 == null) {
            wait5 = new WebDriverWait(getDriver(), 5);
        }
        return wait5;
    }
}
