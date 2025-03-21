package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.time.Duration;

public class ShoppingCartPage {
	private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "DIGITAL DOWNLOADS")
    private WebElement digitalDownloads;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")
    private WebElement music1;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/div[3]/div[2]/input")
    private WebElement music2;

    @FindBy(className = "cart-label")
    private WebElement cartLabel;

    @FindBy(name = "updatecart")
    private WebElement updateCart;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[1]/td[5]/input")
    private WebElement deleteItem;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[5]/input")
    private WebElement quantityInput;

    @FindBy(id = "termsofservice")
    private WebElement termsOfService;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div[3]/input[1]")
    private WebElement confirmCheckout;

    @FindBy(id = "checkout-step-billing")
    private WebElement checkoutBillingStep;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void loginToWebsite() {
        driver.get("http://demowebshop.tricentis.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[2]/div[1]/h2")));
    }

    public void addAndRemoveProductFromCart() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(digitalDownloads)).click();
        wait.until(ExpectedConditions.visibilityOf(music1)).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(music2)).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(cartLabel)).click();
        wait.until(ExpectedConditions.visibilityOf(updateCart));
        deleteItem.clear();
        deleteItem.sendKeys("0");
        deleteItem.sendKeys(Keys.ENTER);
    }

    public void updateQuantityAndProceedToCheckout() {
        quantityInput.clear();
        quantityInput.sendKeys("3");
        quantityInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(termsOfService)).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    public boolean confirmCheckoutPage() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmCheckout)).click();
        return wait.until(ExpectedConditions.visibilityOf(checkoutBillingStep)).isDisplayed();
    }
}
