package com.prem.wallethub.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.prem.wallethub.utilities.Global_Vars;

public class BasePage {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait;
	public static String browser;
	public static JavascriptExecutor je;

	public BasePage() {
		if (driver == null) {
			try {
				fis = new FileInputStream(Global_Vars.basePath
						+ Global_Vars.propFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void initConfiguration(){
		// Initializing browser		
		browser = config.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Global_Vars.basePath
					+ Global_Vars.chromeDriverExePath);
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			driver = new ChromeDriver(options);
		}

		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", Global_Vars.basePath
					+ Global_Vars.geckoDriverExePath);
			driver = new FirefoxDriver();
		}
		
		je = (JavascriptExecutor) driver;

		driver.get(config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Global_Vars.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Global_Vars.EXPLICIT_TIMEOUT);
		

	}

	public static void quit() {
		driver.quit();
	}
}
