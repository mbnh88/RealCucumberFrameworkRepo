Feature: Add trade
User is able to add, delete, edit his trade logs
@addTrade
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

# we will be working with the date picker here
# we are going to create different scenarios to understand the data tables
# with data passing in the step

@addTradeWithDataTable
Scenario: As a user I should be able to log my trade


Given I am on the app login page
When I enter valid username "helil" and password "superHelil123!"combo
And I click on signin button
Then I should be in the trade home page
When I click on the add trade button
Then I should be directed to save trade form
When I enter the following trade details
|Buy to Open|TSLA|06/01/2021|500|06/10/2021|622|
And I click the save button
Then the trade is displayed in the trade table

