package com.williamHill.Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.williamHill.pages.BetSlip;
import com.williamHill.pages.HomePage;
import com.williamHill.util.Constants;
import com.williamHill.util.ErrorUtil;

public class TestWilliamHill extends TestBase {

	@BeforeMethod
	public void beforeMethod() {

		// Initializes configuration file
		initConfigurations();

		// creates the driver
		createDriver();

	}

	/**
	 * @Method: verifyHorseBetting
	 * @param:
	 * @Description:This method will check whether the end user will be able to
	 *                   add a horse to the betslip and it will also check
	 *                   whether he is able to add the stack and those values
	 *                   are displaying correctly or not.
	 * @author :swathi Gunuputi
	 */
	@Test
	public void verifyHorseBetting() throws InterruptedException {

		waitTillPageLoad();
		driver.manage().timeouts().implicitlyWait(50L, TimeUnit.SECONDS);
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.nextToJump.click();
		homePage.interstedHorse.click();
		Thread.sleep(3000L);

		try {
			Assert.assertTrue(homePage.betSlipBadge.getAttribute("data-count").equals(Constants.betSlipBadgeCount),
					"badslipbage count is not matching with the expected one");
		} catch (Throwable e) {
			Reporter.log("badslipbage count is not matching with the expected one" + Constants.betSlipBadgeCount);
			ErrorUtil.addVerificationFailure(e);
		}
		homePage.betSlipBadge.click();
		BetSlip betSlipPage = PageFactory.initElements(driver, BetSlip.class);
		betSlipPage.stake.sendKeys(Constants.stakeAmount);

		try {
			Assert.assertTrue(betSlipPage.totalBets.getText().equals(Constants.expectedBets),
					"No:of bets are not matched with the expected bets");
		} catch (Throwable e) {
			Reporter.log("No:of Bets not matched with the expected Bets" + Constants.expectedBets);
			ErrorUtil.addVerificationFailure(e);
		}

		try {
			Assert.assertTrue(betSlipPage.totalStake.getText().equals(Constants.expectedStake),
					"Total stake is not matched with the expected stake");
		} catch (Throwable e) {
			Reporter.log("Total stake is not matched with the expected stake" + Constants.expectedStake);
			ErrorUtil.addVerificationFailure(e);
		}

		try {
			Assert.assertTrue(betSlipPage.possiblePayout.isDisplayed(), "possible payout is not displayed");
		} catch (Throwable e) {
			Reporter.log("possible payout is not displayed");
			ErrorUtil.addVerificationFailure(e);
		}

	}

	@AfterMethod
	public void afterMethod() {
		quitDriver();
	}

}
