package kainos.specs.site;

import kainos.specs.countrystore.CountryStore;
import kainos.specs.datastore.DataStore;
import kainos.specs.driver.DriverManager;
import kainos.specs.environment.Environment;
import kainos.specs.helpers.LanguageCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static kainos.specs.datastore.DataStore.APPLICATION_LANGUAGE;
@Slf4j
public class Site {

    private static final long DEFAULT_WAIT_MILLISECONDS = 10_000;

    public static WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    public static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public static WebDriverWait webDriverWait(long milliseconds) {
        return new WebDriverWait(getDriver(), Duration.ofMillis(milliseconds));
    }

    public static boolean elementIsDisplayed(WebElement element) {
        try {
            webDriverWait(DEFAULT_WAIT_MILLISECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    private static void waitForElementToBeDisplayed(WebElement element) {
        try {
            webDriverWait(DEFAULT_WAIT_MILLISECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element));
            log.debug("WebElement displayed {}", element);
        } catch (TimeoutException e) {
            throw new NoSuchElementException("ERROR: Cannot find WebElement: " + element, e);
        }
    }

    public static void waitForElementToContainText(WebElement element, String expectedText) {
        waitForElementToBeDisplayed(element);

        try {
            webDriverWait(DEFAULT_WAIT_MILLISECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.textToBePresentInElement(element, expectedText));
            log.debug("WebElement {} contained expected text: {}", element, expectedText);
        } catch (TimeoutException e) {
            throw new NotFoundException("ERROR: WebElement " + element + " did not contain expected text: " + expectedText, e);
        }
    }

    public static void goToUrl(String webAddress) {
        getDriver().get(webAddress);
    }

    public static WebElement findElement(By by) {
        return getDriver().findElement(by);
    }

    public static void closeWindow() {
        getDriver().close();
    }

    public void removeCookies() {
        getDriver().manage().deleteAllCookies();
        if (!getDriver().manage().getCookies().isEmpty()) {
            throw new IllegalStateException("Expected all cookies to be removed but cookies are still present");
        }
    }

    public void clickContinue() {
        clickOnElement(findElement(By.cssSelector(".button")));
    }

    public void clickOnElement(WebElement webElement) {
        try {
            WebElement clickableElement = webDriverWait(DEFAULT_WAIT_MILLISECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(webElement));
            log.debug("Clicking element {}", clickableElement);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", clickableElement);
            clickableElement.click();
        } catch (TimeoutException | ElementClickInterceptedException | StaleElementReferenceException e) {
            throw new NoSuchElementException("Cannot find or click on WebElement: " + webElement, e);
        }
    }

    public void enterTextIntoTheField(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    public void verifyPageHeader(String expectedPageHeader, WebElement pageHeaderElement) throws Exception {
        verifyTextInElement(expectedPageHeader, pageHeaderElement);
        log.info("Loaded page: {}", expectedPageHeader);
        if (Environment.executeAccessibilityTesting()) {
            AccessibilityBase.checkAllAccessibilityViolations(expectedPageHeader);
        }
    }

    public void verifyPageHeaderWelsh(Pair<String, String> expectedPageHeaders, WebElement pageHeaderElement) {
        verifyTextInElement(expectedPageHeaders.getLeft(), pageHeaderElement);

        log.info("Loaded page: {} ({})", expectedPageHeaders.getLeft(), expectedPageHeaders.getRight());
    }

    private void verifyTextInElement(String text, WebElement webElement) {
        waitForElementToContainText(webElement, text);
    }

    public void verifyHeaderBilingual(String expectedWelsh, String expectedEnglish, WebElement pageHeader) throws Exception {
        verifyPageHeader(expectedEnglish, pageHeader);
    }

    public void verifyHeaderBilingualWithRetry(String expectedWelsh, String expectedEnglish, WebElement pageHeader) throws Exception {
        try {
            if (isApplicationLanguageWelsh()) {
                waitForElementToContainText(pageHeader, expectedWelsh);
                log.info("Loaded page: {} ({})", expectedWelsh, expectedEnglish);
            } else {
                waitForElementToContainText(pageHeader, expectedEnglish);
                log.info("Loaded page: {}", expectedEnglish);
            }
            if (Environment.executeAccessibilityTesting()) {
                AccessibilityBase.checkAllAccessibilityViolations(expectedEnglish);
            }
        } catch (StaleElementReferenceException | NotFoundException e) {
            throw new Exception("Failed to find page header", e);
        }
    }

    protected void waitForElementToBeInvisible(By elementLocator, long timeoutMilliseconds) {
        webDriverWait(timeoutMilliseconds).until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
    }

    public boolean isApplicationLanguageWelsh() {
        return DataStore.hasKey(APPLICATION_LANGUAGE) &&
                LanguageCode.WELSH.getLanguageCode()
                        .equalsIgnoreCase(
                                DataStore.getDataKey(APPLICATION_LANGUAGE));
    }

    protected String getCountryName(String countryCode) {
        if (countryCode.isEmpty()) {
            return countryCode;
        }
        if (isApplicationLanguageWelsh()) {
            return CountryStore.countryHashMap.get(countryCode).get(6);
        } else {
            return CountryStore.countryHashMap.get(countryCode).get(4);
        }
    }
}
