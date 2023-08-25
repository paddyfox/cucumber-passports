package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.countrystore.CountryStore;
import kainos.specs.datastore.DataStore;
import kainos.specs.helpers.ApplicantData;
import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;

import static com.google.common.base.Strings.isNullOrEmpty;
import static kainos.specs.helpers.CountryHelpers.convertCountryTextToCountryAMSFormat;
import static kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants.CANNOT_PROVIDE_PATERNAL_GRANDPARENT_ONE_DETAILS;
import static kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants.CANNOT_PROVIDE_PATERNAL_GRANDPARENT_TWO_DETAILS;

public class PaternalGrandparentsDetailsPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Paternal grandparents";
    private static final String PAGE_HEADER_WELSH = "Nain a thaid tadol";

    @FindBy(tagName = "h1")
    private WebElement paternalGrandparentsDetailsPageHeader;
    @FindBy(id = "parent2-parent1-first-name")
    private WebElement paternalGrandParentOneFirstNameField;
    @FindBy(id = "parent2-parent1-last-name")
    private WebElement paternalGrandParentOneLastNameField;
    @FindBy(id = "parent2-parent2-first-name")
    private WebElement paternalGrandParentTwoFirstNameField;
    @FindBy(id = "parent2-parent2-last-name")
    private WebElement paternalGrandParentTwoLastNameField;
    @FindBy(id = "parent2-parent1-date-of-birth-day")
    private WebElement dobDayFieldPaternalGrandParentOne;
    @FindBy(id = "parent2-parent1-date-of-birth-month")
    private WebElement dobMonthFieldPaternalGrandParentOne;
    @FindBy(id = "parent2-parent1-date-of-birth-year")
    private WebElement dobYearFieldPaternalGrandParentOne;
    @FindBy(id = "parent2-parent2-date-of-birth-day")
    private WebElement dobDayFieldPaternalGrandParentTwo;
    @FindBy(id = "parent2-parent2-date-of-birth-month")
    private WebElement dobMonthFieldPaternalGrandParentTwo;
    @FindBy(id = "parent2-parent2-date-of-birth-year")
    private WebElement dobYearFieldPaternalGrandParentTwo;
    @FindBy(id = "parent2-parents-marriage-date-day")
    private WebElement marriageDateDayPaternalGrandParentsField;
    @FindBy(id = "parent2-parents-marriage-date-month")
    private WebElement marriageDateMonthPaternalGrandParentsField;
    @FindBy(id = "parent2-parents-marriage-date-year")
    private WebElement marriageDateYearPaternalGrandParentsField;
    @FindBy(id = "parent2-parent1-no-details-reason")
    private WebElement insertReasonForPaternalGrandMotherField;
    @FindBy(id = "parent2-parent2-no-details-reason")
    private WebElement insertReasonForPaternalGrandFatherField;
    @FindBy(id = "parent2-parent1-town-of-birth")
    private WebElement paternalGrandParentOneTownOfBirthField;
    @FindBy(id = "parent2-parent2-town-of-birth")
    private WebElement paternalGrandParentTwoTownOfBirthField;
    @FindBy(css = "#parent2-parent1-reason-reveal > summary > span")
    private WebElement cantProvidePaternalGrandMotherDetailsLink;
    @FindBy(css = "#parent2-parent1-reason-reveal")
    private WebElement cantProvidePaternalGrandMotherDetailsLinkEdit;
    @FindBy(css = "#parent2-parent2-reason-reveal > summary > span")
    private WebElement cantProvidePaternalGrandFatherDetailsLink;
    @FindBy(css = "#parent2-parent2-reason-reveal")
    private WebElement cantProvidePaternalGrandFatherDetailsLinkEdit;
    @FindBy(id = "parent2-parent1-country-of-birth")
    private WebElement paternalGrandmotherCountryOfBirthDropdown;
    @FindBy(id = "parent2-parent2-country-of-birth")
    private WebElement paternalGrandfatherCountryOfBirthDropdown;
    @FindBy(id = "parent2-parents-married-true-label")
    private WebElement yesForMyParentTwosParentsMarriedOrInCivilPartnership;
    @FindBy(id = "parent2-parents-married-false-label")
    private WebElement noForMyParentTwosParentsMarriedOrInCivilPartnership;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, paternalGrandparentsDetailsPageHeader);
    }

    public void insertPaternalGrandParentOneFirstName(String firstName) {
        enterTextIntoTheField(paternalGrandParentOneFirstNameField, firstName);
        DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_ONE_FIRST_NAME, firstName);

    }

    public void insertPaternalGrandParentOneLastName(String lastName) {
        enterTextIntoTheField(paternalGrandParentOneLastNameField, lastName);
        DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_ONE_LAST_NAME, lastName);

    }

    public void insertPaternalGrandParentTwoFirstName(String firstName) {
        enterTextIntoTheField(paternalGrandParentTwoFirstNameField, firstName);
        DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_TWO_FIRST_NAME, firstName);

    }

    public void insertPaternalGrandParentTwoLastName(String lastName) {
        enterTextIntoTheField(paternalGrandParentTwoLastNameField, lastName);
        DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_TWO_LAST_NAME, lastName);
    }

    public void setPaternalGrandParentsMarriageDate(String grandparentsMarriageDate) {
        LocalDate dateOfMarriage = LocalDate.parse(grandparentsMarriageDate);
        enterTextIntoTheField(marriageDateDayPaternalGrandParentsField, String.valueOf(dateOfMarriage.getDayOfMonth()));
        enterTextIntoTheField(marriageDateMonthPaternalGrandParentsField, String.valueOf(dateOfMarriage.getMonthValue()));
        enterTextIntoTheField(marriageDateYearPaternalGrandParentsField, String.valueOf(dateOfMarriage.getYear()));
    }

    public void enterWhyICannotProvidePaternalGrandMotherDetails() {
        if (cantProvidePaternalGrandMotherDetailsLinkEdit.getAttribute("open") == null) {
            clickOnElement(cantProvidePaternalGrandMotherDetailsLink);
        }
        enterTextIntoTheField(insertReasonForPaternalGrandMotherField, CANNOT_PROVIDE_PATERNAL_GRANDPARENT_ONE_DETAILS);
        DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_ONE_REASON, CANNOT_PROVIDE_PATERNAL_GRANDPARENT_ONE_DETAILS);
    }

    public void enterWhyICannotProvidePaternalGrandFatherDetails() {
        if (cantProvidePaternalGrandFatherDetailsLinkEdit.getAttribute("open") == null) {
            clickOnElement(cantProvidePaternalGrandFatherDetailsLink);
        }
        enterTextIntoTheField(insertReasonForPaternalGrandFatherField, CANNOT_PROVIDE_PATERNAL_GRANDPARENT_TWO_DETAILS);
        DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_TWO_REASON, CANNOT_PROVIDE_PATERNAL_GRANDPARENT_TWO_DETAILS);

    }

    private void selectCountryOfBirthParentTwosParentOne(String countryCodeOfBirth) {
        Select paternalGrandmotherCountryOfBirthSelect = new Select(paternalGrandmotherCountryOfBirthDropdown);
        if ("UK".equalsIgnoreCase(countryCodeOfBirth)) {
            paternalGrandmotherCountryOfBirthSelect.selectByVisibleText("United Kingdom");
            DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_ONE_COUNTRY_OF_BIRTH, "United Kingdom");
            DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_ONE_COUNTRY_OF_BIRTH_CODE, "GB");

        } else {
            String countryName = getCountryName(countryCodeOfBirth);
            paternalGrandmotherCountryOfBirthSelect.selectByVisibleText(countryName);
            DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_ONE_COUNTRY_OF_BIRTH_CODE, countryCodeOfBirth);
            String country = CountryStore.countryHashMap.get(countryCodeOfBirth).get(4);
            DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_ONE_COUNTRY_OF_BIRTH, convertCountryTextToCountryAMSFormat(country));
        }
    }

    private void selectCountryOfBirthParentTwosParentTwo(String countryCodeOfBirth) {
        Select paternalGrandfatherCountryOfBirthSelect = new Select(paternalGrandfatherCountryOfBirthDropdown);
        if ("UK".equalsIgnoreCase(countryCodeOfBirth)) {
            paternalGrandfatherCountryOfBirthSelect.selectByVisibleText("United Kingdom");
            DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_TWO_COUNTRY_OF_BIRTH, "United Kingdom");
            DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_TWO_COUNTRY_OF_BIRTH_CODE, "GB");

        } else {
            String countryName = getCountryName(countryCodeOfBirth);
            paternalGrandfatherCountryOfBirthSelect.selectByVisibleText(countryName);
            DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_TWO_COUNTRY_OF_BIRTH_CODE, countryCodeOfBirth);
            String country = CountryStore.countryHashMap.get(countryCodeOfBirth).get(4);
            DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_TWO_COUNTRY_OF_BIRTH, convertCountryTextToCountryAMSFormat(country));
        }
    }

    private void setDateOfBirthDayParentTwosParentOne(String dateOfBirthDay) {
        enterTextIntoTheField(dobDayFieldPaternalGrandParentOne, dateOfBirthDay);
    }

    private void setDateOfBirthMonthParentTwosParentOne(String dateOfBirthMonth) {
        enterTextIntoTheField(dobMonthFieldPaternalGrandParentOne, dateOfBirthMonth);
    }

    private void setDateOfBirthYearParentTwosParentOne(String dateOfBirthYear) {
        enterTextIntoTheField(dobYearFieldPaternalGrandParentOne, dateOfBirthYear);
    }

    private void setParentTwosParentOneDateOfBirth(String date) {
        LocalDate dob = LocalDate.parse(date);

        setDateOfBirthDayParentTwosParentOne(Integer.toString(dob.getDayOfMonth()));
        setDateOfBirthMonthParentTwosParentOne(Integer.toString(dob.getMonthValue()));
        setDateOfBirthYearParentTwosParentOne(Integer.toString(dob.getYear()));
        DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_ONE_DATE_OF_BIRTH, date);

    }

    private void setDateOfBirthDayParentTwosParentTwo(String dateOfBirthDay) {
        enterTextIntoTheField(dobDayFieldPaternalGrandParentTwo, dateOfBirthDay);
    }

    private void setDateOfBirthMonthParentTwosParentTwo(String dateOfBirthMonth) {
        enterTextIntoTheField(dobMonthFieldPaternalGrandParentTwo, dateOfBirthMonth);
    }

    private void setDateOfBirthYearParentTwosParentTwo(String dateOfBirthYear) {
        enterTextIntoTheField(dobYearFieldPaternalGrandParentTwo, dateOfBirthYear);
    }

    private void setParentTwosParentTwoDateOfBirth(String date) {
        LocalDate dob = LocalDate.parse(date);

        setDateOfBirthDayParentTwosParentTwo(Integer.toString(dob.getDayOfMonth()));
        setDateOfBirthMonthParentTwosParentTwo(Integer.toString(dob.getMonthValue()));
        setDateOfBirthYearParentTwosParentTwo(Integer.toString(dob.getYear()));
        DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_TWO_DATE_OF_BIRTH, date);
    }

    private void setTownOfBirthParentTwosParentOne(String townOfBirthParentOne) {
        enterTextIntoTheField(paternalGrandParentOneTownOfBirthField, townOfBirthParentOne);
        DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_ONE_PLACE_OF_BIRTH, townOfBirthParentOne);
    }

    private void setTownOfBirthParentTwosParentTwo(String townOfBirthParentOne) {
        enterTextIntoTheField(paternalGrandParentTwoTownOfBirthField, townOfBirthParentOne);
        DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_TWO_PLACE_OF_BIRTH, townOfBirthParentOne);
    }

    private void clickYesForMyParentTwosParentsMarriedOrInCivilPartnership() {
        clickOnElement(yesForMyParentTwosParentsMarriedOrInCivilPartnership);
    }

    private void clickNoForMyParentTwosParentsMarriedOrInCivilPartnership() {
        clickOnElement(noForMyParentTwosParentsMarriedOrInCivilPartnership);
    }

    private void choosesParentTwosParentsMarriedOrNot(Boolean parentTwosParentsMarried) {
        if (parentTwosParentsMarried) {
            clickYesForMyParentTwosParentsMarriedOrInCivilPartnership();
        } else {
            clickNoForMyParentTwosParentsMarriedOrInCivilPartnership();
        }
    }

    public void completePaternalGrandParentOnesForm(ApplicantData applicantData) throws Exception {
        this.verifyPageHeader();
        this.insertPaternalGrandParentOneFirstName(applicantData.getParentTwosParentOneFirstName());
        this.insertPaternalGrandParentOneLastName(applicantData.getParentTwosParentOneLastName());
        this.setTownOfBirthParentTwosParentOne(applicantData.getParentTwosParentOneTownOfBirth());
        this.selectCountryOfBirthParentTwosParentOne(applicantData.getParentTwosParentOneCountryOfBirthCode());
        this.setParentTwosParentOneDateOfBirth(applicantData.getParentTwosParentOneBirthDate());
        DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_ONE_FIRST_NAME, applicantData.getParentTwosParentOneFirstName());
        DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_ONE_LAST_NAME, applicantData.getParentTwosParentOneLastName());
    }

    public void completePaternalGrandParentTwosForm(ApplicantData applicantData) throws Exception {
        this.verifyPageHeader();
        this.insertPaternalGrandParentTwoFirstName(applicantData.getParentTwosParentTwoFirstName());
        this.insertPaternalGrandParentTwoLastName(applicantData.getParentTwosParentTwoLastName());
        this.setTownOfBirthParentTwosParentTwo(applicantData.getParentTwosParentTwoTownOfBirth());
        this.selectCountryOfBirthParentTwosParentTwo(applicantData.getParentTwosParentTwoCountryOfBirthCode());
        this.setParentTwosParentTwoDateOfBirth(applicantData.getParentTwosParentTwoBirthDate());
        DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_TWO_FIRST_NAME, applicantData.getParentTwosParentTwoFirstName());
        DataStore.setDataKey(DataStore.PATERNAL_GRAND_PARENT_TWO_LAST_NAME, applicantData.getParentTwosParentTwoLastName());
    }

    public void completePaternalGrandParentsMarriedForm(ApplicantData applicantData) throws Exception {
        this.verifyPageHeader();
        this.choosesParentTwosParentsMarriedOrNot(applicantData.getParentTwosParentsMarriedStatus());
        if (applicantData.getParentTwosParentsMarriedStatus() && !isNullOrEmpty(applicantData.getParentTwosParentsMarriageDate())) {
            this.setPaternalGrandParentsMarriageDate(applicantData.getParentTwosParentsMarriageDate());
        }
    }
}
