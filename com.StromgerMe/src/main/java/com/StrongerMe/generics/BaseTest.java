package com.StrongerMe.generics;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.StrongerMe.ObjectRepositry.HomePage;
import com.StrongerMe.ObjectRepositry.LoginPage;
import org.apache.log4j.Logger;

/**
 * Base class configuration
 * @author Shivaprasad
 *
 */

public class BaseTest 
{
	public WebDriver driver;
	public static WebDriver staticDriver;
	public ExcelUtiltiy eUtil = new ExcelUtiltiy(IAutoConstant.EXCELPATH);
	public FileUtility fUtil = new FileUtility(IAutoConstant.COMMONDATAPROPERTYPATH);;
	public WebDriverUtility wUtil = new WebDriverUtility();
	public LoginPage loginPage;
	public HomePage homePage;
	public Logger logger;
	
	@BeforeClass
	public void configBC() throws Throwable{
	    logger = Logger.getLogger("StrongerMe");
		PropertyConfigurator.configure("Log4j.properties");
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
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		staticDriver = driver;
	}
	@BeforeMethod
	public void configBM() throws Throwable {
		String url = fUtil.getPropertyStringValue("url");
		logger.info("Url is opened");
		String un = fUtil.getPropertyStringValue("userName");
	    String pwd = fUtil.getPropertyStringValue("password");
		driver.get(url);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.login(un, pwd);
	}
	@AfterMethod
	public void configAM() {
	    wUtil.waitForElementVisibility(driver, homePage.getLogOutBtn());
	    wUtil.mouseOver(driver,homePage.getLogOutBtn());
	    homePage.getLogOutBtn().click();
	}
	
	@AfterClass
	public void cofigAC() {
		driver.close();
	}
}
