package kainos.specs.driver.producer.desktop.windows;

import io.appium.java_client.windows.WindowsDriver;
import kainos.specs.driver.GridUtils;
import kainos.specs.driver.producer.WebDriverProducer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;

public class WindowsTenRemoteDriverProducer implements WebDriverProducer {

    @Override
    public WebDriver produce() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "WindowsPC");
        capabilities.setCapability("app", "Root");
        WindowsDriver remoteWebDriver = new WindowsDriver(GridUtils.getSeleniumGridURL(), capabilities);
        remoteWebDriver.setFileDetector(new LocalFileDetector());

        return remoteWebDriver;
    }
}
