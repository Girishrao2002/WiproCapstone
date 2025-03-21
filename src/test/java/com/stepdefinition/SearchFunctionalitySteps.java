package com.stepdefinition;

import org.testng.Assert;

import com.base.Hooks;
import com.pages.SearchFunctionality;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFunctionalitySteps {

	private SearchFunctionality searchFunction;

    public SearchFunctionalitySteps() {
        this.searchFunction = new SearchFunctionality(Hooks.getDriver()); // Use driver from Hooks
    }

    @Given("User is in the search page")
    public void user_is_in_the_search_page() {
        searchFunction.navigateToSearchPage();
    }

    @When("User searches for {string}")
    public void user_searches_for_product(String product) {
        searchFunction.searchForProduct(product);
    }

    @And("User filters the results")
    public void user_filters_the_results() {
        searchFunction.applyFilters();
    }

    @Then("User should see the filtered results")
    public void user_should_see_the_filtered_results() {
        Assert.assertTrue(searchFunction.isFilteredResultsDisplayed(), "Filtered results are not displayed!");
        System.out.println("Search and filtering for product successful!");
    }
}
