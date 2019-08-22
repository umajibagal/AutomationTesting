package assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTest {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void amazonTest() {
		driver.get("https://www.amazon.in/s?k=samsung&rh=n%3A1389401031&ref=nb_sb_noss");
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys(" mobile");
		//driver.findElement(By.xpath("//input[@value='Go']")).click();
		//WebElement lowPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("low-price")));
		//lowPrice.sendKeys("10000");
		//WebElement highPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("high-price")));
		//highPrice.sendKeys("20000");
		
		WebElement go = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='₹10,000 - ₹20,000']")));
		go.click();
		List<WebElement> allSamsungMobile = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		for (WebElement samsung : allSamsungMobile) {
			System.out.println(samsung.getText());
		}
		System.out.println("***************Price***************");
		List<WebElement> allSamsungMobilePrice = driver.findElements(By.xpath("//span[1][@class='a-price']"));
		for (WebElement samsung : allSamsungMobilePrice) {
			System.out.println(samsung.getText());
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver.exe");
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
