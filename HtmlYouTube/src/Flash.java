import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Flash {

	@Test
	public void test1() throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.get("https://iview.abc.net.au/programs/emma/ZW0297A007S00");
		// driver.get("http://splash.abc.net.au/home#!/media/1979231/john-glover-mr-robinson-s-house-on-the-derwent-van-diemen-s-land-1838");
		Thread.sleep(5000L);

		/*
		 * WebElement video = driver.findElement(By.tagName("object"));
		 * JavascriptExecutor js = driver;
		 * js.executeScript("arguments[0].play();", video);
		 */
		driver.findElement(By.className("play-button")).click();
		Thread.sleep(5000L);
		JavascriptExecutor js = driver;
		js.executeScript("document.getElementsByClassName('play-button')[0].click();");
		Thread.sleep(5000L);
		// driver.quit();

	}

}
