package androidwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.selendroid.common.SelendroidCapabilities;




public class TestClass {
	
	public static void main(String[] args)
	{
		DesiredCapabilities  caps = SelendroidCapabilities.android();
		WebDriver driver = new SelendroidDriver("http://localhost:5555/wd/hub",caps);
		driver.get("http://www.google.com");
		
	}

}
