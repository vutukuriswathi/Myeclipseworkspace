package com.abc.stepDefinition;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Hooks {

	public static AppiumDriver driver;
	public static Scenario currentScenario;

	@Before
	public void beforeMethod(Scenario cscenario) throws IOException {

		currentScenario = cscenario;

		ClassLoader loader = Thread.currentThread().getContextClassLoader();

		Properties platformConfig = new Properties();
		platformConfig.load(loader.getResourceAsStream("com/abc/config/platform.properties"));

		// Loading the androidconfig properties file and initializing the driver
		if (platformConfig.getProperty("platform").equalsIgnoreCase("android")) {
			Properties androidConfig = new Properties();
			androidConfig.load(loader.getResourceAsStream("com/abc/config/androidConfig.properties"));

			// setting the desired capabilities of android
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", platformConfig.getProperty("platform"));
			capabilities.setCapability("platformVersion", androidConfig.getProperty("androidDeviceVersion"));
			capabilities.setCapability("deviceName", androidConfig.getProperty("androidDeviceName"));
			File appdir = new File(System.getProperty("user.dir") + "/src/test/resources/com/abc/mobileApps/"
					+ androidConfig.getProperty("androidAppName") + ".apk");
			capabilities.setCapability("app", appdir.getAbsolutePath());
			capabilities.setCapability("appActivity", androidConfig.getProperty("appActivity"));
			capabilities.setCapability("appPackage", androidConfig.getProperty("appPakcage"));
			capabilities.setCapability("autoAcceptAlerts", true);
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		}

		// Loading the iosconfig properties file and initializing the driver
		if (platformConfig.getProperty("platform").equalsIgnoreCase("ios")) {
			Properties iosConfig = new Properties();
			iosConfig.load(loader.getResourceAsStream("iosConfig.properties"));

			// setting the desired capabilities of iphone
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("udid", iosConfig.getProperty("udid"));
			capabilities.setCapability("udid", iosConfig.getProperty("appBundleId"));
			capabilities.setCapability("platformName", platformConfig.getProperty("platform"));
			capabilities.setCapability("platformVersion", iosConfig.getProperty("iosDeviceVersion"));
			capabilities.setCapability("deviceName", iosConfig.getProperty("iosDeviceName"));
			capabilities.setCapability("app", "com/abc/mobileApps/" + iosConfig.getProperty("iosAppName") + ".ipa");
			capabilities.setCapability("autoAcceptAlerts", true);
			driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		}

	}

	@After
	public void AfterMethod(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			embedScreenshot();
		}

		// GenerateTestReport testReport = new GenerateTestReport();
		// testReport.generateCustomReport();
		driver.quit();
	}

	public static void embedScreenshot() {
		byte[] srcFile = driver.getScreenshotAs(OutputType.BYTES);
		currentScenario.embed(srcFile, "image/png");
	}

	public static AppiumDriver getDriver() {
		return driver;
	}

}
