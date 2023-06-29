package kainos.specs.properties;

import kainos.specs.environment.Environment;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@Slf4j
public class PropertyLoader {

    private static final Set<PropertiesFileConfig> propertiesFileConfigs;

    static {
        String env = Environment.getEnvironmentName();
        propertiesFileConfigs = new HashSet<>();
        registerPropertiesFileConfig(new PropertiesFileConfig("properties/" + env + ".properties"));
    }

    /**
     * Tries to look up a property using System.getProperty() as a priority and then from any properties files that have been registered
     * with this PropertyLoader.
     * <p>
     * By default, the properties file <strong>properties/sit.properties</strong> is registered.
     *
     * @param propertyKey
     * @return the property relating to the propertyKey or null if nothing was found
     */
    public static String getProperty(String propertyKey) {
        if (System.getProperty(propertyKey) != null) {
            log.debug("Found property, " + propertyKey + " as a system property of " + System.getProperty(propertyKey));
            return System.getProperty(propertyKey);
        }

        for (PropertiesFileConfig config : propertiesFileConfigs) {
            String property = getValueFromPropertiesFile(config, propertyKey);

            if (property != null) {
                log.debug("Found property, " + propertyKey + " in file: " + config.getFileName() + " with value of " + property);
                return property;
            }
        }

        return null;
    }

    /**
     * Register additional properties files with the PropertyLoader class
     *
     * @param propertiesFileConfig
     */
    public static void registerPropertiesFileConfig(PropertiesFileConfig propertiesFileConfig) {
        propertiesFileConfigs.add(propertiesFileConfig);
    }

    private static String getValueFromPropertiesFile(PropertiesFileConfig config, String propertyKey) {
        Properties properties = new Properties();
        InputStream inputStream;

        try {
            inputStream = PropertyLoader.class.getClassLoader().getResourceAsStream(config.getFileName());
            if (inputStream == null) {
                System.out.println("Sorry, unable to find " + config.getFileName());

                return null;
            }
            log.debug("Loaded resource from " + PropertyLoader.class.getClassLoader().getResource(config.getFileName()).getPath());
            properties.load(inputStream);

            return properties.getProperty(propertyKey);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
