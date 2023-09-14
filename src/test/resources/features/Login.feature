#Author: your.email@your.domain.com
#Keywords Summary :

Feature: Login Feature

  Background:
    Given User has navigated to login page
    

  #Scenario: Login with valid credentials
   # Given User enters valid email address "sridhar.murari@gmware.com" into email field
    #When User enters valid passsword "Kanaga@3479" into password field
    #Then User clicks on Login button
    #And User should get successfully logged in
 @smoke
  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"

    Examples:
      | username          				| password        | error_message         																									|
     # | sridhar.murari@gmware.com | Kanaga@3479			| Shield Suite Api Administration																					|
      | invalid@email.com 				| invalidPassword | Please enter the correct email address and password for a staff account. Note that both fields may be case-sensitive. |
      | abcccc            				| validPassword   | Please enter the correct email address and password for a staff account. Note that both fields may be case-sensitive. |
      | valid@email.com   				| abccc           | Please enter the correct email address and password for a staff account. Note that both fields may be case-sensitive. |