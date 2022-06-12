/**
 * 
 */
package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class Activity3_SnapDeal
{

	public static boolean isSorted(List<String> listOfStrings) {
	    if (listOfStrings.isEmpty() || (listOfStrings.size() == 1)) {
	        return true;
	    }

	    Iterator<String> iter = listOfStrings.iterator();
	    String current, previous = iter.next();
	    while (iter.hasNext()) {
	        current = iter.next();
	        if (previous.compareTo(current) > 0) {
	            return false;
	        }
	        previous = current;
	    }
	    return true;
	}
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//options.addArguments("--headless");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		//1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com");

		Actions builder = new Actions(driver);
		
		//2. Go to Mens Fashion
		WebElement mensFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		builder.moveToElement(mensFashion).click().perform();
		
		//3. Go to Sports Shoes
		WebElement shoes = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		builder.moveToElement(shoes).click().perform();
		
		//4. Get the count of the sports shoes
		String countOfShoes = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		String[] splitArray = countOfShoes.split(" ");
		countOfShoes = splitArray[1];
		
//		for (int i= 0; i< splitArray.length; i++)
//			System.out.println(" " + i + ": " + splitArray[i]);
		
		System.out.println("Count of Shoes: " + countOfShoes);
		
		//5. Click Training shoes
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		//6. Sort by Low to High
		Thread.sleep(1000);
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();

		//7. Check if the items displayed are sorted correctl
		List<WebElement> findItems = 
				driver.findElements(By.xpath("//span[contains(@class,'lfloat product-desc-price')]/following-sibling::span"));
		System.out.println("Count of Items = " + findItems.size());

		List<String> priceList = new ArrayList<String>();
		for(int i = 1; i <= findItems.size() ; i++)
		{
			Thread.sleep(1000);
			String price = driver.findElement(By.xpath("(//span[contains(@class,'lfloat product-desc-price')]/following-sibling::span)[" + i + "]")).getAttribute("display-price");
			//System.out.println(i + ": " + price);
			priceList.add(price);
		}	
		
		if (isSorted(priceList))
			System.out.println("The List is Sorted");
		else
			System.out.println("The List is not Sorted");
			
		//8.Select the price range (900-1200)
		WebElement minPrice = driver.findElement(By.name("fromVal"));
		WebElement maxPrice = driver.findElement(By.name("toVal"));
		
		//WebElement minPrice = driver.findElement(By.xpath("(//input[@class='input-filter'])[1]"));
		//Fill Min Range
		minPrice.clear(); minPrice.sendKeys("900");
		
		//Fill Max Range
		maxPrice.clear(); maxPrice.sendKeys("1200");
		
		//Click Go
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		
		//9.Filter with color Navy
		Thread.sleep(1000);
		WebElement blueColor = driver.findElement(By.xpath("//label[@for='Color_s-Blue']"));
		blueColor.click();
		
		//10 verify the all applied filters
		WebElement colorElement = driver.findElement(By.xpath("//a[@data-key='Color_s|Color']"));
		if (colorElement.getText().contains("Blue"))
			System.out.println("Blue Color Selected");
		else
			System.out.println("Blue Color Not Selected");
		
		String priceVal = driver.findElement(By.xpath("//a[@data-key='Price|Price']")).getText();
		if (priceVal.contains("900"))
			System.out.println("Minimum Price 900 Filtered");
		else
			System.out.println("Minimum Price 900 Not Filtered");

		if (priceVal.contains("1200"))
			System.out.println("Maximum Price 1200 Filtered");
		else
			System.out.println("Maximum Price 1200 Not Filtered");

		if (driver.findElement(By.linkText("Men's Sports Fashion")).getText().contentEquals("Men's Sports Fashion"))
			System.out.println("Men's Sports Fashion - Selected");
		else
			System.out.println("Men's Sports Fashion - Not Selected");

		if (driver.findElement(By.linkText("Sports Shoes for Men")).getText().contentEquals("Sports Shoes for Men"))
			System.out.println("Sports Shoes for Men - Selected");
		else
			System.out.println("Sports Shoes for Men - Not Selected");

		//11. Mouse Hover on first resulting Training shoes
		WebElement firstElement = driver.findElement(By.xpath("//img[@class='product-image wooble']"));

		//12. click QuickView button
		builder.moveToElement(firstElement).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		
		//13. Print the cost and the discount percentage
		String costItem = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span")).getText();
		String discountPercent = driver.findElement(By.xpath("(//div[@class='product-price pdp-e-i-PAY-l clearfix']/span)[2]")).getText();
		System.out.println("Cost of Item = " + costItem);
		System.out.println("Discount Percentage of Item = " + discountPercent);
		
		//14. Take the snapshot of the shoes.
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File ("./SnapDeal_screenshot.png");
		FileUtils.copyFile(src, dest);
		
		//15. Close the current window
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		
		//16. Close the main window
		driver.close();
		
	}

}
