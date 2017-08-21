package com.abcnews.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.abc.Testcases.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class EpisodeDetailPage {

	public AppiumDriver driver;

	// episode title
	@AndroidFindBy(id = "au.net.abc.iview:id/episode_title")
	public MobileElement andEpisodeTitle;

	@AndroidFindBy(id = "au.net.abc.iview:id/all_description_text")
	public MobileElement andepisodeDescriptionText;

	@AndroidFindBy(id = "au.net.abc.iview:id/channel_img")
	public MobileElement andEpisodeChannelImg;

	@AndroidFindBy(id = "au.net.abc.iview:id/button1")
	public List<MobileElement> andEpisodeCategoryBtn;

	@AndroidFindBy(id = "au.net.abc.iview:id/main_decription")
	public MobileElement andEpisodeMainDescription;

	@AndroidFindBy(id = "au.net.abc.iview:id/add_to_watch_list")
	public MobileElement andAddToWatchListBtn;

	@AndroidFindBy(className = "android.widget.ImageButton")
	public MobileElement andBackBtn;

	// iOS elements

	// iOS episode play btn
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[2]")
	public MobileElement iOSEpisodePlayBtn;

	// share button
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]")
	public MobileElement iOSEpisodeShareBtn;
	// UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[2]

	// add to watchlist btn
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[2]")
	public MobileElement iOSEpisodeAddToWatchlistBtn;

	// in your watchlist btn
	@iOSFindBy(name = "In your watch list")
	public MobileElement iOSEpisodeInYourWatchListBtn;

	// episode image
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAImage[4]")
	public MobileElement iOSEpisodeimage;

	// episode category
	@iOSFindBy(xpath = " //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton")
	public List<MobileElement> iOSEpisodeCategory;

	// category back btn
	@iOSFindBy(name = "Back")
	public MobileElement iOSCategoryBackBtn;

	// watchlist ok btn
	@iOSFindBy(name = "OK")
	public MobileElement iOSWatchlistOkBtn;

	public EpisodeDetailPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);

	}

	/**
	 * @Method: VerifyEpisodePage
	 * @param:
	 * @Description:This method will click whether episode details are
	 *                   displaying correctly or not
	 * @author :swathi Gunuputi
	 */
	public boolean VerifyEpisodePage() {

		if (TestBase.platform.equalsIgnoreCase("android")) {

			if (andEpisodeTitle.isDisplayed() && andEpisodeChannelImg.isDisplayed()
					&& andepisodeDescriptionText.isDisplayed() && andEpisodeMainDescription.isDisplayed())
				return true;
			else
				return false;

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {

			if (iOSEpisodeAddToWatchlistBtn.isDisplayed() && iOSEpisodeimage.isDisplayed()
					&& iOSEpisodeShareBtn.isDisplayed())
				return true;
			else
				return false;
		}
		return false;

	}
}
