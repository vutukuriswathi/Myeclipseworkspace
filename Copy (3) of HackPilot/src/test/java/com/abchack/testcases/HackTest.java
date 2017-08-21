package com.abchack.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.abchack.pages.ArticlePage;
import com.abchack.pages.ChannelPage;
import com.abchack.pages.CommonPage;
import com.abchack.pages.IndexPage;
import com.abchack.util.Constants;

@Listeners({ com.abchack.screenshot.ScreenShotOnFailure.class, com.abchack.listener.TestsListenerAdapter.class })
public class HackTest extends TestBase {

	// Initializes configuration,logger and driver

	@BeforeMethod
	public void beforeSuite() {
		// Initializes logger and configuration file

		initConfigurations();

	}

	public void getURL() {
		driver.get(Constants.channel_page_url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	}

	/**
	 * This will check channel page w3c validator
	 * 
	 * @param browser
	 * @param version
	 * @param os
	 * @throws Exception
	 */
	// @Test(dataProvider = "hardCodedBrowsers")
	public void testcase1(String browser, String version, String os) throws Exception {
		// initConfigurations();
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonPage commonobj = PageFactory.initElements(driver, CommonPage.class);
		commonobj.w3cValidatorTest(Constants.channel_page_url);

	}

	/**
	 * This will check channel page w3c validator
	 * 
	 * @param browser
	 * @param version
	 * @param os
	 * @throws Exception
	 */
	// @Test(dataProvider = "hardCodedBrowsers")
	public void testcase2(String browser, String version, String os) throws Exception {
		// initConfigurations();
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonPage commonPage = PageFactory.initElements(driver, CommonPage.class);
		commonPage.w3cLinkChecker(Constants.channel_page_url,
				Thread.currentThread().getStackTrace()[1].getMethodName());

	}

	/*
	 * @Test public void testcase3() {
	 * 
	 * Common commonobj = PageFactory.initElements(driver, Common.class);
	 * commonobj.moreNavigation();
	 * 
	 * }
	 */

	/**
	 * click through the carousel items
	 * 
	 */
	@Test(dataProvider = "hardCodedBrowsers")
	public void testcase4(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		getURL();
		ChannelPage channelpage = PageFactory.initElements(driver, ChannelPage.class);
		channelpage.navigateCarouselItems();

	}

	/**
	 * verifying all the email fields error messages when the user failed to
	 * enter it
	 * 
	 */
	@Test(dataProvider = "hardCodedBrowsers")
	public void testcase5(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		getURL();
		ChannelPage channelpage = PageFactory.initElements(driver, ChannelPage.class);
		channelpage.verifyEmailFields();

	}

	/**
	 * This method will check whether email has been send to triple j hack or
	 * not
	 * 
	 */
	@Test(dataProvider = "hardCodedBrowsers")
	public void testcase6(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		getURL();
		ChannelPage channelpage = PageFactory.initElements(driver, ChannelPage.class);
		channelpage.sendHackEmail();

	}

	/**
	 * This method will check whether the comments has been posted in triplej
	 * hack page or not
	 * 
	 */
	@Test(dataProvider = "hardCodedBrowsers")
	public void testcase7(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		driver.get(Constants.facebookCommentsUrl);
		driver.manage().window().maximize();
		ArticlePage article = PageFactory.initElements(driver, ArticlePage.class);
		article.verifyFacebookComments();
		takeScreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());

	}

	/**
	 * This method will automate the youtube videos
	 * 
	 * @param browser
	 * @param version
	 * @param os
	 * @throws Exception
	 */
	@Test(dataProvider = "hardCodedBrowsers")
	public void testcase8(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		driver.get(Constants.youTubeUrl);
		driver.manage().window().maximize();
		ArticlePage article = PageFactory.initElements(driver, ArticlePage.class);
		article.verifyYouTubeVideo(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	/**
	 * This method will automate the youtube playlist videos
	 * 
	 * @param browser
	 * @param version
	 * @param os
	 * @throws Exception
	 */
	@Test(dataProvider = "hardCodedBrowsers")
	public void testcase9(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		driver.get(Constants.youTubePlayListUrl);
		driver.manage().window().maximize();
		ArticlePage article = PageFactory.initElements(driver, ArticlePage.class);
		article.verifyYouTubePlayList(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	/**
	 * This method will check the articles are placed in correct category or not
	 * 
	 * @param browser
	 * @param version
	 * @param os
	 * @throws Exception
	 */
	// @Test(dataProvider = "hardCodedBrowsers")
	public void testcase10(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		driver.navigate().to(Constants.channel_page_url);
		driver.manage().timeouts().pageLoadTimeout(Constants.longWait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		IndexPage indexpage = PageFactory.initElements(driver, IndexPage.class);
		indexpage.verifyArticleCategory(Thread.currentThread().getStackTrace()[1].getMethodName());

	}

	/**
	 * This method will check Whether the menu items are displayed or not
	 * 
	 * @param browser
	 * @param version
	 * @param os
	 * @throws Exception
	 */
	@Test(dataProvider = "hardCodedBrowsers")
	public void testcase11(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		getURL();
		CommonPage commonpage = PageFactory.initElements(driver, CommonPage.class);
		commonpage.verifyMenuItems(Thread.currentThread().getStackTrace()[1].getMethodName());

	}

	/**
	 * This method will check the titles of the index pages
	 * 
	 * @param browser
	 * @param version
	 * @param os
	 * @throws Exception
	 */
	@Test(dataProvider = "hardCodedBrowsers")
	public void testcase12(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		getURL();
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.verifyPageTitle(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@AfterMethod
	public void afterSuite() {
		quitDriver();
	}

}
