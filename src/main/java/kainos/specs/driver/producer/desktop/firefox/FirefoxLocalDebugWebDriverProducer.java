package kainos.specs.driver.producer.desktop.firefox;

import io.github.bonigarcia.wdm.WebDriverManager;
import kainos.specs.driver.producer.BaseLocalDriver;
import kainos.specs.driver.producer.WebDriverProducer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class FirefoxLocalDebugWebDriverProducer extends BaseLocalDriver implements WebDriverProducer {

    @Override
    public WebDriver produce() {
        if (BROWSER_VERSION != null) {
            WebDriverManager.firefoxdriver().browserVersion(BROWSER_VERSION).setup();
        } else {
            WebDriverManager.firefoxdriver().setup();
        }
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        firefoxOptions.setLogLevel(FirefoxDriverLogLevel.TRACE);

        return new FirefoxDriver(firefoxOptions);
    }
}
