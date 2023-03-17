package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

//run all feature file
//@CucumberOptions(features = { ".//Features//" },
//run few feature file 
//@CucumberOptions(features = { "D://Testing//Testing Mini Bytes//Selenium Framework//Workplace//nopCommerceV001_Cucumber//Features//Customers.feature",".//Features//Login.feature"},

@CucumberOptions(features = ".//Features//Customers.feature", glue = "stepDefinitions", dryRun = false, monochrome = true, plugin = {
		"pretty", "html:Report/test.html" }
// tags = { "@sanity,@regression" }
)

public class TestRun {

}
