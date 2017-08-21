import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;

public class TestIphoneTestDroid {

	@Test
	public void test1() throws MalformedURLException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("testdroid_username", "srivastava.abhidhir@abc.net.au");
		caps.setCapability("testdroid_password", "Regiment14");
		caps.setCapability("testdroid_target", "safari");
		caps.setCapability("testdroid_project", "Appiumsafariios");
		caps.setCapability("testdroid_testrun", "testrun1");
		caps.setCapability("testdroid_device", "Apple iPhone 4S A1387 8.4.1");
		caps.setCapability("newCommandTimeout", 120);
		// caps.setCapability("testdroid_device", "Apple iPhone 4S A1387
		// 6.1.3");
		caps.setCapability("deviceName", "iOS Device");
		caps.setCapability("device", "iphone");

		caps.setCapability("browserName", "Safari");

		caps.setCapability("platformName", "iOS");

		WebDriver driver = new IOSDriver(new URL("http://appium.testdroid.com/wd/hub"), caps);

		driver.get("http://www.ebay.com");

		// driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("swathi");
		Assert.assertTrue(true);
		driver.quit();

	}

}
