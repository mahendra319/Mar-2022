package com.qa.orange.utilities;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	Properties prop;
	ChromeOptions co;
	FirefoxOptions fo;
	EdgeOptions eo;
	
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	
	/**
	 * this method is used to get chromeoptions from config file
	 * @return chrome options
	 */
	public ChromeOptions getChromeOptions() {
		
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))){
			co.addArguments("--headless");
		}
		
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			co.addArguments("incognito");
		}
		return co;
	}
	
	/**
	 * This method is used to get firefox options 
	 * @return firefox options
	 */
	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			fo.addArguments("headless");
		}
		
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			fo.addArguments("incognito");
		}
		return fo;
	}
	
	
	public EdgeOptions getEdgeOptions() {
		
		eo = new EdgeOptions();
			
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			
		}
		return eo;
		
		}
	
	
	
	
	
	
	
	
	
	
	
	

}
