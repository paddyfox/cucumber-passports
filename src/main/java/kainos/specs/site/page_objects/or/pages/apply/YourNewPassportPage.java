package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourNewPassportPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "New passport";
    private static final String PAGE_HEADER_WELSH = "Pasbort newydd";

    @FindBy(tagName = "h1") private WebElement yourNewPassportPageHeader;
    @FindBy(id = "largePassport-true-label") private WebElement frequentTravellerPassportButton;
    @FindBy(id = "largePassport-false-label") private WebElement standardPassportButton;
    @FindBy(id = "braille-label") private WebElement brailleStickerButton;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, yourNewPassportPageHeader);
    }

    private void choosePassportSize(Boolean passportSizeOption) {
        WebElement radioButton = passportSizeOption ? frequentTravellerPassportButton : standardPassportButton;
        clickOnElement(radioButton);
    }

    private void chooseBrailleSticker(Boolean choice) {
        if (choice) {
            selectBrailleStickerRadio();
        }
    }

    public void selectBrailleStickerRadio() {
        clickOnElement(brailleStickerButton);
    }

    public void completeForm(Boolean passportSizeOption, Boolean brailleChoice) {
        this.choosePassportSize(passportSizeOption);
        this.chooseBrailleSticker(brailleChoice);
    }
}
