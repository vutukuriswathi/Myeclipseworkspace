package com.abcnews.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

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

	public ListenLive(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);

	}

	public boolean verifyListenLiveSummaryPage() {
		if (listenLiveCategoryHeader.isDisplayed() && listenLiveImage.isDisplayed() && listenLivePageTitle.isDisplayed()
				&& listenLivePageDescription.isDisplayed() && listenLiveListenStationLabel.isDisplayed())
			return true;
		else
			return false;

	}

}
