package com.org.jenda.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.org.jenda.utils.CommonUtils;
import com.org.jenda.utils.CommonWebElementUtils;

public class LoginPage {
	
	private WebDriver driver;
	private CommonWebElementUtils webElement;
    private By emailInputLocator  = By.id("id_username");
    private By passwordInputLocator  = By.id("id_password");
    private By loginButtonLocator  = (By.xpath("//*[@value=\"Log in\"]"));

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        webElement = new CommonWebElementUtils(driver);
    }
    
 // Methods
    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailInputLocator);
       // emailInput.sendKeys(email);
        webElement.typeTextIntoElement(emailInput, email, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
      //  passwordInput.sendKeys(password);
        webElement.typeTextIntoElement(passwordInput, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
      //  loginButton.click();
        webElement.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        
    }
    
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

}
