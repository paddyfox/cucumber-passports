package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import kainos.specs.datastore.DataStore;

public class DeliveryOptionsPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "How should we return your documents?";
    private static final String PAGE_HEADER_WELSH = "Sut ddylen ni ddychwelyd eich dogfennau?";

    @FindBy(tagName = "h1") private WebElement deliveryOptionsPageHeader;
    @FindBy(id = "secureDelivery-false-label") private WebElement standardDeliveryButton;
    @FindBy(id = "secureDelivery-true-label") private WebElement secureDeliveryButton;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, deliveryOptionsPageHeader);
    }

    public void chooseDeliveryOptions(String deliveryType) {
        if ("Standard".equalsIgnoreCase(deliveryType)) {
            selectStandardDelivery();
            DataStore.setDataKey(DataStore.DELIVERY_OPTION, "Standard");
        }
        else {
            selectSecureDelivery();
            DataStore.setDataKey(DataStore.DELIVERY_OPTION, "Secure");
        }
    }

    public void selectStandardDelivery() {
        clickOnElement(standardDeliveryButton);
    }

    public void selectSecureDelivery() {
        clickOnElement(secureDeliveryButton);
    }
}
