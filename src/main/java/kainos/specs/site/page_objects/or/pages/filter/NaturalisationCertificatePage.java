package kainos.specs.site.page_objects.or.pages.filter;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import kainos.specs.datastore.DataStore;

public class NaturalisationCertificatePage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Do you have a naturalisation or registration certificate?";
    private static final String PAGE_HEADER_WELSH = "A oes gennych chi dystysgrif brodori neu gofrestriad?";

    @FindBy(className = "govuk-fieldset__heading") private WebElement pageHeader;
    @FindBy(id= "naturalised-true-label") private WebElement yesNaturalisationCertificateButton;
    @FindBy(id= "naturalised-false-label") private WebElement noNaturalisationCertificateButton;


    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, pageHeader);
    }

    public void selectIfHasNaturalisationCertificate(Boolean hasNaturalisationCertificate) {
        if (hasNaturalisationCertificate) {
            clickOnElement(yesNaturalisationCertificateButton);
            DataStore.setDataKey(DataStore.HAS_NATURALISATION_CERTIFICATE, "true");
        }
        else {
            clickOnElement(noNaturalisationCertificateButton);
            DataStore.setDataKey(DataStore.HAS_NATURALISATION_CERTIFICATE, "false");
        }
    }
}
