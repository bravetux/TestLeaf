/**
 *
 */
package week2.day2.assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class FaceBook
{
    /**
     * @param args
     */
    public static void main (String[] args)
    {
        // Step 1: Download and set the path
        //System.setProperty("webdirver.chrome.driver", "C:\\<path>\\chromdriver.exe");

        // Setup WebDriver Manager's Chrome Driver
        WebDriverManager.chromedriver ( ).setup ( );

        // Step 2: Launch the chromebrowser
        ChromeDriver driver = new ChromeDriver ( );

        // Step 3: Load the URL
        driver.get ( "https://en-gb.facebook.com/" );

        // Step 4: Maximise the window
        driver.manage ( ).window ( ).maximize ( );

        // Step 5: Add implicit wait
        driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 30 ) );

        // Step 6: Click on Create New Account button
        driver.findElement ( By.xpath ( "//a[contains(text(), 'Create New Account')]" ) ).click ( );

        // Step 7: Enter the first name
        driver.findElement ( By.xpath ( "//input[@name='firstname']" ) ).clear ( );
        driver.findElement ( By.xpath ( "//input[@name='firstname']" ) ).sendKeys ( "Vignesh" );

        // Step 8: Enter the last name
        driver.findElement ( By.xpath ( "//input[@name='lastname']" ) ).clear ( );
        driver.findElement ( By.xpath ( "//input[@name='lastname']" ) ).sendKeys ( "B" );

        // Step 9: Enter the mobile number
        driver.findElement ( By.xpath ( "//input[@name='reg_email__']" ) ).sendKeys ( "9444530846" );

        // Step 10: Enter the password
        driver.findElement ( By.xpath ( "//input[@name='reg_passwd__']" ) ).sendKeys ( "9444530846" );

        // Step 11: Handle all the three drop downs
        //Handle Day
        Select selDay = new Select ( driver.findElement ( By.xpath ( "//select[@name='birthday_day']" ) ) );
        selDay.selectByValue ( "4" );

        //Handle Month
        Select selMonth = new Select ( driver.findElement ( By.xpath ( "//select[@name='birthday_month']" ) ) );
        selMonth.selectByValue ( "4" );

        //Handle Year
        Select selYear = new Select ( driver.findElement ( By.xpath ( "//select[@name='birthday_year']" ) ) );
        selYear.selectByValue ( "1991" );

        // Step 12: Select the radio button "Female" - ( A normal click will do for this step)
        driver.findElement ( By.xpath ( "//input[@value=1]" ) ).click ( );
    }

}
