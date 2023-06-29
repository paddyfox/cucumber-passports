package kainos.specs.datastore;

import lombok.experimental.UtilityClass;

import java.util.HashMap;

@UtilityClass
public class DataStore {

    public static final String APPLICANT_FORENAMES = "applicantForenames";
    public static final String APPLICANT_SURNAME = "applicantSurname";
    public static final String APPLICANT_DATE_OF_BIRTH = "applicantDOB";
    public static final String APPLICANT_EMAIL = "applicantEmail";
    public static final String APPLICANT_COUNTRY_CODE = "countryCodeOfApplication";
    public static final String APPLICANT_COUNTRY_OF_BIRTH = "countryOfBirth";
    public static final String APPLICANT_COUNTRY_OF_BIRTH_AMS = "countryOfBirthAms";
    public static final String APPLICANT_COUNTRY_OF_BIRTH_URL = "countryOfBirthURL";
    public static final String APPLICANT_COUNTRY_OF_APPLICATION = "countryOfApplication";
    public static final String APPLICANT_COUNTRY_OF_APPLICATION_URL = "countryOfApplicationURL";
    public static final String APPLICANT_ADDRESS_POSTCODE = "addressPostcode";
    public static final String APPLICANT_EUSS_STATUS = "applicantEUSSStatus";
    public static final String PARENT_ONE_FIRST_NAME = "parentOneFirstName";
    public static final String MATERNAL_GRAND_PARENT_ONE_FIRST_NAME = "maternalGrandParentOneFirstName";
    public static final String PATERNAL_GRAND_PARENT_ONE_FIRST_NAME = "paternalGrandParentOneFirstName";
    public static final String PARENT_TWO_FIRST_NAME = "parentTwoFirstName";
    public static final String MATERNAL_GRAND_PARENT_TWO_FIRST_NAME = "maternalGrandParentTwoFirstName";
    public static final String PATERNAL_GRAND_PARENT_TWO_FIRST_NAME = "paternalGrandParentTwoFirstName";
    public static final String PARENT_ONE_LAST_NAME = "parentOneLastName";
    public static final String MATERNAL_GRAND_PARENT_ONE_LAST_NAME = "maternalGrandParentOneLastName";
    public static final String PATERNAL_GRAND_PARENT_ONE_LAST_NAME = "paternalGrandParentOneLastName";
    public static final String PARENT_TWO_LAST_NAME = "parentTwoLastName";
    public static final String MATERNAL_GRAND_PARENT_TWO_LAST_NAME = "maternalGrandParentTwoLastName";
    public static final String PATERNAL_GRAND_PARENT_TWO_LAST_NAME = "paternalGrandParentTwoLastName";
    public static final String RELATION_TO_APPLICANT = "relationToApplicant";
    public static final String THIRD_PARTY_FIRST_NAME = "thirdPartyFirstName";
    public static final String THIRD_PARTY_LAST_NAME = "thirdPartyLastName";
    public static final String PARENT_ONE_COUNTRY_OF_BIRTH_AMS = "parentOneCountryOfBirth";
    public static final String PARENT_TWO_COUNTRY_OF_BIRTH_AMS = "parentTwoCountryOfBirth";
    public static final String MATERNAL_GRAND_PARENT_ONE_COUNTRY_OF_BIRTH = "maternalGrandParentOneCountryOfBirth";
    public static final String MATERNAL_GRAND_PARENT_TWO_COUNTRY_OF_BIRTH = "maternalGrandParentTwoCountryOfBirth";
    public static final String PATERNAL_GRAND_PARENT_ONE_COUNTRY_OF_BIRTH = "paternalGrandParentOneCountryOfBirth";
    public static final String PATERNAL_GRAND_PARENT_TWO_COUNTRY_OF_BIRTH = "paternalGrandParentTwoCountryOfBirth";
    public static final String TITLE = "title";
    public static final String PARENT_HAS_DOCS_TO_SEND = "parentHasDocsToSend";
    public static final String WHO_IS_THIS_PASSPORT_FOR = "whoIsThisPassportFor";
    public static final String WHAT_NATIONALITY_ON_PASSPORT = "whatNationalityOnPassport";
    public static final String HAS_NATURALISATION_CERTIFICATE = "hasNaturalisationCertificate";
    public static final String NATURALISATION_CERTIFICATE_NUMBER = "naturalisationCertificateNumber";
    public static final String NATURALISATION_CERTIFICATE_ISSUE_DATE = "naturalisationCertificateIssueDate";
    public static final String IS_DAP_APPLICATION = "isDAPApplication";
    public static final String IS_DAP_EXAMINER_APPLICATION = "isDAPExaminerApplication";
    public static final String PHOTO_TYPE = "photoType";
    public static final String APPLICATION_LANGUAGE = "applicationLanguage";
    public static final String APPLICATION_NOT_ALLOWED = "applicationNotAllowed";
    public static final String DELIVERY_OPTION = "deliveryOption";
    public static final String BOOKING_FAILURE = "bookingFailure";

