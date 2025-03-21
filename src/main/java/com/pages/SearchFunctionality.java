//Girish Rao Y E -24411

package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SearchFunctionality {

	    private WebDriver driver;
	    private WebDriverWait wait;

	    // Locators using @FindBy annotation
	    @FindBy(id = "small-searchterms")
	    private WebElement searchBar;

	    @FindBy(id = "As")
	    private WebElement bookCheckbox;

	    @FindBy(id = "Cid")
	    private WebElement categoryDropdown;

	    @FindBy(id = "Mid")
	    private WebElement manufacturerDropdown;

	    @FindBy(id = "Pf")
	    private WebElement priceFrom;

	    @FindBy(id = "Pt")
	    private WebElement priceTo;

	    @FindBy(id = "Sid")
	    private WebElement sortByDropdown;

	    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/form/div[3]/input")
	    private WebElement searchButton;

	    @FindBy(className = "product-grid")
	    private WebElement resultGrid;

	    // Constructor
	    public SearchFunctionality(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }

	    // Navigate to Search Page
	    public void navigateToSearchPage() {
	        driver.get("http://demowebshop.tricentis.com/");
	    }

	    // Search for a product
	    public void searchForProduct(String productName) {
	        wait.until(ExpectedConditions.visibilityOf(searchBar)).sendKeys(productName);
	        searchBar.sendKeys(Keys.ENTER);
	    }

	    // Apply filters
	    public void applyFilters() {
	        wait.until(ExpectedConditions.visibilityOf(bookCheckbox)).click();
	        wait.until(ExpectedConditions.visibilityOf(categoryDropdown)).click();

	        Select categorySelect = new Select(categoryDropdown);
	        categorySelect.selectByVisibleText("All");

	        wait.until(ExpectedConditions.visibilityOf(manufacturerDropdown)).click();
	        Select manufacturerSelect = new Select(manufacturerDropdown);
	        manufacturerSelect.selectByVisibleText("All");

	        priceFrom.sendKeys("0");
	        priceTo.sendKeys("10000");

	        sortByDropdown.click();
	        searchButton.click();
	    }

	    // Verify if filtered results are displayed
	    public boolean isFilteredResultsDisplayed() {
	        return wait.until(ExpectedConditions.visibilityOf(resultGrid)).isDisplayed();
	    }}
