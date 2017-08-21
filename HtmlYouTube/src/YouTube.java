import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class YouTube {

	@Test
	public void test1() throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver","/Users/gunuputis4r/Documents/Browsersdrivers/chromedriver");
		// WebDriver driver = new ChromeDriver();
		FirefoxDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/watch?v=qxoXvn2l2gA");
		// driver.get("http://splash.abc.net.au/home#!/media/1979231/john-glover-mr-robinson-s-house-on-the-derwent-van-diemen-s-land-1838");
		Thread.sleep(5000L);

		WebElement video = driver.findElement(By.tagName("video"));
		JavascriptExecutor js = driver;
		js.executeScript("arguments[0].pause();", video);

		Thread.sleep(5000L);

		js.executeScript("arguments[0].play();", video);
		Thread.sleep(5000L);

		js.executeScript("arguments[0].mute();", video);
		Thread.sleep(5000L);

		js.executeScript("arguments[0].unMute();", video);
		Thread.sleep(5000L);

		js.executeScript("arguments[0].currentTime = 600;", video);
		Thread.sleep(5000L);

		js.executeScript("alert(arguments[0].readyState);", video);

		driver.quit();

	}

}
