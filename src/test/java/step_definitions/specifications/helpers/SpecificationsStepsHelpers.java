package step_definitions.specifications.helpers;

import lombok.extern.slf4j.Slf4j;
import kainos.specs.countrystore.CountryStore;
import kainos.specs.datastore.DataStore;
import kainos.specs.helpers.ApplicantData;
import kainos.specs.site.Site;

import java.util.Objects;

import static com.google.common.base.Strings.isNullOrEmpty;
import static kainos.specs.datastore.DataStore.*;
import static kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants.ME;
import static kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants.OTHER;

@Slf4j
public class SpecificationsStepsHelpers extends Site {

    public static int getCountryOfApplicationGroupNumber(String countryCode) {
        if (countryCode.equalsIgnoreCase("UK")) {
            return 1;
        }
        return Integer.parseInt(CountryStore.countryHashMap.get(countryCode).get(5));
    }

    public static boolean isADAPExaminerCsigApplication() {
        return !isNullOrEmpty(DataStore.getDataKey(IS_DAP_EXAMINER_APPLICATION));
    }

    public static boolean hasDocumentsToSend(ApplicantData applicant) {
        return (applicant.isADualNational()
                || applicant.hasChangedTheirName()
                || applicant.isABritishNationalOverseas()
                || (!isNullOrEmpty(DataStore.getDataKey(WHO_IS_THIS_PASSPORT_FOR)) && !ME.equalsIgnoreCase(DataStore.getDataKey(WHO_IS_THIS_PASSPORT_FOR)))
                || (!isNullOrEmpty(DataStore.getDataKey(RELATION_TO_APPLICANT)) && OTHER.equalsIgnoreCase(DataStore.getDataKey(RELATION_TO_APPLICANT)))
                || (!isNullOrEmpty(DataStore.getDataKey(PARENT_HAS_DOCS_TO_SEND)) && "Yes".equalsIgnoreCase(DataStore.getDataKey(PARENT_HAS_DOCS_TO_SEND)))
                || (!isNullOrEmpty(DataStore.getDataKey(APPLICANT_EUSS_STATUS)) && "Yes".equalsIgnoreCase(DataStore.getDataKey(APPLICANT_EUSS_STATUS)))
                || getCountryOfApplicationGroupNumber(applicant.getCountryCodeOfApplication()) != 1);
    }

    public static boolean requiresADigitalReferee(ApplicantData applicant) {
        return (applicant.isFirstTimeApplication()
                || applicant.isAHiddenFirstTimeApplicant()
                || applicant.isABritishNationalOverseasRequiringAReferee()
                || applicant.isLessThanYearsOld(12)
                || (applicant.hasSpecialIssueDate() && !applicant.isPremium() && !applicant.isCompassionate())
                || (applicant.hasLostOrStolenPassport() && applicant.hasCancelledPassport())
                || isADAPExaminerCsigApplication());
    }

    public static boolean isEUSSEligible(ApplicantData applicant) throws Exception {
        return (applicant.isInEUSSAgeRange() && (!Objects.equals(DataStore.getDataKey(HAS_NATURALISATION_CERTIFICATE), "true") && applicant.isFirstTimeApplication() && "UK".equalsIgnoreCase(applicant.getCountryOfBirthCode())));
    }
}
