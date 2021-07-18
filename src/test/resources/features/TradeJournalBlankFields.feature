    
  @tradeBlankFields  @SmokeTest
 Feature: When i leave username and password i should not be able to log in
 Scenario: As a user, i should not be able to log in when i leave username and password fields blank
 Given i am on the trade journal log in page
 When i leave username and password blank
 And i click on sign in
 Then i shoud get message "please fill out this field"