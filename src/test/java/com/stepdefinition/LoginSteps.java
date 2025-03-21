package com.stepdefinition;

import java.io.IOException;

import org.testng.Assert;

import com.base.Hooks;
import com.pages.LoginPage;
import com.utils.ExcelUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage(Hooks.getDriver()); // Use WebDriver from Hooks
    }

    @Given("User is in the homepage")
    public void user_is_in_the_homepage() {
        loginPage.navigateToHomepage();
    }

    @When("User click on Login button")
    public void user_click_on_login_button() {
        loginPage.clickLoginButton();
    }

    @And("User fetches credentials from excel sheet")
    public void user_fetches_credentials_from_excel_sheet() throws IOException {
        String email = ExcelUtils.getCellValue("LoginData", 0, 0);
        String password = ExcelUtils.getCellValue("LoginData", 0, 1);
        loginPage.enterCredentials(email, password);
    }

    @And("User click on submit button")
    public void user_click_on_submit_button() {
        loginPage.clickSubmit();
    }

    @Then("User should see login success message")
    public void user_should_see_login_success_message() {
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed!");
        System.out.println("Login successful!");
    }
}
