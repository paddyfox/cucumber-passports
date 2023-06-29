package kainos.specs.driver.producer.desktop.chrome;

import io.github.bonigarcia.wdm.WebDriverManager;

import kainos.specs.driver.producer.BaseLocalDriver;
import kainos.specs.driver.producer.WebDriverProducer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeEmulatedLocalWebDriverProducer extends BaseLocalDriver implements WebDriverProducer {

    @Override
    public WebDriver produce() {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        if (BROWSER_VERSION != null) {
            WebDriverManager.chromedriver().browserVersion(BROWSER_VERSION).setup();
        } else {
            WebDriverManager.chromedriver().setup();
        }

        return new ChromeDriver(chromeOptions);
    }
}
