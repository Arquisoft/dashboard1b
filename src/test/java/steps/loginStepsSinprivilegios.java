package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dada;
import cucumber.api.java.es.Entonces;
import pruebas.SeleniumUtils;


public class loginStepsSinprivilegios {
  

	 private WebDriver driver;
	  private String baseUrl;
  
	  @Dada("^una lista de usuarios:$")	
  public void setUp() throws Exception {
    driver = SeleniumUtils.getDriver("test1"); 
    baseUrl = "http://localhost:8090/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
  }
  //me meto con el usuario 'x'

	  @Cuando("^logueo con el correo sin privilegios \"(.+)\" y la contraseña \"(.+)\"$")	  
  public void testNakamura() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("nakamura@gmail.com");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("123456");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.id("logearse")).click();
    
    String texto = "USUARIO SIN PRIVILEGIOS";
    SeleniumUtils.textoPresentePagina(driver, texto);
    
   
  }


	  @Entonces("^recibo el siguiente mensaje:$")
  public void stringSinPriv() throws Exception{
  System.out.println("USUARIO SIN PRIVILEGIOS");
  }
	  
  
}