/**
 * 
 */
package week4.day2.assignments;

import java.time.Duration;
import java.util.List;

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
public class Activity1_Sortable
{

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//options.addArguments("--headless");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("http://www.leafground.com/pages/sortable.html");
		
		List<WebElement> findElements = driver.findElements(By.xpath("//span[@class='ui-icon ui-icon-arrowthick-2-n-s']"));
		Actions builder = new Actions(driver);
		
		for(int i = findElements.size()-1; i>0; i--)
		{
			builder.clickAndHold(findElements.get(i)).moveToElement(findElements.get(i-2)).release().perform();
			Thread.sleep(2000);
		}

	}

}
