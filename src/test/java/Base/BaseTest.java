package Base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.loginPage;
import Utilities.AppConstants;
import Utilities.CommonUtilities;
import Utilities.DataUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	public static String sReportTime;
	public static SoftAssert sa;
	public static String sBrowserName;
	public static Properties properties;
	public CommonUtilities objCommon = new CommonUtilities();
	public DataUtilities objData = new DataUtilities();
	public static loginPage lp;
	
	public WebDriver getBrowser(String sBrowsername) throws IOException
	{
		String sBrowserName = sBrowsername;
		switch(sBrowserName.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default:
			driver=null;
			break;
			
		}	
		driver.manage().window().maximize();
		driver.get(objData.ReadPageURL("Salesforce.HomePage"));
		lp=new loginPage(driver);
	//	lp= new loginPage(driver);
		return driver;
		
	}
	@BeforeTest
	public void initReport()
	{
		sReportTime = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		htmlReporter = new ExtentHtmlReporter(AppConstants.EXTENTREPORTPATH+"/"+sReportTime+".html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		
	}
	@AfterTest
	public void teardown()
	{
		report.flush();
	}
	@BeforeMethod
	public void createReport(Method sMethodName)
	{
		test=report.createTest(sMethodName.getName());
	}
	@AfterMethod
	public void closure() throws Exception
	{
		Thread.sleep(5000);
		driver.close();
	}
	
}
