package selenium2;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import asw.controllers.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Selenium {
	private WebDriver driver = new HtmlUnitDriver();
	private String baseUrl = "http://localhost:8080/";
	

	@Before
	public void setUp() throws Exception {
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * Iniciar sesión con exito como usuario
	 * 
	 * @throws Exception
	 */
	@Test
	public void prueba01() throws Exception {
		driver.get(baseUrl);
		SeleniumUtils.EsperaCargaPagina(driver, "id", "login", 25);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("nombre2@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login")).click();
		SeleniumUtils.textoPresentePagina(driver, "Titulo");
		SeleniumUtils.textoPresentePagina(driver, "Contenido");
	}

	/**
	 * Iniciar sesión sin exito como user
	 * 
	 * @throws Exception
	 */
	@Test
	public void prueba02() throws Exception {
		driver.get(baseUrl + "/");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "login", 25);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("nombre2@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("pass");
		driver.findElement(By.id("login")).click();
		SeleniumUtils.textoPresentePagina(driver, "Error");
		SeleniumUtils.textoPresentePagina(driver,
				"Se ha producido algún error, por favor contacte con un administrador");
	}

	/**
	 * Cerrar sesion desde usuario
	 * 
	 * @throws Exception
	 */
	@Test
	public void prueba03() throws Exception {
		driver.get(baseUrl + "/");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "login", 25);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("nombre2@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login")).click();
		SeleniumUtils.textoPresentePagina(driver, "Titulo");
		driver.findElement(By.linkText("Cerrar Sesion")).click();
		driver.get(baseUrl + "/cerrarSesion");

	}

	/**
	 * Sumar un voto a "SI" a una sugerencia
	 * 
	 * @throws Exception
	 */
	@Test
	public void prueba04() throws Exception {
		driver.get(baseUrl + "/");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "login", 25);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("nombre2@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login")).click();
		SeleniumUtils.textoPresentePagina(driver, "Titulo");
		driver.findElement(By.id("Si")).click();
		SeleniumUtils.textoPresentePagina(driver, "1");
	}	

	/**
	 * Crear una sugerencia
	 */
	@Test
	public void prueba05() {
		driver.get(baseUrl + "/");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "login", 25);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("nombre2@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login")).click();
		SeleniumUtils.textoPresentePagina(driver, "Titulo");
		driver.findElement(By.linkText("Añadir Sugerencia")).click();
		driver.findElement(By.id("titulo")).clear();
		driver.findElement(By.id("titulo")).sendKeys("Sugerencia 4");
		driver.findElement(By.id("contenido")).clear();
		driver.findElement(By.id("contenido")).sendKeys("asdadfafw");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		SeleniumUtils.textoPresentePagina(driver, "Sugerencia 4");
	}

	/**
	 * Arrepentirse de crear una sugerencia y volver a la lista de sugerencias
	 */
	@Test
	public void prueba06() {
		driver.get(baseUrl + "/");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "login", 25);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("nombre2@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login")).click();
		SeleniumUtils.textoPresentePagina(driver, "Titulo");
		driver.findElement(By.linkText("Añadir Sugerencia")).click();
		driver.findElement(By.linkText("Sugerencias")).click();
	}

	/**
	 * Comentar sugerencia
	 */
	@Test
	public void prueba07() {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("nombre2@gmail.com");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.linkText("Añadir Sugerencia")).click();
		driver.findElement(By.id("titulo")).clear();
		driver.findElement(By.id("titulo")).sendKeys("Sugerencia 4");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		driver.findElement(By.linkText("Sugerencia 4")).click();
		driver.findElement(By.id("comentario")).clear();
		driver.findElement(By.id("comentario")).sendKeys("Comentario 1");
		driver.findElement(By.id("guardar")).click();
		SeleniumUtils.textoPresentePagina(driver, "Comentario 1");

	}

	/**
	 * Votar "Si" comentario
	 */
	@Test
	public void prueba08() {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("nombre2@gmail.com");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.linkText("Añadir Sugerencia")).click();
		driver.findElement(By.id("titulo")).clear();
		driver.findElement(By.id("titulo")).sendKeys("Sugerencia 4");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		driver.findElement(By.linkText("Sugerencia 4")).click();
		driver.findElement(By.id("comentario")).clear();
		driver.findElement(By.id("comentario")).sendKeys("Comentario 1");
		driver.findElement(By.id("guardar")).click();
		SeleniumUtils.textoPresentePagina(driver, "Comentario 1");
		driver.findElement(By.id("Si")).click();
		SeleniumUtils.textoPresentePagina(driver, "1");

	}

	/**
	 * Comentar sugerencia
	 */
	@Test
	public void prueba09() {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("nombre2@gmail.com");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.linkText("Añadir Sugerencia")).click();
		driver.findElement(By.id("titulo")).clear();
		driver.findElement(By.id("titulo")).sendKeys("Sugerencia 4");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		driver.findElement(By.linkText("Sugerencia 4")).click();
		driver.findElement(By.id("comentario")).clear();
		driver.findElement(By.id("comentario")).sendKeys("Comentario 1");
		driver.findElement(By.id("guardar")).click();
		SeleniumUtils.textoPresentePagina(driver, "Comentario 1");
		driver.findElement(By.id("No")).click();
		SeleniumUtils.textoPresentePagina(driver, "1");

	}

	/**
	 * Iniciar sesión con exito como administrador
	 * 
	 * @throws Exception
	 */
	@Test
	public void prueba10() throws Exception {
		driver.get(baseUrl + "/");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "login", 25);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login")).click();
		SeleniumUtils.textoPresentePagina(driver, "Editar");
		SeleniumUtils.textoPresentePagina(driver, "Borrar");

	}

	/**
	 * Iniciar sesión sin exito como administrador
	 * 
	 * @throws Exception
	 */
	@Test
	public void prueba11() throws Exception {
		driver.get(baseUrl + "/");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "login", 25);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("pass");
		driver.findElement(By.id("login")).click();
		SeleniumUtils.textoPresentePagina(driver, "Error");
		SeleniumUtils.textoPresentePagina(driver,
				"Se ha producido algún error, por favor contacte con un administrador");

	}

	/**
	 * Cerrar sesion desde administrador
	 *
	 * @throws Exception
	 */
	@Test
	public void prueba12() throws Exception {
		driver.get(baseUrl + "/");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "login", 25);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login")).click();
		SeleniumUtils.textoPresentePagina(driver, "Titulo");
		driver.findElement(By.linkText("Cerrar Sesion")).click();
		driver.get(baseUrl + "/cerrarSesion");

	}
	

	/**
	 * Borrar sugerencia
	 *
	 * @throws Exception
	 */
	@Test
	public void prueba13() throws Exception {
		driver.get(baseUrl + "/");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "login", 25);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login")).click();
		SeleniumUtils.textoPresentePagina(driver, "Sugerencia2");
		driver.findElement(By.id("botonBorrar")).click();
//		SeleniumUtils.textoNoPresentePagina(driver, "Sugerencia2");

	}
	
	/**
	 * Editar sugerencia
	 *
	 * @throws Exception
	 */
	@Test
	public void prueba14() throws Exception {
		driver.get(baseUrl + "/");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "login", 25);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("botonEditar")).click();
		driver.findElement(By.id("titulo")).clear();
		driver.findElement(By.id("titulo")).sendKeys("Sugerencia 4");

	}
	

}
