package com.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createProductPlus;
	
	@FindBy(xpath="//tr[@id='row_16']/descendant::a[@title='Products']")
	private WebElement serachProduct;
	
	public WebElement getSerachProduct() {
		return serachProduct;
	}
	@FindBy(name="search_text")
	private WebElement searchTextField;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchIn;
	
	@FindBy(name="submit")
	private WebElement searchBtn;

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchIn() {
		return searchIn;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getCreateProductPlus() {
		return createProductPlus;
	}
	
	public void searchBy() {
		Select s=new Select(searchIn);
		s.selectByVisibleText("Product Name");
	}
	

}
