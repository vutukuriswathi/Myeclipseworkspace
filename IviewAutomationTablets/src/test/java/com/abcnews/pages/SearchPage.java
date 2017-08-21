package com.abcnews.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SearchPage {

	public AppiumDriver driver;

	// search button
	@AndroidFindBy(id = "au.net.abc.iview:id/action_search")
	public MobileElement andSearchBtn;

	// search text field
	@AndroidFindBy(id = "au.net.abc.iview:id/action_search")
	public MobileElement andSearchField;

	// search text field text
	@AndroidFindBy(id = "au.net.abc.iview:id/search_edit_text")
	public MobileElement andSearchFieldTxt;

	// search text field list
	@AndroidFindBy(id = "au.net.abc.iview:id/series_title")
	public List<MobileElement> andSearchFieldList;

	// iOS Elements

	// iOS search btn
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[4]")
	public MobileElement iOSSearchBtn;

	// iOS search text field
	@iOSFindBy(xpath = "// UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIASearchBar[1]")
	public MobileElement iOSSearchTextField;

	// iOS search first element
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[1]")
	public MobileElement iOSSearchFirstElement;

	public SearchPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

}
