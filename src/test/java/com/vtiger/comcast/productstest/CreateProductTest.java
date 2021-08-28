package com.vtiger.comcast.productstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericutility.ExcelUtility;
import com.vtiger.comcast.genericutility.FileUtility;
import com.vtiger.comcast.genericutility.JavaUtility;
import com.vtiger.comcast.genericutility.WebDriverUtility;
import com.vtiger.pomrepositorylib.CreateNewProductPage;
import com.vtiger.pomrepositorylib.HomePage;
import com.vtiger.pomrepositorylib.LoginPage;
import com.vtiger.pomrepositorylib.ProductInfoPage;
import com.vtiger.pomrepositorylib.ProductsPage;
@Test 
public class CreateProductTest {
	
	public void createProdTest() throws Throwable {
	//public static void main(String[] args) throws Throwable {
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
		String productName=eLib.getDataFromExcel("Sheet1", 7, 2)+randomNum;
//		
		WebDriver driver=null;
				if(BROWSER.equals("chrome"))
				{
					driver=new ChromeDriver();
				} else {
					driver=new FirefoxDriver();
				}
				wLib.pageToLoad(driver);
				driver.get(URL);
				
				LoginPage loginPage=new LoginPage(driver);
				loginPage.loginToApp(USERNAME,PASSWORD);
				
				HomePage homePage=new HomePage(driver);
				homePage.getProductLink().click();
				
				ProductsPage productsPage=new ProductsPage(driver);
				productsPage.getCreateProductPlus().click();
				
				CreateNewProductPage createNewProductPage = new CreateNewProductPage(driver);
				createNewProductPage.createProdName(productName);
				
				
				ProductInfoPage productInfoPage=new ProductInfoPage(driver);
				String actualMsg=productInfoPage.getSuccessMsg().getText();
				if(actualMsg.contains(productName))
				{
					System.out.println("PASS: Product Name is Corrrect");
				}else {
					System.out.println("FAIL: Product Name is incorrect");
				}
				homePage.logout();
				
	}

}
