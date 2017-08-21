package com.abchack.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.abchack.pages.Common;

@Listeners({ com.abchack.screenshot.ScreenShotOnFailure.class })
public class HackTests extends TestBase {

	// Initializes configuration,logger and driver
	@BeforeSuite
	public void beforeSuite() {
		// Initializes logger and configuration file
		initConfigurations();

		// Initializes the corresponding webdriver
		initDriver();
	}

	/*
	 * @Test /* public void testcase1() throws InterruptedException {
	 * 
	 * Common commonobj = PageFactory.initElements(driver, Common.class);
	 * commonobj.w3cValidatorTest(Constants.channel_page_url); }
	 */

	/*
	 * @Test public void testcase2() throws InterruptedException {
	 * driver.get("https://validator.w3.org/checklink");
	 * driver.findElement(By.id("uri_1")).sendKeys(Constants.channel_page_url);
	 * driver.findElement(By.id("uri_1")).sendKeys(Keys.ENTER);
	 * Thread.sleep(400000L); driver.findElement(By.linkText("the results"));
	 * WebElement
	 * table=driver.findElement(By.xpath(".//*[@id='main']/table[1]"));
	 * List<WebElement> rows=table.findElements(By.tagName("tr")); for(int
	 * i=1;i<rows.size();i++) { List<WebElement> cols =
	 * rows.get(i).findElements(By.tagName("td")); for(int
	 * j=0;j<cols.size();j++) { System.out.println(cols.get(j).getText()); }
	 * System.out.println("\n");
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 */

	@Test
	public void testcase3() {

		Common commonobj = PageFactory.initElements(driver, Common.class);
		commonobj.moreNavigation();

	}

	@AfterSuite
	public void afterSuite() {
		quitDriver();
	}

}
