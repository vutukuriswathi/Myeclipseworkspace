import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class TestAndoridTestdroid {

	@Test
	public void test1() throws MalformedURLException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("testdroid_username", "srivastava.abhidhir@abc.net.au");
		caps.setCapability("testdroid_password", "Regiment14");
		caps.setCapability("testdroid_target", "chrome");
		caps.setCapability("testdroid_project", "Appiumchromeandroid");
		caps.setCapability("testdroid_testrun", "testrun1");
		caps.setCapability("testdroid_device", "Asus Google Nexus 7 (2013) ME571KL");

		caps.setCapability("deviceName", "AndroidDevice");

		caps.setCapability("browserName", "chrome");

		caps.setCapability("platformName", "Android");

		WebDriver driver = new AndroidDriver(new URL("http://appium.testdroid.com/wd/hub"), caps);
		Thread.sleep(5000L);
		driver.get("http://www.ebay.com");

		Thread.sleep(2000L);
		// driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("swathi");
		Assert.assertTrue(true);
		driver.quit();

	}

}
