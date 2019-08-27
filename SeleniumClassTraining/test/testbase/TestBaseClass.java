package testbase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBaseClass {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startBrowser(driver, "chrome", "http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}

}
