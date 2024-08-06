package kainos.specs.accessibility;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.selenium.AxeBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@Slf4j
public class AccessibilityService {

  private static final HashMap<String, AccessibilityService> ACCESSIBILITY_SERVICE_HASH_MAP = new HashMap<>();
  private final List<AccessibilityRun> accessibilityRuns = new ArrayList<>();
  private final AccessibilityHtmlReporter reporter;

  private AccessibilityService(String testName) {
    reporter = new AccessibilityHtmlReporter(testName);
  }

  public static void createInstance(String testName) {
    String threadId = Thread.currentThread().getName();
    ACCESSIBILITY_SERVICE_HASH_MAP.put(threadId, new AccessibilityService(testName));
  }

  public static AccessibilityService getInstance() {
    String threadId = Thread.currentThread().getName();
    if(!ACCESSIBILITY_SERVICE_HASH_MAP.containsKey(threadId)) {
      throw new RuntimeException("Accessibility service for current thread has not been created");
    }
    return ACCESSIBILITY_SERVICE_HASH_MAP.get(threadId);
  }

  public boolean accessibilityCheckFailed() {
    return accessibilityRuns.stream().anyMatch(AccessibilityRun::failed);
  }

  public Results runAccessibilityCheck(WebDriver webDriver, List<String> tags) {
    try {
      Results axeResults = runAnalysis(webDriver, tags);
      accessibilityRuns.add(new AccessibilityRun(webDriver.getTitle(), axeResults));

      File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
      reporter.generateHtmlReport(axeResults, webDriver.getTitle(), screenshot);
      return axeResults;
    } catch (Exception e) {
      log.error("Error with generating accessibility report %s".formatted(e.getMessage()));
    }
    throw new RuntimeException("Accessibility check failed");
  }

  private Results runAnalysis(WebDriver webDriver, List<String> tags) {
    if(tags.isEmpty()) {
      return new AxeBuilder().analyze(webDriver);
    } else {
      return new AxeBuilder()
          .withTags(tags)
          .analyze(webDriver);
    }
  }
}
