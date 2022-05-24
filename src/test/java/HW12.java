import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.NoSuchElementException;

public class HW12 extends BaseTest{

    @Test(priority = 1)
    public void testSubmenuLetterJ() {
        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath("//ul[@id='menu']/li[2]/a")).click();
        WebElement submenuJ = getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("J")));
        submenuJ.click();
        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@id='main']/p[1]")).getText(),
                "All languages starting with the letter J are shown, sorted by Language.");
    }

    @Test (priority = 2)
    public void testLastLangOnM() {
        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath("//ul[@id='menu']/li[2]/a")).click();
        WebElement submenuM = getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("M")));
        submenuM.click();
        getJs().executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight, document.body.scrollHeight, document.documentElement.clientHeight));", new Object[0]);
        WebElement lastLang = getDriver().findElement(By.xpath("//tbody/tr[last()]/td[1]"));
        Assert.assertEquals(lastLang.getText(),"MySQL");
    }

    @Test (priority = 3)
    public void testColumnTitles(){ //Language, Author, Date, Comments, Rate
        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath("//ul[@id='menu']/li[2]/a")).click();
        WebElement langColumn = getDriver().findElement(By.xpath("//tbody/tr[1]/th[1]"));
        WebElement authorColumn = getDriver().findElement(By.xpath("//tbody/tr[1]/th[2]"));
        WebElement dateColumn = getDriver().findElement(By.xpath("//tbody/tr[1]/th[3]"));
        WebElement commentsColumn = getDriver().findElement(By.xpath("//tbody/tr[1]/th[4]"));
        WebElement rateColumn = getDriver().findElement(By.xpath("//tbody/tr[1]/th[5]"));

        Assert.assertEquals(langColumn.getText(), "Language");
        Assert.assertEquals(authorColumn.getText(), "Author");
        Assert.assertEquals(dateColumn.getText(), "Date");
        Assert.assertEquals(commentsColumn.getText(), "Comments");
        Assert.assertEquals(rateColumn.getText(), "Rate");
    }

    @Test (priority = 4)
    public void testMathematicaLine(){
        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath("//ul[@id='menu']/li[2]/a")).click();
        WebElement submenuM = getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("M")));
        submenuM.click();
        WebElement langMathematica = getDriver().findElement(By.xpath("//tr/td/a[contains(@href, 'mathematica')]"));
        langMathematica.click();
        Assert.assertEquals(getDriver().findElement(By.xpath("//tr[1]/td[2]")).getText(), "03/16/06");
        Assert.assertEquals(getDriver().findElement(By.xpath("//tr[2]/td[2]")).getText(), "Brenton Bostick");
        Assert.assertEquals(getDriver().findElement(By.xpath("//tr[4]/td[2]")).getText(), "1");
    }

    @Test (priority = 5)
    public void countLangStartWithNums() throws NoSuchElementException{
        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath("//ul[@id='menu']/li[2]/a")).click();
        WebElement submenu = getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("0-9")));
        submenu.click();
        int counter = 0;

        try {
            for (int i = 1; i < 200;){
                WebElement webElement = getDriver().findElement(By.xpath("//tr[" + i + "]"));
                if(webElement.isDisplayed()){
                    counter = i;
                    System.out.println(counter);
                    i++;
                }
                else {
                    break;
                }
            }
        } catch (org.openqa.selenium.NoSuchElementException var8) {
            System.out.println("Error");
        }

        Assert.assertEquals(counter-1, 10);
    }

    @Test (priority = 6)
    public void testInvalidSecurityCode() throws InterruptedException {
        getDriver().get("http://www.99-bottles-of-beer.net/signv2.html");
        getJs().executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight, document.body.scrollHeight, document.documentElement.clientHeight));", new Object[0]);
        WebElement iName = getDriver().findElement(By.xpath("//input[contains(@name, 'name')]"));
        iName.sendKeys("Aida");
        WebElement iLocation = getDriver().findElement(By.xpath("//input[contains(@name, 'location')]"));
        iLocation.sendKeys("Bologna");
        WebElement iEmail = getDriver().findElement(By.xpath("//input[contains(@name, 'email')]"));
        iEmail.sendKeys("aidacattaneo@mail.it");
        WebElement iCode = getDriver().findElement(By.xpath("//input[contains(@name, 'captcha')]"));
        iCode.sendKeys(Instant.now().toString().substring(24,28));
        Thread.sleep(1000);
        WebElement iMsg = getDriver().findElement(By.xpath("//textarea"));
        iMsg.sendKeys("I like your site!");
        Thread.sleep(1000);
        WebElement submitBtn = getDriver().findElement(By.xpath("//form/p/input[contains(@type, 's')]"));
        Thread.sleep(1000);
        submitBtn.click();
        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@id='main']/p")).getText(), "Error: Error: Invalid security code.");
    }

  //  @Test (priority = )






    }



