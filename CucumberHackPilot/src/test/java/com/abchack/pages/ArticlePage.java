package com.abchack.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.abchack.testcases.TestBase;
import com.abchack.util.Constants;
import com.abchack.util.ErrorUtil;

public class ArticlePage {

	public WebDriver driver;

	@FindBy(xpath = Constants.facebook_commentsBox)
	public WebElement facebook_commentsBox;

	@FindBy(xpath = Constants.facebook_postBtn)
	public WebElement facebook_postBtn;

	@FindBy(name = Constants.facebook_loginBtn)
	public WebElement facebook_loginBtn;

	@FindBy(xpath = Constants.facebook_commentsText)
	public WebElement facebook_commentsText;

	@FindBy(id = Constants.facebook_id)
	public WebElement facebook_id;

	@FindBy(id = Constants.facebook_password)
	public WebElement facebook_password;

	@FindBy(xpath = Constants.facebook_menu)
	public WebElement facebook_menu;

	@FindBy(xpath = Constants.facebook_post_checkbox)
	public WebElement facebook_post_checkbox;

	@FindBy(xpath = Constants.facebook_home_profile)
	public WebElement facebook_home_profile;

	@FindBy(xpath = Constants.facebook_post_fbpage)
	public WebElement facebook_post_fbpage;

	@FindBy(css = Constants.youTubePlayBtn)
	public WebElement youTubePlayBtn;

	public ArticlePage(WebDriver dr) {
		driver = dr;
	}

	public void verifyFacebookComments() throws InterruptedException {

		Thread.sleep(5000L);

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		int i = frames.size();
		TestBase.logger.debug("article iframes size is " + frames.size());

		// switching to facebook iframe
		driver.switchTo().frame(i - 1);
		Thread.sleep(Constants.shortWait);

		// System.out.println(facebook_commentsBox.isDisplayed());
		// type the comments
		facebook_commentsBox.click();
		Thread.sleep(3000L);
		facebook_commentsBox.sendKeys(Constants.facebook_commentsTextMsg);

		Thread.sleep(Constants.shortWait);
		// click on facebook post check box
		facebook_post_checkbox.click();

		// click on facebook post button
		facebook_postBtn.click();

		// to come to the main page
		driver.switchTo().defaultContent();

		Thread.sleep(Constants.longWait);
		Set<String> winhand = driver.getWindowHandles();
		Iterator<String> iter = winhand.iterator();
		String mainWindow = iter.next();
		String childWindow = iter.next();

		// to go to the facebook page
		driver.switchTo().window(childWindow);

		// login to facebook page
		facebook_id.sendKeys(Constants.gmail_userName);
		facebook_password.sendKeys(Constants.gmail_password);
		facebook_loginBtn.click();
		Thread.sleep(Constants.longWait);

		// switch to main window
		driver.switchTo().window(mainWindow);
		Thread.sleep(Constants.longWait);

		// switch to facebook module and click on post button
		driver.switchTo().frame(i - 1);
		// facebook_post_checkbox.click();
		facebook_postBtn.click();
		try {
			// check whether it is posted on triplej hack page or not
			Assert.assertEquals(facebook_commentsText.getText(), Constants.facebook_commentsTextMsg);
		} catch (Throwable e) {
			Reporter.log("actual text is" + facebook_commentsText.getText() + "but expected text is test comment");
			ErrorUtil.addVerificationFailure(e);
		}

		// login to facebook to check whether the post is posted in facebook or
		// not
		driver.get("http://www.facebook.com");
		Thread.sleep(Constants.longWait);

		// click on facebook home profile
		facebook_home_profile.click();
		Thread.sleep(5000L);
		try {
			// check whether the text is posted on facebook wall or not
			Assert.assertEquals(facebook_post_fbpage.getText(), Constants.facebook_commentsTextMsg);
		} catch (Throwable e) {
			Reporter.log("not posted on facebook wall");
			ErrorUtil.addVerificationFailure(e);
		}

	}

	/**
	 * This method will verify the youtube video is playing properly or not
	 * 
	 * @param screenshotName
	 * @throws InterruptedException
	 */
	public void verifyYouTubeVideo(String screenshotName) throws InterruptedException {
		Thread.sleep(Constants.shortWait);
		driver.switchTo().frame(0);
		Thread.sleep(Constants.shortWait);
		TestBase.takeScreenshot(screenshotName + "youtubeembed");

		// click the you tube play button
		youTubePlayBtn.click();
		Thread.sleep(Constants.longWait);
		TestBase.takeScreenshot(screenshotName + "Afteryoutubeplay");

		// click the pause button
		((JavascriptExecutor) driver)
				.executeScript("(document.getElementsByClassName('ytp-large-play-button ytp-button'))[0].click();");
		Thread.sleep(Constants.longWait);
		TestBase.takeScreenshot(screenshotName + "youtubepause");

		// click the play button again
		((JavascriptExecutor) driver)
				.executeScript("(document.getElementsByClassName('ytp-play-button ytp-button'))[0].click();");

		Thread.sleep(Constants.longWait);

	}

	/**
	 * This method will verify the youtube playlist video is playing properly or
	 * not
	 * 
	 * @param screenshotName
	 * @throws InterruptedException
	 */
	public void verifyYouTubePlayList(String screenshotName) throws InterruptedException {
		driver.switchTo().frame(0);
		Thread.sleep(Constants.shortWait);
		TestBase.takeScreenshot(screenshotName + "youtubeembed");

		// click the you tube play button
		youTubePlayBtn.click();
		Thread.sleep(Constants.longWait);
		TestBase.takeScreenshot(screenshotName + "AfteryoutubePlaylistplay");

		// click the pause button
		((JavascriptExecutor) driver)
				.executeScript("(document.getElementsByClassName('ytp-large-play-button ytp-button'))[0].click();");
		Thread.sleep(Constants.longWait);
		TestBase.takeScreenshot(screenshotName + "youtubeplaylistpause");

		// click the play button again
		((JavascriptExecutor) driver)
				.executeScript("(document.getElementsByClassName('ytp-play-button ytp-button'))[0].click();");

		Thread.sleep(Constants.longWait);

		((JavascriptExecutor) driver)
				.executeScript("(document.getElementsByClassName('ytp-next-button ytp-button'))[0].click();");
		TestBase.takeScreenshot(screenshotName + "youtubeplaylistnextbtn");
		Thread.sleep(Constants.longWait);

	}

}
