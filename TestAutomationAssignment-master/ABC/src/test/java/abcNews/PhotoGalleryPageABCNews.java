package abcNews;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BasePage;
import utils.TestUtil;

public class PhotoGalleryPageABCNews extends BasePage {

	public static void launchPhotoGallaryPage() {
		driver.navigate().to(Config.getProperty("ABCNewsGallaryPage"));

	}

	public static void validatePageLoad() throws InterruptedException {

		TestUtil.captureScreenshot();
		
		String expPageUrl = Config.getProperty("ABCNewsGallaryPage");
		String actPageUrl = driver.getCurrentUrl();

		Assert.assertEquals(actPageUrl, expPageUrl, "Failed: Application URL Does Not Match");
		log.debug("Application Launches Successfully");
		log.debug(actPageUrl);

	}

	public static void validateContent() throws InterruptedException {

		Thread.sleep(2000L);

		List<WebElement> images = driver.findElements(By.xpath(OR.getProperty("images")));
		log.debug(images.size());

		TestUtil.captureScreenshot();
		Assert.assertEquals(images.size(), 15, "Failed: Images Count Does Not Match");

		for (int i = 1; i <= images.size(); i++) {
			log.debug("Image: " + i);

			WebElement image = driver.findElement(By.cssSelector(OR.getProperty("image")));
			
			TestUtil.captureScreenshot();

			String imageSource = image.getAttribute("src");
			Dimension size = image.getSize();
			int imageHeight = size.getHeight();
			int imageWidth = size.getWidth();

			//Capturing all the Image Properties and storing them in excel, so that they can be validated later
			
			excel.setCellData("ImageTest", "Image Source", i + 1, imageSource);
			excel.setCellData("ImageTest", "Tag Name", i + 1, image.getTagName());
			excel.setCellData("ImageTest", "Width", i + 1, image.getCssValue("max-width"));
			excel.setCellData("ImageTest", "Height", i + 1, image.getCssValue("max-height"));
			excel.setCellData("ImageTest", "Image Width", i + 1, imageWidth);
			excel.setCellData("ImageTest", "Image Height", i + 1, imageHeight);

			Assert.assertTrue((imageSource.startsWith("http://www.abc.net.au/news/image")),
					"Failed: Image source is invalid");
			log.debug("Passed: Image source is valid");

			driver.findElement(By.cssSelector(".lSNext")).click();
		}

	}
}
