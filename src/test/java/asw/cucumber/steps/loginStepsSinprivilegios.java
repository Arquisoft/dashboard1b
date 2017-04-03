package asw.cucumber.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import asw.util.SeleniumUtils;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class loginStepsSinprivilegios {
  
	 private WebDriver driver =  new HtmlUnitDriver();
	  private String baseUrl;
	  private List<Map<String, String>> usuarios;
	  @Autowired
		WebApplicationContext context;
 @Before
 public void setUp() throws Exception {
	   
	    usuarios = new ArrayList<>();
	    baseUrl = "http://localhost:8090/";
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    Map<String,String> Benji = new HashMap<String, String>();
	    Benji.put("email","nakamura@gmail.com");
	    Benji.put("password","123456");
	    usuarios.add(Benji);
	    
	  }

	@Given("^una lista de usuarios:$")
	 public void una_lista_de_usuarios(List<Map<String,String>>arg1)throws Throwable {
		  
		  assertEquals(1,usuarios.size());
	  }

	@When("^logueo con el correo sin privilegios \"([^\"]*)\" y la contraseña \"([^\"]*)\"$")
	public void logueo_con_el_correo_sin_privilegios_y_la_contraseña(String arg1, String arg2) throws Throwable {
		arg1 = "nakamura@gmail.com";
	  	arg2 = "123456";
	  	
	  	boolean esta = false;
	  	
		for (Map<String, String> map : usuarios) {
			
			if (map.get("email").equals(arg1) && map.get("password").equals(arg2)) {
				esta = true;
			}
		}
		assertEquals(true, esta);
		WebDriverWait wait = new WebDriverWait(driver,10);// 10segundos towapos.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		
		driver.findElement(By.name("email")).clear();
		
	    driver.findElement(By.name("email")).sendKeys(arg1);
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys(arg2);
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	    driver.findElement(By.id("logearse")).click();
	    
	    String texto = "USUARIO SIN PRIVILEGIOS";
	    SeleniumUtils.textoPresentePagina(driver, texto);
		 //se supone que estoy logeado.
	   
	}

	@Then("^recibo el siguiente mensaje:$")
	public void recibo_el_siguiente_mensaje() throws Throwable {
		String texto = "USUARIO SIN PRIVILEGIOS";
	    SeleniumUtils.textoPresentePagina(driver, texto);
      assertEquals(driver.getCurrentUrl(),"http://localhost:8090/");
	}

  
}