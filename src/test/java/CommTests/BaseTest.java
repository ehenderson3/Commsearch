package CommTests;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
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
                capabilities.setCapability("resolution", resolution);
                capabilities.setCapability("browserstack.debug", "true");

                String browserStackUrl = String.format("https://browserstack624:y5XpN57x7g4QQrMHqNVK@hub-cloud.browserstack.com/wd/hub");
                driver = new RemoteWebDriver(new URL(browserStackUrl), capabilities);
            } else if (host.equals("localhost")) {
                if (browser.equals("firefox")) {

                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/BrowserDrivers/geckodriver.exe");
                    DesiredCapabilities cap = DesiredCapabilities.firefox();
                    cap.setCapability("marionette", true);
                    driver = new MarionetteDriver(cap);

                } else if (browser.equals("chrome")) {
                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--incognito");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    System.setProperty("webdriver.chrome.driver",
                            System.getProperty("user.dir") + "/vendor/chromedriver.exe");
                   driver = new ChromeDriver(capabilities);
                } else if (browser.equals("IE")){
                    DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

                    ieCapabilities.setCapability("nativeEvents", false);
                    ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
                    ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
                    ieCapabilities.setCapability("disable-popup-blocking", true);
                    ieCapabilities.setCapability("enablePersistentHover", true);
                    File file = new File("C:/AutomationFrameWorks/CommMaster/comsearch-ui-tests/vendor/IEDriverServer.exe");
                    System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                    driver = new InternetExplorerDriver(ieCapabilities);

                }
            }
        }


        @Override
        protected void after() {
            driver.quit();

        }
    };

}
