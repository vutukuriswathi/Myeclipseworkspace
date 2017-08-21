package ABCGroupid.AppiumTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class FlipBoardSwipe {
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", "/Users/gunuputis4r/Downloads/flipboard.app-3.3.13-APK4Fun.com.apk");
		capabilities.setCapability("appPackage", "flipboard.app");
		capabilities.setCapability("appActivity", "flipboard.activities.LaunchActivity");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// WebElement elem = (WebElement)
		// driver.findElements(By.id("flipboard.app:id/coverStoryContainer")).get(0);
		// elem.click();
		Thread.sleep(3000L);
		driver.swipe(420, 1264, 420, 758, 1000);
		Thread.sleep(3000L);
		driver.quit();

	}

}
