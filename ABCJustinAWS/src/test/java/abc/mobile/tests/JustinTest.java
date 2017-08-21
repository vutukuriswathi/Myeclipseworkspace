package abc.mobile.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
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
		androidConfig.load(new FileInputStream(
				System.getProperty("user.dir") + "/src/test/java/abc/mobile/config/androidConfig.properties"));

		// loading the stories property file
		stories = new Properties();
		stories.load(new FileInputStream(
				System.getProperty("user.dir") + "/src/test/java/abc/mobile/config/stories.properties"));

		if (androidConfig.getProperty("environment").equalsIgnoreCase("local")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", androidConfig.getProperty("device.name"));
			capabilities.setCapability("platformName", androidConfig.getProperty("device.platformName"));
			capabilities.setCapability("platformVersion", androidConfig.getProperty("device.platformVersion"));
			capabilities.setCapability("enablePerformanceLogging", true);
			capabilities.setCapability("appPackage", androidConfig.getProperty("app.Package"));
			capabilities.setCapability("appActivity", androidConfig.getProperty("app.Activity"));
			capabilities.setCapability("appWaitActivity", androidConfig.getProperty("app.WaitActivity"));
			capabilities.setCapability("autoAcceptAlerts", true);
			File appdir = new File(System.getProperty("user.dir") + "/src/test/java/abc/mobile/apps");
			File app = new File(appdir, androidConfig.getProperty("test.app.name") + ".apk");
			capabilities.setCapability("app", app.getAbsolutePath());
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}

		if (androidConfig.getProperty("environment").equalsIgnoreCase("saucelabs")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("appiumVersion", "1.4.15");
			caps.setCapability("deviceName", "Android Emulator");
			caps.setCapability("deviceOrientation", "portrait");
			caps.setCapability("browserName", "");
			caps.setCapability("platformVersion", "4.4");
			caps.setCapability("platformName", "Android");
			caps.setCapability("name", "flagshipappmonitoring");
			caps.setCapability("appPackage", androidConfig.getProperty("app.Package"));
			caps.setCapability("appActivity", androidConfig.getProperty("app.Activity"));
			caps.setCapability("appWaitActivity", androidConfig.getProperty("app.WaitActivity"));
			caps.setCapability("autoAcceptAlerts", true);
			File appdir = new File(System.getProperty("user.dir") + "/src/test/java/abc/mobile/apps");
			File app = new File(appdir, androidConfig.getProperty("test.app.name") + ".apk");
			caps.setCapability("app", "sauce-storage:myapplication.zip");
			driver = new AndroidDriver(
					new URL("http://gunuputis4r:9cb3db7a-7fd4-4c55-ba12-041e4a20d61f@ondemand.saucelabs.com:80/wd/hub"),
					caps);
		}

		if (androidConfig.getProperty("environment").equalsIgnoreCase("testdroid")) {
			// get the free android device
			// deviceFinderAndroid();

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", androidConfig.getProperty("test.testdroid.platformName"));
			capabilities.setCapability("testdroid_target", androidConfig.getProperty("test.testdroid.target"));
			capabilities.setCapability("deviceName", "Samsung Galaxy Nexus SPH-L700 4.3");
			capabilities.setCapability("testdroid_username", androidConfig.getProperty("test.testdroid.username"));
			capabilities.setCapability("testdroid_password", androidConfig.getProperty("test.testdroid.password"));
			capabilities.setCapability("testdroid_project", androidConfig.getProperty("test.testdroid.project"));
			capabilities.setCapability("autoAcceptAlerts", true);
			String strTestRun = androidConfig.getProperty("test.testdroid.testrun");

			capabilities.setCapability("testdroid_testrun", strTestRun);
			capabilities.setCapability("testdroid_device", "Samsung Galaxy Nexus SPH-L700 4.3");
			capabilities.setCapability("testdroid_app", androidConfig.getProperty("test.testdroid.app"));
			driver = new AndroidDriver(new URL(androidConfig.getProperty("test.testdroid.server") + "/wd/hub"),
					capabilities);

		}
	}

	public void deviceFinderAndroid() throws IOException {

		String url = "https://cloud.testdroid.com/api/v2/devices?limit=0";
		String line = "";
		boolean flag = false;

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		request.addHeader("content-type", "application/json");
		request.addHeader("Accept", "application/json");

		HttpResponse response = client.execute(request);

		System.out.println("Sending GET request to URL :" + url);
		System.out.println("Response Code :" + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();

		while ((line = rd.readLine()) != null)

		{
			result.append(line);
		}

		System.out.println(result.toString());
		String jsonInput = result.toString();

		JSONObject outerObject = new JSONObject(jsonInput);

		JSONArray jsonArray = outerObject.getJSONArray("data");
		for (int i = 0, size = jsonArray.length(); i < size; i++) {
			JSONObject objectInArray = jsonArray.getJSONObject(i);

			JSONObject softwareVersion = new JSONObject((objectInArray.get("softwareVersion")).toString());

			if ((objectInArray.getInt("creditsPrice") == 0) && (objectInArray.getBoolean("locked") == false)
					&& ((String) objectInArray.get("osType")).equals("ANDROID")
					&& softwareVersion.getInt("apiLevel") > 16) {

				System.out.println("found device" + objectInArray.get("displayName"));
				androiddevicename = (String) objectInArray.get("displayName");
				flag = true;
				break;

			}

		}
		if (flag == false)
			System.out.println("No device found");

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

		FileOutputStream out = new FileOutputStream(
				System.getProperty("user.dir") + "/src/test/java/abc/mobile/config/stories.properties");
		stories.setProperty("top1", topStories.get(0).getText());
		stories.setProperty("top2", topStories.get(1).getText());
		stories.setProperty("top3", topStories.get(2).getText());
		stories.store(out, "properties file updated");
		out.close();

		Assert.assertTrue(story1 && story2 && story3, "justin stories are not refreshed");

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
