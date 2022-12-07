package com.maven.java;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BaseClass {

	private static By username = By.xpath("//input[@type='email']");
	private static By password = By.xpath("//input[@type='password']");
	private static By nextbtn = By.xpath("//span[text()='Next']");
	private static By icon = By.xpath("//img[@class='gb_Ia gbii']");
	private static By incorrectUN = By.xpath("//div[text()='Couldn’t find your Google Account']");
	private static By incorrectPW = By
			.xpath("//span[text()='Wrong password. Try again or click Forgot password to reset it.']");

	public void enterText(String value, String field) throws Exception {

		switch (field) {
		case "EmailID":
			Thread.sleep(3000);
			driver.findElement(username).sendKeys(value);
			break;

		case "Password":
			Thread.sleep(3000);
			driver.findElement(password).sendKeys(value);
			break;

		default:
			throw new Exception("No option present: " + field);
		}
	}

	public void clickButton(String button) throws Exception {

		switch (button) {
		case "Next":
			Thread.sleep(3000);
			driver.findElement(nextbtn).click();
			break;

		case "Welcome":
			break;

		default:
			throw new Exception("No option present: " + button);
		}
	}

	public void verify(String value) throws Exception {

		Boolean act = false;
		switch (value) {
		case "UserProfileIcon":
			Thread.sleep(3000);
			act = driver.findElement(icon).isDisplayed();
			break;

		case "Couldn’t find your Google Account":
			Thread.sleep(3000);
			act = driver.findElement(incorrectUN).isDisplayed();
			break;

		case "Wrong password. Try again or click Forgot password to reset it.":
			Thread.sleep(3000);
			act = driver.findElement(incorrectPW).isDisplayed();
			break;

		default:
			throw new Exception("No option present: " + value);
		}
		System.out.println("Expected Value: true\nActual value: " + act);
		Assert.assertTrue(act, "Expected value not present");
	}

}
