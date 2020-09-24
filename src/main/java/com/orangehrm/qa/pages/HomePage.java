package com.orangehrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//a[contains(text(),'Welcome Demo_RBD')]")
	@CacheLookup
	WebElement usernameLabel;
	
	@FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']")
	WebElement adminLink;
	
	
	@FindBy(xpath= "//a[@id='menu_leave_viewLeaveModule']")
	WebElement leaveLink;
	
	@FindBy(xpath= "//*[@id=\"menu_leave_addLeaveEntitlement\"]")
	WebElement addLeaveEntitlement;
	
	@FindBy(xpath="//a[@id='menu_time_viewTimeModule']")
	WebElement timeLink;
	
	@FindBy(xpath="//a[@id='menu_dashboard_index']")
	WebElement dashBoardLink;

	
	//inialized Page Factory or page object
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		
		//actions
		public boolean verifyCurrentUserName() {
			
			return usernameLabel.isDisplayed();
			
			
		}
		
		public String verifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public SystemUser clickOnAdminLink() {
			adminLink.click();
			return new SystemUser();
		}
		
		public LeavePage clickOnleaveLink() {
			leaveLink.click();
			return new LeavePage();
		}
		
		public TimePage clickOnTimeLink() {
			timeLink.click();
			return new TimePage();
		}
		
		public DashBoard clickOnDashBoardLink() {
			dashBoardLink.click();
			return new DashBoard();
		}
		
		public void clickOnAddEntitlementsLink() throws InterruptedException {
			Actions action = new Actions(driver);
			
			action.moveToElement(leaveLink).build().perform();
			Thread.sleep(2000);
			action.moveToElement(driver.findElement(By.id("menu_leave_Entitlements"))).build().perform();
			Thread.sleep(2000);
			driver.findElement(By.id("menu_leave_addLeaveEntitlement")).click();
			
			
		}
		
		
}

