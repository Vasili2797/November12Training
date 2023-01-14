Feature: Feature to view items in Shopping Cart
	Scenario Outline: Adding multiple products in cart and see
	Given user is on the home page FR005
	When user clicks Shop link on top of webpage
	Then user clicks Software anchor link on top navigation
	And adds 'SVT Suite' to cart
	Then user clicks MERCH dropdown menu 
	And selects Headwear
	When Webpage opens and the user selects 'Classic Snap Back Hat'
	And user Adds the item to cart
	Then selects 'View or Edit your cart' anchor tag 
	