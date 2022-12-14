package com.maven.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/java/com/maven/feature", glue = "com/maven/stepdef", 
					monochrome = true, tags = "@Regression", dryRun = false,
					plugin = { "pretty", "html:target/cucumber-reports/cucumberReport.html" })

public class Runner {

}
