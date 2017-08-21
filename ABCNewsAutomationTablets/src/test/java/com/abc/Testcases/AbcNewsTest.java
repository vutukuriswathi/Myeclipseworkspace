package com.abc.Testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.abc.util.Constants;
import com.abc.util.ErrorUtil;
import com.abc.util.Util;
import com.abcnews.pages.HomePage;
import com.abcnews.pages.ListenLive;
import com.abcnews.pages.NowOnTv;
import com.abcnews.pages.RadioOnDemand;
import com.abcnews.pages.TopStories;
import com.abcnews.pages.TvOnDemand;
import com.abcnews.pages.Weather;

@Listeners({ com.abc.listener.TestListenerAdapter.class })
public class AbcNewsTest extends TestBase {

	HomePage homePage;
	ListenLive listenLivePage;
	NowOnTv nowOnTvPage;
	RadioOnDemand radioOnDemandPage;
	TopStories topStoriesPage;
	TvOnDemand tvOnDemandPage;
	Weather weatherPage;

	@BeforeMethod(alwaysRun = true)
	public void before() throws IOException {
		beforeMethod();
		Util util = new Util();
		homePage = new HomePage(TestBase.getDriver());
		listenLivePage = new ListenLive(TestBase.getDriver());
		nowOnTvPage = new NowOnTv(TestBase.getDriver());
		radioOnDemandPage = new RadioOnDemand(TestBase.getDriver());
		topStoriesPage = new TopStories(TestBase.getDriver());
		tvOnDemandPage = new TvOnDemand(TestBase.getDriver());
		weatherPage = new Weather(TestBase.getDriver());
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

		if (TestBase.platform.equalsIgnoreCase("android"))
			homePage.openApp();

	}

	/**
	 * @Method: checkArticlePage
	 * @param:
	 * @Description:This method will check whether the article page is opened or
	 *                   not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */

	// @Test(groups = { "local", "aws" })
	public void checkArticlePage() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			topStoriesPage.firstArticle.click();
			Thread.sleep(Constants.shortWait);
			Assert.assertTrue(topStoriesPage.articlePage.isDisplayed(), "topstories article page is not displayed");
			TestBase.takeScreenshot("Articlepage");

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

