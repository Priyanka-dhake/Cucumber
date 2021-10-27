package stepdefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/feature",glue= {"stepdefinitions"},
monochrome =true,
plugin= {"pretty","junit:target/Junitreports/reports.xml",
		"json:target/JSONreports/reports.json",
		"html:target/Htmlreports/reports.html"},
tags= "@SmokeTest"
)
public class sawglabsrunner {

}
