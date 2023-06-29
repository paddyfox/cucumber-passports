package kainos.specs.site;

import kainos.specs.countrystore.CountryStore;
import kainos.specs.datastore.DataStore;
import kainos.specs.driver.DriverManager;
import kainos.specs.helpers.LanguageCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.*;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static kainos.specs.datastore.DataStore.APPLICATION_LANGUAGE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

@Slf4j
public class Site {

    public static WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    public static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public void removeCookies() {
        getDriver().manage().deleteAllCookies();
        assertThat(getDriver().manage().getCookies(), empty());
    }

    public void clickContinue() {
        clickOnElement(findElement(By.cssSelector(".button")));
    }

    public void clickOnElement(WebElement webElement) {
        for (int i = 1; i <= 10; i++) {
            try {
                log.debug("Try click {} for element {}", i, webElement);
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
                webElement.click();
                return;
            } catch (NoSuchElementException | ElementClickInterceptedException | StaleElementReferenceException e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                    throw new RuntimeException(ex);
                }
            }
        }

        throw new NoSuchElementException("Cannot find or click on WebElement: " + webElement);
    }

    public void enterTextIntoTheField(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    public void verifyPageHeader(String expectedPageHeader, WebElement pageHeaderElement) throws Exception {
        verifyTextInElement(expectedPageHeader, pageHeaderElement);

        log.info("Loaded page: {}", expectedPageHeader);
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
        int tries = 30;
        boolean pageHeaderFound = false;
        while (tries > 0 && !pageHeaderFound) {
            tries--;
            try {
                if (isApplicationLanguageWelsh()) {
                    verifyPageHeaderWelsh(Pair.of(expectedWelsh, expectedEnglish), pageHeader);
                } else {
                    verifyPageHeader(expectedEnglish, pageHeader);
                }
                pageHeaderFound = true;
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                log.info("Page header not found. {} tries remaining", tries);
                if (tries == 0) {
                    throw new Exception("Failed to find page header", e);
                }
                Thread.sleep(3000);

            }
        }
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

    public static WebDriverWait webDriverWait(long milliseconds) {
        return new WebDriverWait(getDriver(), Duration.ofMillis(milliseconds));
    }

    public static boolean elementIsDisplayed(WebElement element) {
        int tries = 10;
        for (int i = 1; i <= tries; i++) {
            try {
                return element.isDisplayed();
            } catch (NoSuchElementException e) {
                return false;
            } catch (StaleElementReferenceException | JsonException e) {
                log.info("Retry {} out of {} to check if WebElement {} is displayed", i, tries, element);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }

        throw new RuntimeException("ERROR: Could not determine if WebElement is displayed: " + element);
    }

    private static void waitForElementToBeDisplayed(WebElement element) {
        int tries = 10;
        for (int i = 1; i <= tries; i++) {
            if (elementIsDisplayed(element)) {
                log.debug("WebElement displayed {}", element);
                return;
            }

            try {
                log.info("Retry {} out of {} for WebElement {} to be displayed", i, tries, element);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        throw new NoSuchElementException("ERROR: Cannot find WebElement: " + element);
    }

    public static void waitForElementToContainText(WebElement element, String expectedText) {
        waitForElementToBeDisplayed(element);

        String actualText = null;
        int tries = 10;
        for (int i = 0; i < tries; i++) {
            actualText = element.getText();
            if (actualText.contains(expectedText)) {
                log.debug("WebElement {} contained text: {} (expected {})", element, actualText, expectedText);
                return;
            }

            try {
                log.info("WebElement {} did not contain expected text: {}, got: {}", element, expectedText, actualText);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        throw new NotFoundException("ERROR: WebElement " + element + " did not contain expected text: " + expectedText + ", got: " + actualText);
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
}
