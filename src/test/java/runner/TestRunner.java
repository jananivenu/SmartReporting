package runner;



import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.reporting.stepdefinition"},
        plugin = { "pretty", "html:target/cucumber-reports.html" ,"json:target/cucumber.json"},
        monochrome = true

)
public class TestRunner {
}