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
	@AndroidFindBy(id = "android.AbcApplication:id/mediaPagePublishDate")
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

	// iOS Elements

	// radio on demand first podcast
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")
	public MobileElement iOSRadioOnDemandFirstPodcast;

	// on demand text
	@iOSFindBy(name = "ON DEMAND")
	public MobileElement iOSRadioOnDemandText;

	// on demand title,date and time
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")
	public MobileElement iOSRadioOnDemandTitleAndDate;

	// on demand Description
	@iOSFindBy(name = "Description")
	public MobileElement iOSRadioOnDemandDescription;

	// on demand play button
	@iOSFindBy(name = "Play")
	public MobileElement iOSRadioOnDemandPlay;

	// on demand pause
	@iOSFindBy(name = "Pause")
	public MobileElement iOSRadioOnDemandPause;

	// on demand pause
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[5]")
	public MobileElement iOSRadioOnDemandPlayTime;

	public RadioOnDemand(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

	/**
	 * @Method: verifyRadioOnDemandSummaryPage
	 * @param:
	 * @Description:This method will check the Radio on demand page elements.
	 * @author :swathi Gunuputi
	 */
	public boolean verifyRadioOnDemandSummaryPage() {
		if (TestBase.platform.equalsIgnoreCase("android")) {
			if (radioOnDemCategoryHeader.isDisplayed() && radioOnDemImage.isDisplayed()
					&& radioOnDemCategoryDescription.isDisplayed() && radioOnDemPubDate.isDisplayed()
					&& radioOnDemPageDuration.isDisplayed() && radioOnDemFileSize.isDisplayed()
					&& radioOnDemListenProgram.isDisplayed())
				return true;
			else
				return false;
		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

			if (iOSRadioOnDemandText.isDisplayed() && iOSRadioOnDemandDescription.isDisplayed()
					&& iOSRadioOnDemandTitleAndDate.isDisplayed() && iOSRadioOnDemandPlay.isDisplayed()) {
				return true;
			} else {
				return false;
			}

		}
		return false;
	}

}
