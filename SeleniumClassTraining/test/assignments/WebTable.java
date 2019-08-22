package assignments;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTable {
	WebDriver driver;
	WebDriverWait wait;
	Table t;

	 //@Test
	public void displayWebTableTest() {
		driver.get("http://the-internet.herokuapp.com/tables");
		t = new Table(driver.findElement(By.xpath("//table[@id='table2']")));
		List<WebElement> allDataRow = t.getAllDataRows();
		for (WebElement oneRecord : allDataRow) {
			for (WebElement cell : oneRecord.findElements(By.tagName("td"))) {
				System.out.print(cell.getText() + " ");
			}
			System.out.println();
		}
	}

	//@Test
	public void searchWebTableDataTest() {
		driver.get("http://the-internet.herokuapp.com/tables");
		t = new Table(driver.findElement(By.xpath("//table[@id='table2']")));
		String header = "email";
		int index = t.getHeaderIndex(header); // email index
		String searchString = "jdoe";
		int res = t.SearchInColumnWithOutHeader(index, searchString);
		System.out.println(header + " is at location" + res);
	
	}

	@Test
	public void deleteWebTableDataTest1() {
		driver.get("https://www.toolsqa.com/automation-practice-table/");
		String Xpath = "//table[@summary='Sample Table']";
		t = new Table(driver.findElement(By.xpath(Xpath)));
		String header = "Built";
		int index = t.getHeaderIndex(header); // getting email index
		String searchString = "2004";
		System.out.println("****************"+index+"*******************");
		int rIndex = t.SearchInColumnWithHeader(index, searchString);
		
		String action = "details";
		
		WebElement delete = t.deleteTableRow(rIndex,Xpath,action);
		delete.click();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.toolsqa.com/automation-practice-table/#";
		
		assertEquals(actualUrl, expectedUrl);
	}

	//@Test
	public void deleteWebTableDataTest() {
		driver.get("http://the-internet.herokuapp.com/tables");
		String Xpath = "//table[@summary='Sample Table']";
		t = new Table(driver.findElement(By.xpath(Xpath)));
		String header = "email";
		int index = t.getHeaderIndex(header); // getting email index
		String searchString = "jdoe";
		int rIndex = t.SearchInColumnWithOutHeader(index, searchString);
		String action =  "delete";
		WebElement delete = t.deleteTableRow(rIndex,Xpath,action);
		delete.click();

		String actualUrl = "http://the-internet.herokuapp.com/tables#delete";
		String expectedUrl = driver.getCurrentUrl();

		assertEquals(actualUrl, expectedUrl);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver32.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);

	}

	@AfterMethod
	public void afterMethod() {
		// driver.quit();
	}

}
