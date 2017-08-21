package com.abchack.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;

import com.abchack.util.Constants;
import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;

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

	// Initializing the driver

	public void createDriver(String browser, String version, String os, String methodName) {
		if (driver == null) {
			if (config.getProperty("browser").equalsIgnoreCase("firefox")) {

				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", config.getProperty("ie_exe_path"));
				driver = new InternetExplorerDriver();
			} else if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", Constants.chrome_exe_path);
				driver = new ChromeDriver();

			} else if (config.getProperty("browser").equalsIgnoreCase("safari")) {
				System.setProperty("webdriver.safari.driver", config.getProperty("safari_exe_path"));
			}
		}

	}

	// Quitting the driver
	public void quitDriver() {
		driver.quit();
		driver = null;
	}

	/**
	 * DataProvider that explicitly sets the browser combinations to be used.
	 *
	 * @param testMethod
	 * @return
	 */
	@DataProvider(name = "hardCodedBrowsers", parallel = false)

	public static Object[][] sauceBrowserDataProvider(Method testMethod) {
		return new Object[][] { new Object[] { "internet explorer", "11", "Windows 8.1" }
				// new Object[] { "safari", "6", "OSX 10.8" },
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

	/*
	 * public void createDriver(String browser, String version, String os,
	 * String methodName) throws MalformedURLException {
	 * 
	 * DesiredCapabilities capabilities = new DesiredCapabilities();
	 * capabilities.setCapability(CapabilityType.BROWSER_NAME, browser); if
	 * (version != null) { capabilities.setCapability(CapabilityType.VERSION,
	 * version); } capabilities.setCapability(CapabilityType.PLATFORM, os);
	 * capabilities.setCapability("idleTimeout", 1000); String jobName =
	 * methodName + '_' + os + '_' + browser + '_' + version;
	 * screenshotFolderName = os + '_' + browser + '_' + version;
	 * capabilities.setCapability("name", jobName); webDriver.set(new
	 * RemoteWebDriver(new URL("http://" + authentication.getUsername() + ":" +
	 * authentication.getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub"),
	 * capabilities)); sessionId.set(((RemoteWebDriver)
	 * getWebDriver()).getSessionId().toString()); driver = webDriver.get(); //
	 * driver = webDriver.get(); ScreenShotOnFailure screenshot =
	 * PageFactory.initElements(driver, ScreenShotOnFailure.class); }
	 */

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
		String fullFileName = System.getProperty("user.dir") + "/" + screenshotFolderName + "/"
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
