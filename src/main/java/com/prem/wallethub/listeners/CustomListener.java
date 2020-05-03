package com.prem.wallethub.listeners;

import java.io.IOException;

import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.prem.wallethub.base.BasePage;
import com.prem.wallethub.utilities.TestUtility;

public class CustomListener extends BasePage implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed Test is: " + result.getName());
		try {
			TestUtility.captureScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase Skipped is :" + result.getName());

	}

}
