@Regression
Feature: Create Add Trade Functionality
  As a user I should be able to add a trade and track all its data on the trade table.

  @AddTradeFieldsValidation @SmokeTest
  Scenario Outline: As a user I should be able to enter values and use all the fields on the Add Trade page.
   Given I am external user logged in to the Stock Trade Tracking application 
	 When I click on the Add a Trade button
	 Then I should be directed to a new page with Save Trade as the page heading
	 And Drop Down with the following options "<firstOption>" selected by default and "<secondOption>" 
	 And Symbol textbox which accepts a string "<symbol>" 10 characters in length
	 And Date1 textbox which accepts a "<date1>" value typed by the user or a date picked in the calender picker component
	 And Entry price Text box which takes a "<entryprice>" value that is a double 
	 And Date2 textbox which accepts a "<date2>" type Date, typed by the user or a date picked in the calender picker component
	 And Exit price text box which takes a "<exitprice>" value that is a double 
	
	 
	 Examples: 
      |firstOption|secondOption| symbol  | date1 | entryprice  | date2 | exitprice |
      |Sell to Open|Buy to Open| WER-GH-5fO |06/25/2021| 9.99 |10/27/2022| 500.0 |
     # |Sell to Open|Buy to Open| 1234567890 |07/25/2021 |5.563|10/27/2023 | 40.999|
    
    
     @SaveTradeWithDBValidation @SmokeTest
     Scenario Outline: As a user I should be able to provide valid data to all the fields and save them.
     Given I am external user logged in to the Stock Trade Tracking application
		 When I click on the Add a Trade button
	 	 Then I should be directed to a new page with Save Trade as the page heading
     Then I select "<selectoption>" on the dropdown
     Then I enter "<symbol>" on the Symbol field
		 Then I enter "<entrydate>" in the entry date field
		 And I enter "<entryprice>" for the entry price field
		 And I enter "<exitdate>" in the closing date field
		 And I enter "<exitprice>" to the exit price field
		 Then I click on Save button
		 And there are no issues with the fields submitted 
		 Then The trade information entered by the user should be saved in the application database. 
			
			 Examples: 
      |selectoption| symbol  | entrydate | entryprice  | exitdate | exitprice |
     	|Sell to Open | FF-TY   | 06/25/2021| 9.99   |10/27/2022| 500.0 |
      |Buy to Open | TY-bbnt-34|06/27/2021|113.55 |10/27/2023 |45.56 |
     
     @SaveTradeINVALID @SmokeTest
     Scenario: as a user I should be promted a 
     warning message whenever I enter invalid data or leave a field empty
     Given I am external user logged in to the Stock Trade Tracking application
		 When I click on the Add a Trade button
	 	 Then I should be directed to a new page with Save Trade as the page heading
	 	 When I click on Save button
	 	 Then the system should display the error message "Please fill out this field." for the Symbol input field
		 When I enter "AMZN-AWS" for the Symbol
		 And I click on Save button
		 Then the system should display the error message "Please fill out this field." for the Entry Date input field
		 And I enter "01/04/2021" in the Entry date field and "15" in the entry price field
		 And I click on Save button
		 Then the system should display the error message "Please fill out this field." for the Exit Date input field
		 When I enter "05/07/2022" in the Exit Date input field
		 And I click on Save button
		 Then the system should display the error message "Please fill out this field." for the Exit Price input field
			
			@BackToTransactionFunctionality @SmokeTest
			Scenario: As a user I should be able to see all my saved transactions on the Trade table
			Given I am external user logged in to the Stock Trade Tracking application
			When I click on the Add a Trade button
			Then I should be directed to a new page with Save Trade as the page heading
			And I have Saved a trade with following data 
			|Buy to Open | ARDB-RT|06/27/2021|13.55 |10/27/2023 |45.56 |
			Then I should be directed to the home page
			When I click on the Add a Trade button
			Then I should be directed to a new page with Save Trade as the page heading
			When I click on the Back to Transactions Link, 
			Then I should be directed to the home page 
			Then I should see all the data that I entered and saved in the Save Trade page
			And Gain Loss value should be equal to 45.56 decreased by 13.55 devided by entry price times 100 and rounded to one decimal place
			And If the Gain/Loss value results in Gain then the row should be in black font if its Loss then the row should be in red font
			And Action Column with "Update" and "Delete" buttons 
