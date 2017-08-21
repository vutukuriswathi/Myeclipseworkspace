import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {
	@Test
	public void testcase2() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://wcms-www.test.abc.net.au/test-triplej/programs/hack");
		driver.manage().window().maximize();
		Thread.sleep(5000L);
		List<WebElement> originalImages = driver.findElement(By.className("view-collection-grid-fixed"))
				.findElements(By.tagName("img"));
		int oldNumber = originalImages.size();
		while (true) {
			// try {
			driver.findElement(By.xpath("//*[@class='comp-paginate loadMore']/div/button")).click();

			// } catch (Throwable e) {
			// break;
			// }

			List<WebElement> newImages = driver.findElement(By.className("view-collection-grid-fixed"))
					.findElements(By.tagName("img"));
			int newNumber = newImages.size();
			Assert.assertTrue(newNumber > oldNumber, "load more does not loaded more items");
			oldNumber = newNumber;
		}

	}

}
