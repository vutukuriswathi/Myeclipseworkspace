package ABCGroupid.screenshottest;

import  java.io.File ;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import  java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import  org.testng.ITestResult ;
import  org.testng.Reporter ;


public class ScreenShotOnFailure implements ITestListener {
	
	public WebDriver driver;
	public ScreenShotOnFailure(){
		
	}
	public ScreenShotOnFailure(WebDriver dr)
	{
		driver =dr;
	}

  
	public  void  onTestFailure(ITestResult tr) 
  { 
		
		File scrFile = ((TakesScreenshot)HackTests.driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
		String destDir = "target/surefire-reports/screenshots";
		new  File(destDir).mkdirs();
		String destFile = dateFormat.format(new Date()) + ".png";

        try {
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			 e.printStackTrace ();
		}
	//	Reporter.setEscapeHtml(false);
		Reporter.log("Saved <a href=target/surefire-reports/screenshots/" + destFile + ">Screenshot</a>");
	}

public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	
}

public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	
}
}
