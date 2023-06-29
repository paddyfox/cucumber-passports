package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactDetailsPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Contact details";
    private static final String PAGE_HEADER_WELSH = "Manylion cyswllt";

    @FindBy(tagName = "h1") private WebElement contactDetailsPageHeader;
    @FindBy(id = "contactEmail") private WebElement contactEmailField;
    @FindBy(id = "contactEmailConfirm") private WebElement contactEmailConfirmField;
    @FindBy(id = "contactPhone") private WebElement contactPhoneField;
    @FindBy(id = "dialling-code-contact") private WebElement contactDiallingCodeField;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, contactDetailsPageHeader);
    }

    public void setEmail(String email) {
        enterTextIntoTheField(contactEmailField, email);
    }

    public void setEmailConfirm(String email) {
        enterTextIntoTheField(contactEmailConfirmField, email);
        if (!contactEmailConfirmField.getAttribute("value").contains(email)) {
            enterTextIntoTheField(contactEmailConfirmField, email);

        }
    }

    public void setDefaultDiallingCode(String diallingCode) {
        enterTextIntoTheField(contactDiallingCodeField, diallingCode);
    }

    public void setMobileOrHomeNumber(String mobileOrHomeNumber) {
        clearMobileOrHomeNumberField();
        enterTextIntoTheField(contactPhoneField, mobileOrHomeNumber);
        if (!(contactPhoneField.getAttribute("value").contains(mobileOrHomeNumber))) {
            enterTextIntoTheField(contactPhoneField, mobileOrHomeNumber);
        }
    }

    public void clearMobileOrHomeNumberField() {
        contactPhoneField.clear();
    }

    public void completeEmailForm(String email) {
        this.setEmail(email);
        this.setEmailConfirm(email);
    }
}
