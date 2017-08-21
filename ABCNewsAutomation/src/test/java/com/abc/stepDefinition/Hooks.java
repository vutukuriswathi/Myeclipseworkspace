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
	public static String platform;

	@Before
	public void beforeMethod(Scenario cscenario) throws IOException {

		currentScenario = cscenario;

		ClassLoader loader = Thread.currentThread().getContextClassLoader();

		Properties platformConfig = new Properties();
		platformConfig.load(loader.getResourceAsStream("com/abc/config/platform.properties"));

		platform = platformConfig.getProperty("platform");

		// Loading the androidconfig properties file and initializing the driver
		if (platformConfig.getProperty("platform").equalsIgnoreCase("android")) {

			Properties androidConfig = new Properties();
			androidConfig.load(loader.getResourceAsStream("com/abc/config/androidConfig.properties"));
			if (platformConfig.getProperty("environment").equalsIgnoreCase("local")) {
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

			if (platformConfig.getProperty("environment").equalsIgnoreCase("saucelabs")) {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("appiumVersion", "1.4.15");
				caps.setCapability("deviceName", "Android Emulator");
				caps.setCapability("deviceOrientation", "portrait");

				caps.setCapability("platformVersion", "5.1");
				caps.setCapability("platformName", "Android");
				caps.setCapability("name", "ABCNEWSAndroid");
				caps.setCapability("appActivity", androidConfig.getProperty("appActivity"));
				caps.setCapability("appPackage", androidConfig.getProperty("appPakcage"));

				caps.setCapability("autoAcceptAlerts", true);
				File appdir = new File(System.getProperty("user.dir") + "/src/test/resources/com/abc/mobileApps/"
						+ androidConfig.getProperty("androidAppName") + ".apk");

				caps.setCapability("app", "sauce-storage:abcapp-debug.zip");
				driver = new AndroidDriver(
						new URL("http://gunuputis4r:9cb3db7a-7fd4-4c55-ba12-041e4a20d61f@ondemand.saucelabs.com:80/wd/hub"),
						caps);
			}

		}

		// Loading the iosconfig properties file and initializing the driver
		if (platformConfig.getProperty("platform").equalsIgnoreCase("ios")) {
			Properties iosConfig = new Properties();
			iosConfig.load(loader.getResourceAsStream("com/abc/config/iosConfig.properties"));

			if (platformConfig.getProperty("environment").equalsIgnoreCase("local")) {
				// setting the desired capabilities of iphone
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("udid", iosConfig.getProperty("udid"));
				capabilities.setCapability("bundleId", iosConfig.getProperty("appBundleId"));
				capabilities.setCapability("platformName", platformConfig.getProperty("platform"));
				capabilities.setCapability("platformVersion", iosConfig.getProperty("iosDeviceVersion"));
				capabilities.setCapability("deviceName", iosConfig.getProperty("iosDeviceName"));
				File appdir = new File(System.getProperty("user.dir") + "/src/test/resources/com/abc/mobileApps/"
						+ iosConfig.getProperty("iosAppName") + ".ipa");
				capabilities.setCapability("app", appdir.getAbsolutePath());
				capabilities.setCapability("autoAcceptAlerts", true);
				driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			}
			if (platformConfig.getProperty("environment").equalsIgnoreCase("saucelabs")) {

				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("appiumVersion", "1.4.16");
				caps.setCapability("deviceName", "iPhone 6");
				caps.setCapability("deviceOrientation", "portrait");
				caps.setCapability("platformVersion", "9.0");
				caps.setCapability("platformName", "iOS");
				caps.setCapability("name", "ABCNEWSIOS");
				caps.setCapability("app", "sauce-storage:ABCAppFile.zip");
				// caps.setCapability("app", "sauce-storage:abcphone.zip");
				caps.setCapability("autoAcceptAlerts", true);
				driver = new IOSDriver(
						new URL("http://gunuputis4r:9cb3db7a-7fd4-4c55-ba12-041e4a20d61f@ondemand.saucelabs.com:80/wd/hub"),
						caps);

			}

		}

	}

	@After
	public void AfterMethod(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			embedScreenshot();
		}

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
