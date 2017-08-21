package com.abcnews.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

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

	public TvOnDemand(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);

	}

	public boolean verifyTvOnDemandSummaryPage() {
		if (tvOnDemandCategoryHeader.isDisplayed() && tvOnDemandImage.isDisplayed() && tvOnDemandPageTitle.isDisplayed()
				&& tvOnDemandFileSize.isDisplayed() && tvOnDemandPageDuration.isDisplayed()
				&& tvOnDemandPageDescription.isDisplayed() && tvOnDemandWatchProgram.isDisplayed()
				&& tvOnDemandPublishDate.isDisplayed())
			return true;
		else
			return false;
	}

}
