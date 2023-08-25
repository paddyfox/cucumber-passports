package kainos.specs.site.page_objects.or.pages.filter;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OtherPassportsPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Do you have any passports from other countries?";
    private static final String PAGE_HEADER_WELSH = "A oes gennych unrhyw basbortau o wledydd eraill?";

    @FindBy(className = "govuk-fieldset__heading")
    private WebElement pageHeader;
    @FindBy(id = "otherPassports-true-label")
    private WebElement hasOtherPassportsButton;
    @FindBy(id = "otherPassports-false-label")
    private WebElement noOtherPassportsButton;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, pageHeader);
    }

    public void selectIfHasOtherPassports(Boolean hasOtherPassports) {
        if (hasOtherPassports) {
            clickOnElement(hasOtherPassportsButton);
        } else {
            clickOnElement(noOtherPassportsButton);
        }
    }
}
