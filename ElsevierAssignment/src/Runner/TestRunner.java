package Runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@Cucumber.Options(features={"Features"},glue ="StepDefinition",monochrome = true)

public class TestRunner {

}
