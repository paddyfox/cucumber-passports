package kainos.specs.site.page_objects.onlineRenewals.pages.photo;

import kainos.specs.site.Site;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhotoUploadResultPage extends Site {

    private static final By PHOTO_UPLOAD_PROGRESS_CONTAINER = By.id("progress-container");
    private static final String PAGE_HEADER_ENGLISH = "Photo result";
    private static final String PAGE_HEADER_WELSH = "Canlyniad llun";

    @FindBy(tagName = "h1") private WebElement pageHeader;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingualWithRetry(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, pageHeader);
    }

    public void waitForPhotoUploadToComplete() {
        waitForElementToBeInvisible(PHOTO_UPLOAD_PROGRESS_CONTAINER, 90_000);
    }
}
