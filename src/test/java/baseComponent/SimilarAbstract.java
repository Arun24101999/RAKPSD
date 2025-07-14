package baseComponent;

import static org.testng.Assert.expectThrows;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimilarAbstract {

	public static ChromeDriver driver;

	public void click(WebElement ele) {
		ele.click();

	}

	public void moveToElement(WebElement ele) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().build().perform();

	}

	public void waitForElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(ele));
	}

	public void selectDropdown(WebElement ele, String value) {
		Select D1 = new Select(ele);
		D1.selectByVisibleText(value);
	}
	
	public void Webdriverwait(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele)).click();
	}
	
	public String getText(WebElement ele) {
		String text=ele.getText();
		return text;
	}
	
	
	
	
	
}
