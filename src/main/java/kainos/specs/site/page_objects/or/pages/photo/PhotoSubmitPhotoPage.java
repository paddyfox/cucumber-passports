package kainos.specs.site.page_objects.or.pages.photo;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhotoSubmitPhotoPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Do you want to submit this photo?";
    private static final String PAGE_HEADER_WELSH = "A ydych chi’n dymuno cyflwyno’r llun hwn?";

    @FindBy(tagName = "h1")
    private WebElement pageHeader;
    @FindBy(id = "submitPhoto-true-label")
    private WebElement submitPhotoButton;
    @FindBy(css = "#main-content > div > div > form > button")
    private WebElement continueButton;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, pageHeader);
    }

    public void clickSubmitThisPhotoButton() {
        clickOnElement(submitPhotoButton);
    }

    public void clickOnContinue() {
        clickOnElement(continueButton);
    }
}
