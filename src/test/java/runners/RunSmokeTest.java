package runners;

import io.cucumber.testng.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import kainos.specs.listener.EventListener;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_definitions",
        tags = "@smoke",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-reports.html"})

@Listeners(EventListener.class)
@Slf4j
public class RunSmokeTest extends BaseRunner {
}
