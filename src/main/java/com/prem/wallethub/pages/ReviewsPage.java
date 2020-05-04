package com.prem.wallethub.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.prem.wallethub.base.BasePage;
import com.prem.wallethub.utilities.Global_Vars;

public class ReviewsPage extends BasePage {

	public ReviewsPage() {
		PageFactory.initElements(driver, this);
	}

	// WebElements
	@FindBy(css = ".avatar-img")
	public WebElement testInsuranceCompanyLogo;
	@FindBy(css = ".review-action.ng-enter-element .rating-box-wrapper svg")
	public WebElement reviewStarsSection;
	@FindAll({ @FindBy(css = ".review-action.ng-enter-element .rating-box-wrapper svg") })
	public List<WebElement> reviewStarsList;

	// WebElements for asserting the review
	@FindBy(css = "#reviews-section .rvtab-content .rvtab-citem.rvtab-item-user .rvtab-ci-name")
	public WebElement profileName;

	// Actions
	public void clickTheReviewStar() {
		wait.until(ExpectedConditions.visibilityOf(testInsuranceCompanyLogo));
		je.executeScript("arguments[0].scrollIntoView(true);", reviewStarsSection);
		System.out.println(reviewStarsList.size());
		for (int i = 0; i < reviewStarsList.size(); i++) {
			Actions action = new Actions(driver);
			action.moveToElement(reviewStarsList.get(i));
			if (i == Global_Vars.profileRatingStarCount-1) {
				reviewStarsList.get(i).click();
				break;
			}
		}
	}
	

	public String getReviewProfileName()
	//public void assertingPostedReview() {
		wait.until(ExpectedConditions.visibilityOf(profileName));
		String actualprofileName= profileName.getText();
		return actualProfileName;
		
		Assert.assertEquals(actualprofileName, Global_Vars.postedReviewName); //Assertions should happen in TestCase, not in page class.
	}

}
