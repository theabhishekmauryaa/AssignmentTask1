package Assignment_EVe1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#Open%20New%20Tab");
		driver.manage().window().maximize();
		
		String parentWindow = driver.getWindowHandle();
		
		//click buttom on the new open window
		driver.findElement(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//a[@class='button e.g. button_hilite button_pale small_button'][normalize-space()='Click Here']")).click();
		
		//get allow the handle
		Set<String> allWindow = driver.getWindowHandles();
		
		//switch to child window
		for(String window : allWindow) {
			if(!window.endsWith(parentWindow)) {
				driver.switchTo().window(window);
				System.out.println("Switch to : " + driver.getTitle());
			}
		}
		
		//perfrom action in new window
		System.out.println("child window title " + driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentWindow);
		System.out.println("back to parent window " + driver.getTitle());
		driver.quit();

	}
	
}
