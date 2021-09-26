package com.StrongerMe.generics;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

public class DataDriven extends BaseClass {
	@DataProvider(name = "LoginData")
	public String[][] getData(){
		//Get the data from excel.
		String[][] loginData = null;
		try {
			int totalRows = eUtil.getRowCount(IAutoConstant.LOGINSHEETNAME);
			eUtil.getCellCount(IAutoConstant.LOGINSHEETNAME,totalRows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginData;
		
    }
}
 