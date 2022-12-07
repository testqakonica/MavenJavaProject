package com.maven.stepdef;

import com.maven.java.BaseClass;
import com.maven.java.EbayHome;
import com.maven.java.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class StepDef extends BaseClass {

	public static LoginPage lp = new LoginPage();
	public static EbayHome ebh = new EbayHome();

	@Given("User is on {string} screen")
	public void user_is_on_screen(String screen) throws Exception {

		browserLaunch(screen);
	}

	@Then("User clicks on {string} button in {string} screen")
	public void user_clicks_on_button_in_screen(String button, String screen) throws Exception {

		switch (screen) {
		case "SignIn":
		case "Welcome":
			lp.clickButton(button);
			break;

		case "EbayHome":
			ebh.clickButton(button);
			break;

		default:
			throw new Exception("No option present: " + screen);
		}
	}

	@When("User enters {string} in {string} field in {string} screen")
	public void user_enters_in_field_in_screen(String value, String field, String screen) throws Exception {

		switch (screen) {
		case "SignIn":
		case "Welcome":
			lp.enterText(value, field);
			break;

		case "EbayHome":
			ebh.enterText(value, field);
			break;

		default:
			throw new Exception("No option present: " + screen);
		}
	}

	@Then("User verifies {string} is displayed")
	public void user_verifies_is_displayed(String value) throws Exception {

		switch (value) {
		case "UserProfileIcon":
			lp.verify(value);
			break;

		case "Couldn’t find your Google Account":
			lp.verify(value);
			break;

		case "Wrong password. Try again or click Forgot password to reset it.":
			lp.verify(value);
			break;

		case "Electric Guitar":
		case "Guitar Details with Price":
			ebh.verify(value);
			break;

		default:
			throw new Exception("No option present: " + value);
		}
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}
}
