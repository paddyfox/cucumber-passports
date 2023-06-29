package kainos.specs.driver.producer.desktop.safari;

import kainos.specs.driver.producer.WebDriverProducer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariLocalWebDriverProducer implements WebDriverProducer {

    @Override
    public WebDriver produce() {
        return new SafariDriver();
    }
}
