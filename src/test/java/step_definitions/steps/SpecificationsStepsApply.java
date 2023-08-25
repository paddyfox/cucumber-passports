package step_definitions.steps;

import kainos.specs.countrystore.CountryStore;
import kainos.specs.datastore.DataStore;
import kainos.specs.helpers.ApplicantData;
import kainos.specs.site.page_objects.or.pages.apply.*;
import kainos.specs.site.page_objects.or.pages.filter.BirthPage;
import kainos.specs.site.page_objects.or.pages.photo.PhotoGuideHowToGetADigitalPhotoPage;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import step_definitions.helpers.SpecificationsStepsHelpers;

import java.util.Objects;

import static com.google.common.base.Strings.isNullOrEmpty;
import static kainos.specs.datastore.DataStore.*;
import static kainos.specs.helpers.ApplicantData.isAValidApplicationForThisStep;
import static kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants.OTHER;

@Slf4j
public class SpecificationsStepsApply extends SpecificationsStepsHelpers {

    private final WebDriver driver = getDriver();

    private final HowToApplyPage howToApplyPage = PageFactory.initElements(driver, HowToApplyPage.class);
    private final PhotoGuideHowToGetADigitalPhotoPage photoGuideHowToGetADigitalPhotoPage = PageFactory.initElements(driver, PhotoGuideHowToGetADigitalPhotoPage.class);
    private final BirthPage birthPage = PageFactory.initElements(driver, BirthPage.class);
    private final OldPassportDetailsPage oldPassportDetailsPage = PageFactory.initElements(driver, OldPassportDetailsPage.class);
    private final NamePage namePage = PageFactory.initElements(driver, NamePage.class);
    private final PreviousNamePage previousNamePage = PageFactory.initElements(driver, PreviousNamePage.class);
    private final GenderPage genderPage = PageFactory.initElements(driver, GenderPage.class);
    private final AddressPage addressPage = PageFactory.initElements(driver, AddressPage.class);
    private final ContactDetailsPage contactDetailsPage = PageFactory.initElements(driver, ContactDetailsPage.class);
    private final ContactPreferencesPage contactPreferencesPage = PageFactory.initElements(driver, ContactPreferencesPage.class);
    private final YourNewPassportPage yourNewPassportPage = PageFactory.initElements(driver, YourNewPassportPage.class);
    private final SARDetailsPage sarDetailsPage = PageFactory.initElements(driver, SARDetailsPage.class);
    private final DeliveryOptionsPage deliveryOptionsPage = PageFactory.initElements(driver, DeliveryOptionsPage.class);
    private final DeclarationPage declarationPage = PageFactory.initElements(driver, DeclarationPage.class);
    private final FinalChecksPage finalChecksPage = PageFactory.initElements(driver, FinalChecksPage.class);
    private final NaturalisationDetailsPage naturalisationDetailsPage = PageFactory.initElements(driver, NaturalisationDetailsPage.class);
    private final FamilyDetailsPage familyDetailsPage = PageFactory.initElements(driver, FamilyDetailsPage.class);
    private final ParentsDetailsPage parentsDetailsPage = PageFactory.initElements(driver, ParentsDetailsPage.class);
    private final ParentOneDetailsPage parentOneDetailsPage = PageFactory.initElements(driver, ParentOneDetailsPage.class);
    private final ParentTwoDetailsPage parentTwoDetailsPage = PageFactory.initElements(driver, ParentTwoDetailsPage.class);
    private final GrandParentsDetailsPage grandParentsDetailsPage = PageFactory.initElements(driver, GrandParentsDetailsPage.class);
    private final MaternalGrandparentsDetailsPage maternalGrandparentsDetailsPage = PageFactory.initElements(driver, MaternalGrandparentsDetailsPage.class);
    private final PaternalGrandparentsDetailsPage paternalGrandparentsDetailsPage = PageFactory.initElements(driver, PaternalGrandparentsDetailsPage.class);
    private final WhoIsThisPassportForPage whoIsThisPassportForPage = PageFactory.initElements(driver, WhoIsThisPassportForPage.class);
    private final WhatIsYourRelationToApplicantPage whatIsYourRelationToApplicantPage = PageFactory.initElements(driver, WhatIsYourRelationToApplicantPage.class);
    private final PassportFeePage passportFeePage = PageFactory.initElements(driver, PassportFeePage.class);
    private final ChangeOfNamePage changeOfNamePage = PageFactory.initElements(driver, ChangeOfNamePage.class);
    private final CostChecksPage costChecksPage = PageFactory.initElements(driver, CostChecksPage.class);
    private final DocumentsPage documentsPage = PageFactory.initElements(driver, DocumentsPage.class);
    private final TownOfBirthPage townOfBirthPage = PageFactory.initElements(driver, TownOfBirthPage.class);
    private final ConfirmYourIdentityPage confirmYourIdentityPage = PageFactory.initElements(driver, ConfirmYourIdentityPage.class);
    private final ParentsEUSettledPage parentsEUSettledPage = PageFactory.initElements(driver, ParentsEUSettledPage.class);
    private final ApplicationSummaryPage applicationSummaryPage = PageFactory.initElements(driver, ApplicationSummaryPage.class);
    private final WhatYouNeedPage whatYouNeedPage = PageFactory.initElements(driver, WhatYouNeedPage.class);

