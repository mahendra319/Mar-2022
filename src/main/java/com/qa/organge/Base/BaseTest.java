package com.qa.organge.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.oranges.pages.DashboardPage;
import com.qa.oranges.pages.LoginPage;
import com.qa.oranges.pages.PimPage;

public class BaseTest {

	
	BasePage basePage;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public PimPage pimPage;
	
	@Parameters({"browserName"})
	@BeforeTest
	public void setUp(String bName) {
		basePage = new BasePage();
		prop = basePage.initialize_Properties();
		prop.setProperty("browser", bName);
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
	}
	
	
	
/*
 * If we want to execute individual test class un comment below code and comment above code	
 */
//	@BeforeTest
//	public void setUp() {
//		basePage = new BasePage();
//		prop = basePage.initialize_Properties();
//		driver = basePage.initialize_driver(prop);
//		loginPage = new LoginPage(driver);
//	}
//	
	
	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
}
