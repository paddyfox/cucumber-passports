package kainos.specs.helpers;

import kainos.specs.site.page_objects.or.constants.StepDefinitionAssertionConstants;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import kainos.specs.datastore.DataStore;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Objects.*;

@Slf4j
public class ApplicantData extends TestData {

    private static final String DOB_KEY = "dateOfBirth";
    private static final String OVERSEAS_KEY = "isOverseas";
    private static final String TITLE_KEY = "title";
    private static final String FIRST_NAMES_KEY = "firstNames";
    private static final String SURNAME_KEY = "surname";
    private static final String PREVIOUS_FIRST_NAMES_KEY = "previousFirstNames";
    private static final String PREVIOUS_SURNAMES_KEY = "previousSurnames";
    private static final String HAS_NAME_CHANGE_KEY = "hasNameChange";
    private static final String NAME_CHANGE_REASON_KEY = "nameChangeReason";
    private static final String GENDER_KEY = "gender";
    private static final String TOWN_OF_BIRTH_KEY = "townOfBirth";
    private static final String COUNTRY_OF_BIRTH_CODE_KEY = "countryOfBirthCode";
    private static final String COUNTRY_CODE_OF_APPLICATION_KEY = "countryCodeOfApplication";
    private static final String EXISTING_PASSPORT_ISSUE_DATE_KEY = "existingPassportIssueDate";
    private static final String EXISTING_PASSPORT_EXPIRY_DATE_KEY = "existingPassportExpiryDate";
    private static final String EXISTING_PASSPORT_NUMBER_KEY = "existingPassportNumber";
    private static final String ADDRESS_POSTCODE_KEY = "addressPostcode";
    private static final String ADDRESS_LINE_1_KEY = "addressLine1";
    private static final String ADDRESS_LINE_2_KEY = "addressLine2";
    private static final String ADDRESS_TOWN_KEY = "addressTown";
    private static final String ADDRESS_STATE_PROVINCE = "addressStateProvince";
    private static final String EMAIL_KEY = "email";
    private static final String HOUSE_PHONE_NUMBER_KEY = "housePhoneNumber";
    private static final String MOBILE_PHONE_NUMBER_KEY = "mobilePhoneNumber";
    private static final String DESIRES_EMAIL_UPDATES_KEY = "desiresEmailUpdates";
    private static final String DESIRES_TEXT_UPDATES_KEY = "desiresTextUpdates";
    private static final String ISSUING_AUTHORITY_KEY = "issuingAuthority";
    private static final String DESIRED_PASSPORT_SIZE_KEY = "passportSize";
    private static final String DESIRES_BRAILLE_STICKER_KEY = "desiresBrailleSticker";
    private static final String PROCESSING_CENTRE_KEY = "processingCentre";
    private static final String CAN_SIGN_NEW_PASSPORT_KEY = "canSignNewPassport";
    private static final String DESIRED_DELIVERY_TYPE_KEY = "desiredDeliveryType";
    private static final String PREMIUM_KEY = "isPremium";
    private static final String COMPASSIONATE_KEY = "isCompassionate";
    private static final String OFFICE_USE_KEY = "isOfficeUse";
    private static final String POL_KEY = "isPOL";
    private static final String NAME_CHANGE_KEY = "hasNameChange";
    private static final String PASSPORT_DAMAGED_KEY = "isPassportDamaged";
    private static final String LOST_OR_STOLEN_KEY = "isLostOrStolen";
    private static final String HAS_CANCELLED_PASSPORT = "hasCancelledPassport";
    private static final String EUSS_STATUS_KEY = "EUSSStatus";
    private static final String FIRST_TIME_APPLICANT_KEY = "isFirstTimeApplication";
    private static final String HAS_NATURALISATION_CERTIFICATE_KEY = "hasNaturalisationCertificate";
    private static final String CERTIFICATE_NUMBER_KEY = "certificateNumber";
    private static final String NATURALISATION_DATE_KEY = "naturalisationDate";
    private static final String PARENT_ONE_FIRST_NAME_KEY = "parentOneFirstName";
    private static final String PARENT_ONE_LAST_NAME_KEY = "parentOneLastName";
    private static final String PARENT_TWO_FIRST_NAME_KEY = "parentTwoFirstName";
    private static final String PARENT_TWO_LAST_NAME_KEY = "parentTwoLastName";
    private static final String PARENT_ONES_PARENT_ONE_FIRST_NAME_KEY = "parentOnesParentOneFirstName";
    private static final String PARENT_ONES_PARENT_ONE_LAST_NAME_KEY = "parentOnesParentOneLastName";
    private static final String PARENT_ONES_PARENT_ONE_TOWN_OF_BIRTH_KEY = "parentOnesParentOneTownOfBirth";
    private static final String PARENT_ONES_PARENT_TWO_TOWN_OF_BIRTH_KEY = "parentOnesParentTwoTownOfBirth";
    private static final String PARENT_ONES_PARENT_ONE_COUNTRY_OF_BIRTH_KEY = "maternalGrandmotherCountryOfBirth";
    private static final String PARENT_ONES_PARENT_TWO_COUNTRY_OF_BIRTH_KEY = "maternalGrandfatherCountryOfBirth";
    private static final String PARENT_ONES_PARENT_ONE_BIRTH_DATE_KEY = "parentOnesParentOneBirthDate";
    private static final String PARENT_ONES_PARENT_TWO_BIRTH_DATE_KEY = "parentOnesParentTwoBirthDate";
    private static final String PARENT_ONES_PARENTS_MARRIAGE_DATE_KEY = "parentOnesParentsMarriageDate";
    private static final String PARENT_TWOS_PARENTS_MARRIAGE_DATE_KEY = "parentTwosParentsMarriageDate";
    private static final String PARENT_ONES_PARENT_TWO_FIRST_NAME_KEY = "parentOnesParentTwoFirstName";
    private static final String PARENT_ONES_PARENT_TWO_LAST_NAME_KEY = "parentOnesParentTwoLastName";
    private static final String PARENT_ONE_BIRTH_DATE_KEY = "parentOneBirthDate";
    private static final String PARENT_TWO_BIRTH_DATE_KEY = "parentTwoBirthDate";
    private static final String PARENTS_MARRIED_STATUS_KEY = "parentsMarried";
    private static final String PARENT_ONES_PARENTS_MARRIED_STATUS_KEY = "parentOnesParentsMarried";
    private static final String PARENT_TWOS_PARENT_ONE_FIRST_NAME_KEY = "parentTwosParentOneFirstName";
    private static final String PARENT_TWOS_PARENT_ONE_LAST_NAME_KEY = "parentTwosParentOneLastName";
    private static final String PARENT_TWOS_PARENT_ONE_TOWN_OF_BIRTH_KEY = "parentTwosParentOneTownOfBirth";
    private static final String PARENT_TWOS_PARENT_TWO_TOWN_OF_BIRTH_KEY = "parentTwosParentTwoTownOfBirth";
    private static final String PARENT_TWOS_PARENT_ONE_COUNTRY_OF_BIRTH_KEY = "paternalGrandmotherCountryOfBirth";
    private static final String PARENT_TWOS_PARENT_TWO_COUNTRY_OF_BIRTH_KEY = "paternalGrandfatherCountryOfBirth";
    private static final String PARENT_TWOS_PARENT_ONE_BIRTH_DATE_KEY = "parentTwosParentOneBirthDate";
    private static final String PARENT_TWOS_PARENT_TWO_BIRTH_DATE_KEY = "parentTwosParentTwoBirthDate";
    private static final String PARENT_TWOS_PARENT_TWO_FIRST_NAME_KEY = "parentTwosParentTwoFirstName";
    private static final String PARENT_TWOS_PARENT_TWO_LAST_NAME_KEY = "parentTwosParentTwoLastName";
    private static final String PARENT_TWOS_PARENTS_MARRIED_STATUS_KEY = "parentTwosParentsMarried";
    private static final String PARENT_ONE_UK_PASSPORT_KEY = "parentOneHavingUKPassport";
    private static final String PARENT_TWO_UK_PASSPORT_KEY = "parentTwoHavingUKPassport";
    private static final String PARENTS_NATIONALITY_KEY = "parentsNationality";
    private static final String PARENT_ONE_COUNTRY_CODE_OF_BIRTH_KEY = "parentOneCountryOfBirthCode";
    private static final String PARENT_TWO_COUNTRY_CODE_OF_BIRTH_KEY = "parentTwoCountryOfBirthCode";
    private static final String PARENT_ONES_PARENT_ONE_COUNTRY_CODE_OF_BIRTH_KEY = "maternalGrandParentOneCountryOfBirthCode";
    private static final String PARENT_ONES_PARENT_TWO_COUNTRY_CODE_OF_BIRTH_KEY = "maternalGrandParentTwoCountryOfBirthCode";
    private static final String PARENT_TWOS_PARENT_ONE_COUNTRY_CODE_OF_BIRTH_KEY = "paternalGrandParentOneCountryOfBirthCode";
    private static final String PARENT_TWOS_PARENT_TWO_COUNTRY_CODE_OF_BIRTH_KEY = "paternalGrandParentTwoCountryOfBirthCode";
    private static final String PARENTS_MARRIAGE_DATE_KEY = "parentsMarriageDate";
    private static final String PARENT_ONE_PASSPORT_NUMBER_KEY = "parentOnePassportNumber";
    private static final String PARENT_TWO_PASSPORT_NUMBER_KEY = "parentTwoPassportNumber";
    public static final String PARENT_ONE_PASSPORT_ISSUE_DATE_DAY = "parentOnePassportIssueDateDay";
    public static final String PARENT_ONE_PASSPORT_ISSUE_DATE_MONTH = "parentOnePassportIssueDateMonth";
    public static final String PARENT_ONE_PASSPORT_ISSUE_DATE_YEAR = "parentOnePassportIssueDateYear";
    public static final String PARENT_TWO_PASSPORT_ISSUE_DATE_DAY = "parentTwoPassportIssueDateDay";
    public static final String PARENT_TWO_PASSPORT_ISSUE_DATE_MONTH = "parentTwoPassportIssueDateMonth";
    public static final String PARENT_TWO_PASSPORT_ISSUE_DATE_YEAR = "parentTwoPassportIssueDateYear";
    private static final String PARENT_ONE_TOWN_OF_BIRTH = "parentOneTownOfBirth";
    private static final String PARENT_TWO_TOWN_OF_BIRTH = "parentTwoTownOfBirth";
    private static final String WHO_IS_THIS_PASSPORT_FOR = "whoIsThisPassportFor";
    private static final String WHAT_RELATION_TO_APPLICANT = "whatRelationToApplicant";
    private static final String NATIONALITY_ON_PASSPORT = "whatNationalityOnPassport";
    private static final String THIRD_PARTY_FIRST_NAME = "thirdPartyFirstName";
    private static final String THIRD_PARTY_LAST_NAME = "thirdPartyLastName";
    private static final String PARENT_HAS_DOCS_TO_SEND = "parentHasDocsToSend";
    private static final String APPLICATION_LANGUAGE = "applicationLanguage";
    private static final String PHOTO_NAME = "photoName";
    private static final String[] YES_NO_OPTIONS = {"yes", "no"};
    private static final String OTHER_OPTION = "Other";
    private static final String STANDARD_OPTION = "Standard";
    private static final String DOB_LOG_STRING = "Applicant Date of Birth: {}";
    private static final String IS_DAP_EXAMINER_APPLICATION = "isDAPExaminerApplication";
    private static final String EDIT_DOB_KEY = "editDOB";
    private static final String EDIT_PARENTS_KEY = "editParents";
    private static final String EDIT_GRANDPARENTS_KEY = "editGrandParents";
    private static final String EDIT_COUNTRY_OF_APPLICATION_KEY = "editCountryOfApplication";
    private static final String UPGRADE_REQUIREMENT_TYPE = "upgradeRequirementType";
    private static final String UPGRADE_DECISION_KEY = "upgradeApproved";

