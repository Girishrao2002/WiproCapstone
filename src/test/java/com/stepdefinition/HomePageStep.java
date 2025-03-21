package com.stepdefinition;

import com.pages.HomePage;
import org.testng.Assert;
import com.base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomePageStep {
	private HomePage homePage;

    public HomePageStep() {
        this.homePage = new HomePage(Hooks.getDriver()); // Passing driver from Hooks
    }

    @Given("user navigates to the home page")
    public void user_navigates_to_the_home_page() {
        Hooks.getDriver().get("https://demowebshop.tricentis.com/");
    }

    @When("user locate search bar")
    public void user_locate_search_bar() {
        Assert.assertNotNull(homePage,"Search bar is not found!");
    }

    @And("user verifies search bar is displayed and functional")
    public void user_verifies_search_bar_displayed_and_functional() {
        Assert.assertTrue(homePage.isSearchBarDisplayed(), "Search bar is not displayed!");

        // Check if the search bar is functional by typing a sample text
        String testQuery = "Laptop";
        Assert.assertTrue(homePage.isSearchBarFunctional(testQuery), "Search bar is not functional!");
    }

    @Then("user should display success message")
    public void user_should_display_success_message() {
        System.out.println("Search bar is displayed and functional!");
    }
}
