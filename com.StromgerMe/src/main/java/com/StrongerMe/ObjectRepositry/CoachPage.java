package com.StrongerMe.ObjectRepositry;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.StrongerMe.generics.BaseClass;
import com.StrongerMe.tableInfoData.*;

public class CoachPage extends BaseClass {

	WebDriver driver;

	@FindBy(xpath = "//span[text()='Add Coaches']")
	private WebElement addCoachButton;
	
	@FindBy(xpath = "//button[@class='chooseFileButton ']")
	private WebElement uploadImage;
	
	@FindBy(xpath = "//input[@name='coachName']")
	private WebElement coachNameTxtbox;
	
	@FindBy(xpath = "//input[@name='phoneNumber']")
	private WebElement coachphNoTxtbox;
	
	@FindBy(xpath = "//input[@name='emailId']")
	private WebElement coachEmailTxtbox;
	
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
	
	@FindBy(xpath = "(//span[@class='MuiIconButton-label'])[2]")
	private WebElement nextPageBtn;
	
	@FindBy(xpath = "//button[@title='Previous page']")
	private WebElement previousPageBtn;
	
	@FindBy(xpath = "//button[@title='Previous page']")
	private WebElement nxtTabIdex;
	
	@FindBy(xpath = "//h3[@class='nameposition']")
	private List<WebElement> coachname;
	
	@FindBy(xpath = "//span[@class='MuiButton-label']")
	private WebElement WebEleaddCoachcloseBtn;
	
	@FindBy(xpath = "//input[@class='searchinput']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//span[text()='Yes']")
	private WebElement deleteConfirmBtn;

	public CoachPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

	@FindBy(xpath = "//tbody[@class='MuiTableBody-root']/tr")
	private List<WebElement> rowData;
	@FindBy(xpath = "//tbody[@class='MuiTableBody-root']/tr[*]/td[2]/h3")
	private List<WebElement> coachName;
	@FindBy(xpath = "//tbody[@class='MuiTableBody-root']/tr[*]/td[3]")
	private List<WebElement> coachPhoneNumber;
	@FindBy(xpath = "//tbody[@class='MuiTableBody-root']/tr[*]/td[4]")
	private List<WebElement> coachEmail;
	@FindBy(xpath = "//tbody[@class='MuiTableBody-root']/tr[*]/td[5]")
	private List<WebElement> coachBadge;
	@FindBy(xpath = "//tbody[@class='MuiTableBody-root']/tr[*]/td[6]")
	private List<WebElement> coachCertification;
	@FindBy(xpath = "//tbody[@class='MuiTableBody-root']/tr[*]/td[7]")
	private List<WebElement> coachSpecialization;

	List<CoachInfoTableRecord> latestCoachDetails = new ArrayList<>(); 
	List<CoachInfoTableRecord> coachNames = new ArrayList<>(); 
	
	public List<CoachInfoTableRecord> getAllCoachNames(){
		return coachNames;
	}
	public boolean clickOnPreviousPage() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		boolean flag = true;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(previousPageBtn));
			previousPageBtn.click();
		} catch (Exception e) {
			flag = false;
			return flag;
		}
		return flag;	
	}
	
	public boolean clickOnNextPage() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		boolean flag = true;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(nextPageBtn)); 
			nextPageBtn.click();
		} catch (Exception e) {
			flag = false;
			return flag;
		}
		return flag;
		
	}
	
	public List<CoachInfoTableRecord> getCoachTableData() {
		boolean flag = true;
		while (flag) {
			for (int i = 0; i < rowData.size(); i++) {
				latestCoachDetails.add(new CoachInfoTableRecord(coachName.get(i).getText(),
						Long.parseLong(coachPhoneNumber.get(i).getText()), coachEmail.get(i).getText(),
						coachBadge.get(i).getText(), coachCertification.get(i).getText(),
						coachSpecialization.get(i).getText()));
				coachNames.add(new CoachInfoTableRecord(coachName.get(i).getText()));
			}
			flag = clickOnNextPage();
		}
		System.out.println(latestCoachDetails.size());
		return latestCoachDetails;
	}
	
	public void deleteCoach(String name) throws InterruptedException { 
		boolean isPreviousBtnClickable = true,f = true; 
		WebElement givenCoachName;
		while(isPreviousBtnClickable) {
			Thread.sleep(2000);
			isPreviousBtnClickable = clickOnPreviousPage();
			System.out.println("Previous btn");
		}
		while(f) {
			try {
			        givenCoachName = driver.findElement(By.xpath("//h3[text()='"+name+"']"));
			        logger.info("Coach details available to delete");
			        System.out.println("IS previous btn:-"+isPreviousBtnClickable);
			        driver.findElement(By.xpath("//h3[text()='"+name+"']/../../td[contains(@class,'jss3')]/button[@aria-label='delete']")).click();
			        deleteConfirmBtn.click();
			} catch (Exception e) {
				f = clickOnNextPage();
			}
		}
	}
