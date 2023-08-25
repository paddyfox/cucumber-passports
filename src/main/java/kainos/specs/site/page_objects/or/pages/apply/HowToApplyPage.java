package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HowToApplyPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "How to apply";
    private static final String PAGE_HEADER_WELSH = "Sut i wneud cais";

    @FindBy(tagName = "h1")
    private WebElement howToApplyPageHeader;
    @FindBy(css = "#main-content > div > div > form > button")
    private WebElement continueButton;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, howToApplyPageHeader);
    }

    public void continueButton() {
        clickOnElement(continueButton);
    }
}
