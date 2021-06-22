Feature: Add trade
User is able to add, delete, edit his trade logs

Scenario: As a user I should be able to log my trade

Given I am on the app login page
When I enter valid username "helil" and password "superHelil123!"combo
And I click on signin button
Then I should be in the trade home page
When I click on the add trade button
Then I should be directed to save trade form
When I select "Buy to Open" and enter symbol "TSLA" entrydate "06/01/2021" entryprice "590" exitdate "06/10/2021" exitprice "600"
And I click the save button
Then the trade is displayed in the trade table
