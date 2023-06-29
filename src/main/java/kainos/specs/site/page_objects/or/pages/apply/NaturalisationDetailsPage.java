package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import kainos.specs.datastore.DataStore;

import java.time.LocalDate;

public class NaturalisationDetailsPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Naturalisation or registration details";
    private static final String PAGE_HEADER_WELSH = "Manylion brodori neu gofrestriad";

    private static final String HREF = "href";

    @FindBy(tagName = "h1") private WebElement naturalisationDetailsPageHeader;
    @FindBy(id = "naturalisationCertificateNumber") private WebElement certificateNumberField;
    @FindBy(id = "naturalisationIssueDate-day") private WebElement issueDateDayField;
    @FindBy(id = "naturalisationIssueDate-month") private WebElement issueDateMonthField;
    @FindBy(id = "naturalisationIssueDate-year") private WebElement issueDateYearField;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, naturalisationDetailsPageHeader);
    }

    public void enterCertificateNumber(String certificateNumber) {
        enterTextIntoTheField(certificateNumberField, certificateNumber);
    }

    public void enterIssueDate(String day, String month, String year) {
        enterTextIntoTheField(issueDateDayField, day);
        enterTextIntoTheField(issueDateMonthField, month);
        enterTextIntoTheField(issueDateYearField, year);
    }

    public void completeForm(String certificateNumber, String naturalisationDate, String applicationType) throws Exception {
        LocalDate date = LocalDate.parse(naturalisationDate);
        String day = Integer.toString(date.getDayOfMonth());
        String month = Integer.toString(date.getMonthValue());
        String year = Integer.toString(date.getYear());
        this.enterCertificateNumber(certificateNumber);
        this.enterIssueDate(day, month, year);
        DataStore.setDataKey(DataStore.NATURALISATION_CERTIFICATE_ISSUE_DATE, naturalisationDate);
        DataStore.setDataKey(DataStore.NATURALISATION_CERTIFICATE_NUMBER, certificateNumber);
    }
}
