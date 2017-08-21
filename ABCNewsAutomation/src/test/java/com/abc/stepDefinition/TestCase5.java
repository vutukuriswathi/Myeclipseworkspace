package com.abc.stepDefinition;

import com.abc.util.Constants;
import com.abcnews.pages.Weather;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class TestCase5 {

	Weather weatherPage = new Weather(Hooks.getDriver());

	@When("^I am in weather$")
	public void I_am_in_weather() {
		weatherPage.weatherIcon.click();

	}

	@When("^I tap on the change link$")
	public void I_tap_change_link() {
		weatherPage.search.click();

	}

	@Then("^I will be presented with a search box to enter the location syd$")
	public void presented_search_box() {
		weatherPage.androidSearchText.sendKeys("syd");
	}

	@And("^A list of suggested locations should appear after I type three characters$")
	public void suggested_locations() throws InterruptedException {
		Thread.sleep(2000L);
		Assert.assertTrue("suggested locations is less than 3", weatherPage.suggestedLocationsList.size() > 3);

	}

	@Then("^select a location sydney$")
	public void select_location() throws InterruptedException {
		Thread.sleep(2000L);
		weatherPage.suggestedLocationsList.get(6).click();
		Thread.sleep(1000L);
		weatherPage.alertOkButton.click();

	}

	@Then("^I should be shown a screen with today and tomorrows weather$")
	public void screen_today_tomorrow() {
		Assert.assertTrue("weather page does not contain today and tomorrow details",
				weatherPage.verifyWeatherDetails());

	}

	@And("^It should be for the new location$")
	public void new_lcoation() {
		Assert.assertTrue("new location is not matching with sydney",
				weatherPage.locationName.getText().equals(Constants.locationName));

	}

}
