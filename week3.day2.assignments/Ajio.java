/**
 * 
 */
package week3.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class Ajio
{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		/* Disable Popup Notifications on the browser */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		/* Trigger the Browser */
		ChromeDriver driver = new ChromeDriver(options);
		
		//Maximize Window and Set the timeout to 30seconds
		driver.manage().window().minimize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds ( 30 ));
		
		driver.get("https://www.ajio.com");
		
		//In the search box, enter keyword bag and press Enter Key
		driver.findElement(By.name("searchVal")).sendKeys("bags", Keys.ENTER);
		Thread.sleep(2000);
		
		// To the left  of the screen under " Gender" click the "Men"
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(2000);
		
		//Under "Category" click "Fashion Bags"
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		Thread.sleep(2000);
		
		//Get the Total Items Fount
		String strTotalItems = driver.findElement(By.className("length")).getText();
		System.out.println("Total Number of Items: " + strTotalItems);
		
		//Get the list of brand of the products displayed in the page and print the list.
		List<WebElement> bagBrandList = driver.findElements(By.className("brand"));
		List<WebElement> bagNameList = driver.findElements(By.className("nameCls"));
				
		//Create a new ArrayList<String>
		List<String> strBagBrandList = new ArrayList<String>();
		//Convert WebElement List to String List
		for(WebElement we : bagBrandList){
			strBagBrandList.add(we.getText());
		}
		System.out.println("List Size:  " + bagBrandList.size());
		System.out.println("Brand List: " + strBagBrandList);
		
		//Create a new ArrayList<String>
		List<String> strBagNameList = new ArrayList<String>();
		//Convert WebElement List to String List
		for(WebElement we : bagNameList){
			strBagNameList.add(we.getText());
		}
		System.out.println("List Size :" + bagNameList.size());
		System.out.println("Name List: " + strBagNameList);

		//HashSet for BagBrand
		Set<String> strBagBrandset = new HashSet<String>();
		for (String bagBrand : strBagBrandList)
			strBagBrandset.add(bagBrand);
		
		//HashSet for BagNames
		Set<String> strBagNameset = new HashSet<String>();
		for (String bagName : strBagNameList)
			strBagNameset.add(bagName);
		
        // Creates Iterator object.
        Iterator itr = strBagBrandset.iterator();
        
        System.out.println("Uniq Brand Set - Size: " + strBagBrandset.size());
        // check element is present or not. if not loop will break
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        System.out.println("");
        System.out.println("Uniq Name Set - Size: " + strBagNameset.size());
        itr = strBagNameset.iterator();
        // check element is present or not. if not loop will break
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        //Close the browser
        driver.close();
		
	}

}
