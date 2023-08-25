package kainos.specs.site.page_objects.or.pages;

import kainos.specs.site.Site;
import kainos.specs.site.page_objects.OpenablePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends Site implements OpenablePage {

    private static final String PAGE_HEADER_ENGLISH = "Apply online for a UK passport";

    @FindBy(tagName = "h1")
    private WebElement pageHeader;
    @FindBy(linkText = "Start now")
    private WebElement startButton;

    @Override
    public String getPagePath() {
        return "/start";
    }

    public void verifyPageHeader() throws Exception {
        verifyPageHeader(PAGE_HEADER_ENGLISH, pageHeader);
    }

    public void clickStartButton() {
        clickOnElement(startButton);
    }
}
