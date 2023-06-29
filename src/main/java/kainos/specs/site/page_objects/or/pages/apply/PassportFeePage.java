package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PassportFeePage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Passport fee";
    private static final String PAGE_HEADER_WELSH = "Ffi pasbort";

    @FindBy(tagName = "h1") private WebElement passportFeePageHeader;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, passportFeePageHeader);
    }
}
