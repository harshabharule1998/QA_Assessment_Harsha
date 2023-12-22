package com.task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.task.base.BaseTest;

public class loginpage {
	 WebDriver driver;
	 
	 //Here I have used pagefactory class to supporm page object model design pattern
	 //define constructor to create instance of class
	public loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//using @FindBy annotation web elements are initialized
	
	@FindBy(xpath="//*[@id=\'email\']") private WebElement username;
	@FindBy(xpath="//*[@id=\'password\']") private WebElement password;
	@FindBy(xpath="//button[@type='submit']") private WebElement signInBtn;
	@FindBy(xpath="//*[@id=\'bs-example-navbar-collapse-1\']/ul/li[3]/a") private WebElement logout;


	//defines getter methods so that private variable can be access within from another class

	public WebElement getLogout() {
		return logout;
	}



	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSignInBtn() {
		return  signInBtn;
	}

	public WebElement getUsername() {
		return username;
	}
	
	public WebElement getPassword() {
		return password;
	}
	

	
	
	

}
