import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Icons {

	@Test
	public void CheckRedirectionsOFIcons() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://wcms-www.test.abc.net.au/test-triplej/programs/hack/");
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

		driver.findElement(By.cssSelector(".social-icon.social-channels-triplej.list-item-icon.icon-triplej")).click();
		Thread.sleep(5000L);
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		driver.findElement(By.cssSelector(".social-icon.social-channels-facebook.list-item-icon.icon-facebook"))
				.click();
		Thread.sleep(5000L);
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		driver.findElement(By.cssSelector(".social-icon.social-channels-twitter.list-item-icon.icon-twitter")).click();
		Thread.sleep(5000L);
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		driver.findElement(By.cssSelector(".social-icon.social-channels-instagram.list-item-icon.icon-instagram"))
				.click();
		Thread.sleep(5000L);
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		driver.findElement(By.cssSelector(".social-icon.social-channels-youtube.list-item-icon.icon-youtube")).click();
		Thread.sleep(5000L);
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		driver.findElement(By.cssSelector(".social-icon.social-channels-soundcloud.list-item-icon.icon-soundcloud"))
				.click();
		Thread.sleep(5000L);
		System.out.println(driver.getCurrentUrl());

	}

}
