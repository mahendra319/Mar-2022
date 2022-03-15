package com.qa.oranges.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.oranges.utilities.Constants;
import com.qa.organge.Base.BaseTest;

public class DashboardPageTest extends BaseTest{

	
	@BeforeClass
	public void dashboardSetUp() {
			dashboardPage=loginPage.doLogin(prop.getProperty("userName").trim(), prop.getProperty("password").trim());
		//dashboardPage = new DashboardPage(driver);
	}
	
	
	@Test (priority =1)
	public void verifyDashboardPageTitleTest() {
		String title =dashboardPage.getDashboardPageTitle();
		System.out.println("Dashboard Page title is: "+title);
		Assert.assertEquals(title, Constants.DASHBOARD_PAGE_TITLE);
	}
	
	@Test (priority=2)
	public void verifyDashboardPageHeaderTest() {
		String header = dashboardPage.getHeaderText();
		System.out.println("Dashboard page header is: "+header);
		Assert.assertEquals(header, Constants.DASHBOARD_PAGE_HEADER);
		
	}
	
	@Test(priority=3)
	public void verifyAccountNameTest() {
		String accName = dashboardPage.getAccountName();
		System.out.println("Dashboard page account name is: "+accName);
		Assert.assertEquals(accName, prop.getProperty("AccountName").trim());
	}
	
	
	
	
	@Test
	public void verifyQuickLauchMenuCountTest() {
		int count = dashboardPage.getQuickLaunchMenuCount();
		System.out.println("Quicklaunch menu count is: "+count);
		Assert.assertEquals(count, 6);
	}
	
	
	
	
	
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
