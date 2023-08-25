package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.datastore.DataStore;
import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static kainos.specs.datastore.DataStore.APPLICANT_ADDRESS_POSTCODE;
import static kainos.specs.datastore.DataStore.APPLICANT_ADDRESS_STATEORPROVINCE;
import static kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants.INVALID_UK_POST_CODE;
import static kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants.VALID_UK_POST_CODE;

public class AddressPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Enter home address";
    private static final String PAGE_HEADER_WELSH = "Cyfeiriad cartref";

    @FindBy(tagName = "h1")
    private WebElement addressPageHeader;
    @FindBy(id = "addressLine1")
    private WebElement addressLine1Field;
    @FindBy(id = "addressLine2")
    private WebElement addressLine2Field;
    @FindBy(id = "addressTown")
    private WebElement addressTownField;
    @FindBy(id = "addressPostcode")
    private WebElement addressPostcodeField;
    @FindBy(id = "address-state-province")
    private WebElement addressStateProvinceField;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, addressPageHeader);
    }

    public void setAddressLine1(String addressLine1) {
        clearAddressLine1();
        enterTextIntoTheField(addressLine1Field, addressLine1);
    }

    public void setAddressLine2(String addressLine2) {
        clearAddressLine2();
        enterTextIntoTheField(addressLine2Field, addressLine2);
    }

    public void setAddressTown(String addressCity) {
        clearAddressTown();
        enterTextIntoTheField(addressTownField, addressCity);
    }

    public void setStateProvince(String stateProvince) {
        if (addressStateProvinceFieldIsDisplayed()) {
            addressStateProvinceField.clear();
            enterTextIntoTheField(addressStateProvinceField, stateProvince);
            DataStore.setDataKey(APPLICANT_ADDRESS_STATEORPROVINCE, stateProvince);
        }
    }

    public void clearPostcode() {
        addressPostcodeField.clear();
    }

    private void clearAddressLine1() {
        addressLine1Field.clear();
    }

    private void clearAddressLine2() {
        addressLine2Field.clear();
    }

    private void clearAddressTown() {
        addressTownField.clear();
    }

    public void setPostcode(String postcode) {
        if (addressPostcodeFieldIsDisplayed()) {
            clearPostcode();
            enterTextIntoTheField(addressPostcodeField, postcode);
            if (!(addressPostcodeField.getAttribute("value").contains(postcode))) {
                enterTextIntoTheField(addressPostcodeField, postcode);
            }
        }
        if (!postcode.equals(INVALID_UK_POST_CODE)) {
            DataStore.setDataKey(APPLICANT_ADDRESS_POSTCODE, postcode);
        }
    }

    public boolean addressPostcodeFieldIsDisplayed() {
        return elementIsDisplayed(addressPostcodeField);
    }

    public boolean addressStateProvinceFieldIsDisplayed() {
        return elementIsDisplayed(addressStateProvinceField);
    }

    public void completeManualAddressForm(String addressLine1, String addressLine2, String addressTown, String stateProvince) throws Exception {
        this.setAddressLine1(addressLine1);
        this.setAddressLine2(addressLine2);
        this.setAddressTown(addressTown);
        this.setPostcode(VALID_UK_POST_CODE);
        this.setStateProvince(stateProvince);
    }
}
