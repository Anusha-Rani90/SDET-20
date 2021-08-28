package com.vtiger.comcast.productstest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericutility.BaseClass;
import com.vtiger.pomrepositorylib.HomePage;
import com.vtiger.pomrepositorylib.ProductsPage;
@Listeners(com.vtiger.comcast.genericutility.ListenerImplementation.class)
public class SearchProductTest extends BaseClass{
	
	@Test(groups="Regional Regression Test")
	public void searchProduct() throws Throwable {
		HomePage homePage=new HomePage(driver);
		homePage.getProductLink().click();
		String SEARCHTEXT=fLib.getPropertyKeyValue("searchtextfield");
		String PRODUCTNAME=fLib.getPropertyKeyValue("productName");
		
		ProductsPage products=new ProductsPage(driver);
		products.getSearchTextField().sendKeys(SEARCHTEXT);
		
		String actualProd=products.getSerachProduct().getText();
		products.searchBy();
		
		products.getSearchIn().sendKeys(PRODUCTNAME);
		products.getSearchBtn().click();
		
		System.out.println(actualProd);
		System.out.println(PRODUCTNAME);
		boolean prName = actualProd.contains(PRODUCTNAME);
//		if(actualProd.contains(PRODUCTNAME))
//		{
//			System.out.println("pass: " +PRODUCTNAME+ " is matching");
//		}else {
//			System.out.println("fail: " +PRODUCTNAME+ " is not matching");
//		}
		
		Assert.assertTrue(prName);
	}

}
