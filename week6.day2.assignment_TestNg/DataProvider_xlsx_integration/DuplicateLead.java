/**
 *
 */
package week6.day2.assignment.dataprovider.xlsx.integration;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class DuplicateLead extends BaseClass
{

    /**
     * @param args
     */
	@Test(dataProvider = "getData")
    public void duplicateLead (String duEmailID)
    {
        //6  Click Leads link
        driver.findElement ( By.linkText ( "Leads" ) ).click ( );

        //7  Click Find leads
        driver.findElement ( By.linkText ( "Find Leads" ) ).click ( );

        //8  Click on Email
        driver.findElement ( By.xpath ( "//span[text()='Email']" ) ).click ( );

        //9  Enter Email
        driver.findElement ( By.xpath ( "//input[@name='emailAddress']" ) ).sendKeys ( duEmailID );

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
    }
	
	@DataProvider(name = "getData")
	public String[][] fetchData() throws IOException 
	{
		return ReadXLSX.readData("DuplicateLead");
	}

}
