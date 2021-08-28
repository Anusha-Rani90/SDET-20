package pac1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProductTestcase06 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		String PRODUCTNAME=pobj.getProperty("productName");WebDriver driver=null;
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
			
			driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
			driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
			driver.findElement(By.name("button")).click();
			
			driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.name("search_text")).sendKeys(PRODUCTNAME);
			
			WebElement inDropdownBox = driver.findElement(By.id("bas_searchfield"));
			Select s=new Select(inDropdownBox);
			s.selectByVisibleText("Product Name");
			driver.findElement(By.name("submit")).click();
			
			WebElement sourceImg = driver.findElement(By.xpath("//img[contains(@src,'user.PNG')]"));
			Actions actions=new Actions(driver);
			actions.moveToElement(sourceImg).perform();
			 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();


	}

}
