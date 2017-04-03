package asw.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import asw.Application;
import asw.util.SeleniumUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(value = "server.port=8090")
//@SeleniumTest(driver = FirefoxDriver.class, baseUrl = "http://localhost:8090")

public class test1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = SeleniumUtils.getDriver("test1"); 
    baseUrl = "http://localhost:8090/";
    driver.get(baseUrl);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
  }

  @Test
  public void testNakamura() throws Exception {
    
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("nakamura@gmail.com");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("123456");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.id("logearse")).click();
    
    String texto = "USUARIO SIN PRIVILEGIOS";
    SeleniumUtils.textoPresentePagina(driver, texto);
    
   
  }
  
  @Test
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
  @Test
  public void testNoExiste() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("paco@gmail.com");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("123456");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.id("logearse")).click();
    
    String texto = "Error 404";
    SeleniumUtils.textoPresentePagina(driver, texto);
    
   
    
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
