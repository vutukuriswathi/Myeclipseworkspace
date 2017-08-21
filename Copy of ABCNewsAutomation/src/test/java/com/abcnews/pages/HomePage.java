package com.abcnews.pages;

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
import junit.framework.Assert;

@SuppressWarnings("deprecation")
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

	public HomePage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

	/**
	 * @Method: Android_open_app
	 * @param:
	 * @Description:This method will click on onboarding icons
	 * @author :swathi Gunuputi
	 */
	public void openApp() {
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

	/**
	 * @Method: verifyTopStoriesHeading
	 * @param:
	 * @Description:This method will check whether top stories page is opened or
	 *                   not.
	 * @author :swathi Gunuputi
	 */
	public void verifyTopStoriesHeading() {
		Hooks.embedScreenshot();
		Assert.assertTrue("Topstories page is not opened",
				topStoriesHeading.getText().equals(Constants.topStoriesHeading));

	}

}
