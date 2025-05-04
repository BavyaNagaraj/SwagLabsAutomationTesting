package com.swag.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swag.qa.base.BaseClass;

public class CheckoutPage extends BaseClass{
	
	@FindBy(xpath = "//span[contains(text(),'Checkout: Your Information')]")
	WebElement checkoutPageTitle;
	
	@FindBy(xpath = "//input[contains(@name,'firstName')]")
	WebElement firstName;
	
	@FindBy(name = "lastName")
	WebElement lastName;
	
	@FindBy(name = "postalCode")
	WebElement postalCode;
	
	@FindBy(id = "continue")
	WebElement continueButton;
	
	@FindBy(id = "cancel")
	WebElement cancelButton;
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCheckoutPageTitle() {
		return checkoutPageTitle.isDisplayed();
	}
	
	public CheckoutOverviewPage enterYourInformation(String fName, String lName, String code) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		postalCode.sendKeys(code);
		continueButton.click();
		
		return new CheckoutOverviewPage();
	}
	
	public CartPage clickOnCancelButton() {
		return new CartPage();
	}

}
