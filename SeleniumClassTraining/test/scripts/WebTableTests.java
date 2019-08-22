package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class WebTableTests {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	//@Before
	public void setUp() {
		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.gecko.driver", "test/resources/geckodriver64bit.exe");
		driver = new FirefoxDriver();
		driver.get("http://cookbook.seleniumacademy.com/Locators.html");
	}

	//@Test
	public void testWebTableTests() {
		try {
			
			//Get the table element as WebTable instance using CSS Selector
			//driver.findElement(By.cssSelector("div.cart-info table"))
			WebTable table = new WebTable(driver.findElement(By.cssSelector("div.cart-info table")));
	
			//Verify that it has three rows
			assertEquals(3,table.getDataRowCount());
			//Verify that it has five columns
			assertEquals(5,table.getColumnCount());
			//Verify that specified value exists in second cell of third row
			assertEquals("iPhone",table.getCellData(3,1));
			
			//Get in cell editor and enter some value 
			WebElement cellEdit = table.getCellEditor(3,3,1);
			cellEdit.clear();
			cellEdit.sendKeys("2");
			
		} catch (Error e) {
			//Capture and append Exceptions/Errors
			verificationErrors.append(e.toString());
		}
	}
	
	//@After
	public void tearDown() {
		
		//Close the browser
	//	driver.quit();
		
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}