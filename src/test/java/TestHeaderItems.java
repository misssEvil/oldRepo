import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;
import runner.LibraryUtils;


public class TestHeaderItems extends BaseTest {

    @Test
    public void checkItemBooks() {
        getDriver().get("https://1lib.tw");
        getDriver().findElement(By.xpath(LibraryUtils.HEAD_L_ITEMS_BOOKS)).click();
        Assert.assertEquals(getDriver().getTitle(), "Electronic library. Download books free. Finding books");
    }

    @Test
    public void checkItemHome(){
        getDriver().get("https://1lib.tw");
        getDriver().findElement(By.xpath(LibraryUtils.HEAD_L_ITEMS_HOME)).click();
        Assert.assertEquals(getDriver().getTitle(), "Z-Library. The world's largest ebook library.");
    }
}
