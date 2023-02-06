package com.CRM.qa.Testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.qa.base.TestBase;
import com.CRM.qa.pages.ContactsPage;

public class ContactsPageTest extends TestBase{
	com.CRM.qa.pages.LoginPage LoginPage;
	com.CRM.qa.pages.HomePage HomePage;
	com.CRM.qa.Util.TestUtil TestUtil;
	ContactsPage ContactsPage;

	public ContactsPageTest() throws IOException {
		super();
		PageFactory.initElements(driver,this);
			
	}
	
	@BeforeMethod
	public void SetUp() throws IOException, InterruptedException
	{	Initialization();
	    TestUtil= new com.CRM.qa.Util.TestUtil();
		LoginPage =new com.CRM.qa.pages.LoginPage();
		ContactsPage ContactsPage = new com.CRM.qa.pages.ContactsPage(); 
		HomePage=LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.SwitchToframe();
		HomePage.ClickonContactslink();
		
	}
	
	@Test(priority=0)
	public void VerifycontactspageLable()
	{
		Assert.assertTrue(ContactsPage.verifyContactsLabel(),"Contacts Lable is missing on Page");	
	}
	@Test(priority=1)
	public void selectContacsList()
	{
		ContactsPage.SelectContactListItem("Mona1 Test1 Mahabudhe");
	}
	
	@Test
	public void ValidateNewlyAddedContacts() throws IOException
	{
		HomePage.ClickonContactslink();
		ContactsPage.AddNewContact("Mona4","Mahabudhe4");
	}
	@DataProvider
	public void GetTestDataExcel()
	{
	//TestUtil.	
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
	
	
	
	

}
