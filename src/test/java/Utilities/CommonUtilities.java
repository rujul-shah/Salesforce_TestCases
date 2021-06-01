package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Base.BaseTest;
import Pages.loginPage;

public class CommonUtilities {
	
	public void takeScreenshot() throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)BaseTest.driver;
		String addDate = new SimpleDateFormat("yyyymmddhhmm").format(new Date());
		String dstFilePath = "/screenshot/"+addDate+".PNG";
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(dstFilePath);
		FileUtils.copyFile(sourceFile, destFile);
		
	}
	public void enterText(WebElement element, String text, String elementName)
	{
		if(element.isDisplayed())
		{
			element.sendKeys(text);
			BaseTest.test.log(Status.INFO, "Text to " + elementName +" entered successfully.");	
		}
		else
			BaseTest.test.log(Status.INFO,elementName + "didnt display.");
		
	}
	public void onClick(WebElement element, String elementName)
	{
		if(element.isDisplayed())
		{
			element.click();
			BaseTest.test.log(Status.INFO, elementName +" clicked.");	
		}
		else
			BaseTest.test.log(Status.INFO,elementName + "didnt display.");
	}
	public boolean waitForElement(WebElement element)
	{
		try {
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void verifyText(String originalText, String outPut, String msg)
	{
		BaseTest.sa.assertEquals(originalText, outPut);
		BaseTest.test.pass(msg + "verified successfully.");
		
	}
	public void login() throws IOException
	{
		DataUtilities objData = new DataUtilities();
		String[] creds = new String[2];
		creds= objData.ReadExcelData();
		enterText(BaseTest.lp.username, creds[0], "Username");
		enterText(BaseTest.lp.password, creds[1], "Password");
		onClick(BaseTest.lp.login, "Login Button");
		
		BaseTest.test.pass("Login Success");
			
	}
	public void logout()
	{
		waitForElement(BaseTest.lp.userNavlable);
		onClick(BaseTest.lp.userNavlable, "User Menu");
		onClick(BaseTest.lp.logOut, "Log Out");
		
		BaseTest.test.pass("Successfully logged out.");
	}
}
