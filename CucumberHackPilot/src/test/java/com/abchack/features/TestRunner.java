package com.abchack.features;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/com/abchack/features", format = { "pretty", "html:target/cucumber" })
public class TestRunner extends AbstractTestNGCucumberTests {

}
