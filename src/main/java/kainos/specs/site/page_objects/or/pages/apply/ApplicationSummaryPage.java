package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicationSummaryPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Apply for a UK passport";
    private static final String PAGE_HEADER_WELSH = "Ymgeisio am basbort y Deyrnas Unedig";
    private static final String PAGE_HEADER_FIRST_ENGLISH = "Apply for a first UK passport";
    private static final String PAGE_HEADER_FIRST_WELSH = "Ymgeisio am basbort cyntaf y Deyrnas Unedig";

    @FindBy(tagName = "h1") private WebElement applicationSummaryPageHeader;
    @FindBy(css = "#main-content > div > div > form > button") private WebElement contButton;

    public void verifyPageHeaderApplyingForUKPassport() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, applicationSummaryPageHeader);
    }

    public void verifyPageHeaderApplyingForFirstUKPassport() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_FIRST_WELSH, PAGE_HEADER_FIRST_ENGLISH, applicationSummaryPageHeader);
    }

    public void clickCont() {
        clickOnElement(contButton);
    }
}
