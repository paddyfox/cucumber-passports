package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TownOfBirthPage extends Site {

    private static final String PAGE_HEADER = "Town of birth";

    @FindBy(tagName = "h1")
    private WebElement townOfBirthPageHeader;
    @FindBy(id = "town-of-birth")
    private WebElement townOfBirthField;

    public void verifyPageHeader() throws Exception {
        verifyPageHeader(PAGE_HEADER, townOfBirthPageHeader);
    }

    public void enterTownOfBirth(String townOfBirth) {
        enterTextIntoTheField(townOfBirthField, townOfBirth);
    }
}
