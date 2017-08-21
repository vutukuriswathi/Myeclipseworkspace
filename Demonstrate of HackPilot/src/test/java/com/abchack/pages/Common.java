package com.abchack.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.abchack.testcases.TestBase;
import com.abchack.util.Constants;

public class Common {

	public WebDriver driver;

	// w3c validator url
	@FindBy(id = Constants.validatorUrl)
	public WebElement urlAdress;

	// w3c result field
	@FindBy(xpath = Constants.validatorresult)
	public WebElement resultField;

	@FindBy(xpath = Constants.more)
	public WebElement more;

	@FindBy(xpath = Constants.world_menuitem)
	public WebElement world_menuitem;

	public Common(WebDriver dr) {
		driver = dr;
	}

	/**
	 * validates the given url with w3cvalidator and returns true if it contains
	 * >0 errors or warnings,other wise it returns false
	 * 
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
		waitTillVisible(resultField, 10);
		// capturing the whole result
		String result = resultField.getText();
		TestBase.logger.info("whole result is" + result);
		String[] errors = result.split(" ");
		TestBase.logger.info("errors is " + errors[0] + "warnings" + errors[2]);

		// returns true if the page has any error or warnings
		Assert.assertFalse(Integer.parseInt(errors[0]) > 0 || Integer.parseInt(errors[2]) > 0, url + "has " + result);

	}

	// If we click on more menu then sub elements of more menu should display
	public void moreNavigation() {
		driver.get(Constants.channel_page_url);
		more.click();
		waitTillVisible(world_menuitem, 10);
		for (int i = 8; i <= 16; i++) {
			WebElement currentItem = driver
					.findElement(By.xpath(".//*[@id='navigationPrimary3']/nav/ul/li[17]/ul/li[" + i + "]/span"));
			System.out.println(currentItem.getText());
		}

	}

	// wait until the element is visible and it will return that element after
	// it is visible
	public void waitTillVisible(WebElement locator, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(locator));

	}

}