    @Setter
    private ApplicantData applicant;

    public SpecificationsStepsApply continuesThroughApplicationSummary() throws Exception {
        if ((applicant.isFirstTimeApplication() || applicant.isAHiddenFirstTimeApplicant()) && !applicant.isABritishNationalOverseasRequiringAReferee()) {
            applicationSummaryPage.verifyPageHeaderApplyingForFirstUKPassport();
        } else {
            applicationSummaryPage.verifyPageHeaderApplyingForUKPassport();
        }
        applicationSummaryPage.clickCont();

        return this;
    }

    public SpecificationsStepsApply continuesThroughWhatYouNeed() throws Exception {
        if (applicant.isFirstTimeApplication() || applicant.isAHiddenFirstTimeApplicant() || applicant.isChild()) {
            whatYouNeedPage.verifyPageHeader();
            whatYouNeedPage.checkImReadyToContinue();
            whatYouNeedPage.clickContinue();
        }
        return this;
    }

    public SpecificationsStepsApply continuesThroughHowToApplyNonPremium() throws Exception {
        if (isAValidApplicationForThisStep()) {
            howToApplyPage.verifyPageHeader();
            howToApplyPage.continueButton();
        }
        return this;
    }

    public SpecificationsStepsApply continuesThroughWhatYouNeedAndPhotoGuidance() throws Exception {
        continuesThroughPhotoGuidance();
        return this;
    }

    public SpecificationsStepsApply continuesThroughPhotoGuidance() throws Exception {
        if (isAValidApplicationForThisStep()) {
            photoGuideHowToGetADigitalPhotoPage.verifyPageHeader();
            photoGuideHowToGetADigitalPhotoPage.clickContinue();
        }
        return this;
    }

    public SpecificationsStepsApply entersOldPassportInformation() throws Exception {
        if (isAValidApplicationForThisStep()) {
            if (applicant.isAHiddenFirstTimeApplicant() || applicant.isABritishNationalOverseasRequiringAReferee()) {
                oldPassportDetailsPage.verifyPageHeader();
                oldPassportDetailsPage.completeOldBluePassportForm(applicant.getExistingPassportNumber(), applicant.getExistingPassportExpiryDate());
                oldPassportDetailsPage.clickContinue();
            } else if (!applicant.isFirstTimeApplication() && !applicant.hasLostOrStolenPassport()) {
                oldPassportDetailsPage.verifyPageHeader();
                oldPassportDetailsPage.completeOldNonBluePassportForm(applicant.getExistingPassportNumber(), applicant.getExistingPassportExpiryDate());
                oldPassportDetailsPage.clickContinue();
            }
        }

        return this;
    }

