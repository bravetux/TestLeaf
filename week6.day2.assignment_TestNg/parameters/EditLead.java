package week6.day2.assignment1.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
	@Test
	@Parameters({"eFirstName"})
	public void editLead(String eFirstName) throws InterruptedException
	{
    	//Steps 1 to 5 - moving them to the baseClass 
    	//@BeforeMethod - preCondition

		// 6. Click Tab Leads
		driver.findElement(By.linkText("Leads")).click();

		// 7. Click Find leads
        driver.findElement ( By.linkText ( "Find Leads" ) ).click ( );
        
        // 8. Enter first name
        driver.findElement(By.xpath("//div[@id='x-form-el-ext-gen248']//input[@name='firstName']")).sendKeys(eFirstName);

        // 9. Click Find leads
        driver.findElement ( By.xpath("//button[text()='Find Leads']")).click ( );
        
        Thread.sleep(2000);
        
        // 10. Capture lead ID of First Resulting lead
        WebElement eleLeadId = driver.findElement ( By.xpath ( "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a" ) );

        // 11. Retrieve the Text of Lead ID
        String leadId = eleLeadId.getText ( );
        System.out.println ( "First Resulting lead ID is : " + leadId );

        // 12. Click First Resulting lead
        eleLeadId.click ( );
        
        // 13. Verify title of the page
        System.out.println("Title: " + driver.getTitle());
        if (driver.getTitle().contains("View Lead"))
        {
        	System.out.println("Title Matches ");
        } 
        else
        {
        	System.out.println("Title Doesnt Matches ");
        }

        // 14. Click Edit
        driver.findElement ( By.xpath ( "//div[@class='frameSectionExtra']//a[@class='subMenuButton'][3]" ) ).click ( );

        // 15. Update the company Name
        driver.findElement ( By.id("updateLeadForm_companyName") ).clear();
        driver.findElement ( By.id("updateLeadForm_companyName") ).sendKeys ( "TestLead" );
       
        // 16. Click Update
        driver.findElement ( By.name ( "submitButton" ) ).click ( );
       
        // 17. Validate Company Name
        String Company = driver.findElement( By.id("viewLead_companyName_sp")).getText();
        if (Company.contains("TestLead"))
        {
       		System.out.println("TestLead Company Name Verified");
        }
        else
        {
    	   System.out.println("TestLead Company Name Not Changed");
        }
       
        //18. Webdriver close
        //@AfterMethod - postCondition in BaseClass
	}
}
