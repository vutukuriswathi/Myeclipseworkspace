package com.abc.stepDefinition;

import com.abcnews.pages.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition {

	HomePage homePage = new HomePage(Hooks.getDriver());

	@When("^the app opens$")
	public void the_app_opens() {
		homePage.openApp();

	}

	@Then("^I should be taken to the Top Stories screen$")
	public void top_stories_screen() {
		homePage.verifyTopStoriesHeading();

	}

	@Given("^I have opened the app$")
	public void opened_app() {
		homePage.openApp();

	}

}
