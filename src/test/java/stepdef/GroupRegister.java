package stepdef;


import java.util.Map;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.org.jenda.factory.DriverFactory;
import com.org.jenda.hooks.MyHooks;
import com.org.jenda.pages.GroupRegisterPage;
import com.org.jenda.pages.LoginPage;
import com.org.jenda.utils.CommonUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class GroupRegister {

	WebDriver driver;
	private GroupRegisterPage registerPage;
	Properties prop;
	
	
	
	
	@Given("User navigates to Add Group page")
	public void User_navigates_to_Add_Group_page() {
		
		driver = DriverFactory.getDriver();
		registerPage = new GroupRegisterPage(driver);
		LoginPage loginPage = new LoginPage(driver);
//		System.out.println(prop.getProperty("username")+" :: "+ prop.getProperty("password"));
		loginPage.login("sridhar.murari@gmware.com", "Kanaga@3479");
		registerPage.clickGroup();
	    
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		registerPage.enterGroupName(dataMap.get("groupName"));
	}
	

	@And("User clicks on Save button")
	public void User_clicks_on_Save_button() {
		registerPage.clickSaveButton();
  
	}

	@Then("Company group should get created successfully")
	public void Company_group_should_get_created_successfully() {
		registerPage.validateSuccessMessage();	    
	}
	
	@When("User enters the {string} into below fields")
	public void User_enters_the_into_below_fields(String groupname) {
		
		registerPage.enterGroupName(groupname);
	}

	

}
