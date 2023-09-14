package com.org.jenda.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "@target/failedScenario.txt",
tags = "@smoke",
glue = {"stepdef","com/org/jenda/hooks"},
plugin = {"pretty", "html:target/rerun-cucumber-reports.html", "json:target/rerun-cucumber.json"},
monochrome = true,
publish = true)
public class ReRunner extends AbstractTestNGCucumberTests {
@Override
@DataProvider(parallel = false)
public Object[][] scenarios() {
return super.scenarios();
}
}

