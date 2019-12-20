package com.orange.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="txtUsername") WebElement usernameText;
	@FindBy(id="txtPassword") WebElement passwordText;
	@FindBy(xpath="//input[@id='btnLogin']") WebElement loginButton;
	
	public void loginToOrangeHRM(String username, String password) {
		
		usernameText.sendKeys(username);
		passwordText.sendKeys(password);
		loginButton.click();
	}

}
