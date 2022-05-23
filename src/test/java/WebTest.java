import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebTest {

    private WebDriver driver;

    public static final String BASE_URL = "http://www.99-bottles-of-beer.net/";
    public static final String SUBMIT_NEW_LANG_URL = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
    public static final String CHROME_DRIVER = "webdriver.chrome.driver";
    public static final String DRIVER_PATH = "C://chromedriver_win32/chromedriver.exe";


    @BeforeTest
    public void driverSetUp(){
        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        driver = new ChromeDriver();
    }


    @Test (priority = 1)
    public void checkTitle(){
        driver.get(BASE_URL);
        WebElement title = driver.findElement(By.xpath("//div[@id='header']/h1"));
        Assert.assertEquals(title.getText(), "99 Bottles of Beer");
    }

    @Test (priority = 2)
    public void lastMenuElement(){
        driver.get(BASE_URL);
        //<a href="/submitnewlanguage.html">Submit new Language</a>
        WebElement submitLang2 = driver.findElement(By.linkText("Submit new Language"));
        WebElement submitLang = driver.findElement(By.cssSelector("#menu > li:nth-child(6) > a"));
        Assert.assertEquals(submitLang.getText().toLowerCase(), "submit new language");
        Assert.assertEquals(submitLang2.getText(), "Submit new Language");
    }

    @Test (priority = 3)
    public void checkSubMenuElement() throws InterruptedException {
        driver.get(BASE_URL);
        WebElement submitLang = driver.findElement(By.cssSelector("#menu > li:nth-child(6) > a"));
        submitLang.click();
        // WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id<locator>));
        Thread.sleep(1000);
        WebElement submenu = driver.findElement(By.linkText("Submit New Language")); //#submenu > li
        Assert.assertEquals(submenu.getText(), "Submit New Language");
    }

    @Test (priority = 4)
    public void checkSubmenuName(){
        driver.get("http://www.99-bottles-of-beer.net/abc.html");
        WebElement subMenuPoint = driver.findElement(By.cssSelector("#submenu > li > a"));
        Assert.assertEquals(subMenuPoint.getText(), "0-9");
    }

    @Test (priority = 6)
    public void foundersNames(){
        driver.get(BASE_URL);
        WebElement foundersNames = driver.findElement(By.cssSelector("#main> p:nth-child(6)"));
        Assert.assertTrue(foundersNames.getText().contains("Oliver, Gregor and Stefan"));
    }

    @Test (priority = 7)
    public void checkTeamMembers(){
        driver.get("http://www.99-bottles-of-beer.net/team.html");
        WebElement member1 = driver.findElement(By.cssSelector("#main >  h3"));
        WebElement member2 = driver.findElement(By.cssSelector("#main > h3:nth-child(6)"));
        WebElement member3 = driver.findElement(By.cssSelector("#main > h3:nth-child(9)"));
        Assert.assertEquals(member1.getText() + " " + member2.getText()  + " " + member3.getText(), "Oliver Schade Gregor Scheithauer Stefan Scheler");
    }

    @Test (priority = 11)
    public void inputErrorGeneral(){
        driver.get(SUBMIT_NEW_LANG_URL);
        WebElement submitBtn = driver.findElement(By.cssSelector("#main > form > p > input.button"));
        submitBtn.click();
        WebElement errorMsg = driver.findElement(By.cssSelector("#main > p "));
        Assert.assertEquals(errorMsg.getText(), "Error: Precondition failed - Incomplete Input.");
    }

    @Test (priority = 12)
    public void inputErrorCheckText(){
        driver.get(SUBMIT_NEW_LANG_URL);
        WebElement submitBtn = driver.findElement(By.cssSelector("#main > form > p > input.button"));
        submitBtn.click();
        WebElement errorMsg = driver.findElement(By.cssSelector("#main > p "));
       // Assert.assertEquals(errorMsg.getText(), "Error: Precondition failed - Incomplete Input.");
        Assert.assertTrue(errorMsg.getText().contains("-") && errorMsg.getText().contains(":"));
        Assert.assertTrue(errorMsg.getText().contains("Error"));
        Assert.assertTrue(errorMsg.getText().contains("Precondition"));
        Assert.assertTrue(errorMsg.getText().contains("Incomplete"));
        Assert.assertTrue(errorMsg.getText().contains("Input"));
        Assert.assertTrue(errorMsg.getText().contains("failed"));
    }

    @Test (priority = 13)
    public void checkWarningText(){
        driver.get(SUBMIT_NEW_LANG_URL);
        WebElement warningText = driver.findElement(By.cssSelector("#main > ul > li"));
        String expectedRes = "IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name and description), the easier it will be for us and the faster your language will show up on this page. We don't have the time to mess around with fixing your descriptions etc. Thanks for your understanding.";
        Assert.assertEquals(warningText.getText(), expectedRes);
    }

    @Test (priority = 14)
    public void columnTitles(){
        driver.get(BASE_URL);
        WebElement browseLang = driver.findElement(By.cssSelector("#navigation > ul > li:nth-child(2) "));
        browseLang.click();
        WebElement langColumn = driver.findElement(By.cssSelector("table#category > tbody > tr > th"));
        WebElement authorColumn = driver.findElement(By.cssSelector("table#category > tbody > tr > th:nth-child(2)"));
        Assert.assertEquals(langColumn.getText(), "Language");
        Assert.assertEquals(authorColumn.getText(), "Author");
    }

    @Test (priority = 15)
    public void checkNoNewComments(){
        driver.get(BASE_URL);

        WebElement topListMenu = driver.findElement(By.cssSelector("ul#menu > li:nth-child(4) > a"));
        topListMenu.click();
        WebElement newCommentsSubmenu = driver.findElement(By.cssSelector("ul#submenu > li:nth-child(7)"));
        newCommentsSubmenu.click();
        WebElement list = driver.findElement(By.xpath("//div[@id=\"main\"]")); //*[@id="main"]/text()

        Assert.assertEquals(list.getText(), "New Comments\n" +"{LIST}");
    }

    @Test (priority = 21)
    public void checkTextAttributes(){
        driver.get(SUBMIT_NEW_LANG_URL);
        WebElement iImportant = driver.findElement(By.cssSelector("div#main > ul > li > span"));  //div[@id= 'main']/ul/li/span
        Assert.assertTrue(iImportant.getAttribute("style").equals("background-color: red; color: white;") && iImportant.getText().equals("IMPORTANT:"));
    }


    @AfterMethod
    public void closeWindow(){
        driver.quit();
    }
}
