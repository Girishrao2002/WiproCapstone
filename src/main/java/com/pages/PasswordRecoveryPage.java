package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordRecoveryPage {

	private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By loginButton = By.className("ico-login");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By submitButton = By.cssSelector("input.button-1.login-button");
    private By forgotPasswordLink = By.linkText("Forgot password?");
    private By recoveryEmailField = By.id("Email");
    private By recoverButton = By.cssSelector("input.button-1.password-recovery-button");
    private By recoverySuccessMessage = By.className("result");

    // Constructor
    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Click Login Button
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    // Enter Login Details
    public void enterLoginDetails(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    // Submit Login
    public void submitLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    // Click Forgot Password Link
    public void clickForgotPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink)).click();
    }

    // Enter Recovery Email
    public void enterRecoveryEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(recoveryEmailField)).sendKeys(email);
    }

    // Click Recover Button
    public void clickRecover() {
        wait.until(ExpectedConditions.elementToBeClickable(recoverButton)).click();
    }

    // Verify Recovery Success Message
    public boolean isRecoverySuccessMessageDisplayed() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(recoverySuccessMessage));
        return successMessage.isDisplayed();
    }
}