    public SpecificationsStepsApply entersPersonalDetails() throws Exception {
        if (isAValidApplicationForThisStep()) {

            namePage.verifyPageHeader();
            namePage.completeForm(applicant.getTitle(), applicant.getFirstNames(), applicant.getSurname());
            DataStore.setDataKey(APPLICANT_FORENAMES, applicant.getFirstNames());
            DataStore.setDataKey(APPLICANT_SURNAME, applicant.getSurname());

            if (applicant.hasChangedTheirName()) {
                namePage.selectNoMyNameHasChangedSinceMyOldPassport();
                namePage.clickContinue();
                if (!applicant.isChild()) {
                    changeOfNamePage.verifyPageHeader();
                    changeOfNamePage.selectNameChangeReason(applicant.getNameChangeReason());
                    changeOfNamePage.clickContinue();
                    previousNamePage.verifyPreviousNamesPageHeader();
                }
            } else {
                namePage.selectYesToSameNameInOldPassport();
                namePage.clickContinue();
                previousNamePage.verifyOtherNamesPageHeader();
            }
        }
        entersAnyPreviousNames();

        genderPage.verifyPageHeader();
        genderPage.selectGender(applicant.getGender());
        genderPage.clickContinue();

        if ((applicant.isOverseas() && applicant.isFirstTimeApplication()) || (applicant.isOverseas() && applicant.isAHiddenFirstTimeApplicant())) {
            townOfBirthPage.verifyPageHeader();
            townOfBirthPage.enterTownOfBirth(applicant.getTownOfBirth());
            townOfBirthPage.clickContinue();
        } else {
            birthPage.verifyPageHeader();
            birthPage.setTownOfBirth(applicant.getTownOfBirth());
            birthPage.chooseCountryOfBirth("UK");
            birthPage.clickContinue();
        }

        if (applicant.isVeteran()) {
            passportFeePage.verifyPageHeader();
            passportFeePage.clickContinue();
        }

        if (applicant.isFirstTimeApplication() || applicant.isAHiddenFirstTimeApplicant()) {
            if (Objects.equals(DataStore.getDataKey(HAS_NATURALISATION_CERTIFICATE), "true")) {
                naturalisationDetailsPage.verifyPageHeader();
                if (applicant.isChild()) {
                    naturalisationDetailsPage.completeForm(applicant.getCertificateNumber(), applicant.getNaturalisationDate(), "child");
                } else {
                    naturalisationDetailsPage.completeForm(applicant.getCertificateNumber(), applicant.getNaturalisationDate(), "adult");
                }
                naturalisationDetailsPage.clickContinue();
            }
            familyDetailsPage.verifyPageHeader();
            familyDetailsPage.clickContinue();
        }

        return this;
    }

    public SpecificationsStepsApply entersParentDetails() throws Exception {
        if (isAValidApplicationForThisStep()) {

            if ((applicant.isChild() || applicant.isFirstTimeApplication()) || (applicant.hasSpecialIssueDate() && (applicant.isOverseas() && applicant.hasOtherIssuingAuthority()) || (!applicant.isOverseas() && applicant.isAHiddenFirstTimeApplicant()))) {
                parentsDetailsPage.verifyPageHeader();
                boolean fillParentOnesDetails = Math.random() > 0.5;
                if (fillParentOnesDetails) {
                    parentsDetailsPage.completeParentOneForm(applicant);
                    log.info("Filled Parent one's first name, last name and date of birth");
                } else {
                    DataStore.setDataKey(PARENT_ONE_FIRST_NAME, null);
                    DataStore.setDataKey(PARENT_ONE_LAST_NAME, null);
                    DataStore.setDataKey(PARENT_ONE_BIRTH_DATE, null);
                    log.info("Did not fill Parent one's first name, last name and date of birth");
                    parentsDetailsPage.enterWhyICannotProvideParentOneDetails();
                }

                boolean fillParentTwosDetails = Math.random() > 0.5;
                if (fillParentTwosDetails) {
                    parentsDetailsPage.completeParentTwoForm(applicant);
                    log.info("Filled Parent two's first name, last name and date of birth");
                } else {
                    DataStore.setDataKey(PARENT_TWO_FIRST_NAME, null);
                    DataStore.setDataKey(PARENT_TWO_LAST_NAME, null);
                    DataStore.setDataKey(PARENT_TWO_BIRTH_DATE, null);
                    log.info("Did not fill Parent two's first name, last name and date of birth");
                    parentsDetailsPage.enterWhyICannotProvideParentTwoDetails();
                }
                parentsDetailsPage.choosesParentsMarriedOrNot(applicant.getParentsMarriedStatus());

                if (applicant.areParentsMarried()) {
                    if (!isNullOrEmpty(applicant.getParentsMarriageDate())) {
                        parentsDetailsPage.setParentsMarriageDate(applicant.getParentsMarriageDate());
                    }
                    parentsDetailsPage.clickContinue();
                }

                if (isEUSSEligible(applicant)) {
                    parentsEUSettledPage.verifyPageHeader();
                    parentsEUSettledPage.selectEUSSStatus(applicant.getEUSSStatus());
                    log.info("Selected EUSS Status: " + DataStore.getDataKey(APPLICANT_EUSS_STATUS));
                    parentsEUSettledPage.clickContinue();
                }

                parentOneDetailsPage.verifyPageHeader();
                if (fillParentOnesDetails) {
                    parentOneDetailsPage.completeNationalityForm(applicant);
                }
                parentOneDetailsPage.completePassportForm(applicant);
                parentOneDetailsPage.clickContinue();

                parentTwoDetailsPage.verifyPageHeader();
                if (fillParentTwosDetails) {
                    parentTwoDetailsPage.completeNationalityForm(applicant);
                }
                parentTwoDetailsPage.completePassportForm(applicant);
                parentTwoDetailsPage.clickContinue();
            }
            return this;
        }

        return this;
    }

