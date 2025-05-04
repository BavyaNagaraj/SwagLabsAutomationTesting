package com.swag.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swag.qa.base.BaseClass;

public class CartPage extends BaseClass{
	
	@FindBy(xpath = "//span[contains(text(),'Your Cart')]")
	WebElement cartPageTitle;
	
	@FindBy(name = "continue-shopping")
	WebElement continueShoppingButton;
	
	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	WebElement checkoutButton;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCartPageTitle() {
		return cartPageTitle.isDisplayed();
	}
	
	public ProductPage clickOnContinueShoppingButton() {
		continueShoppingButton.click();
		return new ProductPage();
	}
	
	public CheckoutPage clickOnCheckoutButton() {
		checkoutButton.click();
		return new CheckoutPage();
	}

}
