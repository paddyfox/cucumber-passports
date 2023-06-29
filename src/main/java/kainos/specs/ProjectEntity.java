package kainos.specs;

import kainos.specs.properties.CommonProperties;
import kainos.specs.properties.PropertyLoader;

import static java.util.Objects.nonNull;

public class ProjectEntity {

    public static String getProjectName = nonNull(PropertyLoader.getProperty(CommonProperties.PROJECT_NAME)) ?
            PropertyLoader.getProperty(CommonProperties.PROJECT_NAME) :
            "Automated Accessibility Tests";

}
