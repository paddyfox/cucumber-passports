package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.datastore.DataStore;
import kainos.specs.helpers.ApplicantData;
import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

import static com.google.common.base.Strings.isNullOrEmpty;
import static kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants.CANNOT_PROVIDE_PARENT_ONE_DETAILS;
import static kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants.CANNOT_PROVIDE_PARENT_TWO_DETAILS;

public class ParentsDetailsPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Parents’ details";
    private static final String PAGE_HEADER_WELSH = "Manylion rhieni";

    public static String PARENTS_MARRIED_STATUS_KEY;

    @FindBy(tagName = "h1")
    private WebElement parentsDetailsPageHeader;
    @FindBy(id = "parent1FirstName")
    private WebElement parentOneFirstNameField;
    @FindBy(id = "parent1LastName")
    private WebElement parentOneLastNameField;
    @FindBy(id = "parent2FirstName")
    private WebElement parentTwoFirstNameField;
    @FindBy(id = "parent2LastName")
    private WebElement parentTwoLastNameField;
    @FindBy(id = "parent1DateOfBirth-day")
    private WebElement dobDayFieldParentOne;
    @FindBy(id = "parent1DateOfBirth-month")
    private WebElement dobMonthFieldParentOne;
    @FindBy(id = "parent1DateOfBirth-year")
    private WebElement dobYearFieldParentOne;
    @FindBy(id = "parent2DateOfBirth-day")
    private WebElement dobDayFieldParentTwo;
    @FindBy(id = "parent2DateOfBirth-month")
    private WebElement dobMonthFieldParentTwo;
    @FindBy(id = "parent2DateOfBirth-year")
    private WebElement dobYearFieldParentTwo;
    @FindBy(id = "parentsMarriageDate-day")
    private WebElement marriageDateDayParentsField;
    @FindBy(id = "parentsMarriageDate-month")
    private WebElement marriageDateMonthParentsField;
    @FindBy(id = "parentsMarriageDate-year")
    private WebElement marriageDateYearParentsField;
    @FindBy(id = "parent1NoDetailsReason")
    private WebElement insertReasonForParentOneField;
    @FindBy(id = "parent2NoDetailsReason")
    private WebElement insertReasonForParentTwoField;
    @FindBy(id = "parentsMarried-true-label")
    private WebElement yesToParentsMarriedOrInCivilPartnershipButton;
    @FindBy(id = "parentsMarried-false-label")
    private WebElement noToParentsMarriedOrInCivilPartnershipButton;
    @FindBy(css = "#parent1ReasonReveal > summary > span")
    private WebElement cantProvideParentOneDetailsLink;
    @FindBy(css = "#parent2ReasonReveal > summary > span")
    private WebElement cantProvideParentTwoDetailsLink;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, parentsDetailsPageHeader);
    }

    public void insertParentOneFirstName(String firstName) {
        enterTextIntoTheField(parentOneFirstNameField, firstName);
        DataStore.setDataKey(DataStore.PARENT_ONE_FIRST_NAME, firstName);
    }

    public void insertParentOneLastName(String lastName) {
        enterTextIntoTheField(parentOneLastNameField, lastName);
        DataStore.setDataKey(DataStore.PARENT_ONE_LAST_NAME, lastName);
    }

    public void insertParentTwoFirstName(String firstName) {
        enterTextIntoTheField(parentTwoFirstNameField, firstName);
        DataStore.setDataKey(DataStore.PARENT_TWO_FIRST_NAME, firstName);
    }

    public void insertParentTwoLastName(String lastName) {
        enterTextIntoTheField(parentTwoLastNameField, lastName);
        DataStore.setDataKey(DataStore.PARENT_TWO_LAST_NAME, lastName);
    }

    public void setParentOneDateOfBirth(String parentDateOfBirth) {
        if (!isNullOrEmpty(parentDateOfBirth)) {
            LocalDate dateOfBirth = LocalDate.parse(parentDateOfBirth);
            enterTextIntoTheField(dobDayFieldParentOne, String.valueOf(dateOfBirth.getDayOfMonth()));
            enterTextIntoTheField(dobMonthFieldParentOne, String.valueOf(dateOfBirth.getMonthValue()));
            enterTextIntoTheField(dobYearFieldParentOne, String.valueOf(dateOfBirth.getYear()));
        }
    }

    public void setParentTwoDateOfBirth(String parentDateOfBirth) {
        if (!isNullOrEmpty(parentDateOfBirth)) {
            LocalDate dateOfBirth = LocalDate.parse(parentDateOfBirth);
            enterTextIntoTheField(dobDayFieldParentTwo, String.valueOf(dateOfBirth.getDayOfMonth()));
            enterTextIntoTheField(dobMonthFieldParentTwo, String.valueOf(dateOfBirth.getMonthValue()));
            enterTextIntoTheField(dobYearFieldParentTwo, String.valueOf(dateOfBirth.getYear()));
        }
    }

    public void setParentsMarriageDate(String parentsMarriageDate) {
        if (!isNullOrEmpty(parentsMarriageDate)) {
            LocalDate dateOfMarriage = LocalDate.parse(parentsMarriageDate);
            enterTextIntoTheField(marriageDateDayParentsField, String.valueOf(dateOfMarriage.getDayOfMonth()));
            enterTextIntoTheField(marriageDateMonthParentsField, String.valueOf(dateOfMarriage.getMonthValue()));
            enterTextIntoTheField(marriageDateYearParentsField, String.valueOf(dateOfMarriage.getYear()));
        }
    }

    public void clickYesForMyParentsMarriedOrInCivilPartnership() {
        clickOnElement(yesToParentsMarriedOrInCivilPartnershipButton);
        DataStore.setDataKey(PARENTS_MARRIED_STATUS_KEY, "YES");
    }

    public void clickNoForMyParentsMarriedOrInCivilPartnership() {
        clickOnElement(noToParentsMarriedOrInCivilPartnershipButton);
        DataStore.setDataKey(PARENTS_MARRIED_STATUS_KEY, "NO");
    }

    public void enterWhyICannotProvideParentOneDetails() {
        if (cantProvideParentOneDetailsLink.getAttribute("open") == null) {
            clickOnElement(cantProvideParentOneDetailsLink);
        }
        enterTextIntoTheField(insertReasonForParentOneField, CANNOT_PROVIDE_PARENT_ONE_DETAILS);
        DataStore.setDataKey(DataStore.MOTHER_REASON, CANNOT_PROVIDE_PARENT_ONE_DETAILS);
    }

    public void enterWhyICannotProvideParentTwoDetails() {
        if (cantProvideParentTwoDetailsLink.getAttribute("open") == null) {
            clickOnElement(cantProvideParentTwoDetailsLink);
        }
        enterTextIntoTheField(insertReasonForParentTwoField, CANNOT_PROVIDE_PARENT_TWO_DETAILS);
        DataStore.setDataKey(DataStore.FATHER_REASON, CANNOT_PROVIDE_PARENT_TWO_DETAILS);
    }

    public void choosesParentsMarriedOrNot(Boolean parentsMarried) {
        if (parentsMarried) {
            clickYesForMyParentsMarriedOrInCivilPartnership();
        } else {
            clickNoForMyParentsMarriedOrInCivilPartnership();
            clickContinue();
        }
    }

    public void completeParentOneForm(ApplicantData applicantData) {
        this.insertParentOneFirstName(applicantData.getParentOneFirstName());
        this.insertParentOneLastName(applicantData.getParentOneLastName());
        this.setParentOneDateOfBirth(applicantData.getParentOneBirthDate());
        DataStore.setDataKey(DataStore.PARENT_ONE_FIRST_NAME, applicantData.getParentOneFirstName());
        DataStore.setDataKey(DataStore.PARENT_ONE_LAST_NAME, applicantData.getParentOneLastName());
        DataStore.setDataKey(DataStore.PARENT_ONE_BIRTH_DATE, applicantData.getParentOneBirthDate());
    }

    public void completeParentTwoForm(ApplicantData applicantData) {
        this.insertParentTwoFirstName(applicantData.getParentTwoFirstName());
        this.insertParentTwoLastName(applicantData.getParentTwoLastName());
        this.setParentTwoDateOfBirth(applicantData.getParentTwoBirthDate());
        DataStore.setDataKey(DataStore.PARENT_TWO_FIRST_NAME, applicantData.getParentTwoFirstName());
        DataStore.setDataKey(DataStore.PARENT_TWO_LAST_NAME, applicantData.getParentTwoLastName());
        DataStore.setDataKey(DataStore.PARENT_TWO_BIRTH_DATE, applicantData.getParentTwoBirthDate());

    }
}

