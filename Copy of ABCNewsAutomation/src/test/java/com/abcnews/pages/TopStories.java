package com.abcnews.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TopStories {

	public AppiumDriver driver;

	// Top article in topstories page
	@AndroidFindBy(id = "android.AbcApplication:id/nlTitle")
	public MobileElement firstArticle;

	// article page
	@AndroidFindBy(className = "android.view.View")
	public MobileElement articlePage;

	public TopStories(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

}
