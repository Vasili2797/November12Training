    
Feature: Feature to test to see specifications for individual products

	Scenario Outline: Clicking a specific product on products link shows more details about the product
		Given user is on home pages
		When user clicks on products
		And clicks on MICRO SERIES product link
		Then user sees specific details about the chosen product