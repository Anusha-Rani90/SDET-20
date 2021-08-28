package com.vtiger.comcast.productstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericutility.BaseClass;
import com.vtiger.pomrepositorylib.CreateNewProductPage;
import com.vtiger.pomrepositorylib.HomePage;
import com.vtiger.pomrepositorylib.ProductInfoPage;
import com.vtiger.pomrepositorylib.ProductsPage;
import com.vtiger.pomrepositorylib.QuickCreateProductPage;

public class CreateProduct1Test extends BaseClass{
	
@Test(groups="smoke test")
	public void createProTest() throws Throwable{
	/* navigate to home page*/
	HomePage homePage=new HomePage(driver);
	homePage.getProductLink().click();
	/* Navigate to products page*/
	ProductsPage productsPage=new ProductsPage(driver);
	productsPage.getCreateProductPlus().click();
	
	String PRODUCTNAME=fLib.getPropertyKeyValue("productname");
	String productName=eLib.getDataFromExcel("Sheet1", 7, 2);
	
	CreateNewProductPage createNewProductPage = new CreateNewProductPage(driver);
	createNewProductPage.createProdName(productName);
	
	
	ProductInfoPage productInfoPage=new ProductInfoPage(driver);
	String actualMsg=productInfoPage.getSuccessMsg().getText();
	
	boolean pName=actualMsg.contains(productName);
	
//	if(actualMsg.contains(productName))
//	{
//		System.out.println("PASS: Product Name is Corrrect");
//	}else {
//		System.out.println("FAIL: Product Name is incorrect");
//	}
	Assert.assertTrue(pName);
}
	@Test
	public void quickCreateProTest() throws Throwable {
		HomePage homePage=new HomePage(driver);
		homePage.getQuickCreateMenuList().click();
		homePage.quickMenu();
		
		String PRODUCTNAME=fLib.getPropertyKeyValue("productname");

		QuickCreateProductPage quickCreateProductPage= new QuickCreateProductPage(driver);
		//Thread.sleep(5000);
		String PRODUCTNAME1=fLib.getPropertyKeyValue("productname");

//		quickCreateProductPage.getProdName().sendKeys(PRODUCTNAME);
//		quickCreateProductPage.getCheckbox().click();
//		quickCreateProductPage.getUnitPrice().sendKeys(UNITPRICE);
//		quickCreateProductPage.getQtyInStock().sendKeys(QUANTITY);
//		quickCreateProductPage.getRadioButton().click();
//		quickCreateProductPage.getGroupId().sendKeys(GROUPID);
//		quickCreateProductPage.getSaveBtn().click();
		quickCreateProductPage.createquickproduct(PRODUCTNAME1);
		String actualProduct =quickCreateProductPage.getProdName().getText();
		String expectedProduct = "Laptop";
		Assert.assertEquals(actualProduct, expectedProduct);
		
	}
}


