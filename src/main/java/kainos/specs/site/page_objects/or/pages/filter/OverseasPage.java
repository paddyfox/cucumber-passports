package kainos.specs.site.page_objects.or.pages.filter;

import kainos.specs.helpers.CountryHelpers;
import kainos.specs.site.Site;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import kainos.specs.datastore.DataStore;

import java.util.HashMap;

@Slf4j
public class OverseasPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Do you live in the UK?";
    private static final String PAGE_HEADER_WELSH = "A ydych yn byw yn y Deyrnas Unedig?";

    @FindBy(className = "govuk-fieldset__heading") private WebElement pageHeader;
    @FindBy(id = "isUKApplication-true-label") private WebElement applyFromUkButton;
    @FindBy(id = "isUKApplication-false-label") private WebElement applyFromOverseasButton;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, pageHeader);
    }

    private static final HashMap<String, String> countries;

    static {
        countries = new HashMap<>();
        countries.put("Bangladesh", "BD");
        countries.put("British Indian Ocean Territory", "IO");
        countries.put("Cuba", "CU");
        countries.put("France", "FR");
        countries.put("Germany", "DE");
        countries.put("Gibraltar", "GI");
        countries.put("Iran", "IR");
        countries.put("Italy", "IT");
        countries.put("Laos", "LA");
        countries.put("Libya", "LY");
        countries.put("Mongolia","MN");
        countries.put("North Korea", "KP");
        countries.put("Pitcairn Island", "PN");
        countries.put("Saint Helena", "SH");
        countries.put("South Georgia", "GS");
        countries.put("St Helena, Ascension & Tristan da Cunha", "SH");
        countries.put("Syria", "SY");
        countries.put("Tajikistan", "TJ");
        countries.put("Timor Leste", "TL");
        countries.put("Tunisia", "TN");
        countries.put("UK", "UK");
        countries.put("United Kingdom", "UK");
        countries.put("Yemen", "YE");
        countries.put("Australia", "AU");
        countries.put("Aruba", "AW");
    }

    public void clickNoForApplyingFromUk() {
        clickOnElement(applyFromOverseasButton);
    }

    public void chooseApplicationLocation(Boolean isOverseas, String countryCode) throws Exception {
        if (!isOverseas) {
            clickYesForApplyingFromUk();
            DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_CODE, "GB");
            DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_APPLICATION, "United Kingdom");
        } else {
            clickNoForApplyingFromUk();
            selectCountryOfApplication(countryCode);
        }
    }

    public void clickYesForApplyingFromUk() {
        clickOnElement(applyFromUkButton);
        DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_APPLICATION, "United Kingdom");
    }

    private void selectCountryOfApplication(String countryCode) {
        Select se = new Select(findElement(By.name("country-of-application")));
        se.selectByValue(countryCode);
        DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_APPLICATION_URL, CountryHelpers.convertCountryTextToCountryURLFormat(se.getFirstSelectedOption().getText()));
    }
}
