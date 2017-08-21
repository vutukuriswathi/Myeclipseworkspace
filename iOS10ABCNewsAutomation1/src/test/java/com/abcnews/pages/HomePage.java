package com.abcnews.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.abc.Testcases.TestBase;
import com.abc.util.Constants;
import com.abc.util.Util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomePage {

	private AppiumDriver driver;

	// onboarding screen heading
	@AndroidFindBy(name = "Get headlines at a glance")
	public WebElement onBoarding_Screen;

	// onboarding screen next button
	@AndroidFindBy(id = "android.AbcApplication:id/onboarding_next")
	public MobileElement onBoarding_next;

	// onboarding screen not now
	@AndroidFindBy(id = "android.AbcApplication:id/onboarding_notnow")
	public MobileElement onBoarding_notnow;

	// 6.0 device location access alert button
	@AndroidFindBy(name = "Allow")
	public MobileElement alertAllowBtn;

	// TopStories menu
	@AndroidFindBy(name = "TOP STORIES")
	public MobileElement topStoriesMenuItem;

	// TopStoriescategoryheading
	@AndroidFindBy(id = "android.AbcApplication:id/categoryHeader")
	public MobileElement topStoriesHeading;

	// Android hamburger menu
	@AndroidFindBy(id = "android:id/home")
	public MobileElement androidMenu;

	// android menu heading that is news
	@AndroidFindBy(id = "android.AbcApplication:id/navMenuHeading")
	public MobileElement androidMenuHeading;

	// now on tv menu item
	@AndroidFindBy(name = "NOW ON TV")
	public MobileElement nowOnTvMenuItem;

	// radio on demand menu item
	@AndroidFindBy(name = "RADIO ON DEMAND")
	public MobileElement radioOnDemandMenuItem;

	// tv on demand menu item
	@AndroidFindBy(name = "TV ON DEMAND")
	public MobileElement tvOnDemandMenuItem;

	// listen live menu item
	@AndroidFindBy(name = "LISTEN LIVE")
	public MobileElement listenLiveMenuItem;

	// menu icon elements
	@AndroidFindBy(id = "android.AbcApplication:id/navMenuThumb")
	public List<MobileElement> menuIcons;

	// menu items
	@AndroidFindBy(id = "android.AbcApplication:id/navMenuCaption")
	public List<MobileElement> menuItems;

	// menu cell items
	@AndroidFindBy(id = "android.AbcApplication:id/navMenuNormal")
	public List<MobileElement> menuCellItems;

	// ios Elements

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")
	public WebElement nextArrowBtn;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[2]")
	public WebElement not_now;

	@iOSFindBy(name = "TOP STORIES")
	public WebElement iostopStoriesHeading;

	// iOS hamburger menu
	@iOSFindBy(name = "Menu button")
	public MobileElement iOSMenu;

	// iOS Menu Heading news
	@iOSFindBy(name = "NEWS")
	public MobileElement iOSMenuHeading;

	@iOSFindBy(name = "Listen Live, Button")
	public MobileElement iOSListenLive;

	@iOSFindBy(name = "Now On TV, Button")
	public MobileElement iOSNowOnTv;

	@iOSFindBy(name = "TV On Demand, Button")
	public MobileElement iOSTvOnDemand;

	@iOSFindBy(name = "Radio On Demand, Button")
	public MobileElement iOSRadioOnDemand;

	@iOSFindBy(xpath = "/UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell")
	public List<MobileElement> iOSMenuItems;

	public HomePage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

	/**
	 * @Method: openApp
	 * @param:
	 * @Description:This method will click on onboarding icons
	 * @author :swathi Gunuputi
	 */
	public void openApp() {

		if (TestBase.platform.equalsIgnoreCase("android")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 360);
				wait.until(ExpectedConditions
						.presenceOfElementLocated(By.id("android.AbcApplication:id/onboarding_next")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				onBoarding_next.click();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				onBoarding_notnow.click();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				alertAllowBtn.click();
			} catch (Exception e) {

			}
			try {
				topStoriesMenuItem.click();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {

			try {
				WebDriverWait nwait = new WebDriverWait(driver, 360);
				nwait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")));
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				nextArrowBtn.click();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				not_now.click();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * @Method: verifyTopStoriesHeading
	 * @param:
	 * @Description:This method will check whether top stories page is opened or
	 *                   not.
	 * @author :swathi Gunuputi
	 */
	public void verifyTopStoriesHeading() {

		boolean topstoriespagescreenshot = TestBase.takeScreenshot("TopStoriespage");

		if (TestBase.platform.equalsIgnoreCase("android")) {
			Assert.assertTrue(topStoriesHeading.getText().equals(Constants.topStoriesHeading),
					"Topstories page is not opened");
		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {
			Assert.assertTrue(iostopStoriesHeading.getText().equals(Constants.topStoriesHeading),
					"Topstories page is not opened");

		}

	}

	/**
	 * @Method: menuSwiping
	 * @param:
	 * @Description:This method will swipe the hambuger menu on android.
	 * @author :swathi Gunuputi
	 */
	public void menuSwiping() throws InterruptedException {
		Util util = new Util();
		Thread.sleep(Constants.shortWait);
		androidMenu.click();
		Thread.sleep(Constants.shortWait);
		util.swipeUp();
		Thread.sleep(Constants.shortWait);
		util.swipeUp();
		Thread.sleep(Constants.shortWait);
		util.swipeUp();
		Thread.sleep(Constants.shortWait);
	}

}
