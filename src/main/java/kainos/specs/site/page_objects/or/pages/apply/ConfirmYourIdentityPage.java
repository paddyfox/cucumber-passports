package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmYourIdentityPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Confirm your identity";
    private static final String PAGE_HEADER_WELSH = "Cadarnhau pwy ydych chi";

    @FindBy(tagName = "h1") private WebElement confirmYourIdentityPageHeader;

    public void verifyPageHeader() throws Exception { verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, confirmYourIdentityPageHeader); }
}
