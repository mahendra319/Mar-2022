package com.qa.oranges.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.orange.utilities.Constants;
import com.qa.organge.Base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("Epic:22 - Login Module")
@Story("US:22 - Login Feature Testing")
public class LoginPageTest extends BaseTest{

	
	@Description("Verify login page title")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority =1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Browser title is: "+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("Verify forgot password link")
	@Severity(SeverityLevel.CRITICAL)
	@Test (priority =2)
	public void verifyForgotPasswordLinkTest() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}
	
	@Description("Login Test")
	@Severity(SeverityLevel.BLOCKER)
	@Test (priority=3)
	public void verifyLoginTest() {
		loginPage.doLogin(prop.getProperty("userName").trim(),prop.getProperty("password").trim());
	}
	
	
	
}