    public SpecificationsStepsApply entersAddressAndContactDetails() throws Exception {
        if (isAValidApplicationForThisStep()) {
            addressPage.verifyPageHeader();
            addressPage.completeManualAddressForm(applicant.getAddressLine1(), applicant.getAddressLine2(), applicant.getAddressTown(), applicant.getAddressStateProvince());
            addressPage.clickContinue();

            contactDetailsPage.verifyPageHeader();
            DataStore.setDataKey(APPLICANT_EMAIL, applicant.getEmail());
            contactDetailsPage.completeEmailForm(DataStore.getDataKey(APPLICANT_EMAIL));

            switch (DataStore.getDataKey(APPLICANT_COUNTRY_OF_APPLICATION)) {
                case "Kosovo":
                case "British Virgin Islands":
                case "St Vincent and the Grenadines":
                    contactDetailsPage.setDefaultDiallingCode(CountryStore.countryHashMap.get(applicant.getCountryCodeOfApplication()).get(0));
                    break;
            }

            contactDetailsPage.setMobileOrHomeNumber("1111");
            contactDetailsPage.setMobileOrHomeNumber(applicant.getHousePhoneNumber());
            contactDetailsPage.clickContinue();
        }

        return this;
    }

    public SpecificationsStepsApply entersContactPreferences() throws Exception {
        if (isAValidApplicationForThisStep()) {
            String countryOfApplication = DataStore.getDataKey(APPLICANT_COUNTRY_OF_APPLICATION);

            contactPreferencesPage.verifyPageHeader();
            if (applicant.getDesiresEmailUpdates()) {
                contactPreferencesPage.chooseEmailUpdates(applicant.getDesiresEmailUpdates());
            }
            if (applicant.getDesiresTextUpdates()) {
                contactPreferencesPage.chooseTextMessageUpdates(applicant.getDesiresTextUpdates());

                switch (countryOfApplication) {
                    case "British Virgin Islands":
                    case "St Vincent and the Grenadines":
                        contactPreferencesPage.setDefaultDiallingCodeForSMS(CountryStore.countryHashMap.get(applicant.getCountryCodeOfApplication()).get(0));
                        break;
                }
                contactPreferencesPage.setMobileNumberForTextUpdates(applicant.getMobilePhoneNumber());
            }

            switch (countryOfApplication) {
                case "Kiribati":
                case "Kosovo":
                case "Tuvalu":
                case "Wallis and Futuna":
                    //Set to not receive SMS updates as we cannot send SMS messages to these countries
                    contactPreferencesPage.verifyPageHeader();
                    contactPreferencesPage.chooseTextMessageUpdates(false);
            }
            contactPreferencesPage.clickContinue();
        }

        return this;
    }

    public SpecificationsStepsApply choosesNewPassportOptions() throws Exception {
        if (isAValidApplicationForThisStep()) {
            yourNewPassportPage.verifyPageHeader();
            yourNewPassportPage.completeForm(applicant.desiresExtraLargePassport(), applicant.desiresBrailleSticker());
            yourNewPassportPage.clickContinue();
        }

        return this;
    }

    public SpecificationsStepsApply choosesToSignNewPassport() throws Exception {
        if (isAValidApplicationForThisStep()) {
            if (applicant.isAdult() || applicant.isVeteran() || applicant.isTwelveToFifteen() || applicant.isRising16() || applicant.isFifteenEight()) {
                sarDetailsPage.verifyPageHeader();
                sarDetailsPage.choosesToSign(applicant.canSignNewPassport());
                sarDetailsPage.clickContinue();
            }
        }

        return this;
    }

