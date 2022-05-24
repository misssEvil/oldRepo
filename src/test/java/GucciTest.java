import java.time.Instant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GucciTest extends BaseTest {

    @Test(priority = 1)
    public void gucciSingUpForNewsValidTest() throws InterruptedException {
        String url = "https://www.gucci.com/cz/en_gb/";
        this.getDriver().get(url);
        Assert.assertEquals(this.getDriver().getCurrentUrl(), url);
        Thread.sleep(1000L);

        WebElement intPopupClose;
        try {
            WebElement popupCookie = this.getDriver().findElement(By.xpath("//div[@id='onetrust-policy']"));
            WebElement popupInternational;
            if (popupCookie.isDisplayed()) {
                popupInternational = this.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
                popupInternational.click();
            }

            popupInternational = this.getDriver().findElement(By.xpath("//div[@id='international-overlay']"));
            if (popupInternational.isDisplayed()) {
                intPopupClose = this.getDriver().findElement(By.className("international-overlay-close"));
                intPopupClose.click();
            }
        } catch (NoSuchElementException var8) {
            System.out.println("Pop-up didn't appear!");
        }

        JavascriptExecutor js = (JavascriptExecutor)this.getDriver();
        js.executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight, document.body.scrollHeight, document.documentElement.clientHeight));", new Object[0]);
        Thread.sleep(2000L);
        WebDriverWait wait = new WebDriverWait(this.getDriver(), 20L);
        intPopupClose = (WebElement)wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.newsletter-input-wrapper > input")));
        CharSequence[] var10001 = new CharSequence[1];
        String var10004 = Instant.now().toString();
        var10001[0] = "test" + var10004.substring(21, 27) + "@mail.kz";
        intPopupClose.sendKeys(var10001);
        WebElement submitBtn = this.getDriver().findElement(By.cssSelector("div.newsletter-button-wrapper > input"));
        submitBtn.click();
        Thread.sleep(4000L);
        WebElement successMsg = this.getDriver().findElement(By.cssSelector(".overlay-form-header"));
        Thread.sleep(2000L);
        Assert.assertTrue(successMsg.getText().contains("You are now signed up for the Gucci newsletter"));
        WebElement closePopup = this.getDriver().findElement(By.cssSelector("#thank-you-newsletter > div > div > button"));
        closePopup.click();
        Thread.sleep(2000L);
        Assert.assertFalse(this.getDriver().findElement(By.cssSelector("div.form-overlay-content")).isDisplayed());
    }
}

