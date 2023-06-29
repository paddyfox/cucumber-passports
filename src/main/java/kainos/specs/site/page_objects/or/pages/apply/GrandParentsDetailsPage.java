package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GrandParentsDetailsPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Grandparents’ details";
    private static final String PAGE_HEADER_WELSH = "Manylion neiniau a theidiau";

    @FindBy(tagName = "h1") private WebElement grandParentsDetailsPageHeader;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, grandParentsDetailsPageHeader);
    }
}
