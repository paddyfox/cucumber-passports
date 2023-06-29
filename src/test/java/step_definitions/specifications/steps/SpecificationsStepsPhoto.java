package step_definitions.specifications.steps;

import kainos.specs.site.page_objects.or.pages.photo.*;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import step_definitions.specifications.helpers.SpecificationsStepsHelpers;
import kainos.specs.datastore.DataStore;
import kainos.specs.helpers.ApplicantData;

import static kainos.specs.datastore.DataStore.*;
import static org.testng.Assert.assertEquals;

@Slf4j
public class SpecificationsStepsPhoto extends SpecificationsStepsHelpers {

    private final WebDriver driver = getDriver();
    private final PhotoChooseMethodPage photoChooseMethodPage = PageFactory.initElements(driver, PhotoChooseMethodPage.class);
    private final PhotoUploadPage photoUploadPage = PageFactory.initElements(driver, PhotoUploadPage.class);
    private final PhotoGuideHowToTakeADigitalPhotoPage photoGuideHowToTakeADigitalPhotoPage = PageFactory.initElements(driver, PhotoGuideHowToTakeADigitalPhotoPage.class);
    private final PhotoUploadResultPage photoUploadResultPage = PageFactory.initElements(driver, PhotoUploadResultPage.class);
    private final PhotoSubmitPhotoPage photoSubmitPhotoPage = PageFactory.initElements(driver, PhotoSubmitPhotoPage.class);

    @Setter
    private ApplicantData applicant;

    public void uploadsAPhoto() throws Exception {
        uploadPhoto();
        confirmsUploadedPhoto();
    }

    private void confirmsUploadedPhoto() throws Exception {
                    waitForPhotoUploadRetrieve();
                    verifyPhotoResult();
    }

    private void verifyPhotoResult() throws Exception {
        photoUploadResultPage.clickContinue();
        photoSubmitPhotoPage.verifyPageHeader();
        photoSubmitPhotoPage.clickSubmitThisPhotoButton();
        photoSubmitPhotoPage.clickOnContinue();
    }

    private void uploadPhoto() throws Exception {
        DataStore.setDataKey(PHOTO_TYPE, "Photo Upload");

        photoChooseMethodPage.selectIHaveADigitalPhotoToUpload();
        photoChooseMethodPage.clickContinue();

        photoGuideHowToTakeADigitalPhotoPage.verifyPageHeader();
        verifyCorrectPhotoGuidance();
        photoGuideHowToTakeADigitalPhotoPage.clickContinue();

        photoUploadPage.verifyPageHeader();
        if (hasKey(DAP_PHOTO_RESUB) && getDataKey(DAP_PHOTO_RESUB).equalsIgnoreCase("true")) {
            photoUploadPage.uploadPhoto(applicant.getPhotoName(), ".jpg");
        } else {
            if (hasKey(STORED_PHOTO_NAME)) {

                photoUploadPage.uploadPhoto(getDataKey(STORED_PHOTO_NAME), ".jpg");
            } else {
                photoUploadPage.uploadPhoto(applicant.getPhotoName(), ".jpg");
            }

        }
        log.info("PHOTO UPLOAD NAME: [{}], PHOTO UPLOAD TYPE: [{}]", getDataKey(STORED_PHOTO_NAME), getDataKey(PHOTO_TYPE));
    }

    private void verifyCorrectPhotoGuidance() {
        if (applicant.isRising16() || !applicant.isChild()) {
                assertEquals(photoGuideHowToTakeADigitalPhotoPage.getPhotoGuidanceSubHeader(), "Photos for adults");
        } else {
                assertEquals(photoGuideHowToTakeADigitalPhotoPage.getPhotoGuidanceSubHeader(), "Photos for babies and children");
        }
    }

    private void waitForPhotoUploadRetrieve() {
        webDriverWait(90_000).until(ExpectedConditions.invisibilityOfElementLocated(By.id("progress-container")));
    }
}
