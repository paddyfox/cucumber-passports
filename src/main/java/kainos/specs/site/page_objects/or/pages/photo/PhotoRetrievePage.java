package kainos.specs.site.page_objects.or.pages.photo;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhotoRetrievePage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Retrieve your digital photo";
    private static final String PAGE_HEADER_WELSH = "Cael gafael ar eich llun digidol";

    @FindBy(tagName = "h1") private WebElement pageHeader;
    @FindBy(id = "photo-code-sld") private WebElement photoCodeSecondLevelDomain;
    @FindBy(id = "photo-code-tld") private WebElement photoCodeTopLevelDomain;
    @FindBy(id = "photo-code-path") private WebElement photoCodePath;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, pageHeader);
    }

    public void clearFields() {
        photoCodePath.clear();
        photoCodeSecondLevelDomain.clear();
        photoCodeTopLevelDomain.clear();
    }

    public void enterPhotoCode(String secondLevelDomain, String topLevelDomain, String path) {

        enterTextIntoTheField(photoCodeSecondLevelDomain, secondLevelDomain);
        enterTextIntoTheField(photoCodeTopLevelDomain, topLevelDomain);
        enterTextIntoTheField(photoCodePath, path);
       // Work around for Safari as the cleared field has a problem to get text entered immediately.
        if (!(photoCodeSecondLevelDomain.getAttribute("value").contains(secondLevelDomain))) {
            enterTextIntoTheField(photoCodeSecondLevelDomain, secondLevelDomain);
        }
    }
}
