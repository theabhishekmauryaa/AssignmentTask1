package Assignment_EVe1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.manage().window().maximize();
		
		// upload the file 
		WebElement uploadElement = driver.findElement(By.xpath("//input[@id='file-upload']"));
				uploadElement.sendKeys("C:\\Users\\maury\\Downloads\\R_system_Assignment-20250314T172539Z-001.zip");
				Thread.sleep(4000);
				
				// Click and verify the button and uploaded file
				WebElement clickUpload = driver.findElement(By.xpath("//input[@id='file-submit']"));
				clickUpload .click();
				// to check and verify the uploaded the  file
				System.out.println("Sucessfully upload " + uploadElement);
				
				Thread.sleep(4000);
				driver.close();
	}

}
