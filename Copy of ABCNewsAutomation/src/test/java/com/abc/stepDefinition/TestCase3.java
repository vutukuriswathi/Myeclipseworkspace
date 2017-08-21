package com.abc.stepDefinition;

import com.abcnews.pages.TopStories;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestCase3 {

	TopStories topStories = new TopStories(Hooks.getDriver());

	@When("^I tap on the first article$")
	public void I_tap_on_the_first_article() {
		topStories.firstArticle.click();

	}

	@Then("^I should be taken to the article page$")
	public void I_should_be_taken_to_article_page() {
		topStories.articlePage.isDisplayed();

	}

}
