package Cucumber;

import static junit.framework.TestCase.assertTrue;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import asw.controllers.Application;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.SeleniumUtils;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberSteps {

	
	private String baseUrl = String.format("http://localhost:8080/");
	private SeleniumUtils su = new SeleniumUtils();
	private WebDriver driver = su.getDriver();
	


	@Given("^the user navigates to \"([^\"]*)\"$")
	public void theUserNavigatesTo(String url) throws Throwable {
		driver.get(baseUrl + "/");
		assertTrue(su.isElementPresent(By.id(("email"))));
		assertTrue(su.isElementPresent(By.id(("password"))));
		
		
	}

	@When("^the user introduces username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void theUserIntroducesUsernameAndPassword(String username, String password) throws Throwable {
		assertTrue(su.isElementPresent(By.id(("login"))));
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("nombre2@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login")).click();
		
	}

	@Then("^the user successfully logs in$")
	public void theUserSuccessfullyLogsIn() throws Throwable {
		assertTrue(su.isElementPresent(By.id("addSuggestion")));
		
	}

}
