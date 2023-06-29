package kainos.specs.site.page_objects.or.constants;

/**
 * TODO: Verifying content is maintenance heavy and provides little value.
 * TODO: Verify the content delivery mechanism once then trust it to work in all cases.
 * TODO: If these constants are being used to verify e.g. correct error/message
 * TODO: pages in the product GUI then that can be done by checking which elements
 * TODO: are present on the pages, without coupling tests to specific content which may
 * TODO: frequently change.
 */
public interface StepDefinitionAssertionConstants {

    //DataSourceKeys
    String TITLE_MAX_VALUE = "maximumlength' -,.hh";
    String BRITISH_NATIONAL_OVERSEAS = "British National Overseas";
    String ME = "Me";
    String OTHER = "Other";

    //HardCodedData
    String VALID_UK_POST_CODE = "SW1P 4DF";
    String INVALID_UK_POST_CODE = "ZZZ ZZZ";
    String MISTYPED_EMAIL_ADDRESS = "testpex1234@example.cpm";
    String UK_MOBILE_PHONE_NUMBER = "07506666821";
    String UK_HOME_PHONE_NUMBER = "02079460918";
    String SAR_CANNOT_SIGN_REASON = "SaR a-z A-Z 0-9.,'- & /098123 asdbjASDASDasda-zA-Z0-9. , ' - & /abcdefghijklmnopqrstuvwxyzabcdefghijk\n" +
            "mnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz SaR";
    String CANNOT_PROVIDE_PARENT_ONE_DETAILS = "PaD1 a-z A-Z 0-9.,'- & /098123 asdbjASDASDasda-zA-Z0-9. , ' - &/abcdefghijklmnopqrstuvwxyzabcdefghijk\n" +
            "mnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz Pa1";
    String CANNOT_PROVIDE_PARENT_TWO_DETAILS = "PaD2 a-z A-Z 0-9.,'- & /098123 asdbjASDASDasda-zA-Z0-9. , ' - &/abcdefghijklmnopqrstuvwxyzabcdefghijk\n" +
            "mnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz Pa2";
    String CANNOT_PROVIDE_PATERNAL_GRANDPARENT_ONE_DETAILS = "GaD1 a-z A-Z 0-9.,'- & /098123 asdbjASDASDasda-zA-Z0-9. , ' - &/abcdefghijklmnopqrstuvwxyzabcdefghijk\n" +
            "mnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz Ga1";
    String CANNOT_PROVIDE_PATERNAL_GRANDPARENT_TWO_DETAILS = "GaD2 a-z A-Z 0-9.,'- & /098123 asdbjASDASDasda-zA-Z0-9. , ' - &/abcdefghijklmnopqrstuvwxyzabcdefghijk\n" +
            "mnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz Ga2";
    String CANNOT_PROVIDE_MATERNAL_GRANDPARENT_ONE_DETAILS = "MaD1 a-z A-Z 0-9.,'- & /098123 asdbjASDASDasda-zA-Z0-9. , ' - &/abcdefghijklmnopqrstuvwxyzabcdefghijk\n" +
            "mnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz Ma1";
    String CANNOT_PROVIDE_MATERNAL_GRANDPARENT_TWO_DETAILS = "MaD2 a-z A-Z 0-9.,'- & /098123 asdbjASDASDasda-zA-Z0-9. , ' - &/abcdefghijklmnopqrstuvwxyzabcdefghijk\n" +
            "mnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz Ma2";
    String RELATION_TO_APPLICANT_MAX_VLAUE = "Maximum-',. /maxi";
    String THIRD_PARTY_EXPLANATION = "3rdPartyEx -',.&/ abcdefghijklmnopqrstuvwxyzabcdefghijk\n" +
            "mnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
}
