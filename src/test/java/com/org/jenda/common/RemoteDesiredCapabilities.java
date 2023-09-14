package com.org.jenda.common;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RemoteDesiredCapabilities {
	
	Logger LOG = LoggerFactory.getLogger(getClass());
	private DesiredCapabilities desiredCapabilities=null;
	
	public DesiredCapabilities getDesiredCapabilities() {
		return desiredCapabilities;
	}
	
	public RemoteDesiredCapabilities() {
	}
	
	public ChromeOptions buildRemoteChromeDesiredCapabilities() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.setAcceptInsecureCerts(true);
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		return options;
		
		
	}

}
