package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicationConfirmationPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "What you need to do";
    private static final String PAGE_HEADER_WELSH = "Beth sydd angen i chi ei wneud";

    @FindBy(tagName = "h1") private WebElement nextStepPageHeader;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, nextStepPageHeader);
    }
}
