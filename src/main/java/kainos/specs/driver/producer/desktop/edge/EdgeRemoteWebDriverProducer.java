package kainos.specs.driver.producer.desktop.edge;

import kainos.specs.driver.GridUtils;
import kainos.specs.driver.producer.BaseRemoteDriver;
import kainos.specs.driver.producer.WebDriverProducer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EdgeRemoteWebDriverProducer extends BaseRemoteDriver implements WebDriverProducer {

    @Override
    public WebDriver produce() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("acceptInsecureCerts", true);
        edgeOptions.addArguments("--disable-site-isolation-trials");

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
