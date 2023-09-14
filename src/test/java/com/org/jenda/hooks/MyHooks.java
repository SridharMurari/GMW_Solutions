package com.org.jenda.hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.asserts.SoftAssert;

import com.org.jenda.factory.DriverFactory;
import com.org.jenda.utils.PropertyReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {
	
	WebDriver driver;
	SoftAssert softAssert;
	Properties prop;
	
	
	@Before
    public void setup() throws IOException {
		
		softAssert = new SoftAssert();
		prop = new PropertyReader().intializeProperties();
		driver = DriverFactory.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario){
    	
    	softAssert.assertAll();
    	/*String scenarioName = scenario.getName().replaceAll(" ", "_");
    	if(scenario.isFailed()) {
    		
    		byte[] srcSceenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    		scenario.attach(srcSceenshot, "image/png", scenarioName);
    	}
    	
        if(driver!=null){
            driver.quit();
        }*/
    } 
    
    public WebDriver getDriver() {
        return driver;
    }
    
    public SoftAssert getSoftAssert() {
        return softAssert;
    }
    
    public Properties getProperties() {
        return prop;
    }

}
