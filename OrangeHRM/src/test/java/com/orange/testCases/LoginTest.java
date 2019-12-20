package com.orange.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orange.pages.BaseClass;
import com.orange.pages.LoginPage;


public class LoginTest extends BaseClass {

	
	@Test
	public void loginToApp1() {
		logger= report.createTest("login to app1");
		System.out.println("Title: "+ driver.getTitle());
		
		logger.info("Starting the application");
		
		LoginPage loginPage= new LoginPage(driver);
		loginPage.loginToOrangeHRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login is successfull");

	}
	
	@Test
	public void loginToApp2() {
		logger= report.createTest("login to app2");
		System.out.println("Title: "+ driver.getTitle());
		
		logger.info("Starting the application");
		
		LoginPage loginPage= new LoginPage(driver);
		loginPage.loginToOrangeHRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login is successfull");

	}
	
	//code is pushed to GIT HUB
	
	
}
