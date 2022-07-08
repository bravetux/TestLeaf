/**
 * 
 */
package temp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class BaseClass
{
	public ChromeDriver driver;
	/*
	 *   <parameter name="uname" value="DemoSalesManager"></parameter>
	 *   <parameter name="passwd" value="crmsfa"></parameter>
	 *   <parameter name="url" value="http://leaftaps.com/opentaps/control/login"></parameter>
	 */
	@Parameters({"uname", "passwd", "url"})
	@BeforeMethod
	public void preCondition(String uname, String passwd, String url)
	{
        //Setup WebDriver Manager's Chrome Driver
        WebDriverManager.chromedriver ( ).setup ( );
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver ( options);

        driver.manage ( ).window ( ).maximize ( );
        driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 30 ) );

        //1. Launch URL "http://leaftaps.com/opentaps/control/login"
        driver.get ( url );

        //2 & 3. Enter UserName and Password Using Id Locator
        //Login using username and password
        driver.findElement ( By.id ( "username" ) ).sendKeys ( uname );
        driver.findElement ( By.id ( "password" ) ).sendKeys ( passwd );

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
