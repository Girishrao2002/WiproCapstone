package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPlacementPage {

	private WebDriver driver;
    private WebDriverWait wait;

    // Locators for order placement elements
    @FindBy(linkText = "Log in")
    private WebElement loginButton;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement submitButton;

    @FindBy(linkText = "JEWELRY")
    private WebElement jewelry;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/h2/a")
    private WebElement product;

    @FindBy(id = "add-to-cart-button-14") // Update based on product selection
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='cart-label']")
    private WebElement shoppingCartButton;

    @FindBy(id = "CountryId")
    private WebElement countryDropdown;

    @FindBy(id = "termsofservice")
    private WebElement acceptTermsCheckbox;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;
    
    @FindBy(id="billing-address-select")
    private WebElement billingSelect;

    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement billingFirstName;

    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement billingLastName;

    @FindBy(id = "BillingNewAddress_Email")
    private WebElement billingEmail;

    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement billingCountryDropdown;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement billingCity;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement billingAddress1;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement billingZip;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement billingPhoneNumber;

    @FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/input")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"shipping-buttons-container\"]/input")
    private WebElement confirmShippingAddressContinue;

    @FindBy(id = "shippingoption_1") // Ground shipping method
    private WebElement shippingMethod;
    
    @FindBy(xpath="//*[@id=\"shipping-method-buttons-container\"]/input")
    private WebElement shippingContinue;
    
    @FindBy(id = "paymentmethod_2") // Credit card
    private WebElement paymentMethod;
    
    @FindBy (xpath="//*[@id=\"payment-method-buttons-container\"]/input")
    private WebElement paymentContinue;

    @FindBy(id = "CreditCardType")
    private WebElement creditCardDropdown;

    @FindBy(id = "CardholderName")
    private WebElement cardHolderName;

    @FindBy(id = "CardNumber")
    private WebElement cardNumber;

    @FindBy(id = "ExpireMonth")
    private WebElement expiryMonth;

    @FindBy(id = "ExpireYear")
    private WebElement expiryYear;

    @FindBy(id = "CardCode")
    private WebElement cardCvv;

    @FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/input")
    private WebElement confirmPaymentContinue;

    @FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/input")
    private WebElement confirmOrderButton;

    @FindBy(className = "order-completed")
    private WebElement orderSuccessMessage;

    // Constructor
    public OrderPlacementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Login
    public void login(String email, String password) {
    	driver.get("https://demowebshop.tricentis.com/");
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    // Navigate to Product Section
    public void navigateToProductSection() {
        wait.until(ExpectedConditions.elementToBeClickable(jewelry)).click();
    }

    // Add Product to Cart
    public void addProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(product)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    // Proceed to Shopping Cart
    public void goToShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartButton)).click();
    }

    // Checkout Process
    public void selectCountryAndCheckout(String country) {
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
        acceptTermsCheckbox.click();
        checkoutButton.click();
    }

    // Fill Billing Address
    public void fillBillingDetails(String fname, String lname, String email, String country, String city, String address, String zip, String phone) {
        if (billingSelect.isDisplayed()) {
        	continueButton.click();
        }else {
    	
    	billingFirstName.clear();
        billingFirstName.sendKeys(fname);
        billingLastName.clear();
        billingLastName.sendKeys(lname);
        billingEmail.clear();
        billingEmail.sendKeys(email);
        Select selectCountry = new Select(billingCountryDropdown);
        selectCountry.selectByVisibleText(country);
        billingCity.sendKeys(city);
        billingAddress1.sendKeys(address);
        billingZip.sendKeys(zip);
        billingPhoneNumber.sendKeys(phone);
        continueButton.click();
        }
    }

    // Confirm Shipping Address
    public void confirmShippingAddress() {
        confirmShippingAddressContinue.click();
    }

    // Select Shipping Method
    public void selectShippingMethod() {
        shippingMethod.click();
        shippingContinue.click();
    }

    // Select Payment Method
    public void selectPaymentMethod() {
        paymentMethod.click();
        paymentContinue.click();
    }

    // Enter Payment Details
    public void enterCreditCardDetails(int index, String name, String number, String expMonth, String expYear, String cvv) {
        Select selectCardType = new Select(creditCardDropdown);
        selectCardType.selectByIndex(index);
        cardHolderName.sendKeys(name);
        cardNumber.sendKeys(number);
        Select selectMonth = new Select(expiryMonth);
        selectMonth.selectByVisibleText(expMonth);
        Select selectYear = new Select(expiryYear);
        selectYear.selectByVisibleText(expYear);
        cardCvv.sendKeys(cvv);
        confirmPaymentContinue.click();
    }

    // Confirm Order
    public void confirmOrder() {
        confirmOrderButton.click();
    }

    // Verify Order Success
    public boolean isOrderSuccessful() {
        return wait.until(ExpectedConditions.visibilityOf(orderSuccessMessage)).isDisplayed();
    }
}
