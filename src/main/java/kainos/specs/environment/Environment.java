package kainos.specs.environment;

import static com.google.common.base.Strings.isNullOrEmpty;

public class Environment {

    private static final String DEFAULT_ENVIRONMENT_NAME = "sit";

    public static String getEnvironmentName() {
        String environmentName = System.getenv("ENVIRONMENT");
        if (isNullOrEmpty(environmentName)) {
            environmentName = DEFAULT_ENVIRONMENT_NAME;
        }
        return environmentName.toLowerCase();
    }

    public static Boolean executingInJenkins() {
        String jenkinsUrl = System.getenv("JENKINS_URL");
        return !isNullOrEmpty(jenkinsUrl);
    }

    public static Boolean executeAccessibilityTesting() {
        //Change this flag to true to enable Accessibility testing to run
        return false;
    }
}
