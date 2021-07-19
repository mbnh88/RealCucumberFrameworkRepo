@Regression

Feature: Stock Trade Tracking login with Valid username and password
  
  User should be able to login using Stock Trade tracking login feature
 @tradeLogInValidtest @SmokeTest
  Scenario: As a user, i should be directed to home page on click of the sign up button
    Given i am on the stock trade tracking homepage
    Then signin text should be displayed
    When i enter valid username "Yamina" and password "SuperYamina123!"
    Then i should be able to click on signin button
    And i should be directed to the home page
    



  @tradelogInInvalidTest @SmokeTest
  Scenario: As a user, i should not be able to login with invalid username and password
    Given i am on the trade journal page
    When when i enter invalid username "yamina" and password "superyamina123!"
    And click on signIn
    Then i should get a message "Bad credentials"
    

 
    
    
