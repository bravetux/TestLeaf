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
public class TestLeafCheckBox
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String orignalUrl = "http://leafground.com/pages/checkbox.html";
		WebElement[] eleCheck    = new WebElement[6];
		WebElement[] eleCheckAll = new WebElement[7];
		Boolean isChecked = true;
		int checkboxSelected = 0;
		int i = 0;
		
		//Setup WebDriver Manager
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize Browser Window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Goto the URL
		driver.get(orignalUrl);
		
		//Select 4th Checkbox
		driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following-sibling::input)[4]")).click();
		
		//Confirm 4th Option is Checked
		for(i=1; i< eleCheck.length ; i++)
		{
			//Retrieve all the options to array
			eleCheck[i] = driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following-sibling::input)["+i+"]"));
			
			//Check if the checkbox is Selected and respond accordingly
			if (eleCheck[i].isSelected())
			{
				switch(i)
				{
					case 1:
						System.out.println("Java Selected");
						break;
					case 2:
						System.out.println("VB Selected");
						break;
					case 3:
						System.out.println("SQL Selected");
						break;
					case 4:
						System.out.println("C Selected");
						break;
					case 5:
						System.out.println("C++ Selected");
						break;
					default:
						break;
				}
			}
		}
		
		//Question 2
		isChecked = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following-sibling::input")).isSelected();
		if (isChecked)
			System.out.println("Selenium is Selected");
		else
			System.out.println("Selenium is Not Selected");
		
		//Question 3 - Deselect the selected
		driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following-sibling::input)[2]")).click();
		isChecked = driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following-sibling::input)[2]")).isSelected();
		
		if (isChecked)
			System.out.println("I am Selected is Selected");
		else
			System.out.println("I am Selected is Not Selected");
		
		//Question 4 - Check all the checkboxes
		for(i=1; i<eleCheckAll.length; i++)
		{
			eleCheckAll[i] = driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following-sibling::input)["+i+"]"));
			eleCheckAll[i].click(); //Select the Checkbox
			//driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[4]/input["+i+"]")).click();
		}
		
		// Count how many checkboxes are selected
		for(i=1; i<eleCheckAll.length; i++)
		{
			if (eleCheckAll[i].isSelected())
				checkboxSelected++;
		}
		
		//Display the details based on the checkboxSelected
		if (checkboxSelected < (eleCheckAll.length - 1))
			System.out.println("All Checkbox is Selected");
		else
			System.out.println("Not all is Selected");
		
		driver.close();
	}

}
