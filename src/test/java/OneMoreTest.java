import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class OneMoreTest extends BaseTest {

    @Test
    public void oneMoreWelcomeTest(){
        getDriver().get("http://localhost:8080");
        Assert.assertEquals(getDriver().findElement(By.xpath("//div/h1")).getText(),  "Welcome to Jenkins!");

    }

    @Test
    public void oneMoreLoginTest(){
        getDriver().get("http://localhost:8080");

        getDriver().findElement(By.name("j_username")).sendKeys("testOneMore");
        getDriver().findElement(By.name("j_password")).sendKeys("test");
        getDriver().findElement(By.name("Submit")).click();


    }
}
