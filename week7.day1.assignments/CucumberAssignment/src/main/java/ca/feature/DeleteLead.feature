Feature: Login into the Website

Background:
Given Open the Chrome Webbrowser
Given Load the application URL 'http://leaftaps.com/opentaps'
Given Enter the username string 'Demosalesmanager'
Given Enter the password string 'crmsfa'
When Click on the Login Button.
Then Check the Page Title.

Scenario: Delete with Positive Case
When Click on Leads Button
When Click on Find Leads Using LinkText
When Click on Phone
Given Enter phone number country code ''
Given Enter phone number area code ''
Given Enter phone number '9444530846'
When Click find leads button using XPATH
Then Capture lead ID of First Resulting lead
Then Click First Resulting lead
Then Click Delete
Then Click Find leads page
Then Enter captured lead ID
When Click find leads button using XPATH
Then Verify message

