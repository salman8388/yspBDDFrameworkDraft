package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/java/features",
        glue = {"stepDefinition","Hooks"},
        monochrome = true,
        tags = "@tag",
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/cucumber-reports/CucumberTestReport.json", "html:target/cucumber-reports/CucumberTestReport.html", },
        publish = true
)
public class TestRunner {
}
