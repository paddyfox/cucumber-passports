package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FamilyDetailsPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Family details";
    private static final String PAGE_HEADER_WELSH = "Manylion teulu";

    @FindBy(tagName = "h1")
    private WebElement familyDetailsPageHeader;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, familyDetailsPageHeader);
    }
}
