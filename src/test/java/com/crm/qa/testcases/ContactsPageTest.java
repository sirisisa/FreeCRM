package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";

	public ContactsPageTest(){
		super();
}

	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login("sirisisa","ecegvp09");
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}	

	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is missing on the page");	
	}
		
	@Test(priority=2)
	public void selectContactsTest() throws InterruptedException{
			contactsPage.selectContactsByName("Cont4 FL Cont4 LL");
			Thread.sleep(3000);
	}	
	
	@Test(priority=3)
	public void selectMultipleContactsTest() throws InterruptedException{
			contactsPage.selectContactsByName("Cont4 FL Cont4 LL");
			contactsPage.selectContactsByName("Cont3 FL Cont3 LL");
			Thread.sleep(6000);
	}	
		
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data [][]=TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=4,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstName,String lastName,String company) throws InterruptedException{
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title,firstName,lastName,company);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

	