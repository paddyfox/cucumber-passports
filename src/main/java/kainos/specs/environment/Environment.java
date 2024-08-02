package kainos.specs.environment;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Environment {

    private static final String DEFAULT_ENVIRONMENT_NAME = "sit";
    private static final String TEST_RUN_DATE_AND_TIME = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

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
        return true;
    }

    public static Boolean failOnAccessibilityFailure() {
        return false;
    }

    public static String getTestRunDateAndTime() {
        return TEST_RUN_DATE_AND_TIME;
    }
}
