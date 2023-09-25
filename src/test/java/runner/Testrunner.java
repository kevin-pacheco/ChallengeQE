package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import seleniumgluecode.Hooks;

import static cucumber.api.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"seleniumgluecode"},
        features = "src/test/java/features",
        tags = "@OrderDetails"
)
public class Testrunner extends Hooks {

}
