package com.swag.qa.test;

import org.testng.Assert;
import org.testng.annotations.*;

import com.swag.qa.base.BaseClass;
import com.swag.qa.pages.CartPage;
import com.swag.qa.pages.CheckoutPage;
import com.swag.qa.pages.LoginPage;
import com.swag.qa.pages.ProductPage;
import com.swag.qa.utility.UtilClass;

public class CartPageTest extends BaseClass{
	
	LoginPage loginPage;
	CartPage cartPage;
	ProductPage productPage;
	CheckoutPage checkoutPage;
	UtilClass util;
	
	public CartPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		productPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		cartPage = productPage.clickOnShoppingCartLink();
	}
	
	@Test(priority = 1)
	public void cartPageTitleTest() {
		Assert.assertTrue(cartPage.verifyCartPageTitle());
	}
	
	@Test(priority = 2)
	public void continueShoppingButtonTest() {
		productPage = cartPage.clickOnContinueShoppingButton();
	}
	
	@Test(priority = 3)
	public void checkoutButtonTest() {
		checkoutPage = cartPage.clickOnCheckoutButton();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
