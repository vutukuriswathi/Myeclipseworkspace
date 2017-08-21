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

	// episode play btn
	@AndroidFindBy(className = "android.widget.ImageView")
	public List<MobileElement> andEpisodePlaybtn;

	// pause button
	@AndroidFindBy(className = "android.widget.ImageButton")
	public MobileElement andEpisodePauseBtn;

	// volumeControl
	@AndroidFindBy(className = "android.widget.ImageView")
	public MobileElement andEpisodeVolumeControl;

	// episode title
	@AndroidFindBy(id = "au.net.abc.iview:id/episode_item_series_title")
	public MobileElement andEpisodeTitle;

	// episode add to watchlist button
	@AndroidFindBy(id = "au.net.abc.iview:id/add_to_watchlist")
	public MobileElement andAddToWatchlistBtn;

	// episode thumbnail
	@AndroidFindBy(id = "au.net.abc.iview:id/episode_item_thumbnail")
	public MobileElement andEpisodeThumbnail;

	// episode categories
	@AndroidFindBy(className = "android.widget.TextView")
	public MobileElement andEpisodeCategories;

	// episode title
	@AndroidFindBy(id = "au.net.abc.iview:id/episode_description")
	public MobileElement andEpisodeDescription;

	// episode category button
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.TextView[1]")
	public MobileElement andEpisodeCategoryBtn;

	@AndroidFindBy(className = "android.widget.ImageButton")
	public MobileElement andBackBtn;

	@AndroidFindBy(id = "au.net.abc.iview:id/add_to_watchlist")
	public MobileElement andAddToWatchListBtn;

	// iOS elements

	// play btn
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]")
	public MobileElement iOSSecondEpisode;

	// episode category
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAButton")
	public List<MobileElement> iOSEpisodeCategory;

	// add to watchlist btn
	@iOSFindBy(name = "Add to watch list.")
	public MobileElement iOSEpisodeAddToWatchlistBtn;

	// episode image
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAImage[1]")
	public MobileElement iOSEpisodeimage;

	// pause btn
	@iOSFindBy(name = "Pause")
	public MobileElement iOSEpisodePause;

	// episode start time
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[4]")
	public MobileElement iOSEpisodeStartTime;

	// watchlist ok btn
	@iOSFindBy(name = "OK")
	public MobileElement iOSWatchlistOkBtn;

	// in your watchlist btn
	@iOSFindBy(name = "In your watch list")
	public MobileElement iOSEpisodeInYourWatchListBtn;

	// iOS episode play btn
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]")
	public MobileElement iOSEpisodePlayBtn;

	// category back btn
	@iOSFindBy(name = "Back")
	public MobileElement iOSCategoryBackBtn;

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

			if (andEpisodeThumbnail.isDisplayed() && andEpisodeTitle.isDisplayed()
					&& andEpisodeDescription.isDisplayed() && andAddToWatchlistBtn.isDisplayed())
				return true;
			else
				return false;
		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {

			if (iOSEpisodeAddToWatchlistBtn.isDisplayed() && iOSEpisodeimage.isDisplayed()
					&& iOSEpisodePlayBtn.isDisplayed())
				return true;
			else
				return false;
		}
		return false;

	}
}
