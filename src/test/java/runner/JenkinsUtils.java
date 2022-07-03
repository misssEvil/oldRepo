package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

        driver.findElement(By.name("j_username")).sendKeys(getProperties().getProperty("test"));
        driver.findElement(By.name("j_password")).sendKeys(getProperties().getProperty("test"));
        driver.findElement(By.name("Submit")).click();
    }

    static void logout(WebDriver driver) {
        get(driver);

        driver.findElement(By.xpath("//a[@href='/logout']")).click();
    }

}