package com.abcnews.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NowOnTv {

	public AppiumDriver driver;

	// watch now link
	@AndroidFindBy(id = "android.AbcApplication:id/tvnWatchNow")
	public MobileElement NowTvWatchNow;

	// Now on category header menu
	@AndroidFindBy(id = "android.AbcApplication:id/categoryHeader")
	public MobileElement NowOnCategoryHeader;

	// image
	@AndroidFindBy(id = "android.AbcApplication:id/mediaPageThumb")
	public MobileElement NowOnImage;

	// now on tv page description
	@AndroidFindBy(id = "android.AbcApplication:id/mediaPageDescription")
	public MobileElement NowOnPageDescription;

	// watch program button
	@AndroidFindBy(id = "android.AbcApplication:id/mppWatchLabel")
	public MobileElement NowOnTvwatchProgram;

	// now on tv program play time
	@AndroidFindBy(id = "android:id/time_current")
	public MobileElement NowOnTvCurrentTime;

	// now on tv pause button
	@AndroidFindBy(id = "android:id/pause")
	public MobileElement NowOnTvPause;

	public NowOnTv(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

	public boolean verifyNowOnTvSummaryPageElements() {
		if (NowOnCategoryHeader.isDisplayed() && NowOnImage.isDisplayed() && NowOnPageDescription.isDisplayed()
				&& NowOnTvwatchProgram.isDisplayed())
			return true;
		else
			return false;
	}

}
