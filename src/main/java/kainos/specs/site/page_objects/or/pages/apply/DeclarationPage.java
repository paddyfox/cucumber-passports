package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeclarationPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Declaration";
    private static final String PAGE_HEADER_WELSH = "Datganiad";

    @FindBy(tagName = "h1")
    private WebElement declarationPageHeader;
    @FindBy(id = "declaration-label")
    private WebElement declarationCheckbox;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, declarationPageHeader);
    }

    public void checkDeclaration() {
        clickOnElement(declarationCheckbox);
    }
}
