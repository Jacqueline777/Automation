

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        tags = ("@runapi"),
        features="src/test/resources",
        glue={"stepsdef", "processes"},

        plugin = {
                "pretty",  "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports/report.html",

        },

        monochrome = true
)


public class Testrunner {

}
