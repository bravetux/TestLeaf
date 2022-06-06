/**
 * 
 */
package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class ActivityFrames
{

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		//Setup Chrome Options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//Setup Chrome Driver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Navigate to WebPage
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		//Store frame WebElements
		WebElement iframe1 = driver.findElement(By.id("frame1"));
		WebElement iframe2 = driver.findElement(By.id("frame2"));
		
		//Switch to Frame1
		driver.switchTo().frame(iframe1);
		
		//Frame3, resides within frame1, so we are doing after switching to frame1
		WebElement iframe3 = driver.findElement(By.id("frame3"));
		
		driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input")).sendKeys("Hello World");
		
		//Switch to Frame3
		driver.switchTo().frame(iframe3);
		driver.findElement(By.id("a")).click();
		
		//To move out of all the frames.
		driver.switchTo().defaultContent();
		
		//Move to Frame2
		driver.switchTo().frame(iframe2);
		
		WebElement dropDown = driver.findElement(By.tagName("select"));
		//Another way of choosing
		//WebElement dropDown = driver.findElement(By.id("animals"));
		
		Select drop = new Select(dropDown);
		for (int i = 0; i < 4; i++)
		{
			drop.selectByIndex(i);
			Thread.sleep(2000);
		}
	}
}
