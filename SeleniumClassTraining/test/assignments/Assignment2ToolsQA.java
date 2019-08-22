package assignments;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment2ToolsQA {
	WebDriver driver;

	@Test
  public void toolsqaTest() {
	  driver.get("http://toolsqa.com/automation-practice-form/");
	  driver.findElement(By.name("firstname")).sendKeys("umesh");
	  driver.findElement(By.name("lastname")).sendKeys("Bagal");
	  driver.findElement(By.cssSelector("input[value='Male']")).click();
	  driver.findElement(By.cssSelector("input[value='7']")).click();
	  driver.findElement(By.id("datepicker")).sendKeys("20/07/2019");
	 
	  WebElement manual =  driver.findElement(By.cssSelector("input[value='Manual Tester']"));
	  if(!manual.isSelected())
		  manual.click();
	  WebElement automation = driver.findElement(By.cssSelector("input[value='Automation Tester']"));
	  if(!automation.isSelected())
		  automation.click();
	  
	  WebElement ide = driver.findElement(By.cssSelector("input[value='Selenium IDE']"));
	  if(!ide.isSelected())
		  ide.click();
	  
	  WebElement selweb = driver.findElement(By.cssSelector("input[value='Selenium Webdriver']"));
	  if(!selweb.isSelected())
		  selweb.click();
	  
	  Select ContinentsAll = new Select(driver.findElement(By.id("continents")));
	  ContinentsAll.selectByVisibleText("Antartica");
	  
	  String actualContinents =  ContinentsAll.getFirstSelectedOption().getText();
	  String expectedContinents = "Antartica";
	  
	  assertEquals(actualContinents, expectedContinents,"Actual Continents are not matching");
	  
	  Select selcom = new Select(driver.findElement(By.id("selenium_commands")));
	  
	  selcom.selectByVisibleText("Browser Commands");
	  selcom.selectByVisibleText("WebElement Commands");
	  
	  List<String> actualselcom = new ArrayList<String>();
	  List<String> expectedselcom = new ArrayList<String>();
	  
	  actualselcom.add("Browser Commands");
	  actualselcom.add("WebElement Commands");
	  	  
	  for (WebElement webele : selcom.getAllSelectedOptions()) {
		expectedselcom.add(webele.getText());
	}
	  
	  assertEquals(actualselcom, expectedselcom);
	  
	  System.out.println("First Text  : "+driver.findElement(By.xpath("//span[text()='Text1']")).getText());
	  System.out.println("Second Text : "+driver.findElement(By.xpath("//label[text()=' Text2']")).getText().split("\n")[1]);
	  
	  
  }

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver32.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod() {
	}

}
