package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangeOfNamePage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "How did you change your name?";
    private static final String PAGE_HEADER_WELSH = "Sut wnaethoch chi newid eich enw?";

    @FindBy(className = "govuk-fieldset__heading") private WebElement pageHeader;
    @FindBy(id = "nameChangeReason-marriage-label") private WebElement nameChangeReasonMarriageButton;
    @FindBy(id = "nameChangeReason-divorce-label") private WebElement nameChangeReasonDivorcedButton;
    @FindBy(id = "nameChangeReason-gender-label") private WebElement nameChangeReasonGenderReassignmentButton;
    @FindBy(id = "nameChangeReason-other-label") private WebElement nameChangeReasonOtherButton;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, pageHeader);
    }

    public void selectNameChangeReason(String reason) {
        switch (reason) {
            case "Marriage":
                clickOnElement(nameChangeReasonMarriageButton);
                break;
            case "Divorced":
                clickOnElement(nameChangeReasonDivorcedButton);
                break;
            case "GenderReassignment":
                clickOnElement(nameChangeReasonGenderReassignmentButton);
                break;
            case "Other":
                clickOnElement(nameChangeReasonOtherButton);
                break;
            default:
                throw new IllegalArgumentException("No behaviour defined!");
        }
    }
}
