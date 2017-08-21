package com.abc.stepDefinition;

import org.junit.Assert;

import com.abc.util.Constants;
import com.abc.util.Util;
import com.abcnews.pages.HomePage;
import com.abcnews.pages.ListenLive;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ListenLiveSteps {

	HomePage homePage = new HomePage(Hooks.getDriver());
	Util util = new Util();
	ListenLive listenLivePage = new ListenLive(Hooks.getDriver());

	@When("^I tap on listen live menu item$")
	public void tap_listen_live() throws InterruptedException {
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
		homePage.listenLiveMenuItem.click();
		Thread.sleep(Constants.shortWait);

	}

	@When("^I tap on the first item$")
	public void tap_first_item() throws InterruptedException {
		listenLivePage.listenLivePodcasts.get(0).click();
		Thread.sleep(Constants.mediumWait);

	}

	@Then("^I should be presented with a summary page$")
	public void show_summary_page() {
		Assert.assertTrue("listen live summary page elments are missing", listenLivePage.verifyListenLiveSummaryPage());

	}

	@Then("^when I tap on Listen to station$")
	public void tap_listen_to_station() {
		listenLivePage.listenLiveListenStationLabel.click();

	}

	@Then("^a player should appear on the page and an audio stream should start$")
	public void audio_start() throws InterruptedException {
		Thread.sleep(Constants.longWait);
		String time = listenLivePage.listenLiveTimer.getText();
		String[] timeSplit = time.split(":");
		Assert.assertTrue("listen live audio is not played", Integer.parseInt(timeSplit[(timeSplit.length) - 1]) > 0);
		listenLivePage.listenLivePause.click();

	}

}
