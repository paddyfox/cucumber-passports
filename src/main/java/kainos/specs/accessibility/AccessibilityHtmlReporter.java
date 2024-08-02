package kainos.specs.accessibility;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.selenium.AxeReporter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;
import kainos.specs.environment.Environment;

public class AccessibilityHtmlReporter {
  private static final String ACCESSIBILITY_ROOT_DIRECTORY = "src/test/java/accessibility_reports/";
  private final String testReportsRootDirectoryPath;

  public AccessibilityHtmlReporter(String testName) {
    testReportsRootDirectoryPath = String.format(
        "%s%s/%s",
        ACCESSIBILITY_ROOT_DIRECTORY,
        Environment.getTestRunDateAndTime(),
        testName);
    AccessibilityUtils.createDirectoriesIfDoesNotExist(testReportsRootDirectoryPath);
  }

  public void generateHtmlReport(Results results, String pageName, File screenshot)
      throws Exception {
    boolean checkPassed = results.violationFree();
    String reportsDirectoryPath = getReportDirectoryPath(checkPassed, pageName);
    String htmlReportFileName = getHtmlReportName();
    String screenshotFileName = getScreenshotFileName();
    String jsonReportFileName = getJsonReportFileName();

    String report = new AccessibilityHtmlReportBuilder().buildReport(results, screenshotFileName, jsonReportFileName);

    storeReport(report, reportsDirectoryPath, htmlReportFileName);
    storeScreenshot(reportsDirectoryPath, screenshotFileName, screenshot);
    storeJsonReport(reportsDirectoryPath, jsonReportFileName, results);
  }

  private void storeReport(String report, String reportDirectoryPath, String reportPath) throws IOException {
    String path = String.format("%s/%s", reportDirectoryPath, reportPath);
    AccessibilityUtils.createFile(path, report);
  }

  private void storeScreenshot(String reportDirectoryPath, String screenshotFileName, File screenshot)
      throws IOException {
    String screenshotFilePath = String.format("%s/%s", reportDirectoryPath, screenshotFileName);
    Files.copy(Path.of(screenshot.getAbsolutePath()), Path.of(screenshotFilePath));
  }

  private void storeJsonReport(String reportDirectoryPath, String jsonFileName, Results results) {
    String jsonReportPath = String.format("%s/%s", reportDirectoryPath, jsonFileName.replace(".json", ""));
    AxeReporter.writeResultsToJsonFile(jsonReportPath, results);
  }

  private String getReportDirectoryPath(boolean checkPassed, String pageName) {
    if(checkPassed) {
      return String.format("%s/%s/%s", testReportsRootDirectoryPath, "passed", pageName);
    } else {
      return String.format("%s/%s/%s", testReportsRootDirectoryPath, "failed", pageName);
    }
  }

  private String getHtmlReportName() {
    return String.format("%s.html", UUID.randomUUID());
  }

  private String getScreenshotFileName() {
    return String.format("%s.jpeg", UUID.randomUUID());
  }

  private String getJsonReportFileName() {
    return String.format("%s.json", UUID.randomUUID());
  }
}
