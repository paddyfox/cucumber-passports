package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import kainos.specs.countrystore.CountryStore;
import kainos.specs.datastore.DataStore;
import kainos.specs.helpers.ApplicantData;

import java.time.LocalDate;

import static com.google.common.base.Strings.isNullOrEmpty;
import static kainos.specs.helpers.CountryHelpers.convertCountryTextToCountryAMSFormat;
import static kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants.CANNOT_PROVIDE_MATERNAL_GRANDPARENT_ONE_DETAILS;
import static kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants.CANNOT_PROVIDE_MATERNAL_GRANDPARENT_TWO_DETAILS;

public class MaternalGrandparentsDetailsPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Maternal grandparents";
    private static final String PAGE_HEADER_WELSH = "Nain a thaid mamol";

    @FindBy(tagName = "h1") private WebElement maternalGrandparentsDetailsPageHeader;
    @FindBy(id = "parent1-parent1-first-name") private WebElement maternalGrandParentOneFirstNameField;
    @FindBy(id = "parent1-parent1-last-name") private WebElement maternalGrandParentOneLastNameField;
    @FindBy(id = "parent1-parent1-date-of-birth-day") private WebElement dobDayFieldMaternalGrandParentOne;
    @FindBy(id = "parent1-parent1-date-of-birth-month") private WebElement dobMonthFieldMaternalGrandParentOne;
    @FindBy(id = "parent1-parent1-date-of-birth-year") private WebElement dobYearFieldMaternalGrandParentOne;
    @FindBy(id = "parent1-parent2-first-name") private WebElement maternalGrandParentTwoFirstNameField;
    @FindBy(id = "parent1-parent2-last-name") private WebElement maternalGrandParentTwoLastNameField;
    @FindBy(id = "parent1-parent2-date-of-birth-day") private WebElement dobDayFieldMaternalGrandParentTwo;
    @FindBy(id = "parent1-parent2-date-of-birth-month") private WebElement dobMonthFieldMaternalGrandParentTwo;
    @FindBy(id = "parent1-parent2-date-of-birth-year") private WebElement dobYearFieldMaternalGrandParentTwo;
    @FindBy(id = "parent1-parents-marriage-date-day") private WebElement marriageDateDayMaternalGrandParentsField;
    @FindBy(id = "parent1-parents-marriage-date-month") private WebElement marriageDateMonthMaternalGrandParentsField;
    @FindBy(id = "parent1-parents-marriage-date-year") private WebElement marriageDateYearMaternalGrandParentsField;
    @FindBy(id = "parent1-parent1-town-of-birth") private WebElement maternalGrandParentOneTownOfBirthField;
    @FindBy(id = "parent1-parent2-town-of-birth") private WebElement maternalGrandParentTwoTownOfBirthField;
    @FindBy(id = "parent1-parent1-country-of-birth") private WebElement maternalGrandmotherCountryOfBirthDropdown;
    @FindBy(id = "parent1-parent2-country-of-birth") private WebElement maternalGrandfatherCountryOfBirthDropdown;
    @FindBy(id = "parent1-parents-married-true-label") private WebElement yesForMyParentOnesParentsMarriedOrInCivilPartnership;
    @FindBy(id = "parent1-parents-married-false-label") private WebElement noForMyParentOnesParentsMarriedOrInCivilPartnership;
    @FindBy(css = "#parent1-parent1-reason-reveal > summary > span") private WebElement cantProvideMaternalGrandMotherDetailsLink;
    @FindBy(css = "#parent1-parent1-reason-reveal") private WebElement cantProvideMaternalGrandMotherDetailsLinkEdit;
    @FindBy(css = "#parent1-parent2-reason-reveal > summary > span") private WebElement cantProvideMaternalGrandFatherDetailsLink;
    @FindBy(css = "#parent1-parent2-reason-reveal") private WebElement cantProvideMaternalGrandFatherDetailsLinkEdit;
    @FindBy(id = "parent1-parent1-no-details-reason") private WebElement insertReasonForMaternalGrandMotherField;
    @FindBy(id = "parent1-parent2-no-details-reason") private WebElement insertReasonForMaternalGrandFatherField;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, maternalGrandparentsDetailsPageHeader);
    }

    public void insertMaternalGrandParentOneFirstName(String firstName) {
        enterTextIntoTheField(maternalGrandParentOneFirstNameField, firstName);
        DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_ONE_FIRST_NAME, firstName);
    }

    public void insertMaternalGrandParentOneLastName(String lastName) {
        enterTextIntoTheField(maternalGrandParentOneLastNameField, lastName);
        DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_ONE_LAST_NAME, lastName);
    }

    public void insertMaternalGrandParentTwoFirstName(String firstName) {
        enterTextIntoTheField(maternalGrandParentTwoFirstNameField, firstName);
        DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_TWO_FIRST_NAME, firstName);

    }

    public void insertMaternalGrandParentTwoLastName(String lastName) {
        enterTextIntoTheField(maternalGrandParentTwoLastNameField, lastName);
        DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_TWO_LAST_NAME, lastName);
    }

    public void setMaternalGrandParentsMarriageDate(String grandparentsMarriageDate) {
        LocalDate dateOfMarriage = LocalDate.parse(grandparentsMarriageDate);
        enterTextIntoTheField(marriageDateDayMaternalGrandParentsField, String.valueOf(dateOfMarriage.getDayOfMonth()));
        enterTextIntoTheField(marriageDateMonthMaternalGrandParentsField, String.valueOf(dateOfMarriage.getMonthValue()));
        enterTextIntoTheField(marriageDateYearMaternalGrandParentsField, String.valueOf(dateOfMarriage.getYear()));

    }

    private void selectCountryOfBirthParentOnesParentOne(String countryCodeOfBirth) {
        Select maternalGrandmotherCountryOfBirthSelect = new Select(maternalGrandmotherCountryOfBirthDropdown);
        if ("UK".equalsIgnoreCase(countryCodeOfBirth)) {
            maternalGrandmotherCountryOfBirthSelect.selectByVisibleText("United Kingdom");
            DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_ONE_COUNTRY_OF_BIRTH, "United Kingdom");
            DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_ONE_COUNTRY_OF_BIRTH_CODE, "GB");
        } else {
            String countryName = getCountryName(countryCodeOfBirth);
            maternalGrandmotherCountryOfBirthSelect.selectByVisibleText(countryName);
            DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_ONE_COUNTRY_OF_BIRTH_CODE, countryCodeOfBirth);
            String country = CountryStore.countryHashMap.get(countryCodeOfBirth).get(4);
            DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_ONE_COUNTRY_OF_BIRTH, convertCountryTextToCountryAMSFormat(country));
        }
    }

    private void selectCountryOfBirthParentOnesParentTwo(String countryCodeOfBirth) {
        Select maternalGrandfatherCountryOfBirthSelect = new Select(maternalGrandfatherCountryOfBirthDropdown);
        if ("UK".equalsIgnoreCase(countryCodeOfBirth)) {
            maternalGrandfatherCountryOfBirthSelect.selectByVisibleText("United Kingdom");
            DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_TWO_COUNTRY_OF_BIRTH, "United Kingdom");
            DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_TWO_COUNTRY_OF_BIRTH_CODE, "GB");
        } else {
            String countryName = getCountryName(countryCodeOfBirth);
            maternalGrandfatherCountryOfBirthSelect.selectByVisibleText(countryName);
            DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_TWO_COUNTRY_OF_BIRTH_CODE, countryCodeOfBirth);
            String country = CountryStore.countryHashMap.get(countryCodeOfBirth).get(4);
            DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_TWO_COUNTRY_OF_BIRTH, convertCountryTextToCountryAMSFormat(country));
        }
    }

    private void setDateOfBirthDayParentOnesParentOne(String dateOfBirthDay) {
        enterTextIntoTheField(dobDayFieldMaternalGrandParentOne, dateOfBirthDay);
    }

    private void setDateOfBirthMonthParentOnesParentOne(String dateOfBirthMonth) {
        enterTextIntoTheField(dobMonthFieldMaternalGrandParentOne, dateOfBirthMonth);
    }

    private void setDateOfBirthYearParentOnesParentOne(String dateOfBirthYear) {
        enterTextIntoTheField(dobYearFieldMaternalGrandParentOne, dateOfBirthYear);
    }

    private void setParentOnesParentOneDateOfBirth(String date) {
        LocalDate dob = LocalDate.parse(date);

        setDateOfBirthDayParentOnesParentOne(Integer.toString(dob.getDayOfMonth()));
        setDateOfBirthMonthParentOnesParentOne(Integer.toString(dob.getMonthValue()));
        setDateOfBirthYearParentOnesParentOne(Integer.toString(dob.getYear()));
        DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_ONE_DOB, date);
    }

    private void setDateOfBirthDayParentOnesParentTwo(String dateOfBirthDay) {
        enterTextIntoTheField(dobDayFieldMaternalGrandParentTwo, dateOfBirthDay);
    }

    private void setDateOfBirthMonthParentOnesParentTwo(String dateOfBirthMonth) {
        enterTextIntoTheField(dobMonthFieldMaternalGrandParentTwo, dateOfBirthMonth);
    }

    private void setDateOfBirthYearParentOnesParentTwo(String dateOfBirthYear) {
        enterTextIntoTheField(dobYearFieldMaternalGrandParentTwo, dateOfBirthYear);
    }

    private void setParentOnesParentTwoDateOfBirth(String date) {
        LocalDate dob = LocalDate.parse(date);

        setDateOfBirthDayParentOnesParentTwo(Integer.toString(dob.getDayOfMonth()));
        setDateOfBirthMonthParentOnesParentTwo(Integer.toString(dob.getMonthValue()));
        setDateOfBirthYearParentOnesParentTwo(Integer.toString(dob.getYear()));
        DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_TWO_DATE_OF_BIRTH, date);
    }

    private void setTownOfBirthParentOnesParentOne(String townOfBirthParentOne) {
        enterTextIntoTheField(maternalGrandParentOneTownOfBirthField, townOfBirthParentOne);
        DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_ONE_PLACE_OF_BIRTH, townOfBirthParentOne);

    }

    private void setTownOfBirthParentOnesParentTwo(String townOfBirthParentOne) {
        enterTextIntoTheField(maternalGrandParentTwoTownOfBirthField, townOfBirthParentOne);
        DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_TWO_PLACE_OF_BIRTH, townOfBirthParentOne);
    }

    private void clickYesForMyParentOnesParentsMarriedOrInCivilPartnership() {
        clickOnElement(yesForMyParentOnesParentsMarriedOrInCivilPartnership);
    }

    private void clickNoForMyParentOnesParentsMarriedOrInCivilPartnership() {
        clickOnElement(noForMyParentOnesParentsMarriedOrInCivilPartnership);
    }

    private void choosesParentOnesParentsMarriedOrNot(Boolean parentOnesParentsMarried) {
        if (parentOnesParentsMarried) {
            clickYesForMyParentOnesParentsMarriedOrInCivilPartnership();

        } else {

            clickNoForMyParentOnesParentsMarriedOrInCivilPartnership();
        }
    }

    public void completeMaternalGrandParentOnesForm(ApplicantData applicantData) throws Exception {
        this.verifyPageHeader();
        this.insertMaternalGrandParentOneFirstName(applicantData.getParentOnesParentOneFirstName());
        this.insertMaternalGrandParentOneLastName(applicantData.getParentOnesParentOneLastName());
        this.setTownOfBirthParentOnesParentOne(applicantData.getParentOnesParentOneTownOfBirth());
        this.selectCountryOfBirthParentOnesParentOne(applicantData.getParentOnesParentOneCountryOfBirthCode());
        this.setParentOnesParentOneDateOfBirth(applicantData.getParentOnesParentOneBirthDate());
        DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_ONE_FIRST_NAME, applicantData.getParentOnesParentOneFirstName());
        DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_ONE_LAST_NAME, applicantData.getParentOnesParentOneLastName());
    }

    public void completeMaternalGrandParentTwosForm(ApplicantData applicantData) throws Exception {
        this.verifyPageHeader();
        this.insertMaternalGrandParentTwoFirstName(applicantData.getParentOnesParentTwoFirstName());
        this.insertMaternalGrandParentTwoLastName(applicantData.getParentOnesParentTwoLastName());
        this.setTownOfBirthParentOnesParentTwo(applicantData.getParentOnesParentTwoTownOfBirth());
        this.selectCountryOfBirthParentOnesParentTwo(applicantData.getParentOnesParentTwoCountryOfBirthCode());
        this.setParentOnesParentTwoDateOfBirth(applicantData.getParentOnesParentTwoBirthDate());
        DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_TWO_FIRST_NAME, applicantData.getParentOnesParentTwoFirstName());
        DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_TWO_LAST_NAME, applicantData.getParentOnesParentTwoLastName());
    }

    public void completeMaternalGrandParentsMarriedForm(ApplicantData applicantData) throws Exception {
        this.verifyPageHeader();
        this.choosesParentOnesParentsMarriedOrNot(applicantData.getParentOnesParentsMarriedStatus());
        if (applicantData.getParentOnesParentsMarriedStatus() && !isNullOrEmpty(applicantData.getParentOnesParentsMarriageDate())) {
            this.setMaternalGrandParentsMarriageDate(applicantData.getParentOnesParentsMarriageDate());
        }
    }

    public void enterWhyICannotProvideMaternalGrandMotherDetails() {
        if (cantProvideMaternalGrandMotherDetailsLinkEdit.getAttribute("open") == null) {
            clickOnElement(cantProvideMaternalGrandMotherDetailsLink);
        }
        enterTextIntoTheField(insertReasonForMaternalGrandMotherField, CANNOT_PROVIDE_MATERNAL_GRANDPARENT_ONE_DETAILS);
        DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_ONE_REASON, CANNOT_PROVIDE_MATERNAL_GRANDPARENT_ONE_DETAILS);
    }

    public void enterWhyICannotProvideMaternalGrandFatherDetails() {
        if (cantProvideMaternalGrandFatherDetailsLinkEdit.getAttribute("open") == null) {
            clickOnElement(cantProvideMaternalGrandFatherDetailsLink);
        }
        enterTextIntoTheField(insertReasonForMaternalGrandFatherField, CANNOT_PROVIDE_MATERNAL_GRANDPARENT_TWO_DETAILS);
        DataStore.setDataKey(DataStore.MATERNAL_GRAND_PARENT_TWO_REASON, CANNOT_PROVIDE_MATERNAL_GRANDPARENT_TWO_DETAILS);
    }
}
