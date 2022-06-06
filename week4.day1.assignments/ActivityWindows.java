/**
 * 
 */
package week4.day1.assignments;

import java.awt.Window;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.java.swing.plaf.windows.resources.windows;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class ActivityWindows
{

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException
	{
		//Setup the WebdriverManager for ChromeDriver
		WebDriverManager.chromedriver().setup();
		
		//Open the browser
		ChromeDriver driver = new ChromeDriver();
		
		//Open the webpage and setup
		driver.get("http://leafground.com/pages/Window.html");
		driver.manage().window().minimize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Store the Parent Window Handle
		String parentWindowHandle = driver.getWindowHandle();
		
		//Print the Title
		System.out.println("Parent Title: " + driver.getTitle());
		
		System.out.println("======Open Home Page - Button======");
		//////// 1. Click "Open Home Page" Button ///////////////////////
		driver.findElement(By.id("home")).click();
		
		//Get all the window Handles in to Set
		Set<String> windowHandles = driver.getWindowHandles();
		
		//Convert List to Set
		List<String> windowsList = new ArrayList<String>(windowHandles);
		
		for (int i = 1; i < windowsList.size(); i++)
		{
			driver.switchTo().window(windowsList.get(i));
			if(driver.getTitle().contains("TestLeaf"))
			{
				System.out.println("New Window Opened");
				//Print the Title of the new Window
				System.out.println("Window Title: " + driver.getTitle());
			}
		}
		
		//Close the new Window
		driver.close();
		
		//Switch to Parent Window
		driver.switchTo().window(parentWindowHandle);
		
		//Print the Title
		System.out.println(driver.getTitle());
		//Print the Title
		System.out.println("Parent Title: " + driver.getTitle());
		System.out.println("====== Open Multiple Windows - Button ======");
		////////// 2. Click "Open Multiple Windows" Button ////////////////////
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		//Get all the window Handles in to Set
		windowHandles = driver.getWindowHandles();
		
		//Convert List to Set
		windowsList = new ArrayList<String>(windowHandles);
		
		for (int i = 1; i < windowsList.size(); i++)
		{
			driver.switchTo().window(windowsList.get(i));
			if(driver.getTitle().contains("TestLeaf"))
			{
				System.out.println("New Window Opened");
				//Print the Title of the new Window
				System.out.println("Window Title: " + driver.getTitle());
				driver.close();
				System.out.println("Window Closed");
			}
		}
		
		//Switch to Parent Window
		driver.switchTo().window(parentWindowHandle);
		//Print the Title
		System.out.println("Parent Title: " + driver.getTitle());
		System.out.println("======Do not close me - Button======");
		/////////////// 3. Click - "Do not close me" /////////////////////
		driver.findElement(By.id("color")).click();
		//Get all the window Handles in to Set
		windowHandles = driver.getWindowHandles();
		
		//Convert List to Set
		windowsList = new ArrayList<String>(windowHandles);
		
		for (int i = 1; i < windowsList.size(); i++)
		{
			driver.switchTo().window(windowsList.get(i));
			if(driver.getTitle().contains("TestLeaf"))
			{
				System.out.println("New Window Opened");
				//Print the Title of the new Window
				System.out.println("Window Title: " + driver.getTitle());
				driver.close();
				System.out.println("Window Closed");
			}
		}
		
		//Switch to Parent Window
		driver.switchTo().window(parentWindowHandle);
		//Print the Title
		System.out.println("Parent Title: " + driver.getTitle());
		System.out.println("======Wait for 2 new Windows to open - Button======");
		/////////// 4. Wait for 2 new Windows to open ////////////////////////////////
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Thread.sleep(5500);
		
		//Get all the window Handles in to Set
		windowHandles = driver.getWindowHandles();
		
		//Convert List to Set
		windowsList = new ArrayList<String>(windowHandles);
		
		for (int i = 1; i < windowsList.size(); i++)
		{
			driver.switchTo().window(windowsList.get(i));
			if(driver.getTitle().contains("TestLeaf"))
			{
				System.out.println("New Window Opened");
				//Print the Title of the new Window
				System.out.println("Window Title: " + driver.getTitle());
				driver.close();
				System.out.println("Window Closed");
			}
		}
		
		//Switch to Parent Window
		driver.switchTo().window(parentWindowHandle);
		
		//Print the Title
		System.out.println("Current Title: " + driver.getTitle());

	}

}
