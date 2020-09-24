package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LeavePage;
import com.orangehrm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	LeavePage leavePage;
	
	
	
	
	
	
	public HomePageTest() {
		super();
	}
	
	//Test cases should be seprated and independent to each other
	//before each test cases -- launch the browser and login
	//@test --- execute test cases
	//after each test cases --- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		
		 loginpage = new LoginPage();
		 leavePage = new LeavePage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "OrangeHRM","Home Page Title is not matched");
		
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homepage.verifyCurrentUserName());
	}
	
	
	@Test(priority=3)
	public void verifyLeaveLinkTest() {
		leavePage = homepage.clickOnleaveLink();
		
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
