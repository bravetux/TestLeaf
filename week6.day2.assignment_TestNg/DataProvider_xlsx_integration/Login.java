/**
 * @author vignesh
 *
 */
package week6.day2.assignment.dataprovider.xlsx.integration;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends BaseClass
{

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "getData")
	public  void createLead(String cname, String cfname, String clname) throws InterruptedException
	{
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(cfname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(clname);
		
		//Identify Source DropDown
		WebElement element = driver.findElement(By.id("createLeadForm_dataSourceId"));
		
		//Create Select Object
		//Pass the WebElement object to Select Constructor
		Select source = new Select(element);
		
		//Select by Visible Text
		source.selectByVisibleText("Conference");
		
		//Click the Submit Button
		driver.findElement(By.name("submitButton")).click();
		
		Thread.sleep(2000);
		
		String firstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();

		if (firstName.equals(cfname))
		{
			System.out.println("Validation of First Name Success");
		}
		else
		{
			System.out.println("Validation of First Name Failed");
		}
		
		driver.close();

	}
	
	//If data provider is given a name, that name has to be
	// referenced with @Test
	//
	// Static Function Call is invoked to read the xlsx data and store in String[][] structure
	// and return the same.
	// Since the Class ReadXLSX throws IOException, that exception should be added here as well.
	@DataProvider(name = "getData")
	public String[][] fetchData() throws IOException 
	{
		return ReadXLSX.readData("CreateLead");
	}

}
