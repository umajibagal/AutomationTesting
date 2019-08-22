package com.uiframework.companyName.projectName.helper.wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiframework.companyName.projectName.helper.logger.LoggerHelper;

public class WaitHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setImplicitlyWait(long timeout,TimeUnit unit) {
		log.info("implicitly wait has benn set to : "+timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}
	
	private WebDriverWait getWait(long timeOutInSeconds,long pollingEveryInMiliSec) {
		WebDriverWait wait =new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
}
