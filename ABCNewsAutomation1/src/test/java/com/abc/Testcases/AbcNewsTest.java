package com.abc.Testcases;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
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

	Util util;
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
		util = new Util();
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

	@Test(groups = { "local", "aws" })
	public void checkArticlePage() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			topStoriesPage.firstArticle.click();
			util.waitUntillElementIsVisible(topStoriesPage.articlePage);
			Assert.assertTrue(topStoriesPage.articlePage.isDisplayed(), "topstories article page is not displayed");
			TestBase.takeScreenshot("Articlepage");

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

			homePage.openApp();
			topStoriesPage.iOSFirstArticle.click();
			util.waitUntillElementIsVisible(topStoriesPage.iOSArticlePage);
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

		/*
		 * if (TestBase.platform.equalsIgnoreCase("ios")) homePage.openApp();
		 */

		homePage.verifyTopStoriesHeading();

	}

	/**
	 * @Method: checkHamburgerMenu
	 * @param:
	 * @Description:This method will check whether Hamburger Menu is displaying
	 *                   or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test(groups = { "local", "aws" })
	public void checkHamburgerMenu() throws InterruptedException {

		if (TestBase.platform.equalsIgnoreCase("android")) {
			util.waitUntillElementIsVisible(homePage.androidMenu);
			homePage.androidMenu.click();
			Assert.assertTrue(homePage.androidMenuHeading.isDisplayed(), "MenuHeading is not displayed");
		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

			util.waitUntillElementIsVisible(homePage.iOSMenu);
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

	@Test(groups = { "local", "aws" })
	public void checkWeatherDetails() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {
			util.waitUntillElementIsVisible(weatherPage.weatherIcon);
			weatherPage.weatherIcon.click();
			Assert.assertTrue(weatherPage.verifyWeatherDetails(), "weather details are missing");
			TestBase.takeScreenshot("weatherPage");
		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

			util.waitUntillElementIsVisible(weatherPage.iOSWeatherIcon);
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

	@Test(groups = { "local", "aws" })
	public void checkWeatherDetailsForSydney() throws InterruptedException {

		if (TestBase.platform.equalsIgnoreCase("android")) {
			util.waitUntillElementIsVisible(weatherPage.weatherIcon);
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
			util.waitUntillElementIsVisible(weatherPage.iOSWeatherIcon);
			weatherPage.iOSWeatherIcon.click();
			util.waitUntillElementIsVisible(weatherPage.iOSChangeLocationButton);
			weatherPage.iOSChangeLocationButton.click();
			weatherPage.iOSLocationSearchBar.click();
			driver.executeScript("target.frontMostApp().keyboard().typeString('syd')");

			util.waitUntillElementIsVisible(weatherPage.iOSydneyLocationsList);

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

	@Test(groups = { "local", "aws" })
	public void checkListenLive() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {
			homePage.menuSwiping();

			// clicking on listen live menu item
			homePage.listenLiveMenuItem.click();
			util.waitUntillElementIsVisible(listenLivePage.listenLivePodcasts.get(0));
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
			util.waitUntillElementIsVisible(listenLivePage.iOSListenLivePodCast);
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
	@Test(groups = { "local", "aws" })
	public void checkRadioOnDemand() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {
			homePage.menuSwiping();

			// clicking radio on demand menu item
			homePage.radioOnDemandMenuItem.click();
			util.waitUntillElementIsVisible(radioOnDemandPage.radioOnDemandPodcasts.get(0));
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
			util.waitUntillElementIsVisible(radioOnDemandPage.iOSRadioOnDemandFirstPodcast);
			radioOnDemandPage.iOSRadioOnDemandFirstPodcast.click();
			Thread.sleep(Constants.shortWait);

			try {
				Assert.assertTrue(radioOnDemandPage.verifyRadioOnDemandSummaryPage(),
						"radio on demand summary page elements are missing");
			} catch (Throwable e) {
				Reporter.log("radio on demand summary page elements are missing");
				ErrorUtil.addVerificationFailure(e);
			}

			util.waitUntillElementIsVisible(radioOnDemandPage.iOSRadioOnDemandPlay);
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
	@Test(groups = { "local", "aws" })
	public void checkTvOnDemand() throws InterruptedException {

		if (TestBase.platform.equalsIgnoreCase("android")) {
			homePage.menuSwiping();

			// clicking tv on demand menu item
			homePage.tvOnDemandMenuItem.click();
			util.waitUntillElementIsVisible(tvOnDemandPage.tvOnDemandPodcasts.get(0));
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
			util.waitUntillElementIsVisible(tvOnDemandPage.iOSTvOnDemandFirstPodcast);
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
			util.waitUntillElementIsVisible(nowOnTvPage.NowTvWatchNow);
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
			util.waitUntillElementIsVisible(nowOnTvPage.iOSNowOnTvWatchNow);
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

	/**
	 * @Method: checkMenuItem
	 * @param:
	 * @Description:This method will check whether the menu item is present in
	 *                   the main menu or not
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 * @throws IOException
	 */
	// @Test(groups = { "local", "aws" })
	public void checkMenuItem() throws InterruptedException, IOException {

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties testDataProp = new Properties();
		testDataProp.load(loader.getResourceAsStream("com/abc/TestData/TestData.properties"));

		if (testDataProp.getProperty("RunMode").equalsIgnoreCase("n"))
			throw new SkipException("skipping the test as the run mode is n");
		if (TestBase.platform.equalsIgnoreCase("android"))

		{
			util.waitUntillElementIsVisible(homePage.androidMenu);
			homePage.androidMenu.click();

			try {
				Assert.assertTrue(TestBase.driver.findElementByName(testDataProp.getProperty("MenuItem")).isDisplayed(),
						"menu item" + testDataProp.getProperty("MenuItem") + "is not displayed");

			} catch (Throwable e) {
				Reporter.log("menu item" + testDataProp.getProperty("MenuItem") + "is not displayed");
				ErrorUtil.addVerificationFailure(e);
			}

			// checking no:of icons are matching with the no:of elements
			try {
				Assert.assertTrue(homePage.menuIcons.size() == homePage.menuItems.size(),
						"Menu icon or menu item is missing in the menu and menuIcons size is"
								+ homePage.menuIcons.size() + " and menu items size is" + homePage.menuItems.size());
			} catch (Throwable e)

			{
				Reporter.log("Menu icon or menu item is missing in the menu and menuIcons size is"
						+ homePage.menuIcons.size() + " and menu items size is" + homePage.menuItems.size());
				ErrorUtil.addVerificationFailure(e);
			}

			// checking whether the menu item is at the correct position or not
			try {
				Assert.assertTrue(
						homePage.menuItems.get(Integer.parseInt(testDataProp.getProperty("Position")) - 1).getText()
								.equals(testDataProp.getProperty("MenuItem")),
						"Data at index" + Integer.parseInt(testDataProp.getProperty("Position"))
								+ "is not matching with the expected text" + testDataProp.getProperty("MenuItem"));

			} catch (Throwable e)

			{
				Reporter.log("Data at index" + Integer.parseInt(testDataProp.getProperty("Position"))
						+ "is not matching with the expected text" + testDataProp.getProperty("MenuItem"));
				ErrorUtil.addVerificationFailure(e);
			}

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {
			util.waitUntillElementIsVisible(homePage.iOSMenu);
			homePage.iOSMenu.click();
			try {
				Assert.assertTrue(TestBase.driver.findElementByName(testDataProp.getProperty("MenuItem")).isEnabled(),
						"menu item" + testDataProp.getProperty("MenuItem") + "is not displayed");
			} catch (Throwable e)

			{
				Reporter.log("menu item" + testDataProp.getProperty("MenuItem") + "is not displayed");
				ErrorUtil.addVerificationFailure(e);
			}
			try

			{
				int i = Integer.parseInt(testDataProp.getProperty("Position"));
				Assert.assertTrue(
						driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[" + i
								+ "]/UIAStaticText[1]").getText().equals(testDataProp.getProperty("MenuItem")),
						"menu item" + testDataProp.getProperty("MenuItem") + "is not displayed at" + i + " index");
			} catch (Throwable e)

			{
				Reporter.log(
						"menu item" + testDataProp.getProperty("MenuItem") + "is not displayed at the required index");
				ErrorUtil.addVerificationFailure(e);
			}

		}
		TestBase.takeScreenshot("MenuScreenshot");

	}

	/**
	 * @Method: checkMenuItemDeletion
	 * @param:
	 * @Description:This method will check whether the menu item is deleted from
	 *                   the main menu or not
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 * @throws IOException
	 */
	// @Test(groups = { "local", "aws" })
	public void checkMenuItemDeletion() throws InterruptedException, IOException {

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties testDataProp = new Properties();
		testDataProp.load(loader.getResourceAsStream("com/abc/TestData/TestData.properties"));

		if (testDataProp.getProperty("MenuItemRemoved").equalsIgnoreCase("n"))
			throw new SkipException("skipping the test as the Menuitemremoved is n");
		if (TestBase.platform.equalsIgnoreCase("android"))

		{
			util.waitUntillElementIsVisible(homePage.androidMenu);
			homePage.androidMenu.click();

			try {
				Assert.assertTrue(TestBase.driver.findElementsByName(testDataProp.getProperty("MenuItem")).size() == 0,
						"menu item" + testDataProp.getProperty("MenuItem") + "is  displayed");

			} catch (Throwable e) {
				Reporter.log("menu item" + testDataProp.getProperty("MenuItem") + "is  displayed");
				ErrorUtil.addVerificationFailure(e);
			}
		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {
			util.waitUntillElementIsVisible(homePage.iOSMenu);
			homePage.iOSMenu.click();
			try {
				Assert.assertTrue(TestBase.driver.findElementsByName(testDataProp.getProperty("MenuItem")).size() == 0,
						"menu item" + testDataProp.getProperty("MenuItem") + "is  displayed");
			} catch (Throwable e)

			{
				Reporter.log("menu item" + testDataProp.getProperty("MenuItem") + "is  displayed");
				ErrorUtil.addVerificationFailure(e);
			}

		}
		TestBase.takeScreenshot("MenuDeletionScreenshot");

	}

	@AfterMethod(alwaysRun = true)
	public void after() throws Exception {
		afterMethod();
	}

}
