package com.swag.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swag.qa.base.BaseClass;

public class ProductPage extends BaseClass{
	
	@FindBy(xpath = "//span[contains(text(),'Products')]")
	WebElement headerTitle;
	
	@FindBy(xpath = "//select[contains(@class,'product_sort_container')]")
	public WebElement sortDropDown;
	
	@FindBy(xpath = "//span[contains(@class,'active_option')]")
	WebElement textAfterSelectingDropDown;
	
	@FindBy(xpath = "//button[contains(@name,'add-to-cart-sauce-labs-bike-light')]")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//button[contains(@name,'remove-sauce-labs-bike-light')]")
	WebElement removeButton;
	
	@FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
	WebElement shoppingCartLink;
	
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyProductPageHeaderTitle() {
		return headerTitle.isDisplayed();
	}
	
	public boolean selectSortingDropDown() {
		 return textAfterSelectingDropDown.isDisplayed();
	}
	
	public boolean clickOnAddToCartButton() {
		addToCartButton.click();
		return removeButton.isDisplayed();
	}
	
	public boolean clickOnRemoveButton() {
		removeButton.click();
		return addToCartButton.isDisplayed();
	}
	
	public CartPage clickOnShoppingCartLink() {
		shoppingCartLink.click();
		return new CartPage();
	}

}
