/**
 * 
 */
package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class Activity1_Drop
{

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException
	{
		int x, y;
		//Setup Chrome Driver
		WebDriverManager.chromedriver().setup();
		
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Navigate to URL
		driver.get("http://www.leafground.com/pages/drop.html");
		
		//Find the Element to Drag
		WebElement dragEle = driver.findElement(By.id("draggable"));
		WebElement dropEle = driver.findElement(By.id("droppable"));
		
		//Action object initialized
		Actions builder = new Actions(driver);
			
		builder.dragAndDrop(dragEle, dropEle).perform();

	}
}
