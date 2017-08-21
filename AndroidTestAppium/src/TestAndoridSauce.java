import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class TestAndoridSauce {

	@Test
	public void test1() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("appiumVersion", "1.4.10");
		caps.setCapability("deviceName", "Android Emulator");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("browserName", "Browser");
		caps.setCapability("platformVersion", "5.1");
		caps.setCapability("platformName", "Android");

		WebDriver driver = new AndroidDriver(
				new URL("http://abcdnqa:395b9330-e745-4a7f-a168-afac68f286f5@ondemand.saucelabs.com:80/wd/hub"), caps);
		driver.get("http://www.ebay.com");
		driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("swathi");
		driver.quit();

	}

}
