import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private WebDriver driver;
    public static final String BASE_URL = "http://www.99-bottles-of-beer.net/";
    public static final String SUBMIT_NEW_LANG_URL = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

    @BeforeMethod
    protected void driverSetUp() {
        this.driver = BaseTestUtils.createDriver();
    }

    @AfterMethod
    protected void afterMethod() {
        driver.quit();
    }

    protected WebDriver getDriver() {
        return this.driver;
    }
}

