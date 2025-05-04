package com.swag.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swag.qa.base.BaseClass;

public class CheckoutCompletePage extends BaseClass{
	
	@FindBy(xpath = "//span[contains(text(),'Checkout: Complete!')]")
	WebElement checkoutCompletePageTitle;
	
	@FindBy(xpath = "//h2[contains(text(),'Thank you for your order!')]")
	WebElement thankyouMessage;
	
	@FindBy(xpath = "//button[contains(@id,'back-to-products')]")
	WebElement backHomeButton;
	
	public CheckoutCompletePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCheckoutCompletePageTitle() {
		return checkoutCompletePageTitle.isDisplayed();
	}
	
	public boolean verifyThankyouMessage() {
		return thankyouMessage.isDisplayed();
	}
	
	public ProductPage clickOnBackHomeButton() {
		backHomeButton.click();
		return new ProductPage();
	}

}
