package utils;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class TestUtil extends BasePage {

	public static String mailscreenshotpath;

	public static void captureScreenshot() {

		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH); // 4
		int year = cal.get(Calendar.YEAR); // 2013
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.HOUR_OF_DAY);
		try {

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			mailscreenshotpath = System.getProperty("user.dir") + "\\test-output\\screenShots\\" + year + "_" + date + "_"
					+ (month + 1) + "_" + day + "_" + min + "_" + sec + ".jpeg";
			FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean isElementPresent(WebElement element){
		
		if(element.isDisplayed()){
				return true;
		}else{
			return false;
		}
		
	}

}
