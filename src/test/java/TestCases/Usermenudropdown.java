package TestCases;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import Base.BaseTest;
import Pages.userMenu;
import Utilities.AppConstants;

//@Listeners(Listners.TestListners.class)
public class Usermenudropdown extends BaseTest{
	
	@Test
	public void testCase05() throws IOException
	{
		//driver=getBrowser(sBrowserName);
		um1=new userMenu(driver);
		objCommon.login();
		String[] TextValue=new String[4];
		TextValue[0]="My Profile";
		TextValue[1]="My Settings";
		TextValue[2]="Developer Console";
		TextValue[3]="Logout";
	
		objCommon.onClick(um1.userNavlable, "User Navigation drop down");
		List<WebElement> MenuList = um1.userMenuItem;
		int i=0;
		boolean flag=false;
		for(WebElement V : MenuList) {
			System.out.println(TextValue[i]);
			System.out.println(V.getText());
			System.out.println();
			if(!TextValue[i].equals(V.getText()))
			{
				flag=true;
				break;
			}
			i++;
			
		}
		if(flag)
		{
			BaseTest.test.fail("Text Mismatch");
		}
		else
			BaseTest.test.pass("Success of TestCase 5");
	//	sa.assertAll();
		
	}
	
	@Test(dataProvider = "lastname")
	public void testCase06(String lname) throws IOException, InterruptedException
	{
		
		um1=new userMenu(driver);
		objCommon.login();
		objCommon.waitForElement(um1.userNavlable);
		objCommon.onClick(um1.userNavlable, "Usermenu");
		objCommon.onClick(um1.userProfile, "User Profile");
		Thread.sleep(2000);
		objCommon.waitForElement(um1.editProfile);
		Thread.sleep(2000);
		objCommon.onClick(um1.editProfile, "Edit Profile");
		//step 4
		Thread.sleep(2000);
		driver.switchTo().frame("contactInfoContentId");
		objCommon.onClick(um1.aboutTab, "About Tab");
		um1.lastName.clear();
		objCommon.enterText(um1.lastName, lname, "Last Name");
		um1.saveAll.click();
		if(um1.labelText.getText().contains(lname))
			BaseTest.test.pass("Success of Test Case 6.4");
		
		//step 5
		objCommon.onClick(um1.attachPhoto, "Attach Photo");
		WebElement web = um1.editor;
		driver.switchTo().frame(web);
		WebElement TextEditor = um1.content;
		TextEditor.sendKeys("POM test");
		driver.switchTo().parentFrame();
		objCommon.onClick(um1.publishButton, lname);
		//step 6
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@id='publisherAttachContentPost']/span[1]")));
		Thread.sleep(4000);
		objCommon.onClick(um1.publishAttach, "Attach content post");
		Thread.sleep(1000);
		objCommon.onClick(um1.uploadFile, "Upload File");
		Thread.sleep(1000);
		WebElement ChatterFile = driver.findElement(By.id("chatterFile"));
		objCommon.enterText(um1.chatterFile, AppConstants.IMAGE_PATH, "Chatter File");
		objCommon.onClick(um1.publishButton, "Publish Button");
		//step 7
		Thread.sleep(1000);
		
		objCommon.onClick(um1.badge, "Moderator Badge");
		objCommon.onClick(um1.upload, "Upload");
		WebElement frame = um1.photoID;
		Thread.sleep(1000);
		driver.switchTo().frame(frame);
		Thread.sleep(1000);
		WebElement chooseFile = um1.chooseFile;
		objCommon.enterText(chooseFile, AppConstants.IMAGE_PATH, "Upload Image");
		Thread.sleep(5000);
		objCommon.onClick(um1.uploadButton, "Upload Button");
		Thread.sleep(5000);
		objCommon.onClick(um1.saveButton, "Save");
				
}
	@Test
	public void testCase08_developerConsole() throws IOException
	{
		um1=new userMenu(driver);
		objCommon.login();
		objCommon.onClick(um1.userNavlable, "Usermenu");
		objCommon.onClick(um1.developerConsole, "Developer Console");
		Set<String> GetAllWindows = driver.getWindowHandles();
		String[] GetWindow = GetAllWindows.toArray(new String[GetAllWindows.size()]);
		//System.out.println(GetAllWindows.size());
		driver.switchTo().window(GetWindow[1]);
		driver.quit();
		//System.out.println(driver.getCurrentUrl());
		BaseTest.test.pass("Testcase 8 Success");
	}
	@Test
	public void testCase09_Logout() throws IOException
	{
		um1=new userMenu(driver);
		objCommon.login();
		objCommon.onClick(um1.userNavlable, "Usermenu");
		objCommon.onClick(um1.logout, "Log Out");
		String LogOutUrl = driver.getCurrentUrl();
		sa.assertEquals(objData.ReadPageURL("Salesforce.logout"), LogOutUrl, "URL Match.");
		BaseTest.test.pass("Testcase 9 success");
	}
	
	@DataProvider(name="lastname")
	public Object[][] lastname()
	{
		return new Object[][] {{"Shah"}};
				
	}
}
