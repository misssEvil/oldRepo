package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class BaseTestUtils {

    private static Properties properties;
    private static final ChromeOptions chromeOptions;

     private static void initProperties() {
         if (properties == null){
             properties = new Properties();
             if (isServerRun()){
                 properties.getProperty("default.chrome_options", System.getenv("chrome_options"));
             }
             else {
                 try {
                     InputStream inputStream = BaseTestUtils.class.getClassLoader().getResourceAsStream("local.properties");
                     properties.load(inputStream);
                 } catch (IOException ex) {

                 }
             }
         }
     }

    static boolean isServerRun() {
        return System.getenv("CI_RUN") != null;
    }

     static {
         initProperties();

         chromeOptions = new ChromeOptions();
         String options = properties.getProperty("default.chrome_options");
         if (options != null){
             for (String argument : options.split(";")){
                 chromeOptions.addArguments(argument);
             }
         }
         WebDriverManager.chromedriver().setup();
     }



    static WebDriver createDriver() {

        WebDriver driver = new ChromeDriver(chromeOptions);
        return driver;
    }

    static Properties getProperties(){
         return properties;

    }




}
