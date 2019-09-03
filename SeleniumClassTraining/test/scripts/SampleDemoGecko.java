package scripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class SampleDemoGecko {
	public static void main(String[] args) {
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		File screenShot = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(screenShot, new File("./demoscreenshot1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
