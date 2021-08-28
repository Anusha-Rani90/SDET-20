package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class SampleExtentReportTest {
	WebDriver driver;
	public ExtentHtmlReporter reporter;
	public ExtentReports reports;
	public ExtentTest test;
	
	@BeforeSuite
	public void configBS() {
		reporter=new ExtentHtmlReporter("../SeleniumProject/SDET_20/SDET20.html");
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		System.out.println("Before suite executed");;
	}
	
	@BeforeClass
	public void configBC() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Launch the chrome browser");
		driver.get("http://localhost:8888");
		

	}
	
	@BeforeMethod
	public void loginTest() {
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
	}
	@Test
	public void homePageTitle() {
		test = reports.createTest("homePageTitle");
		WebElement element =driver.findElement(By.xpath("//a[@class='hdrLink']"));
		String ExpectedHomePT = "Home";
		String actualHomePT = element.getText();

//		if(actualHomePT.contains(ExpectedHomePT)) {
//			System.out.println("Pass:Home page Title is corrrect");
//		} else {
//			System.out.println("Fail:Home Page Title is incorrrect");
//		
		Assert.assertEquals(actualHomePT,"Home");
		
		
	}
	@Test
	public void clickOnOrg() {
		test = reports.createTest("clickOnOrg");
		WebElement ele = driver.findElement(By.linkText("Organizations"));
		String expectedTitle = "Organizations";
		String actualTitle = ele.getText();
//		if(actualTitle.contains(expectedTitle)) {
//			System.out.println("Pass:Title is corrrect");
//		} else {
//			System.out.println("Fail:Title is incorrrect");
//		}
		Assert.assertEquals(actualTitle,"Organizations");
		
	}
	@AfterClass
	public void configAC()
	{
		driver.close();
	}
	@AfterMethod
	public void logout() {
		WebElement sourceImg = driver.findElement(By.xpath("//img[contains(@src,'user.PNG')]"));
		
		Actions actions=new Actions(driver);
		actions.moveToElement(sourceImg).perform();
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	
	}
	
	@AfterSuite
	public void configAS() {
		reports.flush();
		System.out.println("After suite executed");
	}
}

