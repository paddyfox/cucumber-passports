package kainos.specs.site.page_objects.or.pages.photo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import kainos.specs.site.Site;

public class PhotoCodeResultPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Check your photo";
    private static final String PAGE_HEADER_WELSH = "Gwirio eich llun";

    @FindBy(tagName = "h1") private WebElement pageHeader;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingualWithRetry(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, pageHeader);
    }
}
