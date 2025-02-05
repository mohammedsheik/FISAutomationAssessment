package factory;

import common.PropertyManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    public static WebDriver createDriver() throws IOException {
        String browser = System.getProperty("browser","chrome");
        String mode = System.getProperty("mode","Local");

        if(mode.equals("Remote")){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            String HUB_URL = PropertyManager.getPropertiesInstance().getProperty("HUB_URL");
            return new RemoteWebDriver(new URL(HUB_URL),capabilities);
        }else{
            WebDriver driver;
            if (browser.equals("firefox")) {
                driver  = new FirefoxDriver();
            }else{
                driver =  new ChromeDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            //driver.manage().window().setSize(new Dimension(1200,1800));
            return driver;
        }
    }
}
