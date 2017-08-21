package com.abcnews.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.abc.Testcases.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

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

	// iOS Elements

	// watch now button
	@iOSFindBy(name = "Watch Now")
	public MobileElement iOSNowOnTvWatchNow;

	// now on text
	@iOSFindBy(name = "NOW ON")
	public MobileElement iOSNowOnTvNowOnText;

	// now on tv video heading
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")
	public MobileElement iOSNowOnTvHeading;

	// now on tv description
	@iOSFindBy(name = "Description")
	public MobileElement iOSNowOnTvDescription;

	// play button
	@iOSFindBy(name = "Play")
	public MobileElement iOSNowOnTvPlay;

	// now on tv pause button
	@iOSFindBy(name = "Pause")
	public MobileElement iOSNowOnTvPause;

	public NowOnTv(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

	/**
	 * @Method: verifyNowOnTvSummaryPageElements
	 * @param:
	 * @Description:This method will check the NowonTv page elements.
	 * @author :swathi Gunuputi
	 */
	public boolean verifyNowOnTvSummaryPageElements() {
		if (TestBase.platform.equalsIgnoreCase("android")) {
			if (NowOnCategoryHeader.isDisplayed() && NowOnImage.isDisplayed() && NowOnPageDescription.isDisplayed()
					&& NowOnTvwatchProgram.isDisplayed())
				return true;
			else
				return false;
		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {
			if (iOSNowOnTvDescription.isDisplayed() && iOSNowOnTvHeading.isDisplayed()
					&& iOSNowOnTvNowOnText.isDisplayed() && iOSNowOnTvPlay.isDisplayed())
				return true;
			else
				return false;
		}
		return false;
	}

}
