package com.StrongerMe.ObjectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement dashBoard;
	@FindBy(xpath = "//button[text()='Logout']")
	private WebElement logOutBtn;
	@FindBy(xpath = "//span[text()='Users']")
	private WebElement userMenu;
	@FindBy(xpath = "//span[text()='Coaches']")
	private WebElement coachMenu;
	@FindBy(xpath ="//span[text()='Transformation']")
	private WebElement transformationMenu;
	@FindBy(xpath = "//span[text()='Live Session']")
	private WebElement liveSessionMenu;
	@FindBy(xpath = "//span[text()='Diet Recipes']")
	private WebElement dietRecipesMenu;
	@FindBy(xpath = "//span[text()='Rewards']")
	private WebElement rewardsMenu;
	@FindBy(xpath = "//span[text()='Plans']")
	private WebElement plansMenu;
	@FindBy(xpath = "//span[text()='Notification']")
	private WebElement notificationMenu;
	@FindBy(xpath = "//span[text()='E-Commerce']")
	private WebElement eCommerceMenu;
	@FindBy(xpath = "//span[text()='Adds']")
	private WebElement addsMenu;
	@FindBy(xpath = "//span[text()='Banners']")
	private WebElement bannersMenu;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getDashBoard() {
		return dashBoard;
	}
	public WebElement getLogOutBtn() {
		return logOutBtn;
	}
	public WebElement getUserMenu() {
		return userMenu;
	}
	public WebElement getCoachMenu() {
		return coachMenu;
	}
	public WebElement getTransformationMenu() {
		return transformationMenu;
	}

	public WebElement getLiveSessionMenu() {
		return liveSessionMenu;
	}
	public WebElement getDietRecipesMenu() {
		return dietRecipesMenu;
	}
	public WebElement getRewardsMenu() {
		return rewardsMenu;
	}
	public WebElement getPlansMenu() {
		return plansMenu;
	}
	public WebElement getNotificationMenu() {
		return notificationMenu;
	}
	public WebElement geteCommerceMenu() {
		return eCommerceMenu;
	}
	public WebElement getAddsMenu() {
		return addsMenu;
	}
	public WebElement getBannersMenu() {
		return bannersMenu;
	}

}

