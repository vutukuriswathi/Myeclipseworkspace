package abcNews;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BasePage;
import utils.TestUtil;

public class VideoPageABCNews extends BasePage {

	public static void launchVideoPage() {
		driver.navigate().to(Config.getProperty("ABCNewsVideoPage"));
		TestUtil.captureScreenshot();

	}

	public static void validatePageLoad() throws InterruptedException {

		Thread.sleep(5000L);
		String expPageUrl = Config.getProperty("ABCNewsVideoPage");
		String actPageUrl = driver.getCurrentUrl();

		Assert.assertEquals(actPageUrl, expPageUrl, "Failed: Application URL Does Not Match");
		log.debug("Application Launches Successfully");
		log.debug(actPageUrl);

		TestUtil.captureScreenshot();
		WebElement videoPlayer = driver.findElement(By.id(OR.getProperty("videoPlayer")));
		Assert.assertTrue(TestUtil.isElementPresent(videoPlayer), "Failed: Video Player is not present");
		Assert.assertTrue(videoPlayer.isDisplayed(), "Failed: Video Player is not displayed");
		log.debug("Passed: Video Player is successfully displayed");

		WebElement videoPlayerButton = driver.findElement(By.id(OR.getProperty("videoPlayerButton")));
		Assert.assertTrue(TestUtil.isElementPresent(videoPlayerButton), "Failed: Video Player button is not present");
		Assert.assertTrue(videoPlayerButton.isDisplayed(), "Failed: Video Player button is not displayed");
		log.debug("Passed: Video Player Button is successfully displayed");
		log.debug("Passed: Video is successfully displayed");

	}

	public static void testVideo() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		log.debug("JavascriptExecutor is instantiated successfully");

				// Play Video for 5 seconds
				jse.executeScript("jwplayer().play();");
				TestUtil.captureScreenshot();
				Thread.sleep(5000);
				log.debug("Passed: Video played for 5 seconds");
		
				// Pause Video for 5 seconds
				jse.executeScript("jwplayer().pause()");
				TestUtil.captureScreenshot();
				Thread.sleep(5000);
				log.debug("Passed: Video paused for 5 seconds");
		
				// Play Video again for 5 seconds
				jse.executeScript("jwplayer().play();");
				TestUtil.captureScreenshot();
				Thread.sleep(5000);
				log.debug("Passed: Video played for 5 seconds");
		
				// Set Volume to 50%
				jse.executeScript("jwplayer().setVolume(50);");
				TestUtil.captureScreenshot();
				Thread.sleep(2000);
		
				// Mute Player for 5 seconds
				jse.executeScript("jwplayer().setMute(true);");
				Thread.sleep(5000);
		
				// UnMute Player
				jse.executeScript("jwplayer().setMute(false);");
				TestUtil.captureScreenshot();
				Thread.sleep(5000);
		
				// Stop the video
				jse.executeScript("jwplayer().stop()");
				TestUtil.captureScreenshot();

	}
}
