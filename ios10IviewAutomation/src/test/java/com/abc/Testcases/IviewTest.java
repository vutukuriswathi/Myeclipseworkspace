package com.abc.Testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.abc.util.Util;

@Listeners({ com.abc.listener.TestListenerAdapter.class })
public class IviewTest extends TestBase {

	Util util;

	@BeforeMethod(alwaysRun = true)
	public void before() throws IOException {
		beforeMethod();
		util = new Util();

		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

		;

	}

	/**
	 * @Method: checkMenuItems
	 * @param:
	 * @Description:This method will check whether menu items are present or
	 *                   not.
	 * @author :swathi Gunuputi
	 * @throws InterruptedException
	 */

	@Test(groups = { "local", "aws" })
	public void checkMenuItems() throws InterruptedException {
		if (TestBase.platform.equalsIgnoreCase("android")) {

		}
		if (TestBase.platform.equalsIgnoreCase("ios")) {
			TestBase.driver.findElementByName("Alerts").click();
			Thread.sleep(50000);

		}

	}

	@AfterMethod(alwaysRun = true)
	public void after() throws Exception {
		afterMethod();
	}

}
