package kainos.specs.site.page_objects.or.pages.photo;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhotoChooseMethodPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Get a digital photo";
    private static final String PAGE_HEADER_WELSH = "Cael llun digidol";

    @FindBy(className = "govuk-fieldset__heading") private WebElement choosePhotoMethodPageHeader;
    @FindBy(id = "photoMethod-digitalphoto-label") private WebElement iHaveADigitalPhotoToUploadRadio;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, choosePhotoMethodPageHeader);
    }

    public void selectIHaveADigitalPhotoToUpload() { clickOnElement(iHaveADigitalPhotoToUploadRadio); }
}
