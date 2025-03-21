package com.stepdefinition;

import org.testng.Assert;

import com.base.Hooks;
import com.pages.RegistrationPage;
import io.cucumber.java.en.*;


public class RegistrationSteps {
    private RegistrationPage registrationPage;

    public RegistrationSteps() {
        this.registrationPage = new RegistrationPage(Hooks.getDriver()); // Use driver from Hooks
    }

    @Given("User navigates to the homepage")
    public void user_navigates_to_the_homepage() {
        registrationPage.navigateToHomepage();
    }

    @When("User clicks on the register button")
    public void user_clicks_on_the_register_button() {
        registrationPage.clickRegisterButton();
    }

    @And("User enters registration details")
    public void user_enters_registration_details() {
        String randomEmail = "test" + System.currentTimeMillis() + "@mail.com"; // Generate unique email
        registrationPage.enterRegistrationDetails("Rajaram", "Roy", randomEmail, "Rajram@2768");
    }

    @And("User submits the registration form")
    public void user_submits_the_registration_form() {
        registrationPage.submitRegistrationForm();
    }

    @Then("User should see a registration success message")
    public void user_should_see_a_registration_success_message() {
        Assert.assertTrue(registrationPage.isRegistrationSuccessful(), "Registration failed!");
        System.out.println("Registration successful!");
    }
}
