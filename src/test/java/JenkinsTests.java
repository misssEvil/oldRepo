import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import runner.BaseUtils;

import static java.lang.System.getProperties;

public class JenkinsTests extends BaseTest {

   @Test
    public void lalaTest(){

       getDriver().get(String.format("http://localhost:%s", BaseUtils.getProperties().getProperty("default.port")));
       Assert.assertEquals(getDriver().findElement(By.xpath("//div/h1")).getText(),  "Welcome to Jenkins!");


       getDriver().findElement(By.name("j_username")).sendKeys("test");
       getDriver().findElement(By.name("j_password")).sendKeys("test");
       getDriver().findElement(By.name("Submit")).click();



   }
}
