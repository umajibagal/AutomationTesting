package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MostImportant {
	private static WebDriver driver;
	static WebDriverWait wait;
	ChromeOptions options;

	@Test
	public void mostImportantTest() throws InterruptedException {

		driver.get("http://triphobo.com");
		driver.findElement(By.xpath("//button[@onclick='remindNotifyLater();']")).click();
		driver.findElement(By.id("plan-my-trip")).click();
		driver.findElement(By.xpath("//input[@class='input-control js_city_search']")).sendKeys("Houston");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Houston, Texas, United States']")))
				.click();

		String startDateXpath = "//input[@placeholder='Start Date']"; // xpath for start date
		dateSelector(startDateXpath, "13", "October", "2019"); // start date selection

		String endDateXpath = "//input[@placeholder='End Date']"; // xpath for end date
		dateSelector(endDateXpath, "23", "October", "2019"); // end date selection

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[@class='button p-color full-width start-planning']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Preferences']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Transportation']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Accommodation']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Bindle']"))).click();

		Actions builder = new Actions(driver);

		WebElement museumDistrict = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@title='Museum district'][text()='Museum district']")));
		builder.moveToElement(museumDistrict).build().perform();

		WebElement addBindle1 = driver.findElement(By.xpath("//span[starts-with(@data-addaid,'52cf')]"));
		builder.click(addBindle1).perform();

		WebElement oldTownSpring = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@title='Downtown Aquarium Houston'][text()='Downtown Aquarium Houston']")));
		builder.moveToElement(oldTownSpring).build().perform();

		WebElement addBindle2 = driver.findElement(By.xpath("//span[contains(@data-addaid,'52bea5')]"));
		builder.click(addBindle2).perform();

		WebElement addBindleWithoutTour = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add to Bindle without Tours']")));
		builder.click(addBindleWithoutTour).perform();

		driver.findElement(By.xpath("//div[@class='icon-close-modal']")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[@id='js_city_next_step_title'][text()='Next']"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Edit This Plan']"))).click();

		//WebElement source = driver.findElement(By.xpath("//div[@title='Houston Astros']"));
	
		builder.moveToElement(driver.findElement(By.xpath("//span[@class='button p-size p-color save-to-plan']")))
				.build().perform();
		WebElement finish = driver.findElement(By.xpath("//span[text()='Finish Planning']"));
		builder.click(finish).perform();

	}

	public static void dateSelector(String xPath, String day, String month, String year) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath))).click();
		WebElement years = driver.findElement(By.xpath(
				"//div[@class='ui-datepicker-group ui-datepicker-group-first']//span[@class='ui-datepicker-year']"));
		WebElement months = driver.findElement(By.xpath(
				"// div[@class='ui-datepicker-group ui-datepicker-group-first']//span[@class='ui-datepicker-month']"));

		while (!(years.getText().equals(year) && months.getText().equalsIgnoreCase(month))) {
			driver.findElement(By.xpath("//a[@data-handler='next']")).click();
			years = driver.findElement(By.xpath(
					"//div[@class='ui-datepicker-group ui-datepicker-group-first']//span[@class='ui-datepicker-year']"));
			months = driver.findElement(By.xpath(
					"// div[@class='ui-datepicker-group ui-datepicker-group-first']//span[@class='ui-datepicker-month']"));
		}

		driver.findElement(
				By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//a[text()='" + day + "']"))
				.click();
	}

	public static void getDateJS(WebDriver driver, WebElement element, String dateValue) throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + dateValue + "');", element);

	}

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver32.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);
	}

	@AfterMethod
	public void afterMethod() {
	}
}
