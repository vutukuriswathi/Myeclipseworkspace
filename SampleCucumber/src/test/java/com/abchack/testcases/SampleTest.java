package com.abchack.testcases;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SampleTest {
	@Given("^Launch the wcLinkChecker$")
	public void launch_the_wcLinkChecker() throws Throwable {
		System.out.println("hi");
		// Write code here that turns the phrase above into concrete actions
		
	}

	@When("^entered page url$")
	public void when_method() {
		System.out.println("enter the  url");
	}

	@Then("^validator validates page errors$")
	public void then_method() throws InterruptedException {
		System.out.println("enter the then");
	}

}
