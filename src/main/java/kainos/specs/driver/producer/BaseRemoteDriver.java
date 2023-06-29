package kainos.specs.driver.producer;

import org.openqa.selenium.remote.DesiredCapabilities;

import kainos.specs.ProjectEntity;
import kainos.specs.environment.Environment;
import kainos.specs.properties.BrowserstackProperties;
import kainos.specs.properties.CommonProperties;
import kainos.specs.properties.PropertyLoader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Slf4j
public class BaseRemoteDriver {

    protected static final String PLATFORM = PropertyLoader.getProperty(CommonProperties.BROWSER_PLATFORM);
    protected static final String PLATFORM_VERSION = PropertyLoader.getProperty(CommonProperties.BROWSER_PLATFORM_VERSION);
    protected static final String BROWSER_VERSION = PropertyLoader.getProperty(CommonProperties.BROWSER_VERSION);
    protected static final String PROJECT_NAME = ProjectEntity.getProjectName;
    protected static final String LOCAL_IDENTIFIER = System.getProperty("localIdentifier");
    private static final String START_TIMESTAMP = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

    protected Map<String, Object> getBrowserstackOptions() {
        String jobName = "Paddy Test";
        String buildNumber = "2";
        String browserVersion = "latest";

        if (isNull(jobName)) {
            jobName = String.format("%s-%s-local",
                    START_TIMESTAMP,
                    Environment.getEnvironmentName());
        }
        if (isNull(buildNumber)) {
            buildNumber = System.getProperty("user.name");
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, Object> browserstackOptions = new HashMap<>();
        if (nonNull(PLATFORM) || nonNull(PLATFORM_VERSION)) {
            if (nonNull(PLATFORM)) {
                browserstackOptions.put("os", PLATFORM);
            }
            if (nonNull(PLATFORM_VERSION)) {
                browserstackOptions.put("osVersion", PLATFORM_VERSION);
            }
        }
        browserstackOptions.putAll(setLogging());
        browserstackOptions.put("projectName", PROJECT_NAME);
        browserstackOptions.put("buildName", buildNumber + "-" + PROJECT_NAME + " " + jobName);
        browserstackOptions.put("sessionName", buildNumber);
        browserstackOptions.put("local", "true");
        browserstackOptions.put("localIdentifier", LOCAL_IDENTIFIER);
        browserstackOptions.put("video", "true");
        browserstackOptions.put("resolution", "1080x1920");
        browserstackOptions.put("idleTimeout", "300");
        browserstackOptions.put("browserVersion", browserVersion);
        browserstackOptions.put("timezone", "Europe/London");
        capabilities.setCapability("bstack:options", browserstackOptions);

        return browserstackOptions;
    }

    protected Map<String, Object> setLogging() {
        String logging = PropertyLoader.getProperty(BrowserstackProperties.BROWSERSTACK_LOGGING);
        Map<String, Object> loggingOptions = new HashMap<>();
        if (isNull(logging)) {
            return loggingOptions;
        } else if (logging.equalsIgnoreCase("off")) {
            loggingOptions.put("debug", "false");
            loggingOptions.put("consoleLogs", "disable");
            loggingOptions.put("networkLogs", "false");
            loggingOptions.put("video", "false");
            loggingOptions.put("seleniumLogs", "false");
            loggingOptions.put("appiumLogs", "false");
            loggingOptions.put("maskCommands", "setValues, getValues, setCookies, getCookies");
        } else {
            loggingOptions.put("debug", "true");
            loggingOptions.put("consoleLogs", "info");
            loggingOptions.put("networkLogs", "true");
            loggingOptions.put("video", "true");
            loggingOptions.put("seleniumLogs", "true");
            loggingOptions.put("appiumLogs", "true");
        }
        log.info("Setting logging options: {}", loggingOptions);

        return loggingOptions;
    }

}
