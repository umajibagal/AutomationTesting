package assignments;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MoveToElement {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void moveToElementTest() throws InterruptedException {
		driver.get("http://annauniv.edu/");
		driver.findElement(By.xpath("//a[text()='Departments']")).click();
		WebElement civilDept = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[text()=' Faculty of Civil Engineering ']")));//driver.findElement(By.xpath("//strong[text()=' Faculty of Civil Engineering ']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(civilDept).perform();
		WebElement oceanM =  driver.findElement(By.xpath("//div[@id='menuItemHilite32']"));
		builder.click(oceanM).perform();
		String actualTile = driver.getTitle();
		System.out.println(actualTile);
		String expectedTitle = "Institute For Ocean Management - Anna University offers M.Tech in Coastal Management. ENVIS Center for Coastal Zone Management and Coastal Shelterbelts";
		assertEquals(actualTile, expectedTitle);
		
		WebElement researchTheme = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Research Themes']")));
		//a[text()='Research Themes']
		builder.moveToElement(researchTheme).perform();
		WebElement costalPollstion = driver.findElement(By.xpath("//a[text()='Coastal Pollution Monitoring and Hazards']"));
		//a[text()='Coastal Pollution Monitoring and Hazards']
		builder.click(costalPollstion).perform();
		
		String nextPageActual = driver.getTitle();
		
		String nextPageExpected = ":: IOM - Institute For Ocean Management - Anna University ::";
		assertEquals(nextPageActual, nextPageExpected);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver32.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 15);
	}

	@AfterMethod
	public void afterMethod() {
	}

}
