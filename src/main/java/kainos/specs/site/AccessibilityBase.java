package kainos.specs.site;

import com.deque.html.axecore.results.Results;
import java.util.Arrays;
import java.util.List;
import kainos.specs.accessibility.AccessibilityService;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class AccessibilityBase extends Site {

    private static final List<String> tags = Arrays.asList("wcag21a", "wcag21aa", "wcag21aaa");

    public static void checkAllAccessibilityViolations(String pageHeader) {
        WebDriver webDriver = getDriver();
        AccessibilityService accessibilityService = AccessibilityService.getInstance();
        try {
            Results results = accessibilityService.runAccessibilityCheck(webDriver, tags);
            log.error(results.getViolations().size() + " Accessibility violations found on page: " + pageHeader);
            log.error(results.getViolations().toString());
        } catch (RuntimeException exception) {
            log.error("Accessibility run failed.");
        }
    }
}
