package org.stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.objectrepository.ForgotPasswordPojo;
import org.objectrepository.LoginPojo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.utilities.BaseClass;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import io.cucumber.datatable.DataTable;

public class LoginSteps extends BaseClass {

	public ForgotPasswordPojo f;
	public LoginPojo l;

	@Given("User is in facebook login page")
	public void user_is_in_facebook_login_page() {

		loadUrl("https://www.facebook.com/");

	}

	@When("User click forgot password link")
	public void user_click_forgot_password_link() {

		f = new ForgotPasswordPojo();
		btnClick(f.getLinkForgotPassword());

	}

	@When("User searches the account using invalid mobilenumber {string}")
	public void user_searches_the_account_using_invalid_mobilenumber(String mobile) throws InterruptedException {

		fill(f.getTxtMobileNumber(), mobile);
		btnClick(f.getBtnSearch());

		Thread.sleep(3000);

	}

	@Then("User is displayed with error message")
	public void user_is_displayed_with_error_message() {

		Assert.assertTrue(f.getTxtErrorMsg().isDisplayed());
	}

	@When("User enter invalid {string} and {string}")
	public void user_enter_invalid_and(String email, String pass) {

		l = new LoginPojo();
		fill(l.getTxtEmail(), email);
		fill(l.getTxtPass(), pass);
	}

	@When("User click login button without entering any credentials")
	public void user_click_login_button_without_entering_any_credentials() throws InterruptedException {

		LoginPojo l2 = new LoginPojo();
		btnClick(l2.getBtnLogin());
		Thread.sleep(5000);

	}

	@When("User enter invalid username and password")
	public void user_enter_invalid_username_and_password(DataTable d) throws IOException {

	List<Map<String, String>> list = d.asMaps();
		Map<String, String> map = list.get(0);
		String email = map.get("username");
		String pass = map.get("password");

		l = new LoginPojo();	
		fill(l.getTxtEmail(), email);
		fill(l.getTxtPass(), pass);

	}

	@When("User click login button")
	public void user_click_login_button() throws InterruptedException {
		btnClick(l.getBtnLogin());
		Thread.sleep(5000);

	}

	@Then("User should be in invalid credentials page")
	public void user_should_be_in_invalid_credentials_page() {

		if (driver.getCurrentUrl().contains("privacy")) {
			System.out.println("User is in invalid credentials page");
		} else if (driver.findElement(By.id("login")).isDisplayed()) {

		}
	}

}
