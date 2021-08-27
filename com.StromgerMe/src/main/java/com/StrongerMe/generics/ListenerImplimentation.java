package com.StrongerMe.generics;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentation extends BaseClass implements ITestListener {
	ExtentReports reports;
	ExtentTest test;
	String screenShot;
	/**
	 * This method will set the report path, document title, report name, theme and reporter name.
	 */
	 @Override	
     public void onStart(ITestContext context) {
		 //Before Suite
		  ExtentSparkReporter htmlReporter = new ExtentSparkReporter(IAutoConstant.HTMLPATH);
		  htmlReporter.config().setDocumentTitle(IAutoConstant.EXTENTREPORTTITLE);
		  htmlReporter.config().setReportName(IAutoConstant.EXTENTREPORTNAME);
		  htmlReporter.config().setTheme(Theme.DARK);
		  reports = new ExtentReports();
		  reports.attachReporter(htmlReporter);
		  reports.setSystemInfo("OS",IAutoConstant.OPERATINGSYSTEM);
		  reports.setSystemInfo("Reporter name",IAutoConstant.REPORTERNAME);  
	  }
	@Override
	public void onTestStart(ITestResult result) {
		//Test method
		test = reports.createTest(result.getMethod().getMethodName());
	}
	@Override
	 public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName()+" is passed");
	}
	@Override
	 public void onTestFailure(ITestResult result) {
		try {
			 screenShot = wUtil.takeScreenShot(staticDriver, result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL,result.getMethod().getMethodName()+" is Failed");
		test.log(Status.FAIL,result.getThrowable());
		test.addScreenCaptureFromPath(screenShot);
	}
	@Override
	 public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,result.getMethod().getMethodName()+" is skipped");
	}
	
	  @Override
	     public void onFinish(ITestContext context) {
		  //After suite
	    	 reports.flush();
	     }
	@Override
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 
	 } 
}
