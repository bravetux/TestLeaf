/**
 *
 */
package temp;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class DeleteLead extends BaseClass
{
    /**
     * @param args
     * @throws InterruptedException
     */
	@Test(dataProvider = "getData")
    public void deleteLead (String dCountryCode, String dAreaCode, String dPhoneNumber) throws InterruptedException
    {
        driver.findElement ( By.linkText ( "Leads" ) ).click ( );
        driver.findElement ( By.linkText ( "Find Leads" ) ).click ( );
        driver.findElement ( By.xpath ( "(//span[@class='x-tab-strip-text '])[2]" ) ).click ( );
        driver.findElement ( By.xpath ( "//input[@name='phoneCountryCode']" ) ).clear ( );
        driver.findElement ( By.xpath ( "//input[@name='phoneCountryCode']" ) ).sendKeys ( dCountryCode );
        driver.findElement ( By.xpath ( "//input[@name='phoneAreaCode']" ) ).clear ( );
        driver.findElement ( By.xpath ( "//input[@name='phoneAreaCode']" ) ).sendKeys ( dAreaCode );
        driver.findElement ( By.xpath ( "//input[@name='phoneNumber']" ) ).clear ( );
        driver.findElement ( By.xpath ( "//input[@name='phoneNumber']" ) ).sendKeys ( dPhoneNumber );
        driver.findElement ( By.xpath ( "//button[text()='Find Leads']" ) ).click ( );

        Thread.sleep ( 2000 );
        //11 Capture lead ID of First Resulting lead
        WebElement eleLeadId = driver.findElement ( By.xpath ( "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a" ) );

        String leadId = eleLeadId.getText ( );
        System.out.println ( "First Resulting lead ID is : " + leadId );

        //12 Click First Resulting lead
        eleLeadId.click ( );

        //13 Click Delete
        driver.findElement ( By.xpath ( "//a[@class='subMenuButtonDangerous']" ) ).click ( );

        //14 Click Find leads
        driver.findElement ( By.xpath ( "//ul[@class='shortcuts']/li/a[text()='Find Leads']" ) ).click ( );

        //15 Enter captured lead ID
        driver.findElement ( By.xpath ( "(//div[@class='x-form-item x-tab-item']/div/input[@class=' x-form-text x-form-field'])[1]" ) ).sendKeys ( leadId );
        //Thread.sleep(2000);

        //16 Click find leads button
        driver.findElement ( By.xpath ( "//button[text()='Find Leads']" ) ).click ( );

        //17 Verify message "No records to display" in the Lead List. This message confirms the successful deletion
        String deletedMsg = driver.findElement ( By.xpath ( "//div[contains(text(),'No records ')]" ) ).getText ( );

        if ( deletedMsg.equalsIgnoreCase ( "No records to display" ) )
        {
            System.out.println ( "Sucessfully Deleted the Lead ID: " + leadId );
        }
        else
        {
            System.out.println ( "Lead ID not Deleted: Actual Text Found " + deletedMsg );
        }

        //Webdriver close
        //@AfterMethod - postCondition in BaseClass
    }
	
	@DataProvider(name = "getData")
	public String[][] fetchData() throws IOException 
	{
		return ReadXLSX.readData("DeleteLead");
	}
}
