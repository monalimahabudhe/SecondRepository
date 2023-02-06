package com.CRM.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.CRM.qa.base.TestBase;

public class ContactsPage extends TestBase{

	public ContactsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@class,'hidden']")
	WebElement SelectRow1;
	
	@FindBy(xpath="//input[contains(name='first_name')]")
	WebElement Fname;
	@FindBy(xpath="//input[contains(name='last_name')]")
	WebElement Lname;
	@FindBy(xpath="//button[contains(@class,'ui linkedin button')//i[@class,'save icon']]")
	WebElement Save;
	
	
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void SelectContactListItem(String name)
	{
		SelectRow1.click();	
		driver.findElement(By.xpath("//a[text()='Mona1 Test1 Mahabudhe']//")).click();
	}
	
	public void AddNewContact(String Firstname, String Lastname)
	{
		Fname.sendKeys(Firstname);
		Lname.sendKeys(Lastname);
		Select select = new Select(driver.findElement(By.name("status")));
		select.selectByIndex(1);
		Save.click();
		
		
	}
	
	

}
