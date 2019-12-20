package com.orange.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.orange.utilities.BrowserFactory;
import com.orange.utilities.ConfigDataProvider;
import com.orange.utilities.ExcelDataProvider;
import com.orange.utilities.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting up the reports and starting tests", true);
		
		excel= new ExcelDataProvider();
		config= new ConfigDataProvider();
		
		ExtentHtmlReporter extent= new ExtentHtmlReporter("./Reports/freeCRM"+Helper.getCurrentDateTime()+".html");
		report= new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Configurations are done- Test can be started", true);
	}
	
	@BeforeClass
	public void setUp() {
		
		Reporter.log("Starting browser and getting application ready", true);
		
		driver =BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		
		Reporter.log("Browser and application is up and running", true);
	}
	
	@AfterClass
	public void tearDown() {
		
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		
		Reporter.log("Test is about to end", true);
		
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.fail("Test case failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test case passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
		
		Reporter.log("Test completed >>> Reports generated", true);
	}

}
