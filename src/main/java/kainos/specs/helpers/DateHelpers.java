package kainos.specs.helpers;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import static kainos.specs.helpers.TestData.DATE_FORMATTER;

@UtilityClass
@Slf4j
public class DateHelpers {

    private static final Random RAND = new Random();

    public static String getRandomDateOfBirth(int minAge, int maxAge) {
        int age = RAND.nextInt(maxAge - minAge) + minAge;

        LocalDate now = LocalDate.now();
        LocalDate dateOfBirth = now
                .minusYears(age);

        //If random generator produces a date of birth of today, make them 1 day old as issue date cannot be on or before they were born.
        if (dateOfBirth == now) {
            return String.valueOf(dateOfBirth.minusDays(1));
        }

        return String.valueOf(dateOfBirth);
    }

    private static int getValueWithinRange(int min, int max) {
        return RAND.nextInt(max - min) + min;
    }

    public static int minAdultYearOfBirth() {
        //Note: You can also be considered an Adult from the age of 16 minus 3 weeks (rising 16) excluding DPS and POL applications
        return 16;
    }

    public static int maxAdultYearOfBirth() {
        //Note: You can be considered an Adult upto and including 02/09/1929, after which you are considered a veteran
        int lastYearToBeConsideredAnAdult = 1930;
        int yearNow = LocalDate.now().getYear();

        return yearNow - lastYearToBeConsideredAnAdult;
    }

    public static String getVeteranDateOfBirth() {
        LocalDate minDate = LocalDate.of(1929, 9, 2);

        int maxDiffAge = 30;
        int diffAge = RAND.nextInt(maxDiffAge);

        LocalDate veteranBirthDate = minDate.minusYears(diffAge);

        return veteranBirthDate.toString();
    }

    public static String getRisingAgeDateOfBirth(int years) {
        LocalDate nowPlus21Days = LocalDate.now().plus(21, ChronoUnit.DAYS).minusYears(years);

        return nowPlus21Days.toString();
    }

    public static String getFifteenYearsEightAgeDateOfBirth(int years) {
        LocalDate nowPlus21Days = LocalDate.now().plus(3, ChronoUnit.MONTHS).minusYears(years);

        return nowPlus21Days.toString();
    }

    public static String getRandomDateInPast(String issueDateRange) {
        switch (issueDateRange) {
            case ("94_02"):
                return LocalDate.now().minusYears(LocalDate.now().getYear() - getValueWithinRange(1994, 2002)).format(DATE_FORMATTER);
            case ("94_04"):
                return LocalDate.now().minusYears(LocalDate.now().getYear() - getValueWithinRange(1994, 2004)).format(DATE_FORMATTER);
            case ("94_97"):
                return LocalDate.now().minusYears(LocalDate.now().getYear() - getValueWithinRange(1994, 1997)).format(DATE_FORMATTER);
            default:
                return LocalDate.now().minusDays(Integer.parseInt(issueDateRange)).format(DATE_FORMATTER);
        }
    }

    public static LocalDate getIssueDateInPast(String applicationType, LocalDate dateOfBirth) {
        int yearsAgo = applicationType.equals("CHILD") ? 5 : 10;
        LocalDate possibleIssueDate = LocalDate.now().plusMonths(3).minusYears(yearsAgo);

        return possibleIssueDate.isAfter(dateOfBirth) ? possibleIssueDate : dateOfBirth.plusDays(1);
    }

    public static LocalDate getExpiryDateFromIssueDateAndType(LocalDate issueDate, String applicationType) {
        int yearsAfterIssue = applicationType.equals("CHILD") ? 5 : 10;
        return issueDate.plusYears(yearsAfterIssue);
    }

    public static String getPassportExpiryDate3MonthsFromNow() {
        String expiryDate = LocalDate.now().plusMonths(3).format(DATE_FORMATTER);
        log.info("Passport Expiry Date: [{}]", expiryDate);

        return expiryDate;
    }
}
