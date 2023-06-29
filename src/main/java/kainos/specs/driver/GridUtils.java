package kainos.specs.driver;


import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.net.URL;

import static java.util.Objects.isNull;

@Slf4j
public class GridUtils {

    public static URL getSeleniumGridURL() {
            return getBrowserstackGridURL("username", "password");
    }

    public static URL getBrowserstackGridURL(String username, String accessKey) {
        String lambdaTestUrl = "url";

        if (isNull(username)) {
            throw new DriverCreationException("Browserstack Error: No username specified");
        }
        if (isNull(accessKey)) {
            throw new DriverCreationException("Browserstack Error: No access key specified");
        }

        try {
            log.info("Loading driver via Browserstack...");
            return new URL(lambdaTestUrl);
        } catch (MalformedURLException e) {
            throw new DriverCreationException("Unable create a driver for browserstack from: " + lambdaTestUrl, e);
        }
    }

}
