package kainos.specs.driver.producer.desktop.chrome;

import kainos.specs.driver.producer.BaseRemoteDriver;
import kainos.specs.driver.producer.WebDriverProducer;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ChromeRemoteWebDriverProducer extends BaseRemoteDriver implements WebDriverProducer {

    @Override
    public WebDriver produce() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("acceptInsecureCerts", true);
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--safebrowsing-disable-download-protection");
        chromeOptions.addArguments("--disable-site-isolation-trials");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("safebrowsing.enabled", "true");
        chromeOptions.setExperimentalOption("prefs", prefs);

        if (BROWSER_VERSION != null) {
            chromeOptions.setCapability("browserVersion", BROWSER_VERSION);
        }

        if (getBrowserstackOptions() != null) {
            chromeOptions.setCapability("bstack:options", getBrowserstackOptions());
        }

        String browserstackUrl = "https://" + "paddyfox2" + ":" + "uXpqTEuyixvxxzWAKpJm" + "@hub.browserstack.com/wd/hub";
        MutableCapabilities capabilities = new MutableCapabilities();
        RemoteWebDriver remoteWebDriver = null;
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(browserstackUrl), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        remoteWebDriver.setFileDetector(new LocalFileDetector());

        return remoteWebDriver;
    }
}
