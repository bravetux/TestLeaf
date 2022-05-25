/**
 *
 */
package week2.day2.assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class acmeTest
{
    /**
     * @param args
     */
    public static void main (String[] args)
    {
        //Setup Webdriver
        WebDriverManager.chromedriver ( ).setup ( );
        ChromeDriver driver = new ChromeDriver ( );
        driver.manage ( ).window ( ).maximize ( );
        driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 30 ) );

        //1. Load url "https://acme-test.uipath.com/login"
        driver.get ( "https://acme-test.uipath.com/login" );

        //2. Enter email as "kumar.testleaf@gmail.com"
        driver.findElement ( By.xpath ( "//input[@name='email']" ) ).sendKeys ( "kumar.testleaf@gmail.com" );

        //3. Enter Password as "leaf@12"
        driver.findElement ( By.xpath ( "//input[@name='password']" ) ).sendKeys ( "leaf@12" );

        //4. Click login button
        driver.findElement ( By.xpath ( "//button[contains(text(),'Login')]" ) ).click ( );

        //5. Get the title of the page and print
        String strTitle = driver.getTitle ( );
        System.out.println ( "Title of the page: " + strTitle );

        //6. Click on Log Out
        driver.findElement ( By.xpath ( "//a[text()='Log Out']" ) ).click ( );

        //7. Close the browser (use -driver.close())
        driver.close ( );
    }
}
