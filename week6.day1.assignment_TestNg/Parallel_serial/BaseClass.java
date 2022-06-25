/**
 * 
 */
package week6.day1.assignment.parallel.serial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class BaseClass
{
	public ChromeDriver driver;
	@BeforeMethod
	public void preCondition()
	{
		String username = "DemoSalesManager";
        String password = "crmsfa";

        //Setup WebDriver Manager's Chrome Driver
        WebDriverManager.chromedriver ( ).setup ( );
        driver = new ChromeDriver ( );

        driver.manage ( ).window ( ).maximize ( );
        driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 30 ) );

        //1. Launch URL "http://leaftaps.com/opentaps/control/login"
        driver.get ( "http://leaftaps.com/opentaps/control/login" );

        //2 & 3. Enter UserName and Password Using Id Locator
        //Login using username and password
        driver.findElement ( By.id ( "username" ) ).sendKeys ( username );
        driver.findElement ( By.id ( "password" ) ).sendKeys ( password );

        //4. Click on Login Button using Class Locator
        driver.findElement ( By.className ( "decorativeSubmit" ) ).click ( );
        
        //5. Click on CRM/SFA Link
        driver.findElement ( By.linkText ( "CRM/SFA" ) ).click ( );
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.quit();
	}
}
