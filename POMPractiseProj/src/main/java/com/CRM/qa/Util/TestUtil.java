package com.CRM.qa.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.CRM.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIME=20;
	public static long IMPLICIT_WAIT=10;
	public static HSSFWorkbook wb;
	public static HSSFSheet sheet;
	public static String DATASHEET_PATH="C:\\Users\\monali.mahabudhe\\eclipse-workspace\\POMPractiseProj\\src\\main\\java\\com\\CRM\\qa\\TestData\\TestNgDataProvider.xlsx";

	
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void SwitchToframe() {
		driver.switchTo().frame("mainpanel");
	}
		
		
	/*
	 * public static Object[][] getTestdataExcel(StringSheet) throws
	 * EncryptedDocumentException, IOException {
	 * 
	 * // FileInputStream fis= null; FileInputStream fis = new
	 * FileInputStream(DATASHEET_PATH);
	 * wb=(HSSFWorkbook)WorkbookFactory.create(fis);
	 * sheet=wb.getSheet("NewContact"); Object[][] data= new
	 * Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; for(int
	 * i=0;i<=sheet.getLastRowNum();i++){ for(int k =0
	 * ;k<=sheet.getRow(i).getLastCellNum();i++) {
	 * data[i][k]=sheet.getRow(i+1).getCell(k).toString(); return null;
	 * 
	 * } } }
	 */	

	private void TakeScreenshotAtendofTC() throws IOException {
		File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrfile, new File(currentDir +"/screenshots/"+System.currentTimeMillis()+".png"));
		
		
	}


}