    public SpecificationsStepsApply choosesToSelectWhoIsThisPassportFor() throws Exception {
        if (!isAValidApplicationForThisStep() || applicant.isPremium()) {
            return this;
        }

        if (applicant.isChild()) {
            String relation = applicant.getWhatRelationToApplicant();
            whatIsYourRelationToApplicantPage.verifyPageHeader();
            whatIsYourRelationToApplicantPage.choosesRelation(relation);
            DataStore.setDataKey(RELATION_TO_APPLICANT, relation);
            whatIsYourRelationToApplicantPage.complete3rdPartyFirstNameLastNameForm(applicant.getThirdPartyFirstName(), applicant.getThirdPartyLastName());
            whatIsYourRelationToApplicantPage.clickContinue();

        } else {
            String recipient = applicant.getWhoIsThisPassportFor();
            whoIsThisPassportForPage.verifyPageHeader();
            whoIsThisPassportForPage.choosesRecipient(recipient);
            DataStore.setDataKey(WHO_IS_THIS_PASSPORT_FOR, recipient);
            whoIsThisPassportForPage.clickContinue();

            if ("Someone else".equalsIgnoreCase(recipient)) {
                String relation = applicant.getWhatRelationToApplicant();
                whatIsYourRelationToApplicantPage.verifyPageHeader();
                whatIsYourRelationToApplicantPage.choosesRelation(relation);
                DataStore.setDataKey(RELATION_TO_APPLICANT, relation);

                whatIsYourRelationToApplicantPage.complete3rdPartyFirstNameLastNameForm(applicant.getThirdPartyFirstName(), applicant.getThirdPartyLastName());
                whatIsYourRelationToApplicantPage.clickContinue();
            }
        }

        return this;
    }

    public SpecificationsStepsApply continuesThroughFinalChecksPage() throws Exception {
        if (isAValidApplicationForThisStep()) {
            finalChecksPage.verifyPageHeader();
            finalChecksPage.clickContinue();
        }

        return this;
    }

    public SpecificationsStepsApply continuesThroughConfirmYourIdentityPage() throws Exception {
        if (isAValidApplicationForThisStep()) {
            confirmYourIdentityPage.verifyPageHeader();
            confirmYourIdentityPage.clickContinue();
        }

        return this;
    }

    public SpecificationsStepsApply continuesThroughOtherDocumentsPage() throws Exception {
        documentsPage.verifyPageHeader();

        if (applicant.isChild()
                && applicant.hasLostOrStolenPassport()
                && !applicant.isADualNational()
                && !applicant.isABritishNationalOverseas()
                && !applicant.hasChangedTheirName()
                && !OTHER.equalsIgnoreCase(DataStore.getDataKey(RELATION_TO_APPLICANT))
                && getCountryOfApplicationGroupNumber(applicant.getCountryCodeOfApplication()) == 1) {
            DataStore.setDataKey(PARENT_HAS_DOCS_TO_SEND, applicant.getParentHasDocsToSend());
            if ("No".equalsIgnoreCase(DataStore.getDataKey(PARENT_HAS_DOCS_TO_SEND))) {
                documentsPage.selectDocumentsToSendNoRadio();
            } else {
                documentsPage.selectDocumentsToSendYesRadio();
            }
        }
        documentsPage.clickContinue();

        return this;
    }

    public SpecificationsStepsApply choosesDeliveryOptions() throws Exception {
        deliveryOptionsPage.verifyPageHeader();
        deliveryOptionsPage.chooseDeliveryOptions(applicant.getDesiredDeliveryType());
        deliveryOptionsPage.clickContinue();

        return this;
    }

    public SpecificationsStepsApply continuesThroughCostPage() throws Exception {
        if (isAValidApplicationForThisStep()) {
            costChecksPage.verifyPageHeader();
            costChecksPage.clickContinue();
        }

        return this;
    }

    public void declaresAgreementToTermsAndConditions() throws Exception {
        if (isAValidApplicationForThisStep()) {
            declarationPage.verifyPageHeader();
            declarationPage.checkDeclaration();
            declarationPage.clickContinue();
        }
    }

    private void entersAnyPreviousNames() {
        if (isAValidApplicationForThisStep()) {
            if (applicant.hasChangedTheirName()) {
                previousNamePage.insertPreviousNames(applicant.getPreviousFirstNames(), applicant.getPreviousSurnames());
                setDataKey(PREVIOUS_NAME_ENTERED, "yes");
            } else {
                if (applicant.hasPreviousNames()) {
                    previousNamePage.selectKnownByAnyOtherName();
                    previousNamePage.insertPreviousNames(applicant.getPreviousFirstNames(), applicant.getPreviousSurnames());
                    setDataKey(PREVIOUS_NAME_ENTERED, "yes");
                } else {
                    previousNamePage.selectNotKnownByAnyOtherName();
                }
            }
            previousNamePage.clickContinue();
        }
    }

