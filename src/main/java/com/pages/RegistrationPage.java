//Girish Rao Y E -24411

package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for registration elements
    @FindBy(linkText = "Register")
    private WebElement registerButton;

    @FindBy(id = "gender-male") // Assuming selecting male gender
    private WebElement genderMale;

    @FindBy(id = "FirstName")
    private WebElement firstName;

    @FindBy(id = "LastName")
    private WebElement lastName;

    @FindBy(id = "Email")
    private WebElement email;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPassword;

    @FindBy(id = "register-button")
    private WebElement registerSubmitButton;

    @FindBy(className = "result")
    private WebElement registrationSuccessMessage;

    // Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Navigate to homepage
    public void navigateToHomepage() {
        driver.get("http://demowebshop.tricentis.com/");
    }

    // Click Register Button
    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    // Fill Registration Form
    public void enterRegistrationDetails(String fName, String lName, String emailID, String pass) {
        wait.until(ExpectedConditions.visibilityOf(genderMale)).click();
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(emailID);
        password.sendKeys(pass);
        confirmPassword.sendKeys(pass);
    }

    // Submit Registration Form
    public void submitRegistrationForm() {
        wait.until(ExpectedConditions.elementToBeClickable(registerSubmitButton)).click();
    }

    // Validate Registration Success
    public boolean isRegistrationSuccessful() {
        return wait.until(ExpectedConditions.visibilityOf(registrationSuccessMessage)).isDisplayed();
    }
}
