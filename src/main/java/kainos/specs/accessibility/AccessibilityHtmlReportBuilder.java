package kainos.specs.accessibility;

import com.deque.html.axecore.results.CheckedNode;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.text.StringEscapeUtils;

public class AccessibilityHtmlReportBuilder {
  private static final String TEMPLATE_FILE_PATH = "accessibility/template.html";
  private static final String NODE_DETAILS_TEMPLATE_FILE_PATH = "accessibility/node-details-table-template.html";

  private String report;
  private final String template;

  protected AccessibilityHtmlReportBuilder() throws Exception {
    this.template = AccessibilityUtils.readFile(TEMPLATE_FILE_PATH);
  }

  public String buildReport(Results results, String screenshotFileName, String jsonFileName)
      throws Exception {
    report = template;
    addToReport("{timestamp}", results.getTimestamp());
    addToReport("{run-timestamp}", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    addToReport("{url}", results.getUrl());
    addToReport("{result}", results.violationFree() ? "PASSED" : "FAILED");
    addToReport("{screenshot}", screenshotFileName);
    addToReport("{json-report}", jsonFileName);
    addToReport("{violations}", buildViolations(results));
    addToReport("{passed}", buildPasses(results));
    return report;
  }

  private String buildViolations(Results results) throws Exception {
    StringBuilder violations = new StringBuilder();
    for(Rule rule : results.getViolations()) {
      violations.append("<tr>");
      violations.append(buildCell(rule.getId()));
      violations.append(buildCell(rule.getDescription()));
      violations.append(buildCell(rule.getImpact()));
      violations.append(buildCell(String.format("<a href=\"%s\">%s</a>", rule.getHelpUrl(), rule.getHelpUrl())));
      violations.append(buildCell(rule.getHelp()));
      violations.append(buildCell(new ObjectMapper().writeValueAsString(rule.getTags())));

      StringBuilder nodeCellContent = new StringBuilder();
      for(CheckedNode node : rule.getNodes()) {
        nodeCellContent.append(getViolationNodeErrorDetails(node));
      }
      violations.append(buildCell(nodeCellContent.toString()));
      violations.append("</tr>");
    }
    return violations.toString();
  }


  private String buildPasses(Results results) throws JsonProcessingException {
    StringBuilder violations = new StringBuilder();
    for(Rule rule : results.getPasses()) {
      violations.append("<tr>");
      violations.append(buildCell(rule.getId()));
      violations.append(buildCell(rule.getDescription()));
      violations.append(buildCell(String.format("<a href=\"%s\">%s</a>", rule.getHelpUrl(), rule.getHelpUrl())));
      violations.append(buildCell(rule.getHelp()));
      violations.append(buildCell(new ObjectMapper().writeValueAsString(rule.getTags())));
      violations.append("</tr>");
    }
    return violations.toString();
  }

  private String buildCell(String value) {
    return String.format("<td>%s</td>", value);
  }

  private String getViolationNodeErrorDetails(CheckedNode node) throws Exception {
    String result = AccessibilityUtils.readFile(NODE_DETAILS_TEMPLATE_FILE_PATH);
    result = result.replace("{html}", StringEscapeUtils.escapeHtml4(node.getHtml()));
    result = result.replace("{xpath}", new ObjectMapper().writeValueAsString(node.getTarget()));
    result = result.replace("{impact}", node.getImpact());
    result = result.replace("{failureSummary}", node.getFailureSummary());
    return result;
  }

  private void addToReport(String placeholder, String value) {
    report = report.replace(placeholder, value);
  }
}
