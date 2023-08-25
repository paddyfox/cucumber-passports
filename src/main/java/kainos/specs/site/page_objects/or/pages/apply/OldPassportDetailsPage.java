package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

import static java.util.Objects.isNull;

public class OldPassportDetailsPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Old passport details";
    private static final String PAGE_HEADER_WELSH = "Manylion hen basbort";

    @FindBy(tagName = "h1")
    private WebElement oldPassportDetailsPageHeader;
    @FindBy(id = "passport-number")
    private WebElement oldPassportNumberField;
    @FindBy(id = "old-passport-number")
    private WebElement oldBluePassportNumberField;
    @FindBy(id = "passport-expiry-day")
    private WebElement oldPassportExpiryDayField;
    @FindBy(id = "passport-expiry-month")
    private WebElement oldPassportExpiryMonthField;
    @FindBy(id = "passport-expiry-year")
    private WebElement oldPassportExpiryYearField;
    @FindBy(id = "old-passport-expiry-day")
    private WebElement oldBluePassportExpiryDayField;
    @FindBy(id = "old-passport-expiry-month")
    private WebElement oldBluePassportExpiryMonthField;
    @FindBy(id = "old-passport-expiry-year")
    private WebElement oldBluePassportExpiryYearField;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, oldPassportDetailsPageHeader);
    }

    public void clearOldPassportNumber() {
        oldPassportNumberField.clear();
    }

    public void setOldPassportNumber(String passportNumber) {
        clearOldPassportNumber();
        enterTextIntoTheField(oldPassportNumberField, passportNumber);
        if (!(oldPassportNumberField.getAttribute("value").contains(passportNumber))) {
            enterTextIntoTheField(oldPassportNumberField, passportNumber);
        }
    }

    public void setOldBluePassportNumber(String passportNumber) {
        enterTextIntoTheField(oldBluePassportNumberField, passportNumber);
    }

    public void setOldPassportExpiryDay(String expiryDay) {
        enterTextIntoTheField(oldPassportExpiryDayField, expiryDay);
    }

    public void setOldPassportExpiryMonth(String expiryMonth) {
        enterTextIntoTheField(oldPassportExpiryMonthField, expiryMonth);
    }

    public void setOldPassportExpiryYear(String expiryYear) {
        enterTextIntoTheField(oldPassportExpiryYearField, expiryYear);
    }

    private void setOldBluePassportExpiryDay(String expiryDay) {
        enterTextIntoTheField(oldBluePassportExpiryDayField, expiryDay);
    }

    private void setOldBluePassportExpiryMonth(String expiryMonth) {
        enterTextIntoTheField(oldBluePassportExpiryMonthField, expiryMonth);
    }

    private void setOldBluePassportExpiryYear(String expiryYear) {
        enterTextIntoTheField(oldBluePassportExpiryYearField, expiryYear);
    }

    private void setPassportExpiryDate(LocalDate expiryDate) {
        String day = isNull(expiryDate) ? "" : String.valueOf(expiryDate.getDayOfMonth());
        String month = isNull(expiryDate) ? "" : String.valueOf(expiryDate.getMonthValue());
        String year = isNull(expiryDate) ? "" : String.valueOf(expiryDate.getYear());

        setOldPassportExpiryDay(day);
        setOldPassportExpiryMonth(month);
        setOldPassportExpiryYear(year);
    }

    private void setOldPassportExpiryDate(LocalDate expiryDate) {
        String day = isNull(expiryDate) ? "" : String.valueOf(expiryDate.getDayOfMonth());
        String month = isNull(expiryDate) ? "" : String.valueOf(expiryDate.getMonthValue());
        String year = isNull(expiryDate) ? "" : String.valueOf(expiryDate.getYear());

        setOldBluePassportExpiryDay(day);
        setOldBluePassportExpiryMonth(month);
        setOldBluePassportExpiryYear(year);
    }

    public void completeOldNonBluePassportForm(String passportNumber, LocalDate expiryDate) throws Exception {
        this.setOldPassportNumber(StepDefinitionAssertionConstants.INVALID_UK_POST_CODE);
        this.setOldPassportNumber(passportNumber);
        this.setPassportExpiryDate(expiryDate);
    }

    public void completeOldBluePassportForm(String passportNumber, LocalDate expiryDate) {
        this.setOldBluePassportNumber(passportNumber);
        this.setOldPassportExpiryDate(expiryDate);
    }
}
