package com.williamHill.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.williamHill.util.Constants;

public class BetSlip {

	public WebDriver driver;

	@FindBy(id = Constants.stake)
	public WebElement stake;

	@FindBy(id = Constants.totalBets)
	public WebElement totalBets;

	@FindBy(id = Constants.totalStake)
	public WebElement totalStake;

	@FindBy(id = Constants.possiblePayout)
	public WebElement possiblePayout;

	public BetSlip(WebDriver driver) {
		this.driver = driver;
	}

}
