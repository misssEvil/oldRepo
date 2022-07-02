import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PlaygroundTest {

    @Test
    public void firstTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://1lib.tw");
        driver.findElement(By.id("searchFieldx")).sendKeys("architecture of happiness");
        driver.findElement(By.className("inner")).click();

        Assert.assertEquals(driver.findElement(By.linkText("The Architecture of Happiness")).getText(), "The Architecture of Happiness");

        driver.quit();

    }
}
