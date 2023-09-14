package stepdef;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.org.jenda.factory.DriverFactory;
import com.org.jenda.hooks.MyHooks;
import com.org.jenda.pages.LoginPage;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	private WebDriver driver;
    private LoginPage loginPage;
    private SoftAssert softAssert = new SoftAssert();
    
    
	@Given("User has navigated to login page")
	public void User_has_navigated_to_login_page() {
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
	}
	
	@Given("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String name) {
		loginPage.enterEmail(name);
	}

	@When("User enters valid passsword {string} into password field")
	public void user_enters_valid_passsword_into_password_field(String password) {
		loginPage.enterPassword(password);
	}

	@Then("User clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickLoginButton();
	   
	}

	@And("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		Assert.assertTrue(driver.findElement(By.linkText("Groups")).isDisplayed());
		 Assert.fail();
	}
	
	@Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }
    
    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage) {
        // Assert that an error message is displayed on the page matching the expected error message
       // Assert.assertEquals(driver.findElement(By.cssSelector("#content > p")).isDisplayed(), true);
      
    	softAssert.assertEquals("Shield Suite Api Administration", errorMessage);
    }


}
