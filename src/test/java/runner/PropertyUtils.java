package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
    private static final String ENV_CHROME_OPTIONS = "CHROME_OPTIONS";

    static final String PREFIX_PROP = "default.";

    private static final String PROP_CHROME_OPTIONS = PREFIX_PROP + ENV_CHROME_OPTIONS.toLowerCase();

    private static Properties properties;

    private static void initProperties() {
        properties = new Properties();
       if (System.getenv("CI_RUN") != null) {
                properties.setProperty("default.chrome_options", System.getenv("CHROME_OPTIONS"));

                for (String option : System.getenv("APP_OPTIONS").split(";")) {
                    String[] optionArr = option.split("=");
                    properties.setProperty("default." + optionArr[0], optionArr[1]);
                }
            } else {
                try {
                    InputStream inputStream = PropertyUtils.class.getClassLoader().getResourceAsStream("local.properties");
                    if (inputStream == null) {
                        System.out.println("You need to create local.properties file");
                        System.exit(1);
                    }
                    properties.load(inputStream);
                } catch (IOException ignore) {}
            }
        }



    protected static final ChromeOptions chromeOptions;
    static {
        initProperties();
        chromeOptions = new ChromeOptions();
        String options = properties.getProperty("default.chrome_options");
        if (options != null) {
            for (String argument : options.split(";")) {
                chromeOptions.addArguments(argument);
            }
        }
    }

    public static Properties getProperties() {
        return properties;
    }


}
