Feature: OrangeHRM Login

Scenario: Login OrangeHRM with valid Credentials

Given Intialize Browser
And Open "https://opensource-demo.orangehrmlive.com/"
When Login with ValidUsername "Admin" and ValidPassword "admin123"
Then Login OrangeHRM is Successfull

Scenario Outline: Login OrangeHRM with In-Valid Credentials

Given Intialize Browser
And Open "https://opensource-demo.orangehrmlive.com/"
When Login with Username <username> and Password <password>
Then Login OrangeHRM is UnSuccessfull

Examples:
|username		|password	|
|admin56		|admin123	|
|Admin			|Admin1234	|
|admin12		|Admin123	|
