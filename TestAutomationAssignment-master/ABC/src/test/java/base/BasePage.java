
package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utils.ExcelReader;
import utils.TestUtil;

public class BasePage {

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static TestUtil util;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\testdata.xlsx");

	@BeforeSuite
	public void setUp() throws IOException, ClassNotFoundException, SQLException {

		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\Softwares\\Selenium\\geckodriver-v0.16.1-win64\\geckodriver.exe"
		 * );
		 */

		if (driver == null) {

			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);

			log.debug("OR Properties loaded");

			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			Config.load(fis);
			log.debug("Config Properties loaded");

			if (Config.getProperty("browser").equals("firefox")) {
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("plugin.state.flash", true);
				driver = new FirefoxDriver(profile);
			} else if (Config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
			} else if (Config.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(25000L, TimeUnit.MILLISECONDS);
			TestUtil.captureScreenshot();
		}

	}

	@AfterSuite
	public void tearDown() {

		driver.quit();

	}

}
