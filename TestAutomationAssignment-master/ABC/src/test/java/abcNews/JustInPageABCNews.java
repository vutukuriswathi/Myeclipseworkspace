package abcNews;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BasePage;
import utils.TestUtil;

public class JustInPageABCNews extends BasePage {

	public static void navigateToJustInMenu() throws InterruptedException {

		// 3)Verify can navigate to the ‘Just In’ page via the link on the
		// primary navigation.

		TestUtil.captureScreenshot();

		WebElement justInMenuItem = driver.findElement(By.id(OR.getProperty("justInMenuItem")));
		Assert.assertTrue(TestUtil.isElementPresent(justInMenuItem), "Failed: Just In Menu Item is not present");
		Assert.assertTrue(justInMenuItem.isDisplayed(), "Failed: Just In Menu Item is not displayed");
		justInMenuItem.click();
		log.debug("Just In Menu is successfully Clicked");

		Thread.sleep(5000L);
		TestUtil.captureScreenshot();

		Assert.assertEquals(driver.getCurrentUrl(), "http://www.abc.net.au/news/justin/",
				"Failed: Page Url Does Not Match");
		log.debug(driver.getCurrentUrl());
		log.debug("Passed: Page Url matches");

	}

	public static void validateJustInPageContent() {

		TestUtil.captureScreenshot();

		WebElement justInPageHeader = driver.findElement(By.xpath(OR.getProperty("justInPageHeader")));
		Assert.assertTrue(TestUtil.isElementPresent(justInPageHeader), "Failed: Just In Page Header is not present");
		Assert.assertTrue(justInPageHeader.isDisplayed(), "Failed: Just In Page Header is not displayed");
		Assert.assertEquals(justInPageHeader.getText(), "Just In", "Failed: Just In Page Header Text Does Not Match");
		log.debug(justInPageHeader.getText());
		log.debug("Passed: Just In Page Header matches");

		WebElement justInPageSubHeader = driver.findElement(By.xpath(OR.getProperty("justInPageSubHeader")));
		Assert.assertTrue(TestUtil.isElementPresent(justInPageSubHeader),
				"Failed: Just In Page SubHeader is not present");
		Assert.assertTrue(justInPageSubHeader.isDisplayed(), "Failed: Just In Page SubHeader is not displayed");
		Assert.assertEquals(justInPageSubHeader.getText(), "The most recent 250 top stories.",
				"Failed: Just In Page SubHeader Text Does Not Match");
		log.debug(justInPageSubHeader.getText());
		log.debug("Passed: Just In Page SubHeader matches");

		/*
		 * 4) Verify that on the ‘Just In’ page
		 * (http://www.abc.net.au/news/justin/) that the content per article
		 * loads correctly, i.e. must contain:
		 * 
		 * 1. Title 2. Timestamp 3. Text
		 */

		TestUtil.captureScreenshot();

		List<WebElement> justInPageNewsTitles = driver
				.findElements(By.cssSelector(OR.getProperty("justInPageNewsTitles")));
		List<WebElement> justInPageNewsTimeStamps = driver
				.findElements(By.cssSelector(OR.getProperty("justInPageNewsTimeStamps")));
		List<WebElement> justInPageNewsText = driver.findElements(By.xpath(OR.getProperty("justInPageNewsText")));

		log.debug("justInPageNewsTitles Size: " + justInPageNewsTitles.size());
		log.debug("JustInPageNewsTimeStamps Size: " + justInPageNewsTimeStamps.size());
		log.debug("justInPageNewsText Size: " + justInPageNewsText.size());

		for (WebElement title : justInPageNewsTitles) {
			log.debug(title.getText());
			Assert.assertNotNull(title.getText(), "Failed: Just In Page News Title is not displayed correctly");

			// Assert.assertTrue(title.getText().contains("i"),"Failed: Just In
			// Page News Title is not displayed correctly");
		}

		for (WebElement timeStamp : justInPageNewsTimeStamps) {
			log.debug(timeStamp.getText());
			Assert.assertTrue(timeStamp.getText().contains("Posted"),
					"Failed: Just In Page News TimeStamp is not displayed correctly");
		}

		for (WebElement newsText : justInPageNewsText) {
			log.debug(newsText.getText());
			Assert.assertTrue(newsText.getText().contains("a"),
					"Failed: Just In Page News Text is not displayed correctly");
		}
		TestUtil.captureScreenshot();

	}
}