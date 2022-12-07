@Ebay 
Feature: Ebay funtionality 

@E001 @Regression
Scenario: Getting price of the product 
	Given User is on "EbayHome" screen 
	When User enters "Electric Guitar" in "SearchBox" field in "EbayHome" screen 
	Then User clicks on "Search" button in "EbayHome" screen 
	And User verifies "Electric Guitar" is displayed 
	When User clicks on "FirstResult" button in "EbayHome" screen 
	And User verifies "Guitar Details with Price" is displayed