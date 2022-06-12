/**
 * 
 */
package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class Activtity1_Resizable
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Setup Chrome Driver
		WebDriverManager.chromedriver().setup();
		
		//Setup Browser Options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://jqueryui.com/resizable/");
		//WebElement iframe = driver.findElement(By.id("demo-frame"));
		
		//Select the frame
		driver.switchTo().frame(0);
		WebElement resizable = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		WebElement rightSide = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-e']"));
	    WebElement bottomSide = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-s']"));
	    
	    //Action object initialised
		Actions builder = new Actions(driver);
	
		System.out.println("Move using Right Handle");
		for(int x = 1; x <= 10; x++ )
			builder.clickAndHold(rightSide).moveByOffset(x, x).release().perform();
		System.out.println("1 Resizeable Location: " + resizable.getLocation());
		
		System.out.println("Move using Bottom Handle");
		for(int y = 1; y <= 10; y++ )
			builder.clickAndHold(bottomSide).moveByOffset(y, y).release().perform();
		System.out.println("2 Resizeable Location: " + resizable.getLocation());
		
		System.out.println("Move using Diagonal Handle");
		for(int x = 1, y = 1; x <= 10 && y <= 10; x++, y++ )
			builder.clickAndHold(resizable).moveByOffset(y, y).release().perform();
		
		System.out.println("3 Resizeable Location: " + resizable.getLocation());
	}

}
