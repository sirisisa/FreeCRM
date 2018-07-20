package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;
import com.crm.qa.config.*;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		
/*	try{	
		
		Properties prop = new Properties();
		
		FileInputStream ip = new FileInputStream
		("C:\\Users\\Sirisha\\workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		
		prop.load(ip);
		
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
	}
		*/
		
		String url = "https://www.freecrm.com";
		String username = "sirisisa";
		String password = "ecegvp09";
		String browserName = "firefox";
	}
	
	public static void initialization(){
	
	/*if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "");
		driver = new ChromeDriver();
		}
	else if(browserName.equals("firefox")) {
		driver = new FirefoxDriver();
		
	}
	else if(browserName.equals("IE")) {
		
		System.setProperty("webdriver.ie.driver", "");
		driver = new InternetExplorerDriver(); */
		
	/*	if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));  */
	
		driver = new FirefoxDriver();
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
		driver.get("https://www.freecrm.com");
		
		}
	}

	
	


