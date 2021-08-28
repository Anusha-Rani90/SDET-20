package pac2;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingCalenderPopupTryCatchTest {

	public static void main(String[] args) {
		String date="28";
		String monthYear="December 2021";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.makemytrip.com/");
		Actions actions=new Actions(driver);
		actions.click().perform();
		
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		for(;;) {
		try {
			
			String dateXpath = "//div[text()='"+monthYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";

			driver.findElement(By.xpath(dateXpath));
			break;
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		
		}
		//driver.quit();

	}

}
