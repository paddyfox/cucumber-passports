package kainos.specs.site.page_objects.or.pages.filter;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import kainos.specs.countrystore.CountryStore;
import kainos.specs.datastore.DataStore;

import static org.openqa.selenium.By.id;
import static kainos.specs.helpers.CountryHelpers.selectRandomCountryOfBirth;

public class BirthPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Were you born in the UK?";
    private static final String PAGE_HEADER_WELSH = "A gawsoch eich geni yn y Deyrnas Unedig?";

    @FindBy(tagName = "h1") private WebElement birthPageHeader;
    @FindBy(id = "bornInUK-true-label") private WebElement bornInTheUKYesButton;
    @FindBy(id = "bornInUK-false-label") private WebElement bornInTheUKNoButton;
    @FindBy(id = "countryOfBirth") private WebElement countryOfBirthDropdown;
    @FindBy(id = "townOfBirth") private WebElement townOfBirthField;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, birthPageHeader);
    }

    public void chooseCountryOfBirth(String countryOfBirth) {
        if (countryOfBirth.equalsIgnoreCase("UK")) {
            selectBornInTheUK();
        } else {
            clickOnElement(bornInTheUKNoButton);
            selectCountryOfBirth(countryOfBirth);
        }
    }

    public void selectBornInTheUK() {
        clickOnElement(bornInTheUKYesButton);
        DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH, "United Kingdom");
        DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_AMS, "United Kingdom");
    }

    public void selectCountryOfBirth(String countryOfBirth) {
        if (countryOfBirth.equalsIgnoreCase("Random")) {
            selectRandomCountryOfBirth(findElement(id("country-of-birth")), DataStore.APPLICANT_COUNTRY_OF_BIRTH);
        }
        else {
            String countryName = getCountryName(countryOfBirth);
            new Select(countryOfBirthDropdown).selectByVisibleText(countryName);
            String countryNameEnglish = CountryStore.countryHashMap.get(countryOfBirth).get(4);
            DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH, countryNameEnglish);
            DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_AMS, countryNameEnglish);
        }

        switch (DataStore.getDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH)) {
            case "The Occupied Palestinian Territories":
                DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_AMS, "Occ. Palestinian Territories");
                break;
            case "St Helena Ascension & Tristan da Cunha":
                DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_AMS, "St Helena");
                break;
            case "St Pierre & Miquelon":
                DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_AMS, "St Pierre and Miquelon");
                break;
            case "South Georgia and the South Sandwich Islands":
                DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_AMS, "Sth Georgia Sth Sandwich Is");
                break;
            case "Timor-Leste":
                DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_AMS, "Timor-Leste");
                break;
            case "Myanmar (Burma)":
                DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_AMS, "Burma");
                DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_URL, "myanmar-burma");
                break;
            case "Democratic Republic of the Congo":
                DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_AMS, "Democratic Republic of Congo");
                break;
            case "St Vincent and the Grenadines":
                DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_AMS, "St Vincent and The Grenadines");
                break;
            default:
                DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_AMS, DataStore.getDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH));
        }
    }

    public void setTownOfBirth(String townOfBirth) {
        enterTextIntoTheField(townOfBirthField, townOfBirth);
    }
}
