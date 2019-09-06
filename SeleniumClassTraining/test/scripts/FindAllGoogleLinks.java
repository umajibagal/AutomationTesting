package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindAllGoogleLinks {
	WebDriver driver;
  @BeforeMethod
  public void initializeBrowser() {
	  //System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
  }
  @Test
  public void getGoogleLink() {
	  
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com");
	  List<WebElement> alllinks = driver.findElements(By.tagName("a"));
	  
	  for (WebElement webElement : alllinks) {
		System.out.println(webElement.getText()+"  :  "+webElement.getAttribute("href"));
	}
  }
}
