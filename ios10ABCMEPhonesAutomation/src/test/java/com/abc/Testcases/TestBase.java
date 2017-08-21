package com.abc.Testcases;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class TestBase {

	public static AppiumDriver driver;
	public static String platform;
	public static String environment;
	public static String screenshotenvironment;

	/**
	 * @Method: beforeMethod
	 * @param:
	 * @Description:This method will initialize the driver
	 * @author :swathi Gunuputi
	 */
	public void beforeMethod() throws IOException {

		ClassLoader loader = Thread.currentThread().getContextClassLoader();

		Properties platformConfig = new Properties();
		platformConfig.load(loader.getResourceAsStream("com/iview/config/platform.properties"));
		platform = platformConfig.getProperty("platform");
		environment = platformConfig.getProperty("environment");
		screenshotenvironment = platformConfig.getProperty("screenshotenvironment");

		// Loading the androidconfig properties file and initializing the driver
		if (platformConfig.getProperty("platform").equalsIgnoreCase("android")) {

			Properties androidConfig = new Properties();
			androidConfig.load(loader.getResourceAsStream("com/iview/config/androidConfig.properties"));
			if (platformConfig.getProperty("environment").equalsIgnoreCase("local")) {
				// setting the desired capabilities of android
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("platformName", platformConfig.getProperty("platform"));
				capabilities.setCapability("platformVersion", androidConfig.getProperty("androidDeviceVersion"));
				capabilities.setCapability("deviceName", androidConfig.getProperty("androidDeviceName"));
				File appdir = new File(System.getProperty("user.dir") + "/src/test/resources/com/iview/mobileApps/"
						+ androidConfig.getProperty("androidAppName") + ".apk");
				capabilities.setCapability("app", appdir.getAbsolutePath());
				capabilities.setCapability("appActivity", androidConfig.getProperty("appActivity"));
				capabilities.setCapability("appPackage", androidConfig.getProperty("appPakcage"));
				// capabilities.setCapability("autoAcceptAlerts", true);
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			}

		}

		// Loading the iosconfig properties file and initializing the driver
		if (platformConfig.getProperty("platform").equalsIgnoreCase("ios")) {
			Properties iosConfig = new Properties();
			iosConfig.load(loader.getResourceAsStream("com/iview/config/iosConfig.properties"));

			if (platformConfig.getProperty("environment").equalsIgnoreCase("local")) {

				// setting the desired capabilities of iphone
				DesiredCapabilities capabilities = new DesiredCapabilities();

				// capabilities.setCapability("automationName", "XCUITest");
				// capabilities.setCapability("xcodeConfigFile", //
				// "/Users/gunuputis4r/Desktop/Config.xcconfig");
				// capabilities.setCapability("realDeviceLogger",
				// "/usr/local/lib/node_modules/deviceconsole/deviceconsole");
				//
				// capabilities.setCapability("udid",
				// iosConfig.getProperty("udid"));
				// capabilities.setCapability("bundleId",
				// iosConfig.getProperty("appBundleId"));
				// capabilities.setCapability("platformName",
				// platformConfig.getProperty("platform"));
				// capabilities.setCapability("platformVersion",
				// iosConfig.getProperty("iosDeviceVersion"));
				// capabilities.setCapability("deviceName",
				// iosConfig.getProperty("iosDeviceName")); //
				// capabilities.setCapability("xcodeConfigFile", //
				// System.getProperty("user.dir") + //
				// "/src/test/resources/Config.xcconfig");
				// File appdir = new File(System.getProperty("user.dir") +
				// "/src/test/resources/com/iview/mobileApps/"
				// + iosConfig.getProperty("iosAppName") + ".ipa");
				// capabilities.setCapability("app", appdir.getAbsolutePath());
				// capabilities.setCapability("autoAcceptAlerts", true);

				driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			}

		}
	}

	/**
	 * @Method: afterMethod
	 * @param:
	 * @Description:This method will quit the driver
	 * @author :swathi Gunuputi
	 */
	public void afterMethod() throws Exception {

		driver.quit();
	}

	/**
	 * @Method: getDriver
	 * @param:
	 * @Description:This method will return the driver
	 * @author :swathi Gunuputi
	 */
	public static AppiumDriver getDriver() {
		return driver;
	}

	/**
	 * @Method: takeScreenshot
	 * @param:
	 * @Description:This method will take the screenshot
	 * @author :swathi Gunuputi
	 */
	public static boolean takeScreenshot(final String name) {
		if (TestBase.screenshotenvironment.equalsIgnoreCase("aws")) {
			String screenshotDirectory = System.getProperty("appium.screenshots.dir",
					System.getProperty("java.io.tmpdir", ""));
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
		}

		else {
			File scrFile = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
			DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
			String destDir = "target/surefire-reports/screenshots";
			new File(destDir).mkdirs();
			String destFile = dateFormat.format(new Date()) + ".png";
			File outputFile = new File(destDir + "/" + destFile);
			try {

				FileUtils.copyFile(scrFile, outputFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Reporter.log("Saved <a href=../screenshots/" + outputFile.getName() + ">Screenshot</a>");
			return true;
		}

	}
}