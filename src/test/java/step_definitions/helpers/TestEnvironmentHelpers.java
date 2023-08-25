package step_definitions.helpers;

import kainos.specs.site.Site;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestEnvironmentHelpers extends Site {

    public void setupTestEnvironment(String applicantType) {
        // Clear all cookies to prevent any cross browser contamination.
        removeCookies();
    }
}
