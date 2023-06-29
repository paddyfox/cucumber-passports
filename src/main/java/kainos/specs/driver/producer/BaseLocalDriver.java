package kainos.specs.driver.producer;


import kainos.specs.properties.CommonProperties;
import kainos.specs.properties.PropertyLoader;

public class BaseLocalDriver {

    protected static final String BROWSER_VERSION = PropertyLoader.getProperty(CommonProperties.BROWSER_VERSION);

}
