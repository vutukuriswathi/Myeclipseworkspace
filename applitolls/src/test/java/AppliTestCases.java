import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;

public class AppliTestCases {

	@Test
	public void test1() {
		WebDriver driver = new FirefoxDriver();
		Eyes eyes = new Eyes();
		try {

			eyes.setApiKey("YXqclovFkHNuL6QjM4uYoxEPGGhv8u97RgJT8JEEtKko110");
			driver = eyes.open(driver, "TestAppliTools", "test1", new RectangleSize(1000, 700));

			driver.get("http://www.abc.net.au/triplej/programs/hack/");

			// visuval check
			eyes.checkWindow("Hack main page");

			// end visuval testing
			eyes.close();
		} finally {
			eyes.abortIfNotClosed();
			driver.quit();

		}

	}

}
