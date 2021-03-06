package ca.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepsDefinition
{
	public ChromeDriver driver;
	public String leadId;			//Delete Lead
	public WebElement eleLeadId;	
	public WebElement eleFirstLead; //Duplicate Lead
	public String strFirstLead;

	@Given("Open the Chrome Webbrowser")
	public void openChromeBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Given("Load the application URL {string}")
	public void loadApplicationURL(String url)
	{
		driver.get(url);
	}

	@Given("Enter the username string {string}") //Can accept any data
	public void enterUsername(String uName)
	{
		//2. Enter UserName Using Id Locator
		driver.findElement ( By.id ( "username" ) ).sendKeys ( uName );
	}

	@Given("Enter the password string {string}")
	public void enterPassword(String pwd)
	{
		//3. Enter Password Using Id Locator
		driver.findElement ( By.id ( "password" ) ).sendKeys ( pwd );
	}

	@When("Click on the Login Button.")
	public void clickLogin()
	{
		//4. Click on Login Button using Class Locator
		driver.findElement ( By.className ( "decorativeSubmit" ) ).click ( );
	}

	@Then("Check the Page Title.")
	public void verifyHomepage()
	{
		//Verify Home Page Title
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@Then("Click on contacts Button")
	public void clickContactsButton()
	{
		//6. Click on contacts Button
		System.out.println("Click on contacts Button");
		driver.findElement ( By.linkText("Contacts")).click ( );

	}

	@Then("Click on Create Contact By LinkText")
	public void clickCreateContactButton()
	{
		//7. Click on Create Contact
		driver.findElement ( By.linkText ( "Create Contact" ) ).click ( );
		//driver.findElement(By.xpath("//a[@href='/crmsfa/control/createContactForm']")).click ( );
		System.out.println("Click on Create Contact");
	}

	@Given("Enter FirstName Field Using id Locator {string}")
	public void enterFirstNameUsingID(String clfname )
	{
		//8. Enter FirstName Field Using id Locator
		driver.findElement ( By.id ( "firstNameField" ) ).sendKeys ( clfname );
		System.out.println("Enter FirstName Field Using id Locator");
	}

	@Given("Enter LastName Field Using id Locator {string}")
	public void enterLastNameUsingID(String cllname)
	{
		//9. Enter LastName Field Using id Locator
		driver.findElement ( By.id ( "lastNameField" ) ).sendKeys ( cllname );
	}

	@Given("Enter FirstName Local Field Using id Locator {string}")
	public void enterFirstNameLocalUsingID(String cfnameLocal)
	{
		//10. Enter FirstName(Local) Field Using id Locator
		driver.findElement ( By.id ( "createContactForm_firstNameLocal" ) ).sendKeys ( cfnameLocal );
	}

	@Given("Enter LastName Local Field Using id Locator {string}")
	public void enterLastNameLocalUsingID(String clnameLocal)
	{
		//11. Enter LastName(Local) Field Using id Locator
		driver.findElement ( By.id ( "createContactForm_lastNameLocal" ) ).sendKeys ( clnameLocal );
	}

	@Given("Enter Department Field Using id Locator {string}")
	public void enterDepartmentFieldUsingID(String cdepartment)
	{
		//12. Enter Department Field Using any Locator of Your Choice
		driver.findElement ( By.id ( "createContactForm_departmentName" ) ).sendKeys ( cdepartment );
	}

	@Given("Enter Description Field Using id Locator {string}")
	public void enterDescriptionFieldUsingID(String cdescription)
	{
		//13. Enter Description Field Using any Locator of your choice
		driver.findElement ( By.id ( "createContactForm_description" ) ).sendKeys ( cdescription );
	}

	@Given("Enter your email in the E-mail address Field using id Locator {string}")
	public void enterEmailAddressUsingID(String cemail)
	{
		//14. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement ( By.id ( "createContactForm_primaryEmail" ) ).sendKeys ( cemail );
	}

	@Given("Select State or Province as NewYork Using Visible Text")
	public void enterStateUsingID()
	{
		//15. Select State/Province as NewYork Using Visible Text
		Select province = new Select ( driver.findElement ( By.id ( "createContactForm_generalStateProvinceGeoId" ) ) );
		province.selectByVisibleText ( "New York" );
	}

	@When("Click on Create Contact By Name")
	public void clickCreateContactByName()
	{
		//16. Click on Create Contact
		driver.findElement ( By.name ( "submitButton" ) ).click ( );
	}

	@When("Click on edit button")
	public void clickEditButton()
	{
		//17. Click on edit button
		driver.findElement ( By.linkText ( "Edit" ) ).click ( );
	}

	@Then("Clear the Description Field using .clear")
	public void clearDescriptionUsingID()
	{
		//18. Clear the Description Field using .clear
		driver.findElement ( By.id ( "updateContactForm_description" ) ).clear ( );
	}

	@Then("Fill ImportantNote Field with Any text {string}")
	public void fillImportantNoteUsingID(String cimportant)
	{
		//19. Fill ImportantNote Field with Any text
		driver.findElement ( By.id ( "updateContactForm_importantNote" ) ).sendKeys ( cimportant );
	}

	@When("Click on update button using Xpath locator")
	public void clickUpdateButtonUsingXPATH()
	{
		//20. Click on update button using Xpath locator
		driver.findElement ( By.xpath ( "//input[@name='submitButton']" ) ).click ( );
	}

	@Then("Get the Title of Resulting Page")
	public void getTitleofResultingPage()
	{
		//21. Get the Title of Resulting Page
		System.out.println ( "Title of the resulting Page: " + driver.getTitle ( ) );
	}

	@Then("Click on Leads Button")
	public void clickOnleadsButtonUsingLinkText()
	{
		driver.findElement ( By.linkText ( "Leads" ) ).click ( );
	}

	@When("Click on Find Leads Using LinkText")
	public void clickFindLeadsUsingLinkText()
	{
		driver.findElement ( By.linkText ( "Find Leads" ) ).click ( );
	}

	@When("Click on Phone")
	public void clickPhoneUsingXPATH()
	{
		driver.findElement ( By.xpath ( "(//span[@class='x-tab-strip-text '])[2]" ) ).click ( );
	}

	@Given("Enter phone number country code {string}")
	public void enterPhoneNumberCountryCode(String dCountryCode)
	{
		driver.findElement ( By.xpath ( "//input[@name='phoneCountryCode']" ) ).clear ( );
		driver.findElement ( By.xpath ( "//input[@name='phoneCountryCode']" ) ).sendKeys ( dCountryCode );
	}

	@Given("Enter phone number area code {string}")
	public void enterPhoneNumberAreaCode(String dAreaCode)
	{
		driver.findElement ( By.xpath ( "//input[@name='phoneAreaCode']" ) ).clear ( );
		driver.findElement ( By.xpath ( "//input[@name='phoneAreaCode']" ) ).sendKeys ( dAreaCode );
	}

	@Given("Enter phone number {string}")
	public void enterPhoneNumber(String dPhoneNumber)
	{
		driver.findElement ( By.xpath ( "//input[@name='phoneNumber']" ) ).clear ( );
		driver.findElement ( By.xpath ( "//input[@name='phoneNumber']" ) ).sendKeys ( dPhoneNumber );
	}

	@When("Click find leads button using XPATH")
	public void clickFindLeadsUsingXPATH()
	{
		driver.findElement ( By.xpath ( "//button[text()='Find Leads']" ) ).click ( );
	}

	@Then("Capture lead ID of First Resulting lead")
	public void CaptureLeadIdOfFirstResultingLead() throws InterruptedException
	{
		Thread.sleep ( 2000 );
		//11 Capture lead ID of First Resulting lead
		eleLeadId = driver.findElement ( By.xpath ( "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a" ) );
		leadId = eleLeadId.getText ( );
		System.out.println ( "First Resulting lead ID is : " + leadId );
	}

	@Then("Click First Resulting lead")
	public void clickFirstResultingLead()
	{
		//12 Click First Resulting lead
		eleLeadId.click ( );
	}

	@Then("Click Delete")
	public void clickDelete()
	{
		//13 Click Delete
		driver.findElement ( By.xpath ( "//a[@class='subMenuButtonDangerous']" ) ).click ( );
	}

	@Then("Click Find leads page")
	public void clickFindLeadsPage()
	{
		//14 Click Find leads
		driver.findElement ( By.xpath ( "//ul[@class='shortcuts']/li/a[text()='Find Leads']" ) ).click ( );

	}

	@Then("Enter captured lead ID")
	public void enterCaptureLeadId()
	{
		//15 Enter captured lead ID
		driver.findElement ( By.xpath ( "(//div[@class='x-form-item x-tab-item']/div/input[@class=' x-form-text x-form-field'])[1]" ) ).sendKeys (leadId);
	}

	@Then("Verify message")
	public void verifyMsgAfterDeletingLead()
	{
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
	}
	@When ("Click on Email Using Xpath")
	public void clickOnEmailUsingXPATH()
	{
		//8  Click on Email
		driver.findElement ( By.xpath ( "//span[text()='Email']" ) ).click ( );
	}

	@Given ("Enter Email Using XPATH {string}")
	public void enterEmailId(String duEmailID)
	{
		//9  Enter Email
		driver.findElement ( By.xpath ( "//input[@name='emailAddress']" ) ).sendKeys ( duEmailID );
	}

	@Then ("Capture name of First Resulting lead")
	public void captureNameOfFirstResultingLead()
	{
		eleFirstLead =
				driver.findElement ( By.xpath ( "//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a" ) );
		strFirstLead = eleFirstLead.getText ( );

		System.out.println ( "Duplicate Lead: " + strFirstLead );
	}

	@When ("Click First Resulting duplicate lead")
	public void clickFirstResultingDuplicateLead()
	{
		eleFirstLead.click ( );
	}

	@Then ("Click Duplicate Lead")
	public void clickDuplicateLead()
	{
		driver.findElement ( By.xpath ( "(//div[@class='frameSectionExtra']/a)[1]" ) ).click ( );
	}

	@Then ("Verify the title as Duplicate Lead")
	public void verifyTitleAsDuplicateLead()
	{
		String strTitle = driver.getTitle ( );
		if ( strTitle.contains ( "Duplicate Lead" ) )
		{
			System.out.println ( "Matches Title: " + strTitle );
		}
		else
		{
			System.out.println ( "Title FAILED to Match: " + strTitle );
		}
	}

	@Then ("Click Create Lead smallSubmit")
	public void clickCreateLeadsmallSubmit()
	{
		//15 Click Create Lead
		driver.findElement ( By.xpath ( "//input[@class='smallSubmit']" ) ).click ( );
	}

	@Then ("Confirm the duplicate Lead Name")
	public void confirmTheDuplicateLeadName()
	{
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

	@When("click On Leads Using LinkText")
	public void clickOnLeadsUsingLinkText()
	{
		driver.findElement(By.linkText("Leads")).click();
	}

	@Given("Provide First Name Of Lead {string}")
	public void updateFirstNameOfLead(String eFirstName)
	{
		driver.findElement(By.xpath("//div[@id='x-form-el-ext-gen248']//input[@name='firstName']")).sendKeys(eFirstName);
		driver.findElement(By.xpath("//div[@id='x-form-el-ext-gen250']//input[@name='lastName']")).sendKeys("B");
		driver.findElement(By.xpath("//div[@id='x-form-el-ext-gen252']//input[@name='companyName']")).sendKeys("TestLeaf");
	}

	@Then("Clicked Find Leads")
	public void clickedFindLeads() throws InterruptedException
	{
		driver.findElement ( By.xpath("//button[text()='Find Leads']")).click ( );
		Thread.sleep(2000);
	}

	@Then("Get The Resulting Lead Id")
	public void getTheResultingLeadId()
	{
		eleLeadId = driver.findElement ( By.xpath ( "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a" ) );
		leadId = eleLeadId.getText ( );
		System.out.println ( "First Resulting lead ID is : " + leadId );

		System.out.println("Title: " + driver.getTitle());
		if (driver.getTitle().contains("Find Leads"))
		{
			System.out.println("Title Matches ");
		} 
		else
		{
			System.out.println("Title Doesnt Matches ");
		}
		
		eleLeadId.click ( );
	}

	@When ("Click Edit Button")
	public void clickEditSubMenuButton()
	{
		// Click Edit
		driver.findElement ( By.xpath ( "//div[@class='frameSectionExtra']//a[@class='subMenuButton'][3]" ) ).click ( );
	}

	@Then ("Update the company Name {string}")
	public void updateTheCompanyNam(String eCompany)
	{
		// Update the company Name
		driver.findElement ( By.id("updateLeadForm_companyName") ).clear();
		driver.findElement ( By.id("updateLeadForm_companyName") ).sendKeys ( eCompany );
	}

	@Then ("Click Update submitButton")
	public void clickUpdateSubmitButton()
	{
		//Click Update
		driver.findElement ( By.name ( "submitButton" ) ).click ( );
	}

	@Then ("Check And Validate Company Name")
	public void checkAndValidateCompanyName()
	{
		//Validate Company Name
		String Company = driver.findElement( By.id("viewLead_companyName_sp")).getText();
		if (Company.contains("TestLead"))
		{
			System.out.println("TestLead Company Name Verified");
		}
		else
		{
			System.out.println("TestLead Company Name Not Changed");
		}
	}

}
