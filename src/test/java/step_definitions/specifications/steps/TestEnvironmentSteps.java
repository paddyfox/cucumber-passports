package step_definitions.specifications.steps;

import lombok.extern.slf4j.Slf4j;
import kainos.specs.site.Site;

@Slf4j
public class TestEnvironmentSteps extends Site {

    public void setupTestEnvironment(String applicantType) {
        // Clear all cookies to prevent any cross browser contamination.
        removeCookies();
    }
}
