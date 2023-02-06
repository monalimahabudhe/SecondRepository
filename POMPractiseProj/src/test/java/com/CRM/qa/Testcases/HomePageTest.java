package com.CRM.qa.Testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.qa.base.TestBase;
import com.CRM.qa.pages.ContactsPage;

public class HomePageTest extends TestBase{
	com.CRM.qa.pages.LoginPage LoginPage;
	com.CRM.qa.pages.HomePage HomePage;
	com.CRM.qa.Util.TestUtil TestUtil;

	public HomePageTest() throws IOException {
		super();		
	}

	@BeforeMethod
	public void SetUp() throws IOException, InterruptedException
	{	Initialization();
	    TestUtil= new com.CRM.qa.Util.TestUtil();
		LoginPage =new com.CRM.qa.pages.LoginPage();
		ContactsPage ContactsPage = new com.CRM.qa.pages.ContactsPage(); 
		HomePage=LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=0)
	public void VerifyHomePageTitle() {
		String HomePageTitle=HomePage.VerifyHomePageTitle();
		Assert.assertEquals(HomePageTitle,"Cogmento CRM");;
	}
	
	@Test(priority=1)
	public void VerifyUsername()
	{	//TestUtil.SwitchToframe();
		Assert.assertTrue(HomePage.VerifyCorrectUsername());
		
	}
	@Test(priority=2)
	public void VerifycontactslinkTest() throws IOException
	{
		HomePage.ClickonContactslink();
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
	
}
