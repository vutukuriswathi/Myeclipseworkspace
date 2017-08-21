package com.abchack.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.abchack.testcases.TestBase;

public class TestUtil {

	public static void takeScreenshot() {

		File srcfile = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateformat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");

	}

}
