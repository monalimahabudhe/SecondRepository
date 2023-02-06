package com.CRM.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.CRM.qa.Util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream ("C:\\Users\\monali.mahabudhe\\eclipse-workspace\\POMPractiseProj\\src\\main\\java\\com\\CRM\\qa\\config\\config.properties");
			prop.load(ip);
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}
		}
	
	@SuppressWarnings("deprecation")
	public void Initialization()
	{
		String BrowserName=prop.getProperty("browser");
		if(BrowserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();			
		}
		else if(BrowserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\SELENIUM\\chromedriver_win32\\geckodriver.exe");
			 driver = new FirefoxDriver();}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
			}
	
	
}
