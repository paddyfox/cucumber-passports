package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhatYouNeedPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "What you’ll need";
    private static final String PAGE_HEADER_WELSH = "Beth fydd ei angen arnoch";

    @FindBy(tagName = "h1") private WebElement whatYouNeedPageHeader;
    @FindBy(id = "whatYouNeed-label") private WebElement whatYouNeedCheckbox;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, whatYouNeedPageHeader);
    }

    public void checkImReadyToContinue() {
        clickOnElement(whatYouNeedCheckbox);
    }
}
