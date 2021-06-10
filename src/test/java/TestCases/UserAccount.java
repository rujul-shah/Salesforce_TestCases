package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.accountPage;

public class UserAccount extends BaseTest{

	
	public void SelectAccountsTab()
	{
		
		ap = new accountPage(BaseTest.driver);
		objCommon.waitForElement(ap.accountTab);
		objCommon.onClick(ap.accountTab, "Accounts Tab");
		objCommon.waitForElement(ap.lightPopup);
		objCommon.onClick(ap.lightPopup, "Lightning Popup");
	}
	
	@Test(dataProvider = "Accounts_Name")
	public void TestCase10_CreateAccount(String name) throws IOException
	{
		objCommon.login();
		SelectAccountsTab();
		objCommon.waitForElement(ap.newLabel);
		objCommon.onClick(ap.newLabel, "Create New");
		objCommon.onClick(ap.menuAccount, "Menu Account");
		String Name = name;
		objCommon.enterText(ap.accountName, Name, "Account Name");
		objCommon.onClick(ap.newAccount_save, "Save Account");
		BaseTest.test.pass("Testcase 10 Success");
		sa.assertEquals(ap.newAccountLabel, Name);
	}
	@Test(dataProvider = "View_Name")
	public void TestCase11_CreateView(String VName, String VUname) throws IOException
	{
		objCommon.login();
		SelectAccountsTab();
		objCommon.onClick(ap.viewLabel, "View");
		objCommon.enterText(ap.viewName, VName, "View Name");
		ap.viewUname.clear();
		objCommon.enterText(ap.viewUname, VUname, "View Unique Name");
		objCommon.onClick(ap.viewSave, "Save View");
		objCommon.waitForElement(ap.viewDrp);
		
		Select ViewDrp = new Select(ap.viewDrp);
		sa.assertEquals(ViewDrp.getFirstSelectedOption().getText(), VName);
		BaseTest.test.pass("Testcase 11 Success");
				
	}
	
	@DataProvider(name="Accounts_Name")
	public Object[][] account_Name()
	{
		return new Object[][] {{"Jinesh"}};
	}
	@DataProvider(name="View_Name")
	public Object[][] view_Name()
	{
		return new Object[][] {{"Today's view1","TD2"}};
	}
	/*@DataProvider(name="View_UniqueName")
	public Object[][] view_uniquename()
	{
		return new Object[][] {{"TD1"}};
	}*/
	
	
}
