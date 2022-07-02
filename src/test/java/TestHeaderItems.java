/*
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;
import runner.LibraryUtils;



public class TestHeaderItems extends BaseTest {

    @BeforeTest
    public void setUp(){
        System.out.println("lala");
    }

    @BeforeMethod
    public void getUrl(){
        getDriver().get(LibraryUtils.LIB_DEFAULT_URL);
    }

    @Ignore
    @Test (priority = 1)
    public void checkItemBooks() {
        getDriver().findElement(By.xpath(LibraryUtils.HEAD_L_ITEMS_BOOKS)).click();
        Assert.assertEquals(getDriver().getTitle(), "Electronic library. Download books free. Finding books");
    }

    @Ignore
    @Test (priority = 2)
    public void checkItemArticles(){
        getDriver().findElement(By.xpath(LibraryUtils.HEAD_L_ITEMS_ARTICLES)).click();
        Assert.assertEquals(getDriver().getTitle(), "booksc.org");
    }

    @Test (priority = 3)
    public void checkItemHome(){
        getDriver().findElement(By.xpath(LibraryUtils.HEAD_L_ITEMS_HOME)).click();
        Assert.assertEquals(getDriver().getTitle(), "Z-Library. The world's largest ebook library.");
    }


}
*/
