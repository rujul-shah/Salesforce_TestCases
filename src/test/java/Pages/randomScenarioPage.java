package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class randomScenarioPage {
	
	public randomScenarioPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Test case 33
	@FindBy(id="home_Tab")
	public WebElement homeTab;
	
	@FindBy(xpath="//h1[@class='currentStatusUserName']/a")
	public WebElement name;
	
	//Test case 35
	@FindBy(className = "allTabsArrow")
	public WebElement tabsArrow;
	
	@FindBy(className = "btnImportant")
	public WebElement customiseTab;
	
	@FindBy(id = "duel_select_1")
	public WebElement selectTab;
		
	@FindBy(id = "duel_select_0_left")
	public WebElement leftSelect;	
	
	@FindBy(id = "duel_select_0")
	public WebElement availTab;
	
	@FindBy(xpath="//input[@name='save']")
	public WebElement save;
	
	//Test case 37
	
}
