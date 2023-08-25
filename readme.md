## Pre-requisites

1. Maven is installed and the environment variable set (From the command line run "mvn -v")
2. Java 11+ is installed and the environment variable set (From the command line run "java -version")
3. Cucumber for Java Plugin is installed

### Running locally

The tests can be executed in a number of ways using Maven.
It is required to specify an environment to run the tests against, and a Maven profile to specify which test suite to
run - by default the Smoke tests (`-Psmoke`) will be run if no profile is specified.

For example:

| Command													     			                                          | Description                                                                                                            |
|-----------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------|
| `ENVIRONMENT=sit mvn clean test -Psmoke`                              | Run smoke test suite against the SIT environment.                                                                      |
| `ENVIRONMENT=sit mvn clean test -Psmoke -Dcucumber.filter.tags=@SMK1` | Run smoke test suite with a specific tag <https://github.com/cucumber/cucumber/wiki/Tags> against the SIT environment. |
| `ENVIRONMENT=stg mvn clean test -Psmoke`                              | Run smoke test suite against the STG environment.                                                                      |

### Running tests in parallel

By default, all tests run that can run in parallel do so, but if you wish to run a test in series mode then tag the test
or scenario with the annotation `@serial`.
To change the amount of parallel threads for a run, change the value of `data-provider-thread-count="5"` in the TestNG
suite XML file e.g. `regression.xml`, `smoke.xml` etc.

## Reports

Once you have executed the tests, Cucumber will create a report as `target/cucumber-reports/cucumber-reports.html`.
