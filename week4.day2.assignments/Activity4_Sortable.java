/**
 * 
 */
package week4.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class Activity4_Sortable
{

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException
	{
		//Setup Chrome Driver
		WebDriverManager.chromedriver().setup();
		
		//Open New Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		//Open URL
		driver.get("http://www.leafground.com/pages/sortable.html");
		
		//Identify the Elements
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		//WebElement item7 = driver.findElement(By.xpath("//li[text()='Item 7']"));
		
		//Action Builder initialize to peform Actions
		Actions builder = new Actions(driver);

		//Move the Elements with Sleep of 4seconds
		builder.moveToElement(item6).clickAndHold().release(item1).perform(); Thread.sleep(4000);
		builder.moveToElement(item5).clickAndHold().release(item6).perform(); Thread.sleep(4000);
		builder.moveToElement(item4).clickAndHold().release(item5).perform(); Thread.sleep(4000);
		builder.moveToElement(item3).clickAndHold().release(item4).perform(); Thread.sleep(4000);
		builder.moveToElement(item2).clickAndHold().release(item3).perform(); Thread.sleep(4000);
		builder.moveToElement(item1).clickAndHold().release(item2).perform(); Thread.sleep(4000);
	}

}
