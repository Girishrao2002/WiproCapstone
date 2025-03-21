//Girish Rao Y E-24411

package com.stepdefinition;

import org.testng.Assert;

import com.base.Hooks;
import com.pages.OrderPlacementPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderPlacementSteps {

	private OrderPlacementPage orderPage;

    public OrderPlacementSteps() {
        this.orderPage = new OrderPlacementPage(Hooks.getDriver()); // Use WebDriver from Hooks
    }

    @Given("User login with valid credentials")
    public void user_login_with_valid_credentials() {
        orderPage.login("mohan@mail.com", "rajmohan@2004");
    }

    @Then("User move to desired product section")
    public void user_move_to_desired_product_section() {
        orderPage.navigateToProductSection();
    }

    @And("User adds desired product in that section to cart")
    public void user_adds_desired_product_in_that_section_to_cart() {
        orderPage.addProductToCart();
    }

    @Then("User click on shopping cart button")
    public void user_click_on_shopping_cart_button() {
        orderPage.goToShoppingCart();
    }

    @When("User selects country and clicks accept terms and checkout")
    public void user_selects_country_and_clicks_accept_terms_and_checkout() {
        orderPage.selectCountryAndCheckout("United States");
    }

    @Then("User should fill required details in Billing address section")
    public void user_should_fill_required_details_in_billing_address_section() {
        orderPage.fillBillingDetails("Mohan", "Raj", "mohanraj@mail.com", "United States", "New York", "187 Main St", "100234", "9856432612");
    }

    @And("User should select a payment method and click continue")
    public void user_should_select_a_payment_method_and_click_continue() {
    	orderPage.confirmShippingAddress();
    	orderPage.selectShippingMethod();
        orderPage.selectPaymentMethod();
        
    }

    @Then("User Should review and click on confirm")
    public void user_should_review_and_click_on_confirm() {
    	orderPage.enterCreditCardDetails(1, "Girish Rao Y E", "6522940102554881", "09", "2025", "713");
        orderPage.confirmOrder();
    }

    @And("User should see order success message")
    public void user_should_see_order_success_message() {
        Assert.assertTrue(orderPage.isOrderSuccessful());
        System.out.println("Order placed successfully!");
    }
}
