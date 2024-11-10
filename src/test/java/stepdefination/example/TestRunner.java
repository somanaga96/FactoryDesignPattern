package stepdefination.example;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  // Path to your feature files
        glue = {"stepDefinitions"},                   // Package with step definitions
        tags = "@Login",                            // Tags to filter which scenarios to run
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Reporting options
        monochrome = true                           // Makes console output more readable
)
public class TestRunner {
}