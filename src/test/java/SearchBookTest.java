import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class SearchBookTest extends BaseTest {

    @Test
    public void findBookTest(){

            getDriver().get("https://1lib.tw");
            getDriver().findElement(By.id("searchFieldx")).sendKeys("architecture of happiness");
            getDriver().findElement(By.className("inner")).click();

            Assert.assertEquals(getDriver().findElement(By.linkText("The Architecture of Happiness")).getText(), "The Architecture of Happiness");

    }
}
