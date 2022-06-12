/**
 * 
 */
package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class Activity1_Drag
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Setup Chrome Driver
		WebDriverManager.chromedriver().setup();
		
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Navigate to URL
		driver.get("http://www.leafground.com/pages/drag.html");
		
		//Find the Element to Drag
		WebElement eleDrag = driver.findElement(By.id("draggable"));
		
		//Action object initialized
		Actions builder = new Actions(driver);
		
		for (int x = 1; x<20; x++)
			for (int y = 1; y < 10; y++, x++)
				builder.clickAndHold(eleDrag).moveByOffset(x, y).release(eleDrag).perform();
	}
}
