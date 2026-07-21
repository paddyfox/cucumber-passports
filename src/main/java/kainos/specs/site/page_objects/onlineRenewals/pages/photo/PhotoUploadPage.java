package kainos.specs.site.page_objects.onlineRenewals.pages.photo;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.FindBy;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PhotoUploadPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Upload your photo";
    private static final String PAGE_HEADER_WELSH = "Lanlwytho eich llun";

    @FindBy(tagName = "h1") private WebElement pageHeader;
    @FindBy(css = "#photo") private WebElement photoUploadButton;
    @FindBy(css = "#main-content > div.govuk-error-summary.error-summary > div > ul") private List<WebElement> photoErrorMessages;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, pageHeader);
    }

    public void uploadPhoto(String photoName, String photoType) {
        String uploadFileName = photoName.endsWith(photoType) ? photoName : photoName + photoType;
        Path relativePhotoPath = Paths.get("src", "test", "resources", "test_data", "photos", uploadFileName);
        LocalFileDetector file = new LocalFileDetector();
        java.io.File localFile = file.getLocalFile(relativePhotoPath.toString());
        if (localFile == null) {
            throw new IllegalArgumentException("No photo found for upload at path: " + relativePhotoPath);
        }
        String fileToUpload = localFile.getAbsolutePath();
        photoUploadButton.sendKeys(fileToUpload);
    }
}
