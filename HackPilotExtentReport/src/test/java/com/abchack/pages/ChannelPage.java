package com.abchack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.abchack.util.Constants;
import com.abchack.util.ErrorUtil;

public class ChannelPage {

	public WebDriver driver;

	// carousel next button for navigating through the carosuel items
	@FindBy(xpath = Constants.carousel_nextbtn)
	public WebElement carousel_nextbtn;

	// carousel list item for getting slick active class
	@FindBy(xpath = Constants.carousel_listitem1)
	public WebElement carousel_listitem1;

	// carousel image
	@FindBy(xpath = Constants.carousel_image)
	public WebElement carousel_image;

	// Email hack button
	@FindBy(xpath = Constants.emailHack)
	public WebElement emailHack;

	// send Email button
	@FindBy(name = Constants.sendEmail)
	public WebElement sendEmail;

	// name error message
	@FindBy(id = Constants.nameError)
	public WebElement nameError;

	// email error message
	@FindBy(id = Constants.emailError)
	public WebElement emailError;

	// subject error message
	@FindBy(id = Constants.subjectError)
	public WebElement subjectError;

	// message error message
	@FindBy(id = Constants.messageError)
	public WebElement messageError;

	// contact form name
	@FindBy(name = Constants.name)
	public WebElement name;

	// contact form email
	@FindBy(name = Constants.email)
	public WebElement email;

	// contact form subject
	@FindBy(name = Constants.subject)
	public WebElement subject;

	// contact form message
	@FindBy(name = Constants.message)
	public WebElement message;

	// triplej icon
	@FindBy(css = Constants.triplejIcon)
	public WebElement triplejIcon;

	// facebook icon
	@FindBy(css = Constants.facebookIcon)
	public WebElement facebookIcon;

	// twitter icon
	@FindBy(css = Constants.twitterIcon)
	public WebElement twitterIcon;

	// instagram icon
	@FindBy(css = Constants.InstagramIcon)
	public WebElement InstagramIcon;

	// youTube icon
	@FindBy(css = Constants.youTubeIcon)
	public WebElement youTubeIcon;

	@FindBy(css = Constants.soundCloudIcon)
	public WebElement soundCloudIcon;

	public ChannelPage(WebDriver dr) {
		driver = dr;
	}

