package com.qa.oranges.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.oranges.utilities.Constants;
import com.qa.oranges.utilities.ExcelUtil;
import com.qa.organge.Base.BaseTest;

public class PIMpageTest extends BaseTest{

	
	@BeforeClass
	public void pimPageSetup() {
		dashboardPage = loginPage.doLogin(prop.getProperty("userName").trim(), prop.getProperty("password").trim());
		pimPage = dashboardPage.goToPIMpage();
		
	}
	
	
	
	@Test(priority =1)
	public void verifyPimPageHeaderTest() {
		String header = pimPage.getPIMpageHeader();
		System.out.println("PIM page header is: "+header);
		Assert.assertEquals(header, Constants.PIM_PAGE_HEADER);
	}
	
	@DataProvider
	public Object[][] getEmpData() {
		Object [][] data = ExcelUtil.getTestData("EmployeeInfo");
		return data;
	}
	
	
	@Test(priority=2, dataProvider = "getEmpData")
	public void verifyAddEmployeeTest(String firstName,String lastName,String photograph,
			String userName, String password, String confirmPassword) {
		String eName=pimPage.addEmployee(firstName,lastName,photograph,userName,password,confirmPassword);
		System.out.println("employee Name is: "+eName);
		Assert.assertEquals(eName, firstName+" "+lastName);
	}
	
	
	
	
	
}
