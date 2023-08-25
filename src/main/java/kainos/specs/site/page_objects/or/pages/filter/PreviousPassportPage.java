package kainos.specs.site.page_objects.or.pages.filter;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreviousPassportPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Have you had a UK passport before?";
    private static final String PAGE_HEADER_WELSH = "A ydych chi wedi cael pasbort y Deyrnas Unedig o’r blaen?";

    @FindBy(className = "govuk-fieldset__heading")
    private WebElement pageHeader;
    @FindBy(id = "previousPassport-true-label")
    private WebElement previousPassportTrueButton;
    @FindBy(id = "previousPassport-false-label")
    private WebElement previousPassportFalseButton;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, pageHeader);
    }

    public void selectIfHasPreviousPassport(Boolean hasPreviousPassport) {
        if (hasPreviousPassport) {
            clickOnElement(previousPassportTrueButton);
        } else {
            clickOnElement(previousPassportFalseButton);
        }
    }

}
