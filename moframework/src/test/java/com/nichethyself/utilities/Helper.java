package com.nichethyself.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	// capturescrrenshot , alert, frame, windwo synch issue, java script executor
	// etc

	public void captureScreenShot(WebDriver driver) {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(src, new File("./Screenshots/NT : "+getCurrentDateTime()+".png"));
			System.out.println("ScreenShhot captured successfully....");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot >> " + e.getMessage());
		}
	}
	
	public String getCurrentDateTime() {
		
		DateFormat customFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
	}
}
