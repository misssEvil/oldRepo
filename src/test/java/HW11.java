import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW11 extends BaseTest {

    @Test(priority = 1)
    public void checkTitle() {
        getDriver().get("http://www.99-bottles-of-beer.net/");
        WebElement title = getDriver().findElement(By.xpath("//div[@id='header']/h1"));
        Assert.assertEquals(title.getText(), "99 Bottles of Beer");
    }

    @Test(priority = 2)
    public void lastMenuElement() {
        getDriver().get("http://www.99-bottles-of-beer.net/");
        WebElement submitLang2 = getDriver().findElement(By.linkText("Submit new Language"));
        WebElement submitLang = getDriver().findElement(By.cssSelector("#menu > li:nth-child(6) > a"));
        Assert.assertEquals(submitLang.getText().toLowerCase(), "submit new language");
        Assert.assertEquals(submitLang2.getText(), "Submit new Language");
    }

    @Test(priority = 3)
    public void checkSubMenuElement() throws InterruptedException {
        getDriver().get("http://www.99-bottles-of-beer.net/");
        WebElement submitLang = getDriver().findElement(By.cssSelector("#menu > li:nth-child(6) > a"));
        submitLang.click();
        Thread.sleep(1000L);
        WebElement submenu = getDriver().findElement(By.linkText("Submit New Language"));
        Assert.assertEquals(submenu.getText(), "Submit New Language");
    }

    @Test(priority = 4)
    public void checkSubmenuName() {
        getDriver().get("http://www.99-bottles-of-beer.net/abc.html");
        WebElement subMenuPoint = getDriver().findElement(By.cssSelector("#submenu > li > a"));
        Assert.assertEquals(subMenuPoint.getText(), "0-9");
    }

    @Test(priority = 6)
    public void foundersNames() {
        getDriver().get("http://www.99-bottles-of-beer.net/");
        WebElement foundersNames = getDriver().findElement(By.cssSelector("#main> p:nth-child(6)"));
        Assert.assertTrue(foundersNames.getText().contains("Oliver, Gregor and Stefan"));
    }

    @Test(priority = 7)
    public void checkTeamMembers() {
        getDriver().get("http://www.99-bottles-of-beer.net/team.html");
        WebElement member1 = getDriver().findElement(By.cssSelector("#main >  h3"));
        WebElement member2 = getDriver().findElement(By.cssSelector("#main > h3:nth-child(6)"));
        WebElement member3 = getDriver().findElement(By.cssSelector("#main > h3:nth-child(9)"));
        String var10000 = member1.getText();
        Assert.assertEquals(var10000 + " " + member2.getText() + " " + member3.getText(), "Oliver Schade Gregor Scheithauer Stefan Scheler");
    }

    @Test(priority = 11)
    public void inputErrorGeneral() {
        getDriver().get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");
        WebElement submitBtn = getDriver().findElement(By.cssSelector("#main > form > p > input.button"));
        submitBtn.click();
        WebElement errorMsg = getDriver().findElement(By.cssSelector("#main > p "));
        Assert.assertEquals(errorMsg.getText(), "Error: Precondition failed - Incomplete Input.");
    }

    @Test(priority = 12)
    public void inputErrorCheckText() {
        getDriver().get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");
        WebElement submitBtn = getDriver().findElement(By.cssSelector("#main > form > p > input.button"));
        submitBtn.click();
        WebElement errorMsg = getDriver().findElement(By.cssSelector("#main > p "));
        Assert.assertTrue(errorMsg.getText().contains("-") && errorMsg.getText().contains(":"));
        Assert.assertTrue(errorMsg.getText().contains("Error"));
        Assert.assertTrue(errorMsg.getText().contains("Precondition"));
        Assert.assertTrue(errorMsg.getText().contains("Incomplete"));
        Assert.assertTrue(errorMsg.getText().contains("Input"));
        Assert.assertTrue(errorMsg.getText().contains("failed"));
    }

    @Test(priority = 13)
    public void checkWarningText() {
        getDriver().get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");
        WebElement warningText = getDriver().findElement(By.cssSelector("#main > ul > li"));
        String expectedRes = "IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name and description), the easier it will be for us and the faster your language will show up on this page. We don't have the time to mess around with fixing your descriptions etc. Thanks for your understanding.";
        Assert.assertEquals(warningText.getText(), expectedRes);
    }

    @Test(priority = 14)
    public void columnTitles() {
        getDriver().get("http://www.99-bottles-of-beer.net/");
        WebElement browseLang = getDriver().findElement(By.cssSelector("#navigation > ul > li:nth-child(2) "));
        browseLang.click();
        WebElement langColumn = getDriver().findElement(By.cssSelector("table#category > tbody > tr > th"));
        WebElement authorColumn = getDriver().findElement(By.cssSelector("table#category > tbody > tr > th:nth-child(2)"));
        Assert.assertEquals(langColumn.getText(), "Language");
        Assert.assertEquals(authorColumn.getText(), "Author");
    }

    @Test(priority = 15)
    public void checkNoNewComments() {
        getDriver().get("http://www.99-bottles-of-beer.net/");
        WebElement topListMenu = getDriver().findElement(By.cssSelector("ul#menu > li:nth-child(4) > a"));
        topListMenu.click();
        WebElement newCommentsSubmenu = getDriver().findElement(By.cssSelector("ul#submenu > li:nth-child(7)"));
        newCommentsSubmenu.click();
        WebElement list = getDriver().findElement(By.xpath("//div[@id=\"main\"]"));
        Assert.assertEquals(list.getText(), "New Comments\n{LIST}");
    }

    @Test(priority = 21)
    public void checkTextAttributes() {
        getDriver().get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");
        WebElement iImportant = getDriver().findElement(By.cssSelector("div#main > ul > li > span"));
        Assert.assertTrue(iImportant.getAttribute("style").equals("background-color: red; color: white;") && iImportant.getText().equals("IMPORTANT:"));
    }
}
