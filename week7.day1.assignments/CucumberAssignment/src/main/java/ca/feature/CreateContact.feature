Feature: Login into the Website

Scenario: Login with Positive Case
Given Open the Chrome Webbrowser
Given Load the application URL 'http://leaftaps.com/opentaps'
Given Enter the username string 'Demosalesmanager'
Given Enter the password string 'crmsfa'
When Click on the Login Button.
Then Check the Page Title.
Then Click on contacts Button
Then Click on Create Contact By LinkText
Given Enter FirstName Field Using id Locator 'VigneshKumar'
Given Enter LastName Field Using id Locator 'B'
Given Enter FirstName Local Field Using id Locator 'Bravetux'
Given Enter LastName Local Field Using id Locator 'Bravo'
Given Enter Department Field Using id Locator 'ICE'
Given Enter Description Field Using id Locator 'Instrumentation and Control'
Given Enter your email in the E-mail address Field using id Locator 'vignesh@bravetux.com'
Given Select State or Province as NewYork Using Visible Text 
When Click on Create Contact By Name
When Click on edit button
When Clear the Description Field using .clear
Then Fill ImportantNote Field with Any text 'Important Note'
When Click on update button using Xpath locator
Then Get the Title of Resulting Page
