Feature: Product Endorsement
	
	Scenario Outline: This feature deals with the information on who endorses individual products
		Given user is on homepage FR004
		And user clicked the link Artists
		Then user hovers over the artist link
		And Get The name of an artist and assert