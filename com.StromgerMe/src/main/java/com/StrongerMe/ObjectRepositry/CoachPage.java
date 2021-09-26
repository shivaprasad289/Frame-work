package com.StrongerMe.ObjectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoachPage {
	@FindBy(xpath = "//span[text()='Add Coaches']")
	private WebElement addCoachButton;
	@FindBy(xpath = "//button[@class='chooseFileButton ']")
	private WebElement uploadImage;
	@FindBy(xpath = "//input[@name='coachName']")
	private WebElement coachNameTxtbox;
	@FindBy(xpath = "//input[@name='phoneNumber']")
	private WebElement coachphNoTxtbox;
	@FindBy(xpath = "//input[@name='emailId']")
	private WebElement CoachEmailTxtbox;
	@FindBy(id = "mui-component-select-badge")
	private WebElement badgeDropDown;
	@FindBy(xpath = "//textarea[@name='coachDetails']")
	private WebElement descpTxtbox;
	@FindBy(xpath = "//input[@name='certifications']")
	private WebElement certifTextbox;
	@FindBy(xpath = "//input[@name='specialization']")
	private WebElement splTxtbox;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	@FindBy(xpath = "//li[@data-value='Silver']")
	private WebElement silverBadge;
	@FindBy(xpath = "//li[@data-value='Gold']")
	private WebElement goldBadge;
	@FindBy(xpath = "//li[@data-value='Premium']")
	private WebElement premiumBadge;
	@FindBy(xpath = "//li[@data-value='Diamond']")
	private WebElement dimondBadge;
	public CoachPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAddCoachButton() {
		return addCoachButton;
	}
	public WebElement getUploadImage() {
		return uploadImage;
	}
	public WebElement getCoachNameTxtbox() {
		return coachNameTxtbox;
	}
	public WebElement getCoachPhNoTxtbox() {
		return coachphNoTxtbox;
	}
	public WebElement getCoachEmailTxtbox() {
		return CoachEmailTxtbox;
	}
	public WebElement getBadgeDropDown() {
		return badgeDropDown;
	}
	public WebElement getDescpTxtbox() {
		return descpTxtbox;
	}
	public WebElement getCertifTextbox() {
		return certifTextbox;
	}
	public WebElement getSplTxtbox() {
		return splTxtbox;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public WebElement getSilverBadge() {
		return silverBadge;
	}
	public WebElement getGoldBadge() {
		return goldBadge;
	}
	public WebElement getPremiumBadge() {
		return premiumBadge;
	}
	public WebElement getDimondBadge() {
		return dimondBadge;
	}	
}
