package kainos.specs.driver.producer.desktop.firefox;

import kainos.specs.driver.GridUtils;
import kainos.specs.driver.producer.WebDriverProducer;
import kainos.specs.properties.CommonProperties;
import kainos.specs.properties.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;

public class FirefoxRemoteDebugWebDriverProducer implements WebDriverProducer {

    private static final String PLATFORM = PropertyLoader.getProperty(CommonProperties.BROWSER_PLATFORM);
    private static final String PLATFORM_VERSION = PropertyLoader.getProperty(CommonProperties.BROWSER_PLATFORM_VERSION);

    @Override
    public WebDriver produce() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("dom.ipc.plugins.enabled.libflashplayer.so", "true");
        firefoxOptions.setLogLevel(FirefoxDriverLogLevel.TRACE);
        firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        if (PLATFORM != null || PLATFORM_VERSION != null) {
            HashMap<String, Object> browserstackOptions = new HashMap<>();
            if (PLATFORM != null) {
                browserstackOptions.put("os", PLATFORM);
            }
            if (PLATFORM_VERSION != null) {
                browserstackOptions.put("osVersion", PLATFORM_VERSION);
            }
            browserstackOptions.put("local", "false");
            firefoxOptions.setCapability("bstack:options", browserstackOptions);
        }
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(GridUtils.getSeleniumGridURL(), firefoxOptions);
        remoteWebDriver.setFileDetector(new LocalFileDetector());

        return remoteWebDriver;
    }
}
