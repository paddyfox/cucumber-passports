package kainos.specs.driver.producer.desktop.edge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import kainos.specs.driver.producer.BaseLocalDriver;
import kainos.specs.driver.producer.WebDriverProducer;

public class EdgeLocalWebDriverProducer extends BaseLocalDriver implements WebDriverProducer {

    @Override
    public WebDriver produce() {
        if (BROWSER_VERSION != null) {
            WebDriverManager.edgedriver().forceDownload().browserVersion(BROWSER_VERSION).setup();
        } else {
            WebDriverManager.edgedriver().forceDownload().setup();
        }

        return new EdgeDriver();
    }
}
