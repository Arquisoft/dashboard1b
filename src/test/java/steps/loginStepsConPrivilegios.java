package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dada;
import cucumber.api.java.es.Entonces;
import pruebas.SeleniumUtils;

public class loginStepsConPrivilegios {

	 private WebDriver driver;
	  private String baseUrl;
@Dada("^una lista de usuarios:$") 
	  
 public void setUp() throws Exception {
   driver = SeleniumUtils.getDriver("test1"); 
   baseUrl = "http://localhost:8090/";
   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
 }
 //me meto con el usuario 'x'
 @Cuando("^me logueo con el correo con privilegios \"(.+)\" y la contraseña \"(.+)\"$")
	 public void testValduvieco() throws Exception {
		    driver.get(baseUrl + "/");
		    driver.findElement(By.name("email")).clear();
		    driver.findElement(By.name("email")).sendKeys("valduvieco@gmail.com");
		    driver.findElement(By.name("password")).clear();
		    driver.findElement(By.name("password")).sendKeys("123456");
		    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		    driver.findElement(By.id("logearse")).click();
		    
		    String texto = "Popularidad de las sugerencias";
		    SeleniumUtils.textoPresentePagina(driver, texto);	   
}
 
 @Entonces("^recibo el siguiente mensaje:$")
 public void stringConPriv() throws Exception{
 System.out.println("Popularidad de las sugerencias");
 }
 
	
}
