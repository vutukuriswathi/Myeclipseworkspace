package com.abc.stepDefinition;

import org.junit.Assert;

import com.abc.util.Util;
import com.abcnews.pages.HomePage;
import com.abcnews.pages.RadioOnDemand;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RadioOnDemandSteps {

	HomePage homePage = new HomePage(Hooks.getDriver());
	Util util = new Util();
	RadioOnDemand radioOnDemandPage = new RadioOnDemand(Hooks.getDriver());

	@And("^click on radio on demand menu item$")
	public void click_radio_demand_menu_item() throws InterruptedException {

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
		homePage.radioOnDemandMenuItem.click();
		Thread.sleep(2000L);

	}

	@When("^I tap the first item$")
	public void tap_first_item() throws InterruptedException {
		radioOnDemandPage.radioOnDemandPodcasts.get(0).click();
		Thread.sleep(1000L);

	}

	@Then("^I should be presented with a ondemand summary page$")
	public void onDemand_summary_page() {
		Assert.assertTrue("radio on demand summary page elements are missing",
				radioOnDemandPage.verifyRadioOnDemandSummaryPage());

	}

	@Then("^when I tap on listen to program$")
	public void listen_to_program() throws InterruptedException {
		Thread.sleep(2000L);
		radioOnDemandPage.radioOnDemListenProgram.click();
		Thread.sleep(1000L);

	}

	@Then("^a player should appear on the page and an audio stream should start for radi on demand$")
	public void player_audio_start() throws InterruptedException {
		Thread.sleep(5000L);
		Hooks.embedScreenshot();
		String audioPlayTime = radioOnDemandPage.radioOnDemandBeginTime.getText();
		String[] timeSplit = audioPlayTime.split(":");
		Assert.assertTrue("audio not played", Integer.parseInt(timeSplit[1]) > 0);
		radioOnDemandPage.radioOnDemandPauseIcon.click();

	}

}
