package assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class MoneyControlTable {
	WebDriver driver;
	WebDriverWait wait;
  @Test
  public void tableTest() throws InterruptedException {
	  driver.get("https://www.moneycontrol.com/stocksmarketsindia/");  
	  Thread.sleep(5000);
	  Table t = new Table(driver.findElement(By.xpath("https://www.moneycontrol.com/stocksmarketsindia/")));
	  List<WebElement> allDataRows = t.getAllDataRows();
	  for (WebElement oneRow : allDataRows) {
		  for (WebElement ele : oneRow.findElements(By.tagName("td"))) {
			System.out.println(ele.getText());
		}
	}
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver32.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);
  }

  @AfterMethod
  public void afterMethod() {
  }

}
