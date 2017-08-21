package abcRadio;

import org.testng.Assert;

import base.BasePage;
import utils.TestUtil;

public class LaunchABCRadio extends BasePage {

	public static void launchRadioApplication() {
		driver.navigate().to(Config.getProperty("ABCRadioHomePageUrl"));
		TestUtil.captureScreenshot();
	}

	public static void validatePageLoad() {

		String expPageUrl = Config.getProperty("ABCRadioHomePageUrl");
		String actPageUrl = driver.getCurrentUrl();

		Assert.assertEquals(actPageUrl, expPageUrl, "Application URL Matches");
		log.debug("Passed: ABC Radio successfully launches");
		log.debug(actPageUrl);

		String actPageTitle = driver.getTitle();
		String expPageTitle = excel.getCellData("ABCRadio", "ABCRadioHomePageTitle", 2);

		Assert.assertEquals(actPageTitle, expPageTitle, "Page Title Does Not Match");
		log.debug("Page Title Matches");
		log.debug(actPageTitle);
		TestUtil.captureScreenshot();

	}
	
	public static void NavigateToRadioTestPage() {
		driver.navigate().to(Config.getProperty("ABCRadioTestPageUrl"));
		TestUtil.captureScreenshot();
	}

}
