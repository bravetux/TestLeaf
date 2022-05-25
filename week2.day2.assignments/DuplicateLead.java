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
public class DuplicateLead
{

    /**
     * @param args
     */
    public static void main (String[] args)
    {
        String username = "DemoSalesManager";
        String password = "crmsfa";


        //Setup WebDriver Manager's Chrome Driver
        WebDriverManager.chromedriver ( ).setup ( );

        //1  Launch the browser
        ChromeDriver driver = new ChromeDriver ( );

        //Open the URL
        driver.get ( "http://leaftaps.com/opentaps/control/login" );

        //Maximize the browser
        driver.manage ( ).window ( ).maximize ( );

        //Increase the implicit wait time to 30seconds
        driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 30 ) );

        //2  Enter the username
        driver.findElement ( By.id ( "username" ) ).sendKeys ( username );

        //3  Enter the password
        driver.findElement ( By.id ( "password" ) ).sendKeys ( password );

        //4  Click Login
        driver.findElement ( By.className ( "decorativeSubmit" ) ).click ( );

        //5  Click crm/sfa link
        driver.findElement ( By.linkText ( "CRM/SFA" ) ).click ( );

        //6  Click Leads link
        driver.findElement ( By.linkText ( "Leads" ) ).click ( );

        //7  Click Find leads
        driver.findElement ( By.linkText ( "Find Leads" ) ).click ( );

        //8  Click on Email
        driver.findElement ( By.xpath ( "//span[text()='Email']" ) ).click ( );

        //9  Enter Email
        driver.findElement ( By.xpath ( "//input[@name='emailAddress']" ) ).sendKeys ( "babu@testleaf.com" );

        //10 Click find leads button

        driver.findElement ( By.xpath ( "//ul[@class='shortcuts']/li/a[text()='Find Leads']" ) ).click ( );

        //11 Capture name of First Resulting lead
        WebElement eleFirstLead =
                driver.findElement ( By.xpath ( "//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a" ) );
        String strFirstLead = eleFirstLead.getText ( );

        System.out.println ( "Duplicate Lead: " + strFirstLead );

        //12 Click First Resulting lead
        eleFirstLead.click ( );

        //13 Click Duplicate Lead
        driver.findElement ( By.xpath ( "(//div[@class='frameSectionExtra']/a)[1]" ) ).click ( );


        //14 Verify the title as 'Duplicate Lead'
        String strTitle = driver.getTitle ( );
        if ( strTitle.contains ( "Duplicate Lead" ) )
        {
            System.out.println ( "Matches Title: " + strTitle );
        }
        else
        {
            System.out.println ( "Title FAILED to Match: " + strTitle );
        }

        //15 Click Create Lead
        driver.findElement ( By.xpath ( "//input[@class='smallSubmit']" ) ).click ( );

        //16 Confirm the duplicated lead name is same as captured name
        WebElement verifyFirstName = driver.findElement ( By.id ( "viewLead_firstName_sp" ) );


        if ( strFirstLead.equalsIgnoreCase ( verifyFirstName.getText ( ) ) )
        {
            System.out.println ( "Duplicate Lead Name Verified " + strFirstLead );
        }
        else
        {
            System.out.println ( "Duplicate Lead Couldnt be Verified " + strFirstLead );
        }

        //17 Close the browser (Do not log out)
        driver.close ( );
    }

}
