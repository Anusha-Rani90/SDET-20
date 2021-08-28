package com.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Products")
	private WebElement productLink;
	
	 @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	 private WebElement administratorImg;
	 
	 @FindBy(linkText="Sign Out")
	 private WebElement logoutLink;
	 
	 @FindBy(id="qccombo")
	 private WebElement quickCreateMenuList;
	 
	public WebElement getQuickCreateMenuList() {
		return quickCreateMenuList;
	}

	public WebElement getProductLink() {
		return productLink;
	}
	
	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getLogout() {
		return logoutLink;
	}
	public void quickMenu() {
		Select s=new Select(quickCreateMenuList);
		s.selectByVisibleText("New Product");
	}
	
	public void logout() {
		Actions actions=new Actions(driver);
		actions.moveToElement(administratorImg).perform();
		logoutLink.click();
	}
	
	
	
	
}


