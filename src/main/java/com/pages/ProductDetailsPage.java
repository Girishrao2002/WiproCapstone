//Girish Rao Y E-24411

package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import java.time.Duration;
import java.util.List;

public class ProductDetailsPage {
	private WebDriver driver;
    private WebDriverWait wait;

    // Locators for Apparel & Shoes section
    @FindBy(linkText = "Apparel & Shoes")
    private WebElement apparelShoesSection;

    @FindBy(className = "product-item") // Assuming class for product items
    private List<WebElement> productList;

    // Locators for product details
    @FindBy(className = "product-name")
    private WebElement productTitle;

    @FindBy(xpath = "//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[1]/h1")
    private WebElement productDescription;

    @FindBy(className = "price-value-5")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@class='picture']//img")
    private WebElement productImage;

    @FindBy(className = "stock")
    private WebElement productAvailability;

    // Add to Wishlist & Cart buttons
    @FindBy(id = "add-to-wishlist-button-5") // Assuming a static ID; update if dynamic
    private WebElement addToWishlistButton;

    @FindBy(id = "add-to-cart-button-5") // Assuming a static ID; update if dynamic
    private WebElement addToCartButton;

    @FindBy(className = "ico-wishlist")
    private WebElement wishlistQuantity;
    
    @FindBy(className="share-label")
    private WebElement wishlist;
    
    @FindBy(name="updatecart")
    private WebElement cartlist;

    @FindBy(className = "cart-label")
    private WebElement cartQuantity;

    // Constructor
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Navigate to Apparel & Shoes section
    public void navigateToApparelShoes() {
    	driver.get("https://demowebshop.tricentis.com/");
        wait.until(ExpectedConditions.elementToBeClickable(apparelShoesSection)).click();
    }

    // Select the first product from the list
    public void selectFirstProduct() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productList));
        productList.get(0).click();
    }

    // Validate product details
    public void validateProductDetails() {
        wait.until(ExpectedConditions.visibilityOf(productTitle));
        System.out.println(productTitle.getText());
        		System.out.println(productDescription.getText());
        		System.out.println  ( productPrice.getText());
        		System.out.println(productImage.getSize());
        		System.out.println (productAvailability.getText()); 
    }

    // Add product to wishlist
    public void addToWishlist() {
        wait.until(ExpectedConditions.elementToBeClickable(addToWishlistButton)).click();
    }

    // Add product to cart
    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    // Validate if the product is added to wishlist and cart
    public void isProductInWishlistAndCart() {
         wishlistQuantity.click();
         
         if(wishlist.isDisplayed()) {
        	 System.out.println("Added product is displayed in the wishlist");
        	 cartQuantity.click();
        	 if(cartlist.isDisplayed())
        		 System.out.println("Added product is in the cart");
        	 else
        		 System.out.println("Added product not in the cart");
         }else {
        	 System.out.println("Added is not in the wishlist");
         }
    }
    
}
