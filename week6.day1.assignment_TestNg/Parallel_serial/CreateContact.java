/**
 *
 */
package week6.day1.assignment.parallel.serial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class CreateContact extends BaseClass
{

    /**
     * @param args
     */
	@Test
    public void createLead ()
    {
    	//Steps 1 to 5 - moving them to the baseClass 
    	//@BeforeMethod - preCondition

        //6. Click on contacts Button
        driver.findElement ( By.linkText ( "Contacts" ) ).click ( );

        //7. Click on Create Contact
        driver.findElement ( By.linkText ( "Create Contact" ) ).click ( );

        //8. Enter FirstName Field Using id Locator
        driver.findElement ( By.id ( "firstNameField" ) ).sendKeys ( "Vignesh" );

        //9. Enter LastName Field Using id Locator
        driver.findElement ( By.id ( "lastNameField" ) ).sendKeys ( "B" );

        //10. Enter FirstName(Local) Field Using id Locator
        driver.findElement ( By.id ( "createContactForm_firstNameLocal" ) ).sendKeys ( "VigneshKumar" );

        //11. Enter LastName(Local) Field Using id Locator
        driver.findElement ( By.id ( "createContactForm_lastNameLocal" ) ).sendKeys ( "Bagavathsingh" );

        //12. Enter Department Field Using any Locator of Your Choice
        driver.findElement ( By.id ( "createContactForm_departmentName" ) ).sendKeys ( "Computer Science" );

        //13. Enter Description Field Using any Locator of your choice
        driver.findElement ( By.id ( "createContactForm_description" ) ).sendKeys ( "Description Enter here" );

        //14. Enter your email in the E-mail address Field using the locator of your choice
        driver.findElement ( By.id ( "createContactForm_primaryEmail" ) ).sendKeys ( "vigneshkumarb@bravetux.com" );

        //15. Select State/Province as NewYork Using Visible Text
        Select province = new Select ( driver.findElement ( By.id ( "createContactForm_generalStateProvinceGeoId" ) ) );
        province.selectByVisibleText ( "New York" );

        //16. Click on Create Contact
        driver.findElement ( By.name ( "submitButton" ) ).click ( );

        //17. Click on edit button
        driver.findElement ( By.linkText ( "Edit" ) ).click ( );

        //18. Clear the Description Field using .clear
        driver.findElement ( By.id ( "updateContactForm_description" ) ).clear ( );

        //19. Fill ImportantNote Field with Any text
        driver.findElement ( By.id ( "updateContactForm_importantNote" ) ).sendKeys ( "Filling ImportantNote with Data" );

        //20. Click on update button using Xpath locator
        driver.findElement ( By.xpath ( "//input[@name='submitButton']" ) ).click ( );

        //21. Get the Title of Resulting Page
        System.out.println ( "Title of the resulting Page: " + driver.getTitle ( ) );
        
        //Webdriver close
        //@AfterMethod - postCondition in BaseClass

    }

}