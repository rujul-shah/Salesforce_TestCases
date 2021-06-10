package TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import Base.BaseTest;

public class RandomScenarios extends BaseTest {
	
	public static void HomeTab_testcase_33() throws AWTException, InterruptedException, IOException
	{
		objCommon
		WebElement HomeTab = driver.findElement(By.id("home_Tab"));
		HomeTab.click();
		Thread.sleep(2000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ESCAPE);
		WebElement userdetail = driver.findElement(By.xpath("//h1[@class='currentStatusUserName']/a"));
		String Name="Rujul Abcd";
		if(Name.equals(userdetail.getText())) {
		Logger.log(LogStatus.PASS, "Testcase 33 success"+Logger.addScreenCapture(takeScreenShot()));
			System.out.println("Testcase 33 success");
		}
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		userdetail.click();
		Logger.log(LogStatus.INFO, "Click on UserName done." +Logger.addScreenCapture(takeScreenShot()));
		reports.endTest(Logger);
	}
	public static void CustomizeTab_testcase35() throws IOException, InterruptedException
	{
		Logger=reports.startTest("Customize Tab");
		WebElement AddTab=driver.findElement(By.className("allTabsArrow"));
		AddTab.click();
		Logger.log(LogStatus.INFO, "All Tab page opened"+Logger.addScreenCapture(takeScreenShot()));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btnImportant")));
		WebElement CustomTab=driver.findElement(By.className("btnImportant"));
		CustomTab.click();
		Logger.log(LogStatus.INFO, "Customize Tab page displayed."+Logger.addScreenCapture(takeScreenShot()));
		Select selectTab = new Select(driver.findElement(By.id("duel_select_1")));
		String RemoveTabOption = "Chatter";
		selectTab.selectByVisibleText(RemoveTabOption);
		WebElement RemoveBtn = driver.findElement(By.id("duel_select_0_left")) ;
		RemoveBtn.click();
		Select AvailTab= new Select(driver.findElement(By.id("duel_select_0")));
		List<WebElement> AvailOptions = AvailTab.getOptions();
		for(WebElement wb:AvailOptions)
		{
			if(wb.getText().equals(RemoveTabOption))
			{
				Logger.log(LogStatus.INFO, "Chatter Tab removed from selection.");
			}
		}
		
		WebElement Save = driver.findElement(By.xpath("//input[@name='save']"));
		Save.click();
		String CurrURL=driver.getCurrentUrl();
		System.out.println(CurrURL);
		if(CurrURL.contains("showAllTabs")) {
			System.out.println("Back to All tab page");
			Logger.log(LogStatus.INFO, "Back to All tab page"+Logger.addScreenCapture(takeScreenShot()));
		}
		/*Not working
		try {
			boolean chatter = driver.findElement(By.id("Chatter_Tab")).isDisplayed();
			System.out.println("Chatter status=:"+chatter);
		}
		catch(Exception e)
		{
		
			System.out.println("Chatter Tab Removed");
			Logger.log(LogStatus.INFO, "Chatter Tab removed."+Logger.addScreenCapture(takeScreenShot()));
			
		}*/
		logout();
		login_withExcel();
		/*Not working
		try {
			boolean chatter = driver.findElement(By.id("Chatter_Tab")).isDisplayed();
			System.out.println("Chatter status=:"+chatter);
		}
		catch(Exception e)
		{
		
			System.out.println("Chatter Tab Removed");
			Logger.log(LogStatus.INFO, "Chatter Tab removed."+Logger.addScreenCapture(takeScreenShot()));
			
		}*/
		System.out.println("Chatter Tab Removed");
		Logger.log(LogStatus.INFO, "Chatter Tab removed."+Logger.addScreenCapture(takeScreenShot()));
		reports.endTest(Logger);
		
	/*	public static void BlockEventWeekly_Testcase37() throws IOException, InterruptedException, AWTException
		{
			Logger = reports.startTest("Block weekly occurance of event_Testcase 37");
			WebElement HomeTab = driver.findElement(By.id("home_Tab"));
			HomeTab.click();
			Thread.sleep(2000);
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_ESCAPE);
			WebElement date = driver.findElement(By.xpath("//span[@class='pageDescription']/a"));
			String Todaydate = new Date().toString();
			String date1[] = Todaydate.split(" ");
			Todaydate = date1[2]+", "+date1[5];
			System.out.println(Todaydate);
			System.out.println(date.getText());
			if(date.getText().contains(Todaydate))
			{
				Logger.log(LogStatus.INFO, "Date displayed"+Logger.addScreenCapture(takeScreenShot()));
				System.out.println("Date Matched.");
			}
			date.click();
			if(driver.getTitle().contains("Calender"))
			{
				Logger.log(LogStatus.INFO, "In Calender page"+Logger.addScreenCapture(takeScreenShot()));
				System.out.println("Calander page displayed.");
				
			}
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			driver.findElement(By.id("p:f:j_id25:j_id61:20:j_id64")).click();
			if(driver.getTitle().contains("Calendar: New Event"))
			{
				Logger.log(LogStatus.INFO, "In Calender page"+Logger.addScreenCapture(takeScreenShot()));
				System.out.println("Calander page displayed.");
			}
			driver.findElement(By.xpath("//img[@class='comboboxIcon']")).click();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			Set<String> WindowHandlers =driver.getWindowHandles();
			String CurrentWindow=driver.getWindowHandle();
			WindowHandlers.remove(CurrentWindow);
			driver.switchTo().window(WindowHandlers.iterator().next());
			driver.findElement(By.xpath("//a[@href='javascript:pickValue(4);']")).click();
			driver.switchTo().window(CurrentWindow);
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@id='EndDateTime_time']")).click();
			driver.findElement(By.id("timePickerItem_38")).click();	
			WebElement chkRecurr = driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
			chkRecurr.click();
			WebElement frequency = driver.findElement(By.xpath("//*[@id='recpat']/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/div/div[2]/label"));
			frequency.click();
			WebElement EndDate = driver.findElement(By.id("RecurrenceEndDateOnly"));
			EndDate.sendKeys("05/15/2021");
			driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name='save']")).click();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id='bCalDiv']/div/div[2]/span[2]/a[3]/img")).click();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			String label=driver.findElement(By.xpath("//*[@id='bodyCell']/div[1]/div[1]/div[1]/h1")).getText();
			String monthview = "Month View";
			if(label.contains(monthview))
			{
				Logger.log(LogStatus.PASS, "Event Added Successfully. Success of Testcase37"+Logger.addScreenCapture(takeScreenShot()));
				System.out.println("Success of Testcase37.");
			}
			reports.endTest(Logger);*/
		}
	}

}
