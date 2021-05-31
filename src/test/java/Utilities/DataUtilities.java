package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Base.BaseTest;

public class DataUtilities {
	
	public String[] ReadExcelData() throws IOException
	{
		FileInputStream fis = new FileInputStream(AppConstants.CREDENTIALS_PATH);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Credentials");
		String[] sCreds = new String[2];
		sCreds[0] = sheet.getRow(1).getCell(1).getStringCellValue();
		sCreds[1] = sheet.getRow(1).getCell(2).getStringCellValue();
		return sCreds;
		
	}
	public String ReadPageURL(String key) throws IOException
	{
		BaseTest.properties = new Properties();
		FileInputStream fis = new FileInputStream(AppConstants.PAGEURLPROPERTYFILE);
		BaseTest.properties.load(fis);
		return BaseTest.properties.getProperty(key);
		
	}

}
