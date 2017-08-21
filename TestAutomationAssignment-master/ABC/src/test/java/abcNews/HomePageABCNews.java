package abcNews;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BasePage;
import utils.TestUtil;

public class HomePageABCNews extends BasePage {

	public static void launchApplication() {
		driver.navigate().to(Config.getProperty("ABCNewsHomePage"));
		TestUtil.captureScreenshot();
	}

	public static void validatePageLoad() {

		String expPageUrl = Config.getProperty("ABCNewsHomePage");
		String actPageUrl = driver.getCurrentUrl();

		Assert.assertEquals(actPageUrl, expPageUrl, "Failed: Application URL Does Not Matches");
		log.debug("Application Launches Successfully");
		log.debug(actPageUrl);

		String actPageTitle = driver.getTitle();
		String expPageTitle = excel.getCellData("ABCNews", "ABCNewsHomePageTitle", 2);

		Assert.assertEquals(actPageTitle, expPageTitle, "Failed: Page Title Does Not Match");
		log.debug("Page Title Matches");
		log.debug(actPageTitle);
		TestUtil.captureScreenshot();

	}

	public static void validateNewsBanner() {

		/*************
		 * Checking for upper header in the News banner
		 **************/

		TestUtil.captureScreenshot();

		WebElement newsHeader = driver.findElement(By.id(OR.getProperty("newsHeader")));
		Assert.assertTrue(TestUtil.isElementPresent(newsHeader), "Failed: Header is not present");
		Assert.assertTrue(newsHeader.isDisplayed(), "Failed: Header is not displayed");
		log.debug("Passed: ABC News Header is successfully displayed");

		/*************
		 * Checking for the contents of the upper header
		 *************/
		WebElement menuSiteLink = driver.findElement(By.xpath(OR.getProperty("menuSiteLink")));
		Assert.assertTrue(menuSiteLink.isDisplayed(), "Failed: Menu Sites is not displayed correctly");
		log.debug("Passed: Menu Sites is successfully displayed");

		WebElement abcNewsLink = driver.findElement(By.xpath(OR.getProperty("abcNewsLink")));
		Assert.assertTrue(abcNewsLink.isDisplayed(), "Failed: ABC News Link is not displayed correctly");
		log.debug("Passed: ABC News Link is successfully displayed");

		WebElement searchLink = driver.findElement(By.xpath(OR.getProperty("searchLink")));
		Assert.assertTrue(searchLink.isDisplayed(), "Failed: Search Link is not displayed correctly");
		log.debug("Passed: Search Link is displayed successfully");

		WebElement containerHeader = driver.findElement(By.id(OR.getProperty("containerHeader")));
		Assert.assertTrue(containerHeader.isDisplayed(), "Failed: Container Header is not displayed correctly");
		log.debug("Passed: Container Header is successfully displayed");

		WebElement newsLogo = driver.findElement(By.xpath(OR.getProperty("newsLogo")));
		Assert.assertTrue(newsLogo.isDisplayed(), "Failed: News Logo is not displayed");
		log.debug("Passed: News Logo is successfully displayed");

		WebElement setLocationLink = driver.findElement(By.xpath(OR.getProperty("setLocationLink")));
		Assert.assertTrue(setLocationLink.isDisplayed(), "Failed: Set Location Link is not displayed correctly");
		log.debug("Passed: Set Location Link is successfully displayed");

		WebElement setLocationText = driver.findElement(By.xpath(OR.getProperty("setLocationText")));
		Assert.assertTrue((setLocationText.getText().startsWith("SET LOCATION")),
				"Set Location text is not displayed correctly");
		log.debug("Passed: Set Location text is correctly displayed");

		TestUtil.captureScreenshot();

	}

}
