package ca.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@CucumberOptions(features = "src/main/java/ca/feature/CreateContact.feature",
//@CucumberOptions(features = "src/main/java/ca/feature/DeleteLead.feature",
//@CucumberOptions(features = "src/main/java/ca/feature/DuplicateLead.feature",
@CucumberOptions(features = "src/main/java/ca/feature/EditLead.feature",
				 glue = "ca/steps",
				 monochrome = true,
				 publish = true)
public class CucumberRunner extends AbstractTestNGCucumberTests
{
	
}
