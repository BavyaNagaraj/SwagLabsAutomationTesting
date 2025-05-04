package com.swag.qa.test;

import org.testng.Assert;
import org.testng.annotations.*;

import com.swag.qa.base.BaseClass;
import com.swag.qa.pages.CartPage;
import com.swag.qa.pages.CheckoutOverviewPage;
import com.swag.qa.pages.CheckoutPage;
import com.swag.qa.pages.LoginPage;
import com.swag.qa.pages.ProductPage;
import com.swag.qa.testdata.TestDataClass;
import com.swag.qa.utility.UtilClass;

public class CheckoutPageTest extends BaseClass{
	
	LoginPage loginPage;
	ProductPage productPage;
	CheckoutPage checkoutPage;
	CheckoutOverviewPage checkoutOverviewPage;
	CartPage cartPage;
	TestDataClass testData;
	UtilClass util;
	
	String sheetName = "userInfo";
	
	public CheckoutPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		util = new UtilClass();
		productPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		cartPage = productPage.clickOnShoppingCartLink();
		checkoutPage =  cartPage.clickOnCheckoutButton();
	}
	
	@Test(priority = 1)
	public void checkoutPageTitleTest() {
		Assert.assertTrue(checkoutPage.verifyCheckoutPageTitle());
	}
	
	@DataProvider
	public Object[][] getData() {
		Object data[][] = util.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 2, dataProvider = "getData")
	public void inputInformationFieldsTest(String ftName, String ltName, String postCode) {
		checkoutOverviewPage = checkoutPage.enterYourInformation(ftName, ltName, postCode);
	}
	
	@Test(priority = 3)
	public void cancelButtonTest() {
		cartPage =  checkoutPage.clickOnCancelButton();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
