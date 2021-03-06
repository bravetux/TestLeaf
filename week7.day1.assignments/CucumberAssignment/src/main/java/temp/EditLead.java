package temp;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 */
public class EditLead extends BaseClass
{
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "getData")
	public void editLead(String eFirstName, String eCompany) throws InterruptedException
	{
		driver.findElement(By.linkText("Leads")).click();
        driver.findElement ( By.linkText ( "Find Leads" ) ).click ( );
        driver.findElement(By.xpath("//div[@id='x-form-el-ext-gen248']//input[@name='firstName']")).sendKeys(eFirstName);
        driver.findElement ( By.xpath("//button[text()='Find Leads']")).click ( );
        Thread.sleep(2000);
        WebElement eleLeadId = driver.findElement ( By.xpath ( "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a" ) );
        String leadId = eleLeadId.getText ( );
        System.out.println ( "First Resulting lead ID is : " + leadId );
        eleLeadId.click ( );
        System.out.println("Title: " + driver.getTitle());
        if (driver.getTitle().contains("Find Leads"))
        {
        	System.out.println("Title Matches ");
        } 
        else
        {
        	System.out.println("Title Doesnt Matches ");
        }
        driver.findElement ( By.xpath ( "//div[@class='frameSectionExtra']//a[@class='subMenuButton'][3]" ) ).click ( );
        driver.findElement ( By.id("updateLeadForm_companyName") ).clear();
        driver.findElement ( By.id("updateLeadForm_companyName") ).sendKeys ( eCompany );
        driver.findElement ( By.name ( "submitButton" ) ).click ( );
        String Company = driver.findElement( By.id("viewLead_companyName_sp")).getText();
        if (Company.contains(eCompany))
        {
       		System.out.println("TestLead Company Name Verified");
        }
        else
        {
    	   System.out.println("TestLead Company Name Not Changed");
        }
	}
	
	@DataProvider(name = "getData")
	public String[][] fetchData() throws IOException 
	{
		return ReadXLSX.readData("EditLead");
	}
}
