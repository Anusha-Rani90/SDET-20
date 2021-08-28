package pac1;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProductTestcase04 {

	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("./data/commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		String PRODUCTNAME=pobj.getProperty("productName");
		String UNITPRICE=pobj.getProperty("UnitPrice");
		String QUANTITY=pobj.getProperty("Quantity");
		WebDriver driver=null;
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  if(BROWSER.equals("chrome")) 
		  { 
			  driver=new ChromeDriver();
		  
		  } else if(BROWSER.equals("firefox")) 
		  { 
			  driver=new FirefoxDriver(); 
			  }
		  driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
		Actions actions=new Actions(driver);
		WebElement quickCreateList = driver.findElement(By.id("qccombo"));
		Select s=new Select(quickCreateList);
		s.selectByVisibleText("New Product");
		Thread.sleep(5000);
		driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
		driver.findElement(By.name("discontinued")).click();
		driver.findElement(By.name("unit_price")).sendKeys(UNITPRICE);
		driver.findElement(By.id("qtyinstock")).sendKeys(QUANTITY);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@value='T']")).click();
		WebElement groupList = driver.findElement(By.name("assigned_group_id"));
		Select s1=new Select(groupList);
		s1.selectByVisibleText("Team Selling");
		driver.findElement(By.name("button")).click();
		WebElement sourceImg = driver.findElement(By.xpath("//img[contains(@src,'user.PNG')]"));
		actions.moveToElement(sourceImg).perform();
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
