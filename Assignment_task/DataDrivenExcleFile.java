package Assignment_EVe1;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenExcleFile {
	public static void main(String[] args) throws IOException, InterruptedException  {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		 FileInputStream fis = new FileInputStream("D:\\masai\\Evaluate-Prograne\\Project\\Tutorial-Ninja_Automation\\src\\test\\resources\\Data\\Login.xlsx");
			
			Workbook book = WorkbookFactory.create(fis);
			
		  String username = book.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		  String password = book.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		  Thread.sleep(4000);
		  
		// Locate login elements and perfrom login
		 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("username");
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
		 Thread.sleep(5000);
	    driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		
	
		
		Thread.sleep(5000);
		fis.close();
		driver.quit();
	}

}
