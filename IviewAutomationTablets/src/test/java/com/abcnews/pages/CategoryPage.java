package com.abcnews.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.abc.Testcases.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class CategoryPage {

	public AppiumDriver driver;

	// category header text
	@AndroidFindBy(id = "au.net.abc.iview:id/first_row_txt_header")
	public MobileElement andCategoryHeadertxt;

	// programs a-z category header text
	@AndroidFindBy(name = "A-Z Index")
	public MobileElement andProgramsCategoryHeaderTxt;

	// watchlist header text
	@AndroidFindBy(className = "android.widget.Button")
	public MobileElement andYourIviewWatchListTxt;

	// recently viewed header text
	@AndroidFindBy(name = "Clear Recently Viewed")
	public MobileElement andYourIviewRecentlyViewedTxt;

	// parental password text
	@AndroidFindBy(name = "Parental Filter")
	public MobileElement andYourIviewParentalFilterTxt;

	// parental field password
	@AndroidFindBy(className = "android.widget.EditText")
	public MobileElement andParentalFieldPwd;

	// parental pin description
	@AndroidFindBy(name = "Please enter a 4 digit PIN ")
	public MobileElement andParentalPinDesc;

	// parental filter close button
	@AndroidFindBy(className = "android.widget.ImageView")
	public MobileElement andParentalCloseBtn;

	// parental filter Header text
	@AndroidFindBy(name = "ABC iview")
	public MobileElement andParentalHeaderTxt;

	// programs all programs tab
	@AndroidFindBy(id = "au.net.abc.iview:id/az_index_listviewheader_button_all")
	public MobileElement andProgramsAllProgramsTab;

	// programs closed captions tab
	@AndroidFindBy(id = "au.net.abc.iview:id/az_index_listviewheader_layout_cc")
	public MobileElement andProgramsClosedCaptionsTab;

	// programs audio described tab
	@AndroidFindBy(id = "au.net.abc.iview:id/az_index_listviewheader_layout_ad")
	public MobileElement andProgramsAudioDescribedTab;

	// more abc menu items page
	@AndroidFindBy(name = "ABC for Android")
	public MobileElement andAnnouncements;

	// support menu items header
	@AndroidFindBy(id = "au.net.abc.iview:id/header")
	public MobileElement andSupportMenuItemHeader;

	// more abc menu items page
	@AndroidFindBy(name = "ABC for Android")
	public MobileElement andMoreAbc;

	// iOS Elements

	// category header text
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAElement[1]")
	public MobileElement iOSCategoryHeading;

	// programs a-z text
	@iOSFindBy(xpath = "/UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]")
	public MobileElement iOSProgramsAz;

	// all programs tab
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAElement[1]")
	public MobileElement iOSAllProgramsTab;

	// closed captions tab
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	public MobileElement iOSClosedCaptionsTab;

	// audio described tab
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")
	public MobileElement iOSAudioDescribedTab;

	public CategoryPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

	/**
	 * @Method: VerifyParentalFilter
	 * @param:
	 * @Description:This method will click whether episode details are
	 *                   displaying correctly or not
	 * @author :swathi Gunuputi
	 */
	public boolean verifyParentalFilter() {

		if (TestBase.platform.equalsIgnoreCase("android")) {

			if (andParentalFieldPwd.isDisplayed() && andParentalPinDesc.isDisplayed()
					&& andYourIviewParentalFilterTxt.isDisplayed() && andParentalHeaderTxt.isDisplayed())
				return true;
			else
				return false;

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {

		}
		return false;

	}

	/**
	 * @Method: VerifyProgramsTabs
	 * @param:
	 * @Description:This method will check whether All Programs, CC, AD tabs are
	 *                   present or not in programsA-Z menu item.
	 * @author :swathi Gunuputi
	 */
	public boolean verifyProgramsTabs() {

		if (TestBase.platform.equalsIgnoreCase("android")) {

			if (andProgramsAllProgramsTab.isDisplayed() && andProgramsClosedCaptionsTab.isDisplayed())
				return true;
			else
				return false;

		}

		if (TestBase.platform.equalsIgnoreCase("ios")) {
			if (iOSAllProgramsTab.isDisplayed() && iOSAudioDescribedTab.isDisplayed()
					&& iOSClosedCaptionsTab.isDisplayed())
				return true;
			else
				return false;

		}
		return false;

	}
}
