/**
 *
 */
package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class DeleteLead
{
    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main (String[] args) throws InterruptedException
    {
        String username = "DemoSalesManager";
        String password = "crmsfa";

        //Setup WebDriver Manager's Chrome Driver
        WebDriverManager.chromedriver ( ).setup ( );
        ChromeDriver driver = new ChromeDriver ( );

        //Maximize the browser window
        driver.manage ( ).window ( ).maximize ( );

        //Increase the implicit wait time to 30seconds
        driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 30 ) );

        //1	 Launch the browser
        driver.get ( "http://leaftaps.com/opentaps/control/login" );

        //2. Enter UserName and Password Using Id Locator
        driver.findElement ( By.id ( "username" ) ).sendKeys ( username );

        //3	 Enter the password
        driver.findElement ( By.id ( "password" ) ).sendKeys ( password );

        //4. Click on Login Button using Class Locator
        driver.findElement ( By.className ( "decorativeSubmit" ) ).click ( );

        //5. Click on CRM/SFA Link
        driver.findElement ( By.linkText ( "CRM/SFA" ) ).click ( );

        //6	 Click Leads link
        driver.findElement ( By.linkText ( "Leads" ) ).click ( );

        //7	 Click Find leads
        driver.findElement ( By.linkText ( "Find Leads" ) ).click ( );

        //8	 Click on Phone
        driver.findElement ( By.xpath ( "(//span[@class='x-tab-strip-text '])[2]" ) ).click ( );

        //9	 Enter phone number
        driver.findElement ( By.xpath ( "//input[@name='phoneCountryCode']" ) ).clear ( );
        driver.findElement ( By.xpath ( "//input[@name='phoneCountryCode']" ) ).sendKeys ( "11" );
        driver.findElement ( By.xpath ( "//input[@name='phoneAreaCode']" ) ).clear ( );
        driver.findElement ( By.xpath ( "//input[@name='phoneAreaCode']" ) ).sendKeys ( "682" );
        driver.findElement ( By.xpath ( "//input[@name='phoneNumber']" ) ).clear ( );
        driver.findElement ( By.xpath ( "//input[@name='phoneNumber']" ) ).sendKeys ( "1234567890" );

        //10 Click find leads button
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

        //18 Close the browser (Do not log out)
        driver.close ( );
    }
}
