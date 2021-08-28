package com.vtiger.comcast.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.vtiger.pomrepositorylib.HomePage;
import com.vtiger.pomrepositorylib.LoginPage;

public class BaseClass {
	
	public ExcelUtility eLib=new ExcelUtility(); 
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public static WebDriver sdriver;
	public WebDriver driver;
	
	@BeforeClass(groups={"smoke test","regression test"})
	public void createPro() throws Throwable {
		String BROWSER=fLib.getPropertyKeyValue("browser");
		System.out.println("Launch the browser");
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
			else if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
		}
		sdriver=driver;
		driver.manage().window().maximize();
		 WebDriverUtility wLib=new WebDriverUtility();
		 wLib.pageToLoad(driver);
		
	}
	
	@BeforeMethod(groups={"smoke test","regression test"})
	public void configBM() throws Throwable {
		
		
		String BROWSER=fLib.getPropertyKeyValue("browser");
		String URL=fLib.getPropertyKeyValue("url");
		String USERNAME=fLib.getPropertyKeyValue("username");
		String PASSWORD=fLib.getPropertyKeyValue("password");
		String UNITPRICE=fLib.getPropertyKeyValue("UnitPrice");
		String QUANTITY=fLib.getPropertyKeyValue("Quantity");
		String GROUPID=fLib.getPropertyKeyValue("groupid");
		String SEARCHTEXT=fLib.getPropertyKeyValue("searchtextfield");
		String PRODUCTNAME=fLib.getPropertyKeyValue("productName");
		driver.get(URL);
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME,PASSWORD);
	}
	
	@AfterMethod(groups={"smoke test","regression test"})
	public void configAM() {
		HomePage homePage=new HomePage(driver);
		homePage.logout();
		
	}
	@AfterClass(groups={"smoke test","regression test"})
	public void confogAc() {
		driver.close();
	}	
	
	}





