@Tabs
Feature: Homepage tabs functionality
	User should be able to click a tab and be directed to the correct corresponding website
	
	Background: 
	Given I am on the Stock Trading Tracking application homepage
	
	@FinomTab
	Scenario: As a user, I should be directed to the Finom website when I click on the Finom Group tab button
	When I click on the tab titled Finom Group
	Then I should be directed to the Finom Group homepage titled "Home - Finom Group"
	
	@SlackTab
	Scenario: As a user, I should be directed to the PrimeTech_SDET_Batch1 slack channel when I click on the Slack channel tab button
	When I click on the tab titled Slack Channel
	And I am logged into the PrimeTech_SDET_Batch1 slack channel
	Then I should be directed to the "PrimeTech_SDET_Batch1" slack channel

	@SlackTab
	Scenario: As a user, I should be directed to the slack sign in page when I click on the Slack channel tab button
	When I click on the tab titled Slack Channel
	And I am not logged into my slack account
	Then I should be directed to the Slack sign in page titled "Slack"
	
	@ToolsTab
	Scenario: As a user, I should be directed to the Options Calculator homepage when I click on the Tools dropdown and select Options Calculator 
	Given I have clicked on the Tools dropdown
	When I click the Options Calculator option
	Then I should be directed to the Options Calculator homepage titled "Options Calculator"
	
	@ToolsTab
	Scenario: As a user, I should be directed to the Vol ETF/ETN Price Converter homepage when I click on the Tools dropdown and select Vol ETF/ETN Price Converter
	Given I have clicked on the Tools dropdown
	When I click the Vol ETF/ETN Price Converter option
	Then I should be directed to the Vol ETF/ETN Price Converter homepage titled "Vol ETF/ETN Price Converter"
	
	@ToolsTab
	Scenario: As a user, I should be directed to the Finviz homepage when I click on the Tools dropdown and select Today’s Market Info
	Given I have clicked on the Tools dropdown
	When I click the Today’s Market Info option
	Then I should be directed to the Finviz Stock Screener homepage titled "Finviz"