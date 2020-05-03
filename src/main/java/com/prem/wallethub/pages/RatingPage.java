package com.prem.wallethub.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prem.wallethub.base.BasePage;
import com.prem.wallethub.utilities.Global_Vars;

public class RatingPage extends BasePage {

	public RatingPage() {
		PageFactory.initElements(driver, this);
	}

	// WebElements
	@FindBy(css = ".wrev-drp .dropdown.second i.dropdown-arrow.bf-icon-down-open")
	public WebElement insuranceDropDownBtn;

	@FindAll({ @FindBy(css = ".dropdown.second.opened .dropdown-list.ng-enter-element li") })
	public List<WebElement> insuranceDrpDwnValues;
	@FindBy(css = "[placeholder='Write your review...']")
	public WebElement reviewInputField;
	@FindBy(css = ".sbn-action.semi-bold-font.btn.fixed-w-c.tall")
	public WebElement ratingSubmitBtn;

	// Actions
	
	public void submitRatingPageWithMandatoryFields() {
		Actions actions = new Actions(driver);
		actions.moveToElement(insuranceDropDownBtn).click().build().perform();
		for(WebElement value:insuranceDrpDwnValues) {
			if(value.getText().equals(Global_Vars.insuranceName)) {
				value.click();
			}
		}
		reviewInputField.sendKeys(Global_Vars.reviewMessage);
		ratingSubmitBtn.click();		
	}

}
