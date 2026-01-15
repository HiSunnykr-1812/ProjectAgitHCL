package PageObject;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class xpath {

	WebDriver driver;

	public xpath(WebDriver driver) {
		this.driver = driver;

	}

	By firstname = By.xpath("//input[@id='firstName']");
	By lastName = By.xpath("//input[@id='lastName']");
	By userEmail = By.xpath("//input[@id='userEmail']");
	By mobilenumber = By.xpath("//input[@id='userNumber']");
	By DOB = By.xpath("//input[@id='dateOfBirthInput']");
	By subject = By.xpath("//div[contains(@class,'subjects-auto-complete__value-container')]");
	By CurrentAddress = By.xpath("//*[@id='currentAddress']");
	By upload = By.xpath("uploadPicture");
	By submit =By.xpath("//button[@id='submit']");
	By closebutton=By.xpath("//button[@id='closeLargeModal']");

	public void enterfirstname(String fname) {
		driver.findElement(firstname).sendKeys(fname);
	}

	public void enterlastname(String lname) {
		driver.findElement(lastName).sendKeys(lname);
	}

	public void enteruserEmail(String email) {
		driver.findElement(userEmail).sendKeys(email);
	}

	public void genderselection(String gender) {
		driver.findElement(By.xpath("//label[normalize-space()='" + gender + "']")).click();
	}

	public void mobile(String number) {
		driver.findElement(mobilenumber).sendKeys(number);

	}

	public void datapicker(String value, String years, String date) {
		driver.findElement(DOB).click();
		WebElement monthpicker = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Select mon = new Select(monthpicker);
		mon.selectByValue(value);
		WebElement yearpicker = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select year = new Select(yearpicker);
		year.selectByValue(years);

		driver.findElement(By.xpath("//div[text()='" + date + "']")).click();

	}

	/*
	 * public void subjects(String sub) {
	 * //driver.findElement(subject).sendKeys(sub);
	 * 
	 * Wait<WebDriver> wait = new
	 * FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(
	 * Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
	 * 
	 * WebElement subjectsContainer = wait.until(driver
	 * ->driver.findElement(subject)); subjectsContainer.sendKeys(sub);
	 * 
	 * }
	 */

	public void hobbiesselection(String hobb) {

		WebElement hobbyselection = driver.findElement(By.xpath("//label[normalize-space()='" + hobb + "']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", hobbyselection);
		hobbyselection.click();
	}

	public void currentaddress(String add) {
		driver.findElement(CurrentAddress).click();
		driver.findElement(CurrentAddress).sendKeys(add);
	}

	public void stateselection(String states,String city) {
		WebElement state = driver.findElement(By.xpath("//*[@id='state']/div"));
		state.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String optionXpath = "//*[text()='" + states + "' and not(contains(@style,'display: none'))]";
		WebElement stateOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stateOption);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", stateOption);
		
		//City Selection
		WebElement cityselection = driver.findElement(By.xpath("//*[@id='city']/div"));
		cityselection.click();
		String cityxpath="//*[text()='" + city + "' and not(contains(@style,'display: none'))]";
		WebElement cityoption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cityxpath)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cityoption);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cityoption);

	}
	
	

	public void uploadfile() {
		driver.findElement(upload).sendKeys("C:\\Users\\Sailaja\\Desktop\\uploadfile.docx");

	}
	
	public void submitbutton() {
		driver.findElement(submit).click();
	}
	public void close() {
		driver.findElement(closebutton).click();
	}

}
