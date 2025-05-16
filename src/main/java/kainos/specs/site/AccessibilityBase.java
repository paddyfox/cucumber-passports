package kainos.specs.site;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class AccessibilityBase extends Site {

    private static final List<String> tags = Arrays.asList("wcag21a", "wcag21aa", "wcag21aaa");
    private static final String reportPath = "src/test/java/accessibility_reports/";

    public static void checkAllAccessibilityViolations(String pageHeader) throws IOException {
        String reportFile = reportPath + pageHeader.replaceAll(" ", "_").toLowerCase() + "_accessibility_report";
        WebDriver webDriver = getDriver();
        AxeBuilder builder = new AxeBuilder();
        builder.withTags(tags);
        Results results = builder.analyze(webDriver);
        saveReport(results, reportFile, pageHeader);
    }

    public static void checkAccessibilityViolationsOfASpecificSelector(String selector, String pageHeader) throws FileNotFoundException {
        String reportFile = reportPath + pageHeader.replaceAll(" ", "_").toLowerCase() + "_accessibility_report";
        WebDriver webDriver = getDriver();
        AxeBuilder builder = new AxeBuilder();
        builder.withTags(tags);
        Results results = builder.include(Collections.singletonList(selector)).analyze(webDriver);
        saveReport(results, reportFile, pageHeader);
        log.info("Axe A11y test report saved to: " + reportPath);
    }

    public static void saveReport(Results results, String reportFile, String pageHeader) {
        List<Rule> violations = results.getViolations();
        if (violations.isEmpty()) {
            Assert.assertTrue(true, "No violations found");
            log.info("No Accessibility violations found on page: {}", pageHeader);
        }
        else {
            // Create a Gson instance with pretty printing
            new GsonBuilder().setPrettyPrinting().create();

            // Write raw results to JSON
            AxeReporter.writeResultsToJsonFile(reportFile, results);

            // Log out results
            log.error("{} Accessibility violations found on page: {}", violations.size(), pageHeader);
            log.error(results.getViolations().toString());
        }
    }
}
