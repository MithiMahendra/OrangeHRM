Feature: User able to edit Personal Details

Scenario: User can Enter some data into Personal Details fields

Given User logged into OrangeHRM "https://opensource-demo.orangehrmlive.com/" with Username "Admin",Password "admin123"
When User Entered data into fields present in Personal Details
Then User is able to enter Data in Personal data fields
