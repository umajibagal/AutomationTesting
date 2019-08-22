package ddt.pageobject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooMyAccountPO extends LoadableComponent<YahooMyAccountPO> {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//a[@aria-label='Mail']")
	private WebElement mailLink;
	
	public YahooMyAccountPO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,20);
		PageFactory.initElements(driver, this);
		isLoaded();
	}

	public YahooMyAccountPO myMail() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Mail']"))).click();
		return this;
	}
	public void signOut() {
		WebElement menuFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[contains(@name,'cmpLocator')]")));
		driver.switchTo().frame(menuFrame);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ybarAccountMenu"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Sign out']"))).click();
	}
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		// nothing to load
		//driver.navigate().refresh();
	}

	public YahooMyAccountPO compose() {
		driver.findElement(By.xpath("//a[@aria-label='Compose']")).click();
		return this;
	}
	@Override
	protected void isLoaded() throws Error {
		assertEquals(driver.getTitle(), "Yahoo India");
	}

	public void closeBrowser() {
		driver.close();
	}

}
