package week2.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vignesh
 */
public class EditLead
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String username = "DemoSalesManager";
		String password = "crmsfa";

		// Setup WebDriver Manager's Chrome Driver
		WebDriverManager.chromedriver().setup();

		// Open the browser
		ChromeDriver driver = new ChromeDriver();

		// Open the link
		driver.get("http://leaftaps.com/opentaps/control/login");

		// Maximize the Browser window
		driver.manage().window().maximize();

		// Login using username and password
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		// Click Submit button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click Link Text CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click Tab Leads
		driver.findElement(By.linkText("Leads")).click();

		// Click the Link Create Lead
		driver.findElement(By.linkText("Create Lead")).click();

		// Enter CompanyName Field Using id Locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");

		// Enter FirstName Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vignesh");

		// Enter LastName Field Using id Locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("B");

		// Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("VigneshKumar");

		// Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Developers");

		// Enter Description Field Using any Locator of your choice
		driver.findElement(By.id("createLeadForm_description")).sendKeys("This is going great");

		// Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("vigneshkumarb@bravetux.com");

		// Create Select class object and initialize the constructor with WebElement
		// name
		Select province = new Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));

		// Select State/Province as NewYork Using Visible Text
		province.selectByVisibleText("New York");

		// Click on Create Button
		driver.findElement(By.name("submitButton")).click();

		// Click on Edit Button
		driver.findElement(By.linkText("Edit")).click();

		// Clear the Description Field using .clear()
		driver.findElement(By.id("updateLeadForm_description")).clear();

		// Fill ImportantNote Field with Any text
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Filling ImportantNote with Data");

		// Click on update button
		driver.findElement(By.className("smallSubmit")).click();

		// Get the Title of Resulting Page. refer the video using driver.getTitle()
		System.out.println("Title of the resulting Page: " + driver.getTitle());

	}
}
