package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Logger log= Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		log.info("entering application url");
		
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		log.info("login page title is------->"+title);
		log.warn("Hey this is just a warning");
		log.fatal("hey this is a fatal message");
		log.debug("This is debug");
		log.error("hello this is error");
		Assert.assertEquals(title,"Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag=loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
	//	homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		homePage = loginPage.login("sirisisa","ecegvp09");
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
