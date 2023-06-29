package kainos.specs.driver.producer.desktop.safari;

import kainos.specs.driver.GridUtils;
import kainos.specs.driver.producer.BaseRemoteDriver;
import kainos.specs.driver.producer.WebDriverProducer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariRemoteWebDriverProducer extends BaseRemoteDriver implements WebDriverProducer {

    @Override
    public WebDriver produce() {
        SafariOptions safariOptions = new SafariOptions();
        if (BROWSER_VERSION != null) {
            safariOptions.setCapability("browserVersion", BROWSER_VERSION);
        }
        if (getBrowserstackOptions() != null) {
            safariOptions.setCapability("bstack:options", getBrowserstackOptions());
        }
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(GridUtils.getSeleniumGridURL(), safariOptions);
        remoteWebDriver.setFileDetector(new LocalFileDetector());

        return remoteWebDriver;
    }
}
