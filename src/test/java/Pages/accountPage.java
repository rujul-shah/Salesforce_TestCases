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
	public WebElement selectTab;
	
	@FindBy(id = "//li[@id='createNewLabel']")
	public WebElement newLabel;
	
	@FindBy(xpath = "//div[@id='createNewMenu']/a[3]")
	public WebElement menuAccount;
	
	@FindBy(xpath = "//input[@id='acc2'")
	public WebElement accountName;
	
	@FindBy(xpath = "//td[@id='bottomButtonRow']/input[1]")
	public WebElement newAccount_save;
	
	@FindBy(xpath = "//div[@class='textBlock']/h2")
	public WebElement newAccountLabel;

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

}
