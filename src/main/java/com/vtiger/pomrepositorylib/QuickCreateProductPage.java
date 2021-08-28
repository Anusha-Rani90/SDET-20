package com.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericutility.WebDriverUtility;

public class QuickCreateProductPage extends WebDriverUtility{
	public QuickCreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="productname")
	private WebElement prodName;
	
	@FindBy(name="discontinued")
	private WebElement checkbox;
	
	@FindBy(name="unit_price")
	private WebElement unitPrice;
	
	@FindBy(id="qtyinstock")
	private WebElement qtyInStock;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement groupradioButton;
	@FindBy(xpath="//input[@value='U']")
	private WebElement userradioButton;
	
	public WebElement getGroupradioButton() {
		return groupradioButton;
	}

	public WebElement getUserradioButton() {
		return userradioButton;
	}

	@FindBy(name="assigned_group_id")
	private WebElement groupId;
	
	@FindBy(name="button")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getProdName() {
		return prodName;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getUnitPrice() {
		return unitPrice;
	}

	public WebElement getQtyInStock() {
		return qtyInStock;
	}

//	public WebElement getRadioButton() {
	//	return radioButton;
//	}

	public WebElement getGroupId() {
		return groupId;
	}
	@FindBy(xpath="//option[text()='Team Selling']")
	private WebElement teamselling;
	
	public WebElement getTeamselling() {
		return teamselling;
	}

	public void createquickproduct (String productname) {
		prodName.sendKeys("Laptop");
		groupradioButton.click();
		teamselling.click();
		saveBtn.click();
		
	}

}
