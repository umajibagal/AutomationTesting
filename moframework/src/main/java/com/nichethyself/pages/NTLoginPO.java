package com.nichethyself.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NTLoginPO {
	WebDriver driver;

	@FindBy(id="loginname") WebElement usernameField;
	@FindBy(id="loginpassword") WebElement passwordField;
	@FindBy(id="loginbutton") WebElement submitButton;
	
	
	public NTLoginPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginNT(String username,String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		submitButton.click();
	}
}

