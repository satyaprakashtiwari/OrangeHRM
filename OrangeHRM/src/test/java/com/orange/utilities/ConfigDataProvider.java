package com.orange.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() {
		
		File file= new File("./Config/config.properties");
		
		try {
			FileInputStream fis= new FileInputStream(file);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to read config file: "+e.getMessage());
		} 
	}
	
	public String getBrowser() {
		return pro.getProperty("browser");
	}
	
	public String getStagingURL() {
		return pro.getProperty("qaURL");
	}
	
	public String getDataFromConfig(String keyTosearch) {
		return pro.getProperty(keyTosearch);
	}

}
