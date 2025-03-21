//Girish Rao Y E-24411

package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"com.stepdefinition","com.base"},
//	    tags="@Login",
	    plugin = {"pretty", "json:target/cucumber-reports-json/Cucumber.json"}
	    
	    
	)

public class TestRunner extends AbstractTestNGCucumberTests{

}
