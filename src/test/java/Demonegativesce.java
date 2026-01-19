import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.xpath;
import utils.Testcontextsetup;

public class Demonegativesce {

	WebDriver driver;
	Testcontextsetup Testcontext;
	xpath detailpage;

	@BeforeTest
	public void launchBrowser() throws IOException {

		Testcontext = new Testcontextsetup();
		driver = Testcontext.baseclass.WebDriverManager();
		detailpage = Testcontext.pomanager.getxpath();

	}

	@Test(priority = 1)
	public void negativeSceanrio() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

	
		detailpage.submitbutton();

		// validation of error --first name
		WebElement firstName = driver.findElement(By.id("firstName"));
		String required = firstName.getAttribute("required");
		Assert.assertNotNull(required, "First Name is not mandatory");
		
		// validation of error --last name
		WebElement lastName = driver.findElement(By.id("lastName"));
		String lastnamerequired = lastName.getAttribute("required");
		Assert.assertNotNull(lastnamerequired, "Last Name is not mandatory");
		
		// validation of error --mobile number 
		WebElement mobilenumber=driver.findElement(By.id("userNumber"));
		String mobilerequired=mobilenumber.getAttribute("required");
        Assert.assertNotEquals(mobilerequired, "Mobile number is not mandatory");
        
        driver.quit();
	}
	
	

}
