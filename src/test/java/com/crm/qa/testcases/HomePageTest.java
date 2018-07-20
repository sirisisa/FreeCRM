package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
		LoginPage loginPage;
		HomePage homePage;
		TestUtil testUtil;
		ContactsPage contactsPage;
		
		public HomePageTest(){
			super();
	
	}

		@BeforeMethod
		public void setUp(){
			initialization();
			testUtil = new TestUtil();
			loginPage = new LoginPage();
			contactsPage = new ContactsPage();
			homePage = loginPage.login("sirisisa","ecegvp09");
			
		}
		
		@Test(priority=1)
		public void verifyHomePageTitleTest(){
			String homePageTitle = homePage.verifyHomePageTitle();
			Assert.assertEquals(homePageTitle,"CRMPRO","Home Page Tiltle not found");
		}
		
		@Test(priority=2)
		public void verifyUserNameTest(){
			testUtil.switchToFrame();
			Assert.assertTrue( homePage.verifyCorrectUserName(), "Incorrect username");
		}
				
		@Test(priority=3)
		public void verifyContactsLinkTest(){
			testUtil.switchToFrame();
			contactsPage = homePage.clickOnContactsLink();
		}
		
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
}
