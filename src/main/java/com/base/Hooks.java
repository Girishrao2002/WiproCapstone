//24411 - Girish Rao Y E

package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;

    
	@Before
    public void setup() {
        System.out.println("******* SETTING UP WEBDRIVER *******");
        if (driver == null) { // Ensure driver is initialized only once
            String browser = System.getProperty("browser", "chrome");
            System.out.println("Running tests on browser: " + browser);
            
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        System.out.println("***** WEBDRIVER INITIALIZED ******");
    }

	 public static WebDriver getDriver() { // static getter to fetch driver
	        return driver;
	    }


    @After
    public void closeDriver()  {
        if (driver != null) {
            driver.quit();
            driver = null; // Ensure fresh session in next run
        }
    }
}
