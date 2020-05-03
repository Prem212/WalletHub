package com.prem.wallethub.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.prem.wallethub.base.BasePage;
import com.prem.wallethub.pages.LoginPage;
import com.prem.wallethub.pages.RatingPage;
import com.prem.wallethub.pages.ReviewsPage;
import com.prem.wallethub.pages.UserProfilePage;

public class WriteAReviewTest extends BasePage {

	ReviewsPage reviewsPage;
	UserProfilePage userProfilePage;
	RatingPage ratingPage;
	LoginPage loginPage;

	public WriteAReviewTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		BasePage.initConfiguration();
		reviewsPage = new ReviewsPage();
		ratingPage = new RatingPage();
		loginPage = new LoginPage();
		userProfilePage = new UserProfilePage();

	}

	@Test
	public void clickTheReviewStarsTest() {
		reviewsPage.clickTheReviewStar();
		ratingPage.submitRatingPageWithMandatoryFields();
		loginPage.loggingIn();
		reviewsPage.assertingPostedReview();
		userProfilePage.assertReviewInProfile();
	}

	@AfterMethod
	public void tearDown() {
		if (BasePage.driver != null) {
			BasePage.quit();
		}
	}

}
