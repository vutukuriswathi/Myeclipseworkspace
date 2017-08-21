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

	@FindBy(xpath = Constants.carousel_nextbtn)
	public WebElement carousel_nextbtn;

	@FindBy(xpath = Constants.carousel_listitem1)
	public WebElement carousel_listitem1;

	@FindBy(xpath = Constants.carousel_image)
	public WebElement carousel_image;

	public ChannelPage(WebDriver dr) {
		driver = dr;
	}

	/**
	 * Navigate through the carousel items
	 * 
	 */
	public void navigateCarouselItems() {

		for (int i = 1; i <= 4; i++) {
			try {

				Assert.assertEquals(carousel_image.isDisplayed(), true);
			} catch (Throwable e) {
				Reporter.log("carousel image" + i + "is not displayed");
				ErrorUtil.addVerificationFailure(e);

			}
			try {

				Assert.assertEquals(
						driver.findElement(By.xpath("//*[@id='collection-slick-carousel4']/ul/li[" + i + "]"))
								.getAttribute("class").equals("slick-active"),
						true);
			} catch (Throwable e) {

				Reporter.log("slick button for the  image" + i + "is not in red colour");
				ErrorUtil.addVerificationFailure(e);
			}
			carousel_nextbtn.click();

		}
		Assert.assertEquals(ErrorUtil.getVerificationFailures().size() > 0, false);

	}
}
