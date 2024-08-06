package runner;




import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@IncludeEngines("cucumber")
@SelectClasspathResource("com/reporting/stepdefinition")
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/reporting/stepdefinition"},
        plugin = { "pretty", "html:target/cucumber-reports.html" ,"json:target/cucumber.json"},
        monochrome = true

)

public class CucumberTest {
}
