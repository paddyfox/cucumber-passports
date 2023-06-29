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

public class ParentOneDetailsPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Mother or parent 1";
    private static final String PAGE_HEADER_WELSH = "Mam neu riant 1";

    @FindBy(tagName = "h1") private WebElement parentOneDetailsPageHeader;
    @FindBy(id = "parent1TownOfBirth") private WebElement parentOneTownOfBirthField;
    @FindBy(id = "parent1CountryOfBirth") private WebElement parentOneCountryOfBirthDropdown;
    @FindBy(id = "parent1Nationality") private WebElement parentOneNationalityField;
    @FindBy(id = "parent1HasPassport-true-label") private WebElement yesToParentOneHavingUKPassport;
    @FindBy(id = "parent1HasPassport-false-label") private WebElement noToParentOneHavingUKPassport;
    @FindBy(id = "parent1PassportNumber") private WebElement parentOnePassportNumberField;
    @FindBy(id = "parent1PassportIssueDate-day") private WebElement parentOnePassportIssueDateDayField;
    @FindBy(id = "parent1PassportIssueDate-month") private WebElement parentOnePassportIssueDateMonthField;
    @FindBy(id = "parent1PassportIssueDate-year") private WebElement parentOnePassportIssueDateYearField;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, parentOneDetailsPageHeader);
    }

    public void setTownOfBirthParentOne(String townOfBirthParentOne) {
        enterTextIntoTheField(parentOneTownOfBirthField, townOfBirthParentOne);
    }

    private void selectCountryOfBirth(String countryCodeOfBirth) {
        if (!countryCodeOfBirth.equals("")) {
            Select parentOneCountryOfBirthSelect = new Select(parentOneCountryOfBirthDropdown);
            if ("UK".equalsIgnoreCase(countryCodeOfBirth)) {
                parentOneCountryOfBirthSelect.selectByVisibleText("United Kingdom");
                DataStore.setDataKey(DataStore.PARENT_ONE_COUNTRY_OF_BIRTH_AMS, "United Kingdom");
                DataStore.setDataKey(DataStore.PARENT_ONE_COUNTRY_OF_BIRTH_CODE, "GB");
            } else {
                String countryName = getCountryName(countryCodeOfBirth);
                parentOneCountryOfBirthSelect.selectByVisibleText(countryName);
                DataStore.setDataKey(DataStore.PARENT_ONE_COUNTRY_OF_BIRTH_CODE, countryCodeOfBirth);
                String country = CountryStore.countryHashMap.get(countryCodeOfBirth).get(4);
                DataStore.setDataKey(DataStore.PARENT_ONE_COUNTRY_OF_BIRTH_AMS, convertCountryTextToCountryAMSFormat(country));
            }
        }
    }

    public void enterNationalityParentOne(String nationalityParentOne) {
        enterTextIntoTheField(parentOneNationalityField, nationalityParentOne);
    }

    public void clickYesForMyParentOneHavingUKPassport() {
        clickOnElement(yesToParentOneHavingUKPassport);
    }

    public void clickNoForMyParentOneHavingUKPassport() {
        clickOnElement(noToParentOneHavingUKPassport);
        DataStore.setDataKey(DataStore.PARENT_ONE_PASSPORT_NUMBER, null);
        DataStore.setDataKey(PARENT_ONE_PASSPORT_ISSUE_DATE_DAY, null);
        DataStore.setDataKey(PARENT_ONE_PASSPORT_ISSUE_DATE_MONTH, null);
        DataStore.setDataKey(PARENT_ONE_PASSPORT_ISSUE_DATE_YEAR, null);
    }

    public void enterParentOnePassportNumber(String passportNumberParentOne) {
        enterTextIntoTheField(parentOnePassportNumberField, passportNumberParentOne);
    }

    public void enterParentOnePassportIssueDate(String day, String month, String year) {
        enterTextIntoTheField(parentOnePassportIssueDateDayField, day);
        enterTextIntoTheField(parentOnePassportIssueDateMonthField, month);
        enterTextIntoTheField(parentOnePassportIssueDateYearField, year);
    }

    private void confirmParentOneUKPassport(Boolean parentOneHasUKPassport) {
        if (parentOneHasUKPassport) {
            clickYesForMyParentOneHavingUKPassport();
        } else {
            clickNoForMyParentOneHavingUKPassport();
        }
    }

    public void setParentOnePassportNumber(String parentOnePassportNumber) {
        enterParentOnePassportNumber(parentOnePassportNumber);
    }

    private void setParentOnePassportIssueDate(String parentOnePassportIssueDay, String parentOnePassportIssueMonth, String parentOnePassportIssueYear) {
        enterParentOnePassportIssueDate(parentOnePassportIssueDay, parentOnePassportIssueMonth, parentOnePassportIssueYear);
    }

    public void completeNationalityForm(ApplicantData applicantData) throws Exception {
        this.setTownOfBirthParentOne(applicantData.getParentOneTownOfBirth());
        this.selectCountryOfBirth(applicantData.getParentOneCountryOfBirthCode());
        this.enterNationalityParentOne(applicantData.getParentsNationality());
        DataStore.setDataKey(DataStore.PARENT_ONE_TOWN_OF_BIRTH, applicantData.getParentOneTownOfBirth());
        DataStore.setDataKey(DataStore.PARENT_ONE_COUNTRY_OF_BIRTH_CODE, applicantData.getParentOneCountryOfBirthCode());
        DataStore.setDataKey(DataStore.PARENTS_ONE_TWO_NATIONALITY, applicantData.getParentsNationality());
    }

    public void completePassportForm(ApplicantData applicantData) throws Exception {
        this.confirmParentOneUKPassport(applicantData.getParentOnePassportStatus());
        if (applicantData.parentOneHasAUKPassport()) {
            this.setParentOnePassportNumber(applicantData.getParentOnePassportNumber());
            DataStore.setDataKey(DataStore.PARENT_ONE_PASSPORT_NUMBER, applicantData.getParentOnePassportNumber());
            this.setParentOnePassportIssueDate(applicantData.getParentOnePassportIssueDateDay(), applicantData.getParentOnePassportIssueDateMonth(), applicantData.getParentOnePassportIssueDateYear());
        }
    }
}
