package com.abc.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.abc.Testcases.TestBase;
import com.abc.util.Constants;
import com.abc.util.Util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ProfilePage {

	private AppiumDriver driver;

	// avatar menu
	@AndroidFindBy(id = "au.net.abc.abcme:id/user_avatar_default")
	public MobileElement andAvatar;

	// change avatar menu item
	@AndroidFindBy(id = "au.net.abc.abcme:id/change_avatar")
	public MobileElement andChangeAvatar;

	// change name menu item
	@AndroidFindBy(id = "au.net.abc.abcme:id/change_name")
	public MobileElement andChangeName;

	// ios elements
	// avatar menu
	@iOSFindBy(xpath = " //UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	public MobileElement iosAvatar;

	// change avatar menu item
	@iOSFindBy(accessibility = "CHANGE AVATAR")
	public MobileElement iosChangeAvatar;

	// change name menu item
	@iOSFindBy(accessibility = "CHANGE NAME")
	public MobileElement iosChangeName;

	// change avatar in my profile screen
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIASegmentedControl[1]/UIAButton[1]")
	public MobileElement iosMyProfileChangeAvatar;

	// change name in my profile screen
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIASegmentedControl[1]/UIAButton[2]")
	public MobileElement iosMyProfileChangeName;

	// pick an avatar text in my profile screen
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")
	public MobileElement iosPickAvatarTxt;

	// avatar carousel
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAElement[1]")
	public MobileElement iosAvatarCarousel;

	// pick a colour
	@iOSFindBy(accessibility = "Pick a colour")
	public MobileElement iosPickColour;

	// yellow colour
	@iOSFindBy(accessibility = "Yellow")
	public MobileElement iosYellowColour;

	// blue colour
	@iOSFindBy(accessibility = "Blue")
	public MobileElement iosBlueColour;

	// red colour
	@iOSFindBy(accessibility = "Red")
	public MobileElement iosRedColour;

	// close button
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	public MobileElement iosMyProfileCloseBtn;

	// My profile text
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]")
	public MobileElement iosMyProfileTxt;

	// name your avatar text
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")
	public MobileElement iosNameYourAvatarTxt;

	// emoji under change name
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAImage[2]")
	public MobileElement iosChangeNameEmoji;

	// name text field
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")
	public MobileElement iosEnterNameFieldTxt;

	public ProfilePage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

	/**
	 * @Method: verifyChangeAvatarPage
	 * @param:
	 * @Description:This method will check the change avatar page elements are
	 *                   displaying or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	public boolean verifyChangeAvatarPage() throws InterruptedException {
		Util util = new Util();
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {
			Thread.sleep(Constants.longWait);
			util.waitUntillElementIsVisible(iosAvatarCarousel);
			TestBase.takeScreenshot("ChangeAvatarPage");

			if (iosMyProfileChangeAvatar.isDisplayed() && iosMyProfileChangeName.isDisplayed()
					&& iosPickAvatarTxt.isDisplayed() && iosAvatarCarousel.isDisplayed() && iosPickColour.isDisplayed()
					&& iosYellowColour.isDisplayed() && iosBlueColour.isDisplayed() && iosRedColour.isDisplayed()
					&& iosMyProfileCloseBtn.isDisplayed()) {
				return true;
			} else {

				return false;
			}

		}
		return false;
	}

	/**
	 * @Method: verifyChangeNamePage
	 * @param:
	 * @Description:This method will check the change name page elements are
	 *                   displaying or not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */
	public boolean verifyChangeNamePage() throws InterruptedException {
		Util util = new Util();
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {
			Thread.sleep(Constants.longWait);
			util.waitUntillElementIsVisible(iosChangeNameEmoji);
			TestBase.takeScreenshot("ChangeNamePage");

			if (iosNameYourAvatarTxt.isDisplayed() && iosChangeNameEmoji.isDisplayed()
					&& iosEnterNameFieldTxt.isDisplayed()) {
				return true;
			} else {

				return false;
			}

		}
		return false;
	}

}
