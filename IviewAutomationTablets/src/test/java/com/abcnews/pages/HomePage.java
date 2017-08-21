package com.abcnews.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import com.abc.Testcases.TestBase;
import com.abc.util.Util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomePage {

	private AppiumDriver driver;

	// Android Elements
	@AndroidFindBy(name = "Ok")
	public MobileElement andChromecastOkBtn;

	// hero card play btn
	@AndroidFindBy(className = "android.widget.ImageView")
	public List<MobileElement> andHeroCardPlayBtn;

	// hero card played time
	@AndroidFindBy(id = "au.net.abc.iview:id/current_location")
	public MobileElement andHeroCardPlayedTime;

	// hero card pause btn
	// @AndroidFindBy(id = "au.net.abc.iview:id/play_pause")
	@AndroidFindBy(className = "android.widget.ImageButton")
	public MobileElement andHeroCardPause;

	// hero card pause btn
	@AndroidFindBy(id = "au.net.abc.iview:id/img_content_small_item")
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

	@AndroidFindBy(name = "Programs A-Z")
	public MobileElement programsMenuItem;

	@AndroidFindBy(name = "Your iview")
	public MobileElement yourIviewMenuItem;

	@AndroidFindBy(name = "Watchlist")
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

	@AndroidFindBy(id = "au.net.abc.iview:id/actor_img")
	public MobileElement andActorImg;

	// ios Elements

	// chrome cast ok btn
	@iOSFindBy(name = "Ok")
	public MobileElement okBtn;

	// hero card play btn
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]")
	public MobileElement heroCardPlayBtn;

	// hero card played time
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]")
	public MobileElement heroCardPlayedTime;

	// hero card pause btn
	@iOSFindBy(name = "Pause")
	public MobileElement heroCardPause;

	// hero card back btn
	@iOSFindBy(name = "Back")
	public MobileElement heroCardBack;

	// iOS first episode
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAButton[1]")
	public MobileElement iOSFirstEpisode;

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

	/**
	 * @Method: openApp
	 * @param:
	 * @Description:This method will click on chromecast button
	 * @author :swathi Gunuputi
	 */
	public void openApp() {

		Util util = new Util();
		if (TestBase.platform.equalsIgnoreCase("android")) {

			try {
				util.waitUntillElementIsVisible(andChromecastOkBtn);
				andChromecastOkBtn.click();
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

}