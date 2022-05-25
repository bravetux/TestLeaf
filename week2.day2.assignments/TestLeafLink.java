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
public class TestLeafLink
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		WebElement eleLink;
		//Setup WebDriver Manager
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("http://leafground.com/pages/Link.html");
		
		//Link 1
		eleLink = driver.findElement(By.linkText("Go to Home Page"));
		//Find the Redirection URL with Attribute
		System.out.println("Link 1 Text Attribute: " + eleLink.getAttribute("href"));
		
		//Find the Color of the text
		System.out.println("Link 1 Color: " + eleLink.getCssValue("color"));
		
		//Link 2
		eleLink= driver.findElement(By.linkText("Find where am supposed to go without clicking me?"));
		
		//Find the Redirection URL with Attribute
		System.out.println("Link 2 Text Attribute: " + eleLink.getAttribute("href"));
		
		//Find the Color of the text
		System.out.println("Link 2 Color: " + eleLink.getCssValue("color"));
		
		//Link 3
		eleLink = driver.findElement(By.linkText("Verify am I broken?"));
		
		//Find the Redirection URL with Attribute
		System.out.println("Link 3 Text Attribute: " + eleLink.getAttribute("href"));
		
		//Find the Color of the text
		System.out.println("Link 3 Color: " + eleLink.getCssValue("color"));
		
		//Link 4
		eleLink = driver.findElement(By.linkText("Verify am I broken?"));
		
		//Find the Redirection URL with Attribute
		System.out.println("Link 4 Text Attribute: " + eleLink.getAttribute("href"));
		
		//Find the Color of the text
		System.out.println("Link 4 Color: " + eleLink.getCssValue("color"));
		
		//Find the Label Caption
		System.out.println("Link 4 Label Caption: " + driver.findElement(By.xpath("//label[contains(text(),'(Interact with same link name)')]")).getText());
		
		//Link 5
		eleLink = driver.findElement(By.linkText("How many links are available in this page?"));
		
		//Find the Redirection URL with Attribute
		System.out.println("Link 5 Text Attribute: " + eleLink.getAttribute("href"));
		
		//Find the Color of the text
		System.out.println("Link 5 Color: " + eleLink.getCssValue("color"));
		
		driver.close();
	}


}
