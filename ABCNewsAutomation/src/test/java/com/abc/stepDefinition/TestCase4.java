package com.abc.stepDefinition;

import com.abcnews.pages.Weather;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class TestCase4 {
	Weather weatherPage = new Weather(Hooks.getDriver());

	@When("^I tap on the weather icon in the top right$")
	public void I_tap_on_weather_icon() {
		weatherPage.weatherIcon.click();

	}

	@Then("^I should see weather for a location for today and tomorrow$")
	public void weather_for_canberra() {
		Assert.assertTrue(weatherPage.verifyWeatherDetails());
		Hooks.embedScreenshot();

	}

}
