@Regression
Feature: Trade Journal Search Functionality Valid tests
  
Background: 
  Given I am logged in tot the Stock Trade applications
  And I am on the TJ home page
  
 @SmokeTest @SearchFunctionalitySymobl 
Scenario: search functionality valid Symbol test  
  When I enter a value "vix" for ‘Symbol' textbox,
And I click on the 'Search’ Button
Then 	The system should filter the existing list of trades associated with the Symbol "vix"
And Once the system fetches the records it should only display the records matching the user’s filters."vix" 

@SmokeTest @SearchFunctionalityDate
Scenario:  search functionality valid date test
  When I enter a value for ‘Date' textbox "06/25/2021",
And I click on the 'Search’ Button
Then 	The system should filter the existing list of trades associated with the Date
And Once the system fetches the records it should only display the records matching the user’s filters.

@SmokeTest @SearchFunctionalitySymbolDate
Scenario: search functionality valid symbol and date test
  When I enter a value "vix" for ‘Symbol' textbox,
  And I enter a value for 'Date' textbox "06/25/2021"
And I click on the 'Search’ Button
Then 	The system should filter the existing list of trades associated with the Symbol and DATE
And Once the system fetches the records it should only display the records matching the user’s filters.

@SmokeTest @SearchFunctionalityNoMatch
Scenario: search functionality no matching records
  When I enter a Symbol or date
  And there are no matching records
  Then the system should display an empty table