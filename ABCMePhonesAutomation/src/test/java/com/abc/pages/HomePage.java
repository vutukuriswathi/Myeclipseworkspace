package com.abc.pages;

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
	@iOSFindBy(accessibility = "My Shows_btn")
	public MobileElement iosMyShowsBtn;

	// explore button
	@iOSFindBy(accessibility = "Explore_btn")
	public MobileElement iosExploreBtn;

	// All shows button
	@iOSFindBy(accessibility = "All Shows_btn")
	public MobileElement iosAllShowsBtn;

	// popular heading
	@iOSFindBy(accessibility = "POPULAR")
	public MobileElement iosPopular;

	// popular first episode
	// @iOSFindBy(xpath =
	// "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAElement[1]")
	@iOSFindBy(className = "UIACollectionCell")
	public MobileElement iosPopularEpisode;

	// our picks collection first episode
	// @iOSFindBy(xpath =
	// "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAElement[1]")
	@iOSFindBy(className = "UIACollectionCell")
	public MobileElement iosOurPicksEpisode;

	// add to my shows collection
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAElement")
	public List<MobileElement> iosAddToMyShowsCollection;

	public HomePage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

}
