import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TestAndorid {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "Android Emulator");
		cap.setCapability("platformVersion", "5.1");

		cap.setCapability("browserName", "Chrome");
		// platformVersion
		// cap.setCapability("app",
		// "/Users/gunuputis4r/Downloads/selendroid-test-app-0.11.0-3.apk");
		// cap.setCapability("appActivity",
		// "io.selendroid.testapp.HomeScreenActivity");
		// cap.setCapability("appPackage", "io.selendroid.testapp");

		cap.setCapability("app", "/Users/gunuputis4r/Downloads/com.android.chrome.apk");
		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		cap.setCapability("appPackage", "com.android.chrome");

		WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		// WebDriver driver = new AndroidDriver(
		// new
		// URL("http://abcdnqa:395b9330-e745-4a7f-a168-afac68f286f5@ondemand.saucelabs.com:80/wd/hub"),
		// cap);
		driver.get("http://www.ebay.com");
		driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("swathi");
		driver.quit();
	}

}
