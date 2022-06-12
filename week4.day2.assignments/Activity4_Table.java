/**
 * 
 */
package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class Activity4_Table
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Setup Chrome Driver
		WebDriverManager.chromedriver().setup();
		
		//Setup Chrome Driver Options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--notifications-disabled");
		options.addArguments("--headless");
		
		//Initialise Chrome Driver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Get the URL
		driver.get("http://www.leafground.com/pages/table.html");
		
		//Print Headers of a Table  ------------------------------------
		String tableData = driver.findElement(By.xpath("//table//tr[1]/th[1]")).getText();
		System.out.println("Table Header C1: " + tableData);
		
		tableData = driver.findElement(By.xpath("//table//tr[1]/th[2]")).getText();
		System.out.println("Table Header C2: " + tableData);
		
		tableData = driver.findElement(By.xpath("//table//tr[1]/th[3]")).getText();
		System.out.println("Table Header C3: " + tableData);
		
		//Print Specific Element of a Row ------------------------------------
		tableData = driver.findElement(By.xpath("//table//tr[2]/td[1]")).getText();
		System.out.println("Table Data C1: " + tableData);
		
		tableData = driver.findElement(By.xpath("//table//tr[2]/td[2]")).getText();
		System.out.println("Table Data C2: " + tableData);
		
		//Empty Field of Text
		tableData = driver.findElement(By.xpath("//table//tr[2]/td[3]")).getText();
		System.out.println("Table Data C3: " + tableData);
		
		//Count the number of rows - including Header
		List<WebElement> rowCountWithHeader = driver.findElements(By.xpath("//table//tr"));
		System.out.println("Row Count = " + rowCountWithHeader.size());
		int rowSize = rowCountWithHeader.size()-1;
		
		//Count the number of columns using header
		List<WebElement> colCount = driver.findElements(By.xpath("//table//tr/th"));
		System.out.println("Column Count = " + colCount.size());
		
		//Get the progress value of 'Learn to interact with Elements'
		String details = null;
		for (int i=2; i<= rowSize; i++ )
		{
			details = driver.findElement(By.xpath("//table//tr[" + i + "]/td[1]")).getText();
			if (details.contentEquals("Learn to interact with Elements"))
			{	
				//System.out.println("Row: " + i );
				for (int j = 1; j <= 2; j++)
				{
					details = driver
							.findElement(By.xpath("//table//tr[" + i + "]/td[" + j + "]"))
							.getText();
					System.out.print( details + ": ");
				}	
				System.out.println("");
			}
			
		}
		List<Integer> progressList  = new ArrayList<Integer>();
		List<Integer> progressListOriginal  = new ArrayList<Integer>();
		String tempSplit = null;
		
		//Check the vital task for the least completed progress.
		for (int i = 2; i<=rowCountWithHeader.size(); i++ ) 
		{
			String temp = driver.findElement(By.xpath("//table//tr[" + i + "]//td[2]")).getText();
			String[] tempOfStr =  temp.split("%", 2);
			int leastProgress = Integer.parseInt(tempOfStr[0]);
			
			progressList.add(leastProgress);
		}
		
		progressListOriginal.addAll(progressList);
		Collections.sort(progressList);
		System.out.println("Least Progress Value: " + progressList.get(0));
		
		//Find the index of Least Progress Value - Excluding the header
		int indexOfProgressValue = 0;
		for(int i = 0; i <progressListOriginal.size(); i++)
		{
			//System.out.println("index: " + i + " O: " + progressListOriginal.get(i) + " S: " + progressList.get(0));
			if (progressListOriginal.get(i) == progressList.get(0))
			{
				//Since Index is starting from 0, increment by 1 
				//xpath starts from 1, increment by 1
				//So we to increment by 2, as we are going to use this value in xpath
				indexOfProgressValue = i+2; 
				break;
			}
		}
		
		System.out.println("Least Progress Value Index = " + indexOfProgressValue);
		
		WebElement checkbox = driver.findElement(By.xpath("//table//tr[" + indexOfProgressValue + "]//td[3]/input[@name='vital']"));
		//Enable Checkbox
		checkbox.click();
		
		if (checkbox.isSelected())
			System.out.println("Checkbox of least Progress Value - Vital Selected");
		else
			System.out.println("Checkbox of least Progress Value - Vital is not Selected");
	}
		
}

