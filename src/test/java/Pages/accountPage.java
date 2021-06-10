package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountPage {

	public accountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[@id='Account_Tab']")
	public WebElement accountTab;
	
	
	@FindBy(xpath = "//a[@id='tryLexDialogX']")
	public WebElement lightPopup;
	
	@FindBy(id = "createNewLabel")
	public WebElement newLabel;
	
	@FindBy(xpath = "//div[@id='createNewMenu']/a[3]")
	public WebElement menuAccount;
	
	@FindBy(xpath = "//input[@id='acc2']")
	public WebElement accountName;
	
	@FindBy(xpath = "//td[@id='bottomButtonRow']/input[1]")
	public WebElement newAccount_save;
	
	@FindBy(xpath = "//div[@class='textBlock']/h2")
	public WebElement newAccountLabel;

	//TestCase11
	@FindBy(xpath = "//span[@class='fFooter']/a[2]")
	public WebElement viewLabel;

	@FindBy(id = "fname")
	public WebElement viewName;

	@FindBy(id = "devname")
	public WebElement viewUname;

	@FindBy(xpath = "//input[@data-uidsfdc='3']")
	public WebElement viewSave;
	
	@FindBy(xpath = "//select[@name='fcf']")
	public WebElement viewDrp;

	//TestCase 14
	@FindBy(xpath = "//div[@class='lbBody']/ul/li[2]/a")
	public WebElement accountsReport;
	
	@FindBy(xpath = "//input[@id='ext-gen20']")
	public WebElement lastActivity;
	
	@FindBy(xpath = "//div[@class='x-combo-list-inner']/div[3]")
	public WebElement selectOption;
	
	@FindBy(name = "startDate")
	public WebElement startDate;
	
	@FindBy(name = "endDate")
	public WebElement endDate;
	
	@FindBy(id = "ext-gen49")
	public WebElement saveReport;
	
	@FindBy(id = "saveReportDlg_reportNameField")
	public WebElement reportName;
	
	@FindBy(id = "saveReportDlg_DeveloperName")
	public WebElement developerName;
	
	@FindBy(xpath = "/html/body/div[17]/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button")
	public WebElement saveRun;
	
}
