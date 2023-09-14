Feature: Group Registration functionality

	Background:
	    Given User has navigated to login page
	    
	Scenario: User creates an group
		Given User navigates to Add Group page
		When User enters the details into below fields
		|groupName	|ChanTest5		|
		And User clicks on Save button
		Then Company group should get created successfully
		
		
	Scenario Outline:: User creates multiple groups
		Given User navigates to Add Group page
		When User enters the "<groupname>" into below fields
		And User clicks on Save button
		Then Company group should get created successfully
		
		Examples:
      | groupname    	| 
      | Group112 				| 
      | Group212				| 
      | Group312        |