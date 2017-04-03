package asw.cucumber.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import asw.util.SeleniumUtils;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class loginStepsSinprivilegios {
  
	 private WebDriver driver;
	  private String baseUrl;
	  private List<Map<String, String>> usuarios;
	  
 @Before
 public void setUp() throws Exception {
	    driver = SeleniumUtils.getDriver("test1"); 
	    baseUrl = "http://localhost:8090/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    Map<String,String> Benji = new HashMap<String, String>();
	    Benji.put("email","nakamura@gmail.com");
	    Benji.put("password","123456");
	    usuarios.add(Benji);
	    
	  }
	@Given("^una lista de usuarios:$")
	public void una_lista_de_usuarios(DataTable arg1) throws Throwable {
		
		 assertEquals(1,usuarios.size());
	   //throw new PendingException();
		
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
		
		 driver.findElement(By.name("email")).clear();
		 driver.findElement(By.name("email")).sendKeys("nakamura@gmail.com");
		 driver.findElement(By.name("password")).clear();
		 driver.findElement(By.name("password")).sendKeys("123456");
		 driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		 driver.findElement(By.id("logearse")).click();
		 //se supone que estoy logeado.
	   
	}

	@Then("^recibo el siguiente mensaje:$")
	public void recibo_el_siguiente_mensaje() throws Throwable {
		String texto = "USUARIO SIN PRIVILEGIOS";
	    SeleniumUtils.textoPresentePagina(driver, texto);
      assertEquals(driver.getCurrentUrl(),"http://localhost:8090/");
	}

  
}