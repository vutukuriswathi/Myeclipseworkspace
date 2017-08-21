package com.abchack.features;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/java/com/abchack/features/", glue = { "com/abchack/testcases/" }, plugin = {
		"pretty", "html:target/cucumber",
		// "json:C:/Users/Selenium/.jenkins/workspace/CucumberMavenReportingPlugin/target/cucumber.json",
		"junit:taget_junit/cucumber.xml" })
public class TestRunner extends AbstractTestNGCucumberTests {

}
