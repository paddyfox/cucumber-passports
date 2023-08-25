package kainos.specs.helpers;

import kainos.specs.datastore.DataStore;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public class CountryHelpers {

    public static void selectRandomCountryOfBirth(WebElement webElement, String dataKey) {
        Select selector = new Select(webElement);
        int maxIndex = selector.getOptions().size();
        int randomIndex = ThreadLocalRandom.current().nextInt(1, maxIndex);
        selector.selectByIndex(randomIndex);

        String countryOfBirthName = selector.getOptions().get(randomIndex).getText().trim();
        String countryOfBirthURL = convertCountryTextToCountryURLFormat(countryOfBirthName);

        if (dataKey.equalsIgnoreCase(DataStore.APPLICANT_COUNTRY_OF_BIRTH)) {
            DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH, countryOfBirthName);
            DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_AMS, countryOfBirthName);
            DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_BIRTH_URL, countryOfBirthURL);
        } else {
            DataStore.setDataKey(dataKey, countryOfBirthName);
        }
    }

    public static String convertCountryTextToCountryURLFormat(String country) {
        if (country.equalsIgnoreCase("Myanmar (Burma)")) {
            country = "myanmar-burma";
        }

        return country.trim()
                .replaceAll("\\&+", "and") //regex to replace '&' symbol to 'and'
                .replaceAll("[\\/+|\\'+|\\s+]", "-") //regex to replace forward slashes, quotes and spaces to hyphens
                .replaceAll("(\\-)\\1+", "-") //regex to replace multiple continuous hyphens to a single hyphen
                .toLowerCase();
    }

    public static String convertCountryTextToCountryAMSFormat(String country) {

        String countryTextFormatted;

        switch (country) {
            case "The Occupied Palestinian Territories":
                countryTextFormatted = "Occ. Palestinian Territories";
                break;
            case "St Helena Ascension & Tristan da Cunha":
                countryTextFormatted = "St Helena";
                break;
            case "St Pierre & Miquelon":
                countryTextFormatted = "St Pierre and Miquelon";
                break;
            case "South Georgia and the South Sandwich Islands":
                countryTextFormatted = "Sth Georgia Sth Sandwich Is";
                break;
            case "Timor-Leste":
                countryTextFormatted = "Timor-Leste";
                break;
            case "Myanmar (Burma)":
                countryTextFormatted = "Burma";
                break;
            case "Democratic Republic of the Congo":
                countryTextFormatted = "Democratic Republic of Congo";
                break;
            case "St Vincent and the Grenadines":
                countryTextFormatted = "St Vincent and The Grenadines";
                break;
            default:
                countryTextFormatted = country;
        }

        return countryTextFormatted;
    }
}
