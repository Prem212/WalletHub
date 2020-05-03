package com.prem.wallethub.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.prem.wallethub.base.BasePage;

public class TestUtility extends BasePage{
	
	public static String screenshotName;
	
	// Utility for capturing screenshots when there is a failure of test.
	
	public static void captureScreenshot(String testMethodName)  {
		
		Date d = new Date();
		screenshotName = testMethodName+ d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile= new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\Screenshots\\" + screenshotName);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Utility for comparing two int values
	public static boolean compareIntValues(int actualIntVal, int expectedIntVal) {
		try {
			Assert.assertTrue(actualIntVal == expectedIntVal , "Value is matched");
		}
		catch (Throwable t) {
			Assert.fail("Actual value: "+actualIntVal+" does not match with expected value: "+ expectedIntVal);
			return false;
		}
		return true;
	}

}
