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
public class TestLeafRadio
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Setup Webdriver
		WebDriverManager.chromedriver().setup();
		
		//Open the web browser
		ChromeDriver driver = new ChromeDriver();
		
		//Maximise Window and increase timeout to 30seconds
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Open the URL
		driver.get("http://www.leafground.com/pages/radio.html");
		
		//Print the Title of the Page
		System.out.println("The Title of the Page: " + driver.getTitle());
		
		//Print the current URL
		System.out.println("Current URL: " + driver.getCurrentUrl());
		
		//Print the page source
		//System.out.println("PageSource: " + driver.getPageSource());

		/* Yes and No Radio Box */
		WebElement eleYes = driver.findElement(By.xpath("//input[@class='myradio'][@id='yes']"));
		WebElement eleNo= driver.findElement(By.xpath("//input[@class='myradio'][@id='no']"));
		
		if (eleYes.isSelected())
			System.out.println("Yes Radio Box is Selected");
		else if (eleNo.isSelected())
			System.out.println("No Radio Box is Selected");
		else
			System.out.println("None of the Radio Box is Selected");

		
		/* Uncheck and Check Radio Box */
		WebElement eleUncheck = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
		WebElement elecheck = driver.findElement(By.xpath("(//input[@type='radio'])[4]"));
		
		//elecheck.click();
		if (eleUncheck.isSelected())
			System.out.println("Uncheck Radio Box is Selected");
		else if(elecheck.isSelected())
			System.out.println("Check Radio Box is Selected");
		else
			System.out.println("None of the Radio Box is Selected");
		
		/* 3 Options -  1 - 20 years  21 - 40 years  Above 40 years */
		WebElement[] eleOptions = new WebElement[3];
		eleOptions[0] = driver.findElement(By.xpath("(//input[@type='radio'])[5]"));
		eleOptions[1] = driver.findElement(By.xpath("(//input[@type='radio'])[6]"));
		eleOptions[2] = driver.findElement(By.xpath("(//input[@type='radio'])[7]"));
		
		//eleOptions[2].click();
		for (int i= 0; i<=2 ; i++)
		{
			if(eleOptions[i].isSelected())
			{
				switch(i)
				{
					case 0:
						System.out.println("Option 0: 1 - 20 years is Selected.");
						break;
					case 1:
						System.out.println("Option 1: 21 - 40 years is Selected.");
						break;
					case 2:
						System.out.println("Option 2: Above 40 years is Selected.");
						break;
					default:
						break;
				}
			}
		}
		
		driver.close();
	}
}
