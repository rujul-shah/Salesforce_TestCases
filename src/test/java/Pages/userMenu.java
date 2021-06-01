package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userMenu {
	
	public userMenu(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@id='userNavLabel']")
	public WebElement userNavlable;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/child::*")
	public List<WebElement> userMenuItem;
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']/child::a[1]")
	public WebElement userProfile;

}