	/**
	 * Navigate through the carousel items
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void navigateCarouselItems() throws InterruptedException {

		for (int i = 1; i <= 2; i++) {
			/*
			 * try {
			 * 
			 * System.out.println(carousel_image.isEnabled() + "output");
			 * Assert.assertEquals(carousel_image.isEnabled(), true); } catch
			 * (Throwable e) { Reporter.log("carousel image" + i +
			 * "is not displayed"); ErrorUtil.addVerificationFailure(e);
			 * 
			 * }
			 */
			try {

				Assert.assertEquals(
						driver.findElement(By.xpath("//*[contains(@id,'collection-slick-carousel')]/ul/li[" + i + "]"))
								.getAttribute("class").equals("slick-active"),
						true);
			} catch (Throwable e) {

				Reporter.log("slick button for the  image" + i + "is not in red colour");
				ErrorUtil.addVerificationFailure(e);
			}
			Thread.sleep(2000L);
			carousel_nextbtn.click();
			Thread.sleep(5000L);

		}
		try {

			Assert.assertEquals(carousel_nextbtn.isDisplayed(), true);
		} catch (Throwable e) {

			Reporter.log("carousel next button is not displayed");
			ErrorUtil.addVerificationFailure(e);
		}

	}

	/**
	 * This method will verify name,email,subject and message errors are
	 * displaying correctly or not
	 * 
	 * @throws InterruptedException
	 */
	public void verifyEmailFields() throws InterruptedException {
		emailHack.click();
		Thread.sleep(2000L);
		sendEmail.click();
		Thread.sleep(2000L);
		try {
			Assert.assertEquals(nameError.getText().equals(Constants.nameErrorMessage), true);
		} catch (Throwable e) {
			Reporter.log("error message for name is displaying wrongly.Acutal is" + nameError.getText() + "expected is "
					+ Constants.nameErrorMessage);
			ErrorUtil.addVerificationFailure(e);
		}

		try {
			Assert.assertEquals(emailError.getText().equals(Constants.emailErrorMessage), true);
		} catch (Throwable e) {
			Reporter.log("error message for email is displaying wrongly.Acutal is" + emailError.getText()
					+ "expected is " + Constants.emailErrorMessage);
			ErrorUtil.addVerificationFailure(e);
		}

		try {
			Assert.assertEquals(subjectError.getText().equals(Constants.subjectErrorMessage), true);
		} catch (Throwable e) {
			Reporter.log("error message for subject is displaying wrongly.Acutal is" + subjectError.getText()
					+ "expected is " + Constants.subjectErrorMessage);
			ErrorUtil.addVerificationFailure(e);
		}

		try {
			Assert.assertEquals(messageError.getText().equals(Constants.messageErrorMessage), true);
		} catch (Throwable e) {
			Reporter.log("error message for subject is displaying wrongly.Acutal is" + subjectError.getText()
					+ "expected is " + Constants.subjectErrorMessage);
			ErrorUtil.addVerificationFailure(e);
		}

	}

	/**
	 * This method will send an email to hack email.
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void sendHackEmail() throws InterruptedException {
		Thread.sleep(Constants.longWait);
		emailHack.click();
		Thread.sleep(Constants.shortWait);
		name.sendKeys("abcuser");
		Thread.sleep(Constants.shortWait);
		email.sendKeys("testabc641@gmail.com");
		Thread.sleep(Constants.shortWait);
		subject.sendKeys("check hack mail box");
		Thread.sleep(Constants.shortWait);
		message.sendKeys("This is testmail to check whether mail is sending or not");
		Thread.sleep(Constants.shortWait);
		sendEmail.click();

	}

	/**
	 * This method will verify the facebook,twitter,soundcloud ,youtube,triplej
	 * icons are redirecting to correct url or not
	 * 
	 * @throws InterruptedException
	 */
	public void verifyIconsRedirection() throws InterruptedException {

		triplejIcon.click();
		Thread.sleep(Constants.longWait);
		try {
			Assert.assertEquals(driver.getCurrentUrl(), Constants.triplejRedirectUrl);
		} catch (Throwable e) {
			Reporter.log(
					driver.getCurrentUrl() + "does not match with the expected url" + Constants.triplejRedirectUrl);
			ErrorUtil.addVerificationFailure(e);
		}

		driver.navigate().back();
		facebookIcon.click();
		Thread.sleep(Constants.longWait);
		try {
			Assert.assertEquals(driver.getCurrentUrl(), Constants.facebookRedirectUrl);
		} catch (Throwable e) {
			Reporter.log(
					driver.getCurrentUrl() + "does not match with the expected url" + Constants.facebookRedirectUrl);
			ErrorUtil.addVerificationFailure(e);
		}
		driver.navigate().back();
		twitterIcon.click();
		Thread.sleep(Constants.longWait);
		try {
			Assert.assertEquals(driver.getCurrentUrl(), Constants.twitterRedirectUrl);
		} catch (Throwable e) {
			Reporter.log(
					driver.getCurrentUrl() + "does not match with the expected url" + Constants.twitterRedirectUrl);
			ErrorUtil.addVerificationFailure(e);
		}
		driver.navigate().back();
		InstagramIcon.click();
		Thread.sleep(Constants.longWait);
		try {
			Assert.assertEquals(driver.getCurrentUrl(), Constants.InstagramRedirectUrl);
		} catch (Throwable e) {
			Reporter.log(
					driver.getCurrentUrl() + "does not match with the expected url" + Constants.InstagramRedirectUrl);
			ErrorUtil.addVerificationFailure(e);
		}
		driver.navigate().back();
		youTubeIcon.click();
		Thread.sleep(Constants.longWait);
		try {
			Assert.assertEquals(driver.getCurrentUrl(), Constants.youTubeRedirectUrl);
		} catch (Throwable e) {
			Reporter.log(
					driver.getCurrentUrl() + "does not match with the expected url" + Constants.youTubeRedirectUrl);
			ErrorUtil.addVerificationFailure(e);
		}
		driver.navigate().back();
		Thread.sleep(Constants.shortWait);
		soundCloudIcon.click();
		Thread.sleep(Constants.longWait);
		try {
			Assert.assertEquals(driver.getCurrentUrl(), Constants.soundCloudRedirectUrl);
		} catch (Throwable e) {
			Reporter.log(
					driver.getCurrentUrl() + "does not match with the expected url" + Constants.soundCloudRedirectUrl);
			ErrorUtil.addVerificationFailure(e);
		}
	}
}
