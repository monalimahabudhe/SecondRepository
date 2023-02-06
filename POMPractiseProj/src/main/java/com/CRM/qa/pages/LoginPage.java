package com.CRM.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement Login;

	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement submit_btn;
	
	@FindBy(xpath="//div[@id='main-nav']//a[@href='/contacts']")
	WebElement Contacts;
	
	public LoginPage() throws IOException {
		//super();
		PageFactory.initElements(driver, this);
		}
	public String LoginPageTitleValidation()
	{
		return driver.getTitle();
		
	}
	public boolean ValidateContacts()
	{
		return Contacts.isDisplayed();
	}
	
	public HomePage login(String Uname , String Pword) throws IOException, InterruptedException
	
	{
	//	Thread.sleep(1000);
		Login.click();
		username.sendKeys(Uname);
		password.sendKeys(Pword);
		submit_btn.click();		
		return new HomePage();
	}
	

	
}
