package kainos.specs.site.page_objects.or.pages.photo;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhotoGuideHowToTakeADigitalPhotoPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "How to take a digital passport photo";
    private static final String PAGE_HEADER_WELSH = "Sut i gymryd llun pasbort digidol";

    @FindBy(tagName = "h1")
    private WebElement photoGuidePageHeader;
    @FindBy(css = "#main-content > div > div > h2")
    private WebElement photoGuidePageSubHeader;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, photoGuidePageHeader);
    }

    public String getPhotoGuidanceSubHeader() {
        return photoGuidePageSubHeader.getText();
    }
}
