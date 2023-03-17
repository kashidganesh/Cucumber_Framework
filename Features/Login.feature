Feature: Login

Background: Below are common steps for every scenario
Given User Launch Chrome browser 
When User opans URL "https://admin-demo.nopcommerce.com/login"

@sanity
Scenario: Successful Login with Valid Credentials
#Given User Launch Chrome browser 
#When User opans URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and password as "admin"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on Log out link
Then page Title should be "Your store. Login"
And close browser

@regression
Scenario Outline: Login Data Driven
#Given User Launch Chrome browser 
#When User opans URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "<email>" and password as "<password>"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on Log out link
Then page Title should be "Your store. Login"
And close browser

Examples:
  | email               | password |
  | admin@yourstore.com | admin    |
  | admin@yourstore.com | admin123 |
 
