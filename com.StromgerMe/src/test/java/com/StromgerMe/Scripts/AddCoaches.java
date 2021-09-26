package com.StromgerMe.Scripts;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.StrongerMe.ObjectRepositry.CoachPage;
import com.StrongerMe.generics.BaseTest;
import com.StrongerMe.generics.IAutoConstant;
public class AddCoaches extends BaseTest {
	@Test(dataProvider = "CoachData")
	public void addCoach(String testCaseName,String coachImagePath,String name,String number,String email,String description,String certification,String specilization) throws AWTException, InterruptedException {
		homePage.getCoachMenu().click();
		CoachPage coachPage = new CoachPage(driver);
		coachPage.getAddCoachButton().click();
		coachPage.getUploadImage().click();
		wUtil.waitUntilPageLoad(driver);
		wUtil.fileUpload(coachImagePath);
		coachPage.getCoachNameTxtbox().sendKeys(name);
		coachPage.getCoachPhNoTxtbox().sendKeys(number);
		coachPage.getCoachEmailTxtbox().sendKeys(email);
		coachPage.getBadgeDropDown().click();
		coachPage.getSilverBadge().click();
		coachPage.getDescpTxtbox().sendKeys(description);
		coachPage.getCertifTextbox().sendKeys(certification);
		coachPage.getSplTxtbox().sendKeys(specilization);
		coachPage.getSubmitBtn().click();
		
		
	}
	@DataProvider(name = "CoachData")
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		Object[][] data = eUtil.getExcelData(IAutoConstant.COACHDATASHEETNAME);
		return data;
	}
}
