package com.abcnews.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RadioOnDemand {

	public AppiumDriver driver;

	// list of radio on demand podcasts
	@AndroidFindBy(id = "android.AbcApplication:id/rodThumbImage")
	public List<MobileElement> radioOnDemandPodcasts;

	// radio on demand category header
	@AndroidFindBy(id = "android.AbcApplication:id/categoryHeader")
	public MobileElement radioOnDemCategoryHeader;

	// radio on demand image
	@AndroidFindBy(id = "android.AbcApplication:id/mediaPageThumb")
	public MobileElement radioOnDemImage;

	// radio on demand page description
	@AndroidFindBy(id = "android.AbcApplication:id/mediaPageDescription")
	public MobileElement radioOnDemCategoryDescription;

	// radio on demand publish date
	@AndroidFindBy(id = "android.AbcApplication:id/mediaPagePublishDater")
	public MobileElement radioOnDemPubDate;

	// radio on demand page duration
	@AndroidFindBy(id = "android.AbcApplication:id/mediaPageDuration")
	public MobileElement radioOnDemPageDuration;

	// radio on demand file size
	@AndroidFindBy(id = "android.AbcApplication:id/mediaPageFileSize")
	public MobileElement radioOnDemFileSize;

	// radio on demand listen program button
	@AndroidFindBy(id = "android.AbcApplication:id/mppListenLabel")
	public MobileElement radioOnDemListenProgram;

	// pause icon
	@AndroidFindBy(id = "android.AbcApplication:id/mppIcon")
	public MobileElement radioOnDemandPauseIcon;

	// audio progression time
	@AndroidFindBy(id = "android.AbcApplication:id/mppTimerDisplay")
	public MobileElement radioOnDemandBeginTime;

	// Total time of the audio
	@AndroidFindBy(id = "android.AbcApplication:id/mppTimerEnd")
	public MobileElement radioOnDemandEndTime;

	public RadioOnDemand(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

	public boolean verifyRadioOnDemandSummaryPage() {
		if (radioOnDemCategoryHeader.isDisplayed() && radioOnDemImage.isDisplayed()
				&& radioOnDemCategoryDescription.isDisplayed() && radioOnDemPubDate.isDisplayed()
				&& radioOnDemPageDuration.isDisplayed() && radioOnDemFileSize.isDisplayed()
				&& radioOnDemListenProgram.isDisplayed())
			return true;
		else
			return false;
	}

}
