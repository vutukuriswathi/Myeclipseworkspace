package com.abc.Testcases;

import java.io.IOException;

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
import com.abcnews.pages.CategoryPage;
import com.abcnews.pages.EpisodeDetailPage;
import com.abcnews.pages.HomePage;
import com.abcnews.pages.SearchPage;

@Listeners({ com.abc.listener.TestListenerAdapter.class })
public class IviewTest extends TestBase {

	HomePage homePage;
	EpisodeDetailPage episodeDetailPage;
	CategoryPage categoryPage;
	SearchPage searchPage;
	Util util;

	@BeforeMethod(alwaysRun = true)
	public void before() throws IOException {
		beforeMethod();
		util = new Util();

		// driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

	}

	/**
	 * @Method: checkMenuItems
	 * @param:
	 * @Description:This method will check whether menu items are present or
	 *                   not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */

	@Test(groups = { "local", "aws" })
	public void checkMenuItems() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

		}

	}

	/**
	 * @Method: checkBrowseMenuItems
	 * @param:
	 * @Description:This method will check whether browse menu items are present
	 *                   or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	// @Test(groups = { "local", "aws" })
	public void checkBrowseMenuItems() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			Assert.assertTrue(homePage.verifyBrowseMenuItems(), "Browse Menu items are not displayed");

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

		}

	}

	/**
	 * @Method: checkYourIviewMenuItems
	 * @param:
	 * @Description:This method will check whether iview menu items are present
	 *                   or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	// @Test(groups = { "local", "aws" })
	public void checkYourIviewMenuItems() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			Assert.assertTrue(homePage.verifyYourIviewMenuItems(), "your iview Menu items are not displayed");

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

		}

	}

	/**
	 * @Method: checkSupportMenuItems
	 * @param:
	 * @Description:This method will check whether support menu items are
	 *                   present or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	// @Test(groups = { "local", "aws" })
	public void checkSupportMenuItems() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			Assert.assertTrue(homePage.verifySupportMenuItems(), "Browse Menu items are not displayed");

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

		}

	}

	/**
	 * @Method: checkMoreMenuItems
	 * @param:
	 * @Description:This method will check whether more menu items are present
	 *                   or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	// @Test(groups = { "local", "aws" })
	public void checkMoreMenuItems() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			Assert.assertTrue(homePage.verifyMoreMenuItems(), "Browse Menu items are not displayed");

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

		}

	}

	/**
	 * @Method: checkHeroCardVideo
	 * @param:
	 * @Description:This method will check whether the hero card video is
	 *                   playing not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test(groups = { "local", "aws" })
	public void checkHeroCardVideo() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			util.swipeUp();
			util.waitUntillElementIsVisible(homePage.andEpisodeItems.get(5));

			homePage.andEpisodeItems.get(5).click();

			util.waitUntillElementIsVisible(episodeDetailPage.andEpisodePlaybtn.get(1));
			episodeDetailPage.andEpisodePlaybtn.get(1).click();
			for (int i = 0; i < 2; i++)
				Thread.sleep(Constants.longWait);
			TestBase.takeScreenshot("episode video");
			Dimension size = TestBase.driver.manage().window().getSize();
			TestBase.driver.tap(1, size.getWidth() / 2, size.getHeight() / 2, 1000);
			episodeDetailPage.andEpisodePauseBtn.click();

			try {
				Assert.assertTrue(episodeDetailPage.andEpisodePauseBtn.isDisplayed(), "pause btn is not displayed");
			} catch (Throwable e) {
				Reporter.log("pause btn is not displayed");
				ErrorUtil.addVerificationFailure(e);
			}

			try {
				Assert.assertTrue(episodeDetailPage.andEpisodeVolumeControl.isDisplayed(),
						"volume control is not displayed");
			} catch (Throwable e) {
				Reporter.log("volume control is not displayed");
				ErrorUtil.addVerificationFailure(e);
			}

		}

		if (TestBase.platform.equalsIgnoreCase("ios"))

		{
			util.swipeUp();
			util.waitUntillElementIsVisible(homePage.iOSSecondEpisode);
			homePage.iOSSecondEpisode.click();
			util.waitUntillElementIsVisible(episodeDetailPage.iOSEpisodePlayBtn);
			episodeDetailPage.iOSEpisodePlayBtn.click();
			TestBase.takeScreenshot("episode video");
			for (int i = 0; i < 3; i++)
				Thread.sleep(Constants.longWait);
			Dimension size = TestBase.driver.manage().window().getSize();
			TestBase.driver.tap(1, size.getWidth() / 2, size.getHeight() / 2, 1);
			episodeDetailPage.iOSEpisodePause.click();
			String playedTime[] = episodeDetailPage.iOSEpisodeStartTime.getText().split(":");
			TestBase.takeScreenshot("HeroCardVideo2");
			try {
				Assert.assertTrue((Integer.parseInt(playedTime[0]) > 0) || (Integer.parseInt(playedTime[1])) > 0,
						"episode not played");
			} catch (Throwable e) {
				Reporter.log("episode video not played");
				ErrorUtil.addVerificationFailure(e);
			}
		}

	}

	/**
	 * @Method: checkProgramSearch
	 * @param:
	 * @Description:This method will search for a program
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test(groups = { "local", "aws" })
	public void checkProgramSearch() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			util.waitUntillElementIsVisible(searchPage.andSearchBtn);
			searchPage.andSearchBtn.click();
			Thread.sleep(3000L);
			util.waitUntillElementIsVisible(searchPage.andSearchFieldTxt);
			searchPage.andSearchFieldTxt.sendKeys("cle");
			TestBase.takeScreenshot("search program");
			util.waitUntillElementIsVisible(searchPage.andSearchFieldList.get(0));
			System.out.println(searchPage.andSearchFieldList.get(0).getText());
			searchPage.andSearchFieldList.get(0).click();
			Thread.sleep(Constants.shortWait);
			searchPage.andSearchFieldList.get(0).click();
			try {
				Assert.assertTrue(episodeDetailPage.VerifyEpisodePage(), "episode page is not displayed");
			} catch (Throwable e) {
				Reporter.log("episode page is not displayed");
				ErrorUtil.addVerificationFailure(e);
			}
		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {
			util.waitUntillElementIsVisible(searchPage.iOSSearchBtn);
			searchPage.iOSSearchBtn.click();
			util.waitUntillElementIsVisible(searchPage.iOSSearchTextField);
			searchPage.iOSSearchTextField.sendKeys("clev");
			TestBase.takeScreenshot("Episode page through search");
			util.waitUntillElementIsVisible(searchPage.iOSSearchFirstElement);
			searchPage.iOSSearchFirstElement.click();
			util.waitUntillElementIsVisible(episodeDetailPage.iOSEpisodePlayBtn);
			TestBase.takeScreenshot("Episode page");

			try {
				Assert.assertTrue(episodeDetailPage.iOSEpisodePlayBtn.isDisplayed(),
						"episode page play btn is not displayed");
			} catch (Throwable e) {
				Reporter.log("episode page play btn is not displayed");
				ErrorUtil.addVerificationFailure(e);
			}
		}

	}

	/**
	 * @Method: checkAddToWatchList
	 * @param:
	 * @Description:This method will check whether the watchlist text is
	 *                   changing on clicking on add to watchlist button
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test(groups = { "local", "aws" })
	public void checkAddToWatchList() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			util.waitUntillElementIsVisible(homePage.andEpisodeStory.get(1));
			homePage.andEpisodeStory.get(1).click();
			util.waitUntillElementIsVisible(episodeDetailPage.andEpisodeTitle);
			TestBase.takeScreenshot("EpisodeDetailPage");
			if (episodeDetailPage.andAddToWatchListBtn.getText().equals(Constants.addWatchlistText)) {

				episodeDetailPage.andAddToWatchListBtn.click();
				Thread.sleep(Constants.mediumWait);
			}
			TestBase.takeScreenshot("watchlistchangetext");

			try {
				Assert.assertTrue(episodeDetailPage.andAddToWatchListBtn.getText().equals(Constants.watchlistText),
						"Actual text is" + episodeDetailPage.andAddToWatchListBtn.getText() + "but expected text is "
								+ Constants.watchlistText);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + episodeDetailPage.andAddToWatchListBtn.getText()
						+ "but expected text is " + Constants.watchlistText);
				ErrorUtil.addVerificationFailure(e);
			}

		}

		if (TestBase.platform.equalsIgnoreCase("ios"))

		{
			util.swipeUp();
			util.waitUntillElementIsVisible(homePage.iOSSecondEpisode);
			homePage.iOSSecondEpisode.click();
			util.waitUntillElementIsVisible(episodeDetailPage.iOSEpisodeAddToWatchlistBtn);
			TestBase.takeScreenshot("EpisodeDetailPage");
			episodeDetailPage.iOSEpisodeAddToWatchlistBtn.click();
			util.waitUntillElementIsVisible(episodeDetailPage.iOSWatchlistOkBtn);
			episodeDetailPage.iOSWatchlistOkBtn.click();

			Thread.sleep(Constants.mediumWait);
			Thread.sleep(Constants.mediumWait);
			TestBase.takeScreenshot("watchlistchangetext");

			try {
				Assert.assertTrue(
						episodeDetailPage.iOSEpisodeInYourWatchListBtn.getText().equals(Constants.iOSWatchlistText),
						"Actual text is" + episodeDetailPage.iOSEpisodeAddToWatchlistBtn.getText()
								+ "but expected text is " + Constants.iOSWatchlistText);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + episodeDetailPage.iOSEpisodeAddToWatchlistBtn.getText()
						+ "but expected text is " + Constants.iOSWatchlistText);
				ErrorUtil.addVerificationFailure(e);
			}
		}

	}

	/**
	 * @Method: checkEpisodeToCategoryNavigation
	 * @param:
	 * @Description:This method will check whether the user is navigated to
	 *                   category page from episode page
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test(groups = { "local", "aws" })
	public void checkEpisodeToCategoryNavigation() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			util.waitUntillElementIsVisible(homePage.andEpisodeStory.get(1));
			homePage.andEpisodeStory.get(1).click();
			util.waitUntillElementIsVisible(episodeDetailPage.andEpisodeTitle);
			Thread.sleep(2000);
			TestBase.takeScreenshot("EpisodeDetailPage");

			String categoryTxt = episodeDetailPage.andEpisodeCategoryBtn.getText();
			episodeDetailPage.andEpisodeCategoryBtn.click();
			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);

			try {
				Assert.assertTrue(categoryPage.andCategoryHeadertxt.getText().equals(categoryTxt), "Actual category is"
						+ categoryTxt + "but it is navigated to " + categoryPage.andCategoryHeadertxt.getText());
			} catch (Throwable e) {
				Reporter.log("Actual category is" + categoryTxt + "but it is navigated to "
						+ categoryPage.andCategoryHeadertxt.getText());
				ErrorUtil.addVerificationFailure(e);
			}
			episodeDetailPage.andBackBtn.click();
			util.waitUntillElementIsVisible(episodeDetailPage.andEpisodeTitle);

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {
			util.swipeUp();
			util.waitUntillElementIsVisible(homePage.iOSSecondEpisode);
			homePage.iOSSecondEpisode.click();
			util.waitUntillElementIsVisible(episodeDetailPage.iOSEpisodeimage);
			System.out.println(episodeDetailPage.iOSEpisodeCategory.size());
			for (int i = 2; i < episodeDetailPage.iOSEpisodeCategory.size(); i++) {
				String categoryTxt = episodeDetailPage.iOSEpisodeCategory.get(i).getText();
				episodeDetailPage.iOSEpisodeCategory.get(i).click();
				util.waitUntillElementIsVisible(categoryPage.iOSCategoryHeading);
				TestBase.takeScreenshot("CategoryPage");

				try {
					Assert.assertTrue(categoryPage.iOSCategoryHeading.getText().equals(categoryTxt),
							"Actual category is" + categoryTxt + "but it is navigated to "
									+ categoryPage.iOSCategoryHeading.getText());
				} catch (Throwable e) {
					Reporter.log("Actual category is" + categoryTxt + "but it is navigated to "
							+ categoryPage.iOSCategoryHeading.getText());
					ErrorUtil.addVerificationFailure(e);
				}
				episodeDetailPage.iOSCategoryBackBtn.click();
				util.waitUntillElementIsVisible(episodeDetailPage.iOSEpisodeimage);
			}

		}

	}

	/**
	 * @Method: checkHomePageScrollInPotraitMode
	 * @param:
	 * @Description:This method will check whether the user is able to scroll up
	 *                   and down in potrait mode
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test(groups = { "local", "aws" })
	public void checkHomePageScrollInPotraitMode() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			// checking the scroll up
			util.waitUntillElementIsVisible(homePage.andEpisodeStory.get(0));
			for (int i = 0; i < 3; i++) {
				util.swipeUp();
				Thread.sleep(Constants.shortWait);
			}
			TestBase.takeScreenshot("Afterscrollingupinhomepage");

			boolean error = false;
			try {
				Assert.assertFalse(homePage.andEpisodeStory.get(0).isDisplayed(),
						"swipe up is not working in home page");
				error = true;
				throw new Exception("elementpresent");
			} catch (Throwable e) {
				if (error == true) {
					Reporter.log("swipe up is not working in home page");
					ErrorUtil.addVerificationFailure(e);
				}
			}

			// checking the scroll down

			for (int i = 0; i < 3; i++) {
				util.swipeDown();
				Thread.sleep(Constants.shortWait);
			}
			TestBase.takeScreenshot("Afterscrollingdowninhomepage");

			try {
				Assert.assertTrue(homePage.andEpisodeStory.get(0).isDisplayed(),
						"swipe down is not working in home page");
			} catch (Throwable e) {
				Reporter.log("swipe down is not working in home page");
				ErrorUtil.addVerificationFailure(e);
			}
		}

		if (TestBase.platform.equalsIgnoreCase("ios"))

		{

			util.waitUntillElementIsVisible(homePage.heroCardPlayBtn);

			for (int i = 0; i < 3; i++) {
				util.swipeUp();
				Thread.sleep(Constants.shortWait);
			}
			TestBase.takeScreenshot("Afterscrollingupinhomepage");

			boolean error = false;
			try {
				Assert.assertFalse(homePage.heroCardPlayBtn.isDisplayed(), "swipe up is not working in home page");
				error = true;
				throw new Exception("elementpresent");
			} catch (Throwable e) {
				if (error == true) {
					Reporter.log("swipe up is not working in home page");
					ErrorUtil.addVerificationFailure(e);
				}
			}

			// checking the scroll down

			for (int i = 0; i < 3; i++) {
				util.swipeDown();
				Thread.sleep(Constants.shortWait);
			}

			TestBase.takeScreenshot("Afterscrollingdowninhomepage");

			try {
				Assert.assertTrue(homePage.heroCardPlayBtn.isDisplayed(), "swipe down is not working in home page");
			} catch (Throwable e) {
				Reporter.log("swipe down is not working in home page");
				ErrorUtil.addVerificationFailure(e);
			}

		}

	}

	/**
	 * @Method: checkProgramsAzFeature
	 * @param:
	 * @Description:This method will check whether All Programs, CC, AD tabs are
	 *                   present or not in programsA-Z menu item.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test(groups = { "local", "aws" })
	public void checkProgramsAzFeature() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			util.waitUntillElementIsVisible(homePage.programsMenuItem);
			homePage.programsMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andProgramsAllProgramsTab);
			try {
				Assert.assertTrue(categoryPage.verifyProgramsTabs(),
						"Programs A-Z category page is not displayed properly");
			} catch (Throwable e) {
				Reporter.log("Programs A-Z category page is not displayed properly");
				ErrorUtil.addVerificationFailure(e);
			}
		}

		if (TestBase.platform.equalsIgnoreCase("ios"))

		{

			util.waitUntillElementIsVisible(homePage.iOSHomeMenuBtn);
			homePage.iOSHomeMenuBtn.click();
			util.waitUntillElementIsVisible(homePage.iOSProgramsAzMenuItem);
			homePage.iOSProgramsAzMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.iOSAllProgramsTab);
			try {
				Assert.assertTrue(categoryPage.verifyProgramsTabs(),
						"Programs A-Z category page is not displayed properly");
			} catch (Throwable e) {
				Reporter.log("Programs A-Z category page is not displayed properly");
				ErrorUtil.addVerificationFailure(e);
			}
		}

	}

	/**
	 * @Method: checkEpisodeDetails
	 * @param:
	 * @Description:This method will check whether the episode details is
	 *                   displaying or not
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test(groups = { "local", "aws" })
	public void checkEpisodeDetails() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			util.waitUntillElementIsVisible(homePage.andEpisodeStory.get(1));
			homePage.andEpisodeStory.get(1).click();
			util.waitUntillElementIsVisible(episodeDetailPage.andEpisodeTitle);
			TestBase.takeScreenshot("EpisodeDetailPage");

			try {
				Assert.assertTrue(episodeDetailPage.VerifyEpisodePage(),
						"Episode detail page is not displayed properly");
			} catch (Throwable e) {
				Reporter.log("Episode detail page is not displayed properly");
				ErrorUtil.addVerificationFailure(e);
			}

		}

		if (TestBase.platform.equalsIgnoreCase("ios"))

		{

		}

	}

	/**
	 * @Method: checkBrowseMenuItemsNavigation
	 * @param:
	 * @Description:This method will check whether the browse menu items are
	 *                   navigated to the correct category or not
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test(groups = { "local", "aws" })
	public void checkBrowseMenuItemsNavigation() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			util.waitUntillElementIsVisible(homePage.channel1MenuItem.get(0));
			homePage.channel1MenuItem.get(0).click();
			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(
						categoryPage.andCategoryHeadertxt.getText().equals(Constants.BrowseChannelsCategory[0]),
						"Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
								+ Constants.BrowseChannelsCategory[0]);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
						+ Constants.BrowseChannelsCategory[0]);
				ErrorUtil.addVerificationFailure(e);
			}

			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			util.waitUntillElementIsVisible(homePage.channel2MenuItem.get(0));
			homePage.channel2MenuItem.get(0).click();
			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(
						categoryPage.andCategoryHeadertxt.getText().equals(Constants.BrowseChannelsCategory[1]),
						"Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
								+ Constants.BrowseChannelsCategory[1]);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
						+ Constants.BrowseChannelsCategory[1]);
				ErrorUtil.addVerificationFailure(e);
			}

			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			util.waitUntillElementIsVisible(homePage.channel3MenuItem.get(0));
			homePage.channel3MenuItem.get(0).click();
			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(
						categoryPage.andCategoryHeadertxt.getText().equals(Constants.BrowseChannelsCategory[2]),
						"Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
								+ Constants.BrowseChannelsCategory[2]);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
						+ Constants.BrowseChannelsCategory[2]);
				ErrorUtil.addVerificationFailure(e);
			}

			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			util.waitUntillElementIsVisible(homePage.channel1MenuItem.get(1));
			homePage.channel1MenuItem.get(1).click();
			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(
						categoryPage.andCategoryHeadertxt.getText().equals(Constants.BrowseChannelsCategory[3]),
						"Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
								+ Constants.BrowseChannelsCategory[3]);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
						+ Constants.BrowseChannelsCategory[3]);
				ErrorUtil.addVerificationFailure(e);
			}

			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			util.waitUntillElementIsVisible(homePage.channel2MenuItem.get(1));
			homePage.channel2MenuItem.get(1).click();
			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(
						categoryPage.andCategoryHeadertxt.getText().equals(Constants.BrowseChannelsCategory[4]),
						"Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
								+ Constants.BrowseChannelsCategory[4]);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
						+ Constants.BrowseChannelsCategory[4]);
				ErrorUtil.addVerificationFailure(e);
			}

			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			util.waitUntillElementIsVisible(homePage.channel3MenuItem.get(1));
			homePage.channel3MenuItem.get(1).click();
			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(
						categoryPage.andCategoryHeadertxt.getText().equals(Constants.BrowseChannelsCategory[5]),
						"Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
								+ Constants.BrowseChannelsCategory[5]);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
						+ Constants.BrowseChannelsCategory[5]);
				ErrorUtil.addVerificationFailure(e);
			}

			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			util.waitUntillElementIsVisible(homePage.channel1MenuItem.get(2));
			homePage.channel1MenuItem.get(2).click();
			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(
						categoryPage.andCategoryHeadertxt.getText().equals(Constants.BrowseChannelsCategory[6]),
						"Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
								+ Constants.BrowseChannelsCategory[6]);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
						+ Constants.BrowseChannelsCategory[6]);
				ErrorUtil.addVerificationFailure(e);
			}

			// checking the category navigation items
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			util.waitUntillElementIsVisible(homePage.menuNavigationArrow.get(1));
			homePage.menuNavigationArrow.get(1).click();
			util.waitUntillElementIsVisible(homePage.artAndCultureMenuItem);
			homePage.artAndCultureMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(categoryPage.andCategoryHeadertxt.getText().equals(Constants.arts), "Actual text is"
						+ categoryPage.andCategoryHeadertxt.getText() + "but expected text is " + Constants.arts);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
						+ Constants.arts);
				ErrorUtil.addVerificationFailure(e);
			}

			// Navigate to comdey menu item
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			util.waitUntillElementIsVisible(homePage.comedyMenuItem);
			homePage.comedyMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(categoryPage.andCategoryHeadertxt.getText().equals(Constants.comedy), "Actual text is"
						+ categoryPage.andCategoryHeadertxt.getText() + "but expected text is " + Constants.comedy);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
						+ Constants.comedy);
				ErrorUtil.addVerificationFailure(e);
			}

			// Navigate to documentary menu item
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			util.waitUntillElementIsVisible(homePage.documentaryMenuItem);
			homePage.documentaryMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(categoryPage.andCategoryHeadertxt.getText().equals(Constants.documentary),
						"Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
								+ Constants.arts);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
						+ Constants.documentary);
				ErrorUtil.addVerificationFailure(e);
			}

			// Navigate to drama menu item
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			Thread.sleep(1000);

			// swiping up in order to compatabile with all screen sizes
			homePage.MenuSwipeUp();
			Thread.sleep(2000);

			util.waitUntillElementIsVisible(homePage.dramaMenuItem);
			homePage.dramaMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(categoryPage.andCategoryHeadertxt.getText().equals(Constants.drama), "Actual text is"
						+ categoryPage.andCategoryHeadertxt.getText() + "but expected text is " + Constants.arts);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
						+ Constants.drama);
				ErrorUtil.addVerificationFailure(e);
			}

			// Navigate to education menu item
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();

			Thread.sleep(1000);

			// swiping up in order to compatabile with all screen sizes
			homePage.MenuSwipeUp();
			Thread.sleep(2000);

			util.waitUntillElementIsVisible(homePage.educationMenuItem);
			homePage.educationMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(categoryPage.andCategoryHeadertxt.getText().equals(Constants.education),
						"Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
								+ Constants.arts);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
						+ Constants.education);
				ErrorUtil.addVerificationFailure(e);
			}

			// Navigate to lifestyle menu item
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			Thread.sleep(1000);

			// swiping up in order to compatabile with all screen sizes
			homePage.MenuSwipeUp();
			Thread.sleep(2000);
			util.waitUntillElementIsVisible(homePage.lifeStyleMenuItem);

			homePage.lifeStyleMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(categoryPage.andCategoryHeadertxt.getText().equals(Constants.lifestyle),
						"Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
								+ Constants.arts);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
						+ Constants.lifestyle);
				ErrorUtil.addVerificationFailure(e);
			}

			// Navigate to news and currentaffairs menu item
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			Thread.sleep(1000);

			// swiping up in order to compatabile with all screen sizes
			homePage.MenuSwipeUp();
			Thread.sleep(2000);
			util.waitUntillElementIsVisible(homePage.newsAndCurrentMenuItem);

			homePage.newsAndCurrentMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(categoryPage.andCategoryHeadertxt.getText().equals(Constants.newsAndAffairs),
						"Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
								+ Constants.arts);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
						+ Constants.newsAndAffairs);
				ErrorUtil.addVerificationFailure(e);
			}

			// Navigate to panel and discussion menu item
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			Thread.sleep(1000);

			// swiping up in order to compatabile with all screen sizes
			homePage.MenuSwipeUp();
			Thread.sleep(2000);
			util.waitUntillElementIsVisible(homePage.panelMenuItem);

			homePage.panelMenuItem.click();

			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(categoryPage.andCategoryHeadertxt.getText().equals(Constants.panelAndDiscussion),
						"Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
								+ Constants.arts);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
						+ Constants.panelAndDiscussion);
				ErrorUtil.addVerificationFailure(e);
			}

			// Navigate to sport menu item
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			Thread.sleep(1000);

			// swiping up in order to compatabile with all screen sizes
			homePage.MenuSwipeUp();
			Thread.sleep(2000);
			util.waitUntillElementIsVisible(homePage.sportMenuItem);

			homePage.sportMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andCategoryHeadertxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(categoryPage.andCategoryHeadertxt.getText().equals(Constants.sport), "Actual text is"
						+ categoryPage.andCategoryHeadertxt.getText() + "but expected text is " + Constants.arts);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andCategoryHeadertxt.getText() + "but expected text is "
						+ Constants.sport);
				ErrorUtil.addVerificationFailure(e);
			}

			// Navigate to programs a-z menu item
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			util.waitUntillElementIsVisible(homePage.menuNavigationArrow.get(1));
			homePage.menuNavigationArrow.get(1).click();
			util.waitUntillElementIsVisible(homePage.programsMenuItem);
			homePage.programsMenuItem.click();
			Thread.sleep(Constants.mediumWait);
			util.waitUntillElementIsVisible(categoryPage.andProgramsCategoryHeaderTxt);
			Thread.sleep(Constants.longWait);
			try {
				Assert.assertTrue(categoryPage.andProgramsCategoryHeaderTxt.getText().equals(Constants.programs),
						"Actual text is" + categoryPage.andProgramsCategoryHeaderTxt.getText() + "but expected text is "
								+ Constants.programs);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andProgramsCategoryHeaderTxt.getText()
						+ "but expected text is " + Constants.programs);
				ErrorUtil.addVerificationFailure(e);
			}

		}

		if (TestBase.platform.equalsIgnoreCase("ios"))

		{

		}

	}

	/**
	 * @Method: checkYourIviewMenuItemsNavigation
	 * @param:
	 * @Description:This method will check whether the yourivew menu items are
	 *                   navigating to the correct page or not
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test(groups = { "local", "aws" })
	public void checkYourIviewMenuItemsNavigation() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			// navigation to recently viewed page
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			util.waitUntillElementIsVisible(homePage.recentlyViewdMenuItem);
			homePage.recentlyViewdMenuItem.click();
			Thread.sleep(Constants.longWait);
			util.swipeDown();
			Thread.sleep(Constants.mediumWait);
			util.waitUntillElementIsVisible(categoryPage.andYourIviewRecentlyViewedTxt);
			TestBase.takeScreenshot("recently viewed");
			try {
				Assert.assertTrue(categoryPage.andYourIviewRecentlyViewedTxt.getText().equals(Constants.recentlyViewed),
						"Actual text is" + categoryPage.andYourIviewRecentlyViewedTxt.getText()
								+ "but expected text is " + Constants.recentlyViewed);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andYourIviewRecentlyViewedTxt.getText()
						+ "but expected text is " + Constants.recentlyViewed);
				ErrorUtil.addVerificationFailure(e);
			}

			// navigation to watchlist
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			// util.waitUntillElementIsVisible(homePage.menuNavigationArrow.get(0));
			// homePage.menuNavigationArrow.get(0).click();
			util.waitUntillElementIsVisible(homePage.watchListMenuItem);
			Thread.sleep(2000);
			homePage.watchListMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andYourIviewWatchListTxt);
			TestBase.takeScreenshot("watchlist");
			try {
				Assert.assertTrue(categoryPage.andYourIviewWatchListTxt.getText().contains(Constants.watchlist),
						"Actual text is" + categoryPage.andYourIviewWatchListTxt.getText()
								+ "but expected text should contain " + Constants.watchlist);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andYourIviewWatchListTxt.getText()
						+ "but expected text should contain " + Constants.watchlist);
				ErrorUtil.addVerificationFailure(e);
			}

			// check the navigation of parental filter
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();

			Thread.sleep(1000);

			// swiping up in order to compatabile with all screen sizes
			homePage.MenuSwipeUp();
			Thread.sleep(2000);

			util.waitUntillElementIsVisible(homePage.parentalFilterMenuItem);
			homePage.parentalFilterMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andYourIviewParentalFilterTxt);
			TestBase.takeScreenshot("parentalFilterPage");
			try {
				Assert.assertTrue(categoryPage.verifyParentalFilter(),
						"Parental Filter elements page is not displayed properly");
			} catch (Throwable e) {
				Reporter.log("Parental Filter elements page is not displayed properly");
				ErrorUtil.addVerificationFailure(e);
			}
			categoryPage.andParentalCloseBtn.click();

		}

		if (TestBase.platform.equalsIgnoreCase("ios"))

		{

		}

	}

	/**
	 * @Method: checkSupportMenuItemsNavigation
	 * @param:
	 * @Description:This method will check whether the support menu items are
	 *                   navigating to the correct page or not
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test(groups = { "local", "aws" })
	public void checkSupportMenuItemsNavigation() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			// navigation to announcements page
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			util.waitUntillElementIsVisible(homePage.menuNavigationArrow.get(0));
			homePage.menuNavigationArrow.get(0).click();
			util.waitUntillElementIsVisible(homePage.menuNavigationArrow.get(1));
			homePage.menuNavigationArrow.get(1).click();
			util.waitUntillElementIsVisible(homePage.menuNavigationArrow.get(2));
			homePage.menuNavigationArrow.get(2).click();
			util.waitUntillElementIsVisible(homePage.announcementsMenuItem);
			homePage.announcementsMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andSupportMenuItemHeader);
			TestBase.takeScreenshot("Announcments");
			try {
				Assert.assertTrue(categoryPage.andSupportMenuItemHeader.getText().equals(Constants.announcements),
						"Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
								+ "but expected text should contain " + Constants.announcements);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
						+ "but expected text should contain " + Constants.announcements);
				ErrorUtil.addVerificationFailure(e);
			}

			// navigation to about iview page
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();

			util.waitUntillElementIsVisible(homePage.aboutIviewMenuItem);
			homePage.aboutIviewMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andSupportMenuItemHeader);
			TestBase.takeScreenshot("about iview");
			try {
				Assert.assertTrue(categoryPage.andSupportMenuItemHeader.getText().equals(Constants.aboutIview),
						"Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
								+ "but expected text should contain " + Constants.aboutIview);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
						+ "but expected text should contain " + Constants.aboutIview);
				ErrorUtil.addVerificationFailure(e);
			}

			// navigation to where to get abc iview page
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();

			util.waitUntillElementIsVisible(homePage.whereToGetAbcIviewMenuItem);
			homePage.whereToGetAbcIviewMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andSupportMenuItemHeader);
			TestBase.takeScreenshot("whereToGetAbcIviewMenuItem");
			try {
				Assert.assertTrue(categoryPage.andSupportMenuItemHeader.getText().equals(Constants.whereToGetABCIview),
						"Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
								+ "but expected text should contain " + Constants.whereToGetABCIview);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
						+ "but expected text should contain " + Constants.whereToGetABCIview);
				ErrorUtil.addVerificationFailure(e);
			}

			// navigation to how to use abc iview page
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();

			util.waitUntillElementIsVisible(homePage.howToUseAbcIviewMenuItem);
			homePage.howToUseAbcIviewMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andSupportMenuItemHeader);
			TestBase.takeScreenshot("about iview");
			try {
				Assert.assertTrue(categoryPage.andSupportMenuItemHeader.getText().equals(Constants.howToUseABCIview),
						"Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
								+ "but expected text should contain " + Constants.howToUseABCIview);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
						+ "but expected text should contain " + Constants.howToUseABCIview);
				ErrorUtil.addVerificationFailure(e);
			}

			// navigation to faqs and help page
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();

			util.waitUntillElementIsVisible(homePage.faqaAndHelpMenuItem);
			homePage.faqaAndHelpMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andSupportMenuItemHeader);
			TestBase.takeScreenshot("about iview");
			try {
				Assert.assertTrue(categoryPage.andSupportMenuItemHeader.getText().equals(Constants.faqsAndHelp),
						"Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
								+ "but expected text should contain " + Constants.faqsAndHelp);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
						+ "but expected text should contain " + Constants.faqsAndHelp);
				ErrorUtil.addVerificationFailure(e);
			}

			// navigation to live streaming page
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();

			Thread.sleep(1000);

			// swiping up in order to compatabile with all screen sizes
			homePage.MenuSwipeUp();
			Thread.sleep(2000);

			util.waitUntillElementIsVisible(homePage.liveStreamingMenuItem);
			homePage.liveStreamingMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andSupportMenuItemHeader);
			TestBase.takeScreenshot("about iview");
			try {
				Assert.assertTrue(categoryPage.andSupportMenuItemHeader.getText().equals(Constants.liveStreaming),
						"Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
								+ "but expected text should contain " + Constants.liveStreaming);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
						+ "but expected text should contain " + Constants.liveStreaming);
				ErrorUtil.addVerificationFailure(e);
			}

			// navigation to chromecast page
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();

			Thread.sleep(1000);

			// swiping up in order to compatabile with all screen sizes
			homePage.MenuSwipeUp();
			Thread.sleep(2000);

			util.waitUntillElementIsVisible(homePage.chromeCastMenuItem);
			homePage.chromeCastMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andSupportMenuItemHeader);
			TestBase.takeScreenshot("about iview");
			try {
				Assert.assertTrue(categoryPage.andSupportMenuItemHeader.getText().equals(Constants.chromeCast),
						"Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
								+ "but expected text should contain " + Constants.chromeCast);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
						+ "but expected text should contain " + Constants.chromeCast);
				ErrorUtil.addVerificationFailure(e);
			}

			// navigation to iview on free view plus page
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();

			Thread.sleep(1000);

			// swiping up in order to compatabile with all screen sizes
			homePage.MenuSwipeUp();
			Thread.sleep(2000);

			util.waitUntillElementIsVisible(homePage.iviewOnFreeViewPlusMenuItem);
			homePage.iviewOnFreeViewPlusMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andSupportMenuItemHeader);
			TestBase.takeScreenshot("about iview");
			try {
				Assert.assertTrue(categoryPage.andSupportMenuItemHeader.getText().equals(Constants.iviewOnFreeViewPlus),
						"Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
								+ "but expected text should contain " + Constants.iviewOnFreeViewPlus);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
						+ "but expected text should contain " + Constants.iviewOnFreeViewPlus);
				ErrorUtil.addVerificationFailure(e);
			}

			// navigation to links to buy page
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			Thread.sleep(1000);

			// swiping up in order to compatabile with all screen sizes
			homePage.MenuSwipeUp();
			util.waitUntillElementIsVisible(homePage.linksToBuyMenuItem);

			homePage.linksToBuyMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andSupportMenuItemHeader);
			TestBase.takeScreenshot("about iview");
			try {
				Assert.assertTrue(categoryPage.andSupportMenuItemHeader.getText().equals(Constants.linksToBuy),
						"Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
								+ "but expected text should contain " + Constants.linksToBuy);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
						+ "but expected text should contain " + Constants.linksToBuy);
				ErrorUtil.addVerificationFailure(e);
			}

			// navigation to audio description page
			/*
			 * util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			 * homePage.HomeMenu.get(0).click();
			 * 
			 * util.waitUntillElementIsVisible(homePage.audioDescriptionMenuItem
			 * ); homePage.audioDescriptionMenuItem.click();
			 * util.waitUntillElementIsVisible(categoryPage.
			 * andSupportMenuItemHeader); TestBase.takeScreenshot("about iview"
			 * ); try {
			 * Assert.assertTrue(categoryPage.andSupportMenuItemHeader.getText()
			 * .equals(Constants.audioDescription), "Actual text is" +
			 * categoryPage.andSupportMenuItemHeader.getText() +
			 * "but expected text should contain " +
			 * Constants.audioDescription); } catch (Throwable e) {
			 * Reporter.log("Actual text is" +
			 * categoryPage.andSupportMenuItemHeader.getText() +
			 * "but expected text should contain " +
			 * Constants.audioDescription); ErrorUtil.addVerificationFailure(e);
			 * }
			 */

			// navigation abc iview terms of use page
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			Thread.sleep(1000);

			// swiping up in order to compatabile with all screen sizes
			homePage.MenuSwipeUp();
			util.waitUntillElementIsVisible(homePage.abcIviewTermsOfUseMenuItem);

			homePage.abcIviewTermsOfUseMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andSupportMenuItemHeader);
			TestBase.takeScreenshot("about iview");
			try {
				Assert.assertTrue(
						categoryPage.andSupportMenuItemHeader.getText().contains(Constants.abcIviewTermsOfUse),
						"Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
								+ "but expected text should contain " + Constants.abcIviewTermsOfUse);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
						+ "but expected text should contain " + Constants.abcIviewTermsOfUse);
				ErrorUtil.addVerificationFailure(e);
			}

			// navigation to iview acess guidelines of use page
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			Thread.sleep(1000);

			// swiping up in order to compatabile with all screen sizes
			homePage.MenuSwipeUp();
			util.waitUntillElementIsVisible(homePage.iviewAcessGuidelinesMenuItem);

			homePage.iviewAcessGuidelinesMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andSupportMenuItemHeader);
			TestBase.takeScreenshot("about iview");
			try {
				Assert.assertTrue(
						categoryPage.andSupportMenuItemHeader.getText().contains(Constants.iviewAcessGuidelines),
						"Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
								+ "but expected text should contain " + Constants.iviewAcessGuidelines);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
						+ "but expected text should contain " + Constants.iviewAcessGuidelines);
				ErrorUtil.addVerificationFailure(e);
			}

			// navigation to high quality page
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			Thread.sleep(1000);

			// swiping up in order to compatabile with all screen sizes
			homePage.MenuSwipeUp();
			util.waitUntillElementIsVisible(homePage.highQualityVideoMenuItem);

			homePage.highQualityVideoMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andSupportMenuItemHeader);
			TestBase.takeScreenshot("about iview");
			try {
				Assert.assertTrue(categoryPage.andSupportMenuItemHeader.getText().contains(Constants.highQualityVideo),
						"Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
								+ "but expected text should contain " + Constants.highQualityVideo);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andSupportMenuItemHeader.getText()
						+ "but expected text should contain " + Constants.highQualityVideo);
				ErrorUtil.addVerificationFailure(e);
			}

			// navigation to acessiblity troubleshooting and faqs page
			/*
			 * util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			 * homePage.HomeMenu.get(0).click();
			 * 
			 * util.waitUntillElementIsVisible(homePage.
			 * accessbilityTroubleshootingMenuItem);
			 * homePage.accessbilityTroubleshootingMenuItem.click();
			 * util.waitUntillElementIsVisible(categoryPage.
			 * andSupportMenuItemHeader); TestBase.takeScreenshot("about iview"
			 * ); try {
			 * Assert.assertTrue(categoryPage.andSupportMenuItemHeader.getText()
			 * .contains(Constants.accessbility), "Actual text is" +
			 * categoryPage.andSupportMenuItemHeader.getText() +
			 * "but expected text should contain " + Constants.accessbility); }
			 * catch (Throwable e) { Reporter.log("Actual text is" +
			 * categoryPage.andSupportMenuItemHeader.getText() +
			 * "but expected text should contain " + Constants.accessbility);
			 * ErrorUtil.addVerificationFailure(e); }
			 */

		}

		if (TestBase.platform.equalsIgnoreCase("ios"))

		{

		}

	}

	/**
	 * @Method: checkMoreMenuItemsNavigation
	 * @param:
	 * @Description:This method will check whether the more menu items are
	 *                   navigating to the correct page or not
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test(groups = { "local", "aws" })
	public void checkMoreMenuItemsNavigation() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			// navigation to more abc page
			util.waitUntillElementIsVisible(homePage.HomeMenu.get(0));
			homePage.HomeMenu.get(0).click();
			util.waitUntillElementIsVisible(homePage.menuNavigationArrow.get(0));
			homePage.menuNavigationArrow.get(0).click();
			util.waitUntillElementIsVisible(homePage.menuNavigationArrow.get(1));
			homePage.menuNavigationArrow.get(1).click();
			util.waitUntillElementIsVisible(homePage.menuNavigationArrow.get(3));
			homePage.menuNavigationArrow.get(3).click();
			util.waitUntillElementIsVisible(homePage.moreAbcMenuItem);
			homePage.moreAbcMenuItem.click();
			util.waitUntillElementIsVisible(categoryPage.andMoreAbc);
			TestBase.takeScreenshot("More ABC");
			try {
				Assert.assertTrue(categoryPage.andMoreAbc.getText().contains(Constants.moreABC), "Actual text is"
						+ categoryPage.andMoreAbc.getText() + "but expected text should contain " + Constants.moreABC);
			} catch (Throwable e) {
				Reporter.log("Actual text is" + categoryPage.andMoreAbc.getText() + "but expected text should contain "
						+ Constants.moreABC);
				ErrorUtil.addVerificationFailure(e);
			}

		}

		if (TestBase.platform.equalsIgnoreCase("ios"))

		{

		}

	}

	@AfterMethod(alwaysRun = true)
	public void after() throws Exception {
		afterMethod();
	}

}
