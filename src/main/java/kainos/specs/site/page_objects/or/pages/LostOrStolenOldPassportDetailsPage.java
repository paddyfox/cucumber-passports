package kainos.specs.site.page_objects.or.pages;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

import static java.util.Objects.isNull;

public class LostOrStolenOldPassportDetailsPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Old passport details";
    private static final String PAGE_HEADER_WELSH = "Manylion hen basbort";

    @FindBy(tagName = "h1") private WebElement oldPassportDetailsPageHeader;
    @FindBy(id = "optional-passport-number") private WebElement passportNumberField;
    @FindBy(id = "optional-passport-expiry-day") private WebElement passportExpiryDayField;
    @FindBy(id = "optional-passport-expiry-month") private WebElement passportExpiryMonthField;
    @FindBy(id = "optional-passport-expiry-year") private WebElement passportExpiryYearField;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, oldPassportDetailsPageHeader);
    }

    public void setPassportNumber(String passportNumber) {
        enterTextIntoTheField(passportNumberField, passportNumber);
    }

    public void setPassportExpiryDay(String expiryDay) {
        enterTextIntoTheField(passportExpiryDayField, expiryDay);
    }

    public void setPassportExpiryMonth(String expiryMonth) {
        enterTextIntoTheField(passportExpiryMonthField, expiryMonth);
    }

    public void setPassportExpiryYear(String expiryYear) {
        enterTextIntoTheField(passportExpiryYearField, expiryYear);
    }

    public void setOldPassportExpiryDate(LocalDate expiryDate) {
        String day = isNull(expiryDate) ? "" : String.valueOf(expiryDate.getDayOfMonth());
        String month = isNull(expiryDate) ? "" : String.valueOf(expiryDate.getMonthValue());
        String year = isNull(expiryDate) ? "" : String.valueOf(expiryDate.getYear());

        setPassportExpiryDay(day);
        setPassportExpiryMonth(month);
        setPassportExpiryYear(year);
    }

    public void completeForm(String passportNumber, LocalDate expiryDate) {
        this.setPassportNumber(passportNumber);
        this.setOldPassportExpiryDate(expiryDate);
    }
}
