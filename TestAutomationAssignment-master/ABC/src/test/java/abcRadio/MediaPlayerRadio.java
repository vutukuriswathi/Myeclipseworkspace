package abcRadio;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BasePage;
import utils.TestUtil;

public class MediaPlayerRadio extends BasePage {

	public static String backUp;
	// ABCRadioTestPageUrl

	public static void DownloadAudioFeature() throws InterruptedException {

		WebElement downloadAudioButton = driver.findElement(By.xpath(OR.getProperty("downloadAudioButton")));
		downloadAudioButton.click();
		TestUtil.captureScreenshot();

		String mediaPlayerUrl = driver.getCurrentUrl();
		log.debug("Media Player Url: " + mediaPlayerUrl);
		Assert.assertTrue(mediaPlayerUrl.startsWith("http://mpegmedia.abc.net.au"),
				"Failed: MPEG Player not launched successfully");
		log.debug("Passed: MPEG Player successfully launched");

		// wait for 10 seconds
		Thread.sleep(10000L);

		Assert.assertTrue(driver.findElement(By.cssSelector(OR.getProperty("mediaPlayer"))).isDisplayed(),
				"Failed: Error playing audio");
		log.debug("Audio is successfully being played");

		driver.navigate().back();
		TestUtil.captureScreenshot();
	}

	public static void ListenAudioFeature() throws InterruptedException {

		WebElement listenNowButton = driver.findElement(By.cssSelector(OR.getProperty("listenNowButton")));
		listenNowButton.click();
		log.debug("Listen Now button is successfully clicked");

		Thread.sleep(5000L);
		TestUtil.captureScreenshot();
		String basePageWinId = driver.getWindowHandle();
		Set<String> winIds = driver.getWindowHandles();
		backUp = basePageWinId;
		winIds.remove(basePageWinId);

		String listenNowPage = winIds.iterator().next();
		driver.switchTo().window(listenNowPage);
		log.debug("Successfully switched to Listen Now Page");

		String actListenNowUrl = driver.getCurrentUrl();
		log.debug("Listen Now Page Url: " + actListenNowUrl);

		String expListenNowUrl = "https://radio.abc.net.au/programitem/pel3PKe2MD?play=true";
		Assert.assertEquals(actListenNowUrl, expListenNowUrl, "Failed: Url is incorrect");
		log.debug("Listen Now Page Url matches");

		// Listen to audio for 10 seconds
		Thread.sleep(10000L);
		TestUtil.captureScreenshot();

	}

	public static void ValidateAudioPlayer() {

		TestUtil.captureScreenshot();
		Assert.assertTrue(driver.findElement(By.id(OR.getProperty("audioPlayer"))).isDisplayed(),
				"Failed: Audio Player is not loaded successfully");

		Assert.assertTrue(driver.findElement(By.cssSelector(OR.getProperty("audioPlayerPlayButton"))).isDisplayed(),
				"Failed: Audio Player Control is not loaded successfully");

		log.debug("Passed " + driver.findElement(By.xpath(OR.getProperty("audioPlayerTrackTitle"))).getText());

		log.debug("Passed: Audio Player is loaded successfully");

	}

	public static void CloseAudioPlayer() throws InterruptedException {

		driver.close();
		log.debug("Successfully closed the Listen Now Page");
		driver.switchTo().window(backUp);
		log.debug("Successfully switched to Base Page");
		driver.navigate().refresh();
		Thread.sleep(5000L);
		TestUtil.captureScreenshot();

	}
}
