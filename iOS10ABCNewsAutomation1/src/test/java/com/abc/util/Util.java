package com.abc.util;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.abc.Testcases.TestBase;

import io.appium.java_client.MobileElement;

public class Util {

	/**
	 * @Method: swipeLeft
	 * @param:
	 * @Description:This method will be used if you want to perform swipeleft
	 *                   action
	 * @author :swathi Gunuputi
	 */
	public void swipeLeft() {

		Dimension size = (TestBase.getDriver()).manage().window().getSize();
		int starty = size.getHeight() / 2;
		int startx = (int) (size.getWidth() * 0.9);
		int endx = (int) (size.getWidth() * 0.1);
		(TestBase.getDriver()).swipe(startx, starty, endx, starty, 1000);

	}

	/**
	 * @Method: swipeRight
	 * @param:
	 * @Description:This method will be used if you want to perform swipe right
	 *                   action
	 * @author :swathi Gunuputi
	 */
	public void swipeRight() {
		Dimension size = (TestBase.getDriver()).manage().window().getSize();
		int starty = size.getHeight() / 2;
		int startx = (int) (size.getWidth() * 0.1);
		int endx = (int) (size.getWidth() * 0.9);
		(TestBase.getDriver()).swipe(startx, starty, endx, starty, 1000);

	}

	/**
	 * @Method: swipeDown
	 * @param:
	 * @Description:This method will be used if you want to perform swipe down
	 *                   action
	 * @author :swathi Gunuputi
	 */
	public void swipeDown() {
		Dimension size = (TestBase.getDriver()).manage().window().getSize();
		int startx = size.getWidth() / 2;
		int starty = (int) (size.getHeight() * 0.2);
		int endy = (int) (size.getHeight() * 0.8);
		(TestBase.getDriver()).swipe(startx, starty, startx, endy, 1000);

	}

	/**
	 * @Method: swipeUp
	 * @param:
	 * @Description:This method will be used if you want to perform swipe up
	 *                   action
	 * @author :swathi Gunuputi
	 */
	public void swipeUp() {

		Dimension size = (TestBase.getDriver()).manage().window().getSize();
		int startx = size.getWidth() / 2;
		int starty = (int) (size.getHeight() * 0.8);
		int endy = (int) (size.getHeight() * 0.2);
		(TestBase.getDriver()).swipe(startx, starty, startx, endy, 1000);

	}

	/**
	 * @Method: waitUntillElementIsVisible
	 * @param:
	 * @Description:This method will be used to wait for the visibility of an
	 *                   element for a certain period of time.
	 * @author :swathi Gunuputi
	 */
	public void waitUntillElementIsVisible(MobileElement elem) {

		new WebDriverWait(TestBase.driver, Constants.longWait).until(ExpectedConditions.visibilityOf(elem));

	}

}
