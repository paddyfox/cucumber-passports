package step_definitions.helpers;

import kainos.specs.countrystore.CountryStore;
import kainos.specs.datastore.DataStore;
import kainos.specs.helpers.ApplicantData;
import kainos.specs.site.Site;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

import static kainos.specs.datastore.DataStore.HAS_NATURALISATION_CERTIFICATE;

@Slf4j
public class SpecificationsStepsHelpers extends Site {

    public static int getCountryOfApplicationGroupNumber(String countryCode) {
        if (countryCode.equalsIgnoreCase("UK")) {
            return 1;
        }
        return Integer.parseInt(CountryStore.countryHashMap.get(countryCode).get(5));
    }

    public static boolean isEUSSEligible(ApplicantData applicant) throws Exception {
        return (applicant.isInEUSSAgeRange() && (!Objects.equals(DataStore.getDataKey(HAS_NATURALISATION_CERTIFICATE), "true") && applicant.isFirstTimeApplication() && "UK".equalsIgnoreCase(applicant.getCountryOfBirthCode())));
    }
}
