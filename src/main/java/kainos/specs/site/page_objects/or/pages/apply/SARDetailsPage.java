package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants.SAR_CANNOT_SIGN_REASON;

public class SARDetailsPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Signing a new passport";
    private static final String PAGE_HEADER_WELSH = "Llofnodi pasbort newydd";

    @FindBy(tagName = "h1")
    private WebElement sarPageHeader;
    @FindBy(id = "canSign-true-label")
    private WebElement iCanSignInButton;
    @FindBy(id = "canSign-false-label")
    private WebElement iCantSignInButton;
    @FindBy(id = "noSignReason")
    private WebElement insertReasonField;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, sarPageHeader);
    }

    public void choosesToSign(Boolean choice) {
        if (choice) {
            selectCanSignIn();
        } else {
            selectCanNotSignIn();
            insertReason();
        }
    }

    public void selectCanSignIn() {
        clickOnElement(iCanSignInButton);
    }

    public void selectCanNotSignIn() {
        clickOnElement(iCantSignInButton);
        insertReason();
    }

    public void insertReason() {
        enterTextIntoTheField(insertReasonField, SAR_CANNOT_SIGN_REASON);
    }
}
