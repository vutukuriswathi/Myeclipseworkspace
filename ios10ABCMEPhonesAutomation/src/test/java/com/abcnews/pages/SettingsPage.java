package com.abcnews.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SettingsPage {

	private AppiumDriver driver;

	// settings menu
	@AndroidFindBy(id = "au.net.abc.abcme:id/user_setting")
	public MobileElement andSettingsMenu;

	// Parent settings label
	@AndroidFindBy(name = "PARENT SETTINGS")
	public MobileElement andParentSettingsMenuItem;

	// restrict content menu item
	@AndroidFindBy(id = "au.net.abc.abcme:id/restrict_content")
	public MobileElement andRestrictContent;

	// change pin menu item
	@AndroidFindBy(id = "au.net.abc.abcme:id/change_pin")
	public MobileElement andChangePin;

	// About ABC ME menu item
	@AndroidFindBy(id = "au.net.abc.abcme:id/menu_about")
	public MobileElement andAboutAbcMe;

	// Information for parents menu item
	@AndroidFindBy(id = "au.net.abc.abcme:id/menu_information_for_parents")
	public MobileElement andInformationForParents;

	// faqs menu item
	@AndroidFindBy(id = "au.net.abc.abcme:id/menu_faq")
	public MobileElement andFaqs;

	// privacy and terms of use menu item
	@AndroidFindBy(id = "au.net.abc.abcme:id/menu_terms")
	public MobileElement andPrivacyAndTerms;

	// support and contact menu item
	@AndroidFindBy(id = "au.net.abc.abcme:id/support_contact")
	public MobileElement andSupportAndContact;

	// settings menu page heading
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]")
	// @AndroidFindBy(className = "android.view.View")
	public MobileElement settingsMenuPageHeading;

	// close button
	@AndroidFindBy(id = "au.net.abc.abcme:id/close_support")
	public MobileElement andSettingsClose;

	// iOS Elements

	// settings menu
	@iOSFindBy(name = "home_settings_btn")
	public MobileElement iosSettingsMenu;

	// Parent settings label
	@iOSFindBy(name = "PARENT SETTINGS")
	public MobileElement iosParentSettingsMenuItem;

	// restrict content menu item
	@iOSFindBy(name = "Restrict content")
	public MobileElement iosRestrictContent;

	// change pin menu item
	@iOSFindBy(name = "Change PIN")
	public MobileElement iosChangePin;

	// info menu item
	@iOSFindBy(name = "INFO")
	public MobileElement iosInfo;

	// About ABC ME menu item
	@iOSFindBy(name = "About ABC ME")
	public MobileElement iosAboutAbcMe;

	// Information for parents menu item
	@iOSFindBy(name = "Information for parents")
	public MobileElement iosInformationForParents;

	// faqs menu item
	@iOSFindBy(name = "FAQs")
	public MobileElement iosFaqs;

	// privacy and terms of use menu item
	@iOSFindBy(name = "Privacy & terms of use")
	public MobileElement iosPrivacyAndTerms;

	// settings menu page heading
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextView[1]")
	public MobileElement iosSettingsMenuPageHeading;

	// close button
	@iOSFindBy(name = "close")
	public MobileElement iosSettingsClose;

	public SettingsPage(AppiumDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);

	}

}
