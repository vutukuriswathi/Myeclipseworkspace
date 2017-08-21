package com.abcnews.pages;

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
	@iOSFindBy(name = "abcme logo small")
	public MobileElement iosAbcMeLogo;

	// series image
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeImage[1]")
	public MobileElement iosSeriesImage;

	// series title
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
	public MobileElement iosShowTitle;

	// series description
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[3]")
	public MobileElement iosSeriesDescription;

	// Add to my shows btn
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[2]")
	public MobileElement iosAddToMyShowBtn;

	// series left out time
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[4]")
	public MobileElement iosSeriesLeftOutTime;

	// all episodes btn
	@iOSFindBy(name = "ALL EPISODES")
	public MobileElement iosAllEpisodesBtn;

	// what did you think of this episode text
	@iOSFindBy(name = "What do you think of the episode?")
	public MobileElement iosEpisodeThinkTxt;

	// love this btn
	@iOSFindBy(name = "love")
	public MobileElement iosLoveThisBtn;

	// This is cool btn
	@iOSFindBy(name = "awesome")
	public MobileElement iosCoolBtn;

	// This makes me LOL btn
	@iOSFindBy(name = "laugh")
	public MobileElement iosLolBtn;

	// meh btn
	@iOSFindBy(name = "boring")
	public MobileElement iosMehBtn;

	// gross Btn
	@iOSFindBy(name = "barf")
	public MobileElement iosGrossBtn;

	// No:of episodes(eg:14 Episodes)
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
	// className = "XCUIElementTypeStaticText")
	public MobileElement iosEpisodes;

	// No:of series episodes
	@iOSFindBy(className = "XCUIElementTypeCell")
	// xpath =
	// "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell")
	public List<MobileElement> iosNoOfSeriesEpisodes;

	// play btn
	@iOSFindBy(name = "play")
	public MobileElement iosPlayBtn;

	// Back button
	@iOSFindBy(name = "Back")
	public MobileElement iosBackBtn;

	// Episode page first episode
	@iOSFindBy(className = "XCUIElementTypeCell")
	// xpath =
	// "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]")
	public MobileElement iosFirstEpisode;

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

			if (iosAbcMeLogo.isDisplayed() && iosSeriesImage.isDisplayed() && iosShowTitle.isDisplayed()
					&& iosSeriesDescription.isDisplayed() && iosAddToMyShowBtn.isDisplayed()
					&& iosSeriesLeftOutTime.isDisplayed()// &&
															// iosEpisodeThinkTxt.isDisplayed()
					&& iosLoveThisBtn.isDisplayed() && iosMehBtn.isDisplayed() && iosGrossBtn.isDisplayed()
					&& iosPlayBtn.isDisplayed()) {
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

			if (iosAbcMeLogo.isDisplayed() && iosSeriesImage.isDisplayed() && iosShowTitle.isDisplayed()
					&& iosSeriesDescription.isDisplayed() && iosAddToMyShowBtn.isDisplayed()
					&& iosSeriesLeftOutTime.isDisplayed() // &&
															// iosEpisodeThinkTxt.isDisplayed()
					&& iosLoveThisBtn.isDisplayed() && iosMehBtn.isDisplayed() && iosGrossBtn.isDisplayed()
					&& iosPlayBtn.isDisplayed() && iosAllEpisodesBtn.isDisplayed()) {
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
