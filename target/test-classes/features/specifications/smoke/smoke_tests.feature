Feature: Apply for a First time UK Passport

  These are the automated accessibility smoke tests for applying for a first time UK Passport.

  @SMK1 @smoke
  Scenario: Simple happy path for adult UK applications to apply for a first time passport

    Given an applicant of type adult United Kingdom first time
    When they apply for a first time passport with a successful payment
    Then the application status will be: submitted
