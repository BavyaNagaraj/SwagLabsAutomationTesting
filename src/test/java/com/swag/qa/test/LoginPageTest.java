package com.swag.qa.test;

import org.testng.Assert;
import org.testng.annotations.*;
import com.swag.qa.base.BaseClass;
import com.swag.qa.pages.LoginPage;
import com.swag.qa.pages.ProductPage;

public class LoginPageTest extends BaseClass{
	
	LoginPage loginPage;
	ProductPage productPage;

//	call the parent class constructor to initialize the properties file inside the constructor
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validatePageTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@Test(priority = 2)
	public void loginTest() {
		productPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
