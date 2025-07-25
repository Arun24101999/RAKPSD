package baseComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import driverFactory.BrowserInitialization;

public class BaseClass {
	
	public static WebDriver driver;
	
	
	
	@BeforeClass
	public static void urlLaunch() throws IOException  {
		BrowserInitialization init=new BrowserInitialization();
		driver= init.initializeDriver();
		
	}
	
	/*
	 * public static void urlQuit() throws IOException {
	 * 
	 * driver.quit();
	 * 
	 * }
	 */
}
