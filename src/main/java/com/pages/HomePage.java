package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private WebDriver driver;

    // Constructor accepting WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for Search Bar
    private By searchBar = By.id("small-searchterms");

    // Method to check if search bar is displayed
    public boolean isSearchBarDisplayed() {
        return driver.findElement(searchBar).isDisplayed();
    }

    // Method to enter text in search bar
    public void enterSearchText(String query) {
        WebElement searchElement = driver.findElement(searchBar);
        searchElement.clear();
        searchElement.sendKeys(query);
    }

    // Method to check if search bar is functional
    public boolean isSearchBarFunctional(String testQuery) {
        enterSearchText(testQuery);
        return driver.findElement(searchBar).getAttribute("value").equals(testQuery);
    }
}
