package com.StrongerMe.generics;



public interface IAutoConstant {
	String EXTENTREPORTTITLE = "StrongerMe Application";
	String EXTENTREPORTNAME = "Regreation testing";
	String OPERATINGSYSTEM = "Windowd 10";
	String REPORTERNAME = "Shivaprasad";
	
	
	String CHROMEKEY = "webdriver.chrome.driver";
	String CHROMEPATH = "./src/main/resources/driver/chromedriver.exe";
	String EXCELPATH = "./src/test/resources/StrongerMe_required_data.xlsx";
	String HTMLPATH = "./ExtentReports/"+JavaUtility.getCurrentSystemDate()+".html";
	String COMMONDATAPROPERTYPATH = "./src/main/resources/commonData.properties";
	String PAGETITLEFILEPATH = "./src/test/resources/pageTitles.properties";
	String LOGINDATASHEETNAME = "Login_data";
	String COACHDATASHEETNAME = "Add_coach_details";
	String EXCELOGINRESULTSHEETNAME  = "Login_testCase_result";
	String RESULTEXCELPATH = "./src/test/resources/Result.xlsx";
	String LOGINRESULTSHEETNAME = "Login_Result";
	String LOGINSHEETNAME = "Login_data";
	
	

}
