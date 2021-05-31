package TestCases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import Base.BaseTest;
import Pages.loginPage;

public class VerifyLogin extends BaseTest {
	
	
	@Parameters({"BrowserName"})
	@Test(priority=0)
	public void testCase01(String sBrowserName) throws IOException
	{
		
		sa=new SoftAssert();
		driver=getBrowser(sBrowserName);
		lp=new loginPage(driver);
		lp.username.sendKeys(objData.ReadExcelData()[0]);
		lp.password.clear();
		lp.login.click();
		objCommon.waitForElement(lp.error, "Error Text");
		sa.assertEquals(lp.error.getText(), "Please enter your password.");
		test.pass("Test Case01 Passed.");
		sa.assertAll();
	}
	
	@Parameters({"BrowserName"})
	@Test
	public void testCase02(String sBrowserName) throws Exception
	{
		sa = new SoftAssert();
		driver=getBrowser(sBrowserName);
		lp=new loginPage(driver);
		objCommon.login();
		Thread.sleep(10000);
		sa.assertEquals(driver.getTitle().trim(), "Home Page ~ Salesforce - Developer Edition");
		System.out.println(driver.getTitle());
		test.info("Login Success");
		sa.assertAll();
	}
	

}
