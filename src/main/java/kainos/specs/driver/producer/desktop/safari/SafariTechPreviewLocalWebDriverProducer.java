package kainos.specs.driver.producer.desktop.safari;

import kainos.specs.driver.producer.WebDriverProducer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariTechPreviewLocalWebDriverProducer implements WebDriverProducer {

    @Override
    public WebDriver produce() {
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setUseTechnologyPreview(true);

        return new SafariDriver(safariOptions);
    }
}
