package com.stepdefinition;

import org.testng.Assert;

import com.base.Hooks;
import com.pages.PasswordRecoveryPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasswordRecoverySteps {

	private PasswordRecoveryPage passwordRecoveryPage=new PasswordRecoveryPage(Hooks.driver);
	   @Given("User is in home page and click on login")
	    public void user_is_in_home_page_and_click_on_login() {
	        Hooks.driver.get("https://demowebshop.tricentis.com/");
	        passwordRecoveryPage.clickLogin();
	    }

	    @When("User enters email and wrong password")
	    public void user_enters_email_and_wrong_password() {
	        passwordRecoveryPage.enterLoginDetails("mohan@mail.com", "lal2456");
	        passwordRecoveryPage.submitLogin();
	    }

	    @Then("User should click on Forgot password")
	    public void user_should_click_on_forgot_password() {
	        passwordRecoveryPage.clickForgotPassword();
	    }

	    @And("User should enter valid email and click on Recover button")
	    public void user_should_enter_valid_email_and_click_on_recover_button() {
	        passwordRecoveryPage.enterRecoveryEmail("mohan@mail.com");
	        passwordRecoveryPage.clickRecover();
	    }

	    @Then("User should get message recovery steps sent")
	    public void user_should_get_message_recovery_steps_sent() {
	        Assert.assertTrue(passwordRecoveryPage.isRecoverySuccessMessageDisplayed(), "Recovery message not displayed!");
	    }
}
