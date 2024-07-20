package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;

public class DriverFactory extends PropertyFilesLoader {

   public static WebDriver driver;

    public static WebDriver initiatingBrowser() throws IOException {
        try {
            String browser = GetProperty("browser");
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-popup-blocking");
//                options.addArguments("--incognito");
                options.addArguments("disable-infobars");
                options.addArguments("--disable-gpu");
                driver = new ChromeDriver(options);
            } else if (browser.equalsIgnoreCase("firfox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else {
                System.out.println("please enter right browser name");
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } catch (IOException e) {
            System.err.println("Dont have compatibilituy");
        }

        return driver;

    }

    public static WebDriver getDriver() {
        return driver;
    }

}

