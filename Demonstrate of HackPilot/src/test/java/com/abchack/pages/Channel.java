package com.abchack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Channel {

	public WebDriver driver;

	@FindBy()
	public WebElement EmailHack;

	@FindBy()
	public WebElement name;

	@FindBy
	public WebElement email;

	@FindBy()
	public WebElement subject;

	@FindBy()
	public WebElement message;

	@FindBy()
	public WebElement sendEmail;

	public Channel(WebDriver dr) {
		driver = dr;
	}

	public void sendContactEmail() {

	}

}
