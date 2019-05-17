package Teste;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class TestareEmag {
	
	WebDriver driver;
	
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.navigate().to("https://www.emag.ro/homepage?ref=emag_CMP-10379_stock-busters-mai-2019");
	  ImplicitWait(driver);
	  
  }
	
  @Test(priority=1)
  public void LoginTest()
  {
	  String username = "cimpeanuionut14@stud.ase.ro";
	  String password = "29GTMaF1bd";
	  
	  driver.findElement(By.className("btn-emag")).click();
	  driver.findElement(By.name("username")).sendKeys(username);
	  driver.findElement(By.className("gui-btn")).click();
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.className("gui-btn")).click();
	  
	  driver.findElement(By.linkText("Promotiile saptamanii"));
	  
	  System.out.println("Login test execute succes");  	 
	 	  
  }
  
  @Test(priority=2)
  public void CartTest() throws InterruptedException
  {
	  driver.findElement(By.linkText("Promotiile saptamanii"));
	  
	  driver.navigate().to("https://www.emag.ro/cart/products?ref=cart");
	  driver.findElement(By.className("title"));
	  
	  System.out.println("Cart is empty, Precondition valid");
	  Thread.sleep(3000);
	  
	  for(int i=0; i<5; i++) {
	  driver.navigate().to("https://www.emag.ro/nike-pantofi-sport-pentru-alergare-flex-experience-negru-alb-9-908985-001-9/pd/DCF1ZXBBM/?X-Search-Id=0892daaacc7d83565bbc&X-Product-Id=4194976&X-Search-Page=1&X-Search-Position=0&X-Section=label&X-MB=0&X-Search-Action=view#reviews-section");
	  driver.findElement(By.className("btn-emag")).click();
	  Thread.sleep(3000);
	  driver.navigate().to("https://www.emag.ro/cart/products?ref=cart");
	  }		  
	  
	  System.out.println("Cart test execute succes");
  }  
  
  public static void ImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
  
  
  
  
  

}