			homePage.openApp();
			topStoriesPage.iOSFirstArticle.click();
			Thread.sleep(Constants.shortWait);
			Assert.assertTrue(topStoriesPage.iOSArticlePage.isDisplayed(), "topstories article page is not displayed");
			TestBase.takeScreenshot("Articlepage");
		}

	}

	/**
	 * @Method: checkTopStoriesHeading
	 * @param:
	 * @Description:This method will check whether top stories page is opened by
	 *                   default or not.
	 * @author :swathi Gunuputi
	 */
	@Test(groups = { "local", "aws" })
	public void checkTopStoriesHeading() {

		if (TestBase.platform.equalsIgnoreCase("ios"))
			homePage.openApp();

		homePage.verifyTopStoriesHeading();
		TestBase.takeScreenshot("topStoriesHeading");

	}

	/**
	 * @Method: checkHamburgerMenu
	 * @param:
	 * @Description:This method will check whether Hamburger Menu is displaying
	 *                   or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	// @Test(groups = { "local", "aws" })
	public void checkHamburgerMenu() throws InterruptedException {

		if (TestBase.platform.equalsIgnoreCase("android")) {
			Thread.sleep(Constants.shortWait);
			homePage.androidMenu.click();
			Assert.assertTrue(homePage.androidMenuHeading.isDisplayed(), "MenuHeading is not displayed");
		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

			Thread.sleep(Constants.shortWait);
			homePage.iOSMenu.click();
			Assert.assertTrue(homePage.iOSMenuHeading.isDisplayed(), "MenuHeading is not displayed");

		}

	}

	/**
	 * @Method: checkWeatherDetails
	 * @param:
	 * @Description:This method will check whether the weather page is
	 *                   displaying all the details or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */

	// @Test(groups = { "local", "aws" })
	public void checkWeatherDetails() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			weatherPage.weatherIcon.click();
			Assert.assertTrue(weatherPage.verifyWeatherDetails(), "weather details are missing");
			TestBase.takeScreenshot("weatherPage");
		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

			Thread.sleep(Constants.shortWait);
			TestBase.takeScreenshot("weatherPage");
			weatherPage.iOSWeatherIcon.click();
			Assert.assertTrue(weatherPage.verifyWeatherDetails(), "weather details are missing");
			TestBase.takeScreenshot("weatherPage");

		}

	}

	/**
	 * @Method: checkWeatherDetailsForSydney
	 * @param:
	 * @Description:This method will check whether the weather page is
	 *                   displaying all the details related to sydney or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */

	// @Test(groups = { "local", "aws" })
	public void checkWeatherDetailsForSydney() throws InterruptedException {

		if (TestBase.platform.equalsIgnoreCase("android")) {
			weatherPage.weatherIcon.click();
			weatherPage.search.click();
			weatherPage.androidSearchText.sendKeys("syd");
			Thread.sleep(Constants.mediumWait);

			try {
				Assert.assertTrue(weatherPage.suggestedLocationsList.size() > 3, "suggested locations is less than 3");
			} catch (Throwable e) {
				Reporter.log("suggested locations is less than 3");
				ErrorUtil.addVerificationFailure(e);
			}

			Thread.sleep(Constants.mediumWait);
			weatherPage.suggestedLocationsList.get(6).click();
			Thread.sleep(Constants.mediumWait);
			weatherPage.alertOkButton.click();

			try {
				Assert.assertTrue(weatherPage.verifyWeatherDetails(),
						"weather page does not contain today and tomorrow details");
			} catch (Exception e) {
				Reporter.log("weather page does not contain today and tomorrow details");
				ErrorUtil.addVerificationFailure(e);

			}

			try {
				Assert.assertTrue(weatherPage.locationName.getText().equals(Constants.locationName),
						"new location is not matching with sydney");
			} catch (Exception e) {
				Reporter.log("New location is not matching with sydney");
				ErrorUtil.addVerificationFailure(e);

			}

			TestBase.takeScreenshot("weatherPageSydney");
		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {

			TestBase.takeScreenshot("weatherPageSydney");
			Thread.sleep(Constants.mediumWait);
			weatherPage.iOSWeatherIcon.click();
			Thread.sleep(Constants.shortWait);
			weatherPage.iOSChangeLocationButton.click();
			weatherPage.iOSLocationSearchBar.click();
			driver.executeScript("target.frontMostApp().keyboard().typeString('syd')");

			Thread.sleep(Constants.mediumWait);

			weatherPage.iOSydneyLocationsList.click();
			Thread.sleep(Constants.mediumWait);

			try {
				Assert.assertTrue(weatherPage.verifyWeatherDetails(),
						"weather page does not contain today and tomorrow details");
			} catch (Exception e) {
				Reporter.log("weather page does not contain today and tomorrow details");
				ErrorUtil.addVerificationFailure(e);

			}

			try {
				Assert.assertTrue(weatherPage.iOSChangeLocationButton.getText().equals(Constants.locationName),
						"new location is not matching with sydney");
			} catch (Exception e) {
				Reporter.log("New location is not matching with sydney");
				ErrorUtil.addVerificationFailure(e);

			}

			TestBase.takeScreenshot("weatherPageSydney");

		}

	}

	/**
	 * @Method: checkListenLive
	 * @param:
	 * @Description:This method will check whether the listen live audio is
	 *                   playing or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */

	// @Test(groups = { "local", "aws" })
	public void checkListenLive() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {
			homePage.menuSwiping();

			// clicking on listen live menu item
			homePage.listenLiveMenuItem.click();
			Thread.sleep(Constants.shortWait);
			listenLivePage.listenLivePodcasts.get(0).click();
			Thread.sleep(Constants.mediumWait);

			try {
				Assert.assertTrue(listenLivePage.verifyListenLiveSummaryPage(),
						"listen live summary page elments are missing");
			} catch (Throwable e) {
				Reporter.log("listen live summary page elments are missing");
				ErrorUtil.addVerificationFailure(e);
			}

			listenLivePage.listenLiveListenStationLabel.click();
			Thread.sleep(Constants.longWait);
			String time = listenLivePage.listenLiveTimer.getText();
			String[] timeSplit = time.split(":");

			try {
				Assert.assertTrue(Integer.parseInt(timeSplit[(timeSplit.length) - 1]) > 0,
						"listen live audio is not played");
			} catch (Throwable e) {
				Reporter.log("listen live audio is not played");
				ErrorUtil.addVerificationFailure(e);
			}
			TestBase.takeScreenshot("ListenLive");

			listenLivePage.listenLivePause.click();
		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

			homePage.iOSMenu.click();

			// clicking listen live menu item
			homePage.iOSListenLive.click();
			Thread.sleep(Constants.shortWait);
			listenLivePage.iOSListenLivePodCast.click();
			Thread.sleep(Constants.mediumWait);

			try {
				Assert.assertTrue(listenLivePage.verifyListenLiveSummaryPage(),
						"listen live summary page elments are missing");
			} catch (Throwable e) {
				Reporter.log("listen live summary page elments are missing");
				ErrorUtil.addVerificationFailure(e);
			}

			listenLivePage.iOSNowOnListenToProgramBtn.click();
			Thread.sleep(Constants.longWait);

			try {
				Assert.assertTrue(listenLivePage.iOSNowOnPauseBtn.isDisplayed(),
						"listen live pause button is not present");
			} catch (Throwable e) {
				Reporter.log("listen live pause button is not present");
				ErrorUtil.addVerificationFailure(e);
			}

			TestBase.takeScreenshot("ListenLive");

			listenLivePage.iOSNowOnPauseBtn.click();

		}

	}

	/**
	 * @Method: checkRadioOnDemand
	 * @param:
	 * @Description:This method will check whether the Radio on demand audio is
	 *                   playing or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	// @Test(groups = { "local", "aws" })
	public void checkRadioOnDemand() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {
			homePage.menuSwiping();

			// clicking radio on demand menu item
			homePage.radioOnDemandMenuItem.click();
			Thread.sleep(Constants.mediumWait);
			radioOnDemandPage.radioOnDemandPodcasts.get(0).click();
			Thread.sleep(Constants.shortWait);

			try {
				Assert.assertTrue(radioOnDemandPage.verifyRadioOnDemandSummaryPage(),
						"radio on demand summary page elements are missing");
			} catch (Throwable e) {
				Reporter.log("radio on demand summary page elements are missing");
				ErrorUtil.addVerificationFailure(e);
			}

			Thread.sleep(Constants.mediumWait);
			radioOnDemandPage.radioOnDemListenProgram.click();
			Thread.sleep(Constants.longWait);

			TestBase.takeScreenshot("radioondemandvideo");
			String audioPlayTime = radioOnDemandPage.radioOnDemandBeginTime.getText();
			String[] timeSplit = audioPlayTime.split(":");

			try {
				Assert.assertTrue(Integer.parseInt(timeSplit[(timeSplit.length) - 1]) > 0, "audio not played");
			} catch (Throwable e) {
				Reporter.log("radio on demand audio not played");
				ErrorUtil.addVerificationFailure(e);
			}

			radioOnDemandPage.radioOnDemandPauseIcon.click();
		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {
			homePage.iOSMenu.click();

			// clicking radio on demand menu item
			homePage.iOSRadioOnDemand.click();
			Thread.sleep(Constants.mediumWait);
			radioOnDemandPage.iOSRadioOnDemandFirstPodcast.click();
			Thread.sleep(Constants.shortWait);

			try {
				Assert.assertTrue(radioOnDemandPage.verifyRadioOnDemandSummaryPage(),
						"radio on demand summary page elements are missing");
			} catch (Throwable e) {
				Reporter.log("radio on demand summary page elements are missing");
				ErrorUtil.addVerificationFailure(e);
			}

			Thread.sleep(Constants.mediumWait);
			radioOnDemandPage.iOSRadioOnDemandPlay.click();
			Thread.sleep(Constants.longWait);

			TestBase.takeScreenshot("radioondemandvideo");
			String audioPlayTime = radioOnDemandPage.iOSRadioOnDemandPlayTime.getText();
			String[] timeSplit = audioPlayTime.split(":");

			try {
				Assert.assertTrue(Integer.parseInt(timeSplit[(timeSplit.length) - 1]) > 0, "audio not played");
			} catch (Throwable e) {
				Reporter.log("radio on demand audio not played");
				ErrorUtil.addVerificationFailure(e);
			}

			radioOnDemandPage.iOSRadioOnDemandPause.click();

		}
	}

	/**
	 * @Method: checkTvOnDemand
	 * @param:
	 * @Description:This method will check whether the Tv on demand video is
	 *                   playing or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	// @Test(groups = { "local", "aws" })
	public void checkTvOnDemand() throws InterruptedException {

		if (TestBase.platform.equalsIgnoreCase("android")) {
			homePage.menuSwiping();

			// clicking tv on demand menu item
			homePage.tvOnDemandMenuItem.click();
			Thread.sleep(Constants.shortWait);
			tvOnDemandPage.tvOnDemandPodcasts.get(0).click();
			Thread.sleep(Constants.mediumWait);

			try {
				Assert.assertTrue(tvOnDemandPage.verifyTvOnDemandSummaryPage(),
						"Tv on demand summary page elements are missing");
			} catch (Throwable e) {
				Reporter.log("Tv on demand summary page elements are missing");
				ErrorUtil.addVerificationFailure(e);
			}

			tvOnDemandPage.tvOnDemandWatchProgram.click();
			Thread.sleep(Constants.longWait);
			Dimension size = TestBase.getDriver().manage().window().getSize();
			TestBase.getDriver().tap(1, (size.getWidth()) / 2, (size.getHeight()) / 2, 1000);

			String timeDuration = tvOnDemandPage.tvOnDemandCurrentTime.getText();
			String[] splitTime = timeDuration.split(":");

			try {
				Assert.assertTrue(Integer.parseInt(splitTime[((splitTime.length) - 1)]) > 0,
						" TV on demand video not played");
			} catch (Throwable e) {
				Reporter.log("Tv on demand video not played");
				ErrorUtil.addVerificationFailure(e);
			}
			TestBase.takeScreenshot("tvondemandvideo");
		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {

			homePage.iOSMenu.click();
			// clicking tv on demand menu item
			homePage.iOSTvOnDemand.click();
			Thread.sleep(Constants.shortWait);
			tvOnDemandPage.iOSTvOnDemandFirstPodcast.click();
			Thread.sleep(Constants.mediumWait);

			try {
				Assert.assertTrue(tvOnDemandPage.verifyTvOnDemandSummaryPage(),
						"Tv on demand summary page elements are missing");
			} catch (Throwable e) {
				Reporter.log("Tv on demand summary page elements are missing");
				ErrorUtil.addVerificationFailure(e);
			}

			tvOnDemandPage.iOSTvOnDemandPlay.click();
			Thread.sleep(Constants.longWait);
			Dimension size = TestBase.getDriver().manage().window().getSize();
			TestBase.getDriver().tap(1, (size.getWidth()) / 2, (size.getHeight()) / 2, 1);

			// tvOnDemandPage.iOSTvOnDemandPause.click();

			String timeDuration = tvOnDemandPage.iOSTvOnDemandPlayTime.getAttribute("value");
			String[] firstPart = timeDuration.split("of");
			String[] splitTime = firstPart[0].split(":");

			try {
				Assert.assertTrue(Double.parseDouble(splitTime[((splitTime.length) - 1)]) > 0,
						" TV on demand video not played");
			} catch (Throwable e) {
				Reporter.log("Tv on demand video not played");
				ErrorUtil.addVerificationFailure(e);
			}
			TestBase.takeScreenshot("tvondemandvideo");
		}
	}

	/**
	 * @Method: checkNowOnTv
	 * @param:
	 * @Description:This method will check whether the now on Tv video is
	 *                   playing or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */

	// @Test(groups = { "local" })
	public void checkNowOnTv() throws InterruptedException {

		if (TestBase.platform.equalsIgnoreCase("android")) {
			homePage.menuSwiping();
			// clicking now on tv menu item
			homePage.nowOnTvMenuItem.click();
			Thread.sleep(Constants.mediumWait);
			nowOnTvPage.NowTvWatchNow.click();
			Thread.sleep(Constants.shortWait);

			try {
				Assert.assertTrue(nowOnTvPage.verifyNowOnTvSummaryPageElements(),
						"Now on Tv summary page elements are missing");
			} catch (Throwable e) {
				Reporter.log("Now on Tv summary page elements are missing");
				ErrorUtil.addVerificationFailure(e);
			}
			nowOnTvPage.NowOnTvwatchProgram.click();
			Thread.sleep(Constants.shortWait);
			Thread.sleep(Constants.longWait);
			TestBase.getDriver().tap(1, 650, 930, 1000);
			String time = nowOnTvPage.NowOnTvCurrentTime.getText();
			String[] timeSplit = time.split(":");
			try {
				Assert.assertTrue(Integer.parseInt(timeSplit[(timeSplit.length) - 1]) > 0,
						"now on tv video is not playing");
			} catch (Throwable e) {
				Reporter.log("now on tv video is not playing");
				ErrorUtil.addVerificationFailure(e);
			}
			nowOnTvPage.NowOnTvPause.click();
		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

			homePage.iOSMenu.click();
			// clicking now on tv menu item
			homePage.iOSNowOnTv.click();
			Thread.sleep(Constants.mediumWait);
			nowOnTvPage.iOSNowOnTvWatchNow.click();
			Thread.sleep(Constants.shortWait);

			try {
				Assert.assertTrue(nowOnTvPage.verifyNowOnTvSummaryPageElements(),
						"Now on Tv summary page elements are missing");
			} catch (Throwable e) {
				Reporter.log("Now on Tv summary page elements are missing");
				ErrorUtil.addVerificationFailure(e);
			}
			nowOnTvPage.iOSNowOnTvPlay.click();

			Thread.sleep(Constants.shortWait);
			nowOnTvPage.iOSNowOnTvPause.click();

		}

	}

	@AfterMethod(alwaysRun = true)
	public void after() throws Exception {
		afterMethod();
	}

}
