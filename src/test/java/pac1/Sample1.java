package pac1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Sample1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Random random=new Random();
		int randomNum = random.nextInt(10);
		
		//driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59");
		FileInputStream fis=new FileInputStream("./data/commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		String ORGANISATION_NAME =pobj.getProperty("organisation_name")+randomNum;
		//WebDriver driver = new ChromeDriver(); 
		
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
		
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(ORGANISATION_NAME);
		driver.findElement(By.name("button")).click();
		//String expectedOrganisationHeader="[ ACC8 ] apple7 - Organization Information  ";
		Thread.sleep(5000);
		String actualOrganisationHeader=(driver.findElement(By.xpath("//span[@class='dvHeaderText']"))).getText();
		if(actualOrganisationHeader.contains(ORGANISATION_NAME))
		{
			System.out.println("Pass: The organaisation header is correct");
			
		} else {
			System.out.println("fail: The organaisation header is incorrect");
			
		}
		WebElement sourceImg = driver.findElement(By.xpath("//img[contains(@src,'user.PNG')]"));
		
		Actions actions=new Actions(driver);
		actions.moveToElement(sourceImg).perform();
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}
}
