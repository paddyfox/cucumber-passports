package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PreviousNamePage extends Site {

    private static final String PREVIOUS_NAMES_PAGE_HEADER_ENGLISH = "Previous names";
    private static final String PREVIOUS_NAMES_PAGE_HEADER_WELSH = "Enwau blaenorol";
    private static final String OTHER_NAMES_PAGE_HEADER_ENGLISH = "Have you ever used any other names?";
    private static final String OTHER_NAMES_PAGE_HEADER_WELSH = "A ydych chi erioed wedi defnyddio unrhyw enwau eraill?";

    @FindBy(tagName = "h1") private WebElement previousNamePageHeader;
    @FindBy(className = "govuk-fieldset__heading") private WebElement otherNamesPageHeader;
    @FindBy(id = "previous-names-false-label") private WebElement otherNameNoButton;
    @FindBy(id = "previous-names-true-label") private WebElement otherNameYesButton;
    @FindBy(id = "previousFirstName1") private WebElement previousFirstNameMiddleNameField0;
    @FindBy(id = "previousLastName1") private WebElement previousLastNamesField0;

    public void verifyPreviousNamesPageHeader() throws Exception {
        verifyHeaderBilingual(PREVIOUS_NAMES_PAGE_HEADER_WELSH, PREVIOUS_NAMES_PAGE_HEADER_ENGLISH, previousNamePageHeader);
    }

    public void verifyOtherNamesPageHeader() throws Exception {
        verifyHeaderBilingual(OTHER_NAMES_PAGE_HEADER_WELSH, OTHER_NAMES_PAGE_HEADER_ENGLISH, otherNamesPageHeader);
    }

    public void selectNotKnownByAnyOtherName() {
        clickOnElement(otherNameNoButton);
    }

    public void selectKnownByAnyOtherName() {
        clickOnElement(otherNameYesButton);
    }

    public void insertPreviousNames(List<String> previousFirstName, List<String> previousLastName) {
                enterTextIntoTheField(previousFirstNameMiddleNameField0, String.valueOf(previousFirstName.get(0)));
                enterTextIntoTheField(previousLastNamesField0, String.valueOf(previousLastName.get(0)));
    }
}
