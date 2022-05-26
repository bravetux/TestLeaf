package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 */
public class EditLead
{
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException
	{
		String username = "DemoSalesManager";
		String password = "crmsfa";

		// Setup WebDriver Manager's Chrome Driver
		WebDriverManager.chromedriver().setup();

		// Open the browser
		ChromeDriver driver = new ChromeDriver();

		// Open the link
		driver.get("http://leaftaps.com/opentaps/control/login");

		// Maximize the Browser window
		driver.manage().window().maximize();

		// Login using username and password
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		// Click Submit button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click Link Text CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click Tab Leads
		driver.findElement(By.linkText("Leads")).click();

		// Click Find leads
        driver.findElement ( By.linkText ( "Find Leads" ) ).click ( );
        
        // Enter first name
        driver.findElement(By.xpath("//div[@id='x-form-el-ext-gen248']//input[@name='firstName']")).sendKeys("Bharat");

        // Click Find leads
        driver.findElement ( By.xpath("//button[text()='Find Leads']")).click ( );
        
        Thread.sleep(2000);
        
        // Capture lead ID of First Resulting lead
        WebElement eleLeadId = driver.findElement ( By.xpath ( "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a" ) );

        //Retrieve the Text of Lead ID
        String leadId = eleLeadId.getText ( );
        System.out.println ( "First Resulting lead ID is : " + leadId );

        //Click First Resulting lead
        eleLeadId.click ( );
        
        //Verify title of the page
        System.out.println("Title: " + driver.getTitle());
        if (driver.getTitle().contains("View Lead"))
        {
        	System.out.println("Title Matches ");
        } 
        else
        {
        	System.out.println("Title Doesnt Matches ");
        }

        // Click Edit
        driver.findElement ( By.xpath ( "//div[@class='frameSectionExtra']//a[@class='subMenuButton'][3]" ) ).click ( );

        // Update the company Name
        driver.findElement ( By.id("updateLeadForm_companyName") ).clear();
        driver.findElement ( By.id("updateLeadForm_companyName") ).sendKeys ( "TestLead" );
       
        //Click Update
        driver.findElement ( By.name ( "submitButton" ) ).click ( );
       
        //Validate Company Name
        String Company = driver.findElement( By.id("viewLead_companyName_sp")).getText();
        if (Company.contains("TestLead"))
        {
       		System.out.println("TestLead Company Name Verified");
        }
        else
        {
    	   System.out.println("TestLead Company Name Not Changed");
        }
       
        // Close the browser (Do not log out)
        driver.close ( );
	}
}
