package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DocumentsPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "What you need to send";
    private static final String PAGE_HEADER_WELSH = "Yr hyn sydd angen i chi anfon";

    @FindBy(tagName = "h1")
    private WebElement documentsToSendPageHeader;
    @FindBy(id = "documents-to-send-true-label")
    private WebElement docsToSendYesRadio;
    @FindBy(id = "documents-to-send-false-label")
    private WebElement docsToSendNoRadio;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, documentsToSendPageHeader);
    }

    public void selectDocumentsToSendYesRadio() {
        clickOnElement(docsToSendYesRadio);
    }

    public void selectDocumentsToSendNoRadio() {
        clickOnElement(docsToSendNoRadio);
    }
}
