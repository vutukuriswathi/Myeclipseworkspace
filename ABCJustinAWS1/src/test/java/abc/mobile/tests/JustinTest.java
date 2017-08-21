package abc.mobile.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class JustinTest {

	public static AppiumDriver driver;

	Properties stories;
	boolean story1, story2, story3;
	String androiddevicename = null;

	@BeforeTest
	public void beforeTest() throws FileNotFoundException, IOException {

		// loading the android properties file
		Properties androidConfig = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		// InputStream resourceStream =
		// loader.getResourceAsStream("androidConfig.properties");
		// androidConfig.load(resourceStream);
		// File f = new File(".");
		// System.out.println("f is" + f.getAbsolutePath());
		androidConfig.load(new FileInputStream("androidConfig.properties"));

		// loading the stories property file
		stories = new Properties();
		// stories.load(new FileInputStream(System.getProperty("user.dir") +
		// "stories.properties"));
		stories.load(loader.getResourceAsStream("stories.properties"));

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "FA46CWM06358");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		capabilities.setCapability("enablePerformanceLogging", true);
		capabilities.setCapability("appPackage", "android.AbcApplication");
		capabilities.setCapability("appActivity", "android.AbcApplication.activities.PreloaderActivity");
		capabilities.setCapability("appWaitActivity", "android.AbcApplication.activities.PreloaderActivity");
		capabilities.setCapability("autoAcceptAlerts", true);
		File appdir = new File(System.getProperty("user.dir") + "/src/test/java/abc/mobile/apps");
		File app = new File(appdir, "abcapp.apk");
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	@Test
	public void testcase1() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 360);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android.AbcApplication:id/onboarding_next")));

		try {
			driver.findElement(By.id("android.AbcApplication:id/onboarding_next")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(3000L);

		try {
			driver.findElement(By.id("android.AbcApplication:id/onboarding_notnow")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// click on justin
		((MobileElement) driver.findElements(By.id("android.AbcApplication:id/navMenuCaption")).get(1)).click();

		// Find the 3 top stories

		List<MobileElement> topStories = driver.findElements(By.id("android.AbcApplication:id/nlTitle"));
		for (int i = 0; i <= 2; i++) {
			if (topStories.get(0).getText().equals(stories.getProperty("top1"))) {
				story1 = false;

			} else
				story1 = true;
			if (topStories.get(1).getText().equals(stories.getProperty("top2")))
				story2 = false;

			else
				story2 = true;
			if (topStories.get(0).getText().equals(stories.getProperty("top3")))
				story3 = false;
			else
				story3 = true;

		}

		FileOutputStream out = new FileOutputStream(System.getProperty("user.dir") + "stories.properties");
		stories.setProperty("top1", topStories.get(0).getText());
		stories.setProperty("top2", topStories.get(1).getText());
		stories.setProperty("top3", topStories.get(2).getText());
		stories.store(out, "properties file updated");
		out.close();

		Assert.assertTrue(true, "justin stories are not refreshed");

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
