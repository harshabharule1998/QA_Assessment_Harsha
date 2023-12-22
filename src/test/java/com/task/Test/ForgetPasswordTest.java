package com.task.Test;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.task.base.BaseTest;

import PageObjects.PageObjects;
import Utils.CommonMethods;

public class ForgetPasswordTest extends BaseTest {

	PageObjects pom =new PageObjects();	
	CommonMethods cm =new CommonMethods();

	@Parameters({"email"})//getting email from testng.xml file
	@Test
	public void getResetLinkForPassword(String email) {
		cm.movetoelement(pom.getForgotPassPage().getForgotPassBtn());
		pom.getForgotPassPage().getForgotPassBtn().click();
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://acme-test.uipath.com/password/reset";
		cm.assertEqualMethod(actualURL, expectedURL);
		cm.elementToBeVisibleWait(pom.getForgotPassPage().getEmail());
		pom.getForgotPassPage().getEmail().sendKeys(email);
		//pom.getForgotPassPage().getEmail().sendKeys("harshabharule@gmail.com");
		cm.elementToBeVisibleWait(pom.getForgotPassPage().getSendPassLinkBtn());
		pom.getForgotPassPage().getSendPassLinkBtn().click();
		
	}


	@Test(dependsOnMethods = {"getResetLinkForPassword"})//this method will get executed only after successful execution of getResetLinkForPassword method
	public void getPopupMsgAfterClickResetLink() {
	
		String actualPopu="We have e-mailed your password reset link!";
		String expected=pom.getForgotPassPage().getResetlinkVerifyMsg().getText();
		System.out.println(expected);
		cm.assertEqualMethod(expected, actualPopu);//assertion to verify the message after sending link 
	}
}
