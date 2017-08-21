import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;

public class TestIphone {

	@Test
	public void test1() throws MalformedURLException

	{

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "iOS");
		cap.setCapability("deviceName", "iPhone Simulator");
		cap.setCapability("platformVersion", "8.4");
		cap.setCapability("browserName", "Safari");
		cap.setCapability("idleTimeout", 1000);
		cap.setCapability("name", "iphonemobileapp1");
		// platformVersion
		// cap.setCapability("app",
		// "/Users/gunuputis4r/Downloads/selendroid-test-app-0.11.0-3.apk");
		// cap.setCapability("appActivity",
		// "io.selendroid.testapp.HomeScreenActivity");
		// cap.setCapability("appPackage", "io.selendroid.testapp");

		// cap.setCapability("app", "/Users/gunuputis4r/Downloads/Chrome.apk");
		// cap.setCapability("appActivity",
		// "com.google.android.apps.chrome.Main");
		// cap.setCapability("appPackage", "com.android.chrome");

		// WebDriver driver = new IOSDriver(new
		// URL("http://127.0.0.1:4723/wd/hub"), cap);
		WebDriver driver = new IOSDriver(
				new URL("http://gunuputis4r:9cb3db7a-7fd4-4c55-ba12-041e4a20d61f@ondemand.saucelabs.com:80/wd/hub"),
				cap);
		driver.get("http://www.google.com");
		System.out.println("title is " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Google");
		driver.quit();
	}

}
