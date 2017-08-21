package ABCGroupid.screenshottest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners({ScreenShotOnFailure.class})
public class HackTests  {
	
	public static WebDriver driver;
	
	@Test
	public void testcase1() throws InterruptedException 
	{
		
		 driver = new FirefoxDriver();
		ScreenShotOnFailure sc = new ScreenShotOnFailure(driver);
		driver.get("http://www.amazon.com");
		Reporter.log("swathi");
		Assert.assertFalse(true, "not matched");
			
	}
	
	/*@Test
	public void testcase2() throws InterruptedException
	{
		driver.get("https://validator.w3.org/checklink");
		driver.findElement(By.id("uri_1")).sendKeys(Constants.channel_page_url);
		driver.findElement(By.id("uri_1")).sendKeys(Keys.ENTER);
		Thread.sleep(400000L);
		driver.findElement(By.linkText("the results"));
		WebElement table=driver.findElement(By.xpath(".//*[@id='main']/table[1]"));
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		for(int i=1;i<rows.size();i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<cols.size();j++)
			{
				System.out.println(cols.get(j).getText());
			}
			System.out.println("\n");
			
			
		}
		
		
		
	}*/
	
	
	
	
	

}
