package TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import Base.BaseTest;
import Pages.userMenu;

public class Usermenudropdown extends BaseTest{
	
	@Parameters({"BrowserName"})
	@Test
	public void testCase05(String sBrowserName) throws IOException
	{
		driver=getBrowser(sBrowserName);
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
			BaseTest.test.info("Text Mismatch");
		}
		else
			BaseTest.test.pass("Success of TestCase 5");
		
	}

}
