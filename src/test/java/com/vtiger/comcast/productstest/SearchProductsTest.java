package com.vtiger.comcast.productstest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.comcast.genericutility.ExcelUtility;
import com.vtiger.comcast.genericutility.FileUtility;
import com.vtiger.comcast.genericutility.JavaUtility;
import com.vtiger.comcast.genericutility.WebDriverUtility;
import com.vtiger.pomrepositorylib.HomePage;
import com.vtiger.pomrepositorylib.LoginPage;
import com.vtiger.pomrepositorylib.ProductsPage;

public class SearchProductsTest {
	public static void main(String[] args) throws Throwable {
		ExcelUtility eLib=new ExcelUtility(); 
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		int randomNum=jLib.getRandomNumber();
		
		String BROWSER=fLib.getPropertyKeyValue("browser");
		String URL=fLib.getPropertyKeyValue("url");
		String USERNAME=fLib.getPropertyKeyValue("username");
		String PASSWORD=fLib.getPropertyKeyValue("password");
		//String PRODUCTNAME=fLib.getPropertyKeyValue("productname");
		String UNITPRICE=fLib.getPropertyKeyValue("UnitPrice");
		String QUANTITY=fLib.getPropertyKeyValue("Quantity");
		String GROUPID=fLib.getPropertyKeyValue("groupid");
		String SEARCHTEXT=fLib.getPropertyKeyValue("searchtextfield");
		String PRODUCTNAME=fLib.getPropertyKeyValue("productName");
		WebDriver driver=null;
				if(BROWSER.equals("chrome"))
				{
					driver=new ChromeDriver();
				} else {
					driver=new FirefoxDriver();
				}
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get(URL);
				
				LoginPage loginPage=new LoginPage(driver);
				loginPage.loginToApp(USERNAME,PASSWORD);
				
				HomePage homePage=new HomePage(driver);
				homePage.getProductLink().click();
				
				ProductsPage products=new ProductsPage(driver);
				products.getSearchTextField().sendKeys(SEARCHTEXT);
				String actualProd=products.getSerachProduct().getText();
				products.searchBy();
				//String actualProd=products.getSearchTextField().getText();
				products.getSearchIn().sendKeys(PRODUCTNAME);
				products.getSearchBtn().click();
				
				System.out.println(actualProd);
				System.out.println(PRODUCTNAME);
				if(actualProd.contains(PRODUCTNAME))
				{
					System.out.println("pass: " +PRODUCTNAME+ " is matching");
				}else {
					System.out.println("fail: " +PRODUCTNAME+ " is not matching");
				}
				
				homePage.logout();

	}

}
