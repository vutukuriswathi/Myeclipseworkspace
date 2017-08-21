package com.abc.stepDefinition;

import org.junit.Assert;

import com.abc.util.Constants;
import com.abc.util.Util;
import com.abcnews.pages.HomePage;
import com.abcnews.pages.NowOnTv;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NowOnTvSteps {

	HomePage homePage = new HomePage(Hooks.getDriver());
	Util util = new Util();
	NowOnTv nowOnTvPage = new NowOnTv(Hooks.getDriver());

	@And("^click on now on tv menu item$")
	public void now_on_tv() throws InterruptedException {
		Thread.sleep(2000L);
		homePage.androidMenu.click();
		Thread.sleep(2000L);
		util.swipeUp();
		Thread.sleep(2000L);
		util.swipeUp();
		Thread.sleep(2000L);
		util.swipeUp();
		Thread.sleep(2000L);

		// clicking now on tv menu item
		homePage.nowOnTvMenuItem.click();
		Thread.sleep(2000L);

	}

	@When("^I tap watch now$")
	public void tap_watch_now() throws InterruptedException {
		nowOnTvPage.NowTvWatchNow.click();
		Thread.sleep(1000L);

	}

	@Then("^I should be presented with a tv summary page$")
	public void tv_summary_page() {
		Assert.assertTrue("Now on Tv summary page elements are missing",
				nowOnTvPage.verifyNowOnTvSummaryPageElements());

	}

	@And("^when I tap watch program$")
	public void tv_watch_program() throws InterruptedException {
		nowOnTvPage.NowOnTvwatchProgram.click();
		Thread.sleep(1000L);

	}

	@Then("^a video stream should start$")
	public void tv_video_start() throws InterruptedException {
		Thread.sleep(Constants.longWait);
		Hooks.getDriver().tap(1, 650, 930, 1000);
		String time = nowOnTvPage.NowOnTvCurrentTime.getText();
		String[] timeSplit = time.split(":");
		Assert.assertTrue("now on tv video is not playing", Integer.parseInt(timeSplit[(timeSplit.length) - 1]) > 0);
		nowOnTvPage.NowOnTvPause.click();

	}

}
