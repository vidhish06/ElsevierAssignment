#Author: Vidhi Sharma
#Purpose:Create Mendeley account
#Coverage: Valid scenario [user successfully registered] and Invalid Scenario [user failed to registered]

@featureTest
Feature: Mendeley Create Account

@Scenario
Scenario: User Entered Valid Email id, Name, FamilyName, CreatePassword and Register for the Account.

Given Launched url https://www.mendeley.com in Firefox browser
And create free account button is clicked
When Entered valid email id and Continue button is clicked 
And  Entered valid Name, FamilyName and password and Register button is clicked and verify message displayed You are registered with continue to Mendeley button 
Then Validated message displayed that You are registered with continue to Mendeley button
