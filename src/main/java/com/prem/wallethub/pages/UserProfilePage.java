package com.prem.wallethub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.prem.wallethub.base.BasePage;
import com.prem.wallethub.utilities.Global_Vars;
import com.prem.wallethub.utilities.TestUtility;

public class UserProfilePage extends BasePage {

	public UserProfilePage() {
		PageFactory.initElements(driver, this);
	}
	
	//WebElements
	@FindBy(css = ".pr-rec-subtitle")
	public WebElement profileRatingRecommendation;
	@FindBy(css = ".inst-rating.rvs-plain.rvs-svg")
	public WebElement reviewRatingGiven;
	
	//Actions
	public void assertReviewInProfile() {
		driver.get("https://wallethub.com/profile/TestRPProfile/");
		String ratingText=profileRatingRecommendation.getText();
		String reviewRating=reviewRatingGiven.getAttribute("ng-reflect-rating");
		Assert.assertEquals(ratingText, Global_Vars.profileRatingText);
		int i=Integer.parseInt(reviewRating);
		TestUtility.compareIntValues(i, Global_Vars.profileRatingStarCount);
		//Assert.assertEquals(i, Global_Vars.profileRatingStarCount);
	}
}
