package abcRadio;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BasePage;
import utils.TestUtil;

public class HomePageABCRadio extends BasePage {

	public static void programGuide() throws InterruptedException {

		TestUtil.captureScreenshot();
		List<WebElement> programBanners = driver.findElements(By.xpath(OR.getProperty("programBanner")));
		log.debug("Count of Program Banners are: " + programBanners.size());

		// int i = programBanners.size() - 1;

		WebElement nextButtonProgramBanner = driver.findElement(By.id(OR.getProperty("nextButtonProgramBanner")));
		log.debug("right arrow loaded");

		WebElement lastProgramBanner = driver
				.findElement(By.xpath(".//*[@id='content']/div[1]/div/div/div[2]/ul/li[21]/a/div/img"));

		if (!TestUtil.isElementPresent(lastProgramBanner)) {
			nextButtonProgramBanner.click();
			Thread.sleep(500L);
			nextButtonProgramBanner.click();
			Thread.sleep(500L);
			nextButtonProgramBanner.click();
			Thread.sleep(500L);
			nextButtonProgramBanner.click();
			Thread.sleep(500L);
			nextButtonProgramBanner.click();
			Thread.sleep(500L);
			nextButtonProgramBanner.click();
			Thread.sleep(500L);
			nextButtonProgramBanner.click();
			Thread.sleep(500L);
			nextButtonProgramBanner.click();
		}
		Thread.sleep(4000L);
		TestUtil.captureScreenshot();
		lastProgramBanner.click();
		lastProgramBanner.click();

		Thread.sleep(5000L);
		TestUtil.captureScreenshot();
		Assert.assertTrue((driver.getCurrentUrl().startsWith("http://www.")));
		log.debug("Passed: New Program successfully loaded");
		log.debug(driver.getCurrentUrl());

	}

	public static String SearchContent() {

		TestUtil.captureScreenshot();
		WebElement searchBox = driver.findElement(By.id(OR.getProperty("searchBox")));
		Assert.assertTrue(searchBox.isDisplayed(), "Failed: Search Box is missing");

		String textToSearch = excel.getCellData("ABCRadio", "Text To Search", 2);
		searchBox.sendKeys(textToSearch);

		driver.findElement(By.id(OR.getProperty("searchButton"))).click();
		return textToSearch;
	}

	public static void ValidateSearchContent(String searchText) {

		TestUtil.captureScreenshot();
		searchText = SearchContent();
		searchText.toLowerCase();

		String searchStatusMsg = driver.findElement(By.xpath(OR.getProperty("searchStatusMsg"))).getText();
		log.debug("Search Message Text: " + searchStatusMsg);

		if (searchStatusMsg.contentEquals("Your search for " + searchText + " matched 0 items.")) {
			log.debug("Invalid Search Parameters Used");
		} else {
			log.debug("Passed: Search Results are returned");
			String firstSearchResult = driver.findElement(By.xpath(OR.getProperty("firstSearchResult"))).getText();
			firstSearchResult.toLowerCase();

			Assert.assertTrue(firstSearchResult.contains(searchText), "Failed: Invalid Search Result returned");
			log.debug("Passed: Search Results are valid");
		}

	}

	public static void ScrollFeature() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,750)", "");
		TestUtil.captureScreenshot();

	}

}
