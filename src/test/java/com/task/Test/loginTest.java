package com.task.Test;

import Utils.Xls_Reader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import Utils.CommonMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.task.base.BaseTest;
import PageObjects.PageObjects;
public class loginTest extends BaseTest{
	//creating object of PageObjects class so that can access methods in page class
	PageObjects pom =new PageObjects();	
	//creating object of CommonMethods class so that can access common methods and pass input from here
	CommonMethods cm =new CommonMethods();
	//create object of Xls_Reader class and passing excel file path to it
	Xls_Reader reader = new Xls_Reader("D:\\Selenium\\QA_Assignment_HarshaBharule\\src\\main\\java\\com\\task\\utility\\exceldata.xlsx");
	int rowCount=reader.getRowCount("LoginTestData");//getting count of total row in excel sheet using function inside Xls_Reader class
	
	
	//this login method covering  scenarios with both invalid username /password and valid username /password
	//data driven testing scenario
	@Test(priority=1)
	public void loginScenarioValidAndInvalidCred() throws InterruptedException{


		for(int rowNum=2;rowNum<=rowCount;rowNum++) {//row start from 2 because 1st row contains headers

			WebElement username =pom.getLoginPage().getUsername();	//getting locator by calling method inside loginpage using pom object
			WebElement password=pom.getLoginPage().getPassword();
			cm.elementToBeVisibleWait(pom.getLoginPage().getUsername());

			username.click();

			username.sendKeys(reader.getCellData("LoginTestData", "username", rowNum));
			Thread.sleep(3000);
			cm.elementToBeVisibleWait(pom.getLoginPage().getPassword());

			password.click();
			password.sendKeys(reader.getCellData("LoginTestData", "password", rowNum));//using getcelldata function in Xls_Reader class and passing sheetname,field name and rowno 
			Thread.sleep(3000);
			cm.elementToBeVisibleWait(pom.getLoginPage().getSignInBtn());//explicite wait -it will wait till sign in button visible

			System.out.println(pom.getLoginPage().getSignInBtn().isEnabled());
			cm.elementToBeClickableWait(pom.getLoginPage().getSignInBtn());
			pom.getLoginPage().getSignInBtn().click();
			Thread.sleep(3000);
			String pageTitle=driver.getTitle();
			System.out.println(pageTitle);
			//if username password is wrong this condition will get executed
			if(pageTitle.contains("ACME System 1 - Log In"))
			{				

				String actual=driver.findElement(By.xpath("//strong[text()='These credentials do not match our records.']")).getText();
				String expected= "These credentials do not match our records.";

				Thread.sleep(3000);
				cm.assertEqualMethod(actual, expected);//assertion to verify message after click on login button with invalid username and password


			}
			//if username password is correct else if condition will get executed
			else if(pageTitle.contains("ACME System 1 - Dashboard")) {
				System.out.println("login successfully");
				Thread.sleep(3000);

				cm.movetoelement(pom.getLoginPage().getLogout());
				cm.elementToBeVisibleWait(pom.getLoginPage().getLogout());

				Thread.sleep(3000);
				pom.getLoginPage().getLogout().click();
				Thread.sleep(3000);
				String actual = driver.getTitle();
				String expected= "ACME System 1 - Log In";
				cm.assertEqualMethod(actual, expected);//assertion after click on logout button
			}


			cm.clearInput(username);
			cm.clearInput(password);

			Thread.sleep(3000);

		}

	}
	
	//this scenario is to check login with empty username and password
	@Test(priority=0)
	public void loginWithEmptyField() throws InterruptedException{

		cm.clickMethod(pom.getLoginPage().getSignInBtn());

		//we cannot find locator for tooltip because its not a element thats why i use getAttribute method to get validation message
		//and then i am doing assertion with message in tooltip
		String emptyFieldError=pom.getLoginPage().getUsername().getAttribute("validationMessage");
		
		System.out.println(emptyFieldError);
		String expected="Please fill out this field.";
		cm.assertEqualMethod(emptyFieldError, expected);//assertion for tooltip message

	}
}




