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

import com.abc.pages.HomePage;
import com.abc.pages.ProfilePage;
import com.abc.pages.SettingsPage;
import com.abc.pages.ShowCollectionScreenPage;
import com.abc.util.Constants;
import com.abc.util.ErrorUtil;
import com.abc.util.Util;

@Listeners({ com.abc.listener.TestListenerAdapter.class })
public class AbcMeTest extends TestBase {

	Util util;
	HomePage homePage;
	SettingsPage settingsPage;
	ProfilePage profilePage;
	ShowCollectionScreenPage showCollectionScreenPage;

	@BeforeMethod(alwaysRun = true)
	public void before() throws IOException {
		beforeMethod();
		util = new Util();
		homePage = new HomePage(TestBase.getDriver());
		settingsPage = new SettingsPage(TestBase.getDriver());
		profilePage = new ProfilePage(TestBase.getDriver());
		showCollectionScreenPage = new ShowCollectionScreenPage(TestBase.getDriver());
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	/**
	 * @Method: checkSettingsMenu
	 * @param:
	 * @Description:This method will check about abc me,info for parents,faqs
	 *                   and privacy and terms of use
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */

	@Test
	public void checkSettingsMenu() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

			// clicking on about abc me
			settingsPage.andSettingsMenu.click();
			util.waitUntillElementIsVisible(settingsPage.andAboutAbcMe);
			settingsPage.andAboutAbcMe.click();
			/*
			 * Thread.sleep(5000); //
			 * util.waitUntillElementIsVisible(settingsPage.
			 * settingsMenuPageHeading); Set<String> availableContexts =
			 * driver.getContextHandles(); for (String contexts :
			 * availableContexts) { System.out.println("Context Name is " +
			 * contexts); if (contexts.contains("WEBVIEW")) {
			 * System.out.println("Context Name is " + contexts);
			 * ((AndroidDriver) driver).context(contexts); break; } } //
			 * driver.context((String) availableContexts.toArray()[1]);
			 * Thread.sleep(5000);
			 * 
			 * // ((AndroidDriver) driver).context("WEBVIEW_1");
			 * System.out.println("output is" +
			 * settingsPage.settingsMenuPageHeading.getText());
			 * 
			 * try {
			 * Assert.assertTrue(settingsPage.settingsMenuPageHeading.getText().
			 * equals(Constants.aboutAbcMe),
			 * settingsPage.settingsMenuPageHeading.getText() +
			 * " is not matching with the expected heading" +
			 * Constants.aboutAbcMe); } catch (Exception e) {
			 * Reporter.log(settingsPage.settingsMenuPageHeading.getText() +
			 * " is not matching with the expected heading" +
			 * Constants.aboutAbcMe); ErrorUtil.addVerificationFailure(e);
			 * 
			 * }
			 */
			settingsPage.andSettingsClose.click();
			util.waitUntillElementIsVisible(settingsPage.andSettingsMenu);

			// clicking on information for parents
			settingsPage.andSettingsMenu.click();
			util.waitUntillElementIsVisible(settingsPage.andInformationForParents);
			settingsPage.andInformationForParents.click();
			util.waitUntillElementIsVisible(settingsPage.settingsMenuPageHeading);

			try {
				Assert.assertTrue(
						settingsPage.settingsMenuPageHeading.getText().equals(Constants.informationForParents),
						settingsPage.settingsMenuPageHeading.getText() + " is not matching with the expected heading"
								+ Constants.informationForParents);
			} catch (Exception e) {
				Reporter.log(settingsPage.settingsMenuPageHeading.getText()
						+ " is not matching with the expected heading" + Constants.informationForParents);
				ErrorUtil.addVerificationFailure(e);

			}

			settingsPage.andSettingsClose.click();
			util.waitUntillElementIsVisible(settingsPage.andSettingsMenu);

			// clicking on faqs
			settingsPage.andSettingsMenu.click();
			util.waitUntillElementIsVisible(settingsPage.andFaqs);
			settingsPage.andFaqs.click();
			util.waitUntillElementIsVisible(settingsPage.settingsMenuPageHeading);

			try {
				Assert.assertTrue(settingsPage.settingsMenuPageHeading.getText().equals(Constants.faqs),
						settingsPage.settingsMenuPageHeading.getText() + " is not matching with the expected heading"
								+ Constants.faqs);
			} catch (Exception e) {
				Reporter.log(settingsPage.settingsMenuPageHeading.getText()
						+ " is not matching with the expected heading" + Constants.faqs);
				ErrorUtil.addVerificationFailure(e);

			}

			settingsPage.andSettingsClose.click();
			util.waitUntillElementIsVisible(settingsPage.andSettingsMenu);

			// clicking on privacy and terms of use
			settingsPage.andSettingsMenu.click();
			util.waitUntillElementIsVisible(settingsPage.andParentSettingsMenuItem);
			settingsPage.andParentSettingsMenuItem.click();
			util.waitUntillElementIsVisible(settingsPage.settingsMenuPageHeading);

			try {
				Assert.assertTrue(settingsPage.settingsMenuPageHeading.getText().equals(Constants.privacyAndTermsOfUse),
						settingsPage.settingsMenuPageHeading.getText() + " is not matching with the expected heading"
								+ Constants.privacyAndTermsOfUse);
			} catch (Exception e) {
				Reporter.log(settingsPage.settingsMenuPageHeading.getText()
						+ " is not matching with the expected heading" + Constants.privacyAndTermsOfUse);
				ErrorUtil.addVerificationFailure(e);

			}

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

			// clicking on about abc me
			util.waitUntillElementIsVisible(settingsPage.iosSettingsMenu);
			settingsPage.iosSettingsMenu.click();
			util.waitUntillElementIsVisible(settingsPage.iosAboutAbcMe);
			settingsPage.iosAboutAbcMe.click();
			util.waitUntillElementIsVisible(settingsPage.iosSettingsMenuPageHeading);
			TestBase.takeScreenshot("Abc me Page");
			Thread.sleep(Constants.shortWait);
			try {
				Assert.assertTrue(settingsPage.iosSettingsMenuPageHeading.getText().contains(Constants.aboutAbcMe),
						settingsPage.iosSettingsMenuPageHeading.getText() + " is not matching with the expected heading"
								+ Constants.aboutAbcMe);
			} catch (Exception e) {
				Reporter.log(settingsPage.iosSettingsMenuPageHeading.getText()
						+ " is not matching with the expected heading" + Constants.aboutAbcMe);
				ErrorUtil.addVerificationFailure(e);

			}

			settingsPage.iosSettingsClose.click();
			util.waitUntillElementIsVisible(settingsPage.iosSettingsMenu);

			// clicking on information for parents
			settingsPage.iosSettingsMenu.click();
			util.waitUntillElementIsVisible(settingsPage.iosInformationForParents);
			settingsPage.iosInformationForParents.click();
			util.waitUntillElementIsVisible(settingsPage.iosSettingsMenuPageHeading);
			TestBase.takeScreenshot("Information for parents page");

			try {
				Assert.assertTrue(
						settingsPage.iosSettingsMenuPageHeading.getText().contains(Constants.informationForParents),
						settingsPage.iosSettingsMenuPageHeading.getText() + " is not matching with the expected heading"
								+ Constants.informationForParents);
			} catch (Exception e) {
				Reporter.log(settingsPage.iosSettingsMenuPageHeading.getText()
						+ " is not matching with the expected heading" + Constants.informationForParents);
				ErrorUtil.addVerificationFailure(e);

			}

			settingsPage.iosSettingsClose.click();
			util.waitUntillElementIsVisible(settingsPage.iosSettingsMenu);

			// clicking on faqs
			settingsPage.iosSettingsMenu.click();
			util.waitUntillElementIsVisible(settingsPage.iosFaqs);
			settingsPage.iosFaqs.click();
			util.waitUntillElementIsVisible(settingsPage.iosSettingsMenuPageHeading);
			TestBase.takeScreenshot("faqs page");

			try {
				Assert.assertTrue(settingsPage.iosSettingsMenuPageHeading.getText().contains(Constants.faqs),
						settingsPage.iosSettingsMenuPageHeading.getText() + " is not matching with the expected heading"
								+ Constants.faqs);
			} catch (Exception e) {
				Reporter.log(settingsPage.iosSettingsMenuPageHeading.getText()
						+ " is not matching with the expected heading" + Constants.faqs);
				ErrorUtil.addVerificationFailure(e);

			}

			settingsPage.iosSettingsClose.click();
			util.waitUntillElementIsVisible(settingsPage.iosSettingsMenu);

			// clicking on privacy and terms of use
			settingsPage.iosSettingsMenu.click();
			util.waitUntillElementIsVisible(settingsPage.iosPrivacyAndTerms);
			settingsPage.iosPrivacyAndTerms.click();
			util.waitUntillElementIsVisible(settingsPage.iosSettingsMenuPageHeading);
			TestBase.takeScreenshot("privacy and terms of use page");

			try {
				Assert.assertTrue(
						settingsPage.iosSettingsMenuPageHeading.getText().contains(Constants.privacyAndTermsOfUse),
						settingsPage.iosSettingsMenuPageHeading.getText() + " is not matching with the expected heading"
								+ Constants.privacyAndTermsOfUse);
			} catch (Exception e) {
				Reporter.log(settingsPage.iosSettingsMenuPageHeading.getText()
						+ " is not matching with the expected heading" + Constants.privacyAndTermsOfUse);
				ErrorUtil.addVerificationFailure(e);

			}

		}

	}

	/**
	 * @Method: checkHomeScreenPage
	 * @param:
	 * @Description:This method will check whether home screen elements like
	 *                   myshows,explore,all shows,avatar and settings menu is
	 *                   displayed or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */

	@Test
	public void checkHomeScreenPage() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {
			util.waitUntillElementIsVisible(homePage.iosAllShowsBtn);
			util.waitUntillElementIsVisible(homePage.iosExploreBtn);
			util.waitUntillElementIsVisible(homePage.iosMyShowsBtn);
			util.waitUntillElementIsVisible(profilePage.iosAvatar);
			util.waitUntillElementIsVisible(settingsPage.iosSettingsMenu);
			TestBase.takeScreenshot("HomeScreenPage");

			Assert.assertTrue(
					homePage.iosAllShowsBtn.isDisplayed() && homePage.iosExploreBtn.isDisplayed()
							&& homePage.iosMyShowsBtn.isDisplayed() && profilePage.iosAvatar.isDisplayed()
							&& settingsPage.iosSettingsMenu.isDisplayed(),
					"some of the home screen elements are missing");

		}

	}

	/**
	 * @Method: checkShowScreenPage
	 * @param:
	 * @Description:This method will check whether all the show screen elements
	 *                   are displaying or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test
	public void checkShowScreenPage() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {
			util.waitUntillElementIsVisible(homePage.iosPopularEpisode);
			homePage.iosPopularEpisode.click();
			util.waitUntillElementIsVisible(showCollectionScreenPage.iosFirstEpisode);
			showCollectionScreenPage.iosFirstEpisode.click();
			util.waitUntillElementIsVisible(showCollectionScreenPage.iosSeriesImage);
			TestBase.takeScreenshot("showScreenPage");

			Assert.assertTrue(showCollectionScreenPage.verifyShowScreenPage(),
					"some of the show screen elements are missing");

		}

	}

	/**
	 * @Method: checkShowScreenEpisodeCount
	 * @param:
	 * @Description:This method will check whether all the show screen episode
	 *                   count is matching with the no:of displayed episodes.
	 * 
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test
	public void checkShowScreenEpisodeCount() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {
			util.waitUntillElementIsVisible(homePage.iosPopularEpisode);
			homePage.iosPopularEpisode.click();
			util.waitUntillElementIsVisible(showCollectionScreenPage.iosEpisodes);
			Assert.assertTrue(showCollectionScreenPage.verifyCollectionShowScreenEpisodeCount(),
					"show screen episode count is not matching with the no:of the episodes");

		}

	}

	/**
	 * @Method: checkCollectionScreenPage
	 * @param:
	 * @Description:This method will check whether all the collection screen
	 *                   elements are displaying or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test
	public void checkCollectionScreenPage() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {

			util.waitUntillElementIsVisible(homePage.iosExploreBtn);
			homePage.iosExploreBtn.click();
			util.waitUntillElementIsVisible(homePage.iosOurPicksEpisode);
			homePage.iosOurPicksEpisode.click();
			util.waitUntillElementIsVisible(showCollectionScreenPage.iosFirstEpisode);
			showCollectionScreenPage.iosFirstEpisode.click();
			util.waitUntillElementIsVisible(showCollectionScreenPage.iosSeriesImage);

			TestBase.takeScreenshot("collectionScreenPage");

			Assert.assertTrue(showCollectionScreenPage.verifyCollectionScreenPage(),
					"some of the collection screen elements are missing");

		}

	}

	/**
	 * @Method: checkCollectionScreenEpisodeCount
	 * @param:
	 * @Description:This method will check whether all the collection screen
	 *                   episode count is matching with the no:of displayed
	 *                   episodes.
	 * 
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test
	public void checkCollectionScreenEpisodeCount() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {
			util.waitUntillElementIsVisible(homePage.iosExploreBtn);
			homePage.iosExploreBtn.click();
			util.waitUntillElementIsVisible(homePage.iosOurPicksEpisode);
			homePage.iosOurPicksEpisode.click();
			util.waitUntillElementIsVisible(showCollectionScreenPage.iosEpisodes);
			Assert.assertTrue(showCollectionScreenPage.verifyCollectionShowScreenEpisodeCount(),
					"collection screen episode count is not matching with the no:of the episodes");

		}

	}

	/**
	 * @Method: checkChangeAvatar
	 * @param:
	 * @Description:This method will check whether the avatar has been changed
	 *                   or not.
	 * 
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test
	public void checkChangeAvatar() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {
			util.waitUntillElementIsVisible(profilePage.iosAvatar);
			profilePage.iosAvatar.click();
			// util.waitUntillElementIsVisible(profilePage.iosChangeAvatar);
			// profilePage.iosChangeAvatar.click();
			util.waitUntillElementIsVisible(profilePage.iosAvatarCarousel);
			Dimension size = driver.manage().window().getSize();
			int x2 = (int) (size.getWidth() * 0.2);
			int x1 = size.getWidth() / 2;
			int y = (size.getHeight()) / 2;
			TestBase.getDriver().swipe(x1, y, x2, y, 1000);
			Thread.sleep(5000);
			TestBase.takeScreenshot("avatarScroll");
			profilePage.iosMyProfileCloseBtn.click();
			util.waitUntillElementIsVisible(profilePage.iosAvatar);

			Assert.assertTrue(profilePage.iosAvatar.isDisplayed(), "Avatar is not displayed");

		}

	}

	/**
	 * @Method: checkChangeAvatarPage
	 * @param:
	 * @Description:This method will check whether all the change avatar
	 *                   elements are present or not.
	 * 
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test
	public void checkChangeAvatarPage() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {
			util.waitUntillElementIsVisible(profilePage.iosAvatar);
			profilePage.iosAvatar.click();
			TestBase.takeScreenshot("changeAvatarPage");
			// verify pick an avatar text
			try {
				Assert.assertTrue(profilePage.iosPickAvatarTxt.getText().equals(Constants.pickAvatarTxt),
						"pick an avatar actual text is" + profilePage.iosPickAvatarTxt.getText()
								+ "but expected text is" + Constants.pickAvatarTxt);

			} catch (Exception e) {
				Reporter.log("pick an avatar actual text is" + profilePage.iosPickAvatarTxt.getText()
						+ "but expected text is" + Constants.pickAvatarTxt);
				ErrorUtil.addVerificationFailure(e);
			}

			// verify pick a colour text
			try {
				Assert.assertTrue(profilePage.iosPickColour.getText().equals(Constants.pickColourTxt),
						"pick an avatar actual text is" + profilePage.iosPickColour.getText() + "but expected text is"
								+ Constants.pickColourTxt);

			} catch (Exception e) {
				Reporter.log("pick an avatar actual text is" + profilePage.iosPickColour.getText()
						+ "but expected text is" + Constants.pickColourTxt);
				ErrorUtil.addVerificationFailure(e);
			}

			// verifying change avatar page elements.
			try {
				Assert.assertTrue(profilePage.verifyChangeAvatarPage(),
						"some of the elemnents in the change avatar page is missing");
			} catch (Exception e) {
				Reporter.log("some of the elemnents in the change avatar page is missing");
				ErrorUtil.addVerificationFailure(e);

			}
		}

	}

	/**
	 * @Method: checkChangeNamePage
	 * @param:
	 * @Description:This method will check whether all the change name page
	 *                   elements are present or not.
	 * 
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test
	public void checkChangeNamePage() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {
			util.waitUntillElementIsVisible(profilePage.iosAvatar);
			profilePage.iosAvatar.click();
			util.waitUntillElementIsVisible(profilePage.iosMyProfileChangeName);
			profilePage.iosMyProfileChangeName.click();
			util.waitUntillElementIsVisible(profilePage.iosEnterNameFieldTxt);
			TestBase.takeScreenshot("changeNamePage");

			// verify name your avatar text
			try {
				Assert.assertTrue(profilePage.iosEnterNameFieldTxt.getText().equals(Constants.nameAvatarTxt),
						"pick an avatar actual text is" + profilePage.iosEnterNameFieldTxt.getText()
								+ "but expected text is" + Constants.nameAvatarTxt);

			} catch (Exception e) {
				Reporter.log("pick an avatar actual text is" + profilePage.iosEnterNameFieldTxt.getText()
						+ "but expected text is" + Constants.nameAvatarTxt);
				ErrorUtil.addVerificationFailure(e);
			}

			// verifying change name page elements.
			try {
				Assert.assertTrue(profilePage.verifyChangeNamePage(),
						"some of the elemnents in the change avatar page is missing");
			} catch (Exception e) {
				Reporter.log("some of the elemnents in the change avatar page is missing");
				ErrorUtil.addVerificationFailure(e);

			}
		}

	}

	/**
	 * @Method: checkShowToAddToMyShows
	 * @param:
	 * @Description:This method will check whether the show is added to my shows
	 *                   or not.
	 * 
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test
	public void checkShowToAddToMyShows() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {
			util.waitUntillElementIsVisible(homePage.iosPopularEpisode);
			homePage.iosPopularEpisode.click();
			Thread.sleep(Constants.mediumWait);
			util.waitUntillElementIsVisible(showCollectionScreenPage.iosFirstEpisode);
			showCollectionScreenPage.iosFirstEpisode.click();
			util.waitUntillElementIsVisible(showCollectionScreenPage.iosAddToMyShowBtn);
			showCollectionScreenPage.iosAddToMyShowBtn.click();
			Thread.sleep(Constants.mediumWait);

			// verifying added to my shows text
			try {
				Assert.assertTrue(
						showCollectionScreenPage.iosAddToMyShowBtn.getText().equals(Constants.addedToMyShowsTxt),
						"Add to my shows text is not updated with added to my shows");
			} catch (Throwable e) {
				Reporter.log("Add to my shows text is not updated with added to my shows");
				ErrorUtil.addVerificationFailure(e);

			}

			String showTitle = showCollectionScreenPage.iosShowTitle.getText();

			showCollectionScreenPage.iosBackBtn.click();
			util.waitUntillElementIsVisible(showCollectionScreenPage.iosBackBtn);
			showCollectionScreenPage.iosBackBtn.click();
			util.waitUntillElementIsVisible(homePage.iosAddToMyShowsCollection.get(0));

			TestBase.takeScreenshot("showaddingtomyshows");
			// verifying show is added to my shows
			try {
				Assert.assertTrue(homePage.iosAddToMyShowsCollection.get(0).getText().equals(showTitle),
						"show is not added to my shows");
			} catch (Exception e) {
				Reporter.log("show is not added to my shows");
				ErrorUtil.addVerificationFailure(e);

			}

			// removing it from my shows
			util.waitUntillElementIsVisible(homePage.iosPopularEpisode);
			homePage.iosPopularEpisode.click();
			util.waitUntillElementIsVisible(showCollectionScreenPage.iosFirstEpisode);
			showCollectionScreenPage.iosFirstEpisode.click();
			util.waitUntillElementIsVisible(showCollectionScreenPage.iosAddToMyShowBtn);
			showCollectionScreenPage.iosAddToMyShowBtn.click();

		}
	}

	/**
	 * @Method: checkCollectionToAddToMyShows
	 * @param:
	 * @Description:This method will check whether the show is added to my shows
	 *                   or not.
	 * 
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	@Test
	public void checkCollectionToAddToMyShows() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {
			util.waitUntillElementIsVisible(homePage.iosExploreBtn);
			homePage.iosExploreBtn.click();
			util.waitUntillElementIsVisible(homePage.iosOurPicksEpisode);
			homePage.iosOurPicksEpisode.click();
			Thread.sleep(Constants.mediumWait);
			util.waitUntillElementIsVisible(showCollectionScreenPage.iosFirstEpisode);
			showCollectionScreenPage.iosFirstEpisode.click();
			util.waitUntillElementIsVisible(showCollectionScreenPage.iosAddToMyShowBtn);
			showCollectionScreenPage.iosAddToMyShowBtn.click();
			Thread.sleep(Constants.mediumWait);

			// verifying added to my shows text
			try {
				Assert.assertTrue(
						showCollectionScreenPage.iosAddToMyShowBtn.getText().equals(Constants.addedToMyShowsTxt),
						"Add to my shows text is not updated with added to my shows");
			} catch (Exception e) {
				Reporter.log("Add to my shows text is not updated with added to my shows");
				ErrorUtil.addVerificationFailure(e);

			}

			String showTitle = showCollectionScreenPage.iosShowTitle.getText();

			showCollectionScreenPage.iosBackBtn.click();
			util.waitUntillElementIsVisible(showCollectionScreenPage.iosBackBtn);
			showCollectionScreenPage.iosBackBtn.click();
			util.waitUntillElementIsVisible(homePage.iosExploreBtn);
			homePage.iosMyShowsBtn.click();
			util.waitUntillElementIsVisible(homePage.iosAddToMyShowsCollection.get(0));

			TestBase.takeScreenshot("collectionaddingtomyshows");
			// verifying show is added to my shows
			try {
				Assert.assertTrue(homePage.iosAddToMyShowsCollection.get(0).getText().equals(showTitle),
						"show is not added to my shows actual text is "
								+ homePage.iosAddToMyShowsCollection.get(0).getText() + "expected text is" + showTitle);
			} catch (Exception e) {
				Reporter.log("show is not added to my shows");
				ErrorUtil.addVerificationFailure(e);

			}
			util.waitUntillElementIsVisible(homePage.iosOurPicksEpisode);
			homePage.iosOurPicksEpisode.click();
			util.waitUntillElementIsVisible(showCollectionScreenPage.iosFirstEpisode);
			showCollectionScreenPage.iosFirstEpisode.click();
			util.waitUntillElementIsVisible(showCollectionScreenPage.iosAddToMyShowBtn);
			showCollectionScreenPage.iosAddToMyShowBtn.click();

		}
	}

	@AfterMethod(alwaysRun = true)
	public void after() throws Exception {
		afterMethod();
	}

}
