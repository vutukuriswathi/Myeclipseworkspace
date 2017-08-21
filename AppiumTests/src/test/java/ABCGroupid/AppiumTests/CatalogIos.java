package ABCGroupid.AppiumTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class CatalogIos {
	public AppiumDriver driver;

	@Test
	public void test1() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "8.4");
		capabilities.setCapability("deviceName", "iPhone 5s");
		capabilities.setCapability("app",
				"/Users/gunuputis4r/Library/Developer/Xcode/DerivedData/UICatalog-etbwgpcbxgomkkeypliryolqobmz/Build/Products/Debug-iphonesimulator/UICatalog.app");
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[8]/UIAStaticText[1]")).click();
		System.out
				.println(driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPicker[1]/UIAPickerWheel[1]"))
						.getAttribute("values"));
	}

}
