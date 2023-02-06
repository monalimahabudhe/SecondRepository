package com.CRM.qa.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.qa.base.TestBase;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class LoginPageTest extends TestBase{
	com.CRM.qa.pages.LoginPage LoginPage;
	com.CRM.qa.pages.HomePage HomePage;
	
	@BeforeMethod
	
	public void SetUp() throws IOException
	{
		Initialization();
		LoginPage= new com.CRM.qa.pages.LoginPage();
	}

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title= LoginPage.LoginPageTitleValidation();
		Assert.assertEquals(title, "Free CRM");
	}
	
	@Test(priority=2)
	public void LoginTest() throws IOException, InterruptedException
	{
		HomePage = LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}

}
