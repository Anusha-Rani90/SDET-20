package pac1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ReadDataFromExcelAndCommonData {

	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("./data/commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		String ORGANISATION_NAME =pobj.getProperty("organisation_name");
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
		//driver.findElement(By.name("button")).click();
		Thread.sleep(5000);
		FileInputStream fisExcelSheet=new FileInputStream("./data/testscript.xlsx");
		Workbook wb= WorkbookFactory.create(fisExcelSheet);
		Sheet sh=wb.getSheet("Sheet1");
		Row row =sh.getRow(1);
		Cell cell=row.getCell(2);
		String val=cell.getStringCellValue();
		System.out.println(val);
		
		Cell writeToCell=row.createCell(6);
		writeToCell.setCellValue("pass");
		
		FileOutputStream fos=new FileOutputStream("./data/testscript.xlsx");
		wb.write(fos);
		wb.close();

		
		
		WebElement sourceImg = driver.findElement(By.xpath("//img[contains(@src,'user.PNG')]"));
		
		Actions actions=new Actions(driver);
		actions.moveToElement(sourceImg).perform();
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}
}

