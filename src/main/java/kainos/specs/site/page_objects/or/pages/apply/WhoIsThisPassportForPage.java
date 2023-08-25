package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhoIsThisPassportForPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Who is the passport for?";
    private static final String PAGE_HEADER_WELSH = "Ar gyfer pwy mae’r pasbort?";

    @FindBy(tagName = "h1")
    private WebElement whoIsThisPassportForPageHeader;
    @FindBy(id = "thirdParty-false-label")
    private WebElement meButton;
    @FindBy(id = "thirdParty-true-label")
    private WebElement someoneElseButton;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, whoIsThisPassportForPageHeader);
    }

    public void choosesRecipient(String recipient) {
        switch (recipient) {
            case "Me":
                clickOnElement(meButton);
                break;
            case "Someone else":
                clickOnElement(someoneElseButton);
                break;
            default:
                throw new IllegalArgumentException("No behaviour defined for recipient");
        }
    }
}
