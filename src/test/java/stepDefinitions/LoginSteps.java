package stepDefinitions;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

/**
 * Unit test for simple App.
 */
public class LoginSteps 
{
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	private String message;
	private String[] messageAndWarning;
	private WebDriver driver;
	
	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver=DriverFactory.getDriver();
		
		
		driver.get("https://secure-sandbox.modulrfinance.com/");
		//Thread.sleep(10000);
	}

	@When("user enters the {string} and {string}")
	public void i_enter_the_and(String userName, String password) {
	    // Write code here that turns the phrase above into concrete actions
		
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		
	}
	
	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}

	@Then("The {string} should be displayed")
	public void the_should_be_displayed(String msg) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		
		message=loginPage.getMessage();
		System.out.println("Message is: "+message);
		Assert.assertTrue(msg.equals(message));
	}

	@Then("Signin button should be disabled")
	public void signin_button_should_be_disabled() {
		Assert.assertFalse(loginPage.checkIfSigninButtonIsEnabled());
	}

	@Then("user should be on the accounts overview page")
	public void user_should_be_on_the_accounts_overview_page() {
		Assert.assertTrue(loginPage.CheckIfUserOnAcntPage());
	}

	@When("user clicks on forgot password link")
	public void user_clicks_on_forgot_password_link() {
		loginPage.clickOnForgotPassLink();
	}

	@Then("user should be on the reset password page")
	public void user_should_be_on_the_reset_password_page() {
		
		Assert.assertTrue(loginPage.CheckIfUserOnResetPwdPage());
	}
	
	@Then("The {string} and {string} should be displayed")
	public void the_and_should_be_displayed(String msg, String warning) {
		messageAndWarning=loginPage.getMessageAndWarning();
		//System.out.println(messageAndWarning[0]+messageAndWarning[1]);
		Assert.assertTrue(msg.equals(messageAndWarning[0]));
		Assert.assertTrue(warning.equals(messageAndWarning[1]));
	}


}
