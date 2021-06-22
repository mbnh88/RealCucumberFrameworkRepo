@Regression
Feature: Trade Journal Logout functionality
  
  Background: 
    Given I am logged into the Trade Journal Application
    And I am on the homepage
  
  Scenario: Logout Functionality
    As a user I should be able to logout of my account
    When I click the Logout button
    
    Then I should be on a new page
    And see the following message: "Are you sure you want to log out?"
    And I click the Logout button
    Then I should be succesfully logged out
    And I should see the Trade Journal Login page
