/**
 * 
 */
package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class TestLeafImage
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		WebElement eleLink;
		String orignalUrl= "http://leafground.com/pages/Image.html";
		
		//Setup Webdriver
		WebDriverManager.chromedriver().setup();
		
		//Open the browser
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize the window and set Timeouts
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Open the URL
		driver.get(orignalUrl);
		
		//Image 1
		driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following-sibling::img")).click();
		System.out.println("Current URL: " + driver.getCurrentUrl());
		if (orignalUrl.equals(driver.getCurrentUrl()))
		{
			System.out.println("Redirect Failed for Image 1 - Broken Link");
		}
		else
		{
			System.out.println("Redirect Happened for Image 1");
		}
		//Image 2
		
		//Redirect to the Page of Interest
		driver.get(orignalUrl);
		
		driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img")).click();
		
		System.out.println("Current URL: " + driver.getCurrentUrl());
		if (orignalUrl.equals(driver.getCurrentUrl()))
		{
			System.out.println("Redirect Failed for Image 2 - Broken Link");
		}
		else
		{
			System.out.println("Redirect Happened for Image 2");
		}
		
		//Image 3
		
		//Redirect to the Page of Interest
		driver.get(orignalUrl);
		
		driver.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img")).click();
		
		System.out.println("Current URL: " + driver.getCurrentUrl());
		
		if (orignalUrl.equals(driver.getCurrentUrl()))
		{
			System.out.println("Redirect Failed for Image 3 - Broken Link");
		}
		else
		{
			System.out.println("Redirect Happened for Image 3");
		}
		
		driver.close();
	}

}
