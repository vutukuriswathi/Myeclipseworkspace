package ABCGroupid.AppiumTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DragAndDrop {

	@Test
	public void test1() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Android");
		cap.setCapability("platformVersion", "5.0.2");
		cap.setCapability("platformName", "Android");
		cap.setCapability("app", "/Users/gunuputis4r/Documents/Appium/TestFolder/com.mobeta.android.demodslv.apk");
		cap.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
		cap.setCapability("appPackage", "com.mobeta.android.demodslv");
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_desc")).get(0).click();
		MobileElement elem = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(0);
		TouchAction act = new TouchAction(driver);
		act.longPress(elem).moveTo(driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(3))
				.release().perform();

	}
}
