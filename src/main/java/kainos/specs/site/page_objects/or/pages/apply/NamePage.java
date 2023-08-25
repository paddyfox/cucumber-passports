package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.datastore.DataStore;
import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants.TITLE_MAX_VALUE;

public class NamePage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "New passport details";
    private static final String PAGE_HEADER_WELSH = "Manylion pasbort newydd";

    @FindBy(tagName = "h1")
    private WebElement namePageHeader;
    @FindBy(id = "title-Mr-label")
    private WebElement mrButton;
    @FindBy(id = "title-Ms-label")
    private WebElement msButton;
    @FindBy(id = "title-Mrs-label")
    private WebElement mrsButton;
    @FindBy(id = "title-Other-label")
    private WebElement otherButton;
    @FindBy(id = "title-Master-label")
    private WebElement masterButton;
    @FindBy(id = "title-Miss-label")
    private WebElement missButton;
    @FindBy(id = "otherTitle")
    private WebElement otherTitleField;
    @FindBy(id = "firstName")
    private WebElement firstNameField;
    @FindBy(id = "lastName")
    private WebElement lastNameField;
    @FindBy(id = "changeOfName-true-label")
    private WebElement sameNameNoButton;
    @FindBy(id = "changeOfName-false-label")
    private WebElement sameNameYesButton;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, namePageHeader);
    }

    private void setOtherTitle(String title) {
        clickOnElement(otherButton);
        otherTitleField.clear();
        enterTextIntoTheField(otherTitleField, title);
    }

    public void insertFirstName(String firstName) {
        firstNameField.clear();
        enterTextIntoTheField(firstNameField, firstName);
    }

    public void insertLastName(String lastName) {
        lastNameField.clear();
        enterTextIntoTheField(lastNameField, lastName);
    }

    public void selectYesToSameNameInOldPassport() {
        clickOnElement(sameNameYesButton);
    }

    public void selectNoMyNameHasChangedSinceMyOldPassport() {
        clickOnElement(sameNameNoButton);
    }

    public void chooseTitle(String title) {
        switch (title) {
            case "Mr":
                clickOnElement(mrButton);
                DataStore.setDataKey(DataStore.TITLE, "Mr");
                break;
            case "Ms":
                clickOnElement(msButton);
                DataStore.setDataKey(DataStore.TITLE, "Ms");
                break;
            case "Miss":
                clickOnElement(missButton);
                DataStore.setDataKey(DataStore.TITLE, "Miss");
                break;
            case "Mrs":
                clickOnElement(mrsButton);
                DataStore.setDataKey(DataStore.TITLE, "Mrs");
                break;
            case "Master":
                clickOnElement(masterButton);
                DataStore.setDataKey(DataStore.TITLE, "Master");
                break;
            case "Other":
                setOtherTitle(TITLE_MAX_VALUE);
                DataStore.setDataKey(DataStore.TITLE, TITLE_MAX_VALUE);
                break;
            default:
                throw new IllegalArgumentException("No behaviour defined!");
        }
    }

    public void completeForm(String title, String firstName, String surname) {
        this.chooseTitle(title);
        this.insertFirstName(firstName);
        this.insertLastName(surname);
    }
}
