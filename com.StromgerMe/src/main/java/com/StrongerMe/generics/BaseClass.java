package com.StrongerMe.generics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.StrongerMe.ObjectRepositry.*;

/**
 * Base class configuration
 * @author Shivaprasad
 *
 */

public class BaseClass 
{
	public WebDriver driver;
	public static WebDriver staticDriver;
	public ExcelUtiltiy eUtil = new ExcelUtiltiy(IAutoConstant.EXCELPATH);
	public FileUtility fUtil = new FileUtility(IAutoConstant.COMMONDATAPROPERTYPATH);
	public WebDriverUtility wUtil = new WebDriverUtility();
	public HomePage homePage;
	public LoginPage loginPage;	
	@BeforeClass
	public void configBC() throws Throwable{
		String browserName = fUtil.getPropertyStringValue("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","./src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","./src/main/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.gecko.driver","./src/main/resources/driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
		}
		staticDriver = driver;
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void configBM() throws Throwable {
		String url = fUtil.getPropertyStringValue("url");
		driver.get(url);
	}
	@AfterMethod
	public void configAM() {
		
	}
	
	@AfterClass
	public void cofigAC() {
		driver.close();
	}
	/**
	 * This method will set the report path, document title, report name, theme and reporter name.
	 */
}
