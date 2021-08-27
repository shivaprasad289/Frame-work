package com.StrongerMe.generics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

/**
 * This class contains webdriver specific geenric methods.
 * @author Shivaprasad
 */
public class WebDriverUtility{
	/**
	 * This method wait for 20 seconds for page loading.
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * This method wait for the element to be visible.
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method wait for the element to be clicked.
	 * @param element
	 * @throws InterruptedException
	 */
	public void wiatAndClick(WebElement element) throws InterruptedException {
		int count = 0;
		while (count < 40) {
			try {
				element.click();
				break;
			} catch (Throwable e) {
				Thread.sleep(2000);
				count++;
			}
		}
	}
	/**
	 * This method enables user to handle dropdowm using visible text.
	 * @param element
	 * @param option
	 */
	public void selectOption(WebElement element, String option) {
		Select s = new Select(element);
		s.selectByVisibleText(option);
	}
	/**
	 * This method enables user to handle dropdown using index.
	 * @param elemnet
	 * @param index
	 */
	public void selectOption(WebElement elemnet, int index) {
		Select s = new Select(elemnet);
		s.selectByIndex(index);
	}
	/**
	 * This method will perform mouse over action. 
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * This method perform double click operation.
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * This method hepls to press enter.
	 * @throws AWTException
	 */
	public void pressEnterKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method perform right click operation.
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This method helps to switch from one window to another window and close
	 * remaining windows.
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if (title.equals(partialWindowTitle)) {

			} else
				driver.close();
		}
	}
	/**
	 * This method help to close only parent window.
	 * @param driver
	 */
	public void closeParentWindow(WebDriver driver) {
		String window = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String w:windows) {
			if(w.equals(window))
				driver.close();
		}
	}
	/**
	 * This method help to close child windows.
	 * @param driver
	 */
	public void closeChildWindows(WebDriver driver) {
		String window = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String w:windows) {
			if(!w.equals(window))
				driver.close();
		}
	}
	/**
	 * This method used to accept the alert message. 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method used to cancel/dismiss the alert messsage.
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used to scrolling action in a web page.
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0," + y + ")", element);
	}
	/**
	 * This method helps to pass driver control from one frame window to another
	 * frame window using index.
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method used to pass driver control from one frame window to frame
	 * another using name or id or class name.
	 * 
	 * @param driver
	 * @param idOrNameOrClassName
	 */
	public void switchFrame(WebDriver driver, String idOrNameOrClassName) {
		driver.switchTo().frame(idOrNameOrClassName);
	}
	/**
	 * This method helps to pass driver control from one frame window to another
	 * frame window using web element.
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method helps to switch from child frame window to parent window frame.
	 * @param driver
	 */
	public void switchParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * This method helps to switch to default frame window.
	 * @param driver
	 */
	public void switchDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 *  This method is helps to take screen shot and stores the file name as the current system time.
	 * @param driver
	 * @param screenShotPath
	 * @throws IOException 
	 */
	public String takeScreenShot(WebDriver driver, String screenShotName) throws IOException{
		String screenShotPath = "./ScreenShots/"+"-"+screenShotName+"-"+JavaUtility.getCurrentSystemDate()+"-"+System.currentTimeMillis()+".png";
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desc = new File(screenShotPath);
		FileUtils.copyFile(src, desc);
		return screenShotPath;
	}
	/**
	 * This method helps to upload image by passing image path.
	 * @param imagepath
	 * @throws AWTException
	 * @throws InterruptedException 
	 */
	public void fileUpload(String imagepath) throws AWTException, InterruptedException {
		StringSelection filePath = new StringSelection(imagepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
		Thread.sleep(1000);
		Robot r= new Robot();
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