    public SpecificationsStepsApply entersGrandparentDetails() throws Exception {
        if (isAValidApplicationForThisStep()) {
            // Only ask for grandparents details for children and first time applicants if both their parents do not have UK Passports
            if ((((applicant.isChild() && applicant.isFirstTimeApplication()) || applicant.isFirstTimeApplication() || applicant.isAHiddenFirstTimeApplicant())
                    && !applicant.hasNaturalisationCertificate()
                    && !"true".equalsIgnoreCase(DataStore.getDataKey(YES_TO_EUSS))
                    && !applicant.parentOneHasAUKPassport()
                    && (!applicant.parentTwoHasAUKPassport() || !applicant.areParentsMarried()))) {
                grandParentsDetailsPage.verifyPageHeader();
                grandParentsDetailsPage.clickContinue();
                boolean fillMaternalGrandParentOnesDetails = Math.random() > 0.5;
                boolean fillMaternalGrandParentTwosDetails = Math.random() > 0.5;
                if (fillMaternalGrandParentOnesDetails) {
                    maternalGrandparentsDetailsPage.completeMaternalGrandParentOnesForm(applicant);
                    log.info("Filled Maternal Grandmother's first name, last name and date of birth");
                } else {
                    DataStore.setDataKey(MATERNAL_GRAND_PARENT_ONE_FIRST_NAME, null);
                    DataStore.setDataKey(MATERNAL_GRAND_PARENT_ONE_LAST_NAME, null);
                    maternalGrandparentsDetailsPage.enterWhyICannotProvideMaternalGrandMotherDetails();
                    log.info("Did not fill Maternal Grandmother's first name, last name and date of birth");
                }
                if (fillMaternalGrandParentTwosDetails) {
                    maternalGrandparentsDetailsPage.completeMaternalGrandParentTwosForm(applicant);
                    log.info("Filled Maternal Grandfather's first name, last name and date of birth");
                } else {
                    DataStore.setDataKey(MATERNAL_GRAND_PARENT_TWO_FIRST_NAME, null);
                    DataStore.setDataKey(MATERNAL_GRAND_PARENT_TWO_LAST_NAME, null);
                    maternalGrandparentsDetailsPage.enterWhyICannotProvideMaternalGrandFatherDetails();
                    log.info("Did not fill Maternal Grandfather's first name, last name and date of birth");
                }
                maternalGrandparentsDetailsPage.completeMaternalGrandParentsMarriedForm(applicant);
                maternalGrandparentsDetailsPage.clickContinue();
                boolean fillPaternalGrandParentOnesDetails = Math.random() > 0.5;
                boolean fillPaternalGrandParentTwosDetails = Math.random() > 0.5;
                if (fillPaternalGrandParentOnesDetails) {
                    paternalGrandparentsDetailsPage.completePaternalGrandParentOnesForm(applicant);
                    log.info("Filled Paternal Grandmother's first name, last name and date of birth");
                } else {
                    DataStore.setDataKey(PATERNAL_GRAND_PARENT_ONE_FIRST_NAME, null);
                    DataStore.setDataKey(PATERNAL_GRAND_PARENT_ONE_LAST_NAME, null);
                    paternalGrandparentsDetailsPage.enterWhyICannotProvidePaternalGrandMotherDetails();
                    log.info("Did not fill Paternal Grandmother's first name, last name and date of birth");
                }
                if (fillPaternalGrandParentTwosDetails) {
                    paternalGrandparentsDetailsPage.completePaternalGrandParentTwosForm(applicant);
                    log.info("Filled Paternal Grandfather's first name, last name and date of birth");
                } else {
                    DataStore.setDataKey(PATERNAL_GRAND_PARENT_TWO_FIRST_NAME, null);
                    DataStore.setDataKey(PATERNAL_GRAND_PARENT_TWO_LAST_NAME, null);
                    paternalGrandparentsDetailsPage.enterWhyICannotProvidePaternalGrandFatherDetails();
                    log.info("Did not fill Paternal Grandfather's first name, last name and date of birth");
                }
                paternalGrandparentsDetailsPage.completePaternalGrandParentsMarriedForm(applicant);
                paternalGrandparentsDetailsPage.clickContinue();
                DataStore.setDataKey(ELIGIBLE_TO_PROVIDE_GRANDPARENTS_DETAILS, "true");
            }
            return this;
        }
        return this;
    }
}
