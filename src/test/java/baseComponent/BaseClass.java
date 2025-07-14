package baseComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import driverFactory.BrowserInitialization;

public class BaseClass {
	
	public static WebDriver driver;
	
	
	
	
	public static WebDriver urlLaunch() throws IOException  {
		BrowserInitialization init=new BrowserInitialization();
		driver= init.initializeDriver();
		driver.get("https://test-pms-dev.medyaan.com/home");
        return driver;
	}
	
	/*
	 * public static void urlQuit() throws IOException {
	 * 
	 * driver.quit();
	 * 
	 * }
	 */
}
