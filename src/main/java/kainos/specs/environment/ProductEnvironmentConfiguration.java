package kainos.specs.environment;

import kainos.specs.properties.PropertyLoader;
import lombok.extern.slf4j.Slf4j;

/**
 * Get the URL config from file based on environment variables.
 * <p>
 * The environment variable and the config files can legitimately not exist.
 * If the environment variable doesn't exist or there is an IO
 * exception then log the issue and return early.
 */

@Slf4j
public class ProductEnvironmentConfiguration {

    public ProductEnvironmentConfiguration(String environmentName) {
        if (environmentName == null || environmentName.isEmpty()) {
            throw new IllegalArgumentException("Test environment must be specified.");
        }
    }

    public static ProductEnvironmentConfiguration getWithDefault() {
        String environmentName = Environment.getEnvironmentName();
        return new ProductEnvironmentConfiguration(environmentName);
    }

    private String getProperty(String key) {
        return PropertyLoader.getProperty(key);
    }

    public String getAppBaseUrl() {
        return getProperty("appBaseUrl");
    }
}
