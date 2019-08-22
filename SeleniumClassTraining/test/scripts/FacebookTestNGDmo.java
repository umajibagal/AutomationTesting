package scripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FacebookTestNGDmo {
	WebDriver driver;
  @Test
  public void facebookLogin() {
	  driver.get("http://www.facebook.com");
	  driver.findElement(By.id("email")).sendKeys("");
	  driver.findElement(By.id("pass")).sendKeys("");
	  driver.findElement(By.id("u_0_2")).click();
	  
	  String s1 = "Facebook";
	  String s2 = driver.getTitle();
	  
	  assertEquals(s1, s2);	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver32.exe");
	  driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
