package com.prem.wallethub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.prem.wallethub.base.BasePage;

public class FacebookPage extends BasePage {

	public FacebookPage() {
		PageFactory.initElements(driver, this);
	}
	
	// WebElements
	@FindBy(css = "#email")
	public WebElement fbEmailID;
	@FindBy(css = "#pass")
	public WebElement fbPassword;
	@FindBy(css = "#loginbutton")
	public WebElement fbLoginBtn;
	@FindBy(xpath = "//span[text()='Create post']")
	public WebElement fbCreatePostBtn;
	@FindBy(css = "._5xmp.fbReactComposerAttachmentSelector_WITH_TAG ._2aha")
	public WebElement fbTagnameBtn;
	@FindBy(css = "[role='presentation'] ._5rpb span br")
	public WebElement fbPostTextField;
	@FindBy(css = "._45wg._69yt ._1mf7")
	public WebElement fbPostBtn;
	
	//Actions
	
	public void fbLogin() {
		driver.get("https://www.facebook.com/");
		fbEmailID.sendKeys("######");
		fbPassword.sendKeys("#####");
		fbLoginBtn.click();
	}
	
	public void createPost() {
		fbLogin();
		String text=driver.getTitle();
		fbCreatePostBtn.click();
		//wait.until(ExpectedConditions.visibilityOf(fbTagnameBtn)); // i dont know this wait is not working
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._5xmp.fbReactComposerAttachmentSelector_WITH_TAG ._2aha")));
		fbPostTextField.sendKeys("Hi");
		fbPostBtn.click();
	}
	
}
