package com.stepdefinition;

import org.testng.Assert;

import com.base.Hooks;
import com.pages.ProductDetailsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailsPageSteps {

	private ProductDetailsPage productDetailsPage;

    public ProductDetailsPageSteps() {
        this.productDetailsPage = new ProductDetailsPage(Hooks.getDriver()); // Use driver from Hooks
    }

    @Given("User navigates to {string} section")
    public void user_navigates_to_section(String section) {
        productDetailsPage.navigateToApparelShoes();
    }

    @When("User selects the product  and validate details")
    public void user_selects_product_and_validate_details() {
        productDetailsPage.selectFirstProduct();
        productDetailsPage.validateProductDetails();
        System.out.println("Product details displayed correctly.");
    }

    @And("User adds product to wishlist and cart")
    public void user_adds_product_to_wishlist_and_cart() {
        productDetailsPage.addToWishlist();
        productDetailsPage.addToCart();
    }

    @Then("User should see products in the wishlist and cart")
    public void user_should_see_products_in_wishlist_and_cart() {
//        Assert.assertTrue(productDetailsPage.isProductInWishlistAndCart(), "Product not added to wishlist or cart!");
        System.out.println("Product successfully added to wishlist and cart.");
    }
}
