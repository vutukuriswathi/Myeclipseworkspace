package abcRadio;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BasePage;
import utils.TestUtil;

public class SocialMediaIcons extends BasePage {

	public static void ValidateTwitterIcon() throws InterruptedException {

		TestUtil.captureScreenshot();
		driver.switchTo().frame(OR.getProperty("iFrameIdTwitter"));
		WebElement twitterIcon = driver.findElement(By.id(OR.getProperty("twitterIcon")));
		twitterIcon.click();

		Set<String> winIds = driver.getWindowHandles();
		String basePageWinId = driver.getWindowHandle();
		String backUp = basePageWinId;
		winIds.remove(basePageWinId);
		String twitterPageWinId = winIds.iterator().next();
		driver.switchTo().window(twitterPageWinId);
		driver.manage().window().maximize();
		Thread.sleep(5000L);
		TestUtil.captureScreenshot();
		log.debug("Twitter URL: " + driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().startsWith("https://twitter.com/"),
				"Failed: Twitter is not displayed successfully");
		log.debug("Passed: Twitter is successfully displayed");

		driver.close();

		driver.switchTo().window(backUp);
		TestUtil.captureScreenshot();
		Thread.sleep(2000L);
		driver.navigate().refresh();
	}

	public static void ValidateFacebookIcon() throws InterruptedException {

		TestUtil.captureScreenshot();
		driver.switchTo().frame(driver.findElement(By.xpath(OR.getProperty("iFrameIdFacebook"))));
		Thread.sleep(4000L);

		WebElement facebookIcon = driver.findElement(By.id(OR.getProperty("facebookIcon")));
		facebookIcon.click();

		Set<String> winIds = driver.getWindowHandles();
		String basePageWinId = driver.getWindowHandle();
		String backUp = basePageWinId;
		winIds.remove(basePageWinId);
		String fbPageWinId = winIds.iterator().next();
		driver.switchTo().window(fbPageWinId);
		driver.manage().window().maximize();

		Thread.sleep(4000L);
		log.debug("Facebook URL: " + driver.getCurrentUrl());
		TestUtil.captureScreenshot();
		Assert.assertTrue(driver.getCurrentUrl().startsWith("https://www.facebook.com"),
				"Failed: Facebook is not displayed successfully");

		log.debug("Passed: Facebook is successfully displayed");

		driver.close();
		driver.switchTo().window(backUp);
		driver.navigate().refresh();
		Thread.sleep(2000L);
		TestUtil.captureScreenshot();
	}
}
