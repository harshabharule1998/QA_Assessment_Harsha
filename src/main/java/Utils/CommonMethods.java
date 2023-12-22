package Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.task.base.BaseTest;



public class CommonMethods extends BaseTest{
	//here i am writing all common methods that will be reusable in different test classes 
	
	public  void clearInput(WebElement element) {
		element.clear();
	}
	
	public void clickMethod(WebElement element) {
		element.clear();
	}

	public void assertEqualMethod(String actual,String expected) {
		Assert.assertEquals(actual, expected);
	}
	private static Actions actionsObj() {
		Actions as = new Actions(driver);
		return as;
	}

	public void movetoelement(WebElement element) {
		actionsObj().moveToElement(element).perform();
	}
	
	public void elementToBeClickableWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void elementToBeVisibleWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
}
