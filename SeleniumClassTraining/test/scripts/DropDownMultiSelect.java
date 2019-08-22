package scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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

public class DropDownMultiSelect {
	WebDriver driver;

	// @Test
	public void testCommands() {
		driver.get("https://www.google.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().to("www.yahoo.com");
		driver.navigate().refresh();
		String str = driver.getCurrentUrl();
		System.out.println("Current" + str);
		String ps = driver.getPageSource();
	}

	// @Test
	public void testCheckBox() throws InterruptedException {
		driver.get("http://selenium-examples.nichethyself.com");
		driver.findElement(By.linkText("Customized tours")).click();
		WebElement elechkb = driver.findElement(By.xpath("//label[text()='England']/input"));
		if (!elechkb.isSelected())
			elechkb.click();
		Thread.sleep(3000);

		if (elechkb.isSelected())
			elechkb.click();

	}

	// @Test
	public void testCombo() throws InterruptedException {
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		Select cmbselect = new Select(driver.findElement(By.cssSelector("[name='make']")));
		assertFalse(cmbselect.isMultiple());

		// size same or not
		assertEquals(4, cmbselect.getOptions().size(), "No. Of Options are not as per Requirements Document");

		List<String> actual = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();

		actual.add("BMW");
		actual.add("Mercedes");
		actual.add("Audi");
		actual.add("Honda");

		for (WebElement one : cmbselect.getOptions()) {
			expected.add(one.getText());
		}

		assertEquals(actual, expected, "order is not matching");

		cmbselect.selectByVisibleText("Mercedes");
		Thread.sleep(3000);
		cmbselect.selectByIndex(3);
		Thread.sleep(3000);
		cmbselect.selectByValue("audi");
		Thread.sleep(3000);

		String sel = cmbselect.getFirstSelectedOption().getText();

		assertEquals("Audi", sel);

	}

	@Test
	public void testMultiCombo() throws InterruptedException {
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		Select multiselect = new Select(driver.findElement(By.name("color")));
		
		assertTrue(multiselect.isMultiple());
		
		assertEquals(5, multiselect.getOptions().size()," No of elements in the combo are not same");
		
		List<String> actual = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();
		
		actual.add("Black");
		actual.add("White");
		actual.add("Red");
		actual.add("Brown");
		actual.add("Silver");
		
		for (WebElement one : multiselect.getOptions()) {
			expected.add(one.getText());
		}
		assertEquals(actual, expected);
		
		List<String> actualselected = new ArrayList<String>();
		List<String> expectedselected = new ArrayList<String>();
		
		multiselect.selectByVisibleText("Black");
		Thread.sleep(3000);
		multiselect.selectByIndex(2);
		Thread.sleep(3000);
		multiselect.selectByValue("sl");
		Thread.sleep(3000);
		
		actualselected.add("Black");
		actualselected.add("Red");
		actualselected.add("Silver");
		
		for (WebElement sele : multiselect.getAllSelectedOptions()) {
			expectedselected.add(sele.getText());
		}
		assertEquals(actualselected, expectedselected," Not matching selection..");
		
		//multiselect.deselectAll();
		multiselect.deselectByValue("sl");
		Thread.sleep(3000);
		multiselect.deselectByVisibleText("Black"       );
		Thread.sleep(3000);
		multiselect.deselectByIndex(2);
		Thread.sleep(3000);
		
	}

	// @Test
	public void testRadioButton() throws InterruptedException {
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		driver.findElement(By.cssSelector("input[value='Petrol']")).click();

	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver32.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		// Thread.sleep(2000);
		// driver.quit();
	}

}
