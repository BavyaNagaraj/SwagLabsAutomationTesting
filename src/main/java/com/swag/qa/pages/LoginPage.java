package com.swag.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swag.qa.base.BaseClass;

public class LoginPage extends BaseClass{
	
//	OR
	@FindBy(name = "user-name")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "login-button")
	WebElement loginButton;
	
//	Initializing the page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
//	functions
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public ProductPage login(String uName, String pwd) {
		username.sendKeys(uName);
		password.sendKeys(pwd);
		loginButton.click();
		
		return new ProductPage();
	}

}
