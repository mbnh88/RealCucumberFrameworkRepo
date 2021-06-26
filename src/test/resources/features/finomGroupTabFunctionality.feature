@TestTag

Feature: Finom Group Tab Functionality
	User should be able to click the Finom Group tab and be directed to the Finom website
	
	Scenario: As a user, I should be directed to the Finom website when I click on the Finom Group tab button
	Given I am on the Stock Trading Tracking application homepage  
	When I click on the tab titled "Finom Group"
	Then I should be directed to the Finom Group homepage titled "Home - Finom Group"
