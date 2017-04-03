package asw.cucumber.steps;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;
import asw.Application;
import asw.util.SeleniumUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

@ContextConfiguration(classes=Application.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class loginStep{

	 WebDriver driver = null; 
	
	 private String url = "http://localhost:8090/";
  
  @Autowired
  protected WebApplicationContext context;

  protected MockMvc mvc;
  protected MvcResult result;
  
  @Value("${local.server.port}")
  protected int port;

  
  
  @When("^the client calls /$")
  public void the_client_calls() throws Throwable {
    Assert.notNull(context);
    this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
    result = mvc.perform(get("/")).andReturn();
  }

  @Then("^the client receives status code of (\\d+)$")
  public void the_client_receives_status_code_of(int status) throws Throwable {
    assertThat(result.getResponse().getStatus(), is(status));
  }

  @Then("^the client receives the string \"([^\"]*)\"$")
  public void the_client_receives_the_string(String str) throws Throwable {
   assertThat(result.getResponse().getContentAsString(), containsString(str));
}
  
  @Given("^un usuario que va a la aplicacion$")
  public void un_usuario_que_va_a_la_aplicasao() throws Throwable {
	  driver = new HtmlUnitDriver();
	  //driver =new  FirefoxDriver();
	
	  assertNotNull(driver);
	  
      driver.get(url); 
  }
  
  @When("^me logueo con usuario privilegiado$")
  public void me_logueo_con_usuario_privilegiado() throws Throwable 
  {
	  driver.findElement(By.id("email")).sendKeys("valduvieco@gmail.com");
      driver.findElement(By.id("password")).sendKeys("123456");
      driver.findElement(By.id("logearse")).click();
      //logueado.
  }

  @Then("^me muestra el html usuario privilegiado$")
  public void me_muestra_el_html_usuario_privilegiado() throws Throwable {
	  String texto = "Popularidad de las sugerencias";
	    SeleniumUtils.textoPresentePagina(driver, texto);
	  
  }
  
  @When("^me logueo con usuario sin privilegios$")
  public void me_logueo_con_usuario_sin_privilegios() throws Throwable {
	  driver.findElement(By.id("email")).sendKeys("nakamura@gmail.com");
      driver.findElement(By.id("password")).sendKeys("123456");
      driver.findElement(By.id("logearse")).click();
      //logueado
  }
  
  
  @Then("^me muestra el html usuario sin privilegios$")
  public void me_muestra_el_html_usuario_sin_privilegios() throws Throwable {
	  
	  String texto = "USUARIO SIN PRIVILEGIOS";
	    SeleniumUtils.textoPresentePagina(driver, texto);
  }


}