    public static final String PARENT_ONE_COUNTRY_OF_BIRTH_CODE = "parentOneCountryOfBirthCode";
    public static final String PARENT_ONE_TOWN_OF_BIRTH = "parentOneTownOfBirth";
    public static final String PARENT_TWO_COUNTRY_OF_BIRTH_CODE = "parentTwoCountryOfBirthCode";
    public static final String PARENT_TWO_TOWN_OF_BIRTH = "parentTwoTownOfBirth";
    public static final String PARENT_ONE_BIRTH_DATE = "parentOneBirthDate";
    public static final String PARENT_TWO_BIRTH_DATE = "parentTwoBirthDate";
    public static final String PARENTS_ONE_TWO_NATIONALITY = "parentsNationality";

    public static final String MATERNAL_GRAND_PARENT_ONE_DOB = "maternalGrandParentOneDOB";
    public static final String MATERNAL_GRAND_PARENT_ONE_PLACE_OF_BIRTH = "maternalGrandparentOnePlaceOfBirth";
    public static final String MATERNAL_GRAND_PARENT_ONE_COUNTRY_OF_BIRTH_CODE = "maternalGrandparentOneCountryOfBirthCode";
    public static final String MATERNAL_GRAND_PARENT_ONE_REASON = "maternalGrandparentOneReason";

    public static final String MATERNAL_GRAND_PARENT_TWO_DATE_OF_BIRTH = "maternalGrandparentTwoDOB";
    public static final String MATERNAL_GRAND_PARENT_TWO_PLACE_OF_BIRTH = "maternalGrandparentTwoPlaceOfBirth";
    public static final String MATERNAL_GRAND_PARENT_TWO_COUNTRY_OF_BIRTH_CODE = "maternalGrandparentTwoCountryOfBirthCode";
    public static final String MATERNAL_GRAND_PARENT_TWO_REASON = "maternalGrandparentTwoReason";

    public static final String PATERNAL_GRAND_PARENT_ONE_DATE_OF_BIRTH = "paternalGrandParentOneDOB";
    public static final String PATERNAL_GRAND_PARENT_ONE_PLACE_OF_BIRTH = "paternalGrandparentOnePlaceOfBirth";
    public static final String PATERNAL_GRAND_PARENT_ONE_COUNTRY_OF_BIRTH_CODE = "paternalGrandparentOneCountryOfBirthCode";
    public static final String PATERNAL_GRAND_PARENT_ONE_REASON = "paternalGrandparentOneReason";

    public static final String PATERNAL_GRAND_PARENT_TWO_DATE_OF_BIRTH = "paternalGrandparentTwoDOB";
    public static final String PATERNAL_GRAND_PARENT_TWO_PLACE_OF_BIRTH = "paternalGrandparentTwoPlaceOfBirth";
    public static final String PATERNAL_GRAND_PARENT_TWO_COUNTRY_OF_BIRTH_CODE = "paternalGrandparentTwoCountryOfBirthCode";
    public static final String PATERNAL_GRAND_PARENT_TWO_REASON = "paternalGrandparentTwoReason";

    public static final String MOTHER_REASON = "motherReason";
    public static final String FATHER_REASON = "fatherReason";
    public static final String PARENT_ONE_PASSPORT_NUMBER = "parentOnePassportNumber";
    public static final String PARENT_TWO_PASSPORT_NUMBER = "parentTwoPassportNumber";
    public static final String DAP_PHOTO_RESUB = "dapPhotoResub";
    public static final String STORED_PHOTO_NAME = "photoName";
    public static final String APPLICANT_ADDRESS_STATEORPROVINCE = "stateOrProvince";
    public static final String HAS_CHANGED_NAME_BEFORE_EDIT = "hasChangedNameBeforeEdit";
    public static final String PREVIOUS_NAME_ENTERED = "previousNameEntered";
    public static final String NO_CHANGE = "noChange";
    public static final String ELIGIBLE_TO_PROVIDE_GRANDPARENTS_DETAILS = "eligibleToProvideGrandParentsDetails";
    public static final String YES_TO_EUSS = "selectedYesToEUSS";

    private static final ThreadLocal<HashMap<String, String>> myData = ThreadLocal.withInitial(HashMap::new);

    public static void setDataKey(String key, String value) {
        myData.get().put(key, value);
    }

    public static String getDataKey(String key) {
        return myData.get().get(key);
    }

    public static Boolean hasKey(String key) {
        String value = myData.get().getOrDefault(key, null);

        return value != null;
    }
}
