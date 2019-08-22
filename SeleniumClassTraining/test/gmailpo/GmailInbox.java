package gmailpo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.expectThrows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailInbox extends LoadableComponent<GmailInbox> {
	private WebDriver driver;
	private WebDriverWait wait;
	public GmailInbox(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		//empty
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(wait.until(ExpectedConditions.titleContains("bagalumaji")));			
	}
	
	public GmailInbox compose() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Compose']"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("to"))).sendKeys("bagalumaji@gmail.com");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("subjectbox"))).sendKeys("demo");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label='Message Body']"))).sendKeys("hello gn");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Send']"))).click();
		return this;
	}
	
	public GmailLoginPage signOut() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='gb_Ba gbii']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sign out']"))).click();
		GmailLoginPage  gm = new GmailLoginPage(driver);
		return gm;
	}
	

}
