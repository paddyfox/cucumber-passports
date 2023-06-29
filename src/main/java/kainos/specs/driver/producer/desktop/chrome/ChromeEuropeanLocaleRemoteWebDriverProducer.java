package kainos.specs.driver.producer.desktop.chrome;

import kainos.specs.driver.GridUtils;
import kainos.specs.driver.producer.BaseRemoteDriver;
import kainos.specs.driver.producer.WebDriverProducer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeEuropeanLocaleRemoteWebDriverProducer extends BaseRemoteDriver implements WebDriverProducer {

    @Override
    public WebDriver produce() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("env", new String[]{"LANG=pt_PT.UTF-8", "LANGUAGE=pt_PT:en", "LC_ALL=pt_PT.UTF-8"});
        if (BROWSER_VERSION != null) {
            chromeOptions.setCapability("browserVersion", BROWSER_VERSION);
        }
        if (getBrowserstackOptions() != null) {
            chromeOptions.setCapability("bstack:options", getBrowserstackOptions());
        }
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(GridUtils.getSeleniumGridURL(), chromeOptions);
        remoteWebDriver.setFileDetector(new LocalFileDetector());

        return remoteWebDriver;
    }
}
