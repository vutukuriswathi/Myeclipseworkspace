package ExtentReportSelenium.ExtentReportSelenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SmokeTest {

	ExtentReports reports;
	ExtentTest logger;
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/gunuputis4r/Downloads/chromedriver-3");
		// driver = new ChromeDriver();
		/// Users/gunuputis4r/Documents/marionette/geckodriver
		// MarionetteDriverManager.getInstance().setup();
		System.setProperty("webdriver.gecko.driver", "/Users/gunuputis4r/Documents/marionette/geckodriver");
		// System.setProperty("webdriver.firefox.marionette",
		// "/Users/gunuputis4r/Documents/marionette/geckodriver");
		driver = new FirefoxDriver();
		reports = new ExtentReports(System.getProperty("user.dir") + "/target/extentReport.html");
	}

	@Test
	public void testGoogleTitle() throws InterruptedException {

		logger = reports.startTest("testGoogleTitle", "This is testing the tile of google page");

		logger.log(LogStatus.INFO, "starting the browser");

		driver.get("http://www.google.com");

		Thread.sleep(5000L);

		logger.log(LogStatus.INFO, "asserting the title");

		Assert.assertEquals(driver.getTitle(), "Google1");

		logger.log(LogStatus.PASS, "testcase passed");

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			new File("target/Screenshots").mkdirs();
			File destFile = new File(result.getName() + ".png");
			FileUtils.copyFile(srcFile, new File("target/Screenshots/" + destFile));
			System.out.println(System.getProperty("user.dir") + "/target/Screenshots/" + destFile);
			String image = logger.addScreenCapture(System.getProperty("user.dir") + "/target/Screenshots/" + destFile);
			File destVideo = new File(
					System.getProperty("user.dir") + "/target/Screenshots/" + result.getName() + "1.mp4");

			logger.log(LogStatus.FAIL, result.getName(), image);
			logger.log(LogStatus.FAIL, result.getName(),
					// logger.addScreencast(System.getProperty("user.dir") +
					// "/target/Screenshots/" + destVideo));
					logger.addScreencast("destvideo.mp4"));
		}

		reports.endTest(logger);
		reports.flush();
		// driver.get(System.getProperty("user.dir") +
		// "/target/extentReport.html");
		driver.quit();

	}

}
