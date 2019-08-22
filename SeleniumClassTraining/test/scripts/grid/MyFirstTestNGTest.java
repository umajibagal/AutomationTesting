package scripts.grid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class MyFirstTestNGTest {
  RemoteWebDriver driver;
  @Test (groups = "window")
  public void wikiTest() {
		driver.get("http://www.wikipedia.org");
		WebElement englishLink = driver.findElement(By.id("js-link-box-en"));
		englishLink.click();
		//   Xpath = //li[@value='Pune']
		
		String city = "Pune";
        String	XpathSelector = "//li[@value='" + city + "']";
		
        driver.findElement(By.xpath(XpathSelector));
        
/*		WebElement searchField = driver.findElement(By.id("searchInput"));
		searchField.sendKeys("Selenium");
	*/	
		driver.findElement(By.id("searchInput")).sendKeys("Selenium");
		driver.findElement(By.id("searchButton")).click();
		
		String expectedPageTitle = "Selenium - Wikipedia1";
		String actualPageTitle = driver.getTitle();
		assertEquals(actualPageTitle,expectedPageTitle);
/*		if (expectedPageTitle.equals(actualPageTitle))
			System.out.println("PageTitle Test Case Passed.");
		else 
			System.out.println("PageTitle Test Case Failed.");
*/		
		
		String expectedPageHeading = "Selenium";
		String actualPageHeading = driver.findElement(By.id("firstHeading")).getText();
		if (expectedPageHeading.equals(actualPageHeading))
			System.out.println("Heading Test Case Passed.");
		else 
			System.out.println("Heading Test Case Failed.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  }
  
  @Test (dependsOnMethods = "wikiTest")
  public void googleHomePageTest() {
	  driver.get("http://www.google.com");
	  driver.findElement(By.name("q")).sendKeys("Learning Selenium at Niche Thyself");
  }
  
  @BeforeClass
  public void beforeMethod() {
		
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver64bit.exe");
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");

		//driver = new FirefoxDriver();
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.0.100:4444/wd/hub"),capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	//	driver = new ChromeDriver();
  }

  @AfterClass
  public void afterMethod() {
	  driver.quit();
  }

}
