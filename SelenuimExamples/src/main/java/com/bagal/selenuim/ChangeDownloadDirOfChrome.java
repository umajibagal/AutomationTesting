package com.bagal.selenuim;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChangeDownloadDirOfChrome {

	public static void main(String[] args) throws IOException {

		// Setting chrome driver path
		System.setProperty("webdriver.chrome.driver",
				"C:\\eclipse-workspace\\SelenuimExamples\\src\\main\\java\\com\\bagal\\resources\\chromedriver32.exe");

		// Setting new download directory path
		Map<String, Object> prefs = new HashMap<String, Object>();

		// Use File.separator as it will work on any OS
		prefs.put("download.default_directory",
				System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");

		// Adding cpabilities to ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);

		// Printing set download directory
		System.out.println(options.getExperimentalOption("prefs"));

		// Launching browser with desired capabilities
		ChromeDriver driver = new ChromeDriver(options);

		// URL loading
		driver.get("https://www.seleniumhq.org/download/");

		// Click on download selenium server jar file
		driver.findElement(By.xpath("//p[text()='Download version ']/a")).click();

	}
}

/*
 * String downloadFilepath = "/path/to/download"; HashMap<String, Object>
 * chromePrefs = new HashMap<String, Object>();
 * chromePrefs.put("profile.default_content_settings.popups", 0);
 * chromePrefs.put("download.default_directory", downloadFilepath);
 * ChromeOptions options = new ChromeOptions();
 * options.setExperimentalOption("prefs", chromePrefs); DesiredCapabilities cap
 * = DesiredCapabilities.chrome();
 * cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
 * cap.setCapability(ChromeOptions.CAPABILITY, options); WebDriver driver = new
 * ChromeDriver(cap);
 */