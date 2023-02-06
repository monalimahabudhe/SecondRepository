package com.CRM.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.qa.base.TestBase;

public class HomePage extends TestBase{

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
			}
	
	@FindBy(xpath="//span[contains(text(),'Monali Mahabudhe Mahabudhe')]")
	WebElement userdisplay;
	
	@FindBy(xpath="//div[@class,'menu-item-wrapper']//a[@href,'/tasks']")
	WebElement tasks;
	
	@FindBy(xpath="//div[@class,'menu-item-wrapper']//a[@href,'/deals")
	WebElement deals;
	
	@FindBy(xpath="//div[@id='main-nav']//a[@href='/contacts']")
		WebElement Contacts;
	
	@FindBy(xpath="//button[@class,'ui linkedin button']//a[@href='/contacts/new']")
	WebElement CreateContacts;
	
	
	public String VerifyHomePageTitle()
	{
		return driver.getTitle();
	}
	public boolean VerifyCorrectUsername()
	{
		return userdisplay.isDisplayed();
	
	}
	public ContactsPage ClickonContactslink() throws IOException
	{
		tasks.click();
		return new ContactsPage();	
	}

	public TaskPage ClickonTasklink() throws IOException
	{
		tasks.click();
		return new TaskPage();	
	}
	public DealsPage clickonDealsLink() throws IOException
	{
		deals.click();
		return new DealsPage();
	}
	
	public void ClickOnNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(Contacts).build().perform();
		CreateContacts.click();
	}
}

	

