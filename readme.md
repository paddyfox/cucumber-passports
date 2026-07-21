# DCS Specifications Test Framework

A modern Java test automation framework for DCS passport journeys, combining UI, BDD, and accessibility validation in one maintainable stack.

## What this project is

- UI automation with Selenium WebDriver
- BDD scenarios with Cucumber
- Test execution and parallel orchestration with TestNG
- Accessibility checks using axe-core
- Maven-based build and dependency management

## Tech stack

- Java `21`
- Maven
- Selenium `4.45.0`
- Cucumber `7.34.3`
- TestNG `7.11.0`
- WebDriverManager
- axe-core Selenium

## Prerequisites

1. Java 21+ installed and available on `PATH`
2. Maven installed and available on `PATH`
3. (Recommended) Cucumber for Java plugin in your IDE

Quick checks:

```zsh
java -version
mvn -v
```

## Quick start

Compile tests:

```zsh
mvn clean test-compile
```

Run smoke tests against SIT:

```zsh
ENVIRONMENT=sit mvn clean test -Psmoke
```

Run a single tagged smoke scenario:

```zsh
ENVIRONMENT=sit mvn clean test -Psmoke -Dcucumber.filter.tags=@SMK1
```

Run smoke tests against STG:

```zsh
ENVIRONMENT=stg mvn clean test -Psmoke
```

## Test execution model

- The smoke suite is configured via `smoke.xml` and Maven profile `smoke`
- Tests run in parallel where supported
- Tag any scenario with `@serial` to force serial execution
- To tune concurrency, update `data-provider-thread-count` in suite XML files such as `smoke.xml`

## Reports and outputs

After execution, generated artifacts are available under `target/`, including:

- Surefire/TestNG outputs: `target/surefire-reports/`
- Cucumber HTML report: `target/cucumber-reports/cucumber-reports.html`

## Accessibility testing

To enable automated accessibility checks, set `executeAccessibilityTesting()` to `true` in:

- `src/main/java/kainos/specs/environment/Environment.java`

Rules are configured in:

- `src/main/java/kainos/specs/site/AccessibilityBase.java`

Notes:

- axe-core checks WCAG and best-practice rule sets
- Some findings are marked as `incomplete` and require manual review

## Useful project paths

- Feature files: `src/test/resources/features/`
- Step definitions: `src/test/java/step_definitions/`
- Page objects: `src/main/java/kainos/specs/site/page_objects/`
- Environment properties: `src/test/resources/properties/`

## Troubleshooting

- `ERR_NAME_NOT_RESOLVED`: verify network/DNS access to the target environment URL
- WebDriver issues: rerun with a clean local driver cache or verify browser compatibility
- Empty runs: confirm tags/profile selection and feature file paths

## Best Practices

- Cover ALL interactive web elements (Dropdowns, text fields etc.) in ALL frontend pages
- Verify the page H1 header as the first test on every page load
- End-to-end journeys in Regression; key journeys in Smoke
- Use API calls for Database validation at key submission points
- Use randomised test data for maximum coverage - non-mandatory, minimum and maximum values
- Follow the [Test Automation Pyramid](https://martinfowler.com/articles/practical-test-pyramid.html)
- Adhere to the [DRY](https://en.wikipedia.org/wiki/Don%27t_repeat_yourself) and [KISS](https://en.wikipedia.org/wiki/KISS_principle) principles
- All tests should be atomic and independent; avoid dependencies between tests
- Never ignore failing/flaky tests! ALWAYS Debug, fix, or raise issues
- Use [PageObjects](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models)
- Don't use assertions in page objects; return values for validation in Steps/Specs
- Avoid testing static text blocks; validate unique locators instead
- Use switch statements if more than 3 conditions are needed. Always add a default case.
- Use `private` access modifier for methods/variables unless they need to be accessed externally
- Use `final` for variables that should not change after initialization
- Use `try-catch` blocks for exception handling; log exceptions appropriately
- Use meaningful names for methods and variables
- Avoid using acronyms or abbreviations in names, prefer better descriptive identifiers
- Avoid deep nesting of code (more than 3 levels)
- Use comments sparingly; prefer self-explanatory code
- Consistent indentation and spacing for readability
- Selector order: `id > name > css > xpath`
- Prefer explicit waits rather than implicit eg `waitForElementToAppear()`
- Use variables, not hardcoded strings
- All test data variables should be logged out on test failure for easier debugging
- Don't use sensitive data or Personal Identifiable Information (PII) in tests
- Don't test external sites; validate the URL href instead
- Run Smokes before Regression to catch critical failures early and save time
- Tests should all run in parallel by default; only tag with `@serial` if serial execution is unavoidable by exception
- Tests should cover end-to-end flows, not partial journeys
- Don't use Selenium for frontend validation messages; prefer unit/integration tests