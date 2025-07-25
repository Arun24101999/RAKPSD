package admin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.List;

public class Users extends Signin {

	public static WebDriver driver;

	@Test
	public void selectUserModule() throws IOException, InterruptedException {

		driver = Signin.driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action = new Actions(driver);

		UserRoles ob = new UserRoles();
		ob.SelectUserRoles();

		WebElement ele = driver
				.findElement(By.xpath("//div[@class='v-list-item__icon']/following-sibling::div/div[text()='Users']"));
		action.moveToElement(ele).click().build().perform();
	}

	@Test(dependsOnMethods = "selectUserModule")
	public void clickAddUserButton() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action = new Actions(driver);

		WebElement ele = driver.findElement(By.cssSelector(".room-text-end>button~button"));
		action.moveToElement(ele).click().build().perform();
	}

	@Test(dependsOnMethods = "clickAddUserButton")
	public void addUserDetails() throws InterruptedException, AWTException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action = new Actions(driver);

		// ProfilePicUpload
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement clickToUploadProfilePic = driver.findElement(By.cssSelector(".profile-image>div"));
		wait.until(ExpectedConditions.visibilityOf(clickToUploadProfilePic)).click();

		Robot robot = new Robot();
		String uploadProfilePic = "C:\\Users\\ArunkumarRagavan\\Pictures\\Screenshots\\Screenshot (53).png";
		StringSelection filePath = new StringSelection(uploadProfilePic);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Select User Roles
		WebElement selectRole = driver.findElement(By.cssSelector(".multiselect__tags>div"));
		wait.until(ExpectedConditions.elementToBeClickable(selectRole)).click();

		List<WebElement> ele = driver.findElements(By.cssSelector(".multiselect__element>span>span"));

		for (int i = 0; i <= ele.size() - 1; i++) {

			String roles = "External Manager";
			if (roles.equalsIgnoreCase(ele.get(i).getText())) {
				Thread.sleep(1000);
				WebElement ClickUserRole = driver.findElement(By.xpath("//span[text()='" + roles + "']"));
				action.moveToElement(ClickUserRole).click().build().perform();
			}
		}

		// EnterUserDetails

		String FirstName = "Arun", LastName = "Ragavan", MobileNumber = "7094755100", Email = "arun@medyaan.com",
				EmergencyContact = "9952715403", Address = "RJPM", EmiratesID = "19991024", TRNNo = "1999";

		driver.findElement(By.cssSelector(".multiselect__select")).click();
		driver.findElement(By.cssSelector("#firstName")).sendKeys(FirstName);
		driver.findElement(By.cssSelector("#lastName")).sendKeys(LastName);

		WebElement gender = driver.findElement(By.cssSelector("#gender"));
		Select selectGender = new Select(gender);
		selectGender.selectByVisibleText("Male");

		driver.findElement(By.cssSelector("#dateOfBirth")).click();
		driver.findElement(
				By.xpath("//div[@class='el-date-picker__header']/button/following-sibling::span[text()='2025 ']"))
				.click();
		int noOfDecadesBack = 3;
		int year = 1999;
		String month = "Oct";
		int date = 24;
		for (int i = 0; i < noOfDecadesBack; i++) {
			driver.findElement(By.xpath("//button[contains(@class,'icon-d-arrow-left')]")).click();
		}
		driver.findElement(By.xpath("//table[@class='el-year-table']//tr/td/a[text()='" + year + "']")).click();
		driver.findElement(By.xpath("//a[text()='" + month + "']")).click();
		driver.findElement(By.xpath("//span[contains(text(), '" + date + "')]")).click();

		WebElement language = driver.findElement(By.cssSelector("#language"));
		Select selectLanguage = new Select(language);
		selectLanguage.selectByValue("Tamil");

		driver.findElement(By.cssSelector("#mobileNumber")).sendKeys(MobileNumber);
		driver.findElement(By.cssSelector("#email")).sendKeys(Email);

		WebElement marital = driver.findElement(By.cssSelector("#maritalStatus"));
		Select selectMarital = new Select(marital);
		selectMarital.selectByValue("single");

		driver.findElement(By.cssSelector("#emergencyContactNumber")).sendKeys(EmergencyContact);
		driver.findElement(By.cssSelector("#address")).sendKeys(Address);
		driver.findElement(By.cssSelector("#emiratesId")).sendKeys(EmiratesID);
		driver.findElement(By.cssSelector("#trnNo")).sendKeys(TRNNo);

		WebElement emirate = driver.findElement(By.cssSelector("#emirateValue"));
		Select selectEmirate = new Select(emirate);
		selectEmirate.selectByVisibleText("Dubai");

		// Upload Id Proof
		WebElement clickToUploadIdProof = driver
				.findElement(By.xpath("(//div[@class='vue-dropzone dropzone dz-clickable'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(clickToUploadIdProof)).click();

		String uploadIdProof = "C:\\Users\\ArunkumarRagavan\\Pictures\\Screenshots\\Def_RAK PSD_Admin_01.png";
		StringSelection idProof = new StringSelection(uploadIdProof);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(idProof, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		// Upload Other Documents
		WebElement clickToUploadOtherDocs = driver
				.findElement(By.xpath("(//div[@class='vue-dropzone dropzone dz-clickable'])[2]"));
		wait.until(ExpectedConditions.visibilityOf(clickToUploadOtherDocs)).click();

		String uploadOtherDocs = "C:\\Users\\ArunkumarRagavan\\Pictures\\Screenshots\\Def_RAK PSD_Admin_01.png";
		StringSelection otherDocs = new StringSelection(uploadOtherDocs);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(otherDocs, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@class='btn primary-btn submit-btn-size btn-secondary']")).click();
		driver.findElement(By.cssSelector(".el-message-box__btns>button~button")).click();

	}

	@Test(dependsOnMethods = "addUserDetails")
	public void editUserDetails() throws InterruptedException, AWTException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action = new Actions(driver);

		// Search the user
		String mobileNo = "7094755100";
		driver.findElement(By.cssSelector("#usermanagementquickFilter")).sendKeys(mobileNo);
		List<WebElement> getMobileNos = driver.findElements(By.xpath(
				"//div[@class='ag-center-cols-container']/div/div/following-sibling::div[@col-id='mobilenumber']"));
		for (int i = 0; i < getMobileNos.size(); i++) {
			if (mobileNo.equals(getMobileNos.get(i).getText())) {
				driver.findElement(By.xpath(
						"(//div[@class='ag-center-cols-container']/div/div/following-sibling::div[text()='"+mobileNo+"']/following-sibling::div[@col-id='action']//div/div/button)[2]"))
						.click();
			}
		}
		// ProfilePicUpload
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement clickToUploadProfilePic = driver.findElement(By.cssSelector(".profile-image>div"));
		wait.until(ExpectedConditions.visibilityOf(clickToUploadProfilePic)).click();

		Robot robot = new Robot();
		String uploadProfilePic = "C:\\Users\\ArunkumarRagavan\\Pictures\\Screenshots\\Screenshot (53).png";
		StringSelection filePath = new StringSelection(uploadProfilePic);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Select User Roles
		WebElement selectRole = driver.findElement(By.cssSelector(".multiselect__tags>div"));
		wait.until(ExpectedConditions.elementToBeClickable(selectRole)).click();

		List<WebElement> ele = driver.findElements(By.cssSelector(".multiselect__element>span>span"));

		for (int i = 0; i <= ele.size() - 1; i++) {

			String roles = "External Manager";
			if (roles.equalsIgnoreCase(ele.get(i).getText())) {
				Thread.sleep(1000);
				WebElement ClickUserRole = driver.findElement(By.xpath("//span[text()='" + roles + "']"));
				action.moveToElement(ClickUserRole).click().build().perform();
			}
		}

		// EnterUserDetails

		String FirstName = "Arun", LastName = "Ragavan", MobileNumber = "7094755100", Email = "arun@medyaan.com",
				EmergencyContact = "9952715403", Address = "RJPM", EmiratesID = "19991024", TRNNo = "1999";

		driver.findElement(By.cssSelector(".multiselect__select")).click();
		driver.findElement(By.cssSelector("#firstName")).sendKeys(FirstName);
		driver.findElement(By.cssSelector("#lastName")).sendKeys(LastName);

		WebElement gender = driver.findElement(By.cssSelector("#gender"));
		Select selectGender = new Select(gender);
		selectGender.selectByVisibleText("Male");

		driver.findElement(By.cssSelector("#dateOfBirth")).click();
		driver.findElement(
				By.xpath("//div[@class='el-date-picker__header']/button/following-sibling::span[text()='2025 ']"))
				.click();
		int noOfDecadesBack = 3;
		int year = 1999;
		String month = "Oct";
		int date = 24;
		for (int i = 0; i < noOfDecadesBack; i++) {
			driver.findElement(By.xpath("//button[contains(@class,'icon-d-arrow-left')]")).click();
		}
		driver.findElement(By.xpath("//table[@class='el-year-table']//tr/td/a[text()='" + year + "']")).click();
		driver.findElement(By.xpath("//a[text()='" + month + "']")).click();
		driver.findElement(By.xpath("//span[contains(text(), '" + date + "')]")).click();

		WebElement language = driver.findElement(By.cssSelector("#language"));
		Select selectLanguage = new Select(language);
		selectLanguage.selectByValue("Tamil");

		driver.findElement(By.cssSelector("#mobileNumber")).sendKeys(MobileNumber);
		driver.findElement(By.cssSelector("#email")).sendKeys(Email);

		WebElement marital = driver.findElement(By.cssSelector("#maritalStatus"));
		Select selectMarital = new Select(marital);
		selectMarital.selectByValue("single");

		driver.findElement(By.cssSelector("#emergencyContactNumber")).sendKeys(EmergencyContact);
		driver.findElement(By.cssSelector("#address")).sendKeys(Address);
		driver.findElement(By.cssSelector("#emiratesId")).sendKeys(EmiratesID);
		driver.findElement(By.cssSelector("#trnNo")).sendKeys(TRNNo);

		WebElement emirate = driver.findElement(By.cssSelector("#emirateValue"));
		Select selectEmirate = new Select(emirate);
		selectEmirate.selectByVisibleText("Dubai");

		// Upload Id Proof
		WebElement clickToUploadIdProof = driver
				.findElement(By.xpath("(//div[@class='vue-dropzone dropzone dz-clickable'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(clickToUploadIdProof)).click();

		String uploadIdProof = "C:\\Users\\ArunkumarRagavan\\Pictures\\Screenshots\\Def_RAK PSD_Admin_01.png";
		StringSelection idProof = new StringSelection(uploadIdProof);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(idProof, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		// Upload Other Documents
		WebElement clickToUploadOtherDocs = driver
				.findElement(By.xpath("(//div[@class='vue-dropzone dropzone dz-clickable'])[2]"));
		wait.until(ExpectedConditions.visibilityOf(clickToUploadOtherDocs)).click();

		String uploadOtherDocs = "C:\\Users\\ArunkumarRagavan\\Pictures\\Screenshots\\Def_RAK PSD_Admin_01.png";
		StringSelection otherDocs = new StringSelection(uploadOtherDocs);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(otherDocs, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@class='btn primary-btn submit-btn-size btn-secondary']")).click();
		driver.findElement(By.cssSelector(".el-message-box__btns>button~button")).click();

	}

}
