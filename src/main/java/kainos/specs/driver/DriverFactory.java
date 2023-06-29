package kainos.specs.driver;

import kainos.specs.driver.producer.WebDriverProducer;
import kainos.specs.driver.producer.appium.AppiumMobileWebDriverProducer;
import kainos.specs.driver.producer.desktop.chrome.*;
import kainos.specs.driver.producer.desktop.edge.EdgeLocalWebDriverProducer;
import kainos.specs.driver.producer.desktop.edge.EdgeRemoteWebDriverProducer;
import kainos.specs.driver.producer.desktop.firefox.*;
import kainos.specs.driver.producer.desktop.ie.IELocalWebDriverProducer;
import kainos.specs.driver.producer.desktop.ie.IENativeEventsRemoteWebDriverProducer;
import kainos.specs.driver.producer.desktop.ie.IERemoteWebDriverProducer;
import kainos.specs.driver.producer.desktop.safari.SafariLocalWebDriverProducer;
import kainos.specs.driver.producer.desktop.safari.SafariRemoteWebDriverProducer;
import kainos.specs.driver.producer.desktop.safari.SafariTechPreviewLocalWebDriverProducer;
import kainos.specs.driver.producer.desktop.safari.SafariTechPreviewRemoteWebDriverProducer;
import kainos.specs.driver.producer.desktop.windows.WindowsTenRemoteDriverProducer;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DriverFactory {

    private static final Map<BrowserType, WebDriverProducer> producers = new HashMap<>();

    static {
        producers.put(BrowserType.ChromeLocal, new ChromeLocalWebDriverProducer());
        producers.put(BrowserType.ChromeLocalNoSandbox, new ChromeLocalNoSandboxWebDriverProducer());
        producers.put(BrowserType.ChromeRemote, new ChromeRemoteWebDriverProducer());
        producers.put(BrowserType.ChromeMobileEmulationLocal, new ChromeEmulatedLocalWebDriverProducer());
        producers.put(BrowserType.ChromeMobileEmulationRemote, new ChromeEmulatedRemoteWebDriverProducer());
        producers.put(BrowserType.ChromeEuropeanLocaleRemote, new ChromeEuropeanLocaleRemoteWebDriverProducer());
        producers.put(BrowserType.AppiumWindowsTenRemote, new WindowsTenRemoteDriverProducer());
        producers.put(BrowserType.AppiumMobile, new AppiumMobileWebDriverProducer());
        producers.put(BrowserType.EdgeLocal, new EdgeLocalWebDriverProducer());
        producers.put(BrowserType.EdgeRemote, new EdgeRemoteWebDriverProducer());
        producers.put(BrowserType.FirefoxLocal, new FirefoxLocalWebDriverProducer());
        producers.put(BrowserType.FirefoxLocalDebug, new FirefoxLocalDebugWebDriverProducer());
        producers.put(BrowserType.FirefoxRemote, new FirefoxRemoteWebDriverProducer());
        producers.put(BrowserType.FirefoxEagerLoadRemote, new FirefoxEagerLoadRemoteWebDriverProducer());
        producers.put(BrowserType.FirefoxRemoteDebug, new FirefoxRemoteDebugWebDriverProducer());
        producers.put(BrowserType.InternetExplorerLocal, new IELocalWebDriverProducer());
        producers.put(BrowserType.InternetExplorerNativeEventsRemote, new IENativeEventsRemoteWebDriverProducer());
        producers.put(BrowserType.InternetExplorerRemote, new IERemoteWebDriverProducer());
        producers.put(BrowserType.SafariLocal, new SafariLocalWebDriverProducer());
        producers.put(BrowserType.SafariRemote, new SafariRemoteWebDriverProducer());
        producers.put(BrowserType.SafariTechPreviewLocal, new SafariTechPreviewLocalWebDriverProducer());
        producers.put(BrowserType.SafariTechPreviewRemote, new SafariTechPreviewRemoteWebDriverProducer());
    }

    private final BrowserType browserType;

    DriverFactory(String browserTypeName) {
        browserType = BrowserType.valueOf(browserTypeName);
        log.info("Browser type: " + browserType + " has been set in the Driver Factory on thread " + Thread.currentThread().getName());
    }

    WebDriver createInstance() {
        return producers.get(browserType).produce();
    }

}
