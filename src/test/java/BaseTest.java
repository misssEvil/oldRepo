import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private WebDriver driver;
    private JavascriptExecutor js;

    private WebDriverWait wait;
    public static final String BASE_URL = "http://www.99-bottles-of-beer.net/";
    public static final String SUBMIT_NEW_LANG_URL = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

    @BeforeMethod
    protected void driverSetUp() {
        driver = BaseTestUtils.createDriver();
    }

    @AfterMethod
    protected void afterMethod() {
      // driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait(){
        return  wait = new WebDriverWait(getDriver(),1000);
    }

    protected JavascriptExecutor getJs(){
        return js = (JavascriptExecutor)getDriver();
    }
}


