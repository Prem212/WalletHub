package com.prem.wallethub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.prem.wallethub.base.BasePage;

public class LoginPage extends BasePage{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".ng-animate-enabled.basic-trans.enter.join li:nth-child(2) a")
	public WebElement loginSection;
	@FindBy(css = "input[placeholder='Email Address']")
	public WebElement emailAddress;
	@FindBy(css = "input[placeholder='Password']")
	public WebElement password;
	@FindBy(css = ".btn.blue.touch-element-cl")
	public WebElement loginSubmitBtn;
	
	//Actions
	 
	public void loggingIn() {
		wait.until(ExpectedConditions.visibilityOf(loginSection));
		loginSection.click();
		emailAddress.sendKeys(config.getProperty("emailAddress"));
		password.sendKeys(config.getProperty("password"));
		loginSubmitBtn.click();
	}
	

}
