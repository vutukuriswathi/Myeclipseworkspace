import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHack {

	@Test
	public static void test1() throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://wcms-www.test.abc.net.au/test-triplej/programs/hack/");
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

		driver.findElement(By.linkText("Hack on iTunes")).click();
		Thread.sleep(5000L);
		Set<String> winHandles = driver.getWindowHandles();
		Iterator<String> winIter = winHandles.iterator();
		String mainWindow = winIter.next();
		String childWindow = winIter.next();
		driver.switchTo().window(childWindow);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://itunes.apple.com/au/podcast/hack/id78995043?mt=2"),
				"hack on itunes is not redirecting to correct site");
		driver.quit();

	}
}