package com.swag.qa.test;

import org.testng.Assert;
import org.testng.annotations.*;

import com.swag.qa.base.BaseClass;
import com.swag.qa.pages.CartPage;
import com.swag.qa.pages.CheckoutCompletePage;
import com.swag.qa.pages.CheckoutOverviewPage;
import com.swag.qa.pages.CheckoutPage;
import com.swag.qa.pages.LoginPage;
import com.swag.qa.pages.ProductPage;
import com.swag.qa.testdata.TestDataClass;

public class CheckoutOverviewPageTest extends BaseClass {
	
	LoginPage loginPage;
	ProductPage productPage;
	CheckoutPage checkoutPage;
	CheckoutOverviewPage checkoutOverviewPage;
	CartPage cartPage;
	CheckoutCompletePage checkoutCompletePage;
	TestDataClass testData;
	
	public CheckoutOverviewPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testData = new TestDataClass();
		productPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		cartPage = productPage.clickOnShoppingCartLink();
		checkoutPage =  cartPage.clickOnCheckoutButton();
		checkoutOverviewPage = checkoutPage.enterYourInformation(testData.firstName, testData.lastName, testData.postalCode);
	}
	
	@Test(priority = 1)
	public void checkoutOverviewTitleTest() {
		Assert.assertTrue(checkoutOverviewPage.verifyCheckoutOverviewTitle());
	}
	
	@Test(priority = 2)
	public void cancelButtonTest() {
		checkoutPage = checkoutOverviewPage.clickOnCancelButton();
	}
	
	@Test(priority = 3)
	public void finishButtonTest() {
		checkoutCompletePage = checkoutOverviewPage.clickOnFinishButton();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
