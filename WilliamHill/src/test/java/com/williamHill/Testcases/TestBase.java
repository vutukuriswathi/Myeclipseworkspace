package com.williamHill.Testcases;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.williamHill.util.Constants;

public class TestBase {

	public static WebDriver driver = null;
	public static Properties config = null;
	private static int counter;
	public static String screenshotFolderName;

	/**
	 * @Method: initConfigurations
	 * @param:
	 * @Description:This method will loads the configuration files.
	 * @author :swathi Gunuputi
	 */
	public void initConfigurations() {

		// config.prop
		config = new Properties();
		try {
			FileInputStream is = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/williamHill/config/config.properties");
			config.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @Method: quitDriver
	 * @param:
	 * @Description:This method will quit the driver.
	 * @author :swathi Gunuputi
	 */
	public void quitDriver() {
		driver.quit();
		driver = null;
	}

	// Initializing the driver

	/**
	 * @Method: createDriver
	 * @param:
	 * @Description:This method will initiate the corresponding webdriver.
	 * @author :swathi Gunuputi
	 */
	public void createDriver() {

		if (driver == null) {
			if (config.getProperty("browser").equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", config.getProperty("ie_exe_path"));
				driver = new InternetExplorerDriver();

			} else if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", config.getProperty("chrome_exe_path"));
				driver = new ChromeDriver();

			} else if (config.getProperty("browser").equalsIgnoreCase("safari")) {
				System.setProperty("webdriver.safari.driver", config.getProperty("safari_exe_path"));
				driver = new SafariDriver();
			}
			driver.get(Constants.williamHillSite);
			driver.manage().window().maximize();
		}

	}

	/**
	 * @Method: waitTillPageLoad
	 * @param:
	 * @Description:This method will wait till the page loads.
	 * @author :swathi Gunuputi
	 */
	public void waitTillPageLoad() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");
		}
	}

}
