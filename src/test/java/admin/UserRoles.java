package admin;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import baseComponent.SimilarAbstract;

public class UserRoles extends Signin {

	public static WebDriver driver;
	
	
	  
   
	@Test
	public void SelectUserRoles() throws IOException, InterruptedException {

		driver=Signin.driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		SimilarAbstract sa = new SimilarAbstract();
        
		WebElement PickUserRole = driver
				.findElement(By.xpath("(//button[@class='btn dropdown-toggle btn-secondary'])[2]/.."));
		sa.click(PickUserRole);
		
		String selectRole="AWC Admin";
	    driver.findElement(By.xpath("//ul[@class='dropdown-menu show']/li/a[text()='"+selectRole+"']")).click();
		
		
	}
	
	

}
