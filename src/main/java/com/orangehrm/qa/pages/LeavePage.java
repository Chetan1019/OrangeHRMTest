package com.orangehrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.qa.base.TestBase;

public class LeavePage extends TestBase{
	
	
	@FindBy(xpath="//*[@id=\"leave-list-search\"]/a")
	WebElement leaveListLabel;
	
	@FindBy(xpath="//input[@id='entitlements_employee_empName']")
	WebElement employee;
	
	@FindBy(xpath="//*[@id=\"leaveList_cmbWithTerminated\"]")
	WebElement checkBox;
	
	@FindBy(xpath="//*[@id=\"entitlements_entitlement\"]")
	WebElement entitlement;
	
	@FindBy(xpath="//*[@id=\"entitlements_filters_location\"]/option[2]")
	WebElement location;
	
	
	@FindBy(xpath= "//*[@id=\"entitlements_filters_bulk_assign\"]")
	WebElement checkbox1;
	
	@FindBy(xpath="//input[@id='btnSave' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//*[@id=\"period\"]/option[5]")
	WebElement leaveperiod;
	
	@FindBy(xpath="//*[@id=\"entitlements_filters_subunit\"]/option[3]")
	WebElement subUnit;
	
	//inialized Page Factory or page object
		public LeavePage() {
			PageFactory.initElements(driver, this);
		}

	//Actions
	public boolean verifyleavelistLabel() {
		return leaveListLabel.isDisplayed();
	}
	
	
	public void verifyCheckBox() {
		checkBox.click();
	
	}
	
	public void AddleaveEntitlement( String location1, String subunit, String leaveType, CharSequence[] entitlement1) {
		
		checkbox1.click();
		//employee.sendKeys(empname);
		
		location.click();
//		Select select3 = new Select(driver.findElement(By.id("entitlements_filters_location")));
//		select3.selectByVisibleText(entitlements_filters_location);
		
		Select select = new Select(driver.findElement(By.id("entitlements_leave_type")));
		select.selectByVisibleText(leaveType);
		
		 
//		Select select1 = new Select(driver.findElement(By.className("valid")));
//		select1.selectByVisibleText(valid);
		leaveperiod.click();
		
		subUnit.click();
		
		entitlement.sendKeys(entitlement1);
		saveBtn.click();

	}
	

}
