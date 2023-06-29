package kainos.specs.site.page_objects.or.pages.apply;

import kainos.specs.site.Site;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import kainos.specs.datastore.DataStore;

import static kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants.RELATION_TO_APPLICANT_MAX_VLAUE;
import static kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants.THIRD_PARTY_EXPLANATION;

public class WhatIsYourRelationToApplicantPage extends Site {

    private static final String PAGE_HEADER_ENGLISH = "What is your relationship to the applicant?";
    private static final String PAGE_HEADER_WELSH = "Beth yw eich perthynas i’r ymgeisydd?";

    @FindBy(tagName = "h1") private WebElement pageHeader;
    @FindBy(id = "relationship-mother-label") private WebElement motherButton;
    @FindBy(id = "relationship-father-label") private WebElement fatherButton;
    @FindBy(id = "relationship-other-label") private WebElement otherButton;
    @FindBy(id = "otherRelationship") private WebElement otherRelationField;
    @FindBy(id = "thirdPartyFirstName") private WebElement motherFirstName;
    @FindBy(id = "thirdPartyLastName") private WebElement motherLastName;
    @FindBy(id = "thirdPartyExplanation") private WebElement motherExplanation;
    @FindBy(id = "thirdPartyFirstName") private WebElement fatherFirstName;
    @FindBy(id = "thirdPartyLastName") private WebElement fatherLastName;
    @FindBy(id = "thirdPartyExplanation") private WebElement fatherExplanation;
    @FindBy(id = "otherFirstName") private WebElement otherFirstName;
    @FindBy(id = "otherLastName") private WebElement otherLastName;
    @FindBy(id = "otherWhy") private WebElement otherExplanation;

    public void verifyPageHeader() throws Exception {
        verifyHeaderBilingual(PAGE_HEADER_WELSH, PAGE_HEADER_ENGLISH, pageHeader);
    }

    private void selectMother() {
        clickOnElement(motherButton);
    }

    private void selectFather() {
        clickOnElement(fatherButton);
    }

    private void selectOther() {
        clickOnElement(otherButton);
    }

    private void setRelationToApplicant(String relationToApplicant) {
        enterTextIntoTheField(otherRelationField, relationToApplicant);
    }

    public void choosesRelation(String relation) {
        switch (relation) {
            case "Mother":
                selectMother();
                break;
            case "Father":
                selectFather();
                break;
            case "Other":
                selectOther();
                setRelationToApplicant(RELATION_TO_APPLICANT_MAX_VLAUE);
                break;
            default:
                throw new IllegalArgumentException("No behaviour defined!");
        }
        DataStore.setDataKey(DataStore.RELATION_TO_APPLICANT, relation);
    }

    public void complete3rdPartyFirstNameLastNameForm(String firstName, String lastName) {
        String relation = DataStore.getDataKey(DataStore.RELATION_TO_APPLICANT);

        switch (relation) {
            case "Mother":
                enterTextIntoTheField(motherFirstName, firstName);
                enterTextIntoTheField(motherLastName, lastName);
                if (elementIsDisplayed(motherExplanation)) {
                    enterTextIntoTheField(motherExplanation, THIRD_PARTY_EXPLANATION);
                }

                break;
            case "Father":
                enterTextIntoTheField(fatherFirstName, firstName);
                enterTextIntoTheField(fatherLastName, lastName);
                if (elementIsDisplayed(fatherExplanation)) {
                    enterTextIntoTheField(fatherExplanation, THIRD_PARTY_EXPLANATION);
                }

                break;
            case "Other":
                enterTextIntoTheField(otherFirstName, firstName);
                enterTextIntoTheField(otherLastName, lastName);
                enterTextIntoTheField(otherExplanation, THIRD_PARTY_EXPLANATION);

                break;
        }
        DataStore.setDataKey(DataStore.THIRD_PARTY_FIRST_NAME, firstName);
        DataStore.setDataKey(DataStore.THIRD_PARTY_LAST_NAME, lastName);
    }

}
