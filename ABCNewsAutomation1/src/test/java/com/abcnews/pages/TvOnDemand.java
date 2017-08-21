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

public class TvOnDemand {

	public AppiumDriver driver;

	@AndroidFindBy(id = "android.AbcApplication:id/tvdThumbImage")
	public List<MobileElement> tvOnDemandPodcasts;

	@AndroidFindBy(id = "android.AbcApplication:id/categoryHeader")
	public MobileElement tvOnDemandCategoryHeader;

	@AndroidFindBy(id = "android.AbcApplication:id/mediaPageThumb")
	public MobileElement tvOnDemandImage;

	@AndroidFindBy(id = "android.AbcApplication:id/mediaPageTitle")
	public MobileElement tvOnDemandPageTitle;

	@AndroidFindBy(id = "android.AbcApplication:id/mediaPageFileSize")
	public MobileElement tvOnDemandFileSize;

	@AndroidFindBy(id = "android.AbcApplication:id/mediaPageDuration")
	public MobileElement tvOnDemandPageDuration;

	@AndroidFindBy(id = "android.AbcApplication:id/mediaPageDescription")
	public MobileElement tvOnDemandPageDescription;

	@AndroidFindBy(id = "android.AbcApplication:id/mppWatchLabel")
	public MobileElement tvOnDemandWatchProgram;

	@AndroidFindBy(id = "android.AbcApplication:id/mediaPagePublishDate")
	public MobileElement tvOnDemandPublishDate;

	@AndroidFindBy(id = "android:id/time_current")
	public MobileElement tvOnDemandCurrentTime;

	@AndroidFindBy(id = "android:id/time")
	public MobileElement tvOnDemandTotalTime;

	@AndroidFindBy(id = "android:id/pause")
	public MobileElement tvOnDemandPauseBtn;

	// iOS Elements

	// radio on demand first podcast
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")
	public MobileElement iOSTvOnDemandFirstPodcast;

	// on demand text
	@iOSFindBy(name = "ON DEMAND")
	public MobileElement iOSTvOnDemandText;

	// on demand title,date and time
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")
	public MobileElement iOSTvOnDemandTitleAndDate;

	// on demand Description
	@iOSFindBy(name = "Description")
	public MobileElement iOSTvOnDemandDescription;

	// on demand play button
	@iOSFindBy(name = "Play")
	public MobileElement iOSTvOnDemandPlay;

	// on demand pause
	@iOSFindBy(name = "Pause")
	public MobileElement iOSTvOnDemandPause;

	// on demand pause
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIASlider[1]")
	public MobileElement iOSTvOnDemandPlayTime;

	public TvOnDemand(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);

	}

	/**
	 * @Method: verifyTvOnDemandSummaryPage
	 * @param:
	 * @Description:This method will check the TV on demand page elements.
	 * @author :swathi Gunuputi
	 */
	public boolean verifyTvOnDemandSummaryPage() {
		if (TestBase.platform.equalsIgnoreCase("android")) {
			if (tvOnDemandCategoryHeader.isDisplayed() && tvOnDemandImage.isDisplayed()
					&& tvOnDemandPageTitle.isDisplayed() && tvOnDemandFileSize.isDisplayed()
					&& tvOnDemandPageDuration.isDisplayed() && tvOnDemandPageDescription.isDisplayed()
					&& tvOnDemandWatchProgram.isDisplayed() && tvOnDemandPublishDate.isDisplayed())
				return true;
			else
				return false;
		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

			if (iOSTvOnDemandDescription.isDisplayed() && iOSTvOnDemandPlay.isDisplayed()
					&& iOSTvOnDemandText.isDisplayed() && iOSTvOnDemandTitleAndDate.isDisplayed()) {
				return true;
			} else {
				return false;
			}

		}
		return false;
	}

}
