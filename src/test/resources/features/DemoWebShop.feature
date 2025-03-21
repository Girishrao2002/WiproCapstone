Feature: Automated UI Testing  

	@HomePage
	Scenario: verification of the search bar 
		Given user navigates to the home page
	  When user locate search bar
	  And user verifies search bar is displayed and functional
	  Then user should display success message
	  
	@SearchFunctionality
Scenario: Verification of functionality by searching different products
    Given User is in the search page
    When User searches for "<product>"
    And User filters the results
    Then User should see the filtered results

Examples:
    | product    |
    | Laptop     |
    | Computer |
    | Jeans |
    | Jewelry     |
		
	@ProductDetailsPage
		Scenario: Validate the product details
			Given User navigates to "APPAREL & SHOES" section
			When User selects the product  and validate details
			And User adds product to wishlist and cart	
			Then User should see products in the wishlist and cart
			
	@ShoppingCart
		Scenario: Managing the cart products
			Given User login to the website
			When User adds product to cart and removes product
			And User updtates the quantity and proceed to checkout
			Then User should confirm  the checkout page
			
	@Registration
	Scenario: Successful User Registration  
    Given User navigates to the homepage  
    When User clicks on the register button  
    And User enters registration details  
    And User submits the registration form  
    Then User should see a registration success message  

  @Login
  Scenario: UserLogin
	  Given User is in the homepage
	  When User click on Login button
	  And User fetches credentials from excel sheet
	  And User click on submit button
	  Then User should see login success message
	
	
	@PasswordRecovery
	Scenario: Password Recovery Steps
		Given User is in home page and click on login
		When User enters email and wrong password
		Then User should click on Forgot password
		And User should enter valid email and click on Recover button
		Then User should get message recovery steps sent
		
	@OrderPlacement
	Scenario: Successfully placing an order with a credit card payment

    Given User login with valid credentials
    Then User move to desired product section
    And User adds desired product in that section to cart
    Then User click on shopping cart button
    When User selects country and clicks accept terms and checkout
    Then User should fill required details in Billing address section
    And User should select a payment method and click continue
    Then User Should review and click on confirm
    And User should see order success message
		
		
		    
	
