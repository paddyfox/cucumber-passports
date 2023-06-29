package step_definitions.specifications.steps;

import kainos.specs.site.page_objects.or.pages.filter.*;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import step_definitions.specifications.helpers.SpecificationsStepsHelpers;
import kainos.specs.datastore.DataStore;
import kainos.specs.helpers.ApplicantData;
import kainos.specs.site.page_objects.or.pages.StartPage;

import static kainos.specs.datastore.DataStore.APPLICATION_NOT_ALLOWED;
import static kainos.specs.helpers.ApplicantData.isAValidApplicationForThisStep;

@Slf4j
public class SpecificationsStepsFilter extends SpecificationsStepsHelpers {

    private final WebDriver driver = getDriver();

    private final StartPage startPage = PageFactory.initElements(driver, StartPage.class);
    private final OverseasPage overseasPage = PageFactory.initElements(driver, OverseasPage.class);
    private final PreviousPassportPage previousPassportPage = PageFactory.initElements(driver, PreviousPassportPage.class);
    private final AgePage agePage = PageFactory.initElements(driver, AgePage.class);
    private final NaturalisationCertificatePage naturalisationCertificatePage = PageFactory.initElements(driver, NaturalisationCertificatePage.class);
    private final OtherPassportsPage otherPassportsPage = PageFactory.initElements(driver, OtherPassportsPage.class);
    private final OverseasCountryOfBirthPage overseasCountryOfBirthPage = PageFactory.initElements(driver, OverseasCountryOfBirthPage.class);

    @Setter
    private ApplicantData applicant;

    public SpecificationsStepsFilter opensTheService() throws Exception {
        startPage.openPage();
        startPage.verifyPageHeader();
        startPage.clickStartButton();

        return this;
    }

    public SpecificationsStepsFilter navigatesTheFilterChooseIfLivesInTheUK() throws Exception {
        if (isAValidApplicationForThisStep()) {
            chooseIfLivesInTheUK();
        }
        return this;
    }

    public SpecificationsStepsFilter navigatesTheFilterDOB() throws Exception {
        if (applicant.isAnOverseasType7Country()) {
            DataStore.setDataKey(APPLICATION_NOT_ALLOWED, "true");
        }
        if (isAValidApplicationForThisStep()) {
            entersDateOfBirth();
        }
        return this;
    }

    public SpecificationsStepsFilter continueNavigationWithFilter() throws Exception {
        if (isAValidApplicationForThisStep()) {

            if (applicant.isFirstTimeApplication()) {
                entersAnyOtherPassports();
                if (applicant.isOverseas()) {
                    entersNaturalisationCertificateDetails();
                    selectsOverseasCountryOfBirth();
                } else {
                    entersNaturalisationCertificateDetails();
                }
            }
        }

        return this;
    }

    private boolean hasPreviousPassport() {
        return (!applicant.isFirstTimeApplication() || applicant.isAHiddenFirstTimeApplicant());
    }

    private void chooseIfLivesInTheUK() throws Exception {
        overseasPage.chooseApplicationLocation(applicant.isOverseas(), applicant.getCountryCodeOfApplication());
        overseasPage.clickContinue();
    }

    private void entersDateOfBirth() throws Exception {
        if (isAValidApplicationForThisStep()) {
            agePage.verifyPageHeader();
            agePage.setDateOfBirth(applicant.getDateOfBirth());
            agePage.clickContinue();
        }
    }

    public SpecificationsStepsFilter selectsIfHasAPreviousPassport() throws Exception {
        if (isAValidApplicationForThisStep()) {
            previousPassportPage.verifyPageHeader();
            previousPassportPage.selectIfHasPreviousPassport(hasPreviousPassport());
            previousPassportPage.clickContinue();
        }
        return this;
    }

    private void entersNaturalisationCertificateDetails() throws Exception {
        if (isAValidApplicationForThisStep()) {
            naturalisationCertificatePage.verifyPageHeader();
            naturalisationCertificatePage.selectIfHasNaturalisationCertificate(applicant.hasNaturalisationCertificate());
            naturalisationCertificatePage.clickContinue();
        }
    }

    private void entersAnyOtherPassports() throws Exception {
        if (isAValidApplicationForThisStep()) {
            otherPassportsPage.verifyPageHeader();
            otherPassportsPage.selectIfHasOtherPassports(applicant.isADualNational());
            otherPassportsPage.clickContinue();
        }
    }

    private void selectsOverseasCountryOfBirth() throws Exception {
        if (isAValidApplicationForThisStep()) {
            overseasCountryOfBirthPage.verifyPageHeader();
            overseasCountryOfBirthPage.selectCountryOfBirth(applicant.getCountryOfBirthCode());
            overseasCountryOfBirthPage.clickContinue();
        }
    }
}
