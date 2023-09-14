package com.org.jenda.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = "src/test/resources/features",
		tags = "@smoke",
        glue = {"stepdef","com/org/jenda/hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json", "rerun:target/failedScenario.txt"},
        monochrome = true,
        publish = true)
public class Runner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
