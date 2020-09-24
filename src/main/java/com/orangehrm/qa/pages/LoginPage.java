package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page factory -- object repo:
	@FindBy(name="txtUsername")
	WebElement username;
	
	
	@FindBy(name = "txtPassword")
	WebElement password;
	
	@FindBy(xpath= "//input[contains(@id,'btnLogin')]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[text()='Forgot your password?']")
	WebElement forgotlink;
	
	@FindBy(xpath = " //*[@id=\"divLogo\"]/img")
	WebElement orangehrmLogo;
	
	//initialize Page-Object or object repo of login page then we create a constructor of loginPage
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateOrangeHrmImage() {
		return orangehrmLogo.isDisplayed();
	}
	
	
	public HomePage login(String un,String pwd) { 
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}

}
