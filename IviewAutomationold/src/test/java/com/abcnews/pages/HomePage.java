package com.abcnews.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

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

	// onboarding screen ok button
	@AndroidFindBy(name = "OK")
	public MobileElement onBoardingScreenOk;

	@AndroidFindBy(name = "Programs A-Z")
	public MobileElement programsMenuItem;

	@AndroidFindBy(name = "Your iview")
	public MobileElement yourIviewMenuItem;

	// watchlist counter
	@AndroidFindBy(id = "au.net.abc.iview:id/navigation_counter")
	public MobileElement watchListMenuItem;

	@AndroidFindBy(name = "Parental Filter")
	public MobileElement parentalFilterMenuItem;

	@AndroidFindBy(name = "Recently Viewed")
	public MobileElement recentlyViewdMenuItem;

	@AndroidFindBy(name = "Support")
	public MobileElement supportMenuItem;

	@AndroidFindBy(name = "Announcements")
	public MobileElement announcementsMenuItem;

	@AndroidFindBy(name = "About iview")
	public MobileElement aboutIviewMenuItem;

	@AndroidFindBy(name = "Where to get ABC iview")
	public MobileElement whereToGetAbcIviewMenuItem;

	@AndroidFindBy(name = "How to use ABC iview")
	public MobileElement howToUseAbcIviewMenuItem;

	@AndroidFindBy(name = "FAQs and Help")
	public MobileElement faqaAndHelpMenuItem;

	@AndroidFindBy(name = "Live Streaming")
	public MobileElement liveStreamingMenuItem;

	@AndroidFindBy(name = "Chromecast")
	public MobileElement chromeCastMenuItem;

	@AndroidFindBy(name = "iview on FreeviewPlus")
	public MobileElement iviewOnFreeViewPlusMenuItem;

	@AndroidFindBy(name = "Links to Buy")
	public MobileElement linksToBuyMenuItem;

	@AndroidFindBy(name = "Audio Description")
	public MobileElement audioDescriptionMenuItem;

	@AndroidFindBy(name = "ABC iview Terms of Use")
	public MobileElement abcIviewTermsOfUseMenuItem;

	@AndroidFindBy(name = "iview Access Guidelines")
	public MobileElement iviewAcessGuidelinesMenuItem;

	@AndroidFindBy(name = "High Quality Video")
	public MobileElement highQualityVideoMenuItem;

	@AndroidFindBy(name = "Accessibility Troubleshooting and FAQs")
	public MobileElement accessbilityTroubleshootingMenuItem;

	@AndroidFindBy(name = "Follow Us")
	public MobileElement followUsMenuItem;

	@AndroidFindBy(name = "Facebook")
	public MobileElement facebookMenuItem;

	@AndroidFindBy(name = "Twitter")
	public MobileElement twitterMenuItem;

	@AndroidFindBy(name = "More")
	public MobileElement moreMenuItem;

	@AndroidFindBy(name = "More ABC")
	public MobileElement moreAbcMenuItem;

	@AndroidFindBy(name = "Contact iview")
	public MobileElement contactIviewMenuItem;

	@AndroidFindBy(name = "Privacy Policy")
	public MobileElement privacyPolicyMenuItem;

	// Android Elements
	@AndroidFindBy(id = "au.net.abc.iview:id/button")
	public MobileElement andChromecastOkBtn;

	// hero card play btn
	@AndroidFindBy(id = "au.net.abc.iview:id/play")
	public MobileElement andHeroCardPlayBtn;

	// hero card played time
	@AndroidFindBy(id = "au.net.abc.iview:id/current_location")
	public MobileElement andHeroCardPlayedTime;

	// hero card pause btn
	@AndroidFindBy(id = "au.net.abc.iview:id/play_pause")
	public MobileElement andHeroCardPause;

	// first episode
	@AndroidFindBy(id = "au.net.abc.iview:id/carousel_item_image")
	public List<MobileElement> andEpisodeStory;

	@AndroidFindBy(className = "android.widget.ImageButton")
	public List<MobileElement> HomeMenu;

	@AndroidFindBy(id = "au.net.abc.iview:id/navigation_arrow")
	public List<MobileElement> menuNavigationArrow;

	@AndroidFindBy(name = "Browse")
	public MobileElement browseMenuItem;

	@AndroidFindBy(name = "Channels")
	public MobileElement channelsMenuItem;

	@AndroidFindBy(id = "au.net.abc.iview:id/navigation_channel_item_1")
	public List<MobileElement> channel1MenuItem;

	@AndroidFindBy(id = "au.net.abc.iview:id/navigation_channel_item_2")
	public List<MobileElement> channel2MenuItem;

	@AndroidFindBy(id = "au.net.abc.iview:id/navigation_channel_item_3")
	public List<MobileElement> channel3MenuItem;

	@AndroidFindBy(name = "Categories")
	public MobileElement categoriesMenuItem;

	@AndroidFindBy(name = "Arts & Culture")
	public MobileElement artAndCultureMenuItem;

	@AndroidFindBy(name = "Comedy")
	public MobileElement comedyMenuItem;

	@AndroidFindBy(name = "Documentary")
	public MobileElement documentaryMenuItem;

	@AndroidFindBy(name = "Drama")
	public MobileElement dramaMenuItem;

	@AndroidFindBy(name = "Education")
	public MobileElement educationMenuItem;

	@AndroidFindBy(name = "Lifestyle")
	public MobileElement lifeStyleMenuItem;

	@AndroidFindBy(name = "News and Current Affairs")
	public MobileElement newsAndCurrentMenuItem;

	@AndroidFindBy(name = "Panel & Discussion")
	public MobileElement panelMenuItem;

	@AndroidFindBy(name = "Sport")
	public MobileElement sportMenuItem;

	// episode items
	@AndroidFindBy(className = "android.widget.ImageView")
	public List<MobileElement> andEpisodeItems;

	@AndroidFindBy(id = "au.net.abc.iview:id/actor_img")
	public MobileElement andActorImg;

	// ios Elements

	// chrome cast ok btn
	@iOSFindBy(name = "Ok")
	public MobileElement okBtn;

	// second episode
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]")
	public MobileElement iOSSecondEpisode;

	// hero card play btn
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]")
	public MobileElement heroCardPlayBtn;

	// iOS home menu btn
	@iOSFindBy(name = "show menu")
	public MobileElement iOSHomeMenuBtn;

	// iOS programs A-z btn
	@iOSFindBy(name = "Programs A-Z")
	public MobileElement iOSProgramsAzMenuItem;

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
		Util util = new Util();

		if (TestBase.platform.equalsIgnoreCase("android")) {

			try {
				util.waitUntillElementIsVisible(andChromecastOkBtn);
				onBoardingScreenOk.click();
			} catch (Throwable e) {

			}

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {
			try {
				util.waitUntillElementIsVisible(okBtn);
				okBtn.click();
			} catch (Throwable e) {

			}

		}

	}

	/**
	 * @Method: verifyMenuItems
	 * @param:
	 * @Description:This method will check whether menu items is displayed or
	 *                   not.
	 * @author :swathi Gunuputi
	 */
	public boolean verifyMenuItems() {

		if (TestBase.platform.equalsIgnoreCase("android")) {
			menuNavigationArrow.get(0).click();
			if (browseMenuItem.isDisplayed() && yourIviewMenuItem.isDisplayed() && supportMenuItem.isDisplayed()
					&& moreMenuItem.isDisplayed())
				return true;
			else
				return false;

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {
		}
		return false;

	}

	/**
	 * @Method: verifyBrowseMenuItems
	 * @param:
	 * @Description:This method will check whether browse menu items displayed
	 *                   not.
	 * @author :swathi Gunuputi
	 */
	public boolean verifyBrowseMenuItems() {

		if (TestBase.platform.equalsIgnoreCase("android")) {
			if (channelsMenuItem.isDisplayed() && channel1MenuItem.get(0).isDisplayed()
					&& channel1MenuItem.get(1).isDisplayed() && channel1MenuItem.get(2).isDisplayed()
					&& channel2MenuItem.get(0).isDisplayed() && channel2MenuItem.get(1).isDisplayed()
					&& channel3MenuItem.get(0).isDisplayed() && channel3MenuItem.get(1).isDisplayed()
					&& categoriesMenuItem.isDisplayed() && programsMenuItem.isDisplayed())
				return true;
			else
				return false;

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {
		}
		return false;

	}

	/**
	 * @Method: verifyYourIviewMenuItems
	 * @param:
	 * @Description:This method will check whether your ivew menu items
	 *                   displayed or not.
	 * @author :swathi Gunuputi
	 */
	public boolean verifyYourIviewMenuItems() {

		if (TestBase.platform.equalsIgnoreCase("android")) {
			menuNavigationArrow.get(0).click();

			if (watchListMenuItem.isDisplayed() && recentlyViewdMenuItem.isDisplayed()
					&& parentalFilterMenuItem.isDisplayed())
				return true;
			else
				return false;

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {
		}
		return false;

	}

	/**
	 * @Method: verifySupportMenuItems
	 * @param:
	 * @Description:This method will check whether support menu items is
	 *                   displayed or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	public boolean verifySupportMenuItems() throws InterruptedException {

		if (TestBase.platform.equalsIgnoreCase("android")) {
			menuNavigationArrow.get(0).click();
			Thread.sleep(Constants.shortWait);
			menuNavigationArrow.get(1).click();
			Thread.sleep(Constants.shortWait);
			menuNavigationArrow.get(2).click();
			Util util = new Util();
			util.waitUntillElementIsVisible(announcementsMenuItem);
			boolean supportMenuItems1 = announcementsMenuItem.isDisplayed() && aboutIviewMenuItem.isDisplayed()
					&& whereToGetAbcIviewMenuItem.isDisplayed() && whereToGetAbcIviewMenuItem.isDisplayed()
					&& howToUseAbcIviewMenuItem.isDisplayed() && faqaAndHelpMenuItem.isDisplayed()
					&& liveStreamingMenuItem.isDisplayed() && chromeCastMenuItem.isDisplayed()
					&& iviewOnFreeViewPlusMenuItem.isDisplayed();
			util.swipeUp();
			Thread.sleep(Constants.shortWait);
			util.swipeUp();
			Thread.sleep(Constants.shortWait);
			util.swipeUp();
			Thread.sleep(Constants.shortWait);

			boolean supportMenuItems2 = linksToBuyMenuItem.isDisplayed() && audioDescriptionMenuItem.isDisplayed();
			menuNavigationArrow.get(0).click();
			Thread.sleep(Constants.shortWait);
			util.swipeUp();
			util.waitUntillElementIsVisible(facebookMenuItem);
			boolean supportMenuItems3 = facebookMenuItem.isDisplayed() && twitterMenuItem.isDisplayed();
			return (supportMenuItems1 && supportMenuItems2 && supportMenuItems3);
		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {
		}
		return false;

	}

	/**
	 * @Method: verifyMoreMenuItems
	 * @param:
	 * @Description:This method will check whether more menu items is displayed
	 *                   or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	public boolean verifyMoreMenuItems() throws InterruptedException {

		if (TestBase.platform.equalsIgnoreCase("android")) {
			menuNavigationArrow.get(0).click();
			Thread.sleep(Constants.shortWait);
			menuNavigationArrow.get(1).click();
			Thread.sleep(Constants.shortWait);
			menuNavigationArrow.get(3).click();

			if (moreAbcMenuItem.isDisplayed() && contactIviewMenuItem.isDisplayed()
					&& privacyPolicyMenuItem.isDisplayed())
				return true;
			else
				return false;

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {
		}
		return false;

	}

	/**
	 * @Method: MenuSwipeUp
	 * @param:
	 * @Description:This method will be used if you want to perform swipe up
	 *                   action
	 * @author :swathi Gunuputi
	 */
	public void MenuSwipeUp() {

		Dimension size = (TestBase.getDriver()).manage().window().getSize();
		// int startx = size.getWidth() / 2;
		int starty = (int) (size.getHeight() * 0.8);
		int endy = (int) (size.getHeight() * 0.2);
		(TestBase.getDriver()).swipe(40, starty, 40, endy, 1000);

	}

}
