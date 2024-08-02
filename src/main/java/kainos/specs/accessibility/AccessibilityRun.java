package kainos.specs.accessibility;

import com.deque.html.axecore.results.Results;

public class AccessibilityRun {
  private final String pageTitle;
  private final Results results;

  public AccessibilityRun(String pageTitle, Results results) {
    this.pageTitle = pageTitle;
    this.results = results;
  }

  public boolean failed() {
    return !results.violationFree();
  }
}
