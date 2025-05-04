package com.swag.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.swag.qa.base.BaseClass;

public class UtilClass extends BaseClass{
	
	public static long page_Load_TimeOut = 20;
	public static long implicitly_Wait = 10;
	
	public static String testData_path = "D:\\Eclipse\\Bavya_Workspace\\SwagLabsAutomation\\src\\main\\java\\com"
			+ "\\swag\\qa\\testdata\\CheckoutInfo.xlsx";
	
	public Workbook book;
	public Sheet sheet;
	
	public Object[][] getTestData(String sheetName) {
		
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(testData_path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0; i < sheet.getLastRowNum(); i++) {
			for(int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		
		return data;
		
	}
	
	public void selectFromDropDown(WebElement dropDown, String visibleText) {
		Select select = new Select(dropDown);
		select.selectByVisibleText(visibleText);
	}
	
	public void handleAlerts() {
		Alert alert = driver.switchTo().alert();
		alert.getText();
		alert.accept();
	}
	
	

}
