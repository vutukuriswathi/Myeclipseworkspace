package com.abcnews.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.abc.Testcases.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class Weather {

	public AppiumDriver driver;

	// weather icon
	@AndroidFindBy(id = "android.AbcApplication:id/omWeather")
	public MobileElement weatherIcon;

	// location name details
	@AndroidFindBy(id = "android.AbcApplication:id/weatherLocationLabel")
	public MobileElement locationName;

	// today widget
	@AndroidFindBy(id = "android.AbcApplication:id/weather_label_today")
	public MobileElement todayWidget;

	// weather elemnets like min and max for today and tomorrow
	@AndroidFindBy(className = "android.widget.TextView")
	public List<MobileElement> weatherElements;

	// tomorrow widget
	@AndroidFindBy(id = "android.AbcApplication:id/weather_label_tomorrow")
	public MobileElement tomorrowWidget;

	// today weathter icon
	@AndroidFindBy(id = "android.AbcApplication:id/weatherIconToday")
	public MobileElement todayWeatherIcon;

	// tomorrow weather icon
	@AndroidFindBy(id = "android.AbcApplication:id/weatherIconTomorrow")
	public MobileElement tomorrowWeatherIcon;

	// today weather description
	@AndroidFindBy(id = "android.AbcApplication:id/weatherDescToday")
	public MobileElement todayWeatherDesc;

	// tomorrow weather description
	@AndroidFindBy(id = "android.AbcApplication:id/weatherDescTomorrow")
	public MobileElement tomorrowWeatherDesc;

	// search field
	@AndroidFindBy(id = "android.AbcApplication:id/weatherSearch")
	public MobileElement search;

	// search box to enter a text
	@AndroidFindBy(id = "android:id/search_src_text")
	public MobileElement androidSearchText;

	// search box to enter a text
	@AndroidFindBy(className = "android.widget.TextView")
	public List<MobileElement> suggestedLocationsList;

	// android alert ok button
	@AndroidFindBy(id = "android:id/button1")
	public MobileElement alertOkButton;

	// ios elements

	// @iOSFindBy(name = "Weather and Change location Button")
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAElement[3]")
	public MobileElement iOSWeatherIcon;

	// @iOSFindBy(name = "ChangeLocation")
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAButton[1]")
	public MobileElement iOSChangeLocationButton;

	@iOSFindBy(name = "LocationSearchBar")
	public MobileElement iOSLocationSearchBar;

	@iOSFindBy(name = "WEATHER")
	public MobileElement iOSWeather;

	@iOSFindBy(name = "TODAY")
	public MobileElement iOSToday;

	@iOSFindBy(name = "TOMORROW")
	public MobileElement iOSTomorrow;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[4]")
	public MobileElement iOSTodayWeather;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAStaticText[4]")
	public MobileElement iOSTommorowWeather;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[2]")
	public MobileElement iOSTodayMin;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[3]")
	public MobileElement iOSTodayMax;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAStaticText[2]")
	public MobileElement iOSTommorowMin;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAStaticText[3]")
	public MobileElement iOSTommorowMax;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]")
	public MobileElement iOSydneyLocationsList;

	public Weather(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

	/**
	 * @Method: verifyRadioOnDemandSummaryPage
	 * @param:
	 * @Description:This method will check the weather page elements.
	 * @author :swathi Gunuputi
	 */
	public boolean verifyWeatherDetails() {
		if (TestBase.platform.equalsIgnoreCase("android")) {
			if (locationName.isDisplayed() && todayWidget.isDisplayed() && tomorrowWidget.isDisplayed()
					&& todayWeatherIcon.isDisplayed() && tomorrowWeatherIcon.isDisplayed()
					&& todayWeatherDesc.isDisplayed() && tomorrowWeatherDesc.isDisplayed()
					&& weatherElements.get(1).isDisplayed() && weatherElements.get(2).isDisplayed()
					&& weatherElements.get(3).isDisplayed() && weatherElements.get(4).isDisplayed())
				return true;
			else
				return false;
		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {

			if (iOSToday.isDisplayed() && iOSTodayMax.isDisplayed() && iOSTodayMin.isDisplayed()
					&& iOSTodayWeather.isDisplayed() && iOSTommorowMax.isDisplayed() && iOSTommorowMin.isDisplayed()
					&& iOSTommorowWeather.isDisplayed() && iOSTomorrow.isDisplayed())
				return true;
			else
				return false;

		}
		return false;

	}

}
