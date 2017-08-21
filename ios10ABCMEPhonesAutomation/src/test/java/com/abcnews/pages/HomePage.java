package com.abcnews.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomePage {

	private AppiumDriver driver;

	// ios elements
	// My shows button
	@iOSFindBy(name = "My Shows_btn")
	public MobileElement iosMyShowsBtn;

	// explore button
	@iOSFindBy(name = "Explore_btn")
	public MobileElement iosExploreBtn;

	// All shows button
	@iOSFindBy(name = "All Shows_btn")
	public MobileElement iosAllShowsBtn;

	// popular heading
	@iOSFindBy(name = "POPULAR")
	public MobileElement iosPopular;

	// popular first episode
	@iOSFindBy(className = "XCUIElementTypeCell")
	// xpath =
	// "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]")
	public MobileElement iosPopularEpisode;

	// our picks collection first episode
	@iOSFindBy(className = "XCUIElementTypeCell")
	// xpath =
	// "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]")
	public MobileElement iosOurPicksEpisode;

	// add to my shows collection
	@iOSFindBy(className = "XCUIElementTypeCell")
	public List<MobileElement> iosAddToMyShowsCollection;

	public HomePage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

}
