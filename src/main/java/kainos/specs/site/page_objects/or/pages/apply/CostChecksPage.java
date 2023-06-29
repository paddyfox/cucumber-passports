package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class CostChecksPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Paying for your passport";
    private static final String PAGE_HEADER_WELSH = "Talu am eich pasbort";

    @FindBy(tagName = "h1") private WebElement pageHeader;

    public void verifyPageHeader() throws Exception {
            verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, pageHeader);
    }
}
