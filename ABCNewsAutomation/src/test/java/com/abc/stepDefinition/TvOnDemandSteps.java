package com.abc.stepDefinition;

import org.junit.Assert;

import com.abc.util.Constants;
import com.abc.util.Util;
import com.abcnews.pages.HomePage;
import com.abcnews.pages.TvOnDemand;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TvOnDemandSteps {

	HomePage homePage = new HomePage(Hooks.getDriver());
	Util util = new Util();
	TvOnDemand tvOnDemandPage = new TvOnDemand(Hooks.getDriver());

	@When("^I click on tv on demand menu item$")
	public void click_demand_menu_item() throws InterruptedException {
		Thread.sleep(Constants.shortWait);
		homePage.androidMenu.click();
		Thread.sleep(Constants.shortWait);
		util.swipeUp();
		Thread.sleep(Constants.shortWait);
		util.swipeUp();
		Thread.sleep(Constants.shortWait);
		util.swipeUp();
		Thread.sleep(Constants.shortWait);

		// clicking now on tv menu item
		homePage.tvOnDemandMenuItem.click();
		Thread.sleep(Constants.shortWait);

	}

	@When("^I tap the first video on tv on demand$")
	public void video_tv_on_demand() throws InterruptedException {
		tvOnDemandPage.tvOnDemandPodcasts.get(0).click();
		Thread.sleep(Constants.mediumWait);

	}

	@Then("^I should be presented with a summary page related to tv on demand category$")
	public void summary_tv_on_demand() {
		Assert.assertTrue("Tv on demand summary page elements are missing",
				tvOnDemandPage.verifyTvOnDemandSummaryPage());

	}

	@Then("tap watch program$")
	public void tap_watch_program() {
		tvOnDemandPage.tvOnDemandWatchProgram.click();

	}

	@Then("^the video stream should start related to tv on demand category$")
	public void video_tv_demand() throws InterruptedException {
		Thread.sleep(Constants.longWait);
		Hooks.getDriver().tap(1, 650, 930, 1000);
		Hooks.embedScreenshot();
		String timeDuration = tvOnDemandPage.tvOnDemandCurrentTime.getText();
		String[] splitTime = timeDuration.split(":");
		Assert.assertTrue("video not played", Integer.parseInt(splitTime[1]) > 0);

	}

}
