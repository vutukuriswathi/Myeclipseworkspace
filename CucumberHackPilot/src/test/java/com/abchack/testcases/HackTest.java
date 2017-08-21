package com.abchack.testcases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.abchack.pages.ArticlePage;
import com.abchack.pages.ChannelPage;
import com.abchack.pages.CommonPage;
import com.abchack.pages.IndexPage;
import com.abchack.util.Constants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Listeners({ com.abchack.screenshot.ScreenShotOnFailure.class, com.abchack.listener.TestsListenerAdapter.class })
public class HackTest extends TestBase {

	// Initializes configuration,logger and driver

	@BeforeMethod
	public void beforeMethod() {
		// Initializes logger and configuration file

		initConfigurations();

	}

	public void getURL() {
		driver.get(Constants.channel_page_url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40L, TimeUnit.SECONDS);
	}

	public void waitTillPageLoad() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");
		}
	}

	@Given("^Launch the w3cLinkChecker$")
	public void Launch_w3c() throws MalformedURLException {
		createDriver("safari", "10.2", "windows", Thread.currentThread().getStackTrace()[1].getMethodName());
		driver.get(Constants.w3cLinkChecker);
	}

	@When("^entered \"([a-zA-Z]{1,})\" page url$")
	public void when_method(String type) {
		System.out.println("enter the  url");
	}

	@Then("^validator validates \"([a-zA-Z]{1,})\" page errors$")
	public void then_method(String type) throws InterruptedException {
		CommonPage commonPage = PageFactory.initElements(driver, CommonPage.class);
		commonPage.w3cLinkChecker(Constants.channel_page_url,
				Thread.currentThread().getStackTrace()[1].getMethodName());

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

	}

	/**
	 * This will check article page w3c validator
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
		commonPage.w3cLinkChecker(Constants.article_page_url,
				Thread.currentThread().getStackTrace()[1].getMethodName());

	}

	/**
	 * This will check article page w3c validator
	 * 
	 * @param browser
	 * @param version
	 * @param os
	 * @throws Exception
	 */
	// @Test(dataProvider = "hardCodedBrowsers")
	public void testcase3(String browser, String version, String os) throws Exception {
		// initConfigurations();
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonPage commonPage = PageFactory.initElements(driver, CommonPage.class);
		commonPage.w3cLinkChecker(Constants.index_page_url, Thread.currentThread().getStackTrace()[1].getMethodName());

	}

	/**
	 * click through the carousel items
	 * 
	 */
	// @Test(dataProvider = "hardCodedBrowsers")
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
	// @Test(dataProvider = "hardCodedBrowsers")
	public void testcase5(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		getURL();
		ChannelPage channelpage = PageFactory.initElements(driver, ChannelPage.class);
		waitTillPageLoad();
		channelpage.verifyEmailFields();

	}

	/**
	 * This method will check whether email has been send to triple j hack or
	 * not
	 * 
	 */
	// @Test(dataProvider = "hardCodedBrowsers")
	public void testcase6(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		getURL();
		ChannelPage channelpage = PageFactory.initElements(driver, ChannelPage.class);
		waitTillPageLoad();
		channelpage.sendHackEmail();

	}

	/**
	 * This method will check whether the comments has been posted in triplej
	 * hack page or not
	 * 
	 */
	// @Test(dataProvider = "hardCodedBrowsers")
	public void testcase7(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		driver.get(Constants.facebookCommentsUrl);
		driver.manage().window().maximize();
		waitTillPageLoad();
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
	// @Test(dataProvider = "hardCodedBrowsers")
	public void testcase8(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		driver.get(Constants.youTubeUrl);
		waitTillPageLoad();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50L, TimeUnit.SECONDS);
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
	// @Test(dataProvider = "hardCodedBrowsers")
	public void testcase9(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		driver.get(Constants.youTubePlayListUrl);
		waitTillPageLoad();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50L, TimeUnit.SECONDS);
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
		// driver.manage().timeouts().pageLoadTimeout(Constants.longWait,
		// TimeUnit.SECONDS);
		waitTillPageLoad();
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
	// @Test(dataProvider = "hardCodedBrowsers")
	public void testcase11(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		getURL();
		waitTillPageLoad();
		// Thread.sleep(Constants.shortWait);
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
	// @Test(dataProvider = "hardCodedBrowsers")
	public void testcase12(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		getURL();
		waitTillPageLoad();
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.verifyPageTitle(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	/**
	 * This method will check the Icons redirection
	 * 
	 * @param browser
	 * @param version
	 * @param os
	 * @throws Exception
	 */
	// @Test(dataProvider = "hardCodedBrowsers")
	public void testcase13(String browser, String version, String os) throws Exception {
		createDriver(browser, version, os, Thread.currentThread().getStackTrace()[1].getMethodName());
		driver.navigate().to(Constants.channel_page_url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		waitTillPageLoad();
		ChannelPage channelPage = PageFactory.initElements(driver, ChannelPage.class);
		channelPage.verifyIconsRedirection();
	}

	@AfterMethod
	public void afterMethod() {
		quitDriver();
	}

}
