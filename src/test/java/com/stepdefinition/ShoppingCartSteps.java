package com.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

import com.base.Hooks;
import com.pages.*;

public class ShoppingCartSteps {
	 ShoppingCartPage shoppingCartPage = new ShoppingCartPage(Hooks.driver);

	    @Given("User login to the website")
	    public void user_login_to_the_website() {
	        shoppingCartPage.loginToWebsite();
	    }

	    @When("User adds product to cart and removes product")
	    public void user_adds_product_to_cart_and_removes_product() throws InterruptedException {
	        shoppingCartPage.addAndRemoveProductFromCart();
	    }

	    @When("User updtates the quantity and proceed to checkout")
	    public void user_updtates_the_quantity_and_proceed_to_checkout() {
	        shoppingCartPage.updateQuantityAndProceedToCheckout();
	    }

	    @Then("User should confirm  the checkout page")
	    public void user_should_confirm_the_checkout_page() {
	        Assert.assertTrue(shoppingCartPage.confirmCheckoutPage(), "Not in the proper checkout page");
	        System.out.println("In the checkout page");
	    }

}
