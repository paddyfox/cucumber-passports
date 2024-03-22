package kainos.specs.driver.producer.appium;

import io.appium.java_client.AppiumDriver;
import kainos.specs.driver.GridUtils;
import kainos.specs.driver.producer.BaseRemoteDriver;
import kainos.specs.driver.producer.WebDriverProducer;
import kainos.specs.properties.AppiumMobileProperties;
import kainos.specs.properties.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;

import java.util.HashMap;

public class AppiumMobileWebDriverProducer extends BaseRemoteDriver implements WebDriverProducer {

    @Override
    public WebDriver produce() {
        String browserName = PropertyLoader.getProperty(AppiumMobileProperties.BROWSER_NAME);
        String platformName = PropertyLoader.getProperty(AppiumMobileProperties.PLATFORM_NAME);
        String osVersion = PropertyLoader.getProperty(AppiumMobileProperties.OS_VERSION);
        String deviceName = PropertyLoader.getProperty(AppiumMobileProperties.DEVICE_NAME);
        String appiumVersion = PropertyLoader.getProperty(AppiumMobileProperties.APPIUM_VERSION) != null ?
                PropertyLoader.getProperty(AppiumMobileProperties.APPIUM_VERSION) : "1.17.0";

        DesiredCapabilities caps = new DesiredCapabilities();
        HashMap<String, Object> browserstackOptions = new HashMap<>(getBrowserstackOptions());

        browserstackOptions.put("realMobile", "true");
        browserstackOptions.put("appiumVersion", appiumVersion);
        browserstackOptions.put("local", "true");

        browserstackOptions.put("device", deviceName);
        if (osVersion != null) {
            browserstackOptions.put("osVersion", osVersion);
        }
        if (browserName != null) {
            caps.setBrowserName(browserName);
        }
        if (platformName != null) {
            caps.setBrowserName(platformName);
        }
        caps.setCapability("bstack:options", browserstackOptions);
        caps.setCapability("realMobile", "true");
        caps.setCapability("acceptSslCerts", "true");
        AppiumDriver remoteWebDriver = new AppiumDriver(GridUtils.getSeleniumGridURL(), caps);
        remoteWebDriver.setFileDetector(new LocalFileDetector());

        return remoteWebDriver;
    }
}