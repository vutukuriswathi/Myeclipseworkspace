package com.abchack.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.abchack.testcases.TestBase;
import com.abchack.util.Constants;
import com.abchack.util.ErrorUtil;
import com.abchack.util.TestUtil;

public class CommonPage {

	public WebDriver driver;

	// w3c validator url
	@FindBy(id = Constants.validatorUrl)
	public WebElement urlAdress;

	// w3c result field
	@FindBy(xpath = Constants.validatorresult)
	public WebElement resultField;

	// id of w3c link checker url field
	@FindBy(id = Constants.w3cLinkCheckerUrl)
	public WebElement w3cLinkCheckerUrl;

	// link text of w3c link checker results field
	@FindBy(linkText = Constants.w3cLinkCheckerResults)
	public WebElement w3cLinkCheckerResults;

	// xpath of w3c link checker results table
	@FindBy(xpath = Constants.w3cLinkCheckerResultsTable)
	public WebElement w3cLinkCheckerResultsTable;

	@FindBy(xpath = Constants.more)
	public WebElement more;

	@FindBy(id = Constants.topMenuItems)
	public WebElement topMenuItems;

	public CommonPage(WebDriver dr) {
		driver = dr;
	}

	/**
	 * validates the given url with w3cvalidator and returns true if it contains
	 * >0 errors or warnings,other wise it returns false
	 * 
	 * @param url
	 * @throws InterruptedException
	 */
	public void w3cValidatorTest(String url) throws InterruptedException {
		// logging to validator site
		driver.get(Constants.w3cValidatorLink);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		TestBase.logger.info("Entering to w3c validator site");
		driver.manage().window().maximize();

		// enter the url for which you want to test the validator
		urlAdress.sendKeys(url);
		urlAdress.sendKeys(Keys.ENTER);
		// Thread.sleep(6000L);
		TestUtil.waitTillVisible(resultField, 10);
		// capturing the whole result
		String result = resultField.getText();
		TestBase.logger.info("whole result is" + result);
		String[] errors = result.split(" ");
		TestBase.logger.info("errors is " + errors[0] + "warnings" + errors[2]);

		// returns true if the page has any error or warnings
		Assert.assertFalse(Integer.parseInt(errors[0]) > 0 || Integer.parseInt(errors[2]) > 0, url + "has " + result);

	}

	/**
	 * This method will validates the given url against w3c link checker and
	 * fails it it contains errors.
	 * 
	 * @param url
	 * @throws InterruptedException
	 */
	public void w3cLinkChecker(String url, String ScreenshotName) throws InterruptedException {
		driver.get(Constants.w3cLinkChecker);
		w3cLinkCheckerUrl.sendKeys(url);
		w3cLinkCheckerUrl.sendKeys(Keys.ENTER);
		Thread.sleep(120000L);
		w3cLinkCheckerResults.click();
		WebElement table = w3cLinkCheckerResultsTable;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		TestBase.takeScreenshot(ScreenshotName);
		Assert.assertFalse(rows.size() > 0, url + "contains errors");

	}

	/**
	 * If we click on more menu then sub elements of more menu should display
	 * and all the remaining menu elements should display with out clicking any
	 * thing.
	 * 
	 * @param screenshotName
	 * @throws InterruptedException
	 */
	public void verifyMenuItems(String screenshotName) throws InterruptedException {
		// get all the menu items
		List<WebElement> menuitems = topMenuItems.findElements(By.tagName("a"));
		int menuitemssize = menuitems.size();
		for (int i = 0; i < (menuitemssize - 1); i++) {

			// if any of the menu items is not displayed then at that point more
			// menu item started and we need to click more menu item
			if (!menuitems.get(i).isDisplayed()) {

				// It will click the more menu item
				more.click();
				Thread.sleep(Constants.shortWait);

				try {
					// check whether the sub items under more menu is visible or
					// not
					Assert.assertTrue(
							driver.findElement(By.xpath("//*[@id='page-header']/div/ul/li[" + (i + 1) + "]/a"))
									.isDisplayed());
				} catch (Throwable e) {

					Reporter.log(driver.findElement(By.xpath("//*[@id='page-header']/div/ul/li[" + (i + 1) + "]/a"))
							.getText() + " is not displayed");
					ErrorUtil.addVerificationFailure(e);

				}

			} else {

				try {
					// check whether the menu items are visible or
					// not
					Assert.assertTrue(menuitems.get(i).isDisplayed());
				} catch (Throwable e) {
					Reporter.log(menuitems.get(i).getText() + " is not displayed");
					ErrorUtil.addVerificationFailure(e);
				}

			}
		}
	}
}
