package kainos.specs.driver.producer.desktop.ie;

import kainos.specs.driver.producer.BaseRemoteDriver;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import kainos.specs.driver.GridUtils;
import kainos.specs.driver.producer.WebDriverProducer;

public class IERemoteWebDriverProducer extends BaseRemoteDriver implements WebDriverProducer {

    @Override
    public WebDriver produce() {
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.ignoreZoomSettings();
        internetExplorerOptions.requireWindowFocus();
        internetExplorerOptions.destructivelyEnsureCleanSession();
        internetExplorerOptions.disableNativeEvents();
        internetExplorerOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (BROWSER_VERSION != null) {
            internetExplorerOptions.setCapability("browserVersion", BROWSER_VERSION);
        }
        if (getBrowserstackOptions() != null) {
            internetExplorerOptions.setCapability("bstack:options", getBrowserstackOptions());
        }
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(GridUtils.getSeleniumGridURL(), internetExplorerOptions);
        remoteWebDriver.setFileDetector(new LocalFileDetector());

        return remoteWebDriver;
    }
}
