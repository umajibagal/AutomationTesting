package screenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotDemo {
	
	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().timeouts().pageLoadTimeout(42, TimeUnit.SECONDS);
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(scr, new File("/home/sayaji/git/AutomationTesting/SeleniumClassTraining/lib/demo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
