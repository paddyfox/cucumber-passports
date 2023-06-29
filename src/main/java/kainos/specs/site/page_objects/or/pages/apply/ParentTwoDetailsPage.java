package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import kainos.specs.countrystore.CountryStore;
import kainos.specs.datastore.DataStore;
import kainos.specs.helpers.ApplicantData;

import static kainos.specs.helpers.ApplicantData.*;
import static kainos.specs.helpers.CountryHelpers.convertCountryTextToCountryAMSFormat;

public class ParentTwoDetailsPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Father or parent 2";
    private static final String PAGE_HEADER_WELSH = "Tad neu riant 2";

    @FindBy(tagName = "h1") private WebElement parentTwoDetailsPageHeader;
    @FindBy(id = "parent2TownOfBirth") private WebElement parentTwoTownOfBirthField;
    @FindBy(id = "parent2CountryOfBirth") private WebElement parentTwoCountryOfBirthDropdown;
    @FindBy(id = "parent2Nationality") private WebElement parentTwoNationalityField;
    @FindBy(id = "parent2HasPassport-true-label") private WebElement yesToParentTwoHavingUKPassport;
    @FindBy(id = "parent2HasPassport-false-label") private WebElement noToParentTwoHavingUKPassport;
    @FindBy(id = "parent2PassportNumber") private WebElement parentTwoPassportNumberField;
    @FindBy(id = "parent2PassportIssueDate-day") private WebElement parentTwoPassportIssueDateDayField;
    @FindBy(id = "parent2PassportIssueDate-month") private WebElement parentTwoPassportIssueDateMonthField;
    @FindBy(id = "parent2PassportIssueDate-year") private WebElement parentTwoPassportIssueDateYearField;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, parentTwoDetailsPageHeader);
    }

    public void setTownOfBirthParentTwo(String townOfBirthParentTwo) {
        enterTextIntoTheField(parentTwoTownOfBirthField, townOfBirthParentTwo);
    }

    private void selectCountryOfBirth(String countryCodeOfBirth) {
        Select parentTwoCountryOfBirthSelect = new Select(parentTwoCountryOfBirthDropdown);
        if (!countryCodeOfBirth.equals("")) {
            if ("UK".equalsIgnoreCase(countryCodeOfBirth)) {
                parentTwoCountryOfBirthSelect.selectByVisibleText("United Kingdom");
                DataStore.setDataKey(DataStore.PARENT_TWO_COUNTRY_OF_BIRTH_AMS, "United Kingdom");
                DataStore.setDataKey(DataStore.PARENT_TWO_COUNTRY_OF_BIRTH_CODE, "GB");
            } else {
                String countryName = getCountryName(countryCodeOfBirth);
                parentTwoCountryOfBirthSelect.selectByVisibleText(countryName);
                DataStore.setDataKey(DataStore.PARENT_TWO_COUNTRY_OF_BIRTH_CODE, countryCodeOfBirth);
                String country = CountryStore.countryHashMap.get(countryCodeOfBirth).get(4);
                DataStore.setDataKey(DataStore.PARENT_TWO_COUNTRY_OF_BIRTH_AMS, convertCountryTextToCountryAMSFormat(country));
            }
        }
    }

    public void enterNationalityParentTwo(String nationalityParentTwo) {
        enterTextIntoTheField(parentTwoNationalityField, nationalityParentTwo);
    }

    public void clickYesForMyParentTwoHavingUKPassport() {
        clickOnElement(yesToParentTwoHavingUKPassport);
    }

    public void clickNoForMyParentTwoHavingUKPassport() {
        clickOnElement(noToParentTwoHavingUKPassport);
        DataStore.setDataKey(DataStore.PARENT_TWO_PASSPORT_NUMBER, null);
        DataStore.setDataKey(PARENT_TWO_PASSPORT_ISSUE_DATE_DAY, null);
        DataStore.setDataKey(PARENT_TWO_PASSPORT_ISSUE_DATE_MONTH, null);
        DataStore.setDataKey(PARENT_TWO_PASSPORT_ISSUE_DATE_YEAR, null);
    }

    public void enterParentTwoPassportNumber(String passportNumberParentTwo) {
        enterTextIntoTheField(parentTwoPassportNumberField, passportNumberParentTwo);
    }

    public void enterParentTwoPassportIssueDate(String day, String month, String year) {
        enterTextIntoTheField(parentTwoPassportIssueDateDayField, day);
        enterTextIntoTheField(parentTwoPassportIssueDateMonthField, month);
        enterTextIntoTheField(parentTwoPassportIssueDateYearField, year);
    }

    private void confirmParentTwoUKPassport(Boolean parentTwoHasUKPassport) {
        if (parentTwoHasUKPassport) {
            clickYesForMyParentTwoHavingUKPassport();
        } else {
            clickNoForMyParentTwoHavingUKPassport();
        }
    }

    public void setParentTwoPassportNumber(String parentTwoPassportNumber) {
        enterParentTwoPassportNumber(parentTwoPassportNumber);
    }

    public void setParentTwoPassportIssueDate(String parentTwoPassportIssueDay, String parentTwoPassportIssueMonth, String parentTwoPassportIssueYear) {
        enterParentTwoPassportIssueDate(parentTwoPassportIssueDay, parentTwoPassportIssueMonth, parentTwoPassportIssueYear);
    }

    public void completeNationalityForm(ApplicantData applicantData) throws Exception {
        this.setTownOfBirthParentTwo(applicantData.getParentTwoTownOfBirth());
        this.selectCountryOfBirth(applicantData.getParentTwoCountryOfBirthCode());
        this.enterNationalityParentTwo(applicantData.getParentsNationality());
        DataStore.setDataKey(DataStore.PARENT_TWO_TOWN_OF_BIRTH, applicantData.getParentTwoTownOfBirth());
        DataStore.setDataKey(DataStore.PARENT_TWO_COUNTRY_OF_BIRTH_AMS, applicantData.getParentTwoCountryOfBirthCode());
        DataStore.setDataKey(DataStore.PARENTS_ONE_TWO_NATIONALITY, applicantData.getParentsNationality());
    }

    public void completePassportForm(ApplicantData applicantData) throws Exception {
        this.confirmParentTwoUKPassport(applicantData.getParentTwoPassportStatus());
        if (applicantData.parentTwoHasAUKPassport()) {
            this.setParentTwoPassportNumber(applicantData.getParentTwoPassportNumber());
            DataStore.setDataKey(DataStore.PARENT_TWO_PASSPORT_NUMBER, applicantData.getParentTwoPassportNumber());
            this.setParentTwoPassportIssueDate(applicantData.getParentTwoPassportIssueDateDay(), applicantData.getParentTwoPassportIssueDateMonth(), applicantData.getParentTwoPassportIssueDateYear());
        }
    }
}
