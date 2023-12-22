package com.task.base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	
	@Parameters({ "URL" })//passing url value from testng.xml file
	//using BeforeTest testng annotation so that this method will get execute before 
	//execution of all the test methods of classes belonging to same folder
	@BeforeTest
	public void setup1(String url) throws InterruptedException
	{
	    System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\QA_Assignment_Harsha\\src\\test\\resources\\chromedriver\\chromedriver.exe");  
		//WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://acme-test.uipath.com/login");
		driver.get(url);
		System.out.println("driver open");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Thread.sleep(1000);

	}
	
	//This is method for closing all window at end of execution of tests in class
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		System.out.println("driver quit");
	}

}
