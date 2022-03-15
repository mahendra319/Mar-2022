package com.qa.orange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orange.Base.BasePage;
import com.qa.orange.utilities.ElementUtil;

public class PimPage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	//By locators
	
	private By header = By.tagName("h1");
	private By addEmployee = By.linkText("Add Employee");
	private By firstName = By.id("firstName");
	private By lastName = By.id("lastName");
	//private By empID = By.id("employeeId");
	private By photograph = By.id("photofile");
	private By chkBox = By.id("chkLogin");
	private By userName = By.id("user_name");
	private By password = By.id("user_password");
	private By rePassword = By.id("re_password");
	private By saveBtn = By.id("btnSave");
	By employeeName = By.xpath("//div[@id='profile-pic']/h1");
	
	
	//Page Constructor
	public PimPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}
	
	//Page Actions
	
	public String getPIMpageHeader() {
		return elementUtil.doGetText(header);
	}
	
	public String addEmployee(String firstName,String lastName,String photograph,
			String userName,String password, String rePassword) {
		
		elementUtil.clickWhenReady(addEmployee, 10);
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.doSendKeys(this.photograph, photograph);
		elementUtil.doClick(chkBox);
		elementUtil.doSendKeys(this.userName, userName);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.rePassword, rePassword);
		elementUtil.doClick(saveBtn);
		
		elementUtil.waitForElementPresent(employeeName, 10);
		return elementUtil.doGetText(employeeName);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			
}
