package com.abcnews.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

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

	@AndroidFindBy(id = "android:id/button1")
	public MobileElement alertOkButton;

	public Weather(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

	public boolean verifyWeatherDetails() {

		if (locationName.isDisplayed() && todayWidget.isDisplayed() && tomorrowWidget.isDisplayed()
				&& todayWeatherIcon.isDisplayed() && tomorrowWeatherIcon.isDisplayed() && todayWeatherDesc.isDisplayed()
				&& tomorrowWeatherDesc.isDisplayed() && weatherElements.get(1).isDisplayed()
				&& weatherElements.get(2).isDisplayed() && weatherElements.get(3).isDisplayed()
				&& weatherElements.get(4).isDisplayed())
			return true;
		else
			return false;

	}

}
