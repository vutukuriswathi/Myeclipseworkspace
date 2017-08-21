package com.abc.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.abc.Testcases.TestBase;
import com.abc.util.Constants;
import com.abc.util.Util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ShowCollectionScreenPage {

	private AppiumDriver driver;

	// ios elements
	// ABC ME logo
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAImage[6]")
	public MobileElement iosAbcMeLogo;

	// series name
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]")
	public MobileElement iosSeriesName;

	// series title
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[4]")
	public MobileElement iosSeriesTitle;

	// series description
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[5]")
	public MobileElement iosSeriesDescription;

	// Add to my shows btn
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[3]")
	public MobileElement iosAddToMyShowBtn;

	// series left out time
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[6]")
	public MobileElement iosSeriesLeftOutTime;

	// all episodes btn
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[4]")
	public MobileElement iosAllEpisodesBtn;

	// what did you think of this episode text
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[7]")
	public MobileElement iosEpisodeThinkTxt;

	// love this btn
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[5]")
	public MobileElement iosLoveThisBtn;

	// This is cool btn
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[6]")
	public MobileElement iosCoolBtn;

	// This makes me LOL btn
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[7]")
	public MobileElement iosLolBtn;

	// meh btn
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[8]")
	public MobileElement iosMehBtn;

	// gross Btn
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[9]")
	public MobileElement iosGrossBtn;

	// No:of episodes(eg:14 Episodes)
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]")
	public MobileElement iosEpisodes;

	// No:of series episodes
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell")
	public List<MobileElement> iosNoOfSeriesEpisodes;

	// play btn
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")
	public MobileElement iosPlayBtn;

	// show title
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")
	public MobileElement iosShowTitle;

	// change name menu item
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]")
	public MobileElement iosCollectionTitle;

	// Back button
	@iOSFindBy(accessibility = "Back")
	public MobileElement iosBackBtn;

	public ShowCollectionScreenPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

	/**
	 * @Method: verifyShowScreenPage
	 * @param:
	 * @Description:This method will check the show screen page elements.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	public boolean verifyShowScreenPage() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {
			Thread.sleep(Constants.longWait);
			TestBase.takeScreenshot("showScreenPage");

			if (iosAbcMeLogo.isDisplayed() && iosSeriesName.isDisplayed() && iosSeriesTitle.isDisplayed()
					&& iosSeriesDescription.isDisplayed() && iosAddToMyShowBtn.isDisplayed()
					&& iosSeriesLeftOutTime.isDisplayed() && iosEpisodeThinkTxt.isDisplayed()
					&& iosLoveThisBtn.isDisplayed() && iosMehBtn.isDisplayed() && iosGrossBtn.isDisplayed()
					&& iosEpisodes.isDisplayed() && iosPlayBtn.isDisplayed() && iosShowTitle.isDisplayed()) {
				return true;
			} else {

				return false;
			}

		}
		return false;
	}

	/**
	 * @Method: verifyCollectionScreenPage
	 * @param:
	 * @Description:This method will check the collection screen page elements.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	public boolean verifyCollectionScreenPage() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {
			Thread.sleep(Constants.longWait);
			TestBase.takeScreenshot("collectionScreenPage");

			if (iosAbcMeLogo.isDisplayed() && iosSeriesName.isDisplayed() && iosSeriesTitle.isDisplayed()
					&& iosSeriesDescription.isDisplayed() && iosAddToMyShowBtn.isDisplayed()
					&& iosSeriesLeftOutTime.isDisplayed() && iosEpisodeThinkTxt.isDisplayed()
					&& iosLoveThisBtn.isDisplayed() && iosMehBtn.isDisplayed() && iosGrossBtn.isDisplayed()
					&& iosEpisodes.isDisplayed() && iosPlayBtn.isDisplayed() && iosShowTitle.isDisplayed()
					&& iosCollectionTitle.isDisplayed() && iosAllEpisodesBtn.isDisplayed()) {
				return true;
			} else {

				return false;
			}

		}
		return false;
	}

	/**
	 * @Method: verifyCollectionShowScreenEpisodeCount
	 * @param:
	 * @Description:This method will check the no:of episodes are matching with
	 *                   the episodes that are displaying or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	public boolean verifyCollectionShowScreenEpisodeCount() throws InterruptedException {
		Util util = new Util();
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

			util.waitUntillElementIsVisible(iosEpisodes);
			TestBase.takeScreenshot("collectionScreenEpisodeCount");
			String episodes[] = iosEpisodes.getText().split(" ");

			// will get the episode count
			int episodeCount = Integer.parseInt(episodes[0]);

			Thread.sleep(Constants.longWait);
			// No:of episode series
			int episodeSeriesCount = iosNoOfSeriesEpisodes.size();

			if (episodeCount == episodeSeriesCount) {
				return true;
			} else {

				return false;
			}

		}
		return false;
	}

}
