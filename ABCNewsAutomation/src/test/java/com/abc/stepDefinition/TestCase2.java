package com.abc.stepDefinition;

import com.abcnews.pages.HomePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class TestCase2 {

	HomePage homePage = new HomePage(Hooks.getDriver());

	@When("^I tap on the hamburger menu icon$")
	public void i_tap_on_the_hamburger_menu_icon() throws InterruptedException {
		Thread.sleep(1000);
		homePage.androidMenu.click();

	}

	@Then("^The Menu should open$")
	public void menuOpen() {
		Assert.assertTrue("MenuHeading is not displayed", homePage.androidMenuHeading.isDisplayed());

	}

}
