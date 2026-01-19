import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.verificationdetails;
import PageObject.xpath;
import utils.Testcontextsetup;
import utils.baseclass;

public class Demopra {

	WebDriver driver;
	xpath detailpage;
	verificationdetails submitpageverification;
	String fname = "Ashutosh";
	String lname = "Ranjan";
	String emailid = "Ashutosh@Test.com";
	Testcontextsetup Testcontext;

	@BeforeTest
	public void launchBrowser() throws IOException {

		Testcontext = new Testcontextsetup();
		driver = Testcontext.baseclass.WebDriverManager();
		detailpage = Testcontext.pomanager.getxpath();
		submitpageverification = Testcontext.pomanager.getverify();
	}

	@Test
	public void formdetails() {

		detailpage.enterfirstname(fname);
		detailpage.enterlastname(lname);
		detailpage.enteruserEmail(emailid);
		detailpage.genderselection("Male");
		detailpage.mobile("8172912817");
		// detailpage.uploadfile();
		// detailpage.subjects("JAVA Learning");
		detailpage.datapicker("3", "1998", "27");
		detailpage.hobbiesselection("Reading");
		detailpage.currentaddress("Bangalore Karnataka");
		detailpage.stateselection("Uttar Pradesh", "Agra");
		detailpage.submitbutton();

	}

	@Test(dependsOnMethods = "formdetails")
	public void verification() {
		// String message = submitpageverification.messagevalidation();
		// Assert.assertEquals(message, "Thanks for submitting the form");
		Map<String, String> validation = new HashMap<>();
		validation.put("Student Name", fname + " " + lname);
		validation.put("Student Email", emailid);

		for (Map.Entry<String, String> entry : validation.entrySet()) {
			String label = entry.getKey();
			String expectedValue = entry.getValue();
			String xpath = "//td[normalize-space(text())='" + label + "']/following-sibling::td";
			WebElement valueElement = driver.findElement(By.xpath(xpath));
			String actualValue = valueElement.getText().trim();

			Assert.assertEquals(actualValue, expectedValue, "Mismatch found for: " + label);

		}
		
		System.out.println("Page Title:" + driver.getTitle());

		detailpage.close();
	}

	@Test(dependsOnMethods = "verification")
	public void quitbrowswer() {
		driver.quit();

	}
	
	
}
