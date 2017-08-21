
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;

public class FacebookMobile {

	@Test
	public void test1() throws MalformedURLException, InterruptedException

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

		WebDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		// WebDriver driver = new IOSDriver(
		// new
		// URL("http://abcdnqa:395b9330-e745-4a7f-a168-afac68f286f5@ondemand.saucelabs.com:80/wd/hub"),
		// cap);
		driver.get("http://wcms-www.test.abc.net.au/test-triplej/programs/hack/stomach-earth/200192388");
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");
		}
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		int i = frames.size();
		driver.switchTo().frame(i - 1);
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//*[@type='submit']")).click();

		driver.quit();
	}

}
