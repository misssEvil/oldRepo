package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import runner.BaseTest;
import runner.PropertyUtils;

import static runner.PropertyUtils.getProperties;

public class LoginPageTest extends BaseTest {

    @Test
    public void secondTest(){
        getDriver().findElement(By.xpath("//a[@href='/logout']")).click();

        LoginPage loginElements = new LoginPage(getDriver());

        PageFactory.initElements(getDriver(), loginElements);
        loginElements.getUsernameField().sendKeys("test");
        loginElements.getPasswordField().sendKeys("test");
        loginElements.getSubmitBtn().click();
        getWait20();

        Assert.assertTrue(getDriver().findElement(By.xpath("//a[@href='/user/test']")).isEnabled());
    }

   @Test
    public void logoWelcomeLPTest(){
       getDriver().findElement(By.xpath("//a[@href='/logout']")).click();

        getDriver().get(String.format("http://localhost:%s", PropertyUtils.getProperties().getProperty("default.port")));
        Assert.assertEquals(getDriver().findElement(By.xpath("//div/h1")).getText(),  "Welcome to Jenkins!");
       Assert.assertTrue(getDriver().findElement(By.xpath("//div[@class='logo']")).isDisplayed());

        getDriver().findElement(By.name("j_username")).sendKeys("test");
        getDriver().findElement(By.name("j_password")).sendKeys("test");
        getDriver().findElement(By.name("Submit")).click();

        Assert.assertTrue(getDriver().findElement(By.xpath("//a[@href='/user/test']")).isEnabled());
    }


}
