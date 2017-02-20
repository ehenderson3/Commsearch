package CommTests;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;



/**
 * Base class for the tests.
 */
public class BaseTest implements Config {

    protected WebDriver driver;

    //junit rule
    @Rule
    public ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            if (host.equals("browserstack")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browser", browser);
                capabilities.setCapability("browser_version", browserVersion);
                capabilities.setCapability("os", platform);
                capabilities.setCapability("os_version", os_version);
                capabilities.setCapability("browserstack.debug", "true");
                String browserStackUrl = String.format("https://browserstack624:y5XpN57x7g4QQrMHqNVK@hub-cloud.browserstack.com/wd/hub");
                driver = new RemoteWebDriver(new URL(browserStackUrl), capabilities);
            } else if (host.equals("localhost")) {
                if (browser.equals("firefox")) {
                    System.setProperty("webdriver.wires.driver",
                            System.getProperty("user.dir") + "/vendor/wires.exe");
                    driver = new FirefoxDriver();
                } else if (browser.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver",
                            System.getProperty("user.dir") + "/vendor/chromedriver.exe");
                    driver = new ChromeDriver();
                }
            }
        }


        @Override
        protected void after() {
            driver.quit();

        }
    };

}
