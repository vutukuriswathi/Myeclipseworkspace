package com.abchack.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.abchack.screenshot.ScreenShotOnFailure;
import com.abchack.util.Constants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class TestBase {

	public static Logger logger = null;
	public static AppiumDriver driver = null;
	public static Properties config = null;
	private static int counter;
	public static String screenshotFolderName;

	public void initConfigurations() {
		if (config == null) {
			// BasicConfigurator.configure();
			logger = Logger.getLogger("devpinoyLogger");

		}
		// config.prop
		config = new Properties();
		try {
			FileInputStream is = new FileInputStream(Constants.Config_File_Path);
			config.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Quitting the driver
	public void quitDriver() {
		driver.quit();
		driver = null;
	}

	// Initializing the driver

	public void createDriver(String browser, String version, String os, String methodName)
			throws MalformedURLException {
		if (driver == null) {
			if (config.getProperty("browser").equalsIgnoreCase("iphone")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("platformName", "iOS");
				cap.setCapability("deviceName", "iPhone Simulator");
				cap.setCapability("browserName", "safari");
				cap.setCapability("platformVersion", "8.4");
				driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			} else if (config.getProperty("browser").equalsIgnoreCase("android")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("platformName", "Android");
				cap.setCapability("deviceName", "Android Emulator");
				cap.setCapability("platformVersion", "5.1");

				cap.setCapability("browserName", "Chrome");

				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			}
		}
		ScreenShotOnFailure screenshot = PageFactory.initElements(driver, ScreenShotOnFailure.class);

	}

	/**
	 * DataProvider that explicitly sets the browser combinations to be used.
	 *
	 * @param testMethod
	 * @return
	 */
	@DataProvider(name = "hardCodedBrowsers", parallel = false)

	public static Object[][] sauceBrowserDataProvider(Method testMethod) {
		return new Object[][] {

				new Object[] { "safari", "8.1", "OS X 10.11" }// , new Object[]
																// { "firefox",
																// "41.0",
																// "Windows 8.1"
																// },
				// new Object[] { "internet explorer", "11", "Windows 8.1" },
				// new Object[] { "chrome", "45.0", "Windows 8.1" }
				// , new Object[] { "safari", "7.0", "OS X 10.9" },
				// new Object[] { "safari", "6", "OSX 10.8" }, new Object[] {
				// "internet explorer", "10.0", "Windows 8" }
		};

	}

	/**
	 * /** Constructs a new {@link RemoteWebDriver} instance which is configured
	 * to use the capabilities defined by the browser, version and os
	 * parameters, and which is configured to run against
	 * ondemand.saucelabs.com, using the username and access key populated by
	 * the {@link #authentication} instance.
	 *
	 * @param browser
	 *            Represents the browser to be used as part of the test run.
	 * @param version
	 *            Represents the version of the browser to be used as part of
	 *            the test run.
	 * @param os
	 *            Represents the operating system to be used as part of the test
	 *            run.
	 * @return
	 * @throws MalformedURLException
	 *             if an error occurs parsing the url
	 * @throws InterruptedException
	 */

	public void createDriver1(String browser, String version, String os, String methodName)
			throws MalformedURLException, InterruptedException {
		// Thread.sleep(60000L);

		if (driver == null) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("testdroid_username", "srivastava.abhidhir@abc.net.au");
			caps.setCapability("testdroid_password", "Regiment14");
			caps.setCapability("testdroid_target", "chrome");
			caps.setCapability("testdroid_project", "HackPilot1");
			caps.setCapability("testdroid_testrun", methodName);
			caps.setCapability("testdroid_device", "Asus Google Nexus 7 (2013) ME571KL");

			caps.setCapability("deviceName", "AndroidDevice");

			caps.setCapability("browserName", "chrome");

			caps.setCapability("platformName", "Android");
			caps.setCapability("newCommandTimeout", 180);

			driver = new AndroidDriver(new URL("http://appium.testdroid.com/wd/hub"), caps);
		}
		// ScreenShotOnFailure screenshot = PageFactory.initElements(driver,
		// ScreenShotOnFailure.class);
	}

	public static void takeScreenshot(String screenshotName) {
		counter = counter + 1;
		String fullFileName = System.getProperty("user.dir") + "/target/surefire-reports/" + screenshotFolderName + "/"
				+ getScreenshotsCounter() + "_" + screenshotName + ".png";

		screenshot(fullFileName);
	}

	public static File screenshot(String name) {
		System.out.println("Taking screenshot...");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			File testScreenshot = new File(name);
			FileUtils.copyFile(scrFile, testScreenshot);
			System.out.println("Screenshot stored to " + testScreenshot.getAbsolutePath());

			return testScreenshot;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getScreenshotsCounter() {
		if (counter < 10) {
			return "0" + counter;
		} else {
			return String.valueOf(counter);
		}
	}

}
