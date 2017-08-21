package com.abchack.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.abchack.util.Constants;
import com.abchack.util.ErrorUtil;

public class IndexPage {

	public WebDriver driver;

	@FindBy(id = Constants.topMenuItems)
	public WebElement topMenuItems;

	@FindBy(xpath = Constants.indexPageTitleText)
	public WebElement indexPageTitleText;

	@FindBy(xpath = Constants.articleImages)
	public WebElement articleImages;

	@FindBy(xpath = Constants.articleMetaTags)
	public List<WebElement> articleMetaTags;

	@FindBy(xpath = Constants.topics)
	public WebElement topics;

	@FindBy(css = Constants.topicsMenuItems)
	public WebElement topicsMenuItems;

	public IndexPage(WebDriver dr) {
		driver = dr;
	}

	public void verifyArticleCategory(String screenshotName) throws InterruptedException {
		topics.click();
		List<WebElement> menuitems = topicsMenuItems.findElements(By.tagName("a"));
		String expectedText;
		int menuitemssize = menuitems.size();
		for (int i = 1; i < (menuitemssize - 1); i++) {
			if (i != 1) {
				topics.click();
				menuitems = topicsMenuItems.findElements(By.tagName("a"));
			}
			Thread.sleep(2000L);
			expectedText = menuitems.get(i).getText();
			menuitems.get(i).click();

			Thread.sleep(5000L);

			try {

				Assert.assertTrue(indexPageTitleText.getText().equalsIgnoreCase(expectedText));
			} catch (Throwable T) {
				Reporter.log("index page heading is not matched.Actual heading is " + indexPageTitleText.getText()
						+ "but expected heading is" + expectedText);
			}

			List<WebElement> article = articleImages.findElements(By.tagName("img"));
			int articlesLength = article.size();
			for (int j = 0; j < articlesLength; j++) {
				article = articleImages.findElements(By.tagName("img"));
				article.get(j).click();
				boolean flag = false;
				Thread.sleep(5000L);
				List<WebElement> metatags = articleMetaTags;
				for (int k = 0; k < metatags.size(); k++) {
					if (metatags.get(k).getAttribute("content").toUpperCase().contains(expectedText)) {
						flag = true;
						break;
					}
				}
				try {
					Assert.assertTrue(flag);

				} catch (Throwable e) {
					int articleNumber = j + 1;
					Reporter.log(articleNumber + "does not belong to " + expectedText + "category");
					ErrorUtil.addVerificationFailure(e);
				}
				driver.navigate().back();
			}
		}
	}

	/**
	 * This method will verify the titles of all the index pages.
	 * 
	 * @param ScreenshotName
	 * @throws InterruptedException
	 */
	public void verifyPageTitle(String ScreenshotName) throws InterruptedException {

		String menuText;
		String middleTitle = " | Hack | triple j";
		String expectedTitle;

		topics.click();
		Thread.sleep(Constants.shortWait);
		List<WebElement> menuitems = topicsMenuItems.findElements(By.tagName("a"));
		int menuitemssize = menuitems.size();
		try {
			menuitems.get(0).click();
			Thread.sleep(Constants.shortWait);
			Assert.assertEquals(driver.getTitle(), Constants.AllIndexTitle);
		} catch (Throwable e) {
			Reporter.log("All index page title is wrong,Actaul title is" + driver.getTitle() + " and expected title is"
					+ Constants.AllIndexTitle);
			ErrorUtil.addVerificationFailure(e);
		}

		for (int i = 1; i < menuitemssize; i++) {
			topics.click();
			Thread.sleep(Constants.shortWait);
			menuitems = topicsMenuItems.findElements(By.tagName("a"));

			menuitems.get(i).click();
			Thread.sleep(Constants.longWait);
			menuText = indexPageTitleText.getText();
			expectedTitle = menuText + middleTitle;
			try {
				Assert.assertEquals(driver.getTitle(), expectedTitle);
			} catch (Throwable e) {
				Reporter.log("actual title is" + driver.getTitle() + "but expected title is" + expectedTitle);
				ErrorUtil.addVerificationFailure(e);
			}

		}
	}

}
