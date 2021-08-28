package pac2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingCalenderPopupTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		
		driver.findElement(By.xpath("//div[@data-cy='outsideModal']")).click();
		
		driver.findElement(By.xpath("//label[@for='departure']//span[contains(@class,'lbl_input latoBold appen')]")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@aria-label='Tue Aug 17 2021']")).click();
		
	}

}
