/**
 * 
 */
package week2.day2.assignments;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * @author vignesh
 *
 */
public class TestLeafButton
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Setup Chrome Driver
		WebDriverManager.chromedriver().setup();
		
		//Open Chrome Browser
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize Browser and set implicit wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Open URL
		driver.get("http://leafground.com/pages/Button.html");
		
		//Get Attribute of Home
		System.out.println(driver.findElement(By.id("home")).getAttribute("onclick"));

		//Click Home
		driver.findElement(By.id("home")).click();		
		
		//Click the Button
		driver.findElement(By.xpath("//h5[text()='Button']/following-sibling::img")).click();
		
		//Get the Location of the Browser
		Point location = driver.findElement(By.id("position")).getLocation();
		System.out.println("Location = " + location);
		
		//Get the Background Color
		System.out.println("BG Color: " + driver.findElement(By.id("color")).getCssValue("background-color"));
		
		//Find the element size
		System.out.println("Size: " + driver.findElement(By.id("size")).getSize());
		
		driver.close();

	}

}
