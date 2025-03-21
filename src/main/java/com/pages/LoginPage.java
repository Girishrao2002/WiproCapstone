package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
	 private WebDriver driver;
	    private WebDriverWait wait;

	    // Locators for login elements
	    @FindBy(linkText = "Log in")
	    private WebElement loginButton;

	    @FindBy(id = "Email")
	    private WebElement emailField;

	    @FindBy(id = "Password")
	    private WebElement passwordField;

	    @FindBy(xpath = "//input[@value='Log in']")
	    private WebElement submitButton;

	    @FindBy(className = "account")
	    private WebElement accountSection; // Element displayed after successful login

	    // Constructor
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }

	    // Navigate to homepage
	    public void navigateToHomepage() {
	        driver.get("http://demowebshop.tricentis.com/");
	    }

	    // Click Login Button
	    public void clickLoginButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	    }

	    // Enter Credentials
	    public void enterCredentials(String email, String password) {
	        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
	        passwordField.sendKeys(password);
	    }

	    // Submit Login Form
	    public void clickSubmit() {
	        submitButton.click();
	    }

	    // Verify Login Success
	    public boolean isLoginSuccessful() {
	        return wait.until(ExpectedConditions.visibilityOf(accountSection)).isDisplayed();
	    }
}