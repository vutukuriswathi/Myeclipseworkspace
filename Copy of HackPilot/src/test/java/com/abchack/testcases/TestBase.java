package com.abchack.testcases;

import java.io.FileInputStream;
import java.util.Properties;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import com.abchack.screenshot.ScreenShotOnFailure;
import com.abchack.util.Constants;


public class TestBase {
	
	public static Logger logger = null;
	public static WebDriver driver = null;
	public static Properties config = null;
	
	public void initConfigurations()
	{
		if(config == null)
		{
			//BasicConfigurator.configure();
			logger = Logger.getLogger("devpinoyLogger");
			
		}
		//config.prop
		config = new Properties();
		try
		{
			FileInputStream is = new FileInputStream(Constants.Config_File_Path);
			config.load(is);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	

	}
	
	//Initializing the driver
	public void initDriver()
	{
		if(driver == null)
		{
			if(config.getProperty("browser").equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else if(config.getProperty("browser").equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.ie.driver",config.getProperty("ie_exe_path"));
				driver = new InternetExplorerDriver();
			}
			else if(config.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",config.getProperty("chrome_exe_path"));
				driver = new ChromeDriver();
			
			}
			else if(config.getProperty("browser").equalsIgnoreCase("safari"))
			{
				System.setProperty("webdriver.safari.driver", config.getProperty("safari_exe_path"));
			}
		}
		ScreenShotOnFailure screenshot= PageFactory.initElements(driver,ScreenShotOnFailure.class);
	}
	
	//Quitting the driver
	public void quitDriver()
	{
		driver.quit();
		driver = null;
	}
	
}
