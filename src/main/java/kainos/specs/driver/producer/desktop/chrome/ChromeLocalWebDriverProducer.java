package kainos.specs.driver.producer.desktop.chrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import kainos.specs.driver.producer.BaseLocalDriver;
import kainos.specs.driver.producer.WebDriverProducer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeLocalWebDriverProducer extends BaseLocalDriver implements WebDriverProducer {

    @Override
    public WebDriver produce() {
        if (BROWSER_VERSION != null) {
            WebDriverManager.chromedriver().browserVersion(BROWSER_VERSION).setup();
        } else {
            WebDriverManager.chromedriver().setup();
        }

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(options);
    }
}
