package ABCGroupid.AppiumTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidContact {

	@Test
	public void test1() throws MalformedURLException {
		AndroidDriver driver;
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Android Emulator");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "4.4.2");
		cap.setCapability("app", "/Users/gunuputis4r/Documents/Appium/TestFolder/ContactManager.apk");
		cap.setCapability("appActivity", "com.example.android.contactmanager.ContactManager");
		cap.setCapability("appPackage", "com.example.android.contactmanager");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.findElement(By.name("Add Contact")).click();
		List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
		textFieldsList.get(0).sendKeys("Some Name");
		textFieldsList.get(2).sendKeys("Some@example.com");
		driver.swipe(100, 500, 100, 100, 2);
		driver.findElementByName("Save").click();
		driver.quit();

	}

}
