package com.prem.wallethub.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.prem.wallethub.base.BasePage;
import com.prem.wallethub.pages.FacebookPage;

public class FacebookPostTest extends BasePage {
	FacebookPage fbPage;
	public FacebookPostTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		BasePage.initConfiguration();
		fbPage= new FacebookPage();
	}
	
	@Test
	public void validateCreationOfFbPost() {
		fbPage.createPost();
	}
	//@AfterMethod
	public void tearDown() {
		if (BasePage.driver != null) {
			BasePage.quit();
		}
	}

}
