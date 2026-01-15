package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class verificationdetails {
	
	WebDriver driver;
	
	public verificationdetails(WebDriver driver) {
		this.driver=driver;
	}
	
	By message=By.xpath("//div[contains(text(), 'Thanks for submitting the form')]");
	
	
	
	public String messagevalidation() {
		return driver.findElement(message).getText();
	}
	
	

}
