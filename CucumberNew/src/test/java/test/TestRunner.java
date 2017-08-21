package test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/resources/features",plugin = {
		"pretty",
		"html:target/cucumber",
		"json:C:/Users/Selenium/.jenkins/workspace/CucumberMavenReportingPlugin/target/cucumber.json",
	//	"junit:taget_junit/cucumber.xml"
		})
public class TestRunner  extends AbstractTestNGCucumberTests  {

}
