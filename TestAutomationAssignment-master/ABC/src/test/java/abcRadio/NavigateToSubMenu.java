package abcRadio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import base.BasePage;
import utils.TestUtil;

public class NavigateToSubMenu extends BasePage {

	public static void navigateToBigIdea() throws InterruptedException {

		WebElement programMenu = driver.findElement(By.xpath(OR.getProperty("programMenu")));
		Assert.assertTrue(TestUtil.isElementPresent(programMenu), "Failed: Program Menu is not present");
		Assert.assertTrue(programMenu.isDisplayed(), "Failed: Program Menu is not displayed");
		log.debug("Passed: On ABC Radio Home Page, Program Menu successfully displayed");

		WebElement bigIdeaSubMenu = driver.findElement(By.xpath(OR.getProperty("bigIdeaSubMenu")));

		Actions action = new Actions(driver);
		action.moveToElement(programMenu).build().perform();
		Thread.sleep(1000L);
		bigIdeaSubMenu.click();
		Thread.sleep(5000L);
		
		TestUtil.captureScreenshot();

		Assert.assertEquals(driver.getCurrentUrl(), "http://www.abc.net.au/radionational/programs/bigideas/",
				"Failed: Big Idea Page fails to load");
		WebElement bigIdeaPageHeader = driver.findElement(By.className(OR.getProperty("bigIdeaPageHeader")));
		Assert.assertTrue(TestUtil.isElementPresent(bigIdeaPageHeader), "Failed: Big Idea header is not present");
		Assert.assertTrue(bigIdeaPageHeader.isDisplayed(), "Failed: Big Idea header is not displayed");

		String bigIdeaPageHeaderText = bigIdeaPageHeader.getText();
		Assert.assertEquals(bigIdeaPageHeaderText, "Big Ideas",
				"Failed: Big Idea Header Text is not displayed correctly");
		log.debug("Passed: Successfully Navigated to Big Idea Page");

	}
}
