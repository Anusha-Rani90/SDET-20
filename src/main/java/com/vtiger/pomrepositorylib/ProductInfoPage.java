package com.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement successMsg;

	public WebElement getSuccessMsg() {
		return successMsg;
	}
	

}
