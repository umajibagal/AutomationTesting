package assignments;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RowSelectionTests {

	WebDriver driver;

	// @Test
	public void rowSelectionTest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> employeeAllRows = new Table(
				driver.findElement(By.xpath("//table[@class='iceDatTbl'][contains(@id,'employeeList')]")))
						.getAllDataRows();
		Actions actions = new Actions(driver);
		actions.click(employeeAllRows.get(2)).keyDown(Keys.CONTROL).click(employeeAllRows.get(3))
				.click(employeeAllRows.get(5)).keyUp(Keys.CONTROL);
		actions.build().perform();

		Thread.sleep(2000);

		int s = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.xpath("//table[@class='iceDatTbl'][contains(@id,'selectedRows')]//tbody//tr"))).size();
		assertEquals(s, 3);

	}

	@Test
	public void rowSelectionShiftTest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> employeeAllRows = new Table(
				driver.findElement(By.xpath("//table[@class='iceDatTbl'][contains(@id,'employeeList')]")))
						.getAllDataRows();
		Actions actions = new Actions(driver);
		actions.click(employeeAllRows.get(0)).keyDown(Keys.SHIFT).click(employeeAllRows.get(1))
				.click(employeeAllRows.get(2)).click(employeeAllRows.get(3)).keyUp(Keys.SHIFT).build().perform();;
		
		Thread.sleep(2000);

		int s = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.xpath("//table[@class='iceDatTbl'][contains(@id,'selectedRows')]//tbody//tr"))).size();
		assertEquals(s, 4);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver32.exe");
		driver = new ChromeDriver();
		driver.get("http://component-showcase.icesoft.org/component-showcase/showcase.iface");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.linkText("Table")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Row Selection"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Multiple']"))).click();
	}

	@AfterMethod
	public void afterMethod() {
	}

}
