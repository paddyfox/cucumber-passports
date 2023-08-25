package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.datastore.DataStore;
import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParentsEUSettledPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "Did either parent have settled status from the EU Settlement Scheme when you were born?";
    private static final String PAGE_HEADER_WELSH = "A oedd gan y naill riant statws preswylydd sefydlog gan y Cynllun Preswylio’n Sefydlog i Ddinasyddion yr UE pan y’ch ganed?";
    private static final String YES_ENGLISH = "Yes";
    private static final String YES_WELSH = "Oedd";
    private static final String NO_ENGLISH = "No";
    private static final String NO_WELSH = "Nac oedd";
    private static final String I_DONT_KNOW_ENGLISH = "I don’t know";
    private static final String I_DONT_KNOW_WELSH = "Dwi ddim yn gwybod";

    @FindBy(tagName = "h1")
    private WebElement parentsEUSettledPageHeader;
    @FindBy(id = "parents-have-eu-settled-status-true-label")
    private WebElement yesButton;
    @FindBy(id = "parents-have-eu-settled-status-false-label")
    private WebElement noButton;
    @FindBy(id = "parents-have-eu-settled-status-unknown-label")
    private WebElement iDontKnowButton;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, parentsEUSettledPageHeader);
    }

    public String selectEUSSStatus(String status) {
        switch (status) {
            case "Yes":
                clickOnElement(yesButton);
                DataStore.setDataKey(DataStore.APPLICANT_EUSS_STATUS,
                        isApplicationLanguageWelsh() ? YES_WELSH : YES_ENGLISH);
                DataStore.setDataKey(DataStore.YES_TO_EUSS, "true");
                break;
            case "No":
                clickOnElement(noButton);
                DataStore.setDataKey(DataStore.APPLICANT_EUSS_STATUS,
                        isApplicationLanguageWelsh() ? NO_WELSH : NO_ENGLISH);
                break;
            case "I don’t know":
                clickOnElement(iDontKnowButton);
                DataStore.setDataKey(DataStore.APPLICANT_EUSS_STATUS,
                        isApplicationLanguageWelsh() ? I_DONT_KNOW_WELSH : I_DONT_KNOW_ENGLISH);
                break;
            case "RANDOM":
                selectRandomEUSSStatus();
                break;
            default:
                throw new IllegalArgumentException("No behaviour defined!");
        }
        return status;
    }

    private void selectRandomEUSSStatus() {
        List<String> list = new ArrayList<>();
        list.add("Yes");
        list.add("No");
        list.add("I don’t know");
        String random = list.get(new Random().nextInt(list.size()));

        selectEUSSStatus(random);
        DataStore.setDataKey(DataStore.APPLICANT_EUSS_STATUS, selectEUSSStatus(random));
    }
}
