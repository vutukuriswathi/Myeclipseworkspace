package com.abchack.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.abchack.testcases.TestBase;

public class TestUtil {

	public static void takeScreenshot() {

		File srcfile = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateformat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");

	}

	// wait until the element is visible and it will return that element after
	// it is visible
	public static void waitTillVisible(WebElement locator, int timeout) {

		WebDriverWait wait = new WebDriverWait(TestBase.driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(locator));

	}

}
