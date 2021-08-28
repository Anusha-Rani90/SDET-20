package com.vtiger.comcast.genericutility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void pageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
// It is usedt Explicit wait condition by visi bility of elements
	
	public void waitForElementVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
//	OVERLOADING CONCEPT------>SELECT() 
//	It is used to select a option from dropdown list using visible text
	
	public void select(WebElement element, String option) {
		Select sel=new Select(element);
		sel.selectByVisibleText(option);
	}
	
//	It is used to select the option from drop down list by index
	
	public void select(WebElement element, int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
//	It is used to mousehover on the webelement
	
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
//	It is used to right click on the target webelement
	
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();;
	}
}
