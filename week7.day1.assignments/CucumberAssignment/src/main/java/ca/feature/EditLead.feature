Feature: Login into the Website

Background:
Given Open the Chrome Webbrowser
Given Load the application URL 'http://leaftaps.com/opentaps'
Given Enter the username string 'Demosalesmanager'
Given Enter the password string 'crmsfa'
When Click on the Login Button.
Then Check the Page Title.

Scenario: Edit Lead Test Case
When click On Leads Using LinkText
When Click on Find Leads Using LinkText
Given Provide First Name Of Lead 'Vignesh'
When Clicked Find Leads
Then Get The Resulting Lead Id
When Click Edit Button
Then Update the company Name 'Bravetux'
Then Click Update submitButton
Then Check And Validate Company Name