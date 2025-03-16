package Assignment_EVe1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleIframe {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();

        // Handling Single Frame
        WebElement singleframe = driver.findElement(By.xpath("//iframe[@id='singleframe']"));
        driver.switchTo().frame(singleframe);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Abhishek Maurya");
        
        // Switch back to the main page
        driver.switchTo().defaultContent();

        // Handling Nested Frames
        WebElement nestedFrameTab = driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']"));
        nestedFrameTab.click();
        Thread.sleep(2000);

        // Switching to outer frame
        WebElement outerFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
        driver.switchTo().frame(outerFrame);

        // Switching to inner frame
        WebElement innerFrame = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
        driver.switchTo().frame(innerFrame);

        // Enter text inside inner frame input
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Abhishek Maurya");

        // Switch back to default content
        driver.switchTo().defaultContent();

        // Quit the driver
        driver.quit();
    }
}
