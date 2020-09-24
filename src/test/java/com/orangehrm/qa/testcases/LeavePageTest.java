package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LeavePage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.utill.TestUtill;

public class LeavePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	LeavePage leavePage;
	
	String sheetName = "leave";
	
	
	
	
	
	public LeavePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		
		 loginpage = new LoginPage();
		 leavePage = new LeavePage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		leavePage = homepage.clickOnleaveLink();
		
		}
	
	
	@Test(priority=1)
	public void verifyleaveListLabelTest() {
		Assert.assertTrue(leavePage.verifyleavelistLabel(),"label text missing on page");
	}
	
	@Test(priority=2)
	public void verifyCheckBox() {
		leavePage.verifyCheckBox();
	}
	
	@DataProvider
	public Object[][] getOrangeHRMTestData() {
		Object data[][] = TestUtill.getTestData(sheetName);
		return data;
		
		
		
	}
	
	
	
	
	
	@Test(priority=3,dataProvider = "getOrangeHRMTestData")
	public void validateAddEntitleMent(String location1,String subunit,String leaveType,CharSequence[] entitlement1) throws InterruptedException {
		homepage.clickOnAddEntitlementsLink();
		//leavePage.AddleaveEntitlement("Vacation US" ,"10");
	  leavePage.AddleaveEntitlement(location1, subunit, leaveType, entitlement1);
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}
