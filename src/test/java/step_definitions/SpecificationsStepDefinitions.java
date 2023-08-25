package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kainos.specs.driver.DriverManager;
import kainos.specs.helpers.ApplicantData;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import step_definitions.helpers.SpecificationsStepsHelpers;
import step_definitions.steps.SpecificationsStepsApply;
import step_definitions.steps.SpecificationsStepsFilter;
import step_definitions.steps.SpecificationsStepsPhoto;
import step_definitions.helpers.TestEnvironmentHelpers;

import java.util.UUID;

@Slf4j
public class SpecificationsStepDefinitions extends SpecificationsStepsHelpers {

    private final TestEnvironmentHelpers testEnvironment = new TestEnvironmentHelpers();
    private final SpecificationsStepsFilter theApplicantFilter = new SpecificationsStepsFilter();
    private final SpecificationsStepsApply theApplicantApply = new SpecificationsStepsApply();
    private final SpecificationsStepsPhoto theApplicantPhoto = new SpecificationsStepsPhoto();

    private ApplicantData applicant;

    @Before
    public void setUp() {
        getDriver().manage().deleteAllCookies();
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                log.error("TEST FAILED!!");

                String path = scenario.getUri().getPath();
                String feature = path.substring(path.lastIndexOf("/") + 1);
                log.error("FAILED SCENARIO NAME: {} ({}) - {} - {}",
                        scenario.getName(),
                        String.join(" ", scenario.getSourceTagNames()),
                        feature,
                        scenario.getLine());

                log.error("URL FOR FAILED TEST WAS: {}", getCurrentUrl());
                final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", String.valueOf(scenario) + UUID.randomUUID());

            } else {
                log.info("TEST PASSED :)");
            }
            closeWindow();
        } catch (Exception e) {
            log.error("Exception in scenario tearDown", e);
        } finally {
            DriverManager.quitDriver();
        }
    }

    private void setApplicantData(String applicantType) throws Exception {
        applicant = new ApplicantData(applicantType);

        theApplicantFilter.setApplicant(applicant);
        theApplicantApply.setApplicant(applicant);
        theApplicantPhoto.setApplicant(applicant);
    }

    @Given("^an applicant of type (.*?)$")
    public void anApplicant(String applicantType) throws Throwable {
        testEnvironment.setupTestEnvironment(applicantType);
        setApplicantData(applicantType);
    }

    @When("^they apply for a first time passport with a successful payment(?: again)?$")
    public void theyApplyToRenewTheirPassport() throws Throwable {

        theApplicantFilter
                .opensTheService()
                .navigatesTheFilterChooseIfLivesInTheUK()
                .navigatesTheFilterDOB()
                .selectsIfHasAPreviousPassport();

        theApplicantApply
                .entersOldPassportInformation()
                .continuesThroughHowToApplyNonPremium()
                .continuesThroughWhatYouNeedAndPhotoGuidance();

        theApplicantPhoto
                .uploadsAPhoto();

        theApplicantFilter
                .continueNavigationWithFilter();

        theApplicantApply
                .continuesThroughApplicationSummary()
                .continuesThroughWhatYouNeed()
                .entersOldPassportInformation()
                .entersPersonalDetails()
                .entersParentDetails()
                .entersGrandparentDetails()
                .entersAddressAndContactDetails()
                .entersContactPreferences()
                .choosesNewPassportOptions()
                .choosesToSignNewPassport()
                .choosesToSelectWhoIsThisPassportFor()
                .continuesThroughFinalChecksPage()
                .continuesThroughConfirmYourIdentityPage()
                .continuesThroughOtherDocumentsPage()
                .choosesDeliveryOptions()
                .continuesThroughCostPage()
                .declaresAgreementToTermsAndConditions();
    }

    @Then("^the application status will be: (.*)$")
    public void theApplicationWillBe(String expectedStatus) {
        //TODO: Extend the test further
    }
}
