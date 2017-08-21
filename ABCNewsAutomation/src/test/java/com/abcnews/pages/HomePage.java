package com.abcnews.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.abc.stepDefinition.Hooks;
import com.abc.util.Constants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import junit.framework.Assert;

public class HomePage {

	private AppiumDriver driver;

	Properties platformConfig;

	// onboarding screen heading
	@AndroidFindBy(name = "Get headlines at a glance")
	public WebElement onBoarding_Screen;

	// onboarding screen next button
	@AndroidFindBy(id = "android.AbcApplication:id/onboarding_next")
	public MobileElement onBoarding_next;

	// onboarding screen not now
	@AndroidFindBy(id = "android.AbcApplication:id/onboarding_notnow")
	public MobileElement onBoarding_notnow;

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

	// ios Elements

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")
	public WebElement nextArrowBtn;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[2]")
	public WebElement not_now;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableGroup[1]/UIAStaticText[1]")
	public WebElement iostopStoriesHeading;

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

		if (Hooks.platform.equalsIgnoreCase("android")) {
			WebDriverWait wait = new WebDriverWait(driver, 360);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android.AbcApplication:id/onboarding_next")));
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
				topStoriesMenuItem.click();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (Hooks.platform.equalsIgnoreCase("ios")) {

			WebDriverWait nwait = new WebDriverWait(driver, 360);
			nwait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")));

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
		Hooks.embedScreenshot();
		if (Hooks.platform.equalsIgnoreCase("android")) {
			Assert.assertTrue("Topstories page is not opened",
					topStoriesHeading.getText().equals(Constants.topStoriesHeading));
		}
		if (Hooks.platform.equalsIgnoreCase("ios")) {
			Assert.assertTrue("Topstories page is not opened",
					iostopStoriesHeading.getText().equals(Constants.topStoriesHeading));

		}

	}

}
