package kainos.specs.driver.producer.desktop.edge;

import kainos.specs.driver.producer.BaseRemoteDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import kainos.specs.driver.GridUtils;
import kainos.specs.driver.producer.WebDriverProducer;

public class EdgeRemoteWebDriverProducer extends BaseRemoteDriver implements WebDriverProducer {

    @Override
    public WebDriver produce() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("env", new String[]{"LANG=en_GB.UTF-8", "LANGUAGE=en_GB:en", "LC_ALL=en_GB.UTF-8"});
        edgeOptions.setCapability("w3c", true);
        edgeOptions.setCapability("acceptInsecureCerts", true);
        edgeOptions.setCapability("ensureCleanSession", true);
        edgeOptions.setCapability("ignoreZoomSetting", true);
        edgeOptions.setCapability("ignoreProtectedModeSettings", true);
        edgeOptions.setCapability("ignore-certificate-error", true);
        edgeOptions.setCapability("acceptSslCerts", "true");

        if (BROWSER_VERSION != null) {
            edgeOptions.setCapability("browserVersion", BROWSER_VERSION);
        }

        if (getBrowserstackOptions() != null) {
            edgeOptions.setCapability("bstack:options", getBrowserstackOptions());
        }

        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(GridUtils.getSeleniumGridURL(), edgeOptions);
        remoteWebDriver.setFileDetector(new LocalFileDetector());

        return remoteWebDriver;
    }
}
