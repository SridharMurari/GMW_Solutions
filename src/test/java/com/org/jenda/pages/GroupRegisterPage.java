package com.org.jenda.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.jenda.utils.CommonUtils;
import com.org.jenda.utils.CommonWebElementUtils;

public class GroupRegisterPage {
	
	WebDriver driver;
	private CommonWebElementUtils elementUtils;
	
	public GroupRegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new CommonWebElementUtils(driver);
		
	}
	
	@FindBy(xpath="//*[@id='content-main']/div[1]/table/tbody/tr/td[1]/a")
	private WebElement groupField;
	
	@FindBy(id="id_name")
	private WebElement groupNameField;
	
	@FindBy(xpath="//*[@id='group_form']/div/div/input[1]")
	private WebElement saveButton;
	
	@FindBy(xpath="//*[@id='main']/div/ul/li")
	private WebElement groupSuccessMessage;
	

	public void clickGroup() {
			
			elementUtils.clickOnElement(groupField, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
			
		}
	public void enterGroupName(String groupNameText) {
		
		elementUtils.typeTextIntoElement(groupNameField, groupNameText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void clickSaveButton() {
		elementUtils.clickOnElement(saveButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void validateSuccessMessage() {
		elementUtils.waitForVisibilityOfElement(groupSuccessMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
	

}
