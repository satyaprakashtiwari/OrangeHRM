package com.orange.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	
	
	public static WebDriver startApplication(WebDriver driver, String browser, String appURL) {
		
		if(browser.equalsIgnoreCase("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("IE")) {
			
			System.setProperty("webdriver.ie.driver", ".\\Drivers\\MicrosoftWebDriver.exe");
			driver=new InternetExplorerDriver();
			
		}
        else if(browser.equalsIgnoreCase("Edge")) {
			
			System.setProperty("webdriver.edge.driver", ".\\Drivers\\MicrosoftWebDriver.exe");
			driver=new EdgeDriver();
			
		}
        else if(browser.equalsIgnoreCase("Firefox")) {
			
        	System.setProperty("webdriver.gecko.driver", ".\\Drivers\\chromedriver.exe");
			driver=new FirefoxDriver();
		}
        else
        	System.out.println("We don't support this browser");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(appURL);
		
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver) {
		
		driver.quit();
	}

}
