Feature: Feature to view items in Shopping Cart
	Scenario Outline: Adding multiple products in cart and see
	Given user is on the home page
	When user clicks Shop link on top of webpage
	Then user clicks Software anchor link on top navigation
	And adds SVT Suite to cart
	Then user clicks continue shopping button
	Then user clicks MERCH dropdown menu 
	And selects Shirts
	When Webpage opens and the user selects Classic Hoodie White
	Then user selects Size
	And adds product to cart
	Then Clicks Cart icon which opens up small preview window
	And Clicks View Cart