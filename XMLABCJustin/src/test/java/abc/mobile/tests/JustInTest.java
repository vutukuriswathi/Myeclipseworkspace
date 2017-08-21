package abc.mobile.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class JustInTest {

	public AppiumDriver driver;
	List<String> titles = new ArrayList<String>();
	List<String> pubDate = new ArrayList<String>();
	boolean flag = false;

	@BeforeTest()
	public void beforeTest() throws FileNotFoundException, IOException {
		Properties androidConfig = new Properties();
		androidConfig.load(new FileInputStream(
				System.getProperty("user.dir") + "/src/test/java/abc/mobile/config/androidConfig.properties"));

		if (androidConfig.getProperty("environment").equalsIgnoreCase("local")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", androidConfig.getProperty("device.name"));
			capabilities.setCapability("platformName", androidConfig.getProperty("device.platformName"));
			capabilities.setCapability("platformVersion", androidConfig.getProperty("device.platformVersion"));
			capabilities.setCapability("enablePerformanceLogging", true);
			capabilities.setCapability("appPackage", androidConfig.getProperty("app.Package"));
			capabilities.setCapability("appActivity", androidConfig.getProperty("app.Activity"));
			capabilities.setCapability("appWaitActivity", androidConfig.getProperty("app.WaitActivity"));
			capabilities.setCapability("autoAcceptAlerts", true);
			File appdir = new File(System.getProperty("user.dir") + "/src/test/java/abc/mobile/apps");
			File app = new File(appdir, androidConfig.getProperty("test.app.name") + ".apk");
			capabilities.setCapability("app", app.getAbsolutePath());
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}
	}

	@Test
	public void test1() throws InterruptedException {
		try {
			// copying url to an xml file
			URL rssurl = new URL("http://www.abc.net.au/news/feed/51120/rss.xml");
			File fxmlfile = new File("file1.xml");
			FileUtils.copyURLToFile(rssurl, fxmlfile);

			// parsing xml file
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();
			Document doc = dbuilder.parse("file1.xml");
			doc.getDocumentElement().normalize();
			System.out.println("root node is" + doc.getDocumentElement().getNodeName());

			NodeList nlist = doc.getElementsByTagName("item");
			for (int i = 0; i < 10; i++) {
				Node node = nlist.item(i);
				Element element = (Element) node;
				System.out.println("title is" + element.getElementsByTagName("title").item(0).getTextContent());
				titles.add(element.getElementsByTagName("title").item(0).getTextContent());
				System.out.println("pub date is" + element.getElementsByTagName("pubDate").item(0).getTextContent());
				pubDate.add(element.getElementsByTagName("pubDate").item(0).getTextContent());

				// Getting the current Date
				DateTime datetime = new DateTime();
				datetime = datetime.minusMinutes(30);
				Date modifiedDateTime = datetime.toDate();
				System.out.println("modified date is" + modifiedDateTime);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		WebDriverWait wait = new WebDriverWait(driver, 360);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android.AbcApplication:id/onboarding_next")));

		try {
			driver.findElement(By.id("android.AbcApplication:id/onboarding_next")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(3000L);

		try {
			driver.findElement(By.id("android.AbcApplication:id/onboarding_notnow")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// click on justin
		((MobileElement) driver.findElements(By.id("android.AbcApplication:id/navMenuCaption")).get(1)).click();

		List<MobileElement> topStories = driver.findElements(By.id("android.AbcApplication:id/nlTitle"));

		System.out.println("current story is" + topStories.get(0).getText());

		// verify the first top story is present in the top 10 xml stories
		for (int j = 0; j < titles.size(); j++) {
			if (topStories.get(0).getText().equals(titles.get(j))) {
				// story matches
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag, "just in stories are not refreshed");

		// click on first justin story
		/*
		 * topStories.get(0).click(); Thread.sleep(2000);
		 * 
		 * 
		 * String articleDate = ((WebElement)
		 * driver.findElements(By.className("android.view.View")).get(2))
		 * .getAttribute("name"); System.out.println("article date is" +
		 * articleDate);
		 */

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
