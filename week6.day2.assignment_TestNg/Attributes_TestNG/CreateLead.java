/**
 * 
 */
package week6.day2.assignment.attributes;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 *
 */
public class CreateLead extends BaseClass
{
	/**
	 * @param args
	 */
	@Test(enabled = true, invocationCount = 50)
	@Parameters({"clfname", "cllname", "cfnameLocal", "cdescription", "cdepartment", "cemail", "cPhoneNumber"})
    public void createLead (String clfname, String cllname, String cfnameLocal, 
    		 String cdescription, String cdepartment, String cemail, @Optional("9444530846") String cPhoneNumber)
    {
		//Click Tab Leads
		driver.findElement(By.linkText("Leads")).click();

		//Click the Link Create Lead
		driver.findElement(By.linkText("Create Lead")).click();

		//Enter CompanyName Field Using id Locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");

		//Enter FirstName Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(clfname);

		//Enter LastName Field Using id Locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(cllname);

		//Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(cfnameLocal);

		//Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(cdepartment);

		//Enter Description Field Using any Locator of your choice 
		driver.findElement(By.id("createLeadForm_description")).sendKeys(cdescription);

		//Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(cemail);
		
        //15a. Provide Phone Number
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).clear();
        driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(cPhoneNumber);
		
        //Create Select class object and initialize the constructor with WebElement name
		Select province = new Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));

		//Select State/Province as NewYork Using Visible Text
		province.selectByVisibleText("New York");

		//Click on Create Button
		driver.findElement(By.name("submitButton")).click();

		//Get the Title of Resulting Page. refer the video  using driver.getTitle()
		System.out.println("Title of the resulting Page: " + driver.getTitle());
	}
}
