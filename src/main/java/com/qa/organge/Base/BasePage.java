package com.qa.organge.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.oranges.utilities.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author mahen
 *
 */
public class BasePage {

	WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	
	public static String flashElement;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	/**
	 * this method is used to initialize driver based on given browser name
	 * @param browserName
	 * @return
	 */
	public WebDriver initialize_driver(Properties prop) {
		
		flashElement = prop.getProperty("flash");
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser is: "+browserName);
		
		optionsManager = new OptionsManager(prop);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver(optionsManager.getEdgeOptions());
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
		}else if(browserName.equalsIgnoreCase("Safari")) {
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		}else {
			System.out.println("Please pass correct browser name: " + browserName);
		}
		
		//driver.manage().deleteAllCookies();
		//tlDriver.get().manage().deleteAllCookies();
		getDriver().manage().deleteAllCookies();
		//driver.manage().window().maximize();
		getDriver().manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get(prop.getProperty("url").trim());
		getDriver().get(prop.getProperty("url").trim());
		
		return getDriver();
		
	}
	
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	
	/**
	 * this method is used to read the properties from config properties file
	 * @return
	 */
	public Properties initialize_Properties() {
		
		prop = new Properties();
		String path = null;
		String env =null;
		//System.out.println("Environment is: " + env);
		try {
			
			env =System.getProperty("env");
			if(env==null) {
				path = ".\\src\\main\\java\\com\\qa\\orange\\config\\config.properties";
				System.out.println("Environment is: "+ "PROD");
			}
			else {
				switch (env) {
				case "qa":
					path = ".\\src\\main\\java\\com\\qa\\orange\\config\\config.qa.properties";
					break;
				case "dev":
					path = ".\\src\\main\\java\\com\\qa\\orange\\config\\config.dev.properties";
					break;
				default:
					System.out.println("Environment is not avaialble. Please pass correct Environment");
					break;
				}
			}
			
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	/**
	 * this method is used to take screen shot
	 * @return path of screenshot
	 */
	public String getScreenshot() {
		
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+"\\screenshots\\"+System.currentTimeMillis()+".png";
		
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
