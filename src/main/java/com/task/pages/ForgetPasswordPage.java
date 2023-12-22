package com.task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.task.base.BaseTest;

public class ForgetPasswordPage {

	WebDriver driver;
	 
	 public ForgetPasswordPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href=\'https://acme-test.uipath.com/password/reset\']")private WebElement forgotPassBtn;
	@FindBy(xpath="//input[@id='email']") private WebElement email;
	@FindBy(xpath="//button[@type='submit']") private WebElement sendPassLinkBtn;
	@FindBy(xpath="//div[@role='alert']") private WebElement resetlinkVerifyMsg;

	
	public WebElement getResetlinkVerifyMsg() {
		return resetlinkVerifyMsg;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getForgotPassBtn() {
		return forgotPassBtn;
	}

	public WebElement getSendPassLinkBtn() {
		return sendPassLinkBtn;
	}
	
	
}
