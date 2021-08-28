package com.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="productname")
	private WebElement prod_Name;
	
	@FindBy(name="button")
	private WebElement saveButton;

	public WebElement getProd_Name() {
		return prod_Name;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createProdName(String productName) {
		prod_Name.sendKeys(productName);
		saveButton.click();
	}
}
