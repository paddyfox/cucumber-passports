package kainos.specs.site.page_objects.or.pages.filter;

import kainos.specs.datastore.DataStore;
import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

public class AgePage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Date of birth";
    private static final String PAGE_HEADER_WELSH = "Dyddiad geni";

    @FindBy(className = "govuk-fieldset__heading")
    private WebElement pageHeader;
    @FindBy(id = "dateOfBirth-day")
    private WebElement dobDayField;
    @FindBy(id = "dateOfBirth-month")
    private WebElement dobMonthField;
    @FindBy(id = "dateOfBirth-year")
    private WebElement dobYearField;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, pageHeader);
    }

    private void setDateOfBirthDay(String dateOfBirthDay) {
        enterTextIntoTheField(dobDayField, dateOfBirthDay);
    }

    private void setDateOfBirthMonth(String dateOfBirthMonth) {
        enterTextIntoTheField(dobMonthField, dateOfBirthMonth);
    }

    private void setDateOfBirthYear(String dateOfBirthYear) {
        enterTextIntoTheField(dobYearField, dateOfBirthYear);
    }

    /**
     * Parse an ISO-8601 date and set the values on the DOB page.
     * https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
     *
     * @param date
     */
    public void setDateOfBirth(String date) {
        LocalDate dob = LocalDate.parse(date);

        setDateOfBirthDay(Integer.toString(dob.getDayOfMonth()));
        setDateOfBirthMonth(Integer.toString(dob.getMonthValue()));
        setDateOfBirthYear(Integer.toString(dob.getYear()));

        DataStore.setDataKey(DataStore.APPLICANT_DATE_OF_BIRTH, String.valueOf(dob));
    }
}
