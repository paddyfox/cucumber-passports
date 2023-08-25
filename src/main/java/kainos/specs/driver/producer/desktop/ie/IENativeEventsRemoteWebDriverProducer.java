package kainos.specs.driver.producer.desktop.ie;

import kainos.specs.driver.GridUtils;
import kainos.specs.driver.producer.WebDriverProducer;
import kainos.specs.properties.CommonProperties;
import kainos.specs.properties.PropertyLoader;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;

public class IENativeEventsRemoteWebDriverProducer implements WebDriverProducer {

    private static final String PLATFORM = PropertyLoader.getProperty(CommonProperties.BROWSER_PLATFORM);
    private static final String PLATFORM_VERSION = PropertyLoader.getProperty(CommonProperties.BROWSER_PLATFORM_VERSION);

    @Override
    public WebDriver produce() {
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.ignoreZoomSettings();
        internetExplorerOptions.requireWindowFocus();
        internetExplorerOptions.destructivelyEnsureCleanSession();
        internetExplorerOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (PLATFORM != null || PLATFORM_VERSION != null) {
            HashMap<String, Object> browserstackOptions = new HashMap<>();
            if (PLATFORM != null) {
                browserstackOptions.put("os", PLATFORM);
            }
            if (PLATFORM_VERSION != null) {
                browserstackOptions.put("osVersion", PLATFORM_VERSION);
            }
            browserstackOptions.put("local", "false");
            internetExplorerOptions.setCapability("bstack:options", browserstackOptions);
        }
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(GridUtils.getSeleniumGridURL(), internetExplorerOptions);
        remoteWebDriver.setFileDetector(new LocalFileDetector());

        return remoteWebDriver;
    }
}
