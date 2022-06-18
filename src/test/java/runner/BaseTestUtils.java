package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class BaseTestUtils {
    public static final String CHROME_DRIVER = "webdriver.chrome.driver";
    public static final String DRIVER_PATH = "C://chromedriver_win32/chromedriver.exe";

    static WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
