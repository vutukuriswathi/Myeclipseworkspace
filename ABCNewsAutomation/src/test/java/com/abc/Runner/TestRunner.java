package com.abc.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = "classpath:com/abc/features/testcase1.feature", glue = "com.abc.stepDefinition", plugin = {
		"pretty", "html:target/cucumber.html", "json:target/cucumber.json" })
public class TestRunner {

}
