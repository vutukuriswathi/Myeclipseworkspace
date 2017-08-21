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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.abchack.screenshot.ScreenShotOnFailure;
import com.abchack.util.Constants;
import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

//@Listeners({ SauceOnDemandTestListener.class })
public class TestBase implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider {

	public static Logger logger = null;
	public static WebDriver driver = null;
	public static Properties config = null;
	private static int counter;
	public static String screenshotFolderName;

	/**
	 * Constructs a {@link com.saucelabs.common.SauceOnDemandAuthentication}
	 * instance using the supplied user name/access key. To use the
	 * authentication supplied by environment variables or from an external
	 * file, use the no-arg
	 * {@link com.saucelabs.common.SauceOnDemandAuthentication} constructor.
	 */
	public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication("gunuputis4r",
			"9cb3db7a-7fd4-4c55-ba12-041e4a20d61f");

	/**
	 * ThreadLocal variable which contains the {@link WebDriver} instance which
	 * is used to perform browser interactions with.
	 */
	private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	/**
	 * ThreadLocal variable which contains the Sauce Job Id.
	 */
	private ThreadLocal<String> sessionId = new ThreadLocal<String>();

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

				new Object[] { "safari", "8.1", "ios" }// , new Object[]
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
	 */

	public void createDriverTestdroid(String browser, String version, String os, String methodName)
			throws MalformedURLException {

		/*
		 * DesiredCapabilities caps = new DesiredCapabilities();
		 * caps.setCapability("platformName", "iOS");
		 * caps.setCapability("deviceName", "iPhone Simulator");
		 * caps.setCapability("platformVersion", "8.4");
		 * caps.setCapability("browserName", "Safari");
		 * caps.setCapability("idleTimeout", 1000);
		 * 
		 * caps.setCapability("idleTimeout", 600);
		 * caps.setCapability("maxDuration", 10800); String jobName =
		 * methodName; screenshotFolderName = os; caps.setCapability("name",
		 * jobName); driver = new IOSDriver((new URL("http://" +
		 * authentication.getUsername() + ":" + authentication.getAccessKey() +
		 * "@ondemand.saucelabs.com:80/wd/hub")), caps); //
		 * sessionId.set(((RemoteWebDriver) //
		 * getWebDriver()).getSessionId().toString());
		 * 
		 * driver = webDriver.get(); ScreenShotOnFailure screenshot =
		 * PageFactory.initElements(driver, ScreenShotOnFailure.class);
		 */
		if (driver == null) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("testdroid_username", "srivastava.abhidhir@abc.net.au");
			caps.setCapability("testdroid_password", "Regiment14");
			caps.setCapability("testdroid_target", "safari");
			caps.setCapability("testdroid_project", "Appiumsafariios");
			caps.setCapability("testdroid_testrun", "testrun1");
			caps.setCapability("testdroid_device", "Apple iPhone 4S A1387 8.4.1");
			caps.setCapability("newCommandTimeout", 120);
			caps.setCapability("deviceName", "iOS Device");
			caps.setCapability("device", "iphone");

			caps.setCapability("browserName", "Safari");

			caps.setCapability("platformName", "iOS");

			driver = new IOSDriver(new URL("http://appium.testdroid.com/wd/hub"), caps);
		}
	}

	public void createDriverSauceLabs(String browser, String version, String os, String methodName)
			throws MalformedURLException {
		if (driver == null) {

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", "iOS");
			caps.setCapability("deviceName", "iPhone Simulator");
			caps.setCapability("platformVersion", "8.4");
			caps.setCapability("browserName", "Safari");

			caps.setCapability("idleTimeout", 300);
			caps.setCapability("maxDuration", 10800);
			String jobName = methodName;
			screenshotFolderName = os;
			caps.setCapability("name", jobName);
			driver = new IOSDriver((new URL("http://" + authentication.getUsername() + ":"
					+ authentication.getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub")), caps);
			// sessionId.set(((IOSDriver)
			// getWebDriver()).getSessionId().toString());
			String id = ((IOSDriver) driver).getSessionId().toString();
			sessionId.set(id);

			// driver = webDriver.get();

		}
	}

	/**
	 * @return the {@link WebDriver} for the current thread
	 */
	public WebDriver getWebDriver() {
		System.out.println("WebDriver" + webDriver.get());
		return webDriver.get();
	}

	/**
	 *
	 * @return the Sauce Job id for the current thread
	 */
	@Override
	public String getSessionId() {
		return sessionId.get();
	}

	/**
	 *
	 * @return the {@link SauceOnDemandAuthentication} instance containing the
	 *         Sauce username/access key
	 */
	@Override
	public SauceOnDemandAuthentication getAuthentication() {
		return authentication;
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
