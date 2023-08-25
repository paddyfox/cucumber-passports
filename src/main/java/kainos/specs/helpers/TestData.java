package kainos.specs.helpers;

import kainos.specs.countrystore.CountryStore;
import kainos.specs.datastore.DataStore;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public abstract class TestData {

    protected static final String RANDOM = "_RANDOM_";
    protected static final String NON_STANDARD = "_NON_STANDARD_";
    protected static final String TYPE_7 = "_TYPE_7_";
    protected static final String DAP_DOB = "_RANDOM_DAP_DOB_";
    protected static final String ADULT = "_ADULT_";
    protected static final String VETERAN = "_VETERAN_";
    protected static final String CHILD = "_CHILD_";
    protected static final String CHILD_UNDER_1 = "_UNDER_1_";
    protected static final String CHILD_UNDER_6 = "_UNDER_6_";
    protected static final String CHILD_UNDER_12 = "_UNDER_12_";
    protected static final String TWELVE_TO_FIFTEEN = "_TWELVE_TO_FIFTEEN_";
    protected static final String TWELVE_TO_FOURTEEN = "_TWELVE_TO_FOURTEEN_";
    protected static final String RISING_16 = "_RISING_16_";
    protected static final String MISTYPED_EMAIL = "_MISTYPED_";
    protected static final String WITHIN_ONE_YEAR = "_WITHIN_ONE_YEAR_";
    protected static final String ISSUE_YEAR_94_02 = "_94_02_";
    protected static final String ISSUE_YEAR_94_97 = "_94_97_";
    protected static final String ISSUE_YEAR_94_04 = "_94_04_";
    protected static final String ISSUE_YEAR_PRE_04 = "_PRE_04_";
    protected static final String ISSUE_YEAR_PRE_94 = "_PRE_94_";
    protected static final String ADULT_PRE_94_DOB = "_PRE_94_DOB_";
    protected static final String OLD_BLUE_PASSPORT = "_OLD_BLUE_";
    protected static final String FIFTEEN_YEARS_EIGHT_MONTHS = "_FIFTEEN_YEARS_EIGHT_MONTHS_";
    protected static final Random RANDOM_GENERATOR = new Random();
    protected static final String DATE_FORMAT_STRING = "yyyy-MM-dd";
    protected static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT_STRING);

    protected JSONObject data;

    protected TestData(String scenarioName, String dataDirectory) throws IOException {
        String pathToData = "./src/test/resources/test_data/" + dataDirectory + "/";
        String scenarioJsonFileName = (scenarioName.replaceAll(" ", "_").toLowerCase() + ".json");
        Path path = Files.walk(Paths.get(pathToData))
                .filter(Files::isRegularFile)
                .filter(it -> it.getFileName().toString().equals(scenarioJsonFileName))
                .findAny()
                .orElseThrow(FileNotFoundException::new);
        this.data = getData(String.valueOf(path));
    }

    public static String getRandomString(int maxNameLength) {
        RandomString randomString = new RandomString(maxNameLength);

        return randomString.nextString();
    }

    /**
     * Read test data from json file and parse it.
     *
     * @param pathToData path to test data directory for this data type
     * @return parsed json object
     * @throws IOException Failure to read or parse JSON file
     */
    private JSONObject getData(String pathToData) throws IOException {
        FileReader reader = new FileReader(pathToData);
        JSONTokener tokener = new JSONTokener(reader);
        JSONObject data = new JSONObject(tokener);
        reader.close();

        return data;
    }

    protected abstract String checkRandomString(String key) throws Exception;

    protected Boolean checkRandomBoolean(String key) {
        return this.data.has(key) ? this.data.getBoolean(key) : null;
    }

    protected String getString(String key) {
        return this.data.has(key) ? this.data.getString(key) : null;
    }

    protected String getRandomStandardOverseasCountryCodeForCountryOfApplication() {
        String randomCountryCode = getRandomStandardOverseasCountryCode();
        DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_CODE, randomCountryCode);

        String randomCountryName = CountryStore.countryHashMap.get(DataStore.getDataKey(DataStore.APPLICANT_COUNTRY_CODE)).get(4);
        DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_APPLICATION, randomCountryName);
        log.info("APPLICANT COUNTRY OF APPLICATION: [{}]", DataStore.getDataKey(DataStore.APPLICANT_COUNTRY_OF_APPLICATION));

        return randomCountryCode;
    }

    protected String getRandomDAPThreatLevelCountryCodeForCountryOfApplication() {
        String randomCountryCode = getRandomDAPThreatLevelCountry();
        DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_CODE, randomCountryCode);

        String randomCountryName = CountryStore.ovsDAPThreatLevelCountryHashMap.get(DataStore.getDataKey(DataStore.APPLICANT_COUNTRY_CODE)).get(0);
        DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_APPLICATION, randomCountryName);
        log.info("APPLICANT COUNTRY OF APPLICATION: [{}]", DataStore.getDataKey(DataStore.APPLICANT_COUNTRY_OF_APPLICATION));

        return randomCountryCode;
    }

    protected String getRandomStandardOverseasCountryCode() {
        List<String> countryList = new ArrayList<>(CountryStore.countryHashMap.keySet());

        int randomIndex = ThreadLocalRandom.current().nextInt(countryList.size());
        return countryList.get(randomIndex);
    }

    protected String getRandomDAPThreatLevelCountry() {
        List<String> countryList = new ArrayList<>(CountryStore.ovsDAPThreatLevelCountryHashMap.keySet());

        int randomIndex = ThreadLocalRandom.current().nextInt(countryList.size());
        return countryList.get(randomIndex);
    }

    protected String getRandomNonStandardOverseasCountryCode() {
        List<String> countryList = new ArrayList<>(CountryStore.ovsPaperChannelCountryHashMap.keySet());

        int randomIndex = ThreadLocalRandom.current().nextInt(countryList.size());
        String randomCountryCode = countryList.get(randomIndex);

        DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_CODE, randomCountryCode);

        String randomCountryName = CountryStore.ovsPaperChannelCountryHashMap.get(DataStore.getDataKey(DataStore.APPLICANT_COUNTRY_CODE));
        DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_APPLICATION, randomCountryName);
        log.info("APPLICANT COUNTRY OF APPLICATION: [{}]", DataStore.getDataKey(DataStore.APPLICANT_COUNTRY_OF_APPLICATION));

        return randomCountryCode;
    }

    protected String getRandomType7CountryCode() {
        List<String> countryList = new ArrayList<>(CountryStore.contentType7countryHashMap.keySet());

        int randomIndex = ThreadLocalRandom.current().nextInt(countryList.size());
        String randomCountryCode = countryList.get(randomIndex);

        DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_CODE, randomCountryCode);

        String randomCountryName = CountryStore.contentType7countryHashMap.get(DataStore.getDataKey(DataStore.APPLICANT_COUNTRY_CODE));
        DataStore.setDataKey(DataStore.APPLICANT_COUNTRY_OF_APPLICATION, randomCountryName);
        log.info("APPLICANT COUNTRY OF APPLICATION: [{}]", DataStore.getDataKey(DataStore.APPLICANT_COUNTRY_OF_APPLICATION));

        return randomCountryCode;
    }

    protected String getOverseasHousePhoneNumber() {
        Object phoneNumber = CountryStore.countryHashMap.get(DataStore.getDataKey(DataStore.APPLICANT_COUNTRY_CODE)).get(1);

        return String.valueOf(phoneNumber).replaceAll("\\-", "").replaceAll(" ", "");
    }

    protected String getOverseasMobilePhoneNumber() {
        Object phoneNumber = CountryStore.countryHashMap.get(DataStore.getDataKey(DataStore.APPLICANT_COUNTRY_CODE)).get(2);

        return String.valueOf(phoneNumber).replaceAll("\\-", "").replaceAll(" ", "");
    }

    protected String getOverseasAddressPostcode() {
        Object postcode = CountryStore.countryHashMap.get(DataStore.getDataKey(DataStore.APPLICANT_COUNTRY_CODE)).get(3);

        DataStore.setDataKey(DataStore.APPLICANT_ADDRESS_POSTCODE, String.valueOf(postcode));

        return String.valueOf(postcode);
    }

    public String randomMistypedEmailAddress() throws IOException {
        JSONArray domains = (JSONArray) getData("src/test/resources/test_data/emails/domains.json").get("domains");
        int randomInt = RANDOM_GENERATOR.nextInt(domains.length());

        String invalidEmailId = "pex" + randomInt + "@" + domains.get(randomInt) + getRandomString(3);
        log.info("INVALID EMAIL ID: [{}]", invalidEmailId);

        return invalidEmailId;

    }

    public String randomValidEmailAddress() {
        int randomInt = RANDOM_GENERATOR.nextInt(10000);

        String validEmailId = "pex" + randomInt + "@example.com";
        log.info("VALID EMAIL ID: [{}]", validEmailId);

        return validEmailId;
    }

    public String generateRandomOldBluePassportNumber() {
        String saltChars = "AbCxYZ1234567890";
        StringBuilder salt = new StringBuilder();
        int randomNum = ThreadLocalRandom.current().nextInt(2, 9 + 1);

        while (salt.length() < randomNum) { // length of the random string.
            int index = (int) (RANDOM_GENERATOR.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }

        return salt.toString();
    }

    public String generateRandomNaturalisationCertificateNumber() {
        String saltChars = "AByz1234567890";
        StringBuilder salt = new StringBuilder();
        int randomNum = ThreadLocalRandom.current().nextInt(1, 12 + 1);

        while (salt.length() < randomNum) { // length of the random string.
            int index = (int) (RANDOM_GENERATOR.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }

        return salt.toString();
    }
}
