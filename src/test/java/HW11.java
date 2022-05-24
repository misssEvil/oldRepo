import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW11 extends BaseTest {

    @Test(priority = 1)
    public void checkTitle() {
        this.getDriver().get("http://www.99-bottles-of-beer.net/");
        WebElement title = this.getDriver().findElement(By.xpath("//div[@id='header']/h1"));
        Assert.assertEquals(title.getText(), "99 Bottles of Beer");
    }

    @Test(priority = 2)
    public void lastMenuElement() {
        this.getDriver().get("http://www.99-bottles-of-beer.net/");
        WebElement submitLang2 = this.getDriver().findElement(By.linkText("Submit new Language"));
        WebElement submitLang = this.getDriver().findElement(By.cssSelector("#menu > li:nth-child(6) > a"));
        Assert.assertEquals(submitLang.getText().toLowerCase(), "submit new language");
        Assert.assertEquals(submitLang2.getText(), "Submit new Language");
    }

    @Test(priority = 3)
    public void checkSubMenuElement() throws InterruptedException {
        this.getDriver().get("http://www.99-bottles-of-beer.net/");
        WebElement submitLang = this.getDriver().findElement(By.cssSelector("#menu > li:nth-child(6) > a"));
        submitLang.click();
        Thread.sleep(1000L);
        WebElement submenu = this.getDriver().findElement(By.linkText("Submit New Language"));
        Assert.assertEquals(submenu.getText(), "Submit New Language");
    }

    @Test(priority = 4)
    public void checkSubmenuName() {
        this.getDriver().get("http://www.99-bottles-of-beer.net/abc.html");
        WebElement subMenuPoint = this.getDriver().findElement(By.cssSelector("#submenu > li > a"));
        Assert.assertEquals(subMenuPoint.getText(), "0-9");
    }

    @Test(priority = 6)
    public void foundersNames() {
        this.getDriver().get("http://www.99-bottles-of-beer.net/");
        WebElement foundersNames = this.getDriver().findElement(By.cssSelector("#main> p:nth-child(6)"));
        Assert.assertTrue(foundersNames.getText().contains("Oliver, Gregor and Stefan"));
    }

    @Test(priority = 7)
    public void checkTeamMembers() {
        this.getDriver().get("http://www.99-bottles-of-beer.net/team.html");
        WebElement member1 = this.getDriver().findElement(By.cssSelector("#main >  h3"));
        WebElement member2 = this.getDriver().findElement(By.cssSelector("#main > h3:nth-child(6)"));
        WebElement member3 = this.getDriver().findElement(By.cssSelector("#main > h3:nth-child(9)"));
        String var10000 = member1.getText();
        Assert.assertEquals(var10000 + " " + member2.getText() + " " + member3.getText(), "Oliver Schade Gregor Scheithauer Stefan Scheler");
    }

    @Test(priority = 11)
    public void inputErrorGeneral() {
        this.getDriver().get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");
        WebElement submitBtn = this.getDriver().findElement(By.cssSelector("#main > form > p > input.button"));
        submitBtn.click();
        WebElement errorMsg = this.getDriver().findElement(By.cssSelector("#main > p "));
        Assert.assertEquals(errorMsg.getText(), "Error: Precondition failed - Incomplete Input.");
    }

    @Test(priority = 12)
    public void inputErrorCheckText() {
        this.getDriver().get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");
        WebElement submitBtn = this.getDriver().findElement(By.cssSelector("#main > form > p > input.button"));
        submitBtn.click();
        WebElement errorMsg = this.getDriver().findElement(By.cssSelector("#main > p "));
        Assert.assertTrue(errorMsg.getText().contains("-") && errorMsg.getText().contains(":"));
        Assert.assertTrue(errorMsg.getText().contains("Error"));
        Assert.assertTrue(errorMsg.getText().contains("Precondition"));
        Assert.assertTrue(errorMsg.getText().contains("Incomplete"));
        Assert.assertTrue(errorMsg.getText().contains("Input"));
        Assert.assertTrue(errorMsg.getText().contains("failed"));
    }

    @Test(priority = 13)
    public void checkWarningText() {
        this.getDriver().get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");
        WebElement warningText = this.getDriver().findElement(By.cssSelector("#main > ul > li"));
        String expectedRes = "IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name and description), the easier it will be for us and the faster your language will show up on this page. We don't have the time to mess around with fixing your descriptions etc. Thanks for your understanding.";
        Assert.assertEquals(warningText.getText(), expectedRes);
    }

    @Test(priority = 14)
    public void columnTitles() {
        this.getDriver().get("http://www.99-bottles-of-beer.net/");
        WebElement browseLang = this.getDriver().findElement(By.cssSelector("#navigation > ul > li:nth-child(2) "));
        browseLang.click();
        WebElement langColumn = this.getDriver().findElement(By.cssSelector("table#category > tbody > tr > th"));
        WebElement authorColumn = this.getDriver().findElement(By.cssSelector("table#category > tbody > tr > th:nth-child(2)"));
        Assert.assertEquals(langColumn.getText(), "Language");
        Assert.assertEquals(authorColumn.getText(), "Author");
    }

    @Test(priority = 15)
    public void checkNoNewComments() {
        this.getDriver().get("http://www.99-bottles-of-beer.net/");
        WebElement topListMenu = this.getDriver().findElement(By.cssSelector("ul#menu > li:nth-child(4) > a"));
        topListMenu.click();
        WebElement newCommentsSubmenu = this.getDriver().findElement(By.cssSelector("ul#submenu > li:nth-child(7)"));
        newCommentsSubmenu.click();
        WebElement list = this.getDriver().findElement(By.xpath("//div[@id=\"main\"]"));
        Assert.assertEquals(list.getText(), "New Comments\n{LIST}");
    }

    @Test(priority = 21)
    public void checkTextAttributes() {
        this.getDriver().get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");
        WebElement iImportant = this.getDriver().findElement(By.cssSelector("div#main > ul > li > span"));
        Assert.assertTrue(iImportant.getAttribute("style").equals("background-color: red; color: white;") && iImportant.getText().equals("IMPORTANT:"));
    }
}
