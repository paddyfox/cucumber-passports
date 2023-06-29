package kainos.specs.driver;

import kainos.specs.environment.Environment;
import kainos.specs.properties.CommonProperties;
import kainos.specs.properties.PropertyLoader;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Slf4j
public class DriverManager {

    private static final ThreadLocal<WebDriver> WEB_DRIVER = new ThreadLocal<>();
    private static final BrowserType DEFAULT_BROWSER = BrowserType.ChromeLocal;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (nonNull(WEB_DRIVER.get())) {
                WEB_DRIVER.get().quit();
            }
        }));
    }

    public static WebDriver getDriver() {
        WebDriver d = WEB_DRIVER.get();

        if (isNull(d)) {
            log.info("Driver needs to be created, creating one...");
            d = createDriver();
        }

        return d;
    }

    public static void quitDriver() {
        WebDriver d = WEB_DRIVER.get();
        if (nonNull(d)) {
            try {
                WEB_DRIVER.get().quit();
            } catch (Exception e) {
                log.warn("Couldn't quit one of the locally created drivers", e);
            }
            WEB_DRIVER.remove();
        }
    }

    private static WebDriver createDriver() {
        String currentBrowser = Environment.executingInJenkins() ?
                System.getenv("BROWSER_NAME") :
                PropertyLoader.getProperty(CommonProperties.BROWSER_TYPE);
        if (isNull(currentBrowser)) {
            String fallbackBrowser = DEFAULT_BROWSER.toString();
            log.warn("null is not a valid browser type, falling back to default of {}", fallbackBrowser);
            currentBrowser = fallbackBrowser;
        }
        DriverMode.setRemote(currentBrowser.contains("Remote") || currentBrowser.contains("Appium"));
        WebDriver d = new DriverFactory(currentBrowser).createInstance();
        d.manage().window().setPosition(new Point(0, 0));
        d.manage().window().maximize();
        WEB_DRIVER.set(d);

        return d;
    }
}
