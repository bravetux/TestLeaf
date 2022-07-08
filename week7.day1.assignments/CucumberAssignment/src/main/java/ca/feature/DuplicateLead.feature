Feature: Login into the Website

Background:
Given Open the Chrome Webbrowser
Given Load the application URL 'http://leaftaps.com/opentaps'
Given Enter the username string 'Demosalesmanager'
Given Enter the password string 'crmsfa'
When Click on the Login Button.
Then Check the Page Title.

Scenario: Duplicate Lead Test Case
When Click on Leads Button
When Click on Find Leads Using LinkText
When Click on Email Using Xpath
Given Enter Email Using XPATH 'vigneshkumarb@bravetux.com'
Then Click Find leads page
Then Capture name of First Resulting lead
When Click First Resulting duplicate lead
Then Click Duplicate Lead
Then Verify the title as Duplicate Lead
Then Click Create Lead smallSubmit
Then Confirm the duplicate Lead Name