//	
//	public List<CoachInfoTableRecord> getAllCoachNames() {
//		WebDriverWait w = new WebDriverWait(driver, 20);
//		boolean flag = true;
//		while(flag) {
//			for(int i = 0;i< rowData.size();i++) {
//			}
//			try {
//				w.until(ExpectedConditions.elementToBeClickable(nextPageBtn));
//				nextPageBtn.click();
//			}catch (Exception e) {
//				flag = false;
//				break;
//			}
//		}
//		return coachNames;
//	}

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
		return coachEmailTxtbox;
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

	public WebElement getNextPageBtn() {
		return nextPageBtn;
	}

	public WebElement getNxtTabIdex() {
		return nxtTabIdex;
	}

	boolean tabIndex;
	public boolean isNxtBtnClickable() {
		int value = Integer.parseInt(nxtTabIdex.getAttribute("tabindex"));
		System.out.println(value);
		if (value == -1) {
			tabIndex = false;
		} else if (value == 0) {
			tabIndex = true;
		}
		return tabIndex;
	}
	public void coachAdd(String testCaseName, String coachImagePath, String name, String number, String email,
			String badge, String description, String certification, String specilization)
			throws AWTException, InterruptedException {
		addCoachButton.click();
		uploadImage.click();
		wUtil.fileUpload(coachImagePath);
		coachNameTxtbox.sendKeys(name);
		coachphNoTxtbox.sendKeys(number);
		coachEmailTxtbox.sendKeys(email);
		badgeDropDown.click();
		selectBadge(badge);
		descpTxtbox.sendKeys(description);
		certifTextbox.sendKeys(certification);
		splTxtbox.sendKeys(specilization);
		submitBtn.click();
		wUtil.waitUntilPageLoad(driver);
	}

	public void selectBadge(String badgeName) {
		switch (badgeName) {
		case "Silver":
			silverBadge.click();
			break;
		case "Gold":
			goldBadge.click();
			break;
		case "Dimond":
			dimondBadge.click();
			break;
		case "Premium":
			premiumBadge.click();
			break;
		}
	}

	public void searchCoach(String coachName) {
		searchBox.click();
		searchBox.sendKeys(coachName);
		List<CoachInfoTableRecord> coachData = getCoachTableData();
		int count = coachData.size();
		logger.info(count+" are mached");
	}
	
	public boolean searchCoachByMail(String email) {
		boolean flag = false;
		wUtil.waitUntilPageLoad(driver);
		List<CoachInfoTableRecord> coachData = getCoachTableData();
		for (CoachInfoTableRecord cd : coachData) {
			if (cd.getCoachEmail().equals(email) == true) {
				flag = true;
				Assert.assertEquals(cd.getCoachEmail(), email, "Coach present"); 
				break;
			}
		}
		return flag;
	}	
	
//	public void deleteCoach(String coachName) {
//		@FindBy(xpath = "//h3[text()='"+coachName+"']")
//		private WebElement coach;
//	}

}
