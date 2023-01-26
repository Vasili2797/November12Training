Feature: Feature to test to find product dealers for individual products

	Scenario Outline: Clicking SHOP link on top left corner shows Featured Products. Clicking specific product brings up popUp window, which has button Find a dealer 
		Given user is on home page FR003
		When user clicks on SHOP tab and sees hardware link
		Then user clicks HARDWARE drop down menu
		And user clicks on Rocket Bass Series option
		Then user clicks on a specific product
		Then user clicks Find a Dealer button
		And sees all the available retailers
		And customer leaves website