package com.qa.orange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orange.Base.BasePage;
import com.qa.orange.utilities.Constants;
import com.qa.orange.utilities.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage{

	private WebDriver driver;
	ElementUtil elementUtil;
	
	//By locators
	private By userName = By.id("txtUsername");
	private By password = By.id("txtPassword");
	private By loginBtn = By.id("btnLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");
	
	
	//Page constructor
	
	public LoginPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}
	
	
	//Page Actions
	@Step("getting page title")
	public String getLoginPageTitle() {
		//return driver.getTitle();
		return elementUtil.waitForTitle(Constants.LOGIN_PAGE_TITLE, 10);
	}
	
	public boolean isForgotPasswordLinkExist() {
		//return driver.findElement(forgotPwdLink).isDisplayed();
		return elementUtil.doIsDisplayed(forgotPwdLink);
		
	}
	
	public DashboardPage doLogin(String uName, String pwd) {
//		driver.findElement(userName).sendKeys(uName);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBtn).click();
		
		elementUtil.doSendKeys(userName, uName);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		
		return new DashboardPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
