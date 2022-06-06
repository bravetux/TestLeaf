/**
 * 
 */
package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class MergeContact
{

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException
	{
		String username = "DemoSalesManager";
		String password = "crmsfa";

		WebDriverManager.chromedriver().setup();
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//1. Launch URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		//3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		//4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		//5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		//6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//a[contains(text(),'Merge')]")).click();
		
		//7. Click on Widget of From Contact
		driver.findElement(By.id("ComboBox_partyIdFrom")).sendKeys("babu");
		Thread.sleep(3000);
		
		//8. Click on First Resulting Contact
		driver.findElement(By.xpath("(//div[@class='dijitMenuItem'])[2]")).click();
		//9. Click on Widget of To Contact
		driver.findElement(By.id("ComboBox_partyIdTo")).sendKeys("babu");
		Thread.sleep(3000);
		
		//10. Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='dijitMenuItem'])[3]")).click();
		//11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		//12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//13. Verify the title of the page
		System.out.println("Title: " + driver.getTitle());
		
		if (driver.getTitle().contains("View"))
			System.out.println("Title Match the String View");
		else
			System.out.println("Title didnt Match");
	}

}
