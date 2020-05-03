package com.prem.wallethub.utilities;

public class Global_Vars {
	
	//BasePage class variables
	public static final int EXPLICIT_TIMEOUT= 5;
	public static final int IMPLICIT_TIMEOUT= 10;
	public static final String basePath =System.getProperty("user.dir");
	public static final String propFile="/src/test/resources/com/prem/wallethub/properties/Config.properties";
	public static final String chromeDriverExePath ="/src/test/resources/com/prem/wallethub/executables/chromedriver.exe";
	public static final String geckoDriverExePath ="/src/test/resources/com/prem/wallethub/executables/geckodriver.exe";
	
	
	
	//Page class variables
	public static final String insuranceName= "Health Insurance";
	public static final String reviewMessage= "Hi this post is for testing purpose. Hi this post is for testing purpose. "
											+ "Hi this post is for testing purpose Hi this post is for testing purpose";
	public static final String postedReviewName= "Your Review";	
	public static final String profileRatingText= "I RECOMMEND";
	public static final int profileRatingStarCount= 4;
	
	
}