    private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_STRING);

    // Data from file
    private final String countryCodeOfApplication;
    private final String dateOfBirth;
    private final String title;
    private String gender;
    private String firstNames;
    private final List<String> previousFirstNames;
    private final List<String> previousSurnames;
    private Boolean hasNameChange;
    private String nameChangeReason;
    private String surname;
    private final String townOfBirth;
    private final String countryOfBirthCode;
    private final Boolean isOverseas;
    private final String addressLine1;
    private final String addressLine2;
    private final String addressTown;
    private final String addressStateProvince;
    private final String email;
    private final String housePhoneNumber;
    private final String mobilePhoneNumber;
    private String existingPassportNumber;
    private final String existingPassportIssueDate;
    private final String existingPassportExpiryDate;
    private String desiresBrailleSticker;
    private String processingCentre;
    private String desiredDeliveryType;
    private String desiresEmailUpdates;
    private String desiresTextUpdates;
    private final String issuingAuthority;
    private Boolean canSignNewPassport;
    private Boolean isPremium;
    private Boolean isCompassionate;
    private final Boolean isPOL;
    private final Boolean isLostOrStolen;
    private final String hasCancelledPassport;
    private final Boolean isFirstTimeApplication;
    private final Boolean hasNaturalisationCertificate;
    private String parentOneFirstName;
    private String parentOneLastName;
    private String parentTwoFirstName;
    private String parentTwoLastName;
    private final String parentOneBirthDate;
    private final String parentTwoBirthDate;
    private final String parentsMarried;
    private final String parentOneHasAUKPassport;
    private final String parentTwoHasAUKPassport;
    private final String parentsNationality;
    private final String parentOneCountryOfBirthCode;
    private final String parentTwoCountryOfBirthCode;
    private final String parentsMarriageDate;
    private String parentOnePassportNumber;
    private String parentTwoPassportNumber;
    private final String parentOnePassportIssueDateDay;
    private final String parentOnePassportIssueDateMonth;
    private final String parentOnePassportIssueDateYear;
    private final String parentTwoPassportIssueDateDay;
    private final String parentTwoPassportIssueDateMonth;
    private final String parentTwoPassportIssueDateYear;
    private final String parentOneTownOfBirth;
    private final String parentTwoTownOfBirth;
    private final String whoIsThisPassportFor;
    private final String whatRelationToApplicant;
    private final String whatNationalityOnPassport;
    private final String thirdPartyFirstName;
    private final String thirdPartyLastName;
    private final String parentHasDocsToSend;
    private final String EUSSStatus;
    private final String parentOnesParentOneFirstName;
    private final String parentOnesParentOneLastName;
    private final String parentOnesParentTwoFirstName;
    private final String parentOnesParentTwoLastName;
    private final String parentOnesParentOneTownOfBirth;
    private final String parentOnesParentTwoTownOfBirth;
    private final String maternalGrandmotherCountryOfBirthCode;
    private final String maternalGrandfatherCountryOfBirthCode;
    private final String parentOnesParentOneBirthDate;
    private final String parentOnesParentTwoBirthDate;
    private final String parentOnesParentsMarried;
    private final String parentOnesParentsMarriageDate;
    private final String parentTwosParentOneFirstName;
    private final String parentTwosParentOneLastName;
    private final String parentTwosParentTwoFirstName;
    private final String parentTwosParentTwoLastName;
    private final String parentTwosParentOneTownOfBirth;
    private final String parentTwosParentTwoTownOfBirth;
    private final String paternalGrandmotherCountryOfBirthCode;
    private final String paternalGrandfatherCountryOfBirthCode;
    private final String parentTwosParentOneBirthDate;
    private final String parentTwosParentTwoBirthDate;
    private final String parentTwosParentsMarried;
    private final String parentTwosParentsMarriageDate;
    private String applicationLanguage;
    private String photoName;
    private final String certificateNumber;
    private String naturalisationDate;

    // Derived data
    private Boolean isOverseasNonStandardCountryFlag;
    private Boolean isOverseasType7CountryFlag;
    private String photoType;
    public Integer previousNameCount;
    public Boolean hasPreviousNames;


    public ApplicantData(String scenarioName) throws Exception {
        super(scenarioName, "applicants");

        countryCodeOfApplication = checkRandomString(COUNTRY_CODE_OF_APPLICATION_KEY);
        dateOfBirth = checkRandomString(DOB_KEY);
        DataStore.setDataKey(DataStore.APPLICANT_DATE_OF_BIRTH, dateOfBirth);
        title = checkRandomString(TITLE_KEY);
        gender = checkRandomString(GENDER_KEY);
        firstNames = checkRandomString(FIRST_NAMES_KEY);
        hasNameChange = checkRandomBoolean(HAS_NAME_CHANGE_KEY);
        hasPreviousNames = hasChangedTheirName() || RANDOM_GENERATOR.nextBoolean();
        previousNameCount = hasPreviousNames ? RANDOM_GENERATOR.nextInt(8) + 1 : 1;

        previousFirstNames = checkRandomList(PREVIOUS_FIRST_NAMES_KEY);
        previousSurnames = checkRandomList(PREVIOUS_SURNAMES_KEY);
        nameChangeReason = checkRandomString(NAME_CHANGE_REASON_KEY);
        surname = checkRandomString(SURNAME_KEY);
        townOfBirth = checkRandomString(TOWN_OF_BIRTH_KEY);
        countryOfBirthCode = checkRandomString(COUNTRY_OF_BIRTH_CODE_KEY);
        isOverseas = checkRandomBoolean(OVERSEAS_KEY);
        addressLine1 = checkRandomString(ADDRESS_LINE_1_KEY);
        addressLine2 = checkRandomString(ADDRESS_LINE_2_KEY);
        addressTown = checkRandomString(ADDRESS_TOWN_KEY);
        addressStateProvince = checkRandomString(ADDRESS_STATE_PROVINCE);
        email = checkRandomString(EMAIL_KEY);
        housePhoneNumber = checkRandomString(HOUSE_PHONE_NUMBER_KEY);
        mobilePhoneNumber = checkRandomString(MOBILE_PHONE_NUMBER_KEY);
        desiresBrailleSticker = checkRandomString(DESIRES_BRAILLE_STICKER_KEY);
        processingCentre = checkRandomString(PROCESSING_CENTRE_KEY);
        desiredDeliveryType = checkRandomString(DESIRED_DELIVERY_TYPE_KEY);
        desiresEmailUpdates = checkRandomString(DESIRES_EMAIL_UPDATES_KEY);
        desiresTextUpdates = checkRandomString(DESIRES_TEXT_UPDATES_KEY);
        whatNationalityOnPassport = checkRandomString(NATIONALITY_ON_PASSPORT);
        issuingAuthority = checkRandomString(ISSUING_AUTHORITY_KEY);
        canSignNewPassport = checkRandomBoolean(CAN_SIGN_NEW_PASSPORT_KEY);
        isPremium = checkRandomBoolean(PREMIUM_KEY);
        isCompassionate = checkRandomBoolean(COMPASSIONATE_KEY);
        isPOL = checkRandomBoolean(POL_KEY);
        hasNameChange = checkRandomBoolean(NAME_CHANGE_KEY);
        isLostOrStolen = checkRandomBoolean(LOST_OR_STOLEN_KEY);
        hasCancelledPassport = checkRandomString(HAS_CANCELLED_PASSPORT);
        isFirstTimeApplication = checkRandomBoolean(FIRST_TIME_APPLICANT_KEY);
        hasNaturalisationCertificate = checkRandomBoolean(HAS_NATURALISATION_CERTIFICATE_KEY);
        parentOneFirstName = checkRandomString(PARENT_ONE_FIRST_NAME_KEY);
        parentOneLastName = checkRandomString(PARENT_ONE_LAST_NAME_KEY);
        parentTwoFirstName = checkRandomString(PARENT_TWO_FIRST_NAME_KEY);
        parentTwoLastName = checkRandomString(PARENT_TWO_LAST_NAME_KEY);
        parentOneBirthDate = checkRandomString(PARENT_ONE_BIRTH_DATE_KEY);
        DataStore.setDataKey(PARENT_ONE_BIRTH_DATE_KEY, parentOneBirthDate);
        parentTwoBirthDate = checkRandomString(PARENT_TWO_BIRTH_DATE_KEY);
        DataStore.setDataKey(PARENT_TWO_BIRTH_DATE_KEY, parentTwoBirthDate);
        parentsMarried = checkRandomString(PARENTS_MARRIED_STATUS_KEY);
        parentOneHasAUKPassport = checkRandomString(PARENT_ONE_UK_PASSPORT_KEY);
        parentTwoHasAUKPassport = checkRandomString(PARENT_TWO_UK_PASSPORT_KEY);
        parentsNationality = checkRandomString(PARENTS_NATIONALITY_KEY);
        parentOneCountryOfBirthCode = checkRandomString(PARENT_ONE_COUNTRY_CODE_OF_BIRTH_KEY);
        parentTwoCountryOfBirthCode = checkRandomString(PARENT_TWO_COUNTRY_CODE_OF_BIRTH_KEY);
        parentsMarriageDate = checkRandomString(PARENTS_MARRIAGE_DATE_KEY);
        parentOnePassportIssueDateDay = checkRandomString(PARENT_ONE_PASSPORT_ISSUE_DATE_DAY);
        parentOnePassportIssueDateMonth = checkRandomString(PARENT_ONE_PASSPORT_ISSUE_DATE_MONTH);
        parentOnePassportIssueDateYear = checkRandomString(PARENT_ONE_PASSPORT_ISSUE_DATE_YEAR);
        parentTwoPassportIssueDateDay = checkRandomString(PARENT_TWO_PASSPORT_ISSUE_DATE_DAY);
        parentTwoPassportIssueDateMonth = checkRandomString(PARENT_TWO_PASSPORT_ISSUE_DATE_MONTH);
        parentTwoPassportIssueDateYear = checkRandomString(PARENT_TWO_PASSPORT_ISSUE_DATE_YEAR);
        parentOneTownOfBirth = checkRandomString(PARENT_ONE_TOWN_OF_BIRTH);
        parentTwoTownOfBirth = checkRandomString(PARENT_TWO_TOWN_OF_BIRTH);
        whoIsThisPassportFor = checkRandomString(WHO_IS_THIS_PASSPORT_FOR);
        whatRelationToApplicant = checkRandomString(WHAT_RELATION_TO_APPLICANT);
        thirdPartyFirstName = checkRandomString(THIRD_PARTY_FIRST_NAME);
        thirdPartyLastName = checkRandomString(THIRD_PARTY_LAST_NAME);
        parentHasDocsToSend = checkRandomString(PARENT_HAS_DOCS_TO_SEND);
        EUSSStatus = checkRandomString(EUSS_STATUS_KEY);
        parentOnesParentOneFirstName = checkRandomString(PARENT_ONES_PARENT_ONE_FIRST_NAME_KEY);
        parentOnesParentOneLastName = checkRandomString(PARENT_ONES_PARENT_ONE_LAST_NAME_KEY);
        parentOnesParentTwoFirstName = checkRandomString(PARENT_ONES_PARENT_TWO_FIRST_NAME_KEY);
        parentOnesParentTwoLastName = checkRandomString(PARENT_ONES_PARENT_TWO_LAST_NAME_KEY);
        parentOnesParentOneTownOfBirth = checkRandomString(PARENT_ONES_PARENT_ONE_TOWN_OF_BIRTH_KEY);
        parentOnesParentTwoTownOfBirth = checkRandomString(PARENT_ONES_PARENT_TWO_TOWN_OF_BIRTH_KEY);
        maternalGrandmotherCountryOfBirthCode = checkRandomString(PARENT_ONES_PARENT_ONE_COUNTRY_CODE_OF_BIRTH_KEY);
        maternalGrandfatherCountryOfBirthCode = checkRandomString(PARENT_ONES_PARENT_TWO_COUNTRY_CODE_OF_BIRTH_KEY);
        paternalGrandmotherCountryOfBirthCode = checkRandomString(PARENT_TWOS_PARENT_ONE_COUNTRY_CODE_OF_BIRTH_KEY);
        paternalGrandfatherCountryOfBirthCode = checkRandomString(PARENT_TWOS_PARENT_TWO_COUNTRY_CODE_OF_BIRTH_KEY);
        parentOnesParentOneBirthDate = checkRandomString(PARENT_ONES_PARENT_ONE_BIRTH_DATE_KEY);
        DataStore.setDataKey(PARENT_ONES_PARENT_ONE_BIRTH_DATE_KEY, parentOnesParentOneBirthDate);
        parentOnesParentTwoBirthDate = checkRandomString(PARENT_ONES_PARENT_TWO_BIRTH_DATE_KEY);
        DataStore.setDataKey(PARENT_ONES_PARENT_TWO_BIRTH_DATE_KEY, parentOnesParentTwoBirthDate);
        parentOnesParentsMarriageDate = checkRandomString(PARENT_ONES_PARENTS_MARRIAGE_DATE_KEY);
        parentTwosParentsMarriageDate = checkRandomString(PARENT_TWOS_PARENTS_MARRIAGE_DATE_KEY);
        parentOnesParentsMarried = checkRandomString(PARENT_ONES_PARENTS_MARRIED_STATUS_KEY);
        parentTwosParentOneFirstName = checkRandomString(PARENT_TWOS_PARENT_ONE_FIRST_NAME_KEY);
        parentTwosParentOneLastName = checkRandomString(PARENT_TWOS_PARENT_ONE_LAST_NAME_KEY);
        parentTwosParentTwoFirstName = checkRandomString(PARENT_TWOS_PARENT_TWO_FIRST_NAME_KEY);
        parentTwosParentTwoLastName = checkRandomString(PARENT_TWOS_PARENT_TWO_LAST_NAME_KEY);
        parentTwosParentOneTownOfBirth = checkRandomString(PARENT_TWOS_PARENT_ONE_TOWN_OF_BIRTH_KEY);
        parentTwosParentTwoTownOfBirth = checkRandomString(PARENT_TWOS_PARENT_TWO_TOWN_OF_BIRTH_KEY);
        parentTwosParentOneBirthDate = checkRandomString(PARENT_TWOS_PARENT_ONE_BIRTH_DATE_KEY);
        parentTwosParentTwoBirthDate = checkRandomString(PARENT_TWOS_PARENT_TWO_BIRTH_DATE_KEY);
        parentTwosParentsMarried = checkRandomString(PARENT_TWOS_PARENTS_MARRIED_STATUS_KEY);
        existingPassportIssueDate = checkRandomString(EXISTING_PASSPORT_ISSUE_DATE_KEY);
        existingPassportExpiryDate = checkRandomString(EXISTING_PASSPORT_EXPIRY_DATE_KEY);
        applicationLanguage = checkRandomString(APPLICATION_LANGUAGE);
        photoName = checkRandomString(PHOTO_NAME);
        existingPassportNumber = checkRandomString(EXISTING_PASSPORT_NUMBER_KEY);
        parentOnePassportNumber = checkRandomString(PARENT_ONE_PASSPORT_NUMBER_KEY);
        parentTwoPassportNumber = checkRandomString(PARENT_TWO_PASSPORT_NUMBER_KEY);
        certificateNumber = checkRandomString(CERTIFICATE_NUMBER_KEY);
        naturalisationDate = checkRandomString(NATURALISATION_DATE_KEY);
    }

    @Override
    protected String checkRandomString(String key) throws Exception {
        String value = getString(key);

        if (ADULT.equalsIgnoreCase(value)) {
            String adultDateOfBirth = DateHelpers.getRandomDateOfBirth(DateHelpers.minAdultYearOfBirth(), DateHelpers.maxAdultYearOfBirth());
            log.info(DOB_LOG_STRING, adultDateOfBirth);

            return adultDateOfBirth;

        } else if (ADULT_PRE_94_DOB.equalsIgnoreCase(value)) {
            String bornBefore1994DateOfBirth = DateHelpers.getRandomDateOfBirth(LocalDate.now().getYear() - 1993, DateHelpers.maxAdultYearOfBirth());
            log.info(DOB_LOG_STRING, bornBefore1994DateOfBirth);

            return bornBefore1994DateOfBirth;

        } else if (DAP_DOB.equalsIgnoreCase(value)) {
            String dapAdultDateOfBirth = DateHelpers.getRandomDateOfBirth(26, DateHelpers.maxAdultYearOfBirth());
            log.info(DOB_LOG_STRING, dapAdultDateOfBirth);

            return dapAdultDateOfBirth;

        } else if (TWELVE_TO_FIFTEEN.equalsIgnoreCase(value)) {
            String twelveToFifteenDateOfBirth = DateHelpers.getRandomDateOfBirth(12, 15);
            log.info(DOB_LOG_STRING, twelveToFifteenDateOfBirth);

            return twelveToFifteenDateOfBirth;

        } else if (TWELVE_TO_FOURTEEN.equalsIgnoreCase(value)) {
            String twelveToFourteenDateOfBirth = DateHelpers.getRandomDateOfBirth(12, 14);
            log.info(DOB_LOG_STRING, twelveToFourteenDateOfBirth);

            return twelveToFourteenDateOfBirth;

        } else if (VETERAN.equalsIgnoreCase(value)) {
            String veteranDateOfBirth = DateHelpers.getVeteranDateOfBirth();
            log.info(DOB_LOG_STRING, veteranDateOfBirth);

            return veteranDateOfBirth;

        } else if (CHILD.equalsIgnoreCase(value)) {
            String childDateOfBirth = DateHelpers.getRandomDateOfBirth(0, 15);
            log.info(DOB_LOG_STRING, childDateOfBirth);

            return childDateOfBirth;

        } else if (CHILD_UNDER_1.equalsIgnoreCase(value)) {
            String childDateOfBirth = DateHelpers.getRisingAgeDateOfBirth(1);
            log.info(DOB_LOG_STRING, childDateOfBirth);

            return childDateOfBirth;

        } else if (CHILD_UNDER_6.equalsIgnoreCase(value)) {
            String childDateOfBirth = DateHelpers.getRisingAgeDateOfBirth(6);
            log.info(DOB_LOG_STRING, childDateOfBirth);

            return childDateOfBirth;

        } else if (CHILD_UNDER_12.equalsIgnoreCase(value)) {
            String childDateOfBirth = DateHelpers.getRisingAgeDateOfBirth(12);
            log.info(DOB_LOG_STRING, childDateOfBirth);

            return childDateOfBirth;

        } else if (RISING_16.equalsIgnoreCase(value)) {
            String rising16DOB = DateHelpers.getRisingAgeDateOfBirth(16);
            log.info(DOB_LOG_STRING, rising16DOB);

            return rising16DOB;
        } else if (FIFTEEN_YEARS_EIGHT_MONTHS.equalsIgnoreCase(value)) {
            String fifteenYearsEightMonthsDOB = DateHelpers.getFifteenYearsEightAgeDateOfBirth(16);
            log.info(DOB_LOG_STRING, fifteenYearsEightMonthsDOB);

            return fifteenYearsEightMonthsDOB;
        }

        if (RANDOM.equalsIgnoreCase(value)) {
            switch (key) {
                case FIRST_NAMES_KEY:
                case SURNAME_KEY:
                case PARENT_ONE_FIRST_NAME_KEY:
                case PARENT_ONE_LAST_NAME_KEY:
                case PARENT_TWO_FIRST_NAME_KEY:
                case PARENT_TWO_LAST_NAME_KEY:
                case PARENT_ONES_PARENT_ONE_FIRST_NAME_KEY:
                case PARENT_ONES_PARENT_ONE_LAST_NAME_KEY:
                case PARENT_ONES_PARENT_TWO_FIRST_NAME_KEY:
                case PARENT_ONES_PARENT_TWO_LAST_NAME_KEY:
                case PARENT_TWOS_PARENT_ONE_FIRST_NAME_KEY:
                case PARENT_TWOS_PARENT_ONE_LAST_NAME_KEY:
                case PARENT_TWOS_PARENT_TWO_FIRST_NAME_KEY:
                case PARENT_TWOS_PARENT_TWO_LAST_NAME_KEY:
                    return getRandomString(20);
                case COUNTRY_CODE_OF_APPLICATION_KEY:
                    if (!isNullOrEmpty(DataStore.getDataKey(DataStore.IS_DAP_APPLICATION))) {
                        return getRandomDAPThreatLevelCountryCodeForCountryOfApplication();
                    } else {
                        return getRandomStandardOverseasCountryCodeForCountryOfApplication();
                    }
                case COUNTRY_OF_BIRTH_CODE_KEY:
                    if (!isNullOrEmpty(DataStore.getDataKey(DataStore.IS_DAP_APPLICATION))) {
                        if (DataStore.getDataKey(DataStore.APPLICANT_COUNTRY_CODE).equalsIgnoreCase("GB")) {
                            return getRandomStandardOverseasCountryCode();
                        } else {
                            return getRandomDAPThreatLevelCountry();
                        }
                    } else {
                        return getRandomStandardOverseasCountryCode();
                    }
                case PARENT_ONE_COUNTRY_CODE_OF_BIRTH_KEY:
                case PARENT_TWO_COUNTRY_CODE_OF_BIRTH_KEY:
                case PARENT_ONES_PARENT_ONE_COUNTRY_CODE_OF_BIRTH_KEY:
                case PARENT_ONES_PARENT_TWO_COUNTRY_CODE_OF_BIRTH_KEY:
                case PARENT_TWOS_PARENT_ONE_COUNTRY_CODE_OF_BIRTH_KEY:
                case PARENT_TWOS_PARENT_TWO_COUNTRY_CODE_OF_BIRTH_KEY:

                    return getRandomStandardOverseasCountryCode();
                case ADDRESS_POSTCODE_KEY:
                    if (isOverseasNonStandardCountryFlag == null && isOverseasType7CountryFlag == null) {
                        return getOverseasAddressPostcode();
                    }
                    break;
                case HOUSE_PHONE_NUMBER_KEY:
                    if (isOverseasNonStandardCountryFlag == null && isOverseasType7CountryFlag == null) {
                        if (isOverseas()) {
                            return getOverseasHousePhoneNumber();
                        } else {
                            return StepDefinitionAssertionConstants.UK_HOME_PHONE_NUMBER;
                        }
                    }
                    break;
                case MOBILE_PHONE_NUMBER_KEY:
                    if (isOverseasNonStandardCountryFlag == null && isOverseasType7CountryFlag == null) {
                        if (isOverseas()) {
                            return getOverseasMobilePhoneNumber();
                        } else {
                            return StepDefinitionAssertionConstants.UK_MOBILE_PHONE_NUMBER;
                        }
                    }
                    break;
                case EMAIL_KEY:
                    return getRandomEmailAddress();
                case PASSPORT_DAMAGED_KEY:
                    return getRandomDamagedStatus();
                case EXISTING_PASSPORT_ISSUE_DATE_KEY:
                    LocalDate dob = LocalDate.parse(DataStore.getDataKey(DataStore.APPLICANT_DATE_OF_BIRTH));
                    String issueDate = DateHelpers.getIssueDateInPast(getApplicationType(), dob).format(DATE_FORMATTER);
                    log.info("Applicant existing passport issue date: [{}]", issueDate);
                    return issueDate;
                case NATURALISATION_DATE_KEY:
                    return getRandomNaturalisationDate();
                case EXISTING_PASSPORT_EXPIRY_DATE_KEY:
                    String expiryDate = DateHelpers.getExpiryDateFromIssueDateAndType(getExistingPassportIssueDate(), getPreviousPassportType()).format(DATE_FORMATTER);
                    log.info("Applicant existing passport expiry date: [{}]", expiryDate);
                    return expiryDate;
                case ISSUING_AUTHORITY_KEY:
                    return getRandomIssuingAuthority();
                case DESIRED_PASSPORT_SIZE_KEY:
                    return getRandomPassportSize();
                case WHO_IS_THIS_PASSPORT_FOR:
                    return getRandomMeOrSomeoneElse();
                case WHAT_RELATION_TO_APPLICANT:
                    return getRandomRelationToApplicant();
                case NATIONALITY_ON_PASSPORT:
                    return getRandomNationalityOnPassport();
                case PARENT_HAS_DOCS_TO_SEND:
                    return getRandomParentDocsToSendDecision();
                case APPLICATION_LANGUAGE:
                    return setRandomApplicationLanguage();
                case PHOTO_NAME:
                    return chooseRandomPhoto();
                case DESIRES_BRAILLE_STICKER_KEY:
                    return getRandomBrailleOption();
                case GENDER_KEY:
                    return randomGender();
                case CERTIFICATE_NUMBER_KEY:
                    return generateRandomNaturalisationCertificateNumber();
                case DESIRED_DELIVERY_TYPE_KEY:
                    return randomDeliveryType();
                case PROCESSING_CENTRE_KEY:
                    return getRandomProcessingCentre();
                case EXISTING_PASSPORT_NUMBER_KEY:
                case PARENT_ONE_PASSPORT_NUMBER_KEY:
                case PARENT_TWO_PASSPORT_NUMBER_KEY:
                    return generateUniquePassportNumber(key);
                case DESIRES_EMAIL_UPDATES_KEY:
                    return getRandomEmailUpdates();
                case DESIRES_TEXT_UPDATES_KEY:
                    return getRandomTextUpdates();
                case TITLE_KEY:
                    return getRandomTitle();
                case NAME_CHANGE_REASON_KEY:
                    return getRandomNameChangeReason();
                case PARENTS_MARRIED_STATUS_KEY:
                case PARENT_ONES_PARENTS_MARRIED_STATUS_KEY:
                case PARENT_TWOS_PARENTS_MARRIED_STATUS_KEY:
                case PARENT_ONE_UK_PASSPORT_KEY:
                case PARENT_TWO_UK_PASSPORT_KEY:
                    return getRandomHasPassportOrMarriedStatus();
                default:
                    throw new IllegalArgumentException("No randomising behaviour defined for key: " + key);
            }
        }

        if (DOB_KEY.equals(key) && nonNull(value) && value.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            DataStore.setDataKey(DataStore.APPLICANT_DATE_OF_BIRTH, value);
            log.info(DOB_LOG_STRING, value);
            return value;
        }

        if (WITHIN_ONE_YEAR.equalsIgnoreCase(value)) {
            naturalisationDate = DateHelpers.getRandomDateInPast("364");

            return naturalisationDate;
        }

        if (MISTYPED_EMAIL.equalsIgnoreCase(value)) {
            //TODO: In future add randomisation so any applicant can have a valid OR mistyped email address
            DataStore.setDataKey(EMAIL_KEY, StepDefinitionAssertionConstants.MISTYPED_EMAIL_ADDRESS);

            return StepDefinitionAssertionConstants.MISTYPED_EMAIL_ADDRESS;
        }

        if (NON_STANDARD.equalsIgnoreCase(value)) {
            isOverseasNonStandardCountryFlag = true;

            return getRandomNonStandardOverseasCountryCode();
        }

        if (TYPE_7.equalsIgnoreCase(value)) {
            isOverseasType7CountryFlag = true;

            return getRandomType7CountryCode();
        }

        if (ISSUE_YEAR_PRE_04.equalsIgnoreCase(value)) {
            LocalDate dateOfBirth = LocalDate.parse(DataStore.getDataKey(DataStore.APPLICANT_DATE_OF_BIRTH)).plusDays(1);
            LocalDate maxDate = LocalDate.parse("2003-12-31");
            long issueDateRangeInDays = (ChronoUnit.DAYS.between(dateOfBirth, maxDate));

            return DateHelpers.getRandomDateInPast(String.valueOf(issueDateRangeInDays));
        }

        if (ISSUE_YEAR_PRE_94.equalsIgnoreCase(value)) {
            LocalDate dateOfBirth = LocalDate.parse(DataStore.getDataKey(DataStore.APPLICANT_DATE_OF_BIRTH)).plusDays(1);
            LocalDate maxDate = LocalDate.parse("1993-12-31");
            long issueDateRangeInDays = (ChronoUnit.DAYS.between(dateOfBirth, maxDate));

            return DateHelpers.getRandomDateInPast(String.valueOf(issueDateRangeInDays));
        }

        //TODO: Add condition for UK PRE 94 issue date treated as Renewal with cSig required
        if (ISSUE_YEAR_94_02.equalsIgnoreCase(value)) {
            return DateHelpers.getRandomDateInPast("94_02");
        } else if (ISSUE_YEAR_94_97.equalsIgnoreCase(value)) {
            return DateHelpers.getRandomDateInPast("94_97");
        } else if (ISSUE_YEAR_94_04.equalsIgnoreCase(value)) {
            return DateHelpers.getRandomDateInPast("94_04");
        }

        if (OLD_BLUE_PASSPORT.equalsIgnoreCase(value)) {

            return generateRandomOldBluePassportNumber();
        }

        return value;
    }

    private String getRandomTitle() {
        String desiredTitleType;

        if (isChild()) {
            String[] titleOptions = {
                    OTHER_OPTION,
                    "Master",
                    "Miss"
            };

            desiredTitleType = titleOptions[RANDOM_GENERATOR.nextInt(titleOptions.length)];
            log.info("Child Applicant Title Type: [{}]", desiredTitleType);
        } else {
            String[] titleOptions = {
                    "Mr",
                    "Mrs",
                    "Miss",
                    "Ms",
                    OTHER_OPTION
            };

            desiredTitleType = titleOptions[RANDOM_GENERATOR.nextInt(titleOptions.length)];
            log.info("Adult Applicant Title Type: [{}]", desiredTitleType);
        }

        return desiredTitleType;
    }

    public String getTitle() {
        return title;
    }

    public String getGender() {
        return gender;
    }

    public String getApplicationType() {
        return isChild() ? "CHILD" : "ADULT";
    }

    private String getPreviousPassportType() {
        return isChildOnDate(getExistingPassportIssueDate()) ? "CHILD" : "ADULT";
    }

    private String getRandomNameChangeReason() {
        String desiredReasonType;

        String[] reasonOptions = {
                "Marriage",
                "Divorced",
                "GenderReassignment",
                "Other"
        };

        desiredReasonType = reasonOptions[RANDOM_GENERATOR.nextInt(reasonOptions.length)];
        log.info("Applicant Name Change Reason Type: [{}]", desiredReasonType);

        return desiredReasonType;

    }

    public List<String> checkRandomList(String key) {
        List<String> previousNames = new ArrayList<>(previousNameCount);

        for (int i = 0; i < previousNameCount; i++) {
            previousNames.add(getRandomString(20));
        }
        String value = getString(key);

        if (RANDOM.equalsIgnoreCase(value)) {
            switch (key) {
                case PREVIOUS_FIRST_NAMES_KEY:
                case PREVIOUS_SURNAMES_KEY:
                    return previousNames;
            }
        }
        return Collections.emptyList();
    }

    public String getFirstNames() {
        return firstNames;
    }

    public List<String> getPreviousFirstNames() {
        return previousFirstNames;
    }

    public List<String> getPreviousSurnames() {
        return previousSurnames;
    }

    public String getNameChangeReason() {
        return nameChangeReason;
    }

    public Boolean hasChangedTheirName() {
        if (!DataStore.hasKey(DataStore.HAS_CHANGED_NAME_BEFORE_EDIT)) {
            if (nonNull(hasNameChange) && !hasNameChange.equals(false)) {
                DataStore.setDataKey(DataStore.HAS_CHANGED_NAME_BEFORE_EDIT, "yes");
            } else {
                DataStore.setDataKey(DataStore.HAS_CHANGED_NAME_BEFORE_EDIT, "no");
            }
        }
        return nonNull(hasNameChange) && !hasNameChange.equals(false);
    }

    public Boolean hasPreviousNames() {
        return hasPreviousNames;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTownOfBirth() {
        return townOfBirth;
    }

    public String getCountryOfBirthCode() {
        return countryOfBirthCode;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public String getNaturalisationDate() {
        return naturalisationDate;
    }

    public LocalDate getExistingPassportIssueDate() {
        return isNullOrEmpty(existingPassportIssueDate) ? null : LocalDate.parse(existingPassportIssueDate);
    }

    public LocalDate getExistingPassportExpiryDate() {
        return isNullOrEmpty(existingPassportExpiryDate) ? null : LocalDate.parse(existingPassportExpiryDate);
    }

    public String getCountryCodeOfApplication() {
        return countryCodeOfApplication;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getAddressTown() {
        return addressTown;
    }

    public String getAddressStateProvince() {
        return addressStateProvince;
    }

    public String getEmail() {
        return email;
    }

    public String getHousePhoneNumber() {
        return housePhoneNumber;
    }

    public String getMobilePhoneNumber() {
        //TODO: Enable once POL mobile number issue PEXDDPS-2515 is fixed.
        //if(isAPOLApplication() && !getDesiresTextUpdates())
        //return null;
        //else {
        return mobilePhoneNumber;
        //}
    }

    public String getExistingPassportNumber() {
        return existingPassportNumber;
    }

    public boolean desiresExtraLargePassport() {
        return !Boolean.parseBoolean(DataStore.getDataKey(DESIRED_PASSPORT_SIZE_KEY));
    }

    public boolean desiresBrailleSticker() {
        return Boolean.parseBoolean(DataStore.getDataKey(DESIRES_BRAILLE_STICKER_KEY));
    }

    public boolean getDesiresTextUpdates() {
        return Boolean.parseBoolean(DataStore.getDataKey(DESIRES_TEXT_UPDATES_KEY));
    }

    public boolean getDesiresEmailUpdates() {
        return Boolean.parseBoolean(DataStore.getDataKey(DESIRES_EMAIL_UPDATES_KEY));
    }

    public String getDesiredDeliveryType() {
        return desiredDeliveryType;
    }

    private String getRandomEmailUpdates() {
        desiresEmailUpdates = YES_NO_OPTIONS[RANDOM_GENERATOR.nextInt(YES_NO_OPTIONS.length)];
        log.info("APPLICANT DESIRES EMAIL UPDATES: [{}]", desiresEmailUpdates);
        return desiresEmailUpdates;
    }

    private String getRandomTextUpdates() {
        desiresTextUpdates = YES_NO_OPTIONS[RANDOM_GENERATOR.nextInt(YES_NO_OPTIONS.length)];
        log.info("APPLICANT DESIRES TEXT UPDATES: [{}]", desiresTextUpdates);
        return desiresTextUpdates;
    }

    public boolean canSignNewPassport() {
        if (isNull(canSignNewPassport)) {
            return randomCanSignPassportOption();
        } else {
            return canSignNewPassport;
        }
    }

    private Boolean randomCanSignPassportOption() {
        boolean canSignPassport = RANDOM_GENERATOR.nextBoolean();
        log.info("Applicant Can Sign Passport: [{}]", canSignPassport);
        canSignNewPassport = canSignPassport;

        return canSignNewPassport;
    }

    public String getParentHasDocsToSend() {
        return parentHasDocsToSend;
    }

    public String getEUSSStatus() {
        return EUSSStatus;
    }

    public boolean isAnOverseasType7Country() {
        return requireNonNullElse(isOverseasType7CountryFlag, false);
    }

    public boolean isChild() {
        return isLessThanYearsOld(16) && !isRising16();
    }

    public boolean isChildOnDate(LocalDate onDate) {
        return isLessThanYearsOldOnDate(16, onDate) && !isRising16OnDate(onDate);
    }

    public boolean isAdult() throws ParseException {
        return !isChild() && !isVeteran();
    }

    public boolean isVeteran() throws ParseException {
        Date applicantDateOfBirth = dateFormat.parse(DataStore.getDataKey(DataStore.APPLICANT_DATE_OF_BIRTH));
        Date veteranDateCutoff = dateFormat.parse("1929-09-03");

        return applicantDateOfBirth.before(veteranDateCutoff);
    }

    public boolean isTwelveToFifteen() throws ParseException {
        Date applicantDateOfBirth = dateFormat.parse(DataStore.getDataKey(DataStore.APPLICANT_DATE_OF_BIRTH));
        Date twelveYearOldDateOfBirth = dateFormat.parse(String.valueOf(DateTime.now().minusYears(12)));
        Date fifteenYearOldDateOfBirth = dateFormat.parse(String.valueOf(DateTime.now().minusYears(15)));

        return twelveYearOldDateOfBirth.compareTo(applicantDateOfBirth) * applicantDateOfBirth.compareTo(fifteenYearOldDateOfBirth) >= 0;
    }

    public boolean isRising16OnDate(LocalDate onDate) {
        LocalDate applicantDateOfBirth = LocalDate.parse(DataStore.getDataKey(DataStore.APPLICANT_DATE_OF_BIRTH));
        LocalDate startDateToBeARisingSixteen = onDate.minusYears(16).plusDays(1);
        LocalDate endDateToBeARisingSixteen = onDate.minusYears(16).plusDays(21);

        return (applicantDateOfBirth.isAfter(startDateToBeARisingSixteen) || applicantDateOfBirth.isEqual(startDateToBeARisingSixteen)) &&
                (applicantDateOfBirth.isBefore(endDateToBeARisingSixteen) || applicantDateOfBirth.isEqual(endDateToBeARisingSixteen));
    }

    public boolean isRising16() {
        return isRising16OnDate(LocalDate.now());
    }

    public boolean isFifteenEight() throws ParseException {
        Date applicantDateOfBirth = dateFormat.parse(DataStore.getDataKey(DataStore.APPLICANT_DATE_OF_BIRTH));
        Date startDateToBeAFifteenEight = dateFormat.parse(String.valueOf(DateTime.now().minusYears(16).plusMonths(4)));
        Date endDateToBeAFifteenEight = dateFormat.parse(String.valueOf(DateTime.now().minusYears(16).plusDays(21)));

        return startDateToBeAFifteenEight.compareTo(applicantDateOfBirth) * applicantDateOfBirth.compareTo(endDateToBeAFifteenEight) >= 0;
    }

    public boolean isInEUSSAgeRange() throws ParseException {
        Date applicantDateOfBirth = dateFormat.parse(getDateOfBirth());
        Date minEUSSDateOfBirth = dateFormat.parse("2018-08-27");

        return applicantDateOfBirth.compareTo(minEUSSDateOfBirth) > 0;
    }

    public String getParentOneBirthYear() {
        if (isNullOrEmpty(parentOneBirthDate)) {
            return "";
        } else {
            LocalDate dateOfBirth = LocalDate.parse(parentOneBirthDate);
            return String.valueOf(dateOfBirth.getYear());
        }
    }

    public String getParentTwoBirthYear() {
        if (isNullOrEmpty(parentTwoBirthDate)) {
            return "";
        } else {
            LocalDate dateOfBirth = LocalDate.parse(parentTwoBirthDate);
            return String.valueOf(dateOfBirth.getYear());
        }
    }

    public Boolean isOverseas() {
        return isOverseas;
    }

    public Boolean isADualNational() {
        return false;
    }

    public Boolean isABritishNationalOverseasRequiringAReferee() {
        return !isNullOrEmpty(DataStore.getDataKey(DataStore.WHAT_NATIONALITY_ON_PASSPORT))
                && StepDefinitionAssertionConstants.BRITISH_NATIONAL_OVERSEAS.equals(DataStore.getDataKey(DataStore.WHAT_NATIONALITY_ON_PASSPORT))
                && getExistingPassportIssueDate().getYear() < 2004;
    }

    public Boolean isABritishNationalOverseas() {
        return !isNullOrEmpty(DataStore.getDataKey(DataStore.WHAT_NATIONALITY_ON_PASSPORT))
                && StepDefinitionAssertionConstants.BRITISH_NATIONAL_OVERSEAS.equals(DataStore.getDataKey(DataStore.WHAT_NATIONALITY_ON_PASSPORT));
    }

    public Boolean isPremium() {
        return isPremium;
    }

    public Boolean isCompassionate() {
        if (isNull(isCompassionate)) {
            isCompassionate = false;
        }
        return isCompassionate;
    }

    public Boolean isAHiddenFirstTimeApplicant() {
        if (isNull(getExistingPassportIssueDate())) {
            return false;
        }

        int issueYear = getExistingPassportIssueDate().getYear();

        if (!isFirstTimeApplication() && !isOverseas() && issueYear < 1994) {
            return true;
        } else if (!isFirstTimeApplication() && isOverseas() && !isABritishNationalOverseasRequiringAReferee() && !hasOtherIssuingAuthority() && issueYear < 1994) {
            return true;
        } else {
            return !isFirstTimeApplication() && isOverseas() && !isABritishNationalOverseasRequiringAReferee() && hasOtherIssuingAuthority() && issueYear < 2004;
        }
    }

    public Boolean hasSpecialIssueDate() {
        if (isNull(getExistingPassportIssueDate())) {
            return false;
        }

        int issueYear = getExistingPassportIssueDate().getYear();

        if (!isOverseas() && (issueYear >= 1994 && issueYear <= 2002)) {
            return true;
        } else if (isOverseas() && !hasOtherIssuingAuthority() && (issueYear >= 1994 && issueYear <= 1997)) {
            return true;
        } else {
            return isOverseas() && hasOtherIssuingAuthority() && (issueYear >= 1994 && issueYear <= 2004);
        }
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public Boolean hasOtherIssuingAuthority() {
        return StepDefinitionAssertionConstants.OTHER.equalsIgnoreCase(getIssuingAuthority());
    }

    public Boolean hasLostOrStolenPassport() {
        return isLostOrStolen;
    }

    public Boolean hasCancelledPassport() {
        return !isNullOrEmpty(hasCancelledPassport) && "Yes".equalsIgnoreCase(hasCancelledPassport);
    }

    public Boolean isFirstTimeApplication() {
        return isFirstTimeApplication;
    }

    public Boolean hasNaturalisationCertificate() {
        return hasNaturalisationCertificate;
    }

    public String getWhoIsThisPassportFor() {
        return whoIsThisPassportFor;
    }

    public String getWhatRelationToApplicant() {
        return whatRelationToApplicant;
    }

    private String generateUniquePassportNumber(String whoFor) {
        String passportNumber;
        passportNumber = "123456789";
        if (isNullOrEmpty(DataStore.getDataKey(DataStore.IS_DAP_APPLICATION))) {
            int minimumApplicationReference = 300000001;
            int maximumApplicationReference = 399999999;

            passportNumber = String.valueOf(RANDOM_GENERATOR.nextInt((maximumApplicationReference - minimumApplicationReference) + 1) + minimumApplicationReference);
            log.info("{} PASSPORT NUMBER: {}", whoFor, passportNumber);
        }

        switch (whoFor) {
            case EXISTING_PASSPORT_NUMBER_KEY:
                this.existingPassportNumber = passportNumber;
                break;
            case PARENT_ONE_PASSPORT_NUMBER_KEY:
                this.parentOnePassportNumber = passportNumber;
                break;
            case PARENT_TWO_PASSPORT_NUMBER_KEY:
                this.parentTwoPassportNumber = passportNumber;
                break;
            default:
                break;
        }

        return passportNumber;
    }

    private String getRandomPassportSize() {
        String[] passportSizeOptions = {
                STANDARD_OPTION,
                "Frequent traveller",
        };
        String passportSizeOption = passportSizeOptions[RANDOM_GENERATOR.nextInt(passportSizeOptions.length)];
        DataStore.setDataKey(DESIRED_PASSPORT_SIZE_KEY, passportSizeOption);
        log.info("Applicant Passport Size: {}", passportSizeOption);

        return passportSizeOption;
    }

    private String getRandomDamagedStatus() {
        return YES_NO_OPTIONS[RANDOM_GENERATOR.nextInt(YES_NO_OPTIONS.length)];
    }

    private String getRandomHasPassportOrMarriedStatus() {
        String[] hasPassportOrMarriedOptions = {
                "Yes",
                "No",
                "I don't know",
        };

        return hasPassportOrMarriedOptions[RANDOM_GENERATOR.nextInt(hasPassportOrMarriedOptions.length)];
    }

    private String getRandomMeOrSomeoneElse() {
        String[] whoForOptions = {
                "Me",
                "Someone else",
        };

        return whoForOptions[RANDOM_GENERATOR.nextInt(whoForOptions.length)];
    }

    private String getRandomIssuingAuthority() {
        if (StepDefinitionAssertionConstants.BRITISH_NATIONAL_OVERSEAS.equalsIgnoreCase(whatNationalityOnPassport)) {
            return "UK";
        } else {
            String[] issueAuthorities = {
                    OTHER_OPTION,
                    "UK",
            };

            return issueAuthorities[RANDOM_GENERATOR.nextInt(issueAuthorities.length)];
        }
    }

    private String getRandomParentDocsToSendDecision() {
        return YES_NO_OPTIONS[RANDOM_GENERATOR.nextInt(YES_NO_OPTIONS.length)];
    }

    private String getRandomRelationToApplicant() {
        String[] relationOptions = {
                "Mother",
                "Father",
                OTHER_OPTION
        };

        return relationOptions[RANDOM_GENERATOR.nextInt(relationOptions.length)];
    }

    private String getRandomNationalityOnPassport() {
        String[] nationalityOptions = {
                "British Citizen",
                "British National Overseas",
                OTHER_OPTION
        };

        return nationalityOptions[RANDOM_GENERATOR.nextInt(nationalityOptions.length)];
    }

    public String getParentOneFirstName() {
        return parentOneFirstName;
    }

    public String getParentOneLastName() {
        return parentOneLastName;
    }

    public String getParentTwoFirstName() {
        return parentTwoFirstName;
    }

    public String getParentTwoLastName() {
        return parentTwoLastName;
    }

    public String getParentOneBirthDate() {
        return parentOneBirthDate;
    }

    public String getParentTwoBirthDate() {
        return parentTwoBirthDate;
    }

    public Boolean getParentOnePassportStatus() {
        return Boolean.valueOf(parentOneHasAUKPassport);
    }

    public Boolean getParentTwoPassportStatus() {
        return Boolean.valueOf(parentTwoHasAUKPassport);
    }

    public Boolean getParentsMarriedStatus() {
        return Boolean.valueOf(parentsMarried);
    }

    public Boolean areParentsMarried() {
        return Boolean.valueOf(parentsMarried);
    }

    public Boolean getParentOnesParentsMarriedStatus() {
        return Boolean.valueOf(parentOnesParentsMarried);
    }

    public Boolean getParentTwosParentsMarriedStatus() {
        return Boolean.valueOf(parentTwosParentsMarried);
    }

    public String getParentOneTownOfBirth() {
        return parentOneTownOfBirth;
    }

    public String getParentTwoTownOfBirth() {
        return parentTwoTownOfBirth;
    }

    public String getParentsNationality() {
        return parentsNationality;
    }

    public String getParentOneCountryOfBirthCode() {
        return parentOneCountryOfBirthCode;
    }

    public String getParentTwoCountryOfBirthCode() {
        return parentTwoCountryOfBirthCode;
    }

    public String getParentsMarriageDate() {
        return parentsMarriageDate;
    }

    public String getParentOnePassportNumber() {
        return parentOnePassportNumber;
    }

    public String getParentTwoPassportNumber() {
        return parentTwoPassportNumber;
    }

    public String getParentOnePassportIssueDateDay() {
        return parentOnePassportIssueDateDay;
    }

    public String getParentOnePassportIssueDateMonth() {
        return parentOnePassportIssueDateMonth;
    }

    public String getParentOnePassportIssueDateYear() {
        return parentOnePassportIssueDateYear;
    }

    public String getParentTwoPassportIssueDateDay() {
        return parentTwoPassportIssueDateDay;
    }

    public String getParentTwoPassportIssueDateMonth() {
        return parentTwoPassportIssueDateMonth;
    }

    public String getParentTwoPassportIssueDateYear() {
        return parentTwoPassportIssueDateYear;
    }

    public String getThirdPartyFirstName() {
        return thirdPartyFirstName;
    }

    public String getThirdPartyLastName() {
        return thirdPartyLastName;
    }

    public boolean parentOneHasAUKPassport() {
        return Boolean.parseBoolean(parentOneHasAUKPassport);
    }

    public boolean parentTwoHasAUKPassport() {
        return Boolean.parseBoolean(parentTwoHasAUKPassport);
    }

    public String getParentOnesParentOneFirstName() {
        return parentOnesParentOneFirstName;
    }

    public String getParentOnesParentOneLastName() {
        return parentOnesParentOneLastName;
    }

    public String getParentOnesParentTwoFirstName() {
        return parentOnesParentTwoFirstName;
    }

    public String getParentOnesParentTwoLastName() {
        return parentOnesParentTwoLastName;
    }

    public String getParentOnesParentOneTownOfBirth() {
        return parentOnesParentOneTownOfBirth;
    }

    public String getParentOnesParentTwoTownOfBirth() {
        return parentOnesParentTwoTownOfBirth;
    }

    public String getParentOnesParentOneCountryOfBirthCode() {
        return maternalGrandmotherCountryOfBirthCode;
    }

    public String getParentOnesParentTwoCountryOfBirthCode() {
        return maternalGrandfatherCountryOfBirthCode;
    }

    public String getParentOnesParentOneBirthDate() {
        return parentOnesParentOneBirthDate;
    }

    public String getParentOnesParentsMarriageDate() {
        return parentOnesParentsMarriageDate;
    }
    public String getParentTwosParentsMarriageDate() {
        return parentTwosParentsMarriageDate;
    }
    public String getParentOnesParentTwoBirthDate() {
        return parentOnesParentTwoBirthDate;
    }

    public String getParentTwosParentOneFirstName() {
        return parentTwosParentOneFirstName;
    }

    public String getParentTwosParentOneLastName() {
        return parentTwosParentOneLastName;
    }

    public String getParentTwosParentTwoFirstName() {
        return parentTwosParentTwoFirstName;
    }

    public String getParentTwosParentTwoLastName() {
        return parentTwosParentTwoLastName;
    }

    public String getParentTwosParentOneTownOfBirth() {
        return parentTwosParentOneTownOfBirth;
    }

    public String getParentTwosParentTwoTownOfBirth() {
        return parentTwosParentTwoTownOfBirth;
    }

    public String getParentTwosParentOneCountryOfBirthCode() {
        return paternalGrandmotherCountryOfBirthCode;
    }

    public String getParentTwosParentTwoCountryOfBirthCode() {
        return paternalGrandfatherCountryOfBirthCode;
    }

    public String getParentTwosParentOneBirthDate() {
        return parentTwosParentOneBirthDate;
    }

    public String getParentTwosParentTwoBirthDate() {
        return parentTwosParentTwoBirthDate;
    }

    public boolean isAPOLApplication() {
        return !isNull(isPOL) && isPOL;
    }

    private String setRandomApplicationLanguage() {
        if (isNull(isCompassionate)) {
            isCompassionate = false;
        }
        if (isOverseas || isPremium || isAPOLApplication() || isCompassionate) {
            DataStore.setDataKey(APPLICATION_LANGUAGE, "en");

            applicationLanguage = "en";
        } else {
            String[] languageOptions = {
                    "en",
                    "cy"
            };
            String language = languageOptions[RANDOM_GENERATOR.nextInt(languageOptions.length)];
            DataStore.setDataKey(APPLICATION_LANGUAGE, language);

            applicationLanguage = language;
        }
        return applicationLanguage;
    }

    public String getPhotoType() {
        String photoNameToUse = photoName;

        if (DataStore.hasKey(DataStore.DAP_PHOTO_RESUB) && DataStore.getDataKey(DataStore.DAP_PHOTO_RESUB).equalsIgnoreCase("true")) {
            photoNameToUse = chooseRandomPhoto();
            log.info("getting photo type for photo resub [{}]",photoNameToUse);
        }
        switch (photoNameToUse) {
            //Photo Code Photos
            case "2AtDAiw":
            case "2jdD4hk":
            case "35lyjrG":
                photoType = "Photo Code";

                return photoType;

            case "2kp3DUh":
                photoType = "Photo Code Not Accepted";

                return photoType;

            case "12345678":
                photoType = "Photo Code Invalid";

                return photoType;

            //Photo Upload Photos
            case "passport-example-1-1-2":
            case "passport-example-1-1-3":
            case "passport-example-1-1-4":
            case "passport-example-1-1-7":
            case "passport-example-1-1-9":
            case "passport-example-1-1-10":
            case "passport-example-2-1-1":
            case "9B9A1058":
            case "9B9A0755":
                photoType = "Photo Upload Not Accepted";

                return photoType;

            case "passport-example-1-1-5":
                photoType = "Photo Upload Invalid";

                return photoType;

            default:
                photoType = "Photo Upload";

                return photoType;
        }
    }

    private String chooseRandomPhoto() {
        boolean usePassingPhoto = Math.random() > 0.1;
        if (DataStore.hasKey(DataStore.DAP_PHOTO_RESUB) && DataStore.getDataKey(DataStore.DAP_PHOTO_RESUB).equalsIgnoreCase("true")) {
            usePassingPhoto = false;
            log.info("Select photo for resub");
        }

        if (usePassingPhoto) {
            photoName = "passport-example-1-1";
        } else {
            if (DataStore.hasKey(DataStore.DAP_PHOTO_RESUB)) {
                DataStore.setDataKey(DataStore.DAP_PHOTO_RESUB, "false");
            }
            String[] photoNameOptions = {
                    "passport-example-1-1-5",
                    "passport-example-1-1-8",
                    "passport-example-1-1-9",
                    "passport-example-1-1-10",
                    "passport-example-1-1-3",
                    "passport-example-1-1-4",
                    "passport-example-1-1-7",
                    //TODO: Re-enable this photo once this story is played: https://collaboration.homeoffice.gov.uk/jira/browse/DCSPII-1778
                    //"9B9A1058",
                    "9B9A0755",
                    "passport-example-1-1-2",
                    "passport-example-1-1-6",
                    "passport-example-2-1-1",
                    "9B9A0756",
                    "9B9A1128",
                    "9B9A0886",
                    "9B9A1136",
                    "9B9A1142",
                    "9B9A1155",
                    "9B9A1071",
                    "9B9A0904",
                    "9B9A0745",
                    "passport-example-1-1",
                    "2AtDAiw",
                    "2jdD4hk",
                    "35lyjrG",
                    "2kp3DUh",
                    "12345678"
            };

            photoName = photoNameOptions[RANDOM_GENERATOR.nextInt(photoNameOptions.length)];
            photoType = getPhotoType();

        }
        log.info("Photo name and type [{}] [{}]",photoName, photoType );
        DataStore.setDataKey(DataStore.STORED_PHOTO_NAME, photoName);
        return photoName;
    }

    public String getPhotoName() {
        if (DataStore.hasKey(DataStore.DAP_PHOTO_RESUB) && DataStore.getDataKey(DataStore.DAP_PHOTO_RESUB).equalsIgnoreCase("true")) {
            return chooseRandomPhoto();
        } else {
            DataStore.setDataKey(DataStore.STORED_PHOTO_NAME,photoName);
            return photoName;
        }
    }

    private String getRandomBrailleOption() {
        desiresBrailleSticker = YES_NO_OPTIONS[RANDOM_GENERATOR.nextInt(YES_NO_OPTIONS.length)];
        log.info("APPLICANT DESIRES BRAILLE: {}", desiresBrailleSticker);
        return desiresBrailleSticker;
    }

    private String randomGender() {
        String[] genderOptions = {
                "M",
                "F"
        };

        gender = genderOptions[RANDOM_GENERATOR.nextInt(genderOptions.length)];
        log.info("Applicant Gender: {}", gender);

        return gender;
    }

    private String randomDeliveryType() {
        String[] deliveryOptions = {
                "Secure",
                STANDARD_OPTION
        };

        desiredDeliveryType = deliveryOptions[RANDOM_GENERATOR.nextInt(deliveryOptions.length)];
        log.info("Applicant Delivery Type: {}", desiredDeliveryType);

        return desiredDeliveryType;
    }

    public Boolean isLessThanYearsOldOnDate(int yearsOld, LocalDate onDate) {
        LocalDate applicantDateOfBirth = LocalDate.parse(DataStore.getDataKey(DataStore.APPLICANT_DATE_OF_BIRTH));
        LocalDate expectedDate = onDate.minusYears(yearsOld);

        return applicantDateOfBirth.isAfter(expectedDate);
    }

    public Boolean isLessThanYearsOld(int yearsOld) {
        return isLessThanYearsOldOnDate(yearsOld, LocalDate.now());
    }

    public static Boolean isAValidApplicationForThisStep() {
        return isNullOrEmpty(DataStore.getDataKey(DataStore.APPLICATION_NOT_ALLOWED));
    }

    private String getRandomNaturalisationDate() {
        return String.valueOf(LocalDate.parse(dateOfBirth).plusDays(1));
    }

    private String getRandomProcessingCentre() {
        String[] processingCentreOptions = {
                "Durham",
                "Glasgow",
                "Peterborough"
        };

        processingCentre = processingCentreOptions[RANDOM_GENERATOR.nextInt(processingCentreOptions.length)];
        log.info("Applicant Processing Centre: {}", processingCentre);

        return processingCentre;
    }

    private String getRandomEmailAddress() throws IOException {
        boolean useMistypedEmailAddress = Math.random() > 0.1;
        if (useMistypedEmailAddress) {
            return randomMistypedEmailAddress();
        } else {
            return randomValidEmailAddress();
        }
    }
}
