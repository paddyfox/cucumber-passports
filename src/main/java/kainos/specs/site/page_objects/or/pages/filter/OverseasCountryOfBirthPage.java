package kainos.specs.site.page_objects.or.pages.filter;

import kainos.specs.site.Site;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import kainos.specs.countrystore.CountryStore;
import kainos.specs.datastore.DataStore;
import kainos.specs.helpers.CountryHelpers;


public class OverseasCountryOfBirthPage extends Site {

    private static final String UNITED_KINGDOM = "United Kingdom";
    private static final String PAGE_HEADER_ENGLISH = "Which country were you born in?";
    private static final String PAGE_HEADER_WELSH = "Ym mha wlad y cawsoch eich geni?";

    @FindBy(tagName = "h1") private WebElement pageHeader;
    @FindBy(id = "country-of-birth") private WebElement countryOfBirthDropdown;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, pageHeader);
    }

    public void selectCountryOfBirth(String countryOfBirth) {
        if (countryOfBirth.equalsIgnoreCase("Random")) {
            CountryHelpers.selectRandomCountryOfBirth(findElement(By.id("country-of-birth")), countryOfBirth);
        } else if (countryOfBirth.equalsIgnoreCase("UK")) {
            new Select(countryOfBirthDropdown).selectByVisibleText(UNITED_KINGDOM);
            DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH, UNITED_KINGDOM);
            DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_URL, UNITED_KINGDOM);
            DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_AMS, UNITED_KINGDOM);
        } else {
            String countryName = getCountryName(countryOfBirth);
            new Select(countryOfBirthDropdown).selectByVisibleText(countryName);
            String countryNameEnglish = CountryStore.countryHashMap.get(countryOfBirth).get(4);
            DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH, countryNameEnglish);
            DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_URL, countryNameEnglish);
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
}
