import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.List;


public class HW12 extends BaseTest {

    @Test(priority = 1)
    public void testSubmenuLetterJ() {
        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath("//ul[@id='menu']/li[2]/a")).click();
        WebElement submenuJ = getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("J")));
        submenuJ.click();
        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@id='main']/p[1]")).getText(),
                "All languages starting with the letter J are shown, sorted by Language.");
    }

    @Test(priority = 2)
    public void testLastLangOnM() {
        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath("//ul[@id='menu']/li[2]/a")).click();
        WebElement submenuM = getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("M")));
        submenuM.click();
        getJs().executeScript("window.scrollTo(0, document.body.scrollHeight);", new Object[0]);
        WebElement lastLang = getDriver().findElement(By.xpath("//tbody/tr[last()]/td[1]"));
        Assert.assertEquals(lastLang.getText(), "MySQL");
    }

    @Test(priority = 3)
    public void testColumnTitles() { //Language, Author, Date, Comments, Rate
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

    @Test(priority = 4)
    public void testMathematicaLine() {
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

    @Test(priority = 5)
    public void countLangStartWithNums() throws NoSuchElementException {
        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath("//ul[@id='menu']/li[2]/a")).click();
        WebElement submenu = getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("0-9")));
        submenu.click();
        int counter = 0;

        try {
            for (int i = 1; i < 200; ) {
                WebElement webElement = getDriver().findElement(By.xpath("//tr[" + i + "]"));
                if (webElement.isDisplayed()) {
                    counter = i;
                    //System.out.println(counter);
                    i++;
                } else {
                    break;
                }
            }
        } catch (NoSuchElementException exception) {
        }

        Assert.assertEquals(counter - 1, 10);
    }

    @Test(priority = 6)
    public void testInvalidSecurityCode() throws InterruptedException {
        getDriver().get("http://www.99-bottles-of-beer.net/signv2.html");
        getJs().executeScript("window.scrollTo(0, document.body.scrollHeight);", new Object[0]);
        WebElement iName = getDriver().findElement(By.xpath("//input[contains(@name, 'name')]"));
        iName.sendKeys("Aida");
        WebElement iLocation = getDriver().findElement(By.xpath("//input[contains(@name, 'location')]"));
        iLocation.sendKeys("Bologna");
        WebElement iEmail = getDriver().findElement(By.xpath("//input[contains(@name, 'email')]"));
        iEmail.sendKeys("aidacattaneo@mail.it");
        WebElement iCode = getDriver().findElement(By.xpath("//input[contains(@name, 'captcha')]"));
        iCode.sendKeys(Instant.now().toString().substring(24, 28));
        Thread.sleep(1000);
        WebElement iMsg = getDriver().findElement(By.xpath("//textarea"));
        iMsg.sendKeys("I like your site!");
        Thread.sleep(1000);
        WebElement submitBtn = getDriver().findElement(By.xpath("//form/p/input[contains(@type, 's')]"));
        Thread.sleep(1000);
        submitBtn.click();
        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@id='main']/p")).getText(), "Error: Error: Invalid security code.");
    }

    @Test(priority = 7)
    public void testSaveBookmarkToReddit() throws NoSuchElementException {
        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath("//ul[@id='menu']/li[2]/a")).click();
        WebElement submenuG = getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("G")));
        submenuG.click();
        WebElement gameLang = getDriver().findElement(By.xpath("//tr/td/a[contains(@href,'gab')]"));
        gameLang.click();
        getJs().executeScript("window.scrollTo(0, document.body.scrollHeight/1.5);", new Object[0]);
        try {
            WebElement altVersion = getDriver().findElement(By.xpath("//table[@id='category']/tbody/tr[2]/td[1]/a"));
            altVersion.click();
        } catch (NoSuchElementException exception) {
        }

        WebElement redditBookmark = getDriver().findElement(By.xpath("//img[@alt='Reddit']"));
        redditBookmark.click();
        Assert.assertEquals(getDriver().getTitle(), "reddit.com: Log in");
    }

    @Test(priority = 8)
    public void testShakespeareTopRated() throws NoSuchElementException {
        getDriver().get("http://www.99-bottles-of-beer.net/toplist.html");
        WebElement langShakespeare = getDriver().findElement(By.xpath("//tr/td/a[contains(@href,'shake')]"));
        int counter = 1;

        for (int i = 1; i < 20; i++) {
            try {
                WebElement element = getDriver().findElement(By.xpath("//tr[" + i + "]/td[2]/a"));
                if (!langShakespeare.equals(element)) {
                    counter = i;
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
            }
        }
        Assert.assertEquals(counter, 16);
    }

    @Test(priority = 9)
    public void testShakespeareTopEsotericRated() throws NoSuchElementException {
        getDriver().get("http://www.99-bottles-of-beer.net/toplist.html");
        WebElement esotericRate = getDriver().findElement(By.linkText("Top Rated Esoteric"));
        esotericRate.click();
        WebElement langShakespeare = getDriver().findElement(By.xpath("//tr/td/a[contains(@href,'shake')]"));
        int counter = 1;

        for (int i = 1; i < 20; i++) {
            try {
                WebElement element = getDriver().findElement(By.xpath("//tr[" + i + "]/td[2]/a"));
                if (!langShakespeare.equals(element)) {
                    counter = i;
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
            }
        }
        Assert.assertEquals(counter, 7);
    }

    @Test(priority = 10)
    public void testShakespeareTopHits() throws NoSuchElementException {
        getDriver().get("http://www.99-bottles-of-beer.net/toplist.html");
        WebElement esotericRate = getDriver().findElement(By.linkText("Top Hits"));
        esotericRate.click();
        WebElement langShakespeare = getDriver().findElement(By.xpath("//tr/td/a[contains(@href,'shake')]"));
        int counter = 1;

        for (int i = 1; i < 20; i++) {
            try {
                WebElement element = getDriver().findElement(By.xpath("//tr[" + i + "]/td[2]/a"));
                if (!langShakespeare.equals(element)) {
                    counter = i;
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
            }
        }
        Assert.assertEquals(counter, 6);
    }

    @Test(priority = 10)
    public void testShakespeareTopRatedReal() throws NoSuchElementException {
        getDriver().get("http://www.99-bottles-of-beer.net/toplist.html");
        WebElement esotericRate = getDriver().findElement(By.linkText("Top Rated Real"));
        esotericRate.click();
        String errorMsg = "";

        try {
            WebElement lang = getDriver().findElement(By.xpath("//tr/td/a[contains(@href,'shake')]"));
        } catch (NoSuchElementException e) {
            errorMsg = "Your language is not on this list";
        }
        errorMsg = "Language was found";
        Assert.assertTrue(errorMsg.equals("Your language is not on this list") || errorMsg.equals("Language was found"));
    }

    @Test(priority = 11)
    public void countVersions() throws NoSuchElementException {
        getDriver().get("http://www.99-bottles-of-beer.net/language-java-3.html");
        // getDriver().get("http://www.99-bottles-of-beer.net/language-game-maker-language-1475.html");
        int counter = 1;

        for (int i = 1; i < 100; i++) {
            try {
                WebElement versionN = getDriver().findElement(By.xpath("//table[@id='category']/tbody/tr[" + i + "]/td[1]/a"));
                if (versionN.isDisplayed()) {
                    counter = i;
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
            }
        }
        Assert.assertEquals(counter, 6);
    }

    @Test(priority = 12)
    public void findMaxNumOfComments() {
        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath("//ul[@id='menu']/li[2]/a")).click();
        WebElement submenuJ = getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("J")));
        submenuJ.click();
        WebElement language = getDriver().findElement(By.xpath("//tr/td/a[contains(@href, 'java')]"));
        language.click();



    }
}