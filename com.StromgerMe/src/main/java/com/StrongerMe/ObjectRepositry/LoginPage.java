package com.StrongerMe.ObjectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath = "//input[@name='user_id']")
	private WebElement userNameTF;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordTF;
	
	@FindBy(xpath = "//button[@value='login']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "(//span[contains(@class,'MuiIconButton')])[2]")
	private WebElement seeIcon;
	
	@FindBy(xpath = "//div[text()='Enter valid Admin ID and Password']")
	private WebElement errorMessage;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	/**
	 * This method helps to login to StrongerMe application and return HomePage object reference.
	 * @param userName
	 * @param password
	 * @return
	 */
	public void login(String userName,String password) {
		System.out.println(userName);
		System.out.println(password);
		userNameTF.sendKeys(userName);
		passwordTF.sendKeys(password);
		loginBtn.click();
	}
	public WebElement getErrorMessage() {
		return errorMessage;
	}
	public WebElement getUserNameTF() {
		return userNameTF;
	}
	public WebElement getPasswordTF() {
		return passwordTF;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public WebElement getSeeIcon() {
		return seeIcon;
	}
	
}
