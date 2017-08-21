package com.abchack.screenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.abchack.testcases.TestBase;

public class ScreenShotOnFailure extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult tr) {

		File scrFile = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
		String destDir = "target/surefire-reports/screenshots";
		new File(destDir).mkdirs();
		String destFile = dateFormat.format(new Date()) + tr.getName() + ".png";
		File outputFile = new File(destDir + "/" + destFile);
		try {

			FileUtils.copyFile(scrFile, outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Reporter.setEscapeHtml(false);
		Reporter.log("Saved <a href=../screenshots/" + outputFile.getName() + ">Screenshot</a>");
		// Reporter.log("<a href='"+ outputFile.getName()+"'>Screenshot</a>");
	}
}
