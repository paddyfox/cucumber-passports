package kainos.specs.site.page_objects.or.pages.photo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import kainos.specs.site.Site;

public class PhotoGuideHowToGetADigitalPhotoPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "How to get a digital passport photo";
    private static final String PAGE_HEADER_WELSH = "Sut i gael llun pasbort digidol";

    @FindBy(tagName = "h1") private WebElement pageHeader;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, pageHeader);
    }
}
