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

public class ListenLive {

	public AppiumDriver driver;

	// list of listenLive podcasts
	@AndroidFindBy(id = "android.AbcApplication:id/rllThumbImage")
	public List<MobileElement> listenLivePodcasts;

	// listen live podcast category header
	@AndroidFindBy(id = "android.AbcApplication:id/categoryHeader")
	public MobileElement listenLiveCategoryHeader;

	// listen live podcast thumbnail image
	@AndroidFindBy(id = "android.AbcApplication:id/mediaPageThumb")
	public MobileElement listenLiveImage;

	// listen live podcast page title
	@AndroidFindBy(id = "android.AbcApplication:id/mediaPageTitle")
	public MobileElement listenLivePageTitle;

	//// listen live podcast page description
	@AndroidFindBy(id = "android.AbcApplication:id/mediaPageDescription")
	public MobileElement listenLivePageDescription;

	//// listen live podcast listen to station label
	@AndroidFindBy(id = "android.AbcApplication:id/mppListenLabel")
	public MobileElement listenLiveListenStationLabel;

	// listen live podcast timer
	@AndroidFindBy(id = "android.AbcApplication:id/mppTimerDisplay")
	public MobileElement listenLiveTimer;

	// listen live pause button
	@AndroidFindBy(id = "android.AbcApplication:id/mppIcon")
	public MobileElement listenLivePause;

	// iOS elements

	// listen live first podcast
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	public MobileElement iOSListenLivePodCast;

	// now on text
	@iOSFindBy(name = "NOW ON")
	public MobileElement iOSNowOnHeader;

	// now on podcast details like name and date
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")
	public MobileElement iOSNowOnPodcastDetails;

	// now on podcast description
	@iOSFindBy(name = "Description")
	public MobileElement iOSNowOnPodcastDescription;

	// now on listen to program button
	@iOSFindBy(name = "Play")
	public MobileElement iOSNowOnListenToProgramBtn;

	// now on pause button
	@iOSFindBy(name = "Pause")
	public MobileElement iOSNowOnPauseBtn;

	public ListenLive(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);

	}

	/**
	 * @Method: verifyListenLiveSummaryPage
	 * @param:
	 * @Description:This method will check the listen live summary page
	 *                   elements.
	 * @author :swathi Gunuputi
	 */
	public boolean verifyListenLiveSummaryPage() {
		if (TestBase.platform.equalsIgnoreCase("android")) {
			if (listenLiveCategoryHeader.isDisplayed() && listenLiveImage.isDisplayed()
					&& listenLivePageTitle.isDisplayed() && listenLivePageDescription.isDisplayed()
					&& listenLiveListenStationLabel.isDisplayed())
				return true;
			else
				return false;

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

			if (iOSNowOnHeader.isDisplayed() && iOSNowOnPodcastDetails.isDisplayed()
					&& iOSNowOnPodcastDescription.isDisplayed() && iOSNowOnListenToProgramBtn.isDisplayed()) {
				return true;
			} else {

				return false;
			}

		}
		return false;
	}

}
