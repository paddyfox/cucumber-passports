package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GenderPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Gender";
    private static final String PAGE_HEADER_WELSH = "Rhywedd";

    @FindBy(className = "govuk-fieldset__heading")
    private WebElement genderPageHeader;
    @FindBy(id = "gender-Male-label")
    private WebElement maleGenderButton;
    @FindBy(id = "gender-Female-label")
    private WebElement femaleGenderButton;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, genderPageHeader);
    }

    public void selectMaleGender() {
        clickOnElement(maleGenderButton);
    }

    public void selectFemaleGender() {
        clickOnElement(femaleGenderButton);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("F")) {
            selectFemaleGender();
        } else if (gender.equalsIgnoreCase("M")) {
            selectMaleGender();
        }
    }
}
