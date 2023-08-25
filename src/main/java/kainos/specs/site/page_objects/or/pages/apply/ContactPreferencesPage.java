package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPreferencesPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Get updates";
    private static final String PAGE_HEADER_WELSH = "Cael diweddariadau";

    @FindBy(tagName = "h1")
    private WebElement contactPreferencesPageHeader;
    @FindBy(id = "contactPrefsEmail-label")
    private WebElement emailContactButton;
    @FindBy(id = "contactPrefsSMS")
    private WebElement smsContactButton;
    @FindBy(id = "dialling-code-sms")
    private WebElement diallingCodeSMSField;
    @FindBy(id = "mobilePhone")
    private WebElement contactMobilePhoneField;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, contactPreferencesPageHeader);
    }

    public void chooseEmailUpdates(Boolean choice) {
        if (choice) checkEmailUpdates();
    }

    public void chooseTextMessageUpdates(Boolean choice) {
        if (choice) checkTextMessageUpdates();
    }

    public void checkEmailUpdates() {
        clickOnElement(emailContactButton);
    }

    public void checkTextMessageUpdates() {
        clickOnElement(smsContactButton);
    }

    public void setDefaultDiallingCodeForSMS(String diallingCode) {
        enterTextIntoTheField(diallingCodeSMSField, diallingCode);
    }

    public void setMobileNumberForTextUpdates(String mobileNumber) {
        contactMobilePhoneField.clear();
        enterTextIntoTheField(contactMobilePhoneField, mobileNumber);
        if (!(contactMobilePhoneField.getAttribute("value").contains(mobileNumber))) {
            enterTextIntoTheField(contactMobilePhoneField, mobileNumber);
        }
    }
}
