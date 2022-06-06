/**
 * 
 */
package week4.day1.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class Amazon
{

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException
	{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		int indexDescription = 0;
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--headless");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().minimize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Store the Parent Window Handle
		String parentWindowHandle = driver.getWindowHandle();
		
		//Load Website
		driver.get("https://www.amazon.in");
		//Click Login
		//driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		
		//Amazon Logon Credentials
		//Send username
		//driver.findElement(By.id("ap_email")).sendKeys("vigneshkumarb@bravetux.com", Keys.ENTER);
		//Send password
		//driver.findElement(By.id("ap_password")).sendKeys("<passwd>",Keys.ENTER);
		
		//Search for the specified String
		String strSearch = "oneplus 9 pro 5g morning mist";
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(strSearch, Keys.ENTER);
		
		Thread.sleep(2000);
		String totalCount = driver.findElement(By.xpath("//div[contains(@class,'a-section a-spacing-small')]//span")).getText();
		
		List<WebElement> eleDescFind = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> elePriceFind = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<WebElement> eleRatings = driver.findElements(By.xpath("//span[contains(@class,'a-size-base')]"));
		
		//Sometimes in Description List, is getting the RESULTS string and 
		//causing the confusion of the index
		if (eleDescFind.get(0).getText().contains("RESULTS"))
		{
			indexDescription = 1;
		} 
		else
		{	
			indexDescription = 0;
		}
		
		//Print Details of the first Item Selected
		System.out.println("Description    : " + eleDescFind.get(indexDescription).getText());
		System.out.println("Price          : " + elePriceFind.get(0).getText());
		System.out.println("Customer Rating: " + eleRatings.get(0).getText());
		
		//Store the phone Price
		String pricePhone = elePriceFind.get(0).getText();
		
		//Get the ScreenShot
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./amazonScreenshot.png");
		FileUtils.copyFile(src, dest);
		
		//Open the first Item in new tab window
		eleDescFind.get(indexDescription).click();
		Thread.sleep(5000);
		
		//Get all the window Handles in to Set
		Set<String> windowHandles = driver.getWindowHandles();
		
		//Convert List to Set
		List<String> windowsList = new ArrayList<String>(windowHandles);
		
		System.out.println("WindowsList Size: " + windowsList.size());
		//Switched to the Tab using Index - Ordered Set
		driver.switchTo().window(windowsList.get(1));
		
		//Print the Title
		System.out.println("New Window Title: " + driver.getTitle());
		
		//Click Add to Cart Button
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);
		
		String cartValue = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("Cart Value = " + cartValue);
		System.out.println("Phone Value = " + pricePhone);
		
		if (cartValue.contains(pricePhone))
			System.out.println("Phone & Cart Value Matches");
		else
			System.out.println("Phone & Cart Value Doesnt Matches");
		
		driver.close(); //Close New Tab
		
		//Switch to Parent Window
		driver.switchTo().window(parentWindowHandle);
	}

}
