package TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import Base.BaseTest;
import Pages.loginPage;

public class VerifyLogin extends BaseTest {
	
	
	@Parameters({"BrowserName"})
	@Test(priority=0, dataProvider = "")
	public void testCase01(String sBrowserName) throws IOException
	{
		
		//sa=new SoftAssert();
	//	driver=getBrowser(sBrowserName);
		lp=new loginPage(driver);
		objCommon.enterText(lp.username,objData.ReadExcelData()[0],"Username");
		lp.password.clear();
		objCommon.onClick(lp.login, "Login Button");
		objCommon.waitForElement(lp.error);
		sa.assertEquals(lp.error.getText(), "Please enter your password.");
		test.pass("Test Case01 Passed.");
		//sa.assertAll();
	}
	
	@Parameters({"BrowserName"})
	@Test
	public void testCase02(String sBrowserName) throws Exception
	{
	//	sa = new SoftAssert();
		//driver=getBrowser(sBrowserName);
		lp=new loginPage(driver);
		objCommon.login();
		Thread.sleep(10000);
		sa.assertEquals(driver.getTitle().trim(), "Home Page ~ Salesforce - Developer Edition");
		System.out.println(driver.getTitle());
		test.info("Login Success");
	//	sa.assertAll();
	}
	
	@Parameters({"BrowserName"})
	@Test
	public void testCase03(String sBrowserName) throws IOException, InterruptedException
	{
		//sa=new SoftAssert();
		//driver=getBrowser(sBrowserName);
		lp=new loginPage(driver);
		objCommon.waitForElement(lp.rememberMe);
		objCommon.onClick(lp.rememberMe, "Remember ME");
		lp.rememberMe.click();
		objCommon.login();
		Thread.sleep(5000);
		objCommon.logout();
		objCommon.waitForElement(lp.username);
		if(lp.rememberMe.isSelected())
			test.pass("Testcase 3 success");
		//sa.assertAll();
	}
	
	@Parameters({"BrowserName"})
	@Test
	public void testCase04(String sBrowserName) throws IOException, InterruptedException
	{
		//sa=new SoftAssert();
		//driver=getBrowser(sBrowserName);
		lp=new loginPage(driver);
		objCommon.waitForElement(lp.forgotPassword);
		objCommon.onClick(lp.forgotPassword, "Forgot Password");
		Thread.sleep(1000);
		objCommon.enterText(lp.fUname, objData.ReadExcelData()[0], "Username from Forget password.");
		objCommon.onClick(lp.fContinue, "Continue");
		String str1="We’ve sent you an email with a link to finish resetting your password.";
		sa.assertEquals(lp.fMessage.getText(), str1);
		test.pass("Testcase 4 success");
		//sa.assertAll();
	}
	

}
