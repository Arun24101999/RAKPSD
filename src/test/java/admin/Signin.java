package admin;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import baseComponent.BaseClass;

public class Signin extends BaseClass {

    public static WebDriver driver;
    
   
   
    
	@Test
	public static void loginTest() throws InterruptedException, IOException {
		// Move the cursor to the Element so we use the actions class
		driver=BaseClass.driver;
		driver.get("https://test-pms-dev.medyaan.com/home");
		WebElement ele = driver.findElement(By.xpath("//button[@class='btn secondary-btn cancel-btn-size btn-secondary']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().build().perform();
		Thread.sleep(1000);

		// Enter the Mobile number
		WebElement userName = driver.findElement(By.xpath("//input[@name='phone']"));
		userName.sendKeys("7094755145");

		// Enter the Password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");

		// Click the login button
		driver.findElement(By.xpath("(//span[contains(text(),'Login')])[1]/..")).click();

	}

	

	
}
