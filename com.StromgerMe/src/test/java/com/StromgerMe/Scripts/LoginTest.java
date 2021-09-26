package com.StromgerMe.Scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.StrongerMe.ObjectRepositry.HomePage;
import com.StrongerMe.ObjectRepositry.LoginPage;
import com.StrongerMe.generics.IAutoConstant;
import com.StrongerMe.generics.BaseClass;

public class LoginTest extends BaseClass{
		
	@Test(dataProvider = "LoginData")
	public void Login(String userName,String password,String expResult) throws IOException {
		
		HomePage homePage = new HomePage(driver);
		String expectedErrorMessage=null,actualErrorMessage;
		LoginPage login =new LoginPage(driver);		
		login.login(userName,password);
		expectedErrorMessage = login.getErrorMessage().getText();
		actualErrorMessage = "Enter valid Admin ID and Password";
		if(expResult.equals("Valid")) 
		{
			 wUtil.waitUntilPageLoad(driver);
			    wUtil.mouseOver(driver, homePage.getLogOutBtn());
    		    homePage.getLogOutBtn().click();
			     Assert.assertTrue(true);
		}	     
		else if(expResult.equals("Invalid")) {
			boolean res = driver.getPageSource().contains(actualErrorMessage);
			if(res==true)
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false); 
		}	
	}
	@DataProvider(name = "LoginData")
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		Object[][] data = eUtil.getExcelData(IAutoConstant.LOGINDATASHEETNAME);
		return data;
	}
//	@DataProvider(name = "Header")
//	public Object[][] getHeaders() throws EncryptedDocumentException, IOException{
//		Object[][] data = eUtil.readheadersOfSheet(IAutoConstant.LOGINDATASHEETNAME);
//		return data;
//	}
}
