package com.qa.orange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orange.utilities.Constants;
import com.qa.orange.utilities.ElementUtil;
import com.qa.organge.Base.BasePage;

public class DashboardPage extends BasePage{

	private WebDriver driver;
	ElementUtil elementUtil;
	
	//By locators
	private By header = By.tagName("h1");
	private By accntName = By.id("welcome");
	private By quickLaunchMenu = By.xpath("//div[@id='dashboard-quick-launch-panel-container']//span");
	private By pimModule = By.id("menu_pim_viewPimModule");
	
	
	
	//Page Constructor
	
	public DashboardPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}
	
	
	//Page Actions
	
	public String getDashboardPageTitle() {
		//return driver.getTitle();
		return elementUtil.waitForTitle(Constants.DASHBOARD_PAGE_TITLE, 10);
	}
	
	public String getHeaderText() {
//		if(driver.findElement(header).isDisplayed()) {
//			return driver.findElement(header).getText();
//		}
//		return null;
		
		
		if(elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}
	
	public String getAccountName() {
		//return driver.findElement(accntName).getText();
		
		return elementUtil.doGetText(accntName);
	}
	
	public int getQuickLaunchMenuCount() {
//		List<WebElement> elements = driver.findElements(quickLaunchMenu);
//		return elements.size();
		
		return elementUtil.visibilityOfAllElements(quickLaunchMenu, 10).size();
		
	}
	
	public PimPage goToPIMpage() {
		elementUtil.clickWhenReady(pimModule, 10);
		
		return new PimPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
