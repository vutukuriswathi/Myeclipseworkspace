package com.abchack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.abchack.util.Constants;
import com.abchack.util.ErrorUtil;

public class All {

	public WebDriver driver;

	@FindBy(id = Constants.username)
	public WebElement username;

	public All(WebDriver dr) {
		driver = dr;
	}

	public static void verifyLinks() {

		System.out.println("hi this is test");
		try {
			Assert.assertEquals("hello", "hello1");
		} catch (Throwable e) {
			ErrorUtil.addVerificationFailure(e);
		}
	}

}
