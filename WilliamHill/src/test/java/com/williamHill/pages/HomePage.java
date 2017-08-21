package com.williamHill.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.williamHill.util.Constants;

public class HomePage {

	public WebDriver driver;

	// next to jump element
	@FindBy(css = Constants.nextToJump)
	public WebElement nextToJump;

	// race lists element
	@FindBy(className = Constants.raceLists)
	public WebElement raceLists;

	@FindBy(className = Constants.runnerListHorses)
	public WebElement runnerListHorses;

	@FindBy(xpath = Constants.InterestedHorse)
	public WebElement interstedHorse;

	@FindBy(id = Constants.betSlipBadge)
	public WebElement betSlipBadge;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

}
