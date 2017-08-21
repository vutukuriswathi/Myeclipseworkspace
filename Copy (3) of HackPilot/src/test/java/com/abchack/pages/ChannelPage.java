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
	@FindBy(id = Constants.name)
	public WebElement name;

	// contact form email
	@FindBy(id = Constants.email)
	public WebElement email;

	// contact form subject
	@FindBy(id = Constants.subject)
	public WebElement subject;

	// contact form message
	@FindBy(id = Constants.message)
	public WebElement message;

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

		for (int i = 1; i <= 3; i++) {
			try {

				System.out.println(carousel_image.isEnabled() + "output");
				Assert.assertEquals(carousel_image.isEnabled(), true);
			} catch (Throwable e) {
				Reporter.log("carousel image" + i + "is not displayed");
				ErrorUtil.addVerificationFailure(e);

			}
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
		Thread.sleep(Constants.shortWait);
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
}
