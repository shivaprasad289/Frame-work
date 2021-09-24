package com.StromgerMe.Scripts;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.StrongerMe.ObjectRepositry.CoachPage;
import com.StrongerMe.generics.BaseClass;
import com.StrongerMe.generics.IAutoConstant;
import com.StrongerMe.tableInfoData.CoachInfoTableRecord;

public class Coach extends BaseClass {
	@Test(dataProvider = "CoachData", priority = 1)
	public void addCoach(String testCaseName, String coachImagePath, String name, String number, String email,String badge,
			String description, String certification, String specilization) throws AWTException, InterruptedException {
		try {
			loginPage.login(fUtil.getPropertyStringValue("userName"), fUtil.getPropertyStringValue("password"));
			logger.info("Login to the application");
		} catch (IOException e) {
			e.printStackTrace();
			logger.warn("Login failed");
		}
		homePage.getCoachMenu().click();
		coachPage = new CoachPage(driver);
		coachPage.coachAdd(testCaseName, coachImagePath, name, number, email,badge, description, certification,
				specilization);
		String errorMsg = "Email id already exists";
		Thread.sleep(2000);
		boolean res = driver.getPageSource().contains(errorMsg);
		System.out.println("res :-" + res);
		wUtil.waitUntilPageLoad(staticDriver);
		boolean flag;
		if (res) {
			logger.info("Coach details not added, dublicate email id");   
			flag = coachPage.searchCoachByMail(email);
			
		} else {
			logger.info("Coach added");
			flag = coachPage.searchCoachByMail(email);
		}		
		if (flag)
			logger.info("coach present");
		else
			logger.warn("Coach not present");
		coachPage.deleteCoach(name);
	}

	
	@DataProvider(name = "CoachData")
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		Object[][] data = eUtil.getExcelData(IAutoConstant.COACHDATASHEETNAME);
		return data;
	}
	
	
//	@Test(priority = 2)
//	public void coachCount() throws IOException {
//		CoachPage coachPage = new CoachPage(driver);
//		homePage.getCoachMenu().click();
//		System.out.println(coachPage.isNxtBtnClickable());
//		List<CoachInfoTableRecord> coachData = coachPage.getCoachTableData();
//		for(CoachInfoTableRecord cd :coachData) {
//			System.out.println(cd);
//		}
}
