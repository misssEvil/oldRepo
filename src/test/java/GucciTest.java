/*
import java.time.Instant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;

public class GucciTest extends BaseTest {


    @Ignore
    @Test
    public void gucciSingUpForNewsValidTest() throws InterruptedException {
        String url = "https://www.gucci.com/cz/en_gb/";
        getDriver().get(url);
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
        Thread.sleep(1000L);

        WebElement intPopupClose;
        try {
            WebElement popupCookie = getDriver().findElement(By.xpath("//div[@id='onetrust-policy']"));
            WebElement popupInternational;
            if (popupCookie.isDisplayed()) {
                popupInternational = getDriver().findElement(By.id("onetrust-accept-btn-handler"));
                popupInternational.click();
            }

            popupInternational = getDriver().findElement(By.xpath("//div[@id='international-overlay']"));
            if (popupInternational.isDisplayed()) {
                intPopupClose = getDriver().findElement(By.className("international-overlay-close"));
                //intPopupClose.click();
                intPopupClose.submit();
            }
            else{}
        } catch (NoSuchElementException var8) {
            System.out.println("Pop-up didn't appear!");
        }

        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight, document.body.scrollHeight, document.documentElement.clientHeight));", new Object[0]);
        Thread.sleep(2000L);
        WebDriverWait wait = new WebDriverWait(getDriver(), 20L);
        intPopupClose = (WebElement)wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.newsletter-input-wrapper > input")));
        intPopupClose.sendKeys("test" + Instant.now().toString().substring(21, 27) + "@mail.kz");
        WebElement submitBtn = getDriver().findElement(By.cssSelector("div.newsletter-button-wrapper > input"));
        submitBtn.click();
        Thread.sleep(4000L);
        WebElement successMsg = getDriver().findElement(By.cssSelector(".overlay-form-header"));
        Thread.sleep(2000L);
        Assert.assertTrue(successMsg.getText().contains("You are now signed up for the Gucci newsletter"));
        WebElement closePopup = getDriver().findElement(By.cssSelector("#thank-you-newsletter > div > div > button"));
        closePopup.click();
        Thread.sleep(2000L);
        Assert.assertFalse(getDriver().findElement(By.cssSelector("div.form-overlay-content")).isDisplayed());
    }
}
*/
