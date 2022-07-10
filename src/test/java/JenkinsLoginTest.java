import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class JenkinsLoginTest extends BaseTest {

    @Test
    public void loginTest(){

           /* Assert.assertTrue(getDriver().findElement(By.xpath("//a[@href='/logout']")).isEnabled());
            getDriver().findElement(By.xpath("//a[@href='/logout']")).click();
*/
            getDriver().get("http://localhost:9090");
            Assert.assertEquals(getDriver().findElement(By.xpath("//div/h1")).getText(),  "Welcome to Jenkins!");

            getDriver().findElement(By.name("j_username")).sendKeys("test");
            getDriver().findElement(By.name("j_password")).sendKeys("test");
            getDriver().findElement(By.name("Submit")).click();

            Assert.assertTrue(getDriver().findElement(By.xpath("//a[@href='/user/test']")).isEnabled());
        }

        /*@Test
        public void logoWelcomeLPTest(){
            getWait20();
            Assert.assertTrue(getDriver().findElement(By.xpath("//a[@href='/logout']")).isEnabled());
            getDriver().findElement(By.xpath("//a[@href='/logout']")).click();

            getDriver().get(String.format("http://localhost:%s", PropertyUtils.getProperties().getProperty("default.port")));
            Assert.assertEquals(getDriver().findElement(By.xpath("//div/h1")).getText(),  "Welcome to Jenkins!");
            Assert.assertTrue(getDriver().findElement(By.xpath("//div[@class='logo']")).isDisplayed());

            getDriver().findElement(By.name("j_username")).sendKeys("test");
            getDriver().findElement(By.name("j_password")).sendKeys("test");
            getDriver().findElement(By.name("Submit")).click();

            Assert.assertTrue(getDriver().findElement(By.xpath("//a[@href='/user/test']")).isEnabled());
        }
*/

    }
