package com.swag.qa.test;

import org.testng.Assert;
import org.testng.annotations.*;
import com.swag.qa.base.BaseClass;
import com.swag.qa.pages.CartPage;
import com.swag.qa.pages.LoginPage;
import com.swag.qa.pages.ProductPage;
import com.swag.qa.utility.UtilClass;

public class ProductPageTest extends BaseClass{
	
	LoginPage loginPage;
	ProductPage productPage;
	UtilClass util;
	CartPage cartPage;
	
	public ProductPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		productPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		util = new UtilClass();
	}
	
	@Test(priority = 1)
	public void productPageHeaderTitleTest() {
		Assert.assertTrue(productPage.verifyProductPageHeaderTitle());
	}
	
	@Test(priority = 2)
	 public void selectDropDownTest() {
		util.selectFromDropDown(productPage.sortDropDown, "Price (low to high)");
		Assert.assertTrue(productPage.selectSortingDropDown());
	}
	
	@Test(priority = 3)
	public void addToCartButtonTest() {
		Assert.assertTrue(productPage.clickOnAddToCartButton());
	}
	
	@Test(priority = 4)
	public void RemoveButtonTest() {
		productPage.clickOnAddToCartButton();
		Assert.assertTrue(productPage.clickOnRemoveButton());
	}
	
	@Test(priority = 5)
	public void ShoppingCartLinkTest() {
		cartPage = productPage.clickOnShoppingCartLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
