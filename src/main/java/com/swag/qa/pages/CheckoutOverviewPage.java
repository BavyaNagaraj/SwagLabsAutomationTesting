package com.swag.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swag.qa.base.BaseClass;

public class CheckoutOverviewPage extends BaseClass {
	
	@FindBy(xpath = "//span[contains(text(),'Checkout: Overview')]")
	WebElement checkoutOverviewPageTitle;
	
	@FindBy(name = "cancel")
	WebElement cancelButton;
	
	@FindBy(name = "finish")
	WebElement finishButton;
	
	public CheckoutOverviewPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCheckoutOverviewTitle() {
		return checkoutOverviewPageTitle.isDisplayed();
	}
	
	public CheckoutPage clickOnCancelButton() {
		cancelButton.click();
		return new CheckoutPage();
	}
	
	public CheckoutCompletePage clickOnFinishButton() {
		finishButton.click();
		return new CheckoutCompletePage();
	}

}